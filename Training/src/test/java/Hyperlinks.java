import org.openqa.selenium.Dimension;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hyperlinks {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		
		driver.navigate().to("http://www.leafground.com/pages/Link.html");
		//driver.manage().window().maximize();
		
		Dimension dimension = new Dimension(768, 1080);
		driver.manage().window().setSize(dimension);
		
		
		
		Thread.sleep(3000);
		WebElement homelink = driver.findElement(By.cssSelector("#contentblock > section > div:nth-child(1) > div > div > a"));
		homelink.click();
		Thread.sleep(3000);
		driver.navigate().back();
		
		Thread.sleep(3000);
		String link1 = driver.findElement(By.cssSelector("#contentblock > section > div:nth-child(4) > div > div > a")).getAttribute("href");
		System.out.println(link1);
		
		Thread.sleep(3000);
		//homelink.click();		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No. of Links: "+links.size());
		
		for (WebElement webElement : links) {
			String url = webElement.getAttribute("href");
			verifyLinks(url);
		}
		driver.quit();
	}	
		public static void verifyLinks(String linkUrl)
		{
			try {
				URL url = new URL(linkUrl);
				
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				Thread.sleep(3000);
				if(con.getResponseCode()>=400)
				{
					System.out.println(linkUrl+"-"+con.getResponseMessage()+"- is a Broken Link");
					
				}
				else
					System.out.println(linkUrl+" is not a Broken Link");
				
			} catch (Exception e) {
				
			}
			
			
		}
		
	}
