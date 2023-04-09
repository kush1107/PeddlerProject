package peddler.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Sign_In_Page {
	
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
	
	
	
	
	@Test(priority=1,groups="Sign-in test")    
	public void Verify_UserLogin() // Both email id & passwords are correct
	{
		
		driver.findElement(By.xpath("(//button[@class='_1M0bH _22pt5 _1ZcRn _10ljI'])[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='emailInput']")).sendKeys("kj.joshi197@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String username = driver.findElement(By.xpath("(//span[@class='_3Qquz _1dt6Y text-truncate'])[1]")).getText();
		System.out.println("User logged in is : "+username);
		

		driver.findElement(By.xpath("(//button[@class='_1M0bH _22pt5 _1ZcRn _1YF6i'])[1]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action = new Actions(driver);
		WebElement logout = driver.findElement(By.xpath("(//a[@class='Aa83x'][normalize-space()='Sign out'])[1]"));
		action.moveToElement(logout).perform();
		logout.click();
		
	}
	
	
	
	@Test(priority=2,groups="Sign-in test")    
	public void Verify_UserLogin_incorrect_email_ID() //  email id is incorrect & passwords is correct
	{
		
		
		driver.findElement(By.xpath("(//button[@class='_1M0bH _22pt5 _1ZcRn _10ljI'])[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='emailInput']")).sendKeys("kj.joshi@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String validation_msg = driver.findElement(By.xpath("(//span[@class='error-text-2'])[1]")).getText();
		System.out.println("Validation Msg is displayed : "+validation_msg);
		
	}
	
	@Test(priority=3,groups="Sign-in test")    
	public void Verify_UserLogin_incorrect_password() //  email id is correct & passwords is incorrect
	{
		
		driver.findElement(By.xpath("(//button[@class='_1M0bH _22pt5 _1ZcRn _10ljI'])[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='emailInput']")).sendKeys("kj.joshi197@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String validation_msg = driver.findElement(By.xpath("(//span[@class='error-text-2'])[1]")).getText();
		System.out.println("Validation Msg is displayed : "+validation_msg);
		
	}

	@Test(priority=4,groups="Sign-in test")    
	public void Verify_UserLogin_incorrect_emailID_password() //  Both email id  & passwords are incorrect
	{
		
		driver.findElement(By.xpath("(//button[@class='_1M0bH _22pt5 _1ZcRn _10ljI'])[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='emailInput']")).sendKeys("kj.joshi@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String validation_msg = driver.findElement(By.xpath("(//span[@class='error-text-2'])[1]")).getText();
		System.out.println("Validation Msg is displayed : "+validation_msg);
		
	}

}

