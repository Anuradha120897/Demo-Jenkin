package Com.WindowHandlingCode;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandellingEx {

	@Test
	public void test01() {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/JBK/Anuradha/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();

		// here we get the handle of dashboard window which is main window which create the unique id if u want to print 
		//then pass the ref in syso statements 
		String mainwin=driver.getWindowHandle();

		//this is the code for open the all 4 window of dashboard page 
		//so if want open the multiple window one by one we required the for loop
		
		List<WebElement> links	= driver.findElements(By.xpath("//a[text()='More info ']"));

		// here we apply the for each loop to get all the windows one by one
		for(WebElement link : links) {
			link.click();}
         // here we get 5 window opened.
		
	   // this code will handle the 4 window i.e. the child window that will opened by clicking on more info	
		Set<String> allwin=driver.getWindowHandles();

		// here we apply the if condition that if win is not equal to mainwin then switch to that window
		//then this will go to that perticular window and close all the window one by one for that here we required the foreach loop
		for (String win : allwin) {
			
		//as we say above that mainwin will give u an unique id , as like main win this all 4 win also have unique id
		//if we want to print this unique id then write the ref in syso statement 
			System.out.println("handle of window"+   win);
			
			if(!win.equals(mainwin)) {
				driver.switchTo().window(win);
				
        //this will print the url of all page this 4 are pdf so we can print the title of it but we can print the url 
		//thats why we write the driver.getCurrentUrl()	in syso statement	
				System.out.println(driver.getCurrentUrl());
				driver.close();

			}

		}

	}

}





