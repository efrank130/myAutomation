package pageObjects.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavouritesPage extends MainPage {
	@FindBy(css = ".skapa-wrapper-prefix-text.skapa-wrapper-prefix-text--heading-l.ListsPage_title__P9aGW")
	private WebElement titlePage;
	@FindBy(css = ".skapa-wrapper-prefix-btn__label")
	private WebElement createNewList;
	@FindBy(css = "#new-list-field")
	private WebElement listName;
	@FindBy(css = "#create-list-sheets-modal>div.skapa-wrapper-prefix-modal-footer.skapa-wrapper-prefix-modal-footer--borderless>button>span>span")
	private WebElement saveBtn;
	@FindBy(css = "#bottomDivider>div>main>section:nth-child(2)>article:nth-child(2)>section>div>a>h6")
	private WebElement titleOfNewList;

	public FavouritesPage(WebDriver driver) {
		super(driver);

	}

	public String titlePage() {
		waiting(3000);
		return getText(titlePage);
	}

	public void createNewList() {
		waiting(3000);
		click(createNewList);

	}

	public void listName(String text) {
		fillText(listName, text);

	}

	public void saveBtn() {
		click(saveBtn);

	}

	public String titleOfNewList() {
		waiting(3000);
		return getText(titleOfNewList);
	}
}
