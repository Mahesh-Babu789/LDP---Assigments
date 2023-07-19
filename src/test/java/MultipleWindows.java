import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class MultipleWindows {

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.WINDOW);

        // need window handler ids for both parent and child window in oder to switch between windows
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindowID = it.next();
        String childWindowID = it.next();
        driver.switchTo().window(childWindowID);
        driver.get("https://www.rahulshettyacademy.com/");
        String course = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        driver.close();
        driver.switchTo().window(parentWindowID);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(course);

        // taking screenshot for a web element
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));

        // get height and width
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
        driver.close();
    }
}
