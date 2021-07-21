package pages;

import com.flipkart.test.BaseProgram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ScreenRecording;

public class Home extends BaseProgram {
    Logger logger = LogManager.getLogger(Login.class);

    @FindBy(xpath = "//input[@type='text']")
    WebElement searchProduct;

    @FindBy(xpath = "//button[@class='L0Z3Pu']")
    WebElement Search;

    public Home(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void SearchProduct() throws InterruptedException {
        ScreenRecording.startRecord("Home");

        logger.info("Enter product name to search");
        searchProduct.sendKeys("Mobile");
        Thread.sleep(2000);
        logger.info("Click on search");
        Search.click();
        Thread.sleep(3000);
        ScreenRecording.stopRecord();
    }
}
