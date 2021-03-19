import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

class Insensitive implements Comparator{
	public final int compare(Object a, Object b) {
		String a1 = a.toString().toLowerCase();
        String b1 = b.toString().toLowerCase();
        return b1.compareTo(a1);
	}
}

public class SortElements {

	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Dev_Tools\\chrome_driver_89\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1/orangehrm-4.1/symfony/web/index.php/auth/login");
	}
	
	
	@Test
	public void test1() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Zingalala@2018");
		driver.findElement(By.id("btnLogin")).click();
		Actions builder=new Actions(driver);
		WebElement admin=driver.findElement(By.xpath("//a/b[contains(.,'Admin')]"));
		builder.moveToElement(admin).build().perform();
		WebElement userMgmt=driver.findElement(By.xpath("//li/a[@id='menu_admin_UserManagement']"));
		builder.moveToElement(userMgmt).build().perform();
		driver.findElement(By.xpath("//li/a[@id='menu_admin_viewSystemUsers']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Username')]")).click();
		List<WebElement> unsortedList=driver.findElements(By.xpath("//tr/td/a"));
		for (WebElement a : unsortedList)
			System.out.println("Unsorted elements are : "+a.getText());
		List<String> sortedList=new ArrayList<String>();
		for (WebElement e : unsortedList) {
			sortedList.add(e.getText());
		}
		
		Collections.sort(sortedList, new Insensitive());
		
		for (String a: sortedList) {
			System.out.println("++++++mysorted list is"+a);
		}
		driver.findElement(By.xpath("//a[@class='ASC' and contains(.,'Username')]")).click();
		
		List<WebElement> sortedElements=driver.findElements(By.xpath("//tr/td/a"));
		int index=0;
		
		
		for (WebElement pe : sortedElements) {
			System.out.println("*******"+pe.getText());
			if (!pe.getText().contains(sortedList.get(index))) {
				Assert.fail("sorting is not working");
			}
			index++;
		}
	}
	
	@AfterClass
	public void shutdown() {
		if (driver!=null) {
			driver.close();
		}
	}
}
