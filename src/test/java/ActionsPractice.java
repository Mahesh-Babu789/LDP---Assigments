import net.bytebuddy.implementation.bytecode.ShiftLeft;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsPractice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://amazon.com/");
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello kitty").doubleClick().build().perform();
        a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).contextClick().build().perform();
//        driver.close();
    }
}
