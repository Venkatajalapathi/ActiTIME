package com.ActiTIME.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BaseTest implements IAutoConstants{
	FileLIB flib;
	public static WebDriver driver;
	public void openBrowser() throws Throwable
	{
		flib=new FileLIB();
		String browserValue=flib.getPropKeyValue(PROP_PATH,"browser");
		if(browserValue.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver=new ChromeDriver();
		}
		else if(browserValue.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY,GECKO_VALUE);
			driver=new FirefoxDriver();
		}
		else 
		{
			Reporter.log("Enter valid browser", true);
		}
		driver.manage().window().maximize();
		driver.get(flib.getPropKeyValue(PROP_PATH, "url"));

	}
	public void closBrowser()
	{
		driver.quit();

	}

}
