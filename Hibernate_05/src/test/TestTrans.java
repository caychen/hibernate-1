package test;

public class TestTrans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadClient1 c1 = new ThreadClient1();
		ThreadClient1 c2 = new ThreadClient1();
		c1.start();
		c2.start();
	}

}
