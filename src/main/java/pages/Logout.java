package pages;

import com.flipkart.test.BaseProgram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Logout extends BaseProgram {
    Logger logger = LogManager.getLogger(Login.class);

    @FindBy(xpath = "//div[@class = 'exehdJ']")
    WebElement sagar;

    @FindBy(xpath = "//div[@class = '_3vhnxf']")
    WebElement logOut;

    public Logout(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void LogoutApplocation() throws InterruptedException, AWTException {
        Actions actions = new Actions(this.driver);
        actions.moveToElement(this.sagar).build().perform();
        Thread.sleep(2000);
        actions.moveToElement(this.logOut).click().perform();
        logger.info("Click on logout button");
        Thread.sleep(3000);

    }
}
