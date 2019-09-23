package com.midTrans.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.gojektest.baseUtils.BasePage;

public class BuynowPage extends BasePage{
	
	public BuynowPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Locators
	 */
	public By buyNowBtn=By.linkText("BUY NOW");
	public By lblPrice=By.xpath("//div[@class='price']/span[2]");
	public By chkoutamount=By.className("amount");
	public By btnCheckout=By.xpath("//div[text()='CHECKOUT']");
	public By itemNameSummary=By.xpath("//span[@class='item-name']");
	public By itemPriceSummary=By.xpath("//td[span[@class='item-name']]/following-sibling::td");
	public By btnContinue=By.className("//div[@class='sprite btn-main-next']");
	public By optCreditCard=By.xpath("//div[text()='Credit Card']");
	public By txtCardNum=By.name("cardnumber");
	public By txtExpDate=By.xpath("//input[@type='tel' and @placeholder='MM / YY']");
	public By txtCVV=By.xpath("//label[text()='CVV']/../input");
	public By btnPayNow=By.xpath("//span[text()='Pay Now']");
	public By txtOtp=By.name("PaRes");
	public By btnOK=By.name("ok");
	
	
	/**
	 * Methods
	 */
	public void clickBuyNowBtn() {
		log("Clicking on Buy Now Button");
		safeClick(buyNowBtn);
		log("clicked on buyNow Button");
		
	}
	
	
	public void clickbtnCheckout() {
		log("Clicking on checkout Button");
		safeClick(btnCheckout);
		log("clicked on checkout Button");
		
	}
	
	
	public void clickbtnContinue() {
		
		log("Clicking on continue Button");
			switchToFrame("snap-midtrans");
		//driver.switchTo().frame(0);
		//safeClick(btnContinue);
			clickByJavaScript(btnContinue);
		log("clicked on continue Button");
		
	}
	
	
	public void selectCreditCard() {
		log("selecting credit Card");
		safeClick(optCreditCard);
		log("Selected credit card");
	}
	
	
	public BuynowPage typeCardNum(String cardNum) {
		log("Entering the card number");
		safeType(txtCardNum, cardNum);
		return this;
		
	}
	
	
	public BuynowPage typeExpDate(String expDate) {
		log("Entering the exp number");
		safeType(txtExpDate, expDate);
		return this;
	}
	
	public BuynowPage typeCvv(String cvv) {
		log("Entering the CVV number");
		safeType(txtCVV, cvv);
		return this;
		
	}
	
	public BuynowPage clickPayNow() {
		log("Clicking on PayNow Button");
		clickByJavaScript(btnPayNow);
		return this;
		
	}
	
	
	public void enterOtp(String pwd) {
		
		try {
			log("Entering the password");
			safeType(txtOtp, pwd);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void clickOk() {
		log("Clicking on OK Button");
		safeClick(btnOK);
		
	}
	
	
	
}
