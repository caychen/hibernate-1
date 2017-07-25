package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;
import entity.Cost;

public class CostDAOImpl implements CostDAO {

	@Override
	public Cost findById(Integer id) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.openSession();

		// 执行查询，按主键当条件查询
		Cost cost = session.get(Cost.class, id);

		// 关闭session
		session.close();

		return cost;
	}

	@Override
	public void save(Cost cost) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();

		// 开启事务
		Transaction ta = session.beginTransaction();
		session.save(cost);

		// 事务提交
		ta.commit();
		session.close();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();
		
		Cost cost = new Cost();
		cost.setId(id);
		session.delete(cost);//只需要主键
		
		ta.commit();
		session.close();
	}

	@Override
	public void update(Cost cost) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();

		Transaction ta = session.beginTransaction();
		
		session.update(cost);//将cost对象更新到数据包中
		ta.commit();
		session.close();
	}

	@Override
	public List<Cost> findAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		
		//SQL:select * from Cost
		String hql = "from Cost";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cost> list = query.list();
		session.close();
		return list;
	}

}
