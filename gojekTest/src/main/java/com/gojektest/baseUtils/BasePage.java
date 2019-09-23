package com.gojektest.baseUtils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends FrameworkBase{
	protected WebDriver driver;
	 static String locator1;
	 static String updatedLoc;
	 By by;
	// constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;

	}

	public void safeClick(By locator) {
		final WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
	}

	public void safeType(By locator, String value) {
		final WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
	}

	public void clickByJavaScript(By locator) {
		driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(locator));
	}

	public void type(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public void waitForElementPresent(By locator) {
		final WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}

	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public By replaceValues(By locator, String... values) {
	    locator1 = locator.toString().split("By.xpath:")[1].trim();
	    for (int i = 0; i < values.length; ++i) {
	      // System.out.println(values[i]);
	      locator1 = locator1.replace("{" + (i + 1) + "}", values[i]);
	    }
	    by = By.xpath(locator1);
	    return by;
	  }
	
	public void selectValuesFromDrpDwn(By locator,String value){
		Select sel=new Select(driver.findElement(locator));
		sel.selectByVisibleText(value);
		waitForPage(2);
		
	}
	public String getSelectedValueFromDrpDwn(By locator){
		Select sel=new Select(driver.findElement(locator));
		return sel.getFirstSelectedOption().getText();
		
	}
	public String getText(By locator){
		return driver.findElement(locator).getText();
		
	}
	public void switchToFrame(String frameID) {
		
		driver.switchTo().frame(frameID);
		
	}
	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}
	
	public void switchToNewWindow() {
		driver.getWindowHandles().stream()
		.forEach(windowId -> driver.switchTo().window(windowId));

	}
	
	public void waitForPage(int sec){
		driver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);
	}
	
	public void wait(int sec){
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectCheckBox(By locator,boolean flag){
		if(true&&!driver.findElement(locator).isSelected())
		driver.findElement(locator).click();
		else
			driver.findElement(locator).click();
			log("Already Selcted");
	}
	
	
	
}
