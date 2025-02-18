package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistorPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass  {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistorPage regpage = new AccountRegistorPage(driver);
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomnumberic());
		
		
		String password = randomalphanumeric();
		regpage.setPassword(password);
		regpage.setConfirmpassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		String confmsg=regpage.getconfirmationMsg();
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
	}
}
