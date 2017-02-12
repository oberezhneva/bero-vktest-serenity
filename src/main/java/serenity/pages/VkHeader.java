package serenity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;

public class VkHeader extends PageObject  {
		
	public VkHeader (WebDriver driver) {
        super(driver);
        driver.manage().window().maximize();
    }
	
	@FindBy(id="l_pr")
	private WebElement userProfileButton;
			
	@FindBy(id="top_profile_link")
	private WebElement menuButton;
	
	@FindBy(id="top_logout_link")
	private WebElement logoutButton;
	
	public void openUserProfile() {
		clickOn(userProfileButton);		
	}
	
	public void openMenu() {
		clickOn(menuButton);
	}
		
	public void logoutVk() {
		clickOn(logoutButton);
	}	
}
