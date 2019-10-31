package com.testleaf.boot.myWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateMyWork {

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
		WebElement ele = driver.findElement(By.xpath("//button[text()='New']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele);
		ele.click();
		driver.findElement(By.linkText("Ticket")).click();
		
		WebElement text = driver.findElement(By.xpath("(//div[@class='hidden']/following-sibling::input)[1]"));
		String value = text.getAttribute("value");
		System.out.println("TextValue =" + value);
		
		driver.findElement(By.xpath("//input[@class ='form-control'][1]")).sendKeys("New Ticket Request");
		driver.findElement(By.xpath("(//textarea[@class='form-control'])[2]")).sendKeys("Created New Ticket");
		driver.findElement(By.xpath("//div[@class='form_action_button_container']//button")).click();
		System.out.println("Successfully Ticket created");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(value,Keys.ENTER);	
		driver.switchTo().defaultContent();

	}
}
