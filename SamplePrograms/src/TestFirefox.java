


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.Test;

public class TestFirefox {
	
	@Test
	public void test1() {
		
		ProfilesIni ini=new ProfilesIni();
		FirefoxProfile profile=ini.getProfile("Webdriver");
		profile.setPreference("browser.startup.homepage","https://seleniumbycharan.wordpress.com&#8221");
		profile.setAcceptUntrustedCertificates(true);
		FirefoxOptions opt=new FirefoxOptions();
		opt.setProfile(profile);
		System.setProperty("webdriver.gecko.driver", "D:\\Dev_Tools\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver(opt);
		driver.get("https://www.google.com/");
		driver.close();
		
		
	}
}
