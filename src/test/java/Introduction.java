import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Introduction {

    public static void main(String[] args) {

        // chromedriver.exe - chrome browser
        System.setProperty("webdriver.chrome.driver", "/home/maheshk/Documents/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Firfox Launch

        System.setProperty("webdriver.gecko.driver", "/home/maheshk/Documents/geckodriver-v0.33.0-linux-aarch64/geckodriver");
        WebDriver driver1  = new FirefoxDriver();

        // Edgedriver
        System.setProperty("webdriver.edge.driver", "/home/maheshk/Documents/msedgedriver");
        WebDriver driver2  = new EdgeDriver();

        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }

}