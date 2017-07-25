package test;


import org.hibernate.Session;
import org.junit.Test;

import entity.Foo;
import utils.HibernateUtil;

public class TestLazy {
	
	@Test
	public void test2(){
		Session session = HibernateUtil.openSession();
		Foo foo1 = session.load(Foo.class, 2);
		System.out.println(foo1.getClass().getName());
		
		System.out.println("============");
		Foo foo2 = session.get(Foo.class, 3);
		System.out.println(foo2.getClass().getName());
		
		session.close();
	}
	
	@Test
	public void test() {
		Session session = HibernateUtil.openSession();
		
		//load���ӳټ��ػ��ƣ�û��sql���
		Foo foo = session.load(Foo.class, 2);
		
		//��һ�δ���getter����ʱ����ȫ������
		System.out.println(foo.getName());
		System.out.println(foo.getSalary());
		System.out.println("====================");
		
		//get�Ǽ�ʱ���ػ��ƣ���sql��䣬select * from ...
		Foo foo2 = session.get(Foo.class, 2);
		session.close();
	}

}
