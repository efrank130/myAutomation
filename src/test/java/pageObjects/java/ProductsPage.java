package pageObjects.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends MainPage {
	@FindBy(css = ".text.text--body-m.search-summary__message")
	private WebElement titleProductsPage;
	@FindBy(css = ".pip-header-section__title--small.notranslate")
	private List<WebElement> listProductsName;
	@FindBy(css = ".pip-product-compact__bottom-wrapper")
	private List<WebElement> listAreaProducts;

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public void addFavouritesProduct(String name) {
		waiting(1000);
		System.out.println(listProductsName.size());
		for (WebElement el : listAreaProducts) {
			WebElement titleEl = el.findElement(By.cssSelector(".pip-header-section__title--small.notranslate"));
			if (getText(titleEl).equalsIgnoreCase(name)) {
				WebElement heartBtn = el.findElement(By.cssSelector(".pip-product-compact__add-to-list-button"));
				waiting(1000);
				click(heartBtn);
				break;
			}

		}
	}

	public void chooseProduct(String name) {
		for (WebElement el : listProductsName) {
			if (el.getText().equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}

	public String titleProductsPage() {
		return getText(titleProductsPage);
	}

	public void chooseProductAndAddToCart(String name) {
		String addToCartBtnId = "add-to-cart-" + name.replace(" ", "-");
		WebElement addToCartBtn = driver.findElement(By.id(addToCartBtnId.toLowerCase()));
		click(addToCartBtn);
	}

}
