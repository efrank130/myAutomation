package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.java.FavouritesPage;
import pageObjects.java.ProductsPage;

public class FavouritesTest extends BaseTest {

	@Test(description = "Add to favourite")
	public void tc01_Favourites() {
		ProductsPage pp = new ProductsPage(driver);
		pp.addFavouritesProduct("HOVET");
		pp.favouritesBtn();
		FavouritesPage fp = new FavouritesPage(driver);
		String expected = "Your favourites";
		Assert.assertEquals(fp.titlePage(), expected);

	}

	@Test(description = "Create a new list")
	public void tc02_Favourites() {
		FavouritesPage fp = new FavouritesPage(driver);
		fp.createNewList();
		fp.listName("My first list-mirror stand");
		fp.saveBtn();
		String expected = "My first list-mirror stand";
		Assert.assertEquals(fp.titleOfNewList(), expected);
	}

}
