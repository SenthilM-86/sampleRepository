import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DifferentWays {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		//driver.get("http://www.leafground.com/pages/Window.html");
		//Thread.sleep(3000);
		//driver.navigate().to("https://www.google.com");
		
		/*
		 * String url = "https://www.google.com";
		 * 
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.location = \'"+url+"\'", "");
		 * 
		 * //Maximize Thread.sleep(3000); //driver.manage().window().maximize();
		 * 
		 * Dimension dim = new Dimension(1080, 768);
		 * driver.manage().window().setSize(dim);
		 */
		//Active Element
		/*
		 * driver.get("https://www.google.com"); driver.switchTo().activeElement();
		 * Thread.sleep(3000); JavascriptExecutor js = (JavascriptExecutor) driver; js.
		 * executeScript("document.getElementsByName('q')[0].value='Cucumber Framework'"
		 * , "");
		 */
		
		//Login Pop-up
		Thread.sleep(3000);
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		/*
		 * Thread.sleep(3000); Robot rob = new Robot(); rob.keyPress(KeyEvent.VK_A);
		 * rob.keyRelease(KeyEvent.VK_A); rob.keyPress(KeyEvent.VK_D);
		 * rob.keyRelease(KeyEvent.VK_D); rob.keyPress(KeyEvent.VK_M);
		 * rob.keyRelease(KeyEvent.VK_M); rob.keyPress(KeyEvent.VK_I);
		 * rob.keyRelease(KeyEvent.VK_I); rob.keyPress(KeyEvent.VK_N);
		 * rob.keyRelease(KeyEvent.VK_N); Thread.sleep(3000);
		 * rob.keyPress(KeyEvent.VK_TAB); rob.keyRelease(KeyEvent.VK_TAB);
		 * Thread.sleep(3000); rob.keyPress(KeyEvent.VK_A);
		 * rob.keyRelease(KeyEvent.VK_A); rob.keyPress(KeyEvent.VK_D);
		 * rob.keyRelease(KeyEvent.VK_D); rob.keyPress(KeyEvent.VK_M);
		 * rob.keyRelease(KeyEvent.VK_M); rob.keyPress(KeyEvent.VK_I);
		 * rob.keyRelease(KeyEvent.VK_I); rob.keyPress(KeyEvent.VK_N);
		 * rob.keyRelease(KeyEvent.VK_N); Thread.sleep(3000);
		 * rob.keyPress(KeyEvent.VK_TAB); rob.keyRelease(KeyEvent.VK_TAB);
		 * Thread.sleep(3000); rob.keyPress(KeyEvent.VK_ENTER);
		 * rob.keyRelease(KeyEvent.VK_ENTER);
		 */
		
		

	}

}
