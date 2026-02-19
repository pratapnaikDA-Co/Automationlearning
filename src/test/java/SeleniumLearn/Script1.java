package SeleniumLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Script1 {
    public static void main(String[] args) throws InterruptedException {
        String userName = "rahul";
        String userPassword = "hello@123";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(userName);
        driver.findElement(By.name("inputPassword")).sendKeys(userPassword);

        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.className("submit")).click();

        boolean isDisplayed = driver.findElement(By.xpath("//p[text()='* Incorrect username or password']")).isDisplayed();

        if (isDisplayed) {
            driver.findElement(By.linkText("Forgot your password?")).click();
        }
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rahulshettyacademyew");
        driver.findElement(By.cssSelector("input[placeholder='Name']")).clear();
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("rahulshetty@gmail.com");
        driver.findElement((By.cssSelector("input[type='text']:nth-child(4)"))).sendKeys("9854215678");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement resetButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("reset-pwd-btn")));
        resetButton.click();

        WebElement passwordMsg = driver.findElement(By.className("infoMsg"));
        boolean passwordTextMsgIsDisplayed = passwordMsg.isDisplayed();
        String passwordText = "";
        if (passwordTextMsgIsDisplayed) {
            passwordText = passwordMsg.getText();
            String[] password = passwordText.split("'");
            System.out.println(password[1]);
            userPassword = password[1];
            driver.findElement(By.className("go-to-login-btn")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("inputUsername")).sendKeys(userName);
            driver.findElement(By.name("inputPassword")).sendKeys(userPassword);

            Thread.sleep(2000);

            driver.findElement(By.xpath("//button[text()='Sign In']")).click();
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
            String success = successMessage.getText();
            System.out.println(success);
            if(successMessage.equals("You are successfully logged in.")) {
                System.out.println("User is logged in to his account successfully");
            }

            driver.findElement(By.className("logout-btn")).click();
        }
        else {
            System.out.println("User password is correct");
            driver.quit();
        }
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.quit();
        }
}