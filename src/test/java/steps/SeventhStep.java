package steps;

import org.openqa.selenium.WebDriver;
import pages.ResendPage;

public class SeventhStep extends Steps {

    public SeventhStep(WebDriver driver, ResendPage resendPage) {
        this.driver = driver;
        this.resendPage = resendPage;
    }

    public void action(){
        resendPage.checkTwitter();
    }

}
