package tasks_tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common_tests.basetest;

public class task_verification extends basetest {

	@Test(priority=2)
	public void createtask()
	{
		driver.findElement(By.xpath("//*[@id=\"topnav\"]/tbody/tr[1]/td[4]/a/div[2]")).click();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"topnav\"]/tbody/tr[1]/td[4]/a/div[2]")))).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class=\"dropdownContainer addNewMenu\"]//div[3]")));

		 wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div[1]"))));
		 js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div[1]")));
		 js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//div[@class=\"searchItemList\"])[15]//div[4]")));

		driver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[3]/td[1]/div/div/div[1]")).click();
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[text()=\"Android prototyping\"]")));
		
		driver.findElement(By.xpath("//div[@class=\"taskTableContainer\"]//tbody/tr[1]/td[1]/input")).sendKeys("task1");
		driver.findElement(By.xpath("//div[@class=\"components_button_label\" and text()=\"Create Tasks\"]")).click();
	
	      //alertIsPresent() condition applied
		try 
		{ 
		   driver.switchTo().alert();
		    System.out.println(" Alert Present");
		}  
		catch (NoAlertPresentException e) 
		{ 
		    System.out.println("No Alert Present");
		}    
		
		
		
		
	}
	

}
