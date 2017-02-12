package serenity;
import java.util.Properties;
import org.junit.Test;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithDriver;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import serenity.PropertiesReader;
import serenity.steps.VkUserSteps;
import org.openqa.selenium.WebDriver;

@Story(Application.UserActions.AddingNewVkPost.class)
@RunWith(SerenityRunner.class)
@Concurrent(threads="1")

public class AddingNewVkPostTest {

	 public Properties userData;
	    {
	        userData = PropertiesReader.readProperties("Vk.properties");
	    }
	
	@Managed
    public WebDriver webdriver;
	
	@ManagedPages(defaultUrl="https://vk.com")
	public Pages pages;

    @Steps
    public VkUserSteps steps;
    
    @WithDriver("iexplorer")
    //@WithDriver("chrome")
    //@WithDriver("firefox")
    @Test
    public void testing_ability_adding_vk_post() {
        steps.openVkHomePage();
    	steps.loginVk(
    			userData.getProperty("vklogin"),
    			userData.getProperty("vkpassword")
    			);
    	steps.openUserProfilePage();
    	steps.addPost(
    			userData.getProperty("userNewPost")
    			);
    	steps.wallShouldContainPost(
    			userData.getProperty("userNewPost"));
    	steps.logoutVk();
    	steps.checkThatLoginPageHasOpened();
    }
}