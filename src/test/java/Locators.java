import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) throws Exception {


        System.setProperty("webdriver.chrome.driver", "/home/maheshk/Documents/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.findElement(By.id("inputUsername")).sendKeys("Mahesh");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy1");
        Thread.sleep(2000);
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector(".error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#inputUsername")).clear();
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Mahesh");
        driver.findElement(By.cssSelector("#inputUsername")).clear();
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("signInBtn")).click();
        driver.close();
    }
}