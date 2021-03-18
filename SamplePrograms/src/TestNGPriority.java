import org.testng.annotations.Test;

public class TestNGPriority {
	@Test(priority=1)
	public void test5() {
		System.out.println("priority 1");
	}

	
	@Test(priority=-1)
	public void test1() {
		System.out.println("priority -1");
	}
	
	@Test(priority=-2)
	public void test2() {
		System.out.println("priority -2");
	}
	
	@Test(priority=-3)
	public void test3() {
		System.out.println("priority -3");
	}
	
	@Test(priority=0)
	public void test4() {
		System.out.println("priority 0");
	}
	
	
}
