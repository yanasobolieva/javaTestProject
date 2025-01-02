package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessLoginPage extends BasePage{

    @FindBy(className = "login-container")
    private WebElement successMessage;

    @FindBy( className = "logout-btn" )
    private WebElement logOutButton;

    public SuccessLoginPage() {super();}

    public String getMessage() {
        return successMessage.getText();
    }

    public SignInPage logout() {
        logOutButton.click();
        return new SignInPage();
    }
}
