package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Account;
import entity.Service;
import utils.HibernateUtil;

//���Լ���
public class TestCascade {

	@Test
	public void testAdd() {
		//һ��Account
		Account account = new Account();
		account.setName("zs");
		account.setCreateDate(new Date(System.currentTimeMillis()));
		
		//����Service
		Service service1 = new Service();
		service1.setAccount(account);
		service1.setServiceName("����10Ԫ");
	
		Service service2 = new Service();
		service2.setAccount(account);
		service2.setServiceName("����20Ԫ");
		
		//��service1��service2��ӵ�account.services��
		account.getServices().add(service1);
		account.getServices().add(service2);
		
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();
		
		//���account.services�е�����ִ�м������
		session.save(account);
		
		ta.commit();
		session.close();
		
	}
	
	@Test
	public void testDelete(){
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();
		
		//����ɾ����ע�ⲻҪ����new��������Ϊnew������account��û��service��ϵ����
		Account account = session.load(Account.class, 8);
		session.delete(account);
		
		ta.commit();
		session.close();
	}

}
