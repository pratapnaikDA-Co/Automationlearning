package SeleniumLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class assignment2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(By.xpath("//label[text()='Name']//following-sibling::input[@name='name']")).sendKeys("Pratap M Naik");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("pratap10@gmail.om");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Password@123");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdownOptions = new Select(genderDropdown);

        dropdownOptions.selectByVisibleText("Female");
        dropdownOptions.selectByVisibleText("Male");

        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.cssSelector("input[type='date']")).sendKeys("26051999");
        driver.findElement(By.cssSelector(".btn.btn-success")).click();

        System.out.println(driver.findElement(By.className("alert-success")).getText());

driver.quit();

    }
}
