package com.testleaf.boot.serviceNow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Resolvepage {

	public static void main(String[] args) throws InterruptedException {
		//Launch Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		//GeTURL
		driver.get("https://dev77567.service-now.com");	
		
		//Login
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
		
		//Filter incident
		driver.switchTo().frame("gsft_main");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Filter navigator']")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
		driver.switchTo().defaultContent();
		
		//Find incident
		driver.switchTo().frame("gsft_main");
		String  value="INC0000007";
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='incident_table_header_search_control'])[1]")).sendKeys(value,Keys.ENTER);
		Thread.sleep(5000);
		WebElement table =driver.findElement(By.xpath("//*[@id=\"incident_table\"]/tbody/tr[1]/td[3]"));
		Thread.sleep(3000);
		table.click();
		driver.switchTo().defaultContent();
		
		//Resolve_Page
		driver.switchTo().frame("gsft_main");
		Thread.sleep(3000);
		WebElement resolvebutton= driver.findElement(By.id("resolve_incident"));
		Thread.sleep(2000);
		resolvebutton.click();
		Thread.sleep(2000);
		JavascriptExecutor jd=(JavascriptExecutor)driver;
		WebElement scrolldown  =driver.findElement(By.xpath("(//span[@class='tab_caption_text'])[3]"));
		jd.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		Thread.sleep(2000);
		scrolldown.click();
		WebElement incidentclose_code = driver.findElement(By.name("incident.close_code")); 
		new Select(incidentclose_code).selectByIndex(3);
		driver.findElement(By.id("incident.close_notes")).sendKeys("testing");
		WebElement scrollup  =driver.findElement(By.id("resolve_incident"));
		jd.executeScript("arguments[0].scrollIntoView(true);", scrollup);
		scrollup.click();
		System.out.println("Incident Resolved Successfully "+value);
		
	}
	}

