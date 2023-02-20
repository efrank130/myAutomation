package pageObjects.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends MainPage {
	@FindBy(css = ".pip-header-section__title--big.notranslate")
	private WebElement itemName;
	@FindBy(css = ".pip-buy-module__buttons--container")
	private WebElement addToBag;
	@FindBy(css = ".pip-mobile-favourite-button-wrapper>button>span")
	private WebElement addToFavourites;

	public ItemPage(WebDriver driver) {
		super(driver);

	}

	public String itemName() {
		return getText(itemName);
	}

	public void addToBag() {
		waiting(500);
		click(addToBag);

	}

	public void addToFavourites1() {
		waiting(1000);
		click(addToFavourites);

	}

	public void addToFavourites() {
		Actions a = new Actions(driver);
		a.moveToElement(addToFavourites).build().perform();
		waiting(5000);
		click(addToFavourites);
	}

}
