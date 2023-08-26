package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dep {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://omrbranch.com/");
		 
		WebElement userId = driver.findElement(By.id("email"));
		userId.sendKeys("nixonaj003@gmail.com");
		
		WebElement passWord = driver.findElement(By.id("pass"));
		passWord.sendKeys("nixon1232");
		
		WebElement btnLogin = driver.findElement(By.xpath("//button[@value='login']"));
		btnLogin.click();
		
		
		
	}
	

}
