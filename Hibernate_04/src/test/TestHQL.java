package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import entity.Account;
import utils.HibernateUtil;

public class TestHQL {

	@Test
	public void test1(){
		
		//查看所有账务帐号信息
		//select * from ACCOUTN;
		String hql = "from Account";
		Session session = HibernateUtil.openSession();
		Query query = session.createQuery(hql);
		List<Account> accounts = query.list();
		for (Account account : accounts) {
			System.out.println(account.getName());
		}
		session.close();
	}
	
	//select * from ACCOUNT where name like ?
	@Test
	public void test2(){
		String hql = "from Account where name like ?";
		
		//String hql2 = "from Account where name like :name";
		
		Session session = HibernateUtil.openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "zs%");
		
		//for hql2
//		Query query = session.createQuery(hql2);
//		query.setString("name", "zs%");
		
		List<Account> accounts = query.list();
		for (Account account : accounts) {
			System.out.println(account.getName());
		}
		session.close();
	}
	
	//查询部分字段
	//select id,name from ACCOUNT
	@Test
	public void test3(){
		String hql = "select id,name from Account";
		
		Session session = HibernateUtil.openSession();
		Query query = session.createQuery(hql);
	
		//部分数据查询，默认采用Object[]封装一行记录
		List<Object[]> objs = query.list();
		for (Object[] obj : objs) {
			//部分查询的字段数与Object[]的一行个数相同
			System.out.println(obj[0] + "," + obj[1]);
		}
		session.close();
	}
	
	@Test
	public void test4(){
		//此时需要在Account类中添加构造函数，必须匹配
		String hql = "select new Account(id,name) from Account";
		
		Session session = HibernateUtil.openSession();
		Query query = session.createQuery(hql);
	
		//部分数据查询，默认采用Account封装一行记录
		List<Account> accounts = query.list();
		for (Account account : accounts) {
			//部分查询的字段数与Object[]的一行个数相同
			System.out.println(account.getId() + "," + account.getName());
		}
		session.close();
	}
	
	//测试，将HQL定义到hbm.xml
	@Test
	public void test5(){
		String hql = "from Account";
		Session session = HibernateUtil.openSession();
		
		Query query = session.getNamedQuery("findAll");
		List<Account> accounts = query.list();
		for (Account account : accounts) {
			System.out.println(account.getName());
		}
		session.close();
	}
	
	//分页查询
	@Test
	public void test6(){
		String hql = "from Account";
		Session session = HibernateUtil.openSession();
		
		Query query = session.getNamedQuery("findAll");
		//设置分页参数
		query.setFirstResult(0);//设置抓取记录的起点
		query.setMaxResults(5);//设置最大抓取数
		
		List<Account> accounts = query.list();
		for (Account account : accounts) {
			System.out.println(account.getName());
		}
		session.close();
	}
	
	//测试对象关联查询
	//select s.ID,s.SERVICE_NAME,a.ID,a.NAME from SERVICE s join ACCOUNT a on(a.ID=s.ACCOUNT_ID)
	@Test
	public void test7(){
		String hql = "select s.id,s.serviceName,a.id,a.name from Service s join s.account a";
		Session session = HibernateUtil.openSession();
		Query query = session.createQuery(hql);
		List<Object[]> objs = query.list();
		for (Object[] obj : objs) {
			System.out.println(obj[0] + " " + obj[1] + " " + obj[2] + " " + obj[3]);
		}
		session.close();
	}
	
	@Test
	public void test8(){
		String hql = "select s.id,s.serviceName,s.account.id,s.account.name from Service s ";
		Session session = HibernateUtil.openSession();
		Query query = session.createQuery(hql);
		List<Object[]> objs = query.list();
		for (Object[] obj : objs) {
			System.out.println(obj[0] + " " + obj[1] + " " + obj[2] + " " + obj[3]);
		}
		session.close();
	}
}
