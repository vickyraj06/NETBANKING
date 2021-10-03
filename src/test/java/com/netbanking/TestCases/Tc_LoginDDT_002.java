package com.netbanking.TestCases;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.PageObjects.LoginPage;
import com.netbanking.Utilities.XLUtils;

public class Tc_LoginDDT_002 extends BaseClass {
	
	
	
	@DataProvider(name="Logindata")
	public String[][] getExcelData() throws IOException {
		
		String Path ="C:\\eclipse-workspace\\NetBanking\\src\\test\\java\\com\\netbanking\\TestData\\LoginData.xlsx";
		
		
		int rowcount = XLUtils.getRowCount(Path,"sheet1");
	
		int colcount = XLUtils.getCellCount(Path, "sheet1", 1);
		
	
		String logindata[][] = new String[rowcount][colcount];
		
		for(int i =1;i<rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				
					logindata[i-1][j]=XLUtils.getCellData(Path,"sheet1", i, j);
				
			}
		}
		return logindata;
	}
	
	public boolean isAlertpresent() {  /* ------> user defined method to check alert   */
		
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@Test(dataProvider = "Logindata")
	public void LoginDDT(String user ,String password) {
		
		PageFactory.initElements(driver, LoginPage.class);
		LoginPage.textusername.sendKeys(user);
		logger.info(" USERNAME PROVIDED ");
		LoginPage.textpassword.sendKeys(password);
		logger.info(" PASSWORD PROVIDED ");
		LoginPage.clicklogin.click();
		logger.info(" LOGIN CLICKED ");
		
		if(isAlertpresent()==true) {
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("  LOGIN FAILED ");
		}
		else {
			Assert.assertTrue(true);
			LoginPage.clickLogout.click();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn(" LOGIN PASSED ");
			
		}
	}
		
		

}


	



