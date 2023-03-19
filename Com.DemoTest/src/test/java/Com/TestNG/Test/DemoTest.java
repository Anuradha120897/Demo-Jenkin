package Com.TestNG.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {

	@Test(groups="dash",dependsOnGroups = "login")
	public void Dashboard() {
		System.out.println("Dashboard");
		
	}
	
	@Test(groups="dash",dependsOnGroups = "login")
	public void DashboardTitle() {
		System.out.println("DashboardTitle");
		
	}

	@Test(priority = 0,groups="login")
	public void Login() {
		System.out.println("Login");

	}
	@Test(priority = 0,groups="login")
	public void LoginTitle() {
		System.out.println("LoginTitle");
		Assert.assertTrue(false);
		}
	

	@Test(alwaysRun = true,groups="user")
	public void User() {
		System.out.println("User");
	}

}
