package Testng_Pack;

import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


@SuppressWarnings("unused")
public class Hometestdemo {
 
WebDriver driver = null;
 
 
  @BeforeTest
  public void setup() throws Exception { 
  // set geckodriver path.
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Downloads\\HomeTest\\geckodriver-v0.33.0-win32");
  //initialize firefox driver.
  driver = new FirefoxDriver();
         driver.manage().window().maximize();
         //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
         driver.get("https://raksul.github.io/recruit-qa-engineer-work-sample/"); 
  } 
 
  @AfterTest
  public void tearDown() throws Exception { 
   driver.quit();
     } 
  
  @Test
  public void Submit_Test(){
   driver.findElement(By.xpath("//input[@id='form_item_firstName']")).sendKeys("My First Name");
   driver.findElement(By.xpath("//input[@id='form_item_lastName']")).sendKeys("My Last Name");
   driver.findElement(By.xpath("//input[@id='form_item_email']")).sendKeys("TestEmail123@gmail.com");
   
   //dropdown where dis you hear about us?
   Select dropdown = new Select(driver.findElement(By.id("form_item_infoSource")));
   dropdown.selectByVisibleText("Social media");
   
   
   //type= checkbox, Service of interest
   driver.findElement(By.xpath("//input[@id='form_item_servicesOfInterest']")).isSelected();
   
   //type = ratio, type of associate: chose"Partner"
   driver.findElement(By.xpath("//input[@value='2']"));
   driver.findElement(By.xpath("//input[@value='2']")).isSelected();
   driver.findElement(By.xpath("//input[@value = '2']")).click();
   driver.findElement(By.xpath("//input[@value = '2']")).isEnabled();
   driver.findElement(By.xpath("//input[@value = '2']")).isDisplayed();
   

   //To submit form.
   //You can use any other Input field's(First Name, Last Name etc.) xpath too In bellow given syntax.
   driver.findElement(By.xpath("//input[@id='form_item_explanation']")).submit();
   String alrt = driver.switchTo().alert().getText();
   driver.switchTo().alert().accept();
   System.out.println(alrt);
  }
  
}
