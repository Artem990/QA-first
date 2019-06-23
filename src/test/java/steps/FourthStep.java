package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ResendPage;

public class FourthStep extends Steps {

    public FourthStep(WebDriver driver, LoginPage loginPage) {
        this.driver = driver;
        this.loginPage = loginPage;
    }

    public ResendPage action(){
        resendPage = loginPage.createAnAccaunt();
        return resendPage;
    }

}
