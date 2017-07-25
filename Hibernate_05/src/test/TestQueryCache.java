package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import entity.Account;
import utils.HibernateUtil;

public class TestQueryCache {

	@Test
	public void test1(){
		show();
		System.out.println("==================");
		show();
	}
	
	 void show(){
		String hql = "from Account";
		Session session = HibernateUtil.openSession();
		Query query = session.createQuery(hql);
		
		//���ò�ѯ������ƽ��в�ѯ
		//ȥ������ң�ִ�й���SQL�������������
		//���δִ�й�����ȥDB�������ݣ�������
		query.setCacheable(true);
		
		@SuppressWarnings("unchecked")
		List<Account> accounts = query.list();
		
		for (Account account : accounts) {
			System.out.println(account.getName());
		}
		session.close();
	}
}
