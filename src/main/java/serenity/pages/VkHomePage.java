package serenity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://vk.com")
public class VkHomePage  extends PageObject  {
		public VkHomePage (final WebDriver driver) {
        super(driver);
        driver.manage().window().maximize();
    }
	
	@FindBy(id="index_email")
	private WebElement loginField;

	@FindBy(id="index_pass")
	private WebElement passwordField;
	    
	@FindBy(id="index_login_button")
	private WebElement loginButton;	
	
	public void enterUserLogin (String userLogin) {
		enter(userLogin).into(loginField);
	}
	
	public void enterUserPassword (String userPassword) {
		enter(userPassword).into(passwordField);
	}

	public void loginVk() {
		clickOn(loginButton);
		//waitABit(7000);
	}
	
}
