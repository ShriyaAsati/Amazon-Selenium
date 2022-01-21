package testcases;

import java.io.File;  
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AmzonLoginPage;
import utilities.InitializeDriver;
import utilities.ReadExcel;



public class LoginTest extends InitializeDriver {

	AmzonLoginPage login;
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException
	{
		this.getBrowser();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		login=new AmzonLoginPage(driver);
	
	}
	
	
	@DataProvider(name="Amazon")
	public Object[][] getData() throws IOException
	{
		
	   String path="C:\\Users\\SASATI\\Desktop\\AmazonSprint2\\Book3.xlsx";
	   
	   ReadExcel x=new ReadExcel(path);
	   int totalRows=x.getRowCount("Sheet1");
	   int totalCols=x.getCellCount("Sheet1", 1);
	   
	   Object logindata[][]=new Object[totalRows][totalCols];
	   
	   System.out.println(totalRows);
	   System.out.println(totalCols);
	   
	   for(int i=1;i<=totalRows;i++)
	   {
		   for(int j=0;j<totalCols;j++)
		   {
			   logindata[i-1][j]=x.getCellData("Sheet1", i, j);
			   }
		   }
	   return logindata;
	   }
	
	
	@Test(dataProvider="Amazon")
    public void test_1(String email, String password, String searchbox ) throws InterruptedException, IOException
	{ 
		
		String url = this.getUrl();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//call the pageobjects
		AmzonLoginPage login = new AmzonLoginPage(driver);
		
		//Sign in 
		login.signin1().click();
		
		//enter email id
		login.email1().sendKeys(email);
		login.submit1().click();
		Thread.sleep(1000);
		
		//enter password and login in amazon page
		login.password1().sendKeys(password);
		login.signIn1().click();
		Thread.sleep(1000);
		
		//search the purse in search bar
		login.fieldkeywords1().sendKeys(searchbox);
		login.search1().click();
		login.purse1().click();
		Thread.sleep(1000);
		
		//window handler is used to change the window
		Set<String>win=driver.getWindowHandles();
		Iterator<String>it=win.iterator();
		it.next();
		String child=it.next();
		driver.switchTo().window(child);
		Thread.sleep(2000);
		
		//increase the quantity of product and add the cart
		login.quantity1();
		login.addtocart1().click();
		Thread.sleep(1000);
		
		//go to cart
		login.gotocart1().click();
		Thread.sleep(1000);
		
		//click the checkbox of this order contain the gift option and click to proceed 
		login.checkbox1().click();
		login.proceedtobuy1().click();
		Thread.sleep(1000);
		
		//click to the delivery address
		login.delivertothisaddress1().click();
		Thread.sleep(1000);
		
		//add the giftbag and go to the select a payment method
		login.savegiftoptions1().click();
		login.SelectAPaymentMethod().click();
		
		//screenshot of select a payment method
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./continue.png"));

	}
	
	@After
	public void teardown()
	{
		driver.close();
	}
	
	
	
}
