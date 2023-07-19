import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class UpdatedDropdown {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
//        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        int i = 0;
        while (i < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), (i + 1) + " Adult");
        driver.close();
    }
}
