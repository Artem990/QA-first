package steps;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ResendPage;

public class FifthStep extends Steps {

    public FifthStep(WebDriver webDriver, ResendPage resendPage) {
        this.driver = webDriver;
        this.resendPage = resendPage;
    }

    public void action(){
        resendPage.fillQASection();
    }
}
