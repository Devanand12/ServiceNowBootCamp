package com.testleaf.servicenow.testcases;

import org.openqa.selenium.WebElement;
import org.testleaf.servicenow.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testleaf.selenium.api.design.Element;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class TC005CancelOrder extends ProjectSpecificMethods{
	@BeforeTest
	public void setData() {
		testcaseName="Login";
		testcaseDec="Login into service now application";
		author="Vignesh";
		category="smoke";
		excelFileName="TC001";
	}

	@Test(dataProvider = "fetchData")
	public void runTC001(String username,String password,String filtertype,String approval, String requeststate, String desc, String shortdesc ) {
		new LoginPage()
		.enterUserName(username)
		.enterpassword(password)
		.clickLoginButton()
		.enterFiltertype(filtertype)
		.clickMyRequests()
		.clickWorkNumber()
		.selectValueRejected(approval)
		.selectValueClosedCancelled(requeststate)
		.inputDescription(desc)
		.shortDescription(shortdesc)
		.clickCancelRequest();
		
		
		
		











	}

}
