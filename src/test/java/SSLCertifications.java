import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Driver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SSLCertifications {
    public static void main(String[] args) throws InterruptedException, IOException {

        // chromedriver.chromium.org/capabilities - where we find all the chrome capabilities

        ChromeOptions options = new ChromeOptions();

        // if you want to pass a proxy orgument we need to create a proxy ref variable using proxy class
        // https://chromedriver.chromium.org/capabilities

//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("ipaddress:8888");
//        options.setCapability("proxy", proxy);
//
//        // if we want to download an object to a specific location, use the below options
//
//        Map<String, Object> prefs = new HashMap<String, Object>();
//        prefs.put("download.default_directory", "/directory/path");
//        options.setExperimentalOption("prefs", prefs);

//        options.setAcceptInsecureCerts(true);
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.get("https://expired.badssl.com");
//        System.out.println(driver.getTitle());
//
//        // how to take screenshots
//
//        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(src, new File("/home/maheshk/Documents/Mahesh-Imp/screenshot.png"));

        // how to handle broken links

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert  a = new SoftAssert();

        for (WebElement link: links) {
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            a.assertTrue(respCode < 400, "The link with the text "+ link.getText() +"is broken with code "+respCode);
        }
        a.assertAll();
//        HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
//        conn.setRequestMethod("HEAD");
//        conn.connect();
//        int respCode = conn.getResponseCode();
//        System.out.println(respCode);
        driver.close();
    }
}
