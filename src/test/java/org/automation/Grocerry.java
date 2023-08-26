package org.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.Select;

public class Grocerry {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://omrbranch.com/");

		driver.manage().window().maximize();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("nixonaj003@gmail.com");

		WebElement txtPassWord = driver.findElement(By.id("pass"));
		txtPassWord.sendKeys("Nj3GQ2xkGr@CRFA");

		WebElement btnLogin = driver.findElement(By.xpath("//button[@value='login']"));
		btnLogin.click();

		Thread.sleep(2500);

		WebElement txtSearch = driver.findElement(By.xpath("//input[@id='search']"));
		txtSearch.sendKeys("nuts", Keys.ENTER);

		WebElement btnAdd = driver.findElement(By.xpath(
				"//a[@class='hover1 font16 fontsemibold colorWhite bgTheme px-4 py-1 radius50 dyna_btn addBtn-22']"));
		btnAdd.click();

		Thread.sleep(2500);

		WebElement btnAddvariety = driver.findElement(By.id("cart-33"));
		btnAddvariety.click();

		Thread.sleep(1000);

		WebElement goToCart = driver.findElement(By.className("hover1"));
		goToCart.click();

		Thread.sleep(1000);

		WebElement addAddress = driver.findElement(By.xpath(
				"//div[@class='diffAddres addAddress d-flex justify-content-center align-items-center mb-md-0 mb-2']"));
		addAddress.click();

		WebElement ddnAddressType = driver.findElement(By.id("address_type"));

		Select select = new Select(ddnAddressType);
		select.selectByIndex(3);

		WebElement txtFirstName = driver.findElement(By.name("first_name"));
		txtFirstName.sendKeys(("ANTONY GEORGE"));

		WebElement txtLastName = driver.findElement(By.name("last_name"));
		txtLastName.sendKeys("NIXON AJ");

		WebElement txtMobile = driver.findElement(By.name("mobile"));
		txtMobile.sendKeys("7373348242");

		WebElement txtDoorNo = driver.findElement(By.name("apartment"));
		txtDoorNo.sendKeys("No 25");

		WebElement txtAddress = driver.findElement(By.name("address"));
		txtAddress.sendKeys("South Street, Sokkankudiruppu,");

		WebElement ddnState = driver.findElement(By.name("state"));

		Select select2 = new Select(ddnState);
		select2.selectByVisibleText("Tamil Nadu");

		Thread.sleep(1000);

		WebElement ddnCity = driver.findElement(By.xpath("//select[@name='city']"));
		Select select3 = new Select(ddnCity);
		select3.selectByVisibleText("Tuticorin");

		WebElement txtZipcode = driver.findElement(By.name("zipcode"));
		txtZipcode.sendKeys("628653", Keys.ENTER);

		Thread.sleep(2000);

		WebElement ddnPayment = driver.findElement(By.id("payment_type"));
		Select select4 = new Select(ddnPayment);
		select4.selectByIndex(1);
		
		Thread.sleep(2000);

		WebElement rdBtnVisa = driver.findElement(By.id("visa_card"));
		
		executor.executeScript("arguments[0].click();", rdBtnVisa);

		

		WebElement txtCardNo = driver.findElement(By.xpath("//input[@placeholder='Card Number']"));
		txtCardNo.sendKeys("5555555555552222");

		WebElement ddnMonth = driver.findElement(By.id("month"));

		Select select5 = new Select(ddnMonth);

		select5.selectByIndex(4);
		
		WebElement ddnYears = driver.findElement(By.id("year"));
		
		Select select6 = new Select(ddnYears);
		select6.selectByIndex(5);
		
		WebElement txtCvv = driver.findElement(By.name("cvv"));
		txtCvv.sendKeys("478");
		
		WebElement btnPlaceOrder = driver.findElement(By.xpath("//button[@id='placeOrder']"));
		
		btnPlaceOrder.click();
		
		
		Thread.sleep(8000);
		
		WebElement txtOrderNo = driver.findElement(By.xpath("(//p[@class='font18 color20 fontSemiBold mb-0'])[1]"));
		String orderNo = txtOrderNo.getText();
		System.out.println(orderNo);
		
	//	driver.close();
		
		

	}

}
