package utility;

import com.flipkart.test.BaseProgram;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenshot extends BaseProgram {

    public void Screenshot(String ScreenshotName, String Result){
        String date = new SimpleDateFormat("yyyy_MM_dd_hhmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        try{
            Allure.addAttachment(ScreenshotName+"_"+date,"image/png",new FileInputStream(srcFile),"png");
            //Allure.addAttachment(ScreenshotName+"_"+date,"image/png",new FileInputStream(srcFile));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String destpath = ".\\screenshots\\"+Result+"\\"+ScreenshotName+"_"+date+".png";
        File destfile = new File(destpath);
        try{
            FileUtils.copyFile(srcFile,destfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
