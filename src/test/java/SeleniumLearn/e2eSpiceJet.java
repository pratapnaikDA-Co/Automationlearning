package SeleniumLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.print.attribute.standard.Destination;
import java.time.Duration;
import java.util.List;

public class e2eSpiceJet {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","filepath");
        String departure = "Goa";
        String destination = "Delhi";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.spicejet.com/");

        driver.findElement(By.xpath("//div[text()='From']")).click();
        driver.findElement(By.xpath("//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")).sendKeys(departure);
        String actualDeparture = driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).getDomAttribute("value");
        System.out.println(actualDeparture);
        Assert.assertTrue(actualDeparture.toLowerCase().contains(departure.toLowerCase()),"Goa is selected");

        List<WebElement> departureCities = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep r-b5h31w r-rnv2vh r-5njf8e r-1otgn73']//div[@class=\"css-76zvg2 r-1xedbs3 r-ubezar\"]"));
        for(WebElement City: departureCities){

            if(City.getText().equalsIgnoreCase("gox")){
                System.out.println("Goa is selected as Departure location");
                Assert.assertTrue(true, "Goa is present in the destination");
                break;
            }
        }

        driver.findElement(By.xpath("//div[text()='To']")).click();
        driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).sendKeys(destination);
        String actualDestination = driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).getDomAttribute("value");
        System.out.println(actualDestination);
        Assert.assertTrue(actualDestination.toLowerCase().contains(destination.toLowerCase()), "Delhi is not selected in Destination");





    }
}
