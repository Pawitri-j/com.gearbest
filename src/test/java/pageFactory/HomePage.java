package pageFactory;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

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


	
	
}// class
