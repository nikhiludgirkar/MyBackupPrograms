import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class CallSingleton {
	
	WebDriver driver;
	@BeforeClass
	public void method1() {
		SingletonForSelenium s=SingletonForSelenium.getDriverInstance();
		driver=s.openBrowser();
	}
}
