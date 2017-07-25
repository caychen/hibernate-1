package test;

import org.hibernate.Session;
import org.junit.Test;

import entity.Account;
import utils.HibernateUtil;

public class TestSecondCache {

	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();

		Account account = session.load(Account.class, 2);
		System.out.println(account.getId());

		//从一级缓存中获取
		Account account1 = session.load(Account.class, 2);
		System.out.println(account1.getName());
		session.close();
	}

	void show(){
		Session session = HibernateUtil.openSession();

		Account account = session.load(Account.class, 2);
		System.out.println(account.getId());
		session.close();
	}
	
	@Test
	public void test2() {
		show();
		System.out.println("================");
		show();
	}

}
