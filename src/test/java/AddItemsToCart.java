import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AddItemsToCart {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        String[] productNames = {"Cucumber", "Brocolli"};
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            // formate product name and remove unwanted text
            String[] productName = products.get(i).getText().split("-");
            List a1 = Arrays.asList(productNames);
            int j = 0;
            if (a1.contains(productName[0].trim())) {
                // add to cart
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == productNames.length)
                    break;
            }
        }
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promocode")));
        driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText().contains("Code applied ..!"));
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
        driver.close();
    }
}
