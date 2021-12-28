import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String parentWindow = driver.getWindowHandle();
		
		WebElement homebtn = driver.findElement(By.id("home"));
		homebtn.click();
		Thread.sleep(3000);
		Set<String> handles = driver.getWindowHandles();
		
		for (String childWindow : handles) {
			driver.switchTo().window(childWindow);
		}
		Thread.sleep(3000);
		WebElement editbtn = driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[1]/a/img"));
		editbtn.click();
		Thread.sleep(3000);
		driver.close();
		
		driver.switchTo().window(parentWindow);
		//driver.switchTo().defaultContent();
		
		WebElement openMultibtn = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/button"));
		openMultibtn.click();
		Thread.sleep(3000);
		int count = driver.getWindowHandles().size();
		System.out.println("Total no. of Windows "+count);
		
		
		WebElement dontclosebtn = driver.findElement(By.id("color"));
		dontclosebtn.click();
		Thread.sleep(3000);
		Set<String> newHandles = driver.getWindowHandles();
		
		Thread.sleep(3000);
		for (String allWindows : newHandles) {
			if(!allWindows.equals(parentWindow)) {
				driver.switchTo().window(allWindows);
				driver.close();
			}
		}		
		
		
		driver.quit();		

	}

}
