package pageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;
import utilities.Constants;

public class CartPage extends CommonMethods {

	public CartPage() {
		
		PageFactory.initElements(BaseClass.getDriver(), this);	
		
	}
	
	//Pawitri 06/28/22
	@FindBy(xpath = "//*[@id='siteWrap']/div/nav/ul")public WebElement cartProcessTab;
	
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div[1]/div/div[2]/div/div[2]/div/div/div[3]/div/div/input")
	public WebElement quantityBox;
	
	
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div[1]/div/div[2]/div/div[2]/div/div/div[3]/div/div/input")
	public List<WebElement> quantityBoxList;
	
	@FindBy(xpath = "//*[@id=\"siteWrap\"]/header/div/a/img") 
	public WebElement gearBestLogoCartPage;
	
	@FindBy(xpath = "//*[@id=\"siteWrap\"]/div/div/div[1]/div/div[1]/p") 
	public WebElement cartEmptyMsg;
	
	@FindBy(xpath = "//*[@id=\"siteWrap\"]/div/div/div[1]/div/div[1]/a[2]") 
	public WebElement goShoppingButton;
	
	@FindBy(xpath = "//*[@id=\"siteWrap\"]/div/div/div[1]/div/div[2]/div/a[1]") 
	public WebElement deleteButton;
	
	@FindBy(xpath = "//*[@id=\"kDialog_171201\"]/div[2]/div/div[2]/a[1]") 
	public WebElement confirmDeleteButton;
	
	
	public void checkIfCartisEmpty() {
		
		try {
			if (c.deleteButton.isDisplayed()) {
				c.deleteButton.click();
				c.confirmDeleteButton.click();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		CommonMethods.waitForVisibility(cartEmptyMsg);
		String cartEmptyText = c.cartEmptyMsg.getText();
		Assert.assertTrue(cartEmptyText.contains(BaseClass.getPropertyString("emptyCartMsg")));
	}
	
	
	public void clickGoShoppingButton() {
		
		Assert.assertTrue(c.goShoppingButton.isDisplayed());
		c.goShoppingButton.click();
	}
	
	
	
	
}//class
