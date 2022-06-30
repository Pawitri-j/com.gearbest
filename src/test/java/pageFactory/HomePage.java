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
	@FindBy(xpath="//input[@id='js-iptKeyword']")public  WebElement searchInput;
	@FindBy(xpath="//div[@class='siteSearch_suggestion']")public static List<WebElement> searchSuggestionsList;
	@FindBy(xpath="//div[@class='select_menu dropdown_menu']")public static List<WebElement> allDropDownSearchList;
	@FindBy(xpath="//div[@class='cateMain_cateWord']")public static List<WebElement> searchWordMatching;
	@FindBy(xpath="//div[@class='cateMain_cateWord']")public static WebElement searchAllTitle;
	@FindBy(xpath="//h1[@class='cateMain_searchMsg']")public static WebElement searchItemNameVerification;
	@FindBy(xpath="//div[normalize-space()='Drones, Toys & Hobbies']")public  WebElement searchAllOptionHeader;

	
	//Scenario 1 Maria  //
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
	///Scenario 2 <Maria///
	public void clickingSearchallBtn() {
		allDropDownsearchBTN.click();
	}


	String SearchAllCategoriesText;
	public void searchByAllButtonListOptions()  {

		for(int i=0;i<allDropDownSearchList.size();i++) {
			allDropDownsearchBTN.click();
			SearchAllCategoriesText=allDropDownSearchList.get(i).getText();

			System.out.println("SearchAllTextCategory= "+ SearchAllCategoriesText);

			if(SearchAllCategoriesText.contains(CommonMethods.getPropertyString("searchAllListoption"))) {
			CommonMethods.click(allDropDownSearchList.get(i));
			searchIcon.click();
			//System.out.println("departmennnnnnnn");
//Assert.assertTrue(searchAllOptionHeader.isDisplayed());
		}}
	}

							///Scenario 3 maria ////
	public void searchByItemName() {

		CommonMethods.sendText(searchInput,BaseClass.getPropertyString("searchItemName") );
	}
	public void clickSearchIcon() {
		searchIcon.click();
	}
	public void verifyItemsPage() {
		//Assert.assertEquals(searchItemNameVerification, BaseClass.getPropertyString("searchItemName"));
		String searchResultText = "";

		try {
			searchResultText =searchItemNameVerification.getText();
			if (searchResultText.contains(BaseClass.getPropertyString("searchItemName"))
					&& searchResultText.contains(BaseClass.getPropertyString("searchItemNameVerification"))) {
				Assert.assertTrue(searchResultText.contains(BaseClass.getPropertyString("matchingSearchResult")));
				Assert.assertTrue(searchResultText.contains(BaseClass.getPropertyString("searchItemName")));
			}

		} catch (Exception e) {
			e.printStackTrace();

			System.out.println(BaseClass.getPropertyString("notMatchingResult"));


		}


	}
								/// //maria/////

	

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


	//Armeena 06/29/22

	@FindBy(xpath="//*[@id='js-siteFooterSub']/div/a[1]")
	public WebElement faceBookIcon;

	@FindBy(xpath="//*[@id='js-siteFooterSub']/div")
	public List<WebElement> socialMediaButtonsList;

	@FindBy(xpath="//*[@id=\"js-siteFooter\"]/div[4]/dl[1]/dd[1]/a")
	public WebElement aboutUsIcon;

	@FindBy(xpath="//*[@id=\"js-siteFooter\"]/div[4]/dl[1]/dd/a")
	public List<WebElement> companyInformationLists;


	public void yellowBannerTabsNavigate () {

		String homePageURL;
		String currentTabURL;

		for(int i = 0; i < yellowTabList.size();i++) {

			homePageURL = BaseClass.getDriver().getCurrentUrl();
			yellowTabList.get(i).click();

			currentTabURL = BaseClass.getDriver().getCurrentUrl();
			Assert.assertTrue(homePageURL.equals(currentTabURL));

		}
	}

	public void socialMediaButtonsAreClickableAndNavigate() {

		String homePageURL;
		String currentTabURL;

		for(int i = 0; i < socialMediaButtonsList.size();i++) {

			homePageURL = BaseClass.getDriver().getCurrentUrl();
			socialMediaButtonsList.get(i).click();

			currentTabURL = BaseClass.getDriver().getCurrentUrl();
			Assert.assertTrue(homePageURL.equals(currentTabURL));

		}

	}

	public void companyInformationLinksNavigate() {

		String homePageURL;
		String currentTabURL;

		for(int i = 0; i < companyInformationLists.size();i++) {

			homePageURL = BaseClass.getDriver().getCurrentUrl();
			companyInformationLists.get(i).click();

			currentTabURL = BaseClass.getDriver().getCurrentUrl();
			Assert.assertTrue(homePageURL.equals(currentTabURL));

		}
	}
	
	
	
	
	
									//maria//

///////////////////////////////////////////////////////////////////////////////////////////////////
	// Alip

}// class
