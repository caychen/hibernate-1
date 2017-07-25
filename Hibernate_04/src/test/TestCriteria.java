package test;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import entity.Account;
import utils.HibernateUtil;

public class TestCriteria {

	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();
		Criteria ct = session.createCriteria(Account.class);
		
		//��ӷ�ҳ
		ct.setFirstResult(0);
		ct.setMaxResults(5);
		
		List<Account> accounts = ct.list();

		for (Account account : accounts) {
			System.out.println(account.getName());
		}
		session.close();
	}

	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();
		Criteria ct = session.createCriteria(Account.class);

		// ׷������
		ct.add(Restrictions.like("name", "z%"));

		List<Account> accounts = ct.list();

		for (Account account : accounts) {
			System.out.println(account.getName());
		}
		session.close();
	}

	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();
		Criteria ct = session.createCriteria(Account.class);

		// ׷����������
		ct.add(Restrictions.and(
				Restrictions.like("name", "z%"),
				Restrictions.gt("createDate",
						new Date(System.currentTimeMillis()))));
		
		//׷������
		ct.addOrder(Order.asc("ID"));
		

		List<Account> accounts = ct.list();

		for (Account account : accounts) {
			System.out.println(account.getName());
		}
		session.close();
	}
}
