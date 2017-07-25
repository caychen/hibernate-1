package test;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import entity.Account;
import entity.Service;
import utils.HibernateUtil;

public class TestOneToMany {

	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();

		Account account = session.load(Account.class, 2);
		System.out.println(account.getName());
		System.out.println(account.getCreateDate());

		Set<Service> services = account.getServices();
		for (Service service : services) {
			System.out.println(service.getId() + "," + "," + service.getServiceName());
		}
		session.close();
	}

	@Test
	public void test2(){
		Session session = HibernateUtil.openSession();
		
		String hql = "from Account a join fetch a.services where a.id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, 2);
		Account account = (Account)query.uniqueResult();
		System.out.println(account.getId());
		System.out.println(account.getName());
		Set<Service> services = account.getServices();
		for (Service service : services) {
			System.out.println(service.getId() + "," + service.getServiceName());
		}
		
		session.close();
	}
}
