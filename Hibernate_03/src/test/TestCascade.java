package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Account;
import entity.Service;
import utils.HibernateUtil;

//测试级联
public class TestCascade {

	@Test
	public void testAdd() {
		//一个Account
		Account account = new Account();
		account.setName("zs");
		account.setCreateDate(new Date(System.currentTimeMillis()));
		
		//两个Service
		Service service1 = new Service();
		service1.setAccount(account);
		service1.setServiceName("流量10元");
	
		Service service2 = new Service();
		service2.setAccount(account);
		service2.setServiceName("流量20元");
		
		//将service1和service2添加到account.services中
		account.getServices().add(service1);
		account.getServices().add(service2);
		
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();
		
		//会对account.services中的数据执行级联添加
		session.save(account);
		
		ta.commit();
		session.close();
		
	}
	
	@Test
	public void testDelete(){
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();
		
		//级联删除，注意不要采用new方法，因为new出来的account，没有service关系数据
		Account account = session.load(Account.class, 8);
		session.delete(account);
		
		ta.commit();
		session.close();
	}

}
