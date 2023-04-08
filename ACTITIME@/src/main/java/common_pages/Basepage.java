package common_pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage {
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public void openbrowser()
	{
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");

		 driver = new ChromeDriver(options);
	}
	public void openapp(String url)
	{
		driver.get(url);

	}
	public void login(String uname ,String pswd)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name=\"pwd\"]")).sendKeys(pswd);
		driver.findElement(By.xpath("//*[@id=\"keepLoggedInCheckBox\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"loginButton\"]/div")).click();
	}
	public void logoutandclose()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"logoutLink\"]"))));
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@id=\"logoutLink\"]")) );
		driver.close();
	}
}

