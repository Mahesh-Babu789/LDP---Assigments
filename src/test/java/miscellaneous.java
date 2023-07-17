import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class miscellaneous {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().deleteCookieNamed("sessionKey");

        driver.get("http://google.com");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(src, new File("/home/maheshk/Pictures/screenshot.png"));



    }
}
