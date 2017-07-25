package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Book;
import entity.Car;
import utils.HibernateUtil;

public class TestExtends {

	@Test
	public void testFindBook() {
		Session session = HibernateUtil.openSession();

		Book book = session.load(Book.class, 4);
		System.out.println(book.getName());
		System.out.println(book.getPrice());
		System.out.println(book.getPulisher());
		System.out.println(book.getAuthor());
		session.close();
	}

	@Test
	public void testAddBook() {
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();

		Book book = new Book();
		// 设置product属性
		book.setName("C++程序设计语言");
		book.setPrice(50.0);
		book.setProduct_pic("CPP.jpg");

		// 设置book属性
		book.setAuthor("本贾尼");
		book.setPulisher("图灵出版社");
		book.setWordNumber("20000");
		book.setTotalPage("1034");

		session.save(book);
		ta.commit();
		session.close();
	}

	@Test
	public void testAddCar() {
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();

		Car car = new Car();
		car.setName("Q7");
		car.setPrice(700000);
		car.setProduct_pic("x6.jpg");

		car.setBrand("奥迪");
		car.setType("轿车");
		car.setColor("红色");
		car.setDisplacement("3.0L");

		session.save(car);
		ta.commit();
		session.close();
	}

	@Test
	public void testFindAllBook() {
		Session session = HibernateUtil.openSession();
		String hql = "from Book";
		Query query = session.createQuery(hql);
		List<Book> bookList = query.list();
		for (Book book : bookList) {
			System.out.println(book.getName());
		}
		session.close();
	}

}
