package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "inputUsername")
    private WebElement userNameField;

    @FindBy(name = "inputPassword")
    private WebElement passwordField;

    @FindBy(css = "input[type='checkbox'][value='rmbrUsername']")
    private WebElement rememberCheckbox;

    @FindBy(css = "input[type='checkbox'][value='agreeTerms']")
    private WebElement agreeCheckbox;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPasswordLink;

    @FindBy(css = "button[type='submit']")
    private WebElement submit;

    @FindBy(className = "error")
    private WebElement errorMessage;

    public SignInPage() {super();}

    public SuccessLoginPage signIn(String username, String password, boolean rememberUser, boolean agreeConditions) {
        enterUserName(username)
                .enterUserPassword(password)
                .rememberUser(rememberUser)
                .agreeWithConditions(agreeConditions)
                .submit.click();
        return new SuccessLoginPage();
    }

    public SignInPage errorSignIn(String username, String password, boolean rememberUser, boolean agreeConditions){
        enterUserName(username)
                .enterUserPassword(password)
                .rememberUser(rememberUser)
                .agreeWithConditions(agreeConditions)
                .submit.click();
        return new SignInPage();
    }

    public SignInPage enterUserName(String username) {
        this.userNameField.sendKeys(username);
        return this;
    }

    public SignInPage enterUserPassword(String password) {
        this.passwordField.sendKeys(password);
        return this;
    }

    public SignInPage agreeWithConditions (boolean agree) {
        if (agree) {
            this.agreeCheckbox.click();
        }
        return this;
    }

    public SignInPage rememberUser (boolean agree) {
        if (agree) {
            this.rememberCheckbox.click();
        }
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public ForgotPasswordPage navigateToForgotPassword(){
        forgotPasswordLink.click();
        return new ForgotPasswordPage();
    }

    public boolean isPageLoaded() {
        return userNameField.isDisplayed() && passwordField.isDisplayed() && submit.isDisplayed();
    }

}
