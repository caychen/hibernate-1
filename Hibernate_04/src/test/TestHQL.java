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
		
		//�鿴���������ʺ���Ϣ
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
	
	//��ѯ�����ֶ�
	//select id,name from ACCOUNT
	@Test
	public void test3(){
		String hql = "select id,name from Account";
		
		Session session = HibernateUtil.openSession();
		Query query = session.createQuery(hql);
	
		//�������ݲ�ѯ��Ĭ�ϲ���Object[]��װһ�м�¼
		List<Object[]> objs = query.list();
		for (Object[] obj : objs) {
			//���ֲ�ѯ���ֶ�����Object[]��һ�и�����ͬ
			System.out.println(obj[0] + "," + obj[1]);
		}
		session.close();
	}
	
	@Test
	public void test4(){
		//��ʱ��Ҫ��Account������ӹ��캯��������ƥ��
		String hql = "select new Account(id,name) from Account";
		
		Session session = HibernateUtil.openSession();
		Query query = session.createQuery(hql);
	
		//�������ݲ�ѯ��Ĭ�ϲ���Account��װһ�м�¼
		List<Account> accounts = query.list();
		for (Account account : accounts) {
			//���ֲ�ѯ���ֶ�����Object[]��һ�и�����ͬ
			System.out.println(account.getId() + "," + account.getName());
		}
		session.close();
	}
	
	//���ԣ���HQL���嵽hbm.xml
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
	
	//��ҳ��ѯ
	@Test
	public void test6(){
		String hql = "from Account";
		Session session = HibernateUtil.openSession();
		
		Query query = session.getNamedQuery("findAll");
		//���÷�ҳ����
		query.setFirstResult(0);//����ץȡ��¼�����
		query.setMaxResults(5);//�������ץȡ��
		
		List<Account> accounts = query.list();
		for (Account account : accounts) {
			System.out.println(account.getName());
		}
		session.close();
	}
	
	//���Զ��������ѯ
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
