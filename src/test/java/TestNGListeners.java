import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {

    // ITestlistener interface which implements testNG listeners
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("I successfully executed listeners pass code");
    }
}
