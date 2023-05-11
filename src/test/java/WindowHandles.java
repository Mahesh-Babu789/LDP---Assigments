import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector("a.blinkingText")).click();
        Set<String> windows = driver.getWindowHandles(); // [parent id , child id]
        Iterator<String>it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0].trim();
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);
    }
}
