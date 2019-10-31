package com.testleaf.boot.myWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UpdateMyWork {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch Browser
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//Maximise the Browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//GeTURL
		driver.get("https://dev77567.service-now.com");
		
		//Login
		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElement(By.xpath("//button[contains(@class,'pull-right btn')]")).click();
		driver.switchTo().defaultContent();
		System.out.println("Login Successfully");
		
		//Filter MyWork		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='My Work'])[1]")).click();

		driver.switchTo().frame("gsft_main");
		String IncidentID = "TKT0010013";
		
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(IncidentID,Keys.ENTER);	
		driver.findElement(By.xpath("//a[text()='"+IncidentID+"']")).click();
				
		//Update Changes
		WebElement element= driver.findElement(By.xpath("//select[@name='ticket.priority']"));
		Select dd = new Select(element);
		dd.selectByIndex(3);
		
		WebElement ele2 = driver.findElement(By.xpath("//select[@name='ticket.state']"));
		Select dd1 = new Select(ele2);
		dd1.selectByValue("2");
		
		driver.findElement(By.xpath("(//textarea[@class='form-control'])[2]")).sendKeys("Update Changes");
		driver.findElement(By.xpath("//button[text()='Update'][1]")).click();
		System.out.println("Updated Changes made successfully");
		//driver.switchTo().defaultContent();
		String ActualState = driver.findElementByXPath("//a[text()='"+IncidentID+"']/following::td[1]").getText();
		Assert.assertEquals(ActualState, "3 - Moderate");
		
		String ActualPriotiry = driver.findElementByXPath("//a[text()='"+IncidentID+"']/following::td[2]").getText();
		Assert.assertEquals(ActualPriotiry, "Work in Progress");
		driver.switchTo().defaultContent();
		
	}
}
