package test;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Trans;
import utils.HibernateUtil;

public class ThreadClient1 extends Thread {

	// ģ�⹺Ʊ����
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();

		//������
//		@SuppressWarnings("deprecation")
//		Trans trans = session.load(Trans.class, 1, LockMode.UPGRADE);
		
		Trans trans = session.load(Trans.class, 1);
		if (trans.getTickets() >= 1) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			trans.setTickets(trans.getTickets() - 1);
			
			System.out.println("��Ʊ�ɹ�...");
		} else {
			System.out.println("Ʊ�����㣬��Ʊʧ��...");
		}
		ta.commit();
		session.close();
	}
}
