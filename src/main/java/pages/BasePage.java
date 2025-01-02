package pages;

import org.openqa.selenium.support.PageFactory;
import driver.WebDriverHolder;


public class BasePage {

    public BasePage() {
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
    }

}
