import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingCalender {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.path2usa.com/travel-companions");
//April 23
        driver.findElement(By.cssSelector("form[name='Travel Companion Form'] .elementor-form-fields-wrapper .elementor-field-type-date input")).click();

        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May")) {
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }

        List<WebElement> dates = driver.findElements(By.className("day"));
//Grab common attribute//Put into list and iterate
        int count = driver.findElements(By.className("day")).size();

        for (int i = 0; i < count; i++) {
            String text = driver.findElements(By.className("day")).get(i).getText();
            if (text.equalsIgnoreCase("21")) {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }

        }
    }

}