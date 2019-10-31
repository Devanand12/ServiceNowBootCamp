package com.testleaf.boot.serviceNow;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssignGroup{
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://dev77567.service-now.com");	
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("filter")).sendKeys("incident");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.='Open']")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath(".//select[@class='form-control']/../../..//input")).sendKeys("INC0000003");
		driver.findElement(By.xpath(".//select[@class='form-control']/../../..//input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//a[.='INC0000003']")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("sys_display.incident.assignment_group")).clear();
		driver.findElement(By.id("sys_display.incident.assignment_group")).sendKeys("Software");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[.='Update']")).click();
		driver.findElement(By.xpath(".//a[.='INC0000003']")).click();
		String group= driver.findElement(By.id("sys_display.incident.assignment_group")).getAttribute("value");
		System.out.print(group);
		Assert.assertEquals(group,"Software");
		
	}
}