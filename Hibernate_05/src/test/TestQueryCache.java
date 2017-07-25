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
		
		//采用查询缓存机制进行查询
		//去缓存查找，执行过此SQL，将结果集返回
		//如果未执行过，则去DB查找数据，并返回
		query.setCacheable(true);
		
		@SuppressWarnings("unchecked")
		List<Account> accounts = query.list();
		
		for (Account account : accounts) {
			System.out.println(account.getName());
		}
		session.close();
	}
}
