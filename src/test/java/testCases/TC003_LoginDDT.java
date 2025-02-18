package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/* Data is valid  - login success - test pass - logout 
 * Data is valid - login failed - test fail 
 * 
 * Data is invalid -login success - test fail - logout 
 * Data is invalid - login failed - test pass 
 */

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider ="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")
	public void verify_loginDDT(String email,String pwd ,String exp) 
	{
		try {
		//Homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		Thread.sleep(5000);   //checking how program is running self 
		hp.clicklogin();
		

		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage == true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
		
		
			else 
			{
				Assert.assertTrue(false);
			}
		}	
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		
		catch(Exception e )
		{
			Assert.fail();
		}
		
	
	}
	
	
	
	
	
	
}
