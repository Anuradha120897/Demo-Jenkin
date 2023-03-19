package Com.FrameHandelling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RedbusLogin {

	@Test
	public void login() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		driver.findElement(By.id("i-icon-profile")).click();
		driver.findElement(By.id("signInLink")).click();
         Thread.sleep(3000);
		//frame handling code
		WebElement frame =driver.findElement(By.xpath("//iframe[@class='modalIframe']"));//frame window
		driver.switchTo().frame(frame);
		driver.findElement(By.id("mobileNoInp")).sendKeys("1234567890");

		driver.findElement(By.xpath("//*[@id=\"newFbId\"]")).click();
	

		String logwin=driver.getWindowHandle();        //fb window
		Set<String>facebookwin=driver.getWindowHandles();
		for (String Win : facebookwin) {
			if(!Win.equals(logwin)) {

				driver.switchTo().window(Win);  }	
		}
		
		
		
		driver.getWindowHandle();
		
		driver.findElement(By.xpath("//*[text()='Create New Account']")).click();//fb account window or create account window
		
		String fbwin=driver.getWindowHandle();
		Set<String>allwin=driver.getWindowHandles();
		for (String accwin : allwin) {
			if(!accwin.equals(logwin)&&!accwin.equals(fbwin)) {}
			driver.switchTo().window(accwin);
		}
		
		
		

		driver.findElement(By.name("firstname")).sendKeys("Anuradha");
		
		driver.findElement(By.name("lastname")).sendKeys("Mhangare");
		driver.findElement(By.name("reg_email__")).sendKeys("anuradhamhangare1919@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Swaramrudu18");
		driver.findElement(By.name("birthday_day")).sendKeys("12");
		driver.findElement(By.name("birthday_month")).sendKeys("August");
		driver.findElement(By.name("birthday_year")).sendKeys("1997");
//		driver.findElement(By.xpath("//*[@id=\"u_0_o_mg\"]/span[1]/label")).click();
	
		
	}
	}

