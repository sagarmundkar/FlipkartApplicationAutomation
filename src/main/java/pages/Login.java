package pages;

import com.flipkart.test.BaseProgram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.ScreenRecording;

public class Login extends BaseProgram {
    Logger logger = LogManager.getLogger(Login.class);


    @FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
    WebElement MobileNo;

    @FindBy(xpath = "//input[@type='password']")
    WebElement Password;

    @FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
    WebElement Login;

    public Login(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void LoginApplication() throws InterruptedException {
        ScreenRecording.startRecord("LoginApplication");
        logger.info("Enter Email/Mobile No");
        MobileNo.sendKeys("*******");
        Thread.sleep(3000);
        logger.info("Enter Password");
        Password.sendKeys("*******");
        Thread.sleep(2000);
        logger.info("click on login button");
        Login.click();
        Thread.sleep(2000);

        String actualUrl = "https://www.flipkart.com/";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        ScreenRecording.stopRecord();

    }
}
