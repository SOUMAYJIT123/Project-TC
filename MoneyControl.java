package com.ibm.moneycontrol;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MoneyControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.moneycontrol.com");
	WebElement stockEle=driver.findElement(By.xpath("(//a[@title='Stocks'])[1]"));
	stockEle.click();
	WebElement alphabetEle=driver.findElement(By.xpath("(//div[@class='MT2 PA10 brdb4px alph_pagn']/span/following::a)[1]"));
	alphabetEle.click();
	WebElement tableEle=driver.findElement(By.xpath("//table[@class='pcq_tbl MT10']"));
	
	List<WebElement> rows=driver.findElements(By.xpath("//table[@class='pcq_tbl MT10']/tbody/tr"));
	int rowsCount=rows.size();
	List<WebElement> cols=driver.findElements(By.xpath("//table[@class='pcq_tbl MT10']/tbody/tr[2]/td"));
	int colsCount=cols.size();
    List<WebElement>links=tableEle.findElements(By.tagName("a"));
    for(WebElement link:links)
    {
    System.out.println(link.getText());
    System.out.println(link.getAttribute("href"));
    }
 WebElement ele=driver.findElement(By.xpath("//a[@title='Ashok Leyland']"));
 ele.click();
 String actualtitle=driver.getTitle();
 String expectedtitle="Ashok Leyland Ltd. Stock Price, Share Price, Live BSE/NSE, Ashok Leyland Ltd. Bids Offers. Buy/Sell Ashok Leyland Ltd. news & tips, & F&O Quotes, NSE/BSE Forecast News and Live Quotes";
 
Assert.assertEquals(expectedtitle,actualtitle);

		}

}
