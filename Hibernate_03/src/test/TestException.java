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
		
		//get��������account1���뻺��
		Account account1 = session.get(Account.class, 2);
		System.out.println(account1.getName());
		
		Account account2 = new Account();
		account2.setId(2);
		
		/**
		 * update�����Ὣaccount2���뻺��
		 * ���ǻ������Ѿ�����idΪ2�Ķ����������ٴη���
		 * ���Դ�ʱ����������쳣��Ϣ��
		 * org.hibernate.NonUniqueObjectException: 
		 * 		A different object with the same identifier value was already associated with the session : [entity.Account#2]
		 */
		session.update(account2);
		ta.commit();
		session.close();
	}

}
