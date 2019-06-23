package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

// second step is click on button
public class SecondStep extends Steps {

    public SecondStep(WebDriver driver, LoginPage loginPage) {
        this.driver = driver;
        this.loginPage = loginPage;
    }

    public LoginPage action(){
        loginPage.submitLogin();
        return loginPage;
    }
}
