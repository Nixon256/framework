
package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	WebDriver driver;
	Select select;
	Actions actions;

	// 1 launchChromeBrowser
	public void launchChromeBrowser() {

		driver = new ChromeDriver();
	}

	// 2 launchFirefoxBrowser
	public void launchFirefoxBrowser() {

		driver = new FirefoxDriver();
	}

	// 3 launchEdgeBrowser
	public void launchEdgeBrowser() {

		driver = new EdgeDriver();
	}

	// 4 launchUrl

	public void launchUrl(String url) {
		driver.get(url);

	}

	// 5 navigate
	public void navigate(String url) {
		navigate(url);
	}

	// 6 windowMaximize
	public void windowMaximize() {
		driver.manage().window().maximize();
	}

	// 7 refreshPage
	public void refreshPage() {
		driver.navigate().refresh();

	}

	// 8 comeToBackPage

	public void comeToBackPage() {
		driver.navigate().back();

	}

	// 9 goToNextPage

	public void goToNextPage() {
		driver.navigate().forward();

	}

	// 10 navigateForward
	public void navigateForward() {
		driver.navigate().forward();
	}

	// 11 findElementById

	public WebElement findElementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	// 12 findElementByName
	public WebElement findElementByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	// 13 findElementByClassName
	public WebElement findElementByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

	// 14 findElementByXpath
	public WebElement findElementByXpath(String xpathexp) {
		WebElement element = driver.findElement(By.xpath(xpathexp));
		return element;

	}

	// findElementsByXpath

	public List<WebElement> findElementsByXpath(String xpathexp) {
		List<WebElement> findElements = driver.findElements(By.xpath(xpathexp));
		return findElements;

	}

	// 15 elementSendkeys
	public void elementSendkeys(WebElement element, String fileName, String sheetName, int rowNum, int cellNum)
			throws IOException {
		element.sendKeys(getCellDate(fileName, sheetName, rowNum, cellNum));
	}

	// 27 insertValueInTextBoxUingJs
	public void insertValueInTextBoxUingJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	// 16 elementClick
	public void elementClick(WebElement element) {
		element.click();
	}

	// 18 clickUingJs
	public void clickUingJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click", element);
	}

	// 17 clickOkAlert
	public void clickOkAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// 18 clickCancelAlert
	public void clickCancelAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// 19 switchToAlertValue
	public void switchToAlertValue(String data) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);

	}

	// 20 getTxtFromWebPage

	public String getTxtFromWebPage(WebElement element) {

		String text = element.getText();
		return text;
	}

	// 21 getInsertedValue
	public String getInsertedValue(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;

	}

	// 22 getTitle
	public String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	// 23 getCurrentUrl
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 24 selectOptionByText

	public void selectOptionByText(WebElement element, String fileName, String sheetName, int rowNum, int cellNum)
			throws IOException {
		select = new Select(element);
		select.selectByVisibleText(getCellDate(fileName, sheetName, rowNum, cellNum));
	}

	// 25 selectOptionByAttribute
	public void selectOptionByAttribute(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	// 26 selectOptionByIndex

	public void selectOptionByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	// 19 switchToChildWindow
	public void switchToChildWindow(String childwindow) {
		driver.switchTo().window(childwindow);

	}

	// 20 switchToFrameByIndex
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);

	}

	// 21 switchToFrameById
	public void switchToFrameById(String id) {
		driver.switchTo().frame(id);
	}

	// 22 returnToDefaultContent
	public void returnToDefaultContent() {
		driver.switchTo().defaultContent();

	}

	// 27 getElementAttributeValue
	public String getElementAttributeValue(WebElement element, String attributeName) {

		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	// 28 elementDoubleClick
	public void elementDoubleClick(WebElement element) {

		actions = new Actions(driver);
		actions.doubleClick(element).perform();

	}

	// 29 elementRightClick

	public void elementRightClick(WebElement element) {

		actions = new Actions(driver);
		actions.contextClick(element).perform();

	}

	// 30 dragAndDrop
	public void dragAndDrop(WebElement s, WebElement d) {

		actions = new Actions(driver);
		actions.dragAndDrop(s, d);

	}

	// 31 getProjectPath

	public String getProjectPath() {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		return path;
	}

	// 32 screenShotUrl

	public void screenShot(String fileName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File(getProjectPath() + "\\screenshots\\" + fileName + ".png");
		FileUtils.copyFile(s, d);
	}

	// 33 screenShotElement
	public void screenShot(String fileName, WebElement element) throws IOException {
		File s = element.getScreenshotAs(OutputType.FILE);
		File d = new File(getProjectPath() + "\\screenshots\\" + fileName + ".png");
		FileUtils.copyFile(s, d);
	}

	// 34 getAllOptions

	public List<WebElement> getAllOptions(WebElement element) {

		select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;

	}

	// 35 getAllSelectedOptions

	public List<WebElement> getAllSelectedOptions(WebElement element) {
		select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;

	}

	// 36 getAllSelectedOptionsAStext

	public List<String> getOptionsText(WebElement element) {
		select = new Select(element);
		List<String> listAllOptionText = new ArrayList<String>();
		List<WebElement> element1 = select.getOptions();
		for (WebElement eachwebElement : element1) {
			String text = eachwebElement.getText();
			listAllOptionText.add(text);
		}
		return listAllOptionText;

	}

	// 37 getFirstSelected
	public WebElement getFirstSelected(WebElement element) {

		select = new Select(element);
		WebElement firstSelected = select.getFirstSelectedOption();
		return firstSelected;

	}

	// 38 deSelectByIndex
	public void deSelectByIndex(WebElement element, int index) {
		select = new Select(element);
		select.deselectByIndex(index);

	}

	// 39 deSelectByValue
	public void deSelectByValue(WebElement element, String value) {

		select = new Select(element);
		select.deselectByValue(value);

	}

	// 40 deSelectedByVisibleText

	public void deSelectedByVisibleText(WebElement element, String text) {

		select = new Select(element);
		select.deselectByVisibleText(text);

	}

	// 44 isMultipleSelect

	public boolean isMultipleSelect(WebElement element) {

		select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;

	}

	// 45 isSelected

	public boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	// 46 isDisplayed

	public boolean isDisplayed(WebElement element) {

		boolean displayed = element.isDisplayed();
		return displayed;
	}

	// 47 isEnabled

	public boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;

	}

	// 48 insertValueAndEnter
	public WebElement insertValueAndEnter(String id, String data) {

		WebElement element = driver.findElement(By.id(id));
		element.sendKeys(data, Keys.ENTER);
		return element;
	}

	// 49 clearTheTextBox
	public void clearTheTextBox(String id) {
		WebElement element = driver.findElement(By.id(id));
		element.clear();
	}

	// 50 getAllWindowId

	public Set<String> clearTheTextBox() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	// 51 getParentWindowId

	public String getParentWindowId() {
		String parentWindowID = driver.getWindowHandle();
		return parentWindowID;
	}

	// 52 deSelectAll

	public void deSelectAll(String id) {
		WebElement element = driver.findElement(By.id(id));
		select = new Select(element);
		select.deselectAll();
	}

	// 56 readExcelData
	public void readExcelData(String bookName, String sheetName) throws IOException {

		File file = new File(getProjectPath() + "\\Excel Sheet\\" + bookName + ".xlsx");

		FileInputStream fileInputStream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(fileInputStream);

		Sheet sheet = workbook.getSheet(sheetName);

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

			Row row = sheet.getRow(i);

			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {

				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();

				switch (cellType) {
				case STRING:

					String value = cell.getStringCellValue();
					System.out.println(value);

					break;

				case NUMERIC:

					double d = cell.getNumericCellValue();
					long round = Math.round(d);

					if (d == round) {
						String n = String.valueOf(round);
						System.out.println(n);
					} else {
						String n = String.valueOf(d);
						System.out.println(n);
					}

					break;

				default:

					break;
				}
			}

		}
	}

	// 57 writeDateinExcel
	public void writeNewRow(String bookName, String sheetName, int rowNum, int cellNum, String data)
			throws IOException {

		File file = new File(getProjectPath() + "\\Excel Sheet\\" + bookName + ".xlsx");

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(inputStream);

		Sheet sheet = workbook.getSheet(sheetName);

		Row createRow = sheet.createRow(rowNum);

		Cell createCell = createRow.createCell(cellNum);

		createCell.setCellValue(data);

		FileOutputStream outputStream = new FileOutputStream(file);

		workbook.write(outputStream);

	}

	// Write in the cell

	public void insertCell(String fileName, String sheetName, int rowNum, int cellNum, String data)
			throws IOException {

		File file = new File(getProjectPath() + "\\Excel Sheet\\" + fileName + ".xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);

	}

	// 58 writeNewWorkbook
	public void writeNewWorkbook(String fileName, String sheetName, int rowNum, int cellNum, String data)
			throws IOException {

		File file = new File(getProjectPath() + "\\Excel Sheet\\" + fileName + ".xlsx");

		Workbook workbook = new XSSFWorkbook();

		Sheet createSheet = workbook.createSheet(sheetName);

		Row createRow = createSheet.createRow(rowNum);

		Cell createCell = createRow.createCell(cellNum);

		createCell.setCellValue(data);

		FileOutputStream outputStream = new FileOutputStream(file);

		workbook.write(outputStream);
	}

	// 59 updateCellData

	public void updateCellData(String fileName, String sheetName, int rowNum, int cellNum, String oldData,
			String newData) throws IOException {

		// ReWriting or Updating Particular Cell Data
		File file = new File(getProjectPath() + "\\Excel Sheet\\" + fileName + ".xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {

			cell.setCellValue(newData);

		}

		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);

	}

	// getCellDate
	public String getCellDate(String fileName, String sheetName, int rowNum, int cellNum) throws IOException {
		String res = "";
		File file = new File(getProjectPath() + "\\Excel Sheet\\" + fileName + ".xlsx");
		// create the object
		FileInputStream inputStream = new FileInputStream(file);

		// create the workbook
		Workbook workbook = new XSSFWorkbook(inputStream);
		// get the sheet
		Sheet sheet = workbook.getSheet(sheetName);
		// get the row
		Row row = sheet.getRow(rowNum);
		// get the cell
		Cell cell = row.getCell(cellNum);
		// get the cell type
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();

			break;
		case NUMERIC:
			double numericCellValue = cell.getNumericCellValue();
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("dd/mmm/yy");
				res = format.format(dateCellValue);

			} else {
				long round = Math.round(numericCellValue);
				if (numericCellValue == round) {
					res = String.valueOf(round);
				} else {
					res = String.valueOf(numericCellValue);

				}

			}

			break;
		default:
			break;
		}
		return res;

	}

	// updateCellData
	public void updateCellData1(String sheetName, String fileName, int rowNum, int cellNum, String oldData,
			String newData) throws IOException {

		File file = new File(getProjectPath() + "\\Excel Sheet\\" + fileName + ".xlsx");

		// create the object
		FileInputStream inputStream = new FileInputStream(file);

		// create the workbook
		Workbook workbook = new XSSFWorkbook(inputStream);

		// get the sheet
		Sheet sheet = workbook.getSheet(sheetName);

		// get the row
		Row row = sheet.getRow(rowNum);

		// get the cell
		Cell cell = row.getCell(cellNum);

		// getStringCellValue
		String value = cell.getStringCellValue();

		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}

		// saveInSameFile
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

	// insertValueInCell

	public void insertValueInCell(String fileName, String sheetName, int rowNum, int cellNum, String data)
			throws IOException {

		File file = new File(getProjectPath() + "\\Excel Sheet\\" + fileName + ".xlsx");

		// create the object
		FileInputStream inputStream = new FileInputStream(file);

		// create the workbook
		Workbook workbook = new XSSFWorkbook(inputStream);

		// get the sheet
		Sheet sheet = workbook.getSheet(sheetName);

		// get the row
		Row row = sheet.getRow(rowNum);

		// get the cell
		Cell cell = row.getCell(cellNum);

		// setCellValue
		cell.setCellValue(data);

		// saveInSameFile
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

	// closeAllWindows
	public void closeAllWindows() {
		driver.quit();
	}

	// closeCurrentWindow
	public void closeCurrentWindow() {
		driver.close();
	}

}
