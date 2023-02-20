package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.java.ItemPage;
import pageObjects.java.ProductsPage;

public class ProductsTest extends BaseTest {

	@Test(description = "Search- Product")
	public void tc01_products() {
		ProductsPage pp = new ProductsPage(driver);
		String expected = "We found 5 products and 160 content results.";
		Assert.assertEquals(pp.titleProductsPage(), expected);

	}

	@Test(description = "choose- Product")
	public void tc02_products() {
		ProductsPage pp = new ProductsPage(driver);
		ItemPage ip = new ItemPage(driver);
		pp.chooseProduct("HOVET");
		String expected = "HOVET";
		Assert.assertEquals(ip.itemName(), expected);

	}

}
