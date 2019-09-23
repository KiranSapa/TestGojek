package goJek.gojekTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.gojektest.baseUtils.BaseTest;
import com.midTrans.pages.BuynowPage;

public class PillowPurchase  extends BaseTest{
	
	 BuynowPage buynowPage;
	 SoftAssert softAssert;
	
	
	
	@Test(dataProvider="Test Data")
	public void testPillowPurchaseE2E(String cardnum,String expiry,String cvv,String otp,String txnStatus) {
		softAssert=new SoftAssert();
		buynowPage=new BuynowPage(driver);
	
		log("Action:Verify");
		AssertJUnit.assertTrue(isElementPresent(buynowPage.lblPrice));
		String price=buynowPage.getText(buynowPage.lblPrice);
		log("Price on Buy now page:"+price);
		log("Action:click");
		buynowPage.clickBuyNowBtn();
		log("Action:Verify");
		AssertJUnit.assertEquals(buynowPage.getText(buynowPage.chkoutamount), price);
		log("Action:click");
		buynowPage.clickbtnCheckout();
		log("Action:click");
		buynowPage.clickbtnContinue();
		log("Selecting Credit Card");
		buynowPage.selectCreditCard();
		log("Entering Card Details");
		buynowPage.typeCardNum(cardnum).typeExpDate(expiry).typeCvv(cvv)
		.clickPayNow();
		log("Entering the OTP");
		buynowPage.enterOtp(otp);
		log("Validating the Transaction status");
		String transactionMessage=buynowPage.getText(buynowPage.lblPrice);
		AssertJUnit.assertEquals(transactionMessage, txnStatus);
		softAssert.assertAll();
		
		
	}
	

	
	@DataProvider(name="Test Data")
	public Object[][] getTestData(){
		return new Object[][] {{"4811 1111 1111 1114","02/20","123","112233","Transaction Successful"},
		{"4811 1111 1111 1113","02/20","123","112233","Transaction Failed"}};
				
	}
	
	
	
	
	
}
