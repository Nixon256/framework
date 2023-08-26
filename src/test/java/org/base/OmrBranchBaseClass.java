package org.base;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OmrBranchBaseClass extends BaseClass {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		OmrBranchBaseClass branch = new OmrBranchBaseClass();
		branch.getOrderId();
	}
	
	public void getOrderId() throws IOException, InterruptedException {
		
		
		launchChromeBrowser();
		
		launchUrl("https://omrbranch.com/");
		
		windowMaximize();
		
		WebElement txtUserName = findElementById("email");
		elementSendkeys(txtUserName, "SignUpPage", "Grocerry", 1, 0);
		
		WebElement txtPassword = findElementById("pass");
		elementSendkeys(txtPassword, "SignUpPage", "Grocerry", 1, 1);
		
		WebElement btnLogin = findElementByXpath("//button[normalize-space()='Login']");
		elementClick(btnLogin);
	
		
		Thread.sleep(2000);

		
		WebElement goToCart = findElementByXpath("//i[@class='fa fa-shopping-cart']");
		elementClick(goToCart);
		Thread.sleep(2000);
		
		WebElement cart = findElementByXpath("//a[@class='hover1']");
		cart.click();
		
		Thread.sleep(2000);
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		List<WebElement> removeProduct = findElementsByXpath("(//div[@class='container'])[3]//img[contains(@src,'https://omrbranch.com/front/ima')]");
		int size = removeProduct.size();
		System.out.println(size);
		for (int i = 0; i < removeProduct.size(); i++) {
			WebElement element = driver.findElement(By.xpath("(//div[@class='container'])[3]//img[contains(@src,'https://omrbranch.com/front/ima')]"));
			Thread.sleep(6000);
			executor.executeScript("arguments[0].click();", element);
		}
		Thread.sleep(5000);
		
		WebElement txtSearch = findElementByXpath("//input[@id='search']");
		elementSendkeys(txtSearch, "SignUpPage", "Grocerry", 1, 2);
		
		WebElement btnSearch = findElementByXpath("//button[@data-testid='searchbtn']");
		elementClick(btnSearch);
		Thread.sleep(2000);
		
		WebElement btnAdd = findElementByXpath("//a[@class='hover1 font16 fontsemibold colorWhite bgTheme px-4 py-1 radius50 dyna_btn addBtn-22']");
		elementClick(btnAdd);
		Thread.sleep(2000);

		WebElement btnAddProduct = findElementById("cart-33");
		elementClick(btnAddProduct);
		Thread.sleep(2000);
		
		WebElement goCart = findElementByClassName("hover1");
		elementClick(goCart);
		
		
		WebElement addAddress = findElementByXpath("//div[@class='diffAddres addAddress d-flex justify-content-center align-items-center mb-md-0 mb-2']");
		elementClick(addAddress);
		
		Thread.sleep(2000);


		WebElement ddnAddressType = findElementById("address_type");
		//selectOptionByText(ddnAddressType,"SignUpPage", "Grocerry", 1, 3);
		selectOptionByIndex(ddnAddressType, 3);
		
		
		//selectOptionByText(ddnAddressType, "SignUpPage", "Grocerry", 1, 3);
		
		
		
		WebElement firstName = findElementByName("first_name");
		elementSendkeys(firstName, "SignUpPage", "Grocerry", 1, 4);
		Thread.sleep(2000);

		
		WebElement lastName = findElementByName("last_name");
		elementSendkeys(lastName, "SignUpPage", "Grocerry", 1, 5);
		Thread.sleep(2000);

		
		WebElement mobileNum = findElementByName("mobile");
		elementSendkeys(mobileNum, "SignUpPage", "Grocerry", 1, 6);
		Thread.sleep(2000);

		WebElement doorNo = findElementByName("apartment");
		elementSendkeys(doorNo, "SignUpPage", "Grocerry", 1, 7);
		Thread.sleep(2000);

		WebElement address = findElementByName("address");
		elementSendkeys(address, "SignUpPage", "Grocerry", 1, 8);
		Thread.sleep(2000);

		WebElement ddnState = findElementByName("state");
		selectOptionByText(ddnState,"SignUpPage", "Grocerry", 1, 10);
		Thread.sleep(2000);

		WebElement ddnCity = findElementByXpath("//select[@name='city']");
		selectOptionByText(ddnCity,"SignUpPage", "Grocerry", 1, 11);
		Thread.sleep(2000);
		
		WebElement zipCode = findElementByName("zipcode");
		elementSendkeys(zipCode, "SignUpPage", "Grocerry", 1, 12);
		Thread.sleep(2000);
		
		
		WebElement btnSave = findElementByXpath("//button[@class='saveAddress font18 fontSemiBold colorWhite bgTheme radius50 borderNone px-5 py-2 hover1']");
		elementClick(btnSave);
		
		Thread.sleep(5000);
		WebElement ddnPaymentType = findElementById("payment_type");
		selectOptionByIndex(ddnPaymentType, 1);
		Thread.sleep(2000);
		
		WebElement rdnCard = findElementByXpath("//label[@for='visa_card']");
		elementClick(rdnCard);
		Thread.sleep(2000);
		
		WebElement cardNo = findElementByXpath("//input[@placeholder='Card Number']");
		elementSendkeys(cardNo, "SignUpPage", "Grocerry", 1, 15);
		
		WebElement cardMonth = findElementById("month");
		selectOptionByIndex(cardMonth, 11);
		
		WebElement cardYear = findElementById("year");
		selectOptionByIndex(cardYear, 5);
		
		WebElement cardCVV = findElementByName("cvv");
		elementSendkeys(cardCVV, "SignUpPage", "Grocerry", 1, 18);
		
		WebElement btnPlaceOrder = findElementByXpath("//button[@id='placeOrder']");
		elementClick(btnPlaceOrder);
		
		Thread.sleep(8000);
		
		
		WebElement orderId = findElementByXpath("(//span[@class='font16 fontNormal color36'])[1]");
		String txtOrderID = orderId.getText();
		System.out.println(txtOrderID);
		insertCell("SignUpPage", "Grocerry", 1, 19, txtOrderID);
		
		//insertValueInCell("SignUpPage", "Grocerry", 1, 19, txtOrderID);
		
		//updateCellData1("Grocerry", "SignUpPage", 1, 19,null ,txtOrderID);
		
		//writeNewRow("SignUpPage", "Grocerry", 1, 19, txtOrderID);
		
		
		//writeNewWorkbook("SignUpPage", "Grocerry", 1, 19, txtOrderID);
		
		
		
		
		
		

		
		
		
		
		
		
		

	}
}
