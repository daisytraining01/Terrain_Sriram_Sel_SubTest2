package seleniumcode;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class seleniumcode 
{
  static WebDriver driver;

 

  public void waits()
  {
      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
  }
  public void url()
  {
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("http://elastic.rapidtestpro.com:8086/index");
      
  }
  public void login()
  {
      driver.findElement(By.id("username")).sendKeys("labuser");
      driver.findElement(By.id("password")).sendKeys("labuser@01");
      driver.findElement(By.xpath("//button[@type='submit']")).click();
      
  }
  public void fundDetails()
  {
	  String s1 = driver.findElement(By.xpath("(//h1/span)[1]")).getText();
      System.out.println("Primary Balance(Before): "+s1);
      waits();
      driver.findElement(By.xpath("//a[@role='button'][text()='Transfer ']")).click();
      driver.findElement(By.xpath("//a[text()='Between Accounts']")).click();
      Select from = new Select(driver.findElement(By.id("transferFrom")));
      from.selectByValue("Primary");
      driver.findElement(By.id("amount")).sendKeys("1");
      
      
  }
  public void transferButton()
  {
      driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  public void balCheck()
  {
      String s1 = driver.findElement(By.xpath("(//h1/span)[1]")).getText();
      System.out.println("Primary Balance(After): "+s1);
      driver.quit();
  }
  public void fillRecipient()
  {
      driver.findElement(By.xpath("//a[@role='button'][text()='Transfer ']")).click();
      driver.findElement(By.xpath("//a[text()='Add/Edit Recipient']")).click();
      WebElement w1 = driver.findElement(By.id("recipientName"));
      w1.sendKeys("Seleniumtesting");
      driver.findElement(By.id("recipientEmail")).sendKeys("seleniumtest@gmail.com");
      driver.findElement(By.id("recipientPhone")).sendKeys("9999999999");
      driver.findElement(By.id("recipientAccountNumber")).sendKeys("1016033717");
      driver.findElement(By.id("recipientDescription")).sendKeys("Create Recipient");
      
  }
  public void addRecipient()
  {
      driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  public void checkRecipient()
  {
	  List<WebElement> list = driver.findElements(By.xpath("//table/tbody/tr/td[1]/a"));
      System.out.println("RowSize :"+list.size());
      for(WebElement a : list)
      {
          System.out.println("RecipientName: "+a.getText());
          if(a.getText().contains("Seleniumtesting"))
          {
              System.out.println("ConfirmRecipientName: "+a.getText());
          }
         
      }
      driver.quit();
  }
  

 
}