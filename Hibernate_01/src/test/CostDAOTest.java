package test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import dao.CostDAO;
import dao.CostDAOImpl;
import entity.Cost;

public class CostDAOTest {

	@Test
	public void test1() {
		CostDAO costDAO  = new CostDAOImpl();
		Cost cost = costDAO.findById(2);
		System.out.println(cost.getName());
	}
	
	@Test
	public void test2() {
		Cost cost = new Cost();
		cost.setName("¹úÇìÌ×²Í");
		cost.setBaseDuration(10);
		cost.setBaseCost(10.3f);
		cost.setDescr("¹úÇìÌ×²Í");
		cost.setCreateTime(new Date(System.currentTimeMillis()));
		cost.setStatus("0");
		cost.setUnitCost(4.5f);
		
		CostDAO costDAO = new CostDAOImpl();
		costDAO.save(cost);
	}
	
	@Test
	public void test3(){
		CostDAO costDAO = new CostDAOImpl();
		Cost cost = costDAO.findById(27);
		if(cost != null){
			cost.setStatus("1");
			cost.setStartTime(new Date(System.currentTimeMillis()));
			costDAO.update(cost);
		}
	}
	
	@Test
	public void test4(){
		new CostDAOImpl().delete(29);
	}
	
	@Test
	public void test5(){
		List<Cost> costList = new CostDAOImpl().findAll();
		for (Cost cost : costList) {
			System.out.println(cost.getName());
		}
	}

}
