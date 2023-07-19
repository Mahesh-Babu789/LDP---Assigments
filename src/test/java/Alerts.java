import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {

        String name = "Mahesh";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
        Assert.assertTrue(driver.switchTo().alert().getText().contains("Mahesh"));
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();
        driver.close();
    }
}
