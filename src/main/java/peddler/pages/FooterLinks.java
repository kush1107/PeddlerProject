package peddler.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {
	public  WebDriver driver;





	@BeforeMethod
	public void setup()
	{
		ChromeOptions options  = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options); 
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.peddler.com/en/amsterdam/");
		

		
	}

	@AfterMethod
	public void teardown()
	{
		driver.close();
	}




	@Test(priority=1,groups="Footer test")    
	public void Verify_List_of_FooterLinks_helpful_section() // List of footer links for particular section - helpful section
	{
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 // Find all the links in the footer
        WebElement footer = driver.findElement(By.cssSelector("._2XoxW._2I2Ru.footer-pos"));
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));

        // Print the URL of each link and click it to get the page title
        for (WebElement link : footerLinks) {
            System.out.println("Link URL: " + link.getAttribute("href"));
        }
           
       }
        
       
	
}
