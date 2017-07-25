package test;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Account;
import utils.HibernateUtil;

public class TestException {

	@Test
	public void test() {
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();
		
		//get操作，将account1放入缓存
		Account account1 = session.get(Account.class, 2);
		System.out.println(account1.getName());
		
		Account account2 = new Account();
		account2.setId(2);
		
		/**
		 * update操作会将account2放入缓存
		 * 但是缓存中已经存在id为2的对象，则不允许再次放入
		 * 所以此时会出现下列异常信息：
		 * org.hibernate.NonUniqueObjectException: 
		 * 		A different object with the same identifier value was already associated with the session : [entity.Account#2]
		 */
		session.update(account2);
		ta.commit();
		session.close();
	}

}
