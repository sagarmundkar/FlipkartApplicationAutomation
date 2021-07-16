package pages;

import com.flipkart.test.BaseProgram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login extends BaseProgram {

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
        MobileNo.sendKeys("********");
        Thread.sleep(2000);
        Password.sendKeys("*******");
        Thread.sleep(2000);
        Login.click();
        Thread.sleep(2000);

        String actualUrl = "https://www.flipkart.com/";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);


    }
}
