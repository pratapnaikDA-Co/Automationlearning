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
        String adultPassengerCount = "5";
        String currency = "AED";
        String[] departureDate = {"28","February","2026"};
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
                break;
            }
        }

        driver.findElement(By.xpath("//div[text()='To']")).click();
        driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).sendKeys(destination);
        String actualDestination = driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).getDomAttribute("value");
        System.out.println(actualDestination);
        Assert.assertTrue(actualDestination.toLowerCase().contains(destination.toLowerCase()), "Delhi is not selected in Destination");

        driver.findElement(By.xpath("//div[text()=\""+departureDate[1]+"\" and text()='"+departureDate[2]+"']/..//following-sibling::div//div//div//div//div[text()='"+departureDate[0]+"']")).click();

        String returnDateEnable= driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style");
        if (returnDateEnable.contains("background-color: rgb(238, 238, 238)")){
            Assert.assertTrue(true);
        }
        else{
            Assert.fail("Return date is enabled");
        }
        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
        for(int i = 1; i<5;i++){
            driver.findElement(By.xpath("//div[text()='Adult']/..//following-sibling::div//div[@data-testid=\"Adult-testID-plus-one-cta\"]")).click();
        }

        String actualCountofPassenger = driver.findElement(By.xpath("//div[@data-testid=\"home-page-travellers\"]//div//div[@class=\"css-76zvg2 css-bfa6kz r-homxoj r-ubezar\"]")).getText();
        System.out.println(actualCountofPassenger);
        String[] countActual = actualCountofPassenger.split(" ");
        String ActualPassenger = countActual[0];

        Assert.assertEquals(ActualPassenger, adultPassengerCount,"count of passengers doesnot match");

        driver.findElement(By.xpath("//div[text()='Currency']")).click();
        driver.findElement(By.xpath("//div[@class=\"css-1dbjc4n\"]//div//div[text()='"+currency+"']")).click();
        driver.findElement(By.xpath("//div[@data-testid=\"home-page-flight-cta\"]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='1']/..//following-sibling::div[text()='Flights']")).isDisplayed(),"Something went wrong");

        driver.quit();


    }
}
