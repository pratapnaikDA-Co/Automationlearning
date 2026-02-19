package SeleniumLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Script1Updated {
    public static void main(String[] args) throws InterruptedException {
        String userName = "rahul";
        String userPassword = "hello@123";
        String emailID = "rahulshetty@gmail.com";
        String mobileNumber = "9854215678";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(userName);
        driver.findElement(By.name("inputPassword")).sendKeys(userPassword);

        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.className("submit")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        if (driver.findElement(By.xpath("//p[text()='* Incorrect username or password']")).isDisplayed()) {
            userPassword = resetPassword(driver, userName, wait, emailID, mobileNumber);

            driver.findElement(By.id("inputUsername")).sendKeys(userName);
            driver.findElement(By.name("inputPassword")).sendKeys(userPassword);

            Thread.sleep(2000);

            driver.findElement(By.xpath("//button[text()='Sign In']")).click();
            Thread.sleep(Duration.ofSeconds(5));
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
            String success = successMessage.getText();
            System.out.println(success);
            if (successMessage.equals("You are successfully logged in.")) {
                System.out.println("User is logged in to his account successfully");
            }

            driver.findElement(By.className("logout-btn")).click();

            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
            driver.quit();
        }
        else{
            driver.quit();
        }
    }

    public static String resetPassword(WebDriver driver, String userName, WebDriverWait wait, String emailId, String mobileNumber) throws InterruptedException {
        String passwordText = "";
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys(emailId);
        driver.findElement((By.cssSelector("input[type='text']:nth-child(4)"))).sendKeys(mobileNumber);
        WebElement resetButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("reset-pwd-btn")));
        resetButton.click();

        WebElement passwordMsg = driver.findElement(By.className("infoMsg"));
        passwordText = passwordMsg.getText();
        String[] password = passwordText.split("'");
        driver.findElement(By.className("go-to-login-btn")).click();
        Thread.sleep(2000);

        return password[1];

    }
}
