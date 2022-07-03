package pageFactory;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

public class ProductPage extends CommonMethods {

	public ProductPage() {

		PageFactory.initElements(BaseClass.getDriver(), this);

	}

//Pawitri 06/28/22
	@FindBy(xpath = "//*[@id=\"siteWrap\"]/div[1]/div[1]/div/div[2]/ul/li")
	public List<WebElement> productList;

	@FindBy(xpath = "//*[@id='goodsDetail']/div[2]/div[1]/div[2]/div[5]/a[1]")
	public WebElement addToCartButton;
	
	
//Alip 06/29/22
	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div[1]/div/div[2]/ul/li/div/p[2]")
	public List<WebElement> productsPriceList;
	
	@FindBy(xpath = "//*[@id=\"siteWrap\"]/div/div/div/div/div/p/a  ")
	public List<WebElement> sortByButtonsList;
	
	
	@FindBy(xpath = "//*[@id='anchorGoodsDesc']/div/h2")
	public WebElement descriptionsInsideProduct;
	
	@FindBy(xpath = "//*[@id='js-navGoods']/div/ul/li[2]/a")
	public WebElement reviewsButtonInsideProduct;
	
	@FindBy(xpath = "//*[@id='anchorGoodsReviews']/h2")
	public WebElement reviewsInsideProduct;
	
	@FindBy(xpath = "//*[@id='filter-price-from']")
	public WebElement minBox;
	
	@FindBy(xpath = "//*[@id='filter-price-to']")
	public WebElement maxBox;
	
	@FindBy(xpath = "//*[@id=\"siteWrap\"]/div/div/div/div/div/div/div/div/div/a")
	public WebElement okButtonInMinMax;
	
	
	public void checkProductPageURL () {
		String currentURL = BaseClass.getDriver().getCurrentUrl();
	Assert.assertTrue(currentURL.contains(BaseClass.getPropertyString("productPageURL")));
	}
	
	
	
	

}// class