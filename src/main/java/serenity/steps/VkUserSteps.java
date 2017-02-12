package serenity.steps;

import static org.assertj.core.api.Assertions.*;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import serenity.pages.VkHeader;
import serenity.pages.VkHomePage;
import serenity.pages.VkLoginPage;
import serenity.pages.VkUserProfilePage;

public class VkUserSteps extends ScenarioSteps{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VkUserSteps(final Pages pages) {
		super(pages);
	}
	
	VkHomePage vkHomePage;
	VkHeader vkHeader;
	VkUserProfilePage vkUserProfilePage;
	VkLoginPage vkLoginPage;
	
	@Step
    public void openVkHomePage() {
		vkHomePage.open();
    }
	
	@Step
	public void loginVk(String userLogin,String userPassword) {
		vkHomePage.enterUserLogin(userLogin);
		vkHomePage.enterUserPassword(userPassword);
		vkHomePage.loginVk();		
	}
	
	@Step
	public void openUserProfilePage() {
		vkHeader.openUserProfile();
	}
	
	@Step
	public void addPost(String userPost) {
		vkUserProfilePage.enterNewPost(userPost);
		vkUserProfilePage.sendPost();		
	}
	
	@Step
	public void wallShouldContainPost(String userPost) {
		assertThat(vkUserProfilePage.getLastPost()).isEqualTo(userPost);		
	}	
	
	@Step
	public void logoutVk() {
		vkHeader.openMenu();		
		vkHeader.logoutVk();
	}
	
	@Step
	public void checkThatLoginPageHasOpened() {
		vkLoginPage = getPages().currentPageAt(VkLoginPage.class);
	}	
}
