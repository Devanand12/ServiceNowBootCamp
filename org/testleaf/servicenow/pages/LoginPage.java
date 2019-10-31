package org.testleaf.servicenow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage() {
	
		PageFactory.initElements(getDriver(), this);
			switchToFrame("gsft_main");
	}
	@FindBy(how=How.XPATH,using="//label[text()='User name']/following::input") private WebElement eleUsername;
	public LoginPage enterUserName(String username) {
		clearAndType(eleUsername, "admin");
		return this;
		
		
	}
	@FindBy(how=How.XPATH,using="//input[@type='password']") private WebElement elePassword;
	public LoginPage enterpassword (String password) {
		clearAndType(elePassword, "India@123");
		return this;
		
	}
	@FindBy(how=How.ID,using="sysverb_login") private WebElement eleLoginButton;
	public HomePage clickLoginButton() {
		click(eleLoginButton);
		return new HomePage() ;
		
	}

	
	
}
