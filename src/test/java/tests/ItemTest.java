package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.java.CartPage;
import pageObjects.java.ItemPage;
import pageObjects.java.ProductsPage;

public class ItemTest extends BaseTest {
	
	@Test(description = "Choose item")
	public void tc01_item() {
		ProductsPage pp = new ProductsPage(driver);
		pp.chooseProduct("HOVET");
		ItemPage ip = new ItemPage(driver);
		String expected = "HOVET";
		Assert.assertEquals(ip.itemName(), expected);
	}

	@Test(description = "add to cart")
	public void tc02_item() {
		CartPage cp = new CartPage(driver);
		ItemPage ip = new ItemPage(driver);
		int before = cp.getNumOfCounterCart();
		ip.addToBag();
		cp.continueToBagBtn();
		Assert.assertEquals(cp.getNumOfCounterCart(), before + 1);
	}
}
