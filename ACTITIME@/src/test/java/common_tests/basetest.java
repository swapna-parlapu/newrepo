package common_tests;

import java.time.Duration;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import common_pages.Basepage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest extends Basepage {
Basepage basepage;
	
	@Test(priority=0)
	public void login_to_app()
	{
		basepage=new Basepage();

		basepage.openbrowser();

		basepage.openapp("https://online.actitime.com/cisco8/login.do");

		basepage.login("parlapuswapna@gmail.com","WHtMGu@Z");
	}
	@Test(priority=3)
	public void logout()
	{
		basepage.logoutandclose();
		}
	
	
}
