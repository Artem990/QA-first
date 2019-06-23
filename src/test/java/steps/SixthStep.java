package steps;

import org.openqa.selenium.WebDriver;
import pages.ResendPage;

public class SixthStep extends Steps {

    public SixthStep(WebDriver driver, ResendPage resendPage) {
        this.driver = driver;
        this.resendPage = resendPage;
    }

    public ResendPage action(){
        resendPage = resendPage.submitQuiz();
        return resendPage;
    }
}
