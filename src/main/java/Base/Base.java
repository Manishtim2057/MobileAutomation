package Base;

import com.codeborne.selenide.WebDriverRunner;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

@BeforeClass
    public void configureAppium() throws MalformedURLException, InterruptedException {

        //Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 7 API 31");
//        options.setDeviceName("realme RMX3471");
        options.setApp("D:\\AndroidAutomation\\Demo\\Android Automation\\src\\main\\java\\Resource\\ApiDemos-debug.apk");
        options.setPlatformName("Android");
        options.setCapability("PlatformVersion", "12.0");
//         options.setCapability(MobileCapabilityType.UDID, "d68aac78");
        options.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
//        options.setCapability("appActivity", "com.androidsample.generalstore.MainActivity");
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         WebDriverRunner.setWebDriver(driver);
    }
    public void ScrollToEnd(){
        boolean canScrollMore;
        do  {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }
        while (canScrollMore);
    }
    public void ScrollToElement(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextSwitcher\"));"));
    }

    public void SwipeAction(WebElement Element, String swipeDirection){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement) Element).getId(),
                "direction", swipeDirection,
                "percent", 0.75
        ));
    }

    @AfterEach
    public void StopAndQuit() {
//        driver.closeApp();
//			driver.quit();
//			service.stop();

        if(service != null){
            service.stop();
        }

    }
}




