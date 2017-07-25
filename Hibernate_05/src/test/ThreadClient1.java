package test;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Trans;
import utils.HibernateUtil;

public class ThreadClient1 extends Thread {

	// Ä£Äâ¹ºÆ±²Ù×÷
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();

		//±¯¹ÛËø
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
			
			System.out.println("¹ºÆ±³É¹¦...");
		} else {
			System.out.println("Æ±Êý²»×ã£¬¹ºÆ±Ê§°Ü...");
		}
		ta.commit();
		session.close();
	}
}
