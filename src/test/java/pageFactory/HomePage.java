package pageFactory;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
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

										//maria//

	@FindBy(xpath="//button[@id='js-btnSubmitSearch']")public static WebElement searchIcon;
	@FindBy(xpath="//div[@class='select_toggle dropdown_toggle']")public static WebElement allDropDownsearchBTN;
	@FindBy(xpath="//input[@id='js-iptKeyword']")public static WebElement searchInput;
	@FindBy(xpath="//div[@class='siteSearch_suggestion']")public static List<WebElement> searchSuggestionsList;
	@FindBy(xpath="//div[@class='select_menu dropdown_menu']")public static List<WebElement> allDropDownSearchList;
	@FindBy(xpath="//div[@class='cateMain_cateWord']")public static List<WebElement> searchWordMatching;
	@FindBy(xpath="//div[@class='searchTitle_wrap']")public static WebElement searchAllTitle;

	
	public void searchByWord() {
		CommonMethods.sendText(searchInput,BaseClass.getPropertyString("searchItem") );
	}
	
	public void searchWordInputSuggestionList() {
		try {
		
	
			for (int i = 0; i < searchSuggestionsList.size(); i++) {
			 System.out.println(searchSuggestionsList.get(i).getText());
			Assert.assertTrue(searchSuggestionsList.get(i).getText().contains(BaseClass.getPropertyString("searchItem")));
		}
		} catch (StaleElementReferenceException e) { 
			// because the suggestion list will come up and then gone for
			// non-matching word
e.printStackTrace();
System.out.println(BaseClass.getPropertyString("warning message"));
}	
		}
	
	public void clickingSearchallBtn() {
		allDropDownsearchBTN.click();
	}
	String SearchAllCategoriesText;
	public void searchByAllButtonListOptions()  {
		
		for(int i=0;i<allDropDownSearchList.size();i++) {
			allDropDownsearchBTN.click();
			SearchAllCategoriesText=allDropDownSearchList.get(i).getText();
			
			System.out.println("SearchAllTextCategory= "+ SearchAllCategoriesText);
			
			
			CommonMethods.click(allDropDownSearchList.get(i));
			searchIcon.click();
			System.out.println("departmennnnnnnn");
		}
	}
	public void searchTitleverification() {
		waitForVisibility(searchAllTitle);
		if(SearchAllCategoriesText.equals(searchAllTitle) ) {
			//Assert.assertTrue(SearchAllCategoriesText, searchAllTitle);
			
			Assert.assertTrue(searchAllTitle.isDisplayed());
		}else {
			// User should be navigated to the category  being tested
			System.out.println("please click the category again");
		}
	}
	
	
									//maria//
}// class
