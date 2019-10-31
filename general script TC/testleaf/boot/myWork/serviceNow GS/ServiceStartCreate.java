package com.testleaf.boot.serviceNow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServiceStartCreate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
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
		System.out.println("Login Successfully");
	
		//Filter incident
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Filter navigator']")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
		driver.switchTo().defaultContent();
		
		//Create New
		driver.switchTo().frame("gsft_main");
		WebElement text = driver.findElement(By.xpath("//input[@class='form-control'][1]"));
		String value = text.getAttribute("value");
		System.out.println("TextValue =" + value);
		
		driver.findElement(By.xpath("(//input[@class='form-control element_reference_input'])[1]")).sendKeys("Abel Tuter");
		driver.findElement(By.xpath("(//input[@data-ref='incident.short_description'])[2]")).sendKeys("Request Normal Change");
		
		//Create Submit
		driver.findElement(By.xpath("(//button[contains(@class,'form_action_button ')])[3]")).click();
		System.out.println("Incident Create Successfully created");
			
		driver.findElement(By.xpath("((//label[text()='Search'])[2]/following::input)[3]")).sendKeys(value, Keys.ENTER);
		
	}

}
