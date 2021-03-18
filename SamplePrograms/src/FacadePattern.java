
interface SynchronizationHelper{
	public void waitForPageToLoad();
}
class HomePage implements SynchronizationHelper{

	@Override
	public void waitForPageToLoad() {
		System.out.println("In homepage");
		
	}
	
}

class AddCustomerPage implements SynchronizationHelper{

	@Override
	public void waitForPageToLoad() {
		// TODO Auto-generated method stub
		System.out.println("In add customer page");
		
	}
	
}

class Manager{
	
	public HomePage h;
	public AddCustomerPage ap;
	
	public void hello() {
		h=new HomePage();
		h.waitForPageToLoad();
	}
	
	public void hello2() {
		ap=new AddCustomerPage();
		ap.waitForPageToLoad();
	}
	
}


public class FacadePattern{
	
	
	
	public static void main(String[] args) {
		Manager m=new Manager();
		m.hello();
		m.hello2();
	}
}