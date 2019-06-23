package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.util.Random;

public class ThirdStep extends Steps {

    public ThirdStep(WebDriver driver, LoginPage loginPage) {
        this.driver = driver;
        this.loginPage = loginPage;
    }

    public void action(){
        String email = generateRandomText();
        loginPage.fillEmailField(email);
    }


    public String generateRandomText (){
        int length = 6;
        String numberLaters = "abcdefghigklmnopqrstuvwxyz";
        Random random = new Random();
        char [] text = new char[length];
        for (int i = 0; i < length; i++){
            text[i] = numberLaters.charAt(random.nextInt(numberLaters.length()));
        }

        String randomString = "";
        for (Character item : text){
            randomString += item;
        }

        String constPartMail = "wpt@wriketask.qaa";
        return randomString.concat(constPartMail);
    }
}
