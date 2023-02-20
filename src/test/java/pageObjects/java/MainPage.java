package pageObjects.java;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class MainPage extends BasePage {
	// Login
	@FindBy(css = ".hnf-btn.hnf-btn--primary")
	private WebElement cookiesBtn;
	@FindBy(css = "#hnf-header-profile")
	private WebElement profileLoginBtn;
	// Create new account
	@FindBy(css = ".profile__btn.profile__btn--secondary.profile__btn-margin-top-xl")
	private WebElement createAccountBtn;
	// Main menu
	@FindBy(css = "[name='q']")
	private WebElement searchForProducts;
	@FindBy(css = ".universal-item__text")
	private List<WebElement> listSearchResults;
	@FindBy(css = ".hnf-header__shopping-list-link>a")
	private WebElement favouritesBtn;

	public MainPage(WebDriver driver) {
		super(driver);

	}

	public void profileLogin() {
		waiting(500);
		click(profileLoginBtn);

	}

	public void cookiesBtn() {
		waiting(1000);
		click(cookiesBtn);

	}

	public void createAccountBtn() {
		waiting(500);
		click(createAccountBtn);

	}

	public void searchForProducts(String text) {
		waiting(500);
		fillText(searchForProducts, text);

	}

	public void listSearchResults(String name) {
		waiting(2000);
		System.out.println(listSearchResults.size());
		for (WebElement el : listSearchResults) {
			if (getText(el).equalsIgnoreCase(name)) {
				waiting(1000);
				click(el);
				break;
			}

		}
	}

	public void favouritesBtn() {
		driver.get("https://www.ikea.com/eg/en/favourites/");

	}
}
