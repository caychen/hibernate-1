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
		
		//foo具有持久性
		Foo foo = session.load(Foo.class, 2);
		
		session.clear();//foo变为游离状态，更改数据不会更新到数据库中
		
		//改变foo对象数据
		foo.setName("Cam");
		foo.setMarry(false);
		
		//触发同步动作
		session.flush();
		
		//事务提交
		ta.commit();//如果有commit，可以省略flush
		session.close();
	}
	
	@Test
	public void test1(){
		//foo是临时状态
		Foo foo = new Foo();
		foo.setName("Amy");
		foo.setSalary(2000.0);
		foo.setHireDate(new Date(System.currentTimeMillis()));
		foo.setMarry(true);
		
		Session session = HibernateUtil.openSession();
		
		Transaction ta = session.beginTransaction();
		
		//foo由临时状态转换为持久状态
		session.save(foo);
		
		//修改持久对象的数据，会更新到数据库中
		foo.setSalary(3000.0);
		
		ta.commit();//同步并提交事务
		
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
