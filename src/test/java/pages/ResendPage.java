package pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ResendPage {
    WebDriver driver;
    // necessary items on resend page
    By firstBar = By.cssSelector("div.wg-cell.wg-cell--md-6.wg-cell--lg-7 > div > form > div:nth-child(6)");
    By secondBar = By.cssSelector("div.wg-cell.wg-cell--md-6.wg-cell--lg-7 > div > form > div:nth-child(8)");
    By thirdBar = By.cssSelector("div.wg-cell.wg-cell--md-6.wg-cell--lg-7 > div > form > div:nth-child(10)");
    By submitQuiz = By.cssSelector("div.wg-cell.wg-cell--md-6.wg-cell--lg-7 > div > form > button");
    By twitterButton = By.xpath("//li[@class='wg-footer__social-item'][1]");
    By twitterButtonLink = By.xpath("//a[@href='https://twitter.com/wrike']");
    By twitterButtonImage = By.cssSelector("div.wg-footer__social-block > div > ul > li:nth-child(1) > a > svg > use");
    By thankYouMessage = By.xpath("//h3[text()='Thanks for helping us out!']");


    public ResendPage(WebDriver driver) {
        this.driver = driver;
    }

    // 5. Fill the Q&A section on resend page
    @Test
    public void fillQASection (){
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstBar)));
        // check on clickability
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(this.firstBar)));
        WebElement firstBar = driver.findElement(this.firstBar);
        selectRandomElementFromBar(firstBar);

        // check on clickability
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(this.secondBar)));
        WebElement secondBar = driver.findElement(this.secondBar);
        selectRandomElementFromBar(secondBar);

        // check on clickability
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(this.thirdBar)));
        WebElement thirdBar = driver.findElement(this.thirdBar);
        selectRandomElementFromBar(thirdBar);
    }

    public void selectRandomElementFromBar (WebElement Bar){
        List<WebElement> berItem = Bar.findElements(By.tagName("button"));
        Random random = new Random();
        int numberButtonInBar = random.nextInt(berItem.size() -1);
        berItem.get(numberButtonInBar).click();

    }

    // 6. submit quiz
    @Test
    public ResendPage submitQuiz (){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        // check on clickable
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(submitQuiz)));
        driver.findElement(submitQuiz).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(thankYouMessage)));
        // check Resend email with Assertion
        Assert.assertEquals(driver.findElement(thankYouMessage).getText(), "Thanks for helping us out!");
        return this;
    }

    // 7. check the twitter button and link and image on button
    @Test
    public ResendPage checkTwitter (){
        driver.findElement(twitterButton);

        driver.findElement(twitterButtonLink);
        driver.findElement(twitterButtonImage);
        return this;
    }


}
