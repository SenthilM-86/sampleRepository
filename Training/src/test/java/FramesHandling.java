import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesHandling {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		  driver.get("http://www.leafground.com/pages/frame.html");
		  
		  driver.switchTo().frame(0); String text1 =
		  driver.findElement(By.id("Click")).getText(); System.out.println(text1);
		  
		  driver.findElement(By.id("Click")).click(); Thread.sleep(3000); String text2
		  = driver.findElement(By.id("Click")).getText(); System.out.println(text2);
		  driver.switchTo().defaultContent();
		  
		  Thread.sleep(3000); driver.switchTo().frame(1);
		  driver.switchTo().frame("frame2"); Thread.sleep(3000);
		  driver.findElement(By.id("Click1")).click();
		  
		  driver.switchTo().defaultContent(); int totalframes =
		  driver.findElements(By.tagName("iframe")).size();
		  System.out.println(totalframes);
		 
		//Drag & Drop
		Thread.sleep(3000);
		driver.get("http://www.leafground.com/pages/drop.html");
		WebElement from = driver.findElement(By.id("draggable"));
		WebElement to = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		//act.clickAndHold(from).moveToElement(to).release(to).build().perform();
		
		act.dragAndDrop(from, to).build().perform();
		Thread.sleep(3000);
		act.dragAndDropBy(to, 167, 48).build().perform();
		
		String text3 = driver.findElement(By.xpath("//*[@id=\'droppable\']/p")).getText();
		if(text3.equals("Dropped!"))
			System.out.println("Passed");
		else
			System.out.println("Failed");
		
		driver.quit();

	}

}
