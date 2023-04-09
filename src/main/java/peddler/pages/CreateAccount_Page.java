package peddler.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount_Page {

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




@Test(priority=1,groups="Create an Account test")    
public void Verify_CreateAccount() // Create an account
{
	
	driver.findElement(By.xpath("(//button[@class='_1M0bH _22pt5 _1ZcRn _10ljI'])[1]")).click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.findElement(By.xpath("//a[normalize-space()='Create new account']")).click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.findElement(By.xpath("//input[@placeholder='000 000 000']")).sendKeys("4353554545");
	driver.findElement(By.xpath("//input[@placeholder='Katy Smith']")).sendKeys("Kavisha Joshi");
	driver.findElement(By.xpath("//input[@placeholder='naam@voorbeeld.com']")).sendKeys("kavisha123@gmail.com");
	driver.findElement(By.xpath("//input[@placeholder='at least 10 characters']")).sendKeys("kavisha@123");
	
	driver.findElement(By.xpath("//button[normalize-space()='Create account']")).click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String Confirmation_msg = driver.findElement(By.xpath("//h3[normalize-space()='Verify your email']")).getText();
	System.out.println(Confirmation_msg);
  }

@Test(priority=2,groups="Create an Account test")    
public void Verify_Validation_Msg() // validation messages are displayed if fields kept empty
{
	
	driver.findElement(By.xpath("(//button[@class='_1M0bH _22pt5 _1ZcRn _10ljI'])[1]")).click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.findElement(By.xpath("//a[normalize-space()='Create new account']")).click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	driver.findElement(By.xpath("//button[normalize-space()='Create account']")).click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String validation_msg = driver.findElement(By.xpath("//span[@class='error-text']")).getText();
	System.out.println(validation_msg);
  }






}