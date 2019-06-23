package test;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.ResendPage;
import steps.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class Solution {
    WebDriver driver;
    LoginPage loginPage;
    ResendPage resendPage;

    public Solution() {
        System.setProperty("webdriver.chrome.driver", "C:\\chrdriver75\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void main(String[] args) {
        Solution app = new Solution();
        app.doSteps();
        app.quit();
    }

    public void doSteps(){
        doFirstStep();
        doSecondStep();
        doThirdStep();
        doFourthStep();
        doFifthStep();
        doSixthStep();
        doSevenStep();
    }

    void doFirstStep (){
        // open the page
        FirstStep firstStep = new FirstStep(driver);
        loginPage = firstStep.action();
        System.out.println("First step completed");
    }

    void doSecondStep (){
        // click on button near login
        SecondStep secondStep = new SecondStep(driver, loginPage);
        secondStep.action();
        System.out.println("Second step completed");
    }

    void doThirdStep (){
        // fill the email field
        ThirdStep thirdStep = new ThirdStep(driver, loginPage);
        thirdStep.action();
        System.out.println("Third step completed");
    }

    void doFourthStep (){
        // send email
        FourthStep fourthStep = new FourthStep(driver, loginPage);
        resendPage = fourthStep.action();
        System.out.println("Fourth step completed");
    }

    void doFifthStep (){
        // fill the left bar on resend page
        FifthStep fifthStep = new FifthStep(driver, resendPage);
        fifthStep.action();
        System.out.println("Fifth step completed");
    }

    void doSixthStep (){
        // send field resend bar
        SixthStep sixthStep = new SixthStep(driver, resendPage);
        resendPage = sixthStep.action();
        System.out.println("Sixth step completed");
    }

    void doSevenStep (){
        // check twitter button
        SeventhStep seventhStep = new SeventhStep(driver, resendPage);
        seventhStep.action();
        System.out.println("Seven step completed");
    }

    void quit (){
        driver.quit();
    }
}
