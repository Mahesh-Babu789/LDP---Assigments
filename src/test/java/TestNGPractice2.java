import org.testng.annotations.*;

import java.net.URL;

public class TestNGPractice2 {

    @AfterTest
    public void afterTest() {
        System.out.println("I will execute after test execution");
    }

    @BeforeMethod
    public void bfMethod() {
        System.out.println("I will execute first before each and every test");
    }

    @AfterSuite
    public void afSuite() {
        System.out.println("I will execute last");
    }
    @Parameters({"URL"})
    @Test
    public void MobileLoginUrl(String url) {
        System.out.println(url);
    }
    @Test(groups = { "smoke" })
    public void MobileLoginCar() {
        System.out.println("Mobile login");
    }

    @Test(timeOut = 3000)
    public void WebLoginCar() {
        System.out.println("Web login");
    }

    @Test(dependsOnMethods = "WebLoginCar")
    public void AppiumLoginCar() {
        System.out.println("Appium login");
    }

    @Test(enabled = false)
    public void APILoginCar() {
        System.out.println("API login");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("I will execute first");
    }

    @BeforeSuite
    public void bfSuite() {
        System.out.println("I am number one");
    }
}
