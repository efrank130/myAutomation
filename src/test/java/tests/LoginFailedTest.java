package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.java.LoginPage;

public class LoginFailedTest extends BaseTest {
	@Override
	public void setupLogin() {

	}

	@Test(description = "Login- invalid username")
	public void tc01_login() {
		LoginPage lp = new LoginPage(driver);
		lp.cookiesBtn();
		lp.profileLogin();
		lp.loginInvalidField("e234", "e1234");
		String expected = "Your email (username) may not contain more than 100 characters, nor more than 64 characters before the @ sign. Successive periods are not allowed.";
		Assert.assertEquals(lp.getErrorMsgInvalidUsername(), expected);

	}

	@Test(description = "Login- invalid password")
	public void tc02_login() {
		LoginPage lp = new LoginPage(driver);
		lp.loginInvalidField("ithlswn@gmail.com", "Ikea12345");
		String expected = "Your password is required.";
		Assert.assertEquals(lp.getErrorMsgInvalidPassword(), expected);

	}

	@Test(description = "Login")
	public void tc03_login() {
		LoginPage lp = new LoginPage(driver);
		lp.login("ithlswn@gmail.com", "Ikea1234567");
		String expected = "Hello Elinor!";
		Assert.assertEquals(lp.getMsgLoginHello(), expected);

	}
}
