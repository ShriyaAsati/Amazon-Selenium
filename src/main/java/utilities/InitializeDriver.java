package utilities;

import java.io.FileInputStream;   
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class InitializeDriver {
	  
	 //public is used to global the WebDriver
	 public WebDriver driver;
		
	 //Read the data file 
	 String readDataFile(String data) throws IOException 
	  {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\SASATI\\eclipse-workspace\\AmazonSprint21\\data.properties");
		//This file use to load data in the file
		prop.load(fis);
		return prop.getProperty(data);
		
	}
		 
	//Call URL to the readDataFile	 
	public String getUrl() throws IOException
	{
		return this.readDataFile("url");
	}
	
	//Call browser to the readDataFile
	public void getBrowser() throws IOException
	{
		String browserName= this.readDataFile("browser") ;
		if(browserName. equals("chrome"))
		{
			//To define the path of that chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SASATI\\Desktop\\Java&Selenium Training\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else
		{
			//To define the path of that Firefox driver
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\SASATI\\Desktop\\Java&Selenium Training\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
	}
}
