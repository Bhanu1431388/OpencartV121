package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity","Master"})
	public void test_Login()
	{
	    logger.info("Starting TC_002_LoginTest");

	    try
	    {				
	        HomePage hp = new HomePage(driver);
	        hp.clickMyAccount();
	        hp.clickLogin();

	        LoginPage lp = new LoginPage(driver);
	        lp.setEmail(p.getProperty("email"));
	        lp.setPassword(p.getProperty("password"));
	        lp.clickLogin();

	        MyAccountPage macc = new MyAccountPage(driver);
	        boolean targetPage = macc.isMyAccountPageExists();

	        Assert.assertTrue(targetPage, "MyAccount page not found. Login may have failed.");
	    }	
	    catch(Exception e)
	    {
	        logger.error("Exception during test_Login: " + e.getMessage());
	        Assert.fail("Exception occurred in test_Login.");
	    }

	    logger.info("Finished TC_002_LoginTest");
	}
}