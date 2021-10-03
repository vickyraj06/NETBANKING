package com.netbanking.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.netbanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	
	@Test
	public void loginTest(){
		
		logger.info(" TC_LOGINTEST_001 TESTING STARTED ");
		PageFactory.initElements(driver, LoginPage.class);
		BaseClass baseclass = new BaseClass();
		LoginPage.textusername.sendKeys(baseclass.username);
		logger.info(" USERNAME ENTERED ");
		LoginPage.textpassword.sendKeys(baseclass.password);
		logger.info(" PASSWORD ENTERED ");
		LoginPage.clicklogin.click();
		logger.info(" LOGIN CLICKED ");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {

			Assert.assertTrue(true);
			logger.info(" LOGIN PASSED ");

		} else {
			Assert.assertTrue(false);
			logger.warn(" LOGIN FAILED ");

		}
		logger.info(" TC_LOGINTEST_001 TESTED ");
	}
}
