package ApiDemos_Gestures;

import Base.Base;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;

import static ApiDemos_Gestures.ApiElements.seekBar;
import static com.codeborne.selenide.Selenide.$x;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class DemoGestures extends Base {
TestMethodOrder Ascending;


    @Order(1)
    @Test
    public void checkBoxGestures() throws InterruptedException, MalformedURLException {
        configureAppium();
        ApiElements.Preference.click();
    ApiElements.Switch.click();
    ApiElements.CheckBoxPreference.click();
    Thread.sleep(1000);
    }

     @Order(2)
    @Test
    public void ToggleButton() throws InterruptedException, MalformedURLException {
         configureAppium();
    ApiElements.Preference.click();
    ApiElements.Switch.click();
    ApiElements.SwitchPerference.click();
    Thread.sleep(1000);
    }


    @Test
    public void scrollGesture() throws MalformedURLException, InterruptedException {
        configureAppium();
        ApiElements.ViewsOption.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextSwitcher\"));"));
       ApiElements.TextSwitcher.click();

    }
    @Test
    public void seekerGesture() throws MalformedURLException, InterruptedException {
        configureAppium();
        ApiElements.ViewsOption.click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Seek Bar\"));"));
        seekBar.should((Condition.visible));
        seekBar.click();
        SelenideElement seekPoint = $x(("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.SeekBar"));

// Get the height of the seek bar (vertical position)
        int startX = seekPoint.getLocation().getX();
        int endX =  startX + seekPoint.getSize().getWidth();
        int middleY =  seekPoint.getLocation().getY()+seekPoint.getSize().getHeight() / 2;


        int desiredProgress = 80;
        int targetX =  startX + (int) (seekPoint.getSize().getWidth() * (desiredProgress / 100.0));
new TouchAction<>(driver)
        .press(PointOption.point(startX, middleY))
        .moveTo(PointOption.point(targetX, middleY))
        .release()
        .perform();


    }

    @Test
    public void SwipeGesture() throws MalformedURLException, InterruptedException {
        configureAppium();
        ApiElements.ViewsOption.click();
        ApiElements.Gallery.click();
        ApiElements.Photos.click();
        WebElement firstImage = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[1]"));


        WebElement thirdImage = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[3]"));
        WebElement thirdLastImage = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[2]"));

        WebElement Images = driver.findElement(By.id("io.appium.android.apis:id/gallery"));

        //Before Swipe
        String Firstvalue = firstImage.getAttribute("focusable");
        Assert.assertEquals("true", Firstvalue);

        //Perform Swipe
        SwipeAction(firstImage , "left");



        //After Swipe
        String SecondValue = firstImage.getAttribute("focusable");
        Assert.assertEquals("false", SecondValue);
    }

}
