package Testng;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;
import org.testng.asserts.SoftAssert;


public class TestListener implements ITestListener, ISuiteListener {


    private ExtentReports extentReports;
    private ExtentTest extentTest;



    @Override
    public void onStart(ISuite suite) {
        extentReports = new ExtentReports(System.getProperty("user.dir")+ "\\tes2.html");
        extentTest  = extentReports.startTest("test");
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(LogStatus.PASS, "Test Passed: " + result.getMethod().getMethodName());

    }



    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(LogStatus.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ISuite suite) {
        extentReports.flush();

    }
}
