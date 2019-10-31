package org.testleaf.servicenow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class RequestPage extends ProjectSpecificMethods {
	
	public RequestPage()
	{
		PageFactory.initElements(getDriver(), this);
	   switchToFrame("gsft_main");
	}
		//TO SELECT THE FIRST REQUIRED REQUEST NUMBER - Vignesh
		@FindBy(how=How.XPATH,using="//table[@id='sc_request_table']//tr[1]//td[3]//a") private WebElement eleWorkNumber;
		public RequestNumberPage clickWorkNumber() {
			click(eleWorkNumber);
			return new RequestNumberPage(); 
		}
		
		//TO SELECT THE FIRST REQUIRED WoRK NUMBER - Vignesh
				@FindBy(how=How.XPATH,using="//table[@id='task_table']//tr[1]//td[3]//a") private WebElement eleMyWorkNumber;
				public RequestNumberPage clickMyWorkNumber() {
					click(eleMyWorkNumber);
					return new RequestNumberPage(); 
				}

	
		

	

}
