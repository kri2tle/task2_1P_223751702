package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void takeSsAndSave(WebDriver driver, String path) {
		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        String formattedTime = currentTime.format(formatter);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String pngname = formattedTime + ".png";
		String destinationPath = path + pngname;
		
		try {
            Files.copy(screenshotFile.toPath(), new File(destinationPath).toPath());
            System.out.println("Screenshot saved successfully at: " + path + " and image name is " + pngname);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.toString());
        }
	}
	
	public static void trustpilotinstitute_signup_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "D:\\vs code\\chromedriver-win64\\chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
				
		// Find first input field which is firstname
		WebElement usrname_element = driver.findElement(By.id("id_username"));
		System.out.println("Found element: " + usrname_element);
		// Send username
		usrname_element.sendKeys("krishna21");
		
		/*
		 * Find following input fields and populate with values
		 */
		WebElement fname_element = driver.findElement(By.id("id_firstname"));
		System.out.println("Found element: " + fname_element);
		// Send first name
		fname_element.sendKeys("Krishna");
		
		WebElement lname_element = driver.findElement(By.cssSelector("input#id_lastname")); // Finding lastname element using cssSelector
		System.out.println("Found element: " + lname_element);
		// Send Last name
		lname_element.sendKeys("Chaudhari");
		
		// not sending password so that page dont get submited
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		WebElement submit_button = driver.findElement(By.xpath("//input[@type='submit']")); // Finding submit button using xpath
		System.out.println("Found element: " + submit_button);
		// Click button
		submit_button.click();
		/*
		 * Take screenshot using selenium API.
		 */
		takeSsAndSave(driver,"D:\\vs code\\ss\\");
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	public static void officeworks_registration_page(String url) {
		
		
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "D:\\vs code\\chromedriver-win64\\chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebElement html = driver.findElement(By.tagName("html"));
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement fname = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + fname);
		fname.sendKeys("Krishna");
		
		/*
		 * Find following input fields and populate with values
		 */
		WebElement lname = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + lname);
		lname.sendKeys("Chaudhari");
		
		WebElement pnumber = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + pnumber);
		pnumber.sendKeys("0491570156");
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		System.out.println("Found element: " + email);
		email.sendKeys("krishnachaudhari21@gmail.com");		
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println("Found element: " + button);
		button.click();
		
		/*
		 * Take screenshot using selenium API.
		 */
		takeSsAndSave(driver,"D:\\vs code\\ss\\");
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
}
