package pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    //By emailButtonNearLogin = By.xpath("//button[@class='wg-header__free-trial-button wg-btn wg-btn--green'][1]");
    By emailButtonNearLogin = By.cssSelector("div.wg-header__cell.wg-header__cell--xs-3.wg-header__cell--sm-6.wg-header__cell--md-5.wg-header__cell--xl-5 > div > form > button");
    By emailFieldPopup = By.cssSelector("div.wg-modal.modal-form-trial.wg-modal--col-1.wg-modal--pro.wg-modal--size-1.wg-modal--home-enterprise > form > label > input");
    By createAccountButtonInPopup = By.cssSelector("div.wg-modal.modal-form-trial.wg-modal--col-1.wg-modal--pro.wg-modal--size-1.wg-modal--home-enterprise > form > label > button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 1. открытие страницы
    @Test
    public void getPage(){
        driver.get("https://www.wrike.com/");
    }

    // 2. нажатие на кнопку
    @Test
    public LoginPage submitLogin(){
        // wait load the page
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailButtonNearLogin)));
        driver.findElement(emailButtonNearLogin).click();
        return new LoginPage(driver);
    }

    // 3. Fill the email field
    @Test
    public void fillEmailField (String email) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailFieldPopup)));
        driver.findElement(emailFieldPopup).sendKeys(email);
    }

    // 4. Open the resend page
    @Test
    public ResendPage createAnAccaunt (){
        driver.findElement(createAccountButtonInPopup).click();
        // check if url is open
        WebDriverWait wait = new WebDriverWait(driver, 20);
        boolean newUrlIsOpen = new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("resend"));
        // Assets check url
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.wrike.com/resend/");
        if (newUrlIsOpen){
            return new ResendPage(driver);
        }else {
            System.out.println("Some problem with redirect");
            return null;
        }
    }
}
