import driver.WebDriverHolder;

    public class BaseTest {

        public String baseUrl = "https://rahulshettyacademy.com/";

        public void goToUrl (String url) {
            WebDriverHolder.getInstance().getDriver().get(url);
        }

        public void pause(long msec){
            try{
                Thread.sleep(msec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
