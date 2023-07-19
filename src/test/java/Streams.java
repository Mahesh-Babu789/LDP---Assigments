import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    @Test
    public void regular() {

        ArrayList<String> names = new ArrayList<String>();
        names.add("Arjun");
        names.add("Arvind");
        names.add("Mahesh");
        names.add("Raj");
        names.add("siri");
        names.add("Puri");

        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (name.startsWith("A")) {
                count ++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void StreamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Arjun");
        names.add("Arvind");
        names.add("Mahesh");
        names.add("Raj");
        names.add("siri");
        names.add("Puri");

        Long x = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(x);

        long c = Stream.of("Arjun","Amar","Arun","Arvind","Akash").filter(s -> s.startsWith("A")).count();
        System.out.println(c);

        Stream.of("Arjun","kamar","Arun","Arvind","Mahesh").filter(s -> s.startsWith("A")).forEach(s -> System.out.println(s));

        Stream.of("Arjun","kamar","Arun","Arvind","Mahesh").filter(s -> s.length() > 2).forEach(s -> System.out.println(s));
    }

    @Test
    public void StreamMap() {
        Stream.of("Arjun","Amar","Arun","Arvind","Mahesh").filter(s -> s.endsWith("h")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        // sort the list

        Stream.of("Arjun","Amar","Arun","Mahesh","Arvindh").filter(s -> s.endsWith("h")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        System.out.println("*********************************************");
        // merging streams

        List<String> names1 = Arrays.asList("A","F","G","D");
        List<String> names2 = Arrays.asList("E","F","C","H");

        Stream<String> newList = Stream.concat(names1.stream(), names2.stream());
//        newList.forEach(s -> System.out.println(s));
        System.out.println("**********************************");
//        newList.sorted().forEach(s -> System.out.println(s));

        boolean flag = newList.anyMatch(s -> s.equalsIgnoreCase("D"));
        Assert.assertTrue(flag);
    }

    @Test
    public void StreamCollect() {

        // old list
        // modify to old list and make new list
        List<String> ls = Stream.of("Arjun","Amar","Arun","Arvind","Mahesh").filter(s -> s.startsWith("A")).sorted().collect(Collectors.toList());
        System.out.println(ls.get(0));

        // print unique number

        List<Integer> values = Arrays.asList(1,2,8,8,4,5,6,6,7,8);
        List<Integer> unique = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(unique.get(2));
    }

    @Test
    public void practice1() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList = list.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(originalList.equals(sortedList));

        // scan the name column with gettext Rice and print the price of the Rice
        List<String> price;
        do
        {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggies(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if(price.size()<1)
            {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while(price.size()<1);
    }

        // It simply conveys elements from a source such as a data structure, an array, or an I/O channel, through a pipeline of computational operations
        private static String getPriceVeggies(WebElement s) {
            String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
            return priceValue;
        }


    @Test
    public void searchVeggies() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/th[1]"));
        List<WebElement> filterdList = veggies.stream().filter(v -> v.getText().contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(veggies.size(), filterdList.size());
    }
}
