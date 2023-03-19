package Com.TestNG.Test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoTest4 {
	
	@Parameters("browser")
	@BeforeSuite
	@Test
	public void setup(String browser) {
		System.out.println(browser);
		
		if(browser.equals("chrome")) {
			// then launch the chrome
		}
		
		if(browser.equals("Firefox")) {
			// then launch the Firefox browser
		}
	}

	@Test
	public void Dashboard() {
		System.out.println("Dashboard");
		
	}
	
	@Test
	public void Login() {
		System.out.println("Login");

	}

	@Test
	public void User() {
		System.out.println("User");
	}

}
