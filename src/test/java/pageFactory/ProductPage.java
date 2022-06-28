package pageFactory;

import java.util.List;

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
	
	
	
	
	
	
	
	
	

}// class
