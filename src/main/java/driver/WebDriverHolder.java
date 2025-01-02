package driver;

import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class WebDriverHolder {
    private static WebDriverHolder instance = null;
    private static WebDriver driver;

    private WebDriverHolder() {
        driver = WebDriverFactory.initDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriverHolder getInstance() {
        if (instance==null) {
            instance = new WebDriverHolder();
        }
        return instance;
    }

    public WebDriver getDriver() { return driver; }

    public void killDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
