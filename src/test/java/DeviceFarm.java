import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DeviceFarm {
    @Test(invocationCount = 2, threadPoolSize = 2)
    public static void justOpen2Runs() throws MalformedURLException {
        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=kAQ_0CEOoHk3iofs3Tyxaz8FWTKKS-xmzh3n8UngfYsl8raxZLlqKekLBpds2-WPe2tAh-H7M7wHdVxEWyGpOT3ByhKBwxGLIb0MYP28xeRpQOQF63TvOQxkYbG0WZrwAa-HxACyTI2LHm_CKDh2sz3twfSjuxj0_JV4X80pnfK8cTggsO5T1fiaEKvITThv066WNxmZ_XgvTW7rDIlJKCSS7GY-TFZv-0XL8mWHpGho5HSClnMWClDVjk-HKayU7hgwP0T-RXl0KGCMQkb3cype6PIL85Kzu77hzhz1gGFyRo8imr0PalPqHUCFh2g&licenseId=LIC4150&projectName=Project12/";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setCapability("fireflink:deviceType", "public");
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("136");
        WebDriver driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));

        driver.get("https://www.amazon.in");
        driver.quit();



    }
}
