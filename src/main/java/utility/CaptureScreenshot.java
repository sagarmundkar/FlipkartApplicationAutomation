package utility;

import com.flipkart.test.BaseProgram;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenshot extends BaseProgram {

    public void Screenshot(String ScreenshotName, String Result){
        String date = new SimpleDateFormat("yyyy_MM_dd_hhmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String destpath = ".\\screenshots\\"+Result+"\\"+ScreenshotName+"_"+date+".png";
        File destfile = new File(destpath);
        try{
            FileUtils.copyFile(srcFile,destfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
