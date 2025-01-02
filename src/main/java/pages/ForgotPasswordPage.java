package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(css = "input[placeholder='Name']")
    private WebElement nameField;

    @FindBy(css = "input[placeholder='Email']")
    private WebElement emailField;

    @FindBy(css = "input[placeholder='Phone Number']")
    private WebElement phoneNumberField;

    @FindBy(className = "go-to-login-btn")
    private WebElement toSignIn;

    @FindBy(className = "reset-pwd-btn")
    private WebElement submit;

    @FindBy(className = "infoMsg")
    private WebElement message;

    public ForgotPasswordPage() {super();}

    public ForgotPasswordPage resetPassword(String name, String email, String phone){
        this.nameField.sendKeys(name);
        this.emailField.sendKeys(email);
        this.phoneNumberField.sendKeys(phone);
        this.submit.click();
        return new ForgotPasswordPage();
    }

    public String getMessage(){
        return message.getText();
    }

    public String getTempPassword(){
        return getMessage().split("'")[1];
    }

}
