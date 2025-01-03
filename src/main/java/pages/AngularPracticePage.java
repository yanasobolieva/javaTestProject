package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AngularPracticePage extends BasePage {
    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(id = "exampleInputPassword1")
    private WebElement passwordField;

    @FindBy(id = "exampleCheck1")
    private WebElement exampleCheckbox;

    @FindBy(id = "exampleFormControlSelect1")
    private WebElement genderDropDown;

    @FindBy(id = "inlineRadio1")
    private WebElement studentRadioButton;

    @FindBy(id = "inlineRadio2")
    private WebElement employedRadioButton;

    @FindBy(id = "inlineRadio3")
    private WebElement entrepreneurRadioButton;

    @FindBy(name = "bday")
    private WebElement birthdayField;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    private WebElement successMessage;

    Select genderList;

    public AngularPracticePage() {super();}

    public AngularPracticePage submitForm(
            String name,
            String email,
            String password,
            boolean exampleCheckbox,
            Gender gender,
            EmploymentStatus status,
            String dateOfBirth    )
    {
        enterName(name)
            .enterEmail(email)
            .enterPassword(password)
            .setExampleCheckbox(exampleCheckbox)
            .setGender(gender)
            .setEmploymentStatus(status)
            .enterBirthday(dateOfBirth)
            .submitButton.click();
        return new AngularPracticePage();
    }

    public AngularPracticePage enterName(String name) {
        this.nameField.sendKeys(name);
        return this;
    }

    public AngularPracticePage enterEmail(String email) {
        this.emailField.sendKeys(email);
        return this;
    }

    public AngularPracticePage enterPassword(String password) {
        this.passwordField.sendKeys(password);
        return this;
    }

    public AngularPracticePage enterBirthday(String dateOfBirth) {
        this.birthdayField.sendKeys(dateOfBirth);
        return this;
    }

    public AngularPracticePage setExampleCheckbox(boolean exampleCheckbox){
        if(exampleCheckbox) {
            this.exampleCheckbox.click();
        }
        return this;
    }

    public AngularPracticePage setGender (Gender gender) {
        genderList = new Select(genderDropDown);
        switch (gender){
            case Male, Female:{
                this.genderList.selectByVisibleText(gender.toString());
                break;
            }
            default: {
                this.genderList.selectByVisibleText("Male");
            }
        }
        return this;
    }

    public enum Gender{
        Male,
        Female
    }

    public AngularPracticePage setEmploymentStatus(EmploymentStatus status) {
        switch (status) {
            case Student: {
                this.studentRadioButton.click();
                break;
            }
            case Employer: {
                this.employedRadioButton.click();
                break;
            }
            case Entrepreneur: {
                this.entrepreneurRadioButton.click();
                break;
            }
            default: {
                this.studentRadioButton.click();
            }
        }
        return this;
    }

    public enum EmploymentStatus{
        Student,
        Employer,
        Entrepreneur
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
