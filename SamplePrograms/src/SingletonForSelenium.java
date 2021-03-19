import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonForSelenium {
	
	private static SingletonForSelenium single=null;
	
	private WebDriver driver;
	private SingletonForSelenium() {
		
	}
	
	public WebDriver openBrowser() {
		driver=new ChromeDriver();
		return driver;
	}
	
	public static SingletonForSelenium getDriverInstance() {
		
		if (single==null) 
			single=new SingletonForSelenium();
			return single;
	}
	
	
}
