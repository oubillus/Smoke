package com.streame;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import junit.framework.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;




public class Smoke {
	  
private WebDriver driver;
private String baseUrl;
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer();

//Change Url to QA or Staging Environment
 @BeforeClass
 public void setUp() throws Exception {
// URL OF GECKODRIVER
System.setProperty("webdriver.chrome.driver","C:\\Users\\dmarroquin\\Documents\\QA\\Selenium_tools\\chromedriver.exe" );
 driver = new ChromeDriver();
 baseUrl = "http://qa.streame.com";
 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 }
//Login + Registration 
 @Test
  public void Streame_smoke() throws Exception {
	 driver.get(baseUrl + "/playground");
  Thread.sleep(2000);
  //Security  password
  Alert alert=driver.switchTo().alert();
  driver.switchTo().alert().sendKeys("v*2$5X0e41US");
  alert.accept();
  assertTrue(isElementPresent(By.cssSelector("img[alt=\"Streame logo\"]")));
  Thread.sleep(2000);
  assertTrue(isElementPresent(By.linkText("DISCOVER")));
  assertEquals(driver.findElement(By.linkText("DISCOVER")).getText(), "DISCOVER");
  assertTrue(isElementPresent(By.id("navbar-comp__langMenu")));
  assertTrue(isElementPresent(By.cssSelector("option[value=\"en\"]")));
  //assertEquals(driver.findElement(By.cssSelector("option[value=\"en\"]")).getText(),"en");
  assertTrue(isElementPresent(By.cssSelector("option[value=\"es\"]")));
  //assertEquals(driver.findElement(By.cssSelector("option[value=\"es\"]")).getText(),"es");
  assertTrue(isElementPresent(By.id("navbar-comp__login-link")));
  assertEquals(driver.findElement(By.id("navbar-comp__login-link")).getText(), "SIGN IN");
  assertTrue(isElementPresent(By.id("navbar-comp__register-link")));
  assertEquals(driver.findElement(By.id("navbar-comp__register-link")).getText(), "CREATE ACCOUNT");
  assertTrue(isElementPresent(By.cssSelector("img[alt=\"LeeHowell.jpg\"]")));
  assertEquals(driver.findElement(By.cssSelector("h1.col-sm-12.favorites-title")).getText(), "My Latest Favorites");
  driver.findElement(By.cssSelector("option[value=\"en\"]")).click();
  Thread.sleep(1000);
  /*assertEquals(driver.findElement(By.id("navbar-comp__login-link")).getText(), "INGRESAR");
  assertEquals(driver.findElement(By.id("navbar-comp__register-link")).getText(), "CREAR CUENTA");*/
  //Login
  driver.findElement(By.id("navbar-comp__login-link")).click();
  Thread.sleep(4000);
  assertTrue(isElementPresent(By.cssSelector("div.modal-header")));
  assertEquals(driver.findElement(By.cssSelector("h2.modal-title")).getText(), "Welcome");
  assertTrue(isElementPresent(By.id("login_comp__close-button")));
  //assertEquals(driver.findElement(By.id("login_comp__close-button")).getText(), "×");
  assertTrue(isElementPresent(By.id("login-comp__username")));
  driver.findElement(By.id("login-comp__username")).click();
  driver.findElement(By.id("login-comp__password")).click();
  Thread.sleep(1000);
  assertTrue(isElementPresent(By.cssSelector("div.alert.alert-danger")));
  assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "Email address is required");
  assertTrue(isElementPresent(By.id("login-comp__password")));
  driver.findElement(By.id("login-comp__password")).click();
  driver.findElement(By.id("login-comp__username")).click();
  Thread.sleep(1000);
  assertEquals(driver.findElement(By.xpath("//div[@id='login-comp']/div[2]/form/div[2]/div")).getText(), "Password is required");
  assertTrue(isElementPresent(By.cssSelector("label")));
  assertTrue(isElementPresent(By.id("login-comp__remember-me")));
  assertEquals(driver.findElement(By.cssSelector("label")).getText(), "Remember me");
  driver.findElement(By.id("login_comp__close-button")).click();
  Thread.sleep(1000);
  //REGISTER
  driver.findElement(By.id("navbar-comp__register-link")).click();
  Thread.sleep(4000);
  assertTrue(isElementPresent(By.cssSelector("button.close")));
  assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Create your account. Now for free.");
  assertTrue(isElementPresent(By.id("register-comp__first-name")));
  driver.findElement(By.id("register-comp__first-name")).click();
  driver.findElement(By.id("register-comp__last-name")).click();
  assertTrue(isElementPresent(By.cssSelector("div.alert.alert-danger")));
  assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "First Name is required");
  assertTrue(isElementPresent(By.id("register-comp__last-name")));
  driver.findElement(By.id("register-comp__last-name")).click();
  driver.findElement(By.id("register-comp__email")).click();
  assertTrue(isElementPresent(By.xpath("//div[@id='register-comp']/form/div[2]/div/div")));
  assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[2]/div/div")).getText(), "Last Name is required");
  assertTrue(isElementPresent(By.id("register-comp__email")));
  driver.findElement(By.id("register-comp__email")).click();
  driver.findElement(By.xpath("//div[@id='register-comp']/form/div[5]/div/div/div/label")).click();
  assertTrue(isElementPresent(By.xpath("//div[@id='register-comp']/form/div[3]/div/div")));
  assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[3]/div/div")).getText(), "Email is required");
  assertTrue(isElementPresent(By.name("dp")));
  assertTrue(isElementPresent(By.xpath("//div[@id='register-comp']/form/div[5]/div/div/div/label")));
  assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[5]/div/div/div/label")).getText(), "Male");
  assertTrue(isElementPresent(By.xpath("//div[@id='register-comp']/form/div[5]/div/div/div[2]/label")));
  assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[5]/div/div/div[2]/label")).getText(), "Female");
  assertTrue(isElementPresent(By.id("register-comp__display-name")));
  driver.findElement(By.id("register-comp__display-name")).click();
  driver.findElement(By.id("register-comp__url")).click();
  assertTrue(isElementPresent(By.cssSelector("div.alert.alert-danger")));
  assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[6]/div/div")).getText(), "Display Name must be between 3 and 35 characters");
  assertTrue(isElementPresent(By.id("register-comp__url")));
  driver.findElement(By.id("register-comp__address")).click();
  Thread.sleep(2000);
  assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[7]/div/div")).getText(), "Handle is required");
  assertTrue(isElementPresent(By.id("register-comp__address")));
  /*assertTrue(isElementPresent(By.id("register-comp__country")));
  assertTrue(isElementPresent(By.id("register-comp__city")));
  assertTrue(isElementPresent(By.id("register-comp__zipcode")));*/
  assertTrue(isElementPresent(By.cssSelector("span.make-drag-overlay.avatar-inherit")));
  //driver.findElement(By.id("register-comp")).sendKeys(Keys.ARROW_DOWN); 
  //driver.findElement(By.id("register-comp")).sendKeys(Keys.ARROW_DOWN); 
  assertTrue(isElementPresent(By.id("register-comp__password")));
  assertTrue(isElementPresent(By.id("register-comp__confirm-password")));
  driver.findElement(By.id("register-comp__confirm-password")).click();
  driver.findElement(By.cssSelector("button.close")).click();
  }

 @AfterClass
 public void tearDown() throws Exception {
	 driver.quit();
 String verificationErrorString = verificationErrors.toString();
 if (!"".equals(verificationErrorString)) {
 fail(verificationErrorString);
 }
 }
	
 private boolean isElementPresent(By by) {
	    try {
	    	driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

 private boolean isAlertPresent() {
	    try {
	    	driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

 private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}



