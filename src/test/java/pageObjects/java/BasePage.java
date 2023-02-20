package pageObjects.java;

import java.time.Duration;

//import java.security.PublicKey;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void fillText(WebElement el, String text) {
		highlightElement(el, "blue", "blue");
		el.clear();
		el.sendKeys(text);
	}

	public void click(WebElement el) {
		highlightElement(el, "blue", "blue");
		waiting(2000);
		el.click();
	}

	public void submit(WebElement el) {
		highlightElement(el, "blue", "blue");
		waiting(2000);
		el.submit();
	}

	public void clear(WebElement el) {
		el.clear();
	}

	public void waiting(long mill) {
		try {
			Thread.sleep(mill);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForElementToBeClickable(WebElement el) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(el));

	}

	public String getText(WebElement el) {
		highlightElement(el, "orange", "orange");
		waiting(300);
		return el.getText();

	}

	public void moveTo(WebElement el) {
		Actions a = new Actions(driver);
		a.moveToElement(el).build().perform();

	}

	protected void highlightElement(WebElement element, String bgColor, String color) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:" + bgColor + "; border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}
}
