package pageFactory;

import java.util.ArrayList;
import java.util.Arrays;
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




	

	//Maria 

	@FindBy(xpath="//button[@id='js-btnSubmitSearch']")public WebElement searchIcon;
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
	///Scenario 2 Maria//
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

	@FindBy(xpath = "//*[@id=':0.targetLanguage']/span/a") public WebElement googleLanguageButton;

	@FindBy(xpath = "//*[@id=':1.menuBody']/table/tbody/tr/td/a/div/span[2]")
	public List <WebElement> languageList;

	@FindBy(xpath = "//*[@id='js-panelIndexRecom']/div") public List <WebElement> productOnHomePageList;

	@FindBy(xpath = "//*[@id='js-panelHeadCurrency']")public WebElement currencyDropDownBox;

	@FindBy (xpath = "//*[@id='js-panelHeadCurrency']/ul/li") public List<WebElement> currencyList;

	@FindBy(xpath = "//*[@id='js-labelShipTo']") public WebElement shipToButton;

	@FindBy(xpath = "//*[@id='js-labelShipTo']/span[2]")public WebElement currencyShow;

	
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div/header/div/div/div/div")
	public WebElement eachPageCategoryHeader;
	//*[@id='siteWrap']/div[1]/div[1]/div/header[2]/div[1]/div/div/div

	@FindBy (xpath = "/html/body/div[1]/div/ul[2]/li/span") public  WebElement categoryButton;
	//     /html/body/div[1]/div/ul[2]/li[1]/span
	
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div/div/div/h1") public  WebElement promotionBanner;
	//*[@id='siteWrap']/div/div[1]/div/div/div[1]/h1
	
	@FindBy(xpath = "/html/body/iframe[2]") public WebElement googleFrame;

	@FindBy (xpath = "/html/body/div[2]/div/ul[2]/li[2]/a/font/font")public WebElement changedLanguageHeader;


	//Armeena 06/29/22

	@FindBy(xpath="//*[@id='js-siteFooterSub']/div/a[1]")
	public WebElement faceBookIcon;

	@FindBy(xpath="//*[@id='js-siteFooterSub']/div/a")
	public List<WebElement> socialMediaButtonsList;

	@FindBy(xpath="//*[@id='js-siteFooter']/div[4]/dl[1]/dd/a")
	public List<WebElement> companyInformationList;
	
	@FindBy (xpath="//*[@id='siteWrap']/div/ul/li[2]")
	public WebElement companyInfoHeader;
	
	@FindBy(xpath="//*[@id='siteWrap']/div[1]/section/header")
	public WebElement topBrandsPage;
	
	@FindBy(xpath="/html/body/div[1]/section[2]/div/section[1]/h3")
	public WebElement blogHeader;
	

	public void yellowBannerTabsNavigate () {

//		ArrayList<String>yellowBanner = new ArrayList<>
//		(Arrays.asList("SUPER DEALS", "APP ONLY", "NEW ARRIVALS"));
//		
//		for(int i = 0; i < yellowTabList.size();i++) {
//			System.out.println(yellowTabList.get(i).getText());
//			yellowTabList.get(i).click();
//		Assert.assertTrue(yellowTabList.get(i).getText().contains(yellowBanner.get(i)));
//		
//		}
	}

	public void socialMediaButtonsAreClickableAndNavigate() {

//		
//		ArrayList<String>socialMediasBanner = new ArrayList<>
//		(Arrays.asList("facebook","messenger","youtube","pinterest","vk","instragram","twitter","blog","tumblr"));
//		
//		for(int i = 0; i < socialMediaButtonsList.size();i++) {
//			System.out.println(socialMediaButtonsList.get(i).getText());
//			
//			Assert.assertTrue(socialMediaButtonsList.get(i).getText().contains(socialMediasBanner.get(i)));
//			
//			BaseClass.getDriver().navigate().back();
//		}
		
	}	
		


	public void companyInformationLinksNavigate() {

			for(int i = 0; i < companyInformationList.size();i++) {

			companyInformationList.get(i).click();

			Assert.assertTrue(companyInformationList.get(i).getText().equalsIgnoreCase(companyInfoHeader.getText()));

			BaseClass.getDriver().navigate().back();
		}
	}
	
	
	
	
	


}// class
