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

public class HomePage extends CommonMethods{

public HomePage() {
		
		PageFactory.initElements(BaseClass.getDriver(), this);	
		
	}
	
	//Pawitri 06/28/22
	@FindBy(xpath = "/html/body/div[1]/div/ul[2]/li/a") public List<WebElement> yellowTabList;

	@FindBy(xpath = "//*[@id='js-labelHeadCart']/a") public WebElement cartIconButton;
	
	@FindBy(xpath = "/html/body/div[1]/div/ul[2]/li[1]/ul/li") public List<WebElement> categoryList;
	
	
	
	
	
	
	public void checkHomePageURL () {
		String currentURL = BaseClass.getDriver().getCurrentUrl();
	Assert.assertTrue(currentURL.equals(BaseClass.getPropertyString("homePageURL")));
	}
	
	
	public void clickCartButtonFromEachPageAndVerifyIfInCart () {
	
	for(int i = 0; i < yellowTabList.size();i++) {
			
			yellowTabList.get(i).click();
			
			cartIconButton.click();
			CommonMethods.waitForVisibility(c.cartProcessTab);
			
			Assert.assertTrue(c.cartProcessTab.isDisplayed());
			
			//BaseClass.getDriver().navigate().refresh();
			c.gearBestLogoCartPage.click();
			
		}
	}
	
	public void clickOnTheCategoryTab() {
		
		CommonMethods.clickSpecificElementInListByText(categoryList, BaseClass.getPropertyString("chosenTab"));
	}


	
	//Sumetta 06/28/22
	
	@FindBy(xpath = "/html/body/div[1]/div/ul[1]/li[4]") public WebElement languageButton;

	@FindBy(xpath = "//*[@id=\":0.targetLanguage\"]/span/a") public WebElement googleLanguageButton;
	
	@FindBy(xpath = "//*[@id=\":1.menuBody\"]/table/tbody/tr/td/a/div/span[2]")
	public List <WebElement> languageList;
	
	@FindBy(xpath = "//*[@id=\"js-panelIndexRecom\"]/div") public List <WebElement> productOnHomePageList;
	
	@FindBy(xpath = "//*[@id=\"js-panelHeadCurrency\"]")public WebElement currencyDropDownBox;
	
	@FindBy (xpath = "//*[@id=\"js-panelHeadCurrency\"]/ul/li") public List<WebElement> currencyList;
	
	@FindBy(xpath = "//*[@id=\"js-labelShipTo\"]") public WebElement shipToButton;

	@FindBy(xpath = "//*[@id=\"js-labelShipTo\"]/span[2]")public WebElement currencyShow;
	
	@FindBy(xpath = "//*[@id=\"siteWrap\"]/div[1]/div[1]/div/header[2]/div[1]/div/div/div")
	public WebElement eachPageCategoryHeader;
	
	@FindBy (xpath = "/html/body/div[1]/div/ul[2]/li[1]/span") public  WebElement categoryButton;
	
	@FindBy(xpath = "//*[@id=\"siteWrap\"]/div/div[1]/div/div/div[1]/h1") public  WebElement promotionBanner;
	
	@FindBy(xpath = "/html/body/iframe[2]") public WebElement googleFrame;
	
	@FindBy (xpath = "/html/body/div[2]/div/ul[2]/li[2]/a/font/font")public WebElement changedLanguageHeader;
	

	
	
	
}// class
