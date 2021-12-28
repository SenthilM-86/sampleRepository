import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectablesHandling {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		
		  driver.get("http://www.leafground.com/pages/selectable.html");
		  
		  //List<WebElement> selectableList =
		  driver.findElements(By.xpath("//*[@id=\'selectable\']")); List<WebElement>
		  selectableList = driver.findElements(By.xpath("//*[@id='selectable']/li"));
		  int sizeoflist = selectableList.size(); System.out.println(sizeoflist);
		  Thread.sleep(3000);
		  
		  Actions act = new Actions(driver); act.keyDown(Keys.CONTROL)
		  .click(selectableList.get(0)) .click(selectableList.get(1))
		  .click(selectableList.get(2)) .build().perform();
		  
		  
		  act.clickAndHold(selectableList.get(3));
		  act.clickAndHold(selectableList.get(4));
		  act.clickAndHold(selectableList.get(5)); act.build().perform();
		  
		  Thread.sleep(3000); //Tool Tip
		  driver.get("http://www.leafground.com/pages/tooltip.html"); WebElement
		  textbox = driver.findElement(By.id("age"));
		  
		  String tooltiptext = textbox.getAttribute("title");
		  System.out.println(tooltiptext);
		 
		
		Thread.sleep(3000);
		//Downloading a file and verify
		driver.get("http://www.leafground.com/pages/download.html");
		WebElement downloadlink = driver.findElement(By.linkText("Download Excel"));
		downloadlink.click();
		Thread.sleep(3000);
		File fileloc = new File("C:\\Users\\Senthil\\Downloads\\");
		File[] totfiles = fileloc.listFiles();
		
		for (File file : totfiles) {
			if(file.getName().equals("testleaf.xlsx"))
			{
				System.out.println("File is downloaded successfully");
				break;
			}
			
		}
		
		driver.quit();
		
		
	}

}
