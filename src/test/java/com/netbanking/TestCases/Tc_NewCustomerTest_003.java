package com.netbanking.TestCases;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.netbanking.PageObjects.LoginPage;
import com.netbanking.PageObjects.NewCustomerPage;

public class Tc_NewCustomerTest_003  extends BaseClass{
	
	
	@Test
	public void AddNewCustomer() throws InterruptedException, IOException {
		
		
		PageFactory.initElements(driver,LoginPage.class);
		
		BaseClass baseclass = new BaseClass();
		
		
		LoginPage.textusername.sendKeys(baseclass.username);
		LoginPage.textpassword.sendKeys(baseclass.password);
		LoginPage.clicklogin.click();
		logger.info(" LOGIN SUCCESFULLY ");
		
		
		PageFactory.initElements(driver, NewCustomerPage.class);
	
		
		logger.info(" TC_NEWCUSTOMERTEST_003 STARTED ");
		
		NewCustomerPage.ClickNewCustomer.click();
		logger.info(" CLICKED NEW CUSTOMER MENU ");
		
		String random =baseclass.randomnames();
		NewCustomerPage.AddCustomername.sendKeys(random);
		logger.info(" ENTERED NAME ");
	
		NewCustomerPage.AddMaleGender.click();
		logger.info(" ENTERED GENDER ");
	
		NewCustomerPage.AddDOB.sendKeys("06111996");
		logger.info(" ENTERED DOB ");
	
		NewCustomerPage.AddAddress.sendKeys(randomnames());
		logger.info(" ENTERED ADDRESS ");
	
		NewCustomerPage.AddCity.sendKeys(randomnames());
		logger.info(" ENTERED CITY ");
	
		NewCustomerPage.AddState.sendKeys("TAMILNADU");
		logger.info(" ENTERED STATE ");

		NewCustomerPage.AddPin.sendKeys(randomnumber());
		logger.info(" ENTERED ZIPCODE ");
		
		String randomnum=baseclass.randomnumber();
		NewCustomerPage.AddMobileno.sendKeys(randomnum);
		logger.info(" ENTERED MOBILENO ");
		String email=baseclass.randomnames()+"@gamil.com";
	
		NewCustomerPage.AddEmail.sendKeys(email);
		logger.info(" ENTERED MAIL ");
	
		NewCustomerPage.AddPassword.sendKeys(random);
		logger.info(" ENTERED PASSWORD ");

		NewCustomerPage.ClickSubmit.click();
		logger.info(" CLICKED SUBMIT ");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res==true) {
			Assert.assertTrue(true);
			logger.info(" ADD CUSTOMER DETAILS SUCCESSFULLY ");
		}else {
			
			Assert.assertTrue(false);
			logger.warn(" FAILED ADDING CUSTOMER DETAILS ");
		}
		
		logger.info(" ADD CUSTOMER DETAILS SUCCESSFULLY ");
		logger.info(" TC_NEWCUSTOMERTEST_003 TESTED ");
	
				
		
		
		
		
	}

}
