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
		
		//load是延迟加载机制，没有sql语句
		Foo foo = session.load(Foo.class, 2);
		
		//第一次触发getter方法时，会全部加载
		System.out.println(foo.getName());
		System.out.println(foo.getSalary());
		System.out.println("====================");
		
		//get是即时加载机制，有sql语句，select * from ...
		Foo foo2 = session.get(Foo.class, 2);
		session.close();
	}

}
