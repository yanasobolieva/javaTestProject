import driver.WebDriverHolder;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;
import pages.SuccessLoginPage;

public class SignInTest extends BaseTest {
    SignInPage signInPage;
    SuccessLoginPage successLoginPage;

    @BeforeMethod
    public void beforeMethod(){
        goToUrl(baseUrl + "locatorspractice/");
        signInPage = new SignInPage();
    }

    @Test(dataProvider="SuccessLoginDataProvider",dataProviderClass=DataSets.class)
    public void successLogin(String username,String userPassword,boolean rememberUser,boolean agreeWithConditions) {
        successLoginPage = signInPage.signIn(username,userPassword,rememberUser,agreeWithConditions);
        pause(1000);
        String successLoginMessage = successLoginPage.getMessage();
        successLoginPage.logout();

        Assert.assertTrue(successLoginMessage.toLowerCase().contains(username.toLowerCase()));
        Assert.assertTrue(successLoginMessage.contains("You are successfully logged in."));
    }

    @Test(dataProvider="ErrorLoginDataProvider",dataProviderClass=DataSets.class)
    public void errorLogin(String username,String userPassword,boolean rememberUser,boolean agreeWithConditions){
        String errorMessage = signInPage
                .errorSignIn(username,userPassword,rememberUser,agreeWithConditions)
                .getErrorMessage();

        Assert.assertTrue(errorMessage.contains("* Incorrect username or password"));
    }

    @AfterClass
    public void afterClass(){
        WebDriverHolder.getInstance().getDriver().close();
    }
}
