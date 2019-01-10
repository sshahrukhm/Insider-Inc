package com.screening.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Exercise2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sshah\\eclipse-workspace\\BusinessInsider\\BrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step1
		driver.get("https://www.thisisinsider.com/");
		
		//Step2
		String actualTitle = driver.getTitle();
		String expectedTitle = "INSIDER";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println(actualTitle);

		//Step3
		driver.findElement(By.linkText("LIFE")).click();
		
		//Step4
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Lifestyle - INSIDER";
		Assert.assertEquals(actualTitle1, expectedTitle1);
		System.out.println(actualTitle1);
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.thisisinsider.com/lifestyle";
		Assert.assertEquals(actualUrl, expectedUrl);
		
		//Step5
		System.out.println(actualUrl);
		System.out.println("Article Title: " + driver.findElement(By.cssSelector("h1 [href]")).getText());
		System.out.println("Author Name: " + driver.findElement(By.cssSelector("[class='tout tout-0 id-5a4c118629505631008b45c9'] [href='https\\:\\/\\/www\\.thisisinsider\\.com\\/author\\/daniel-boan']")).getText());
		
		//Step6
		driver.get("https://www.thisisinsider.com/popular-things-that-didnt-exist-10-years-ago-2018-12");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		//Step6.1
		List<WebElement> totalImages = driver.findElements(By.cssSelector("section[data-post-type=\"slideshow\"]"));
		totalImages.addAll(driver.findElements(By.tagName("img")));
		System.out.println("number of total images is: "+totalImages.size());
		List<WebElement> images = new ArrayList<>();	
		for(int i=0; i<totalImages.size(); i++) {
			if (totalImages.get(i).getAttribute("class") !=null && !totalImages.get(i).getAttribute("class").contains("slideshow-vaop-ad ad")) {
				images.add(totalImages.get(i));
			}
		}
		
		//Step6.2
		System.out.println("no ads images size is: "+images.size());
		List<WebElement> catagories = driver.findElements(By.cssSelector("[data-e2e-name='category-wrapper']"));
		for(int i=0; i<catagories.size(); i++) {
			System.out.println(catagories.get(i).getText()+"\n");
		}
		driver.close();
	}

}
