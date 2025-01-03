import driver.WebDriverHolder;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AngularPracticePage;

public class AngularPracticeTest extends BaseTest {
    AngularPracticePage angularPracticePage;

    @BeforeMethod
    public void beforeMethod(){
        goToUrl(baseUrl + "angularpractice/");
        angularPracticePage = new AngularPracticePage();
    }

    @Test
    public void successFormSubmission() {
        angularPracticePage.submitForm(
                "test",
                "testemail@mail.com",
                "Test11!!",
                true,
                AngularPracticePage.Gender.Female,
                AngularPracticePage.EmploymentStatus.Student,
                "01012001"
        );
        String successMessage = angularPracticePage.getSuccessMessage();

        Assert.assertTrue(successMessage.contains("Success!"));
    }

    @AfterClass
    public void afterClass(){
        WebDriverHolder.getInstance().getDriver().close();
    }
}