package com.testleaf.testng.api.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.testleaf.selenium.api.base.SeleniumBase;
import com.testleaf.utils.DataLibrary;

public class ProjectSpecificMethods extends SeleniumBase {

	
	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(excelFileName);
	}	

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		startApp("chrome", "https://dev69221.service-now.com/");
		setNode();
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		close();
	}













}
