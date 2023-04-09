package peddler.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search_Page {
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




	@Test(priority=1,groups="Search test")    
	public void Verify_search_results() //Search Results
	{
		driver.findElement(By.xpath("//input[@id='autocomplete-search']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='autocomplete-search']")).sendKeys("Trs Chana Dal 1Kg");
		driver.findElement(By.xpath("//input[@id='autocomplete-search']")).sendKeys(Keys.RETURN);
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String Search_text = driver.findElement(By.xpath("//h2[normalize-space()='Trs Chana Dal 1Kg']")).getText();
		System.out.println(Search_text);
	}
	
	@Test(priority=2,groups="Search test")    
	public void Verify_No_search_results() // No Search Results
	{
		driver.findElement(By.xpath("//input[@id='autocomplete-search']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='autocomplete-search']")).sendKeys("fegfrgrgtgtgegaeget5gegegrgr");
		driver.findElement(By.xpath("//input[@id='autocomplete-search']")).sendKeys(Keys.RETURN);
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String No_Search_text = driver.findElement(By.xpath("//h2[contains(text(),'No results for')]")).getText();
		System.out.println(No_Search_text);
	}
}
