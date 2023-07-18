import org.testng.annotations.*;

public class TestNGPractice1 {
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
    @Test(groups = { "smoke" })
    public void MobileLogin() {
        System.out.println("Mobile login");
    }

    @Test(groups = { "smoke" })
    public void WebLogin() {
        System.out.println("Web login");
    }

    @Test
    public void APILogin() {
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
