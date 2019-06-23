package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

// first step is open the window
public class FirstStep extends Steps {

    public FirstStep(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage action(){
        loginPage = new LoginPage(driver);
        loginPage.getPage();
        return loginPage;
    }


}
