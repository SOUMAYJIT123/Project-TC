package com.ibm.testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

public class DataTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
		driver.get("https://datatables.net");
		WebElement showEle = driver.findElement(By.xpath("//select[@name='example_length']"));
		Select s = new Select(showEle);
		s.selectByValue("50");
		
		List<WebElement>rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		int rowsCount = rows.size();
		for (int i = 1; i <= rowsCount; i++) {
			WebElement nameEle = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]"));
			WebElement ageEle = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[4]"));
			String age = ageEle.getText().trim();
			int ageInt =Integer.parseInt(age);
			nameEle.click();
			WebElement salEle = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+(i+1)+"]/td[1]"));
			String sal=salEle.getText().replace("Salary","").trim().replace("$", "").replace(",", "");
			int salry=Integer.parseInt(sal);

			if ((salry>=200000)&&(ageInt>=50)) {
				System.out.println(nameEle.getText());
			}
			nameEle.click();
		}
WebElement pageclick=driver.findElement(By.xpath("//a[@data-dt-idx='2']"));
pageclick.click();
List<WebElement> rows2 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
int rowsCount2 = rows2.size();
for (int i = 1; i <= rowsCount2; i++) {
	WebElement nameEle = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]"));
	WebElement ageEle = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[4]"));
	String age = ageEle.getText().trim();
	int ageInt =Integer.parseInt(age);
	nameEle.click();
	WebElement salEle = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+(i+1)+"]/td[1]"));
	String sal=salEle.getText().replace("Salary","").trim().replace("$", "").replace(",", "");
	int salry=Integer.parseInt(sal);

	if ((salry>=200000)&&(ageInt>=50)) {
		System.out.println(nameEle.getText());
	}
	nameEle.click();
}

	}

}
