package Com.TestNG.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest2 {

	@Test
	public void Dashboard() {
		System.out.println("Dashboard");
		
	}
	
	@Test
	public void DashboardTitle() {
		System.out.println("DashboardTitle");
		
	}

	@Test
	public void Login() {
		System.out.println("Login");

	}
	@Test
	public void LoginTitle() {
		System.out.println("LoginTitle");
		Assert.assertTrue(false);
		}
	

	@Test
	public void User() {
		System.out.println("User");
	}

}
