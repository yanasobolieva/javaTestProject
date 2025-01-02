
import driver.WebDriverHolder;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.SignInPage;

public class ForgotPasswordTest extends BaseTest{

    ForgotPasswordPage forgotPasswordPage;
    SignInPage signInPage;

    @BeforeMethod
    public void beforeMethod(){
        goToUrl(baseUrl + "locatorspractice/");
        signInPage = new SignInPage();
        forgotPasswordPage = signInPage.navigateToForgotPassword();
        pause(1000);
    }

    @Test(dataProvider="SuccessPasswordReset",dataProviderClass=DataSets.class)
    public void successPasswordReset(String name, String email, String phone){
        String confirmMessage = forgotPasswordPage.resetPassword(name,email, phone).getMessage();

        Assert.assertTrue(confirmMessage.contains("Please use temporary password"));
    }

    @AfterClass
    public void afterClass(){
        WebDriverHolder.getInstance().getDriver().close();
    }

}
