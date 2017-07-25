package test;

import java.sql.Date;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Admin;
import entity.Role;
import utils.HibernateUtil;

public class TestManyToMany {

	// 删除角色
	@Test
	public void testDelete() {
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();

		Admin admin = session.load(Admin.class, 6);

		// 删除指定角色
		Role role = session.load(Role.class, 6);
		admin.getRoles().remove(role);

		// 然后更新
		session.update(admin);

		ta.commit();
		session.close();
	}

	@Test
	public void testAdd() {
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();

		Admin admin = new Admin();
		admin.setCode("zs");
		admin.setPassword("123456");
		admin.setName("张三");
		admin.setEnrollDate(new Date(System.currentTimeMillis()));

		// 追加Role
		Role role1 = session.load(Role.class, 4);
		Role role2 = session.load(Role.class, 5);
		admin.getRoles().add(role1);
		admin.getRoles().add(role2);

		session.save(admin);

		ta.commit();
		session.close();
	}

	@Test
	public void test() {
		Session session = HibernateUtil.openSession();

		Admin admin = session.get(Admin.class, 1);

		System.out.println(admin.getName());

		Set<Role> roles = admin.getRoles();
		for (Role role : roles) {
			System.out.println(role.getName());
		}

		System.out.println("=======================");
		Role role = session.get(Role.class, 2);
		System.out.println(role.getName());

		Set<Admin> admins = role.getAdmins();
		for (Admin admin2 : admins) {
			System.out.println(admin2.getName());
		}

		session.close();
	}

}
