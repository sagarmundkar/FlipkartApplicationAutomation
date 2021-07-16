package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.CaptureScreenshot;


public class ListenerTest implements ITestListener {
    CaptureScreenshot screenshot = new CaptureScreenshot();

    /**
     * onTestFailure method is used to perform action when test case is failed
     * @param Result ITestResult interface is used to get the result of testcase
     */
    @Override
    public void onTestFailure(ITestResult Result)
    {
        System.out.println("The name of the testcase failed is :"+Result.getName());
        screenshot.Screenshot(Result.getName(), "failed");
    }
    /**
     * onTestSuccess method is used to perform the action when test case is passes
     * @param Result ITestResult interface is used to get the result of testcase
     */
    @Override
    public void onTestSuccess(ITestResult Result)
    {
        System.out.println("The name of the testcase passed is :"+Result.getName());
        screenshot.Screenshot(Result.getName(),"Success");
    }
    @Override
    public void onTestStart(ITestResult Result){
        System.out.println("Test is starting:" +Result.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am on finish method:" +iTestContext.getName());
    }

}
