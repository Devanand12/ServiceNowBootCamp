package com.testleaf.boot.serviceNow;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class updateIncident {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kirth\\git\\servicenow-automation\\drivers\\chromedriver.exe");  
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://dev77567.service-now.com");
		driver.manage().window().maximize();
		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		driver.switchTo().defaultContent();
		Thread.sleep(12000);
	
		driver.findElementById("filter").sendKeys("incident");
		driver.findElementByXPath("//div[contains(text(),'Open')][1]").click();
		driver.switchTo().frame("gsft_main");
		
		String IncidentID = "INC0000002";

		driver.findElement(By.xpath("((//label[text()='Search'])[2]/following::input)[1]")).sendKeys(IncidentID, Keys.ENTER);
		driver.findElementByXPath("//a[text()='"+IncidentID+"']").click();

		Thread.sleep(3000);
		Select state = new Select (driver.findElementById("incident.state"));
		state.selectByVisibleText("In Progress");
	Thread.sleep(3000);
	Select urgency = new Select (driver.findElementById("incident.urgency"));
	urgency.selectByVisibleText("1 - High");
	
	Thread.sleep(3000);

	Thread.sleep(8000);

	driver.findElement(By.xpath("(//textarea[contains(@class,'sn-string-textarea form-control')])[3]")).sendKeys("Text");
	Thread.sleep(3000);
	
	driver.findElementByXPath("//div[@class=\"btn-group\"]/following::button[text()='Update'][1]").click();
	
	Thread.sleep(3000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("gsft_main");
	driver.findElement(By.xpath("((//label[text()='Search'])[2]/following::input)[1]")).sendKeys(IncidentID, Keys.ENTER);

	String ActualState = driver.findElementByXPath("//a[text()='"+IncidentID+"']/following::td[5]").getText();
	Assert.assertEquals(ActualState, "In Progress");
	
	String ActualPriotiry = driver.findElementByXPath("//a[text()='"+IncidentID+"']/following::td[4]").getText();
	Assert.assertEquals(ActualPriotiry, "1 - Critical");
	driver.switchTo().defaultContent();
	
	
	}

}
