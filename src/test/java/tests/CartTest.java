package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.java.CartPage;
import pageObjects.java.ItemPage;
import pageObjects.java.ProductsPage;

public class CartTest extends BaseTest {
	
	@Test(description = "Add to cart")
	public void tc01_cart() {
		ProductsPage pp = new ProductsPage(driver);
		pp.chooseProduct("HOVET");
		ItemPage ip = new ItemPage(driver);
		ip.addToBag();
		CartPage cp = new CartPage(driver);
		cp.continueToBagBtn();
		String expected = "Your bag";
		Assert.assertEquals(cp.titleCartPage(), expected);
	}

	@Test(description = "Cart - remove item")
	public void tc02_cart() {
		CartPage cp = new CartPage(driver);
		cp.remove("HOVET");
		String expected = "Your bag is empty";
		Assert.assertEquals(cp.titleCartAfterRemove(), expected);
	}
}
