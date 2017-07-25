package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf;

	static {
		// 加载主配置
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");

		// 获取SessionFactory
		sf = conf.buildSessionFactory();
	}

	public static Session openSession() {
		// 获取Session
		Session session = sf.openSession();
		return session;
	}
}
