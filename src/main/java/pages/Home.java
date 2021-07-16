package pages;

import com.flipkart.test.BaseProgram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home extends BaseProgram {

    @FindBy(xpath = "//input[@type='text']")
    WebElement searchProduct;

    @FindBy(xpath = "//button[@class='L0Z3Pu']")
    WebElement Search;

    public Home(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void SearchProduct() throws InterruptedException {
        searchProduct.sendKeys("Mobile");
        Thread.sleep(2000);
        Search.click();
        Thread.sleep(3000);
    }
}
