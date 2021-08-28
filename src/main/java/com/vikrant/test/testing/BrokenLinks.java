package com.vikrant.test.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.net.HttpURLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	static WebDriver driver = null;
	public static Map<String, Integer> brokenLinks = new HashMap<String, Integer>();
	public static Map<String, Integer> activeLinks = new HashMap<String, Integer>();

	public static void main(String args[]) throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

//		checkBrokenLinks("https://demoqa.com/links",driver);
		checkBrokenLinks("https://www.google.com/",driver);
		System.out.println("All broken links are: \n"+brokenLinks);
		System.out.println("All active links are: \n"+activeLinks);
	}

	public static void checkBrokenLinks(String path, WebDriver driver) throws IOException {
		driver.get(path);		
		List<String> urls = new ArrayList<>();
		for(WebElement url: driver.findElements(By.tagName("a"))){
			urls.add(url.getAttribute("href"));
		}
		System.out.println("********************************************************");
		System.out.println(driver.getTitle() +" - "+driver.getCurrentUrl());
		System.out.println("Total links are: "+urls.size());
		System.out.println(urls);
		
		int i = 1;
		for (String link : urls) {
			if(link!=null){
				try{
					System.out.println("URL "+i++);
					if (brokenLinks.keySet().contains(link)){
						brokenLinks.put(link, brokenLinks.get(link) + 1);
						System.out.println(">>>>>>>>>>>> Already existing broken link found - "+link);
					}else if(activeLinks.keySet().contains(link)){
						activeLinks.put(link, activeLinks.get(link) + 1);
						System.out.println(">>>>>>>>>>>> Already existing active link found - "+link);
					}else {
						URL add = new URL(link);
						HttpURLConnection httpConnection = (HttpURLConnection) add.openConnection();
						httpConnection.setRequestMethod("HEAD");
						httpConnection.setConnectTimeout(5000);
						httpConnection.connect();
						System.out.println(httpConnection.getResponseCode());
						if (httpConnection.getResponseCode() >= 400)
						{
							brokenLinks.put(link, 1);
							System.out.println(">>>>>>>>>>>> Broken link found - "+link);
						}else {
							activeLinks.put(link, 1);
							checkBrokenLinks(link, driver);
						}

					}
				}catch(Exception e){
					System.out.println("Exception occured for link "+link);
					if(brokenLinks.containsKey(link)){
						brokenLinks.put(link, brokenLinks.get(link)+1);
					}else{
						brokenLinks.put(link, 1);
					}
					
				}
			}
			
		}

		System.out.println("********************************************************");
	}

}