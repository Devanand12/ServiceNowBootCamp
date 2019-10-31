package com.testleaf.boot.myWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteMyWork {

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
		String IncidentID = "TKT0010029";
		
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(IncidentID,Keys.ENTER);	
		driver.findElement(By.xpath("//a[text()='"+IncidentID+"']")).click();
				
		driver.findElement(By.xpath("//button[text() = 'Delete']")).click();
		Thread.sleep(3000);

		driver.findElementById("ok_button").click();
		System.out.println("Deleted Successfully");

	}
}
