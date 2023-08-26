package com.junit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OmrBranch {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		
		driver = new ChromeDriver();
		driver.get("https://omrbranch.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@AfterClass
	public static void afterClass() throws InterruptedException {
		driver.close();
	}
	@Test
	public void login() {
		driver.findElement(By.id("email")).sendKeys("nixonaj003@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Nj3GQ2xkGr@CRFA");
		driver.findElement(By.xpath("//button[@value='login']")).click();	
	}
	
	@After
	public void afterMethod() throws IOException, InterruptedException {
		Thread.sleep(5000);
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\after.png");
		FileUtils.copyFile(s, des);
	}
	@Before
	public void beforeMethod() throws IOException, InterruptedException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;		
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\before.png");
		FileUtils.copyFile(s, des);
	}
	
	
	
	}


