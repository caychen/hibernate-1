package test;

import java.sql.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Foo;
import utils.HibernateUtil;

public class TestPersistent {

	@Test
	public void test() {
		Session session = HibernateUtil.openSession();
		
		Transaction ta = session.beginTransaction();
		
		//foo���г־���
		Foo foo = session.load(Foo.class, 2);
		
		session.clear();//foo��Ϊ����״̬���������ݲ�����µ����ݿ���
		
		//�ı�foo��������
		foo.setName("Cam");
		foo.setMarry(false);
		
		//����ͬ������
		session.flush();
		
		//�����ύ
		ta.commit();//�����commit������ʡ��flush
		session.close();
	}
	
	@Test
	public void test1(){
		//foo����ʱ״̬
		Foo foo = new Foo();
		foo.setName("Amy");
		foo.setSalary(2000.0);
		foo.setHireDate(new Date(System.currentTimeMillis()));
		foo.setMarry(true);
		
		Session session = HibernateUtil.openSession();
		
		Transaction ta = session.beginTransaction();
		
		//foo����ʱ״̬ת��Ϊ�־�״̬
		session.save(foo);
		
		//�޸ĳ־ö�������ݣ�����µ����ݿ���
		foo.setSalary(3000.0);
		
		ta.commit();//ͬ�����ύ����
		
		session.close();
	}
	
	@Test
	public void test2(){
		Session session = HibernateUtil.openSession();
		
		Foo foo = session.load(Foo.class, 2);
		System.out.println(foo);
		
		session.close();
	}

}
