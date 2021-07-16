package pages;

import com.flipkart.test.BaseProgram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Registration extends BaseProgram {
    Logger logger = LogManager.getLogger(Login.class);


    @FindBy(linkText = "New to Flipkart? Create an account")
    WebElement CreateAccount;

    @FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
    WebElement MobileNo;

    @FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
    WebElement Continue;

    @FindBy(xpath = "//input[@type='password']")
    WebElement Password;

    @FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
    WebElement Login;

    public Registration(WebDriver drive){
        PageFactory.initElements(drive,this);
    }
    public void registration() throws InterruptedException {
        logger.info("Create new account");
        CreateAccount.click();
        Thread.sleep(2000);
        logger.info("Enter Email/Mobile No");
        MobileNo.sendKeys("*********");
        Thread.sleep(3000);
        logger.info("Click on continue button");
        Continue.click();
        Thread.sleep(2000);
        logger.info("Enter Password");
        Password.sendKeys("*******");
        Thread.sleep(2000);
        logger.info("Click on login ");
        Login.click();
        Thread.sleep(2000);
    }
}
