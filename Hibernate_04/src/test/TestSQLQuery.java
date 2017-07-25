package test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import entity.Account;
import utils.HibernateUtil;

public class TestSQLQuery {
	
	@Test
	public void test1(){
		String sql = "select * from ACCOUNT";
		Session session = HibernateUtil.openSession();
		
		SQLQuery query = session.createSQLQuery(sql);
		
		//添加分页
		query.setFirstResult(0);
		query.setMaxResults(5);
		
		List<Object[]>objs = query.list();
		for (Object[] objects : objs) {
			System.out.println(objects[0] + " " + objects[1] + " " + objects[2]);
		}
		
		session.close();
	}
	
	@Test
	public void test2(){
		String sql = "select * from ACCOUNT";
		Session session = HibernateUtil.openSession();
		
		SQLQuery query = session.createSQLQuery(sql);
		
		//设置映射类型，可以利用该类型映射封装成一条记录，必须为全部数据，部分数据则不行
		query.addEntity(Account.class);
		
		List<Account> accounts = query.list();
		for (Account account : accounts) {
			System.out.println(account.getId() + " " + account.getName());
		}
		
		session.close();
	}
}
