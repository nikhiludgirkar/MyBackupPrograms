import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollIntoView  {
	private WebDriver driver;
	
	@BeforeClass
	public void initilialize() {
		System.setProperty("webdriver.chrome.driver", "D:\\Dev_Tools\\chromedriver85\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void test1() {
		driver.findElement(By.name("q")).sendKeys("windows operating system");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(.,'Images')]")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement we=driver.findElement(By.xpath("//a[text()='Privacy']/following-sibling::a[contains(text(), 'Terms')]"));
//		int y = we.getLocation().getY();
		long value=0;
		while (true) {
			js.executeScript("window.scrollBy(0,700)");
			try {
				value = (long)js.executeScript("return window.pageYOffset;");
				System.out.println("*************************"+value);
				boolean b=driver.findElement(By.xpath("//a[text()='Privacy']/following-sibling::a[contains(text(), 'Terms')]")).isDisplayed();
				if (b) {
					driver.findElement(By.xpath("//a[text()='Privacy']/following-sibling::a[contains(text(), 'Terms')]")).click();
					break;
				}
				else if (value>=20000) {
					Assert.fail("element not found");
				}
				else { 
					continue;
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}
}
