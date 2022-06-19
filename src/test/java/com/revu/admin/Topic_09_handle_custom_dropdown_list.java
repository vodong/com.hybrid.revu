package com.revu.admin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_handle_custom_dropdown_list {
	WebDriver driver;
	WebDriverWait expilictwait;
	JavascriptExecutor jsexecutor;
	String projectPath = System.getProperty("user.dir");
	String emailaddress, password;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserdrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		expilictwait = new WebDriverWait(driver,15);
		
		jsexecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		emailaddress = "supermanager_ED@yopmail.com";
		password = "123456";
		
	}
 
	@Test
	public void TC_01() {
		driver.get("https://admin.test.ent.revu.net/login?redirect=%2F");
		
		driver.findElement(By.xpath("//a[@class='ng-binding' and @ng-click='statusFormLogin()']")).click();
		
		driver.findElement(By.cssSelector("form.ng-valid ul.mr-20")).click();
		sleepInsecond(5);
		
		driver.findElement(By.xpath("//form[@name='partnerForm']//ul[@class='dropdown-menu']//a[contains(.,'Korea')]")).click();
		sleepInsecond(2);
		
		driver.findElement(By.xpath("//input[@ng-model='login.email']")).sendKeys(emailaddress);
		driver.findElement(By.xpath("//input[@ng-model='login.password']")).sendKeys(password);
		sleepInsecond(5);
	}

//	public void selectitemindropdownlist (String parentlocator, String childlocator, String Expectecttextitem) {
//		
//		//Step 1: Click vào 1 Element cho nó xổ hết ra các item
//		// write xpath
////		driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s']")).click();
//		
//		// write CSS
//		driver.findElement(By.cssSelector(parentlocator)).click();
//		sleepInsecond(2);
//		
//		//Step 2: chờ cho các item load hết ra thành công (Locator chứa hết tất cả các item)
//		// lưu ý 1: Các locator chứa hết tất cả các item
//		// lưu ý 2: Locator phải đến node cuối cùng chứa text
//		expilictwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childlocator)));
//		
//		//Step 3: Tìm item cần chọn
//		
//		// Lấy hết tất cả element ra sau khi duyệt qua từng item
//		List <WebElement> allitems =  driver.findElements(By.cssSelector(childlocator));
//
//		for (WebElement item : allitems) {
//			String Actualtext = item.getText();
//			System.out.println("Actual text=" + Actualtext);
//
//			if(Actualtext.equals(Expectecttextitem)) {
//
//				jsexecutor.executeScript("arguments[0].scrollIntoView(true);", item);
//				item.click();	
//				break;
//				}
//			}
//		}
				
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
 

	public void sleepInsecond (long second) {
		try {
			Thread.sleep(second *1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
