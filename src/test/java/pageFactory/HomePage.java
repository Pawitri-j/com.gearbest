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




	

	//Maria 
	@FindBy(xpath="//button[@id='js-btnSubmitSearch']")public WebElement searchIcon;
	@FindBy(xpath="//div[@class='select_toggle dropdown_toggle']")public  WebElement allDropDownsearchBTN;
	@FindBy(xpath="//input[@id='js-iptKeyword']")public  WebElement searchInput;
	@FindBy(xpath="//div[@class='siteSearch_suggestion']")public  List<WebElement> searchSuggestionsList;
	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/div/div/div/div/div[2]/div/div/div")public  List<WebElement> allDropDownSearchList;
	@FindBy(xpath="//div[@class='cateMain_cateWord']")public  List<WebElement> searchWordMatching;
	@FindBy(xpath="//div[@class='cateMain_cateWord']")public  WebElement searchAllTitle;
	@FindBy(xpath="//h1[@class='cateMain_searchMsg']")public  WebElement searchItemNameVerification;
	@FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/div/div/div/div[1]") public  WebElement AllButton;
	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div[1]/div/header[1]/div/div/ol")public  WebElement categoryHeader;
	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div/div[1]/p[1]") public WebElement notMatchingMsg;
	public void searchByWord() {
		CommonMethods.sendText(searchInput,BaseClass.getPropertyString("searchItem") );
	}


	//Sumetta 06/28/22

	@FindBy(xpath = "/html/body/div[1]/div/ul[1]/li[4]/span") public WebElement languageButton;

	@FindBy(xpath = "//*[@id=':0.targetLanguage']/span") public WebElement googleLanguageButton;

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

	@FindBy(xpath="//*[@id='js-siteFooterSub']/div/a/i")
	public List<WebElement> socialMediaButtonsList;

	@FindBy(xpath="//*[@id='js-siteFooter']/div[4]/dl[1]/dd/a")
	public List<WebElement> companyInformationList;
	
	@FindBy (xpath="//*[@id='siteWrap']/div/ul/li[2]")
	public WebElement companyInfoHeader;
	
	@FindBy(xpath="//*[@id='siteWrap']/div[1]/section/header")
	public WebElement topBrandsPage;
	
	@FindBy(xpath="/html/body/div[1]/section[2]/div/section[1]/h3")
	public WebElement blogHeader;
	
	@FindBy(xpath="//*[@id=\"js-siteFooterSub\"]/div")
	public WebElement socialMediaTab;
	

	
	
	
	
	


}// class
