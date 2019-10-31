package com.testleaf.boot.myWork;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignTicket{
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://dev77567.service-now.com");
		
		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElement(By.xpath("//button[contains(@class,'pull-right btn')]")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(8000);
		driver.findElement(By.id("filter")).sendKeys("work");
		Thread.sleep(3000);				
		driver.findElement(By.xpath("(//div[text()='My Work'])[1]")).click();

		driver.switchTo().frame("gsft_main");
		Thread.sleep(3000);
		driver.findElementByXPath("//b[text()='All']").click();
		Thread.sleep(3000);
		String TicketID = "TKT0010023";

		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(TicketID,Keys.ENTER);	
		
		Thread.sleep(3000);
		driver.findElementByXPath("//a[text()='"+TicketID+"']").click();
		
		Thread.sleep(8000);
		driver.findElement(By.id("sys_display.ticket.assignment_group")).sendKeys("IT Securities");
		Thread.sleep(5000);
		
		Select priority = new Select (driver.findElementById("ticket.priority"));
		priority.selectByVisibleText("2 - High");
		Thread.sleep(2000);
		Select state = new Select (driver.findElementById("ticket.state"));
		state.selectByVisibleText("Closed Complete");
		Thread.sleep(3000);	
		driver.findElementById("ticket.work_notes").sendKeys("text");
			
		driver.findElement(By.xpath("(//button[@id='sysverb_update'])[1]")).click();
		Thread.sleep(2000);
		
		//driver.findElementByXPath("//b[text()='All']").click();
		//driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(TicketID,Keys.ENTER);	
		Thread.sleep(3000);
		
		String ActualState = driver.findElementByXPath("//a[text()='"+TicketID+"']/following::td[2]").getText();
		Assert.assertEquals(ActualState, "Closed Complete");
		
		String ActualPriotiry = driver.findElementByXPath("//a[text()='"+TicketID+"']/following::td[1]").getText();
		Assert.assertEquals(ActualPriotiry, "2 - High");
		
		driver.findElementByXPath("//a[text()='"+TicketID+"']").click();
		Thread.sleep(3000);
	
		String ActualAssgrp = driver.findElementById("sys_display.ticket.assignment_group").getAttribute("value");
		
		Assert.assertEquals(ActualAssgrp, "IT Securities");
		System.out.println("Test completed");
	}
}