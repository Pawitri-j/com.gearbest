package pageFactory;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

public class CartPage extends CommonMethods {

	public CartPage() {
		
		PageFactory.initElements(BaseClass.getDriver(), this);	
		
	}
	
	//Pawitri 06/28/22
	@FindBy(xpath = "//*[@id='siteWrap']/div/nav/ul")public WebElement cartProcessTab;
	
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div/div/div/div/div/div/div/div/div/div/input")
	public WebElement quantityBox;
	//*[@id='siteWrap']/div/div/div[1]/div/div[2]/div/div[2]/div/div/div[3]/div/div/input
	
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div/div/div/div/div/div/div/div/div/div/input")
	public List<WebElement> quantityBoxList;
	//*[@id='siteWrap']/div/div/div[1]/div/div[2]/div/div[2]/div/div/div[3]/div/div/input
	
	@FindBy(xpath = "//*[@id=\"siteWrap\"]/header/div/a/img") 
	public WebElement gearBestLogoCartPage;
	
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div/div/div/p") 
	public WebElement cartEmptyMsg;
	//*[@id=\"siteWrap\"]/div/div/div[1]/div/div[1]/p
	
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div/div/div/a[2]") 
	public WebElement goShoppingButton;
	//*[@id='siteWrap']/div/div/div[1]/div/div[1]/a[2]
	
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div/div/div/div/a[1]") 
	public WebElement deleteButton;
	//*[@id='siteWrap']/div/div/div[1]/div/div[2]/div/a[1]
	
	@FindBy(xpath = "//*[@id='kDialog_171201']/div/div/div/a[1]") 
	public WebElement confirmDeleteButton;
	//*[@id='kDialog_171201']/div[2]/div/div[2]/a[1]
	
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div[1]/div/div[2]/div/div[2]/div/div/div[2]/p[1]") 
	public WebElement unitPrice;
	
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div[1]/div/div[2]/div/div[2]/div/div/div[2]/p[1]") 
	public List<WebElement> unitPriceList;
	
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div[1]/div/div[2]/div/div[2]/div/div/div[4]/p") 
	public WebElement subTotalPrice;
	
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div[1]/div/div[2]/div/div[2]/div/div/div[4]/p") 
	public List<WebElement> subTotalPriceList;
	
	
	public void inputQuantity(WebElement quantityBox, String quantity ) {
		
		waitForVisibility(quantityBox);
		quantityBox.sendKeys(Keys.BACK_SPACE);
		
		quantityBox.sendKeys(quantity);
		quantityBox.sendKeys(Keys.ENTER);
	}
	
	
	public void checkQuantityByPrice(WebElement unitPrice, WebElement subTotalPrice) {
		
		BaseClass.getDriver().navigate().refresh();
		String unitPriceStr = unitPrice.getText().substring(1);
		System.out.println(unitPriceStr);
		Double unitPriceDouble =Double.parseDouble(unitPriceStr);
		
		String subTotalStr = subTotalPrice.getText().substring(1);
		System.out.println(subTotalStr);
		Double subTotalDouble = Double.parseDouble(subTotalStr);
		
		Double totalDouble = (unitPriceDouble*BaseClass.getPropertyDouble("quantity"));
		
		boolean checkPrice = ( totalDouble == subTotalDouble || totalDouble+0.05 >= subTotalDouble && totalDouble-0.05 <= totalDouble );
				
		System.out.println(unitPriceDouble*BaseClass.getPropertyDouble("quantity"));
		Assert.assertTrue(checkPrice);
	}
	
	
	
	
	
	public void clickGoShoppingButton() {
		
		Assert.assertTrue(goShoppingButton.isDisplayed());
		goShoppingButton.click();
	}
	
	
	
	
}//class
