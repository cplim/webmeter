package au.com.sensis.jmeter;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoadSteps
{
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
        @Override
        public WebDriver initialValue() {
            return new FirefoxDriver();
        }
    };

	@Test
	public void goToGoogle() throws Exception {
		threadDriver.get().get("http://www.google.com/");
	}
	
	@Test
	public void performSearch() throws Exception {
		// Find the text input element by its name
        WebElement element = threadDriver.get().findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
	}
}
