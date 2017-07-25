package test;


import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import entity.Account;
import entity.Service;
import utils.HibernateUtil;

public class TestManyToOne {

	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();
		
		Service service = session.load(Service.class, 3);
	//	System.out.println(service.getAccountId());
		System.out.println(service.getServiceName());
		
		System.out.println(service.getAccount().getId());
		session.close();
	}

	@Test
	public void test2(){
		Session session = HibernateUtil.openSession();
		String hql = "from Service s join fetch s.account where s.id=?";
		
		Query query = session.createQuery(hql);
		query.setInteger(0, 2);
		
		Service service = (Service)query.uniqueResult();
		System.out.println(service.getId());
		System.out.println(service.getServiceName());
		
		Account account = service.getAccount();
		System.out.println(account.getId() + "," + account.getName());
		session.close();
	}
}
