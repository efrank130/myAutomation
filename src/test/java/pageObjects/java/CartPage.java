package pageObjects.java;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends MainPage {
	@FindBy(css = ".skapa-wrapper-prefix-btn.skapa-wrapper-prefix-btn--small.skapa-wrapper-prefix-btn--tertiary.cart-item-removal-button")
	private List<WebElement> removeBtn;
	@FindBy(css = ".rec-link.rec-link--white")
	private WebElement continueToBagBtn;
	@FindBy(css = ".hnf-header__cart-counter")
	private WebElement counterCart;
	@FindBy(css = ".TopSummary_topSummary__lxrxR>h1")
	private WebElement titleCartPage;
	@FindBy(css = "[data-ft='text-empty-cart-header']")
	private WebElement titleCartAfterRemove;

	public CartPage(WebDriver driver) {
		super(driver);

	}

	public void remove(String el) {
		for (WebElement el1 : removeBtn) {
			if (el.equalsIgnoreCase(el))
				click(el1);
			break;
		}
	}

	public int getNumOfCounterCart() {
		waiting(1000);
		String num = getText(counterCart);
		int iNum = Integer.parseInt(num);
		return iNum;
	}

	public void continueToBagBtn() {
		waiting(3000);
		click(continueToBagBtn);

	}

	public String titleCartPage() {
		return getText(titleCartPage);
	}

	public String titleCartAfterRemove() {
		waiting(1000);
		return getText(titleCartAfterRemove);
	}
}
