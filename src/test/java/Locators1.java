import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/home/maheshk/Documents/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String myPassword = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.findElement(By.id("inputUsername")).sendKeys("Mahesh");
        driver.findElement(By.name("inputPassword")).sendKeys(myPassword);
        Thread.sleep(2000);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        String successMsg = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(successMsg, "You are successfully logged in.");
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".form h1")).getText(), "Sign in");
        driver.close();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        String[] passwordArray = passwordText.split("'");
        String myPassword = passwordArray[1].split("'")[0];
        return myPassword;
    }

}