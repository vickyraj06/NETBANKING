package com.netbanking.PageObjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


public class LoginPage {
	
	
		
		@FindBy(xpath ="//input[@name='uid']")
		public static WebElement textusername;
		
		@FindBy(xpath ="//input[@name='password']")
		public static WebElement textpassword;
		
		
		@FindBy(xpath="//input[@name='btnLogin']")
		public static WebElement clicklogin;
		
		
		@FindBy(xpath = "//a[@href='Logout.php']")
		public static WebElement clickLogout;
		
		
		
			
			

}
