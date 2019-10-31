package com.testleaf.selenium.pages;

import com.testleaf.selenium.api.base.SeleniumBase;
import com.testleaft.selenium.api.design.Locators;

public class DeleteTicketPage extends SeleniumBase{

	public DeleteTicketPage() {
		defaultContent();
		switchToFrame("gsft_main");
	}
	
	public MyWorkPage confirmAlert() {
		
		click(locateElement(Locators.ID, "ok_button"));
		defaultContent();
		return new MyWorkPage();
	}
}
