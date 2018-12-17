package com.ibm.ecommertc;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


public class daya1 {
   
    public static WebDriver driver;

   
    public void launchBrowser(){   
       
       
    	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver= new ChromeDriver();       
             
        driver.get("https://atozgroceries.com/admin");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
       
   
      public void login() throws InterruptedException {
          Thread.sleep(2000);

          driver.findElement(By.xpath("//input[@type='text']")).sendKeys("demo@atozgroceries.com");
          driver.findElement(By.xpath("//input[@type='password']")).sendKeys("456789");
          driver.findElement(By.xpath("//span[@class='btn-label']")).click();
         
         
      }
     
      public void EditProduct() throws InterruptedException{
          Thread.sleep(2000);
          driver.findElement(By.xpath("//span[@class='fa arrow']")).click();
          driver.findElement(By.linkText("Products")).click();
          Thread.sleep(5000);   
          driver.findElement(By.xpath("//input[@class='form-control input-sm']")).sendKeys("_modified");         
          driver.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-primary']")).click();         
          driver.findElement(By.xpath("//a[@title='Edit']")).click();   
         
         //String value_text=driver.findElement(By.xpath("//input[@id='pro_name']")).getText();
         driver.findElement(By.xpath("//input[@id='pro_name']")).clear();
         driver.findElement(By.xpath("//input[@id='pro_name']")).sendKeys("_modified");
         driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();   
       
         
           
      }
 
    public static void main (String args[]) throws InterruptedException{
       
        Test_Practice Test_Practice=new Test_Practice();
       
        Test_Practice.launchBrowser();
        Test_Practice.login();
        Test_Practice.EditProduct();
       
    }
   
}

, or
