package test;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import utils.HibernateUtil;
import entity.Foo;

public class FooTest {

	@Test
	public void test() {
		Foo foo = new Foo();
		foo.setName("Cay");
		foo.setSalary(5000.0);
		foo.setMarry(true);
		foo.setHireDate(new Date(System.currentTimeMillis()));
		foo.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
		
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();
		session.save(foo);
		ta.commit();
		session.close();
	}

	@Test
	public void test2(){
		Session session = HibernateUtil.openSession();
		Foo foo = session.load(Foo.class, 1);
		System.out.println(foo.getLastLoginTime());
		session.close();
	}
}
