package pageObjects.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MainPage {
	@FindBy(css = "#email")
	private WebElement usernameField;
	@FindBy(css = "#password")
	private WebElement passwordField;
	@FindBy(css = ".pp-skapa__btn.pp-skapa__btn--primary.pp-skapa__btn--fluid")
	private WebElement loginBtn;
	@FindBy(css = ".pp-skapa__form-field__message")
	private WebElement errorMsgInvalidUsername;
	@FindBy(css = ".pp-skapa__inline-message__body")
	private WebElement errorMsgInvalidPassword;
	@FindBy(css = "#profile-page-headline")
	private WebElement loginHelloMsg;

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public void login(String user, String password) {
		clear(usernameField);
		fillText(usernameField, user);
		clear(passwordField);
		fillText(passwordField, password);
		click(loginBtn);

	}

	public void loginInvalidField(String user, String password) {
		fillText(usernameField, user);
		fillText(passwordField, password);
	}

	public String getErrorMsgInvalidUsername() {
		return getText(errorMsgInvalidUsername);
	}

	public String getErrorMsgInvalidPassword() {
		return getText(errorMsgInvalidPassword);
	}

	public String getMsgLoginHello() {
		waiting(3000);
		return getText(loginHelloMsg);
	}
}
