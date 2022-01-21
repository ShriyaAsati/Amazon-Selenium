package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AmzonLoginPage {
	
	
	  public WebDriver driver;
		
	    //locator
		By signin = By.id("nav-link-accountList");
	    By email = By.xpath("//*[@id='ap_email']");
		By submit = By.xpath("//*[contains(@class, 'a-button-input')]");
		By password = By.xpath("//*[@id='ap_password']");
		By signIn = By.id("signInSubmit");
		By fieldkeywords = By.id("twotabsearchtextbox");
		By search = By.xpath("//*[@id=\"nav-search-submit-button\"]");
		By purse = By.linkText("Handicraft Beautiful Bling Box Clutch Bag Purse For Bridal, Casual, Party, Wedding");
		By quantity = By.xpath("//*[@id='quantity']");
		By addtocart = By.xpath("//*[@id='add-to-cart-button']");
		By gotocart = By.xpath("//*[@id='sw-gtc']//*[contains(@class, 'a-button-text')]");
		By checkbox = By.xpath("//*[@id='sc-buy-box-gift-checkbox']");
		By proceedtobuy = By.xpath("//*[@name='proceedToRetailCheckout']");
		By delivertothisaddress = By.xpath("//*[@id='address-book-entry-0']//*[contains(@class, 'ship-to-this-address')]/span/a");
		By savegiftoptions = By.cssSelector("#giftOptions .a-span12 > div > div > span > span > input");
		By SelectAPaymentMethod = By.className("a-spacing-base");
		
		//constructor
		public AmzonLoginPage(WebDriver driver)
		{
			this.driver = driver;
			AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,10);
			PageFactory.initElements(driver, this);
		}
		
		//methods6
		public WebElement signin1()
		{
			return driver.findElement(signin);
		}
		
		public WebElement email1()
		{
			return driver.findElement(email);
		}
		
		public WebElement submit1()
		{
			return driver.findElement(submit);
		}
		
		public WebElement password1()
		{
			return driver.findElement(password);
		}
		
		public WebElement signIn1()
		{
			return driver.findElement(signIn);
		}
		
		public WebElement fieldkeywords1()
		{
			return driver.findElement(fieldkeywords);
		}
		
		public WebElement search1()
		{
			return driver.findElement(search);
		}
		
		public WebElement purse1()
		{
			return driver.findElement(purse);
		}
		
		public WebElement quantity1()
		{
			return driver.findElement(quantity);
		}
		
		public WebElement addtocart1()
		{
			return driver.findElement(addtocart);
		}
		
		public WebElement gotocart1()
		{
			return driver.findElement(gotocart);
		}
		
		public WebElement checkbox1()
		{
			return driver.findElement(checkbox);
		}
		
		public WebElement proceedtobuy1()
		{
			return driver.findElement(proceedtobuy);
		}
		
		public WebElement delivertothisaddress1()
		{
			return driver.findElement(delivertothisaddress);
		}
		
		public WebElement savegiftoptions1()
		{
			return driver.findElement(savegiftoptions);
		}
		
		public WebElement SelectAPaymentMethod()
		{
			return driver.findElement(SelectAPaymentMethod);
		}

}
