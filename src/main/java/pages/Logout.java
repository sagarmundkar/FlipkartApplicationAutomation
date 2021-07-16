package pages;

import com.flipkart.test.BaseProgram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Logout extends BaseProgram {

    @FindBy(xpath = "//*[contains(text(),'Logout')]")
    WebElement logOut;

    public Logout(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void LogoutApplocation() throws InterruptedException, AWTException {
        Robot r = new Robot();
        r.mouseMove(988,26);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        logOut.click();
        Thread.sleep(2000);

        String actualUrl = "https://www.flipkart.com/";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);


    }
}