package serenity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class VkUserProfilePage extends VkHeader {
	
	@FindBy(id="post_field")
	private WebElementFacade postField;
		
	@FindBy(id="send_post")
	private WebElementFacade sendPostButton;
	
	public VkUserProfilePage (final WebDriver driver) {
        super(driver);
    }
	
	public void enterNewPost(String userPost) {
		postField.type(userPost);
    }
	public void sendPost() {
		sendPostButton.click();
	}	
	
	public String getLastPost() {
        return $("//div[@class='_post post page_block all own'][1]//div[@class='wall_text']").getText();
    }	
}
