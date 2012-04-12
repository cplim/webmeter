package au.com.sensis.jmeter;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProofOfConcept
{
	private WebDriver driver;
	
	@Before
	public void createDriver(){
		System.out.println(String.format("Thread: %s is creating a firefox instance", Thread.currentThread().getName()));
		driver = new FirefoxDriver();
	}
	
	@Test
	public void goToYahoo() throws Exception {
		driver.get("http://yahoo.com.au");
		// Check the title of the page
        System.out.println(String.format("Thread: %s says title is: %s", Thread.currentThread().getName(), driver.getTitle()));
	}
	
	@Test
	public void goToGoogleSearchResultsPage() throws Exception {
		driver.get("http://google.com.au");
		// Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
		System.out.println(String.format("Thread: %s says title is: %s", Thread.currentThread().getName(), driver.getTitle()));
	}
}
