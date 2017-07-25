package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf;

	static {
		// ����������
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");

		// ��ȡSessionFactory
		sf = conf.buildSessionFactory();
	}

	public static Session openSession() {
		// ��ȡSession
		Session session = sf.openSession();
		return session;
	}
}
