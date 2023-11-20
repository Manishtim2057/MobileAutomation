package ApiDemos_Gestures;

import Base.Base;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Collections;

import static ApiDemos_Gestures.ApiElements.seekBar;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class DemoGestures extends Base {

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
    //android.widget.Switch[@content-desc="Standard switch"]
    //android.widget.Switch[@content-desc="Standard switch"]

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
        WebElement firstImage = $x("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[1]");


        WebElement thirdImage = $x("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[3]");
        WebElement thirdLastImage = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[2]"));

        WebElement Images = $(By.id("io.appium.android.apis:id/gallery"));

        //Before Swipe
        String Firstvalue = firstImage.getAttribute("focusable");
        Assert.assertEquals("true", Firstvalue);

        //Perform Swipe
        SwipeAction(firstImage , "left");



        //After Swipe
        String SecondValue = firstImage.getAttribute("focusable");
        Assert.assertEquals("false", SecondValue);
    }
    @Test
    public void IncrementOnCount() throws MalformedURLException, InterruptedException {
        configureAppium();
        ApiElements.ViewsOption.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextSwitcher\"));"));
        ApiElements.TextSwitcher.click();
        ApiElements.nextButton.click();
        ApiElements.nextButton.shouldBe(Condition.visible, Duration.ofSeconds(3));

    }

       @Test
   public void dragAndDrop() throws MalformedURLException, InterruptedException {
       configureAppium();
       ApiElements.ViewsOption.click();
       driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Drag and Drop\"));"));
       ApiElements.dragAndDrop.click();

       //Getting source and target elements
       WebElement  source = $(By.id("io.appium.android.apis:id/drag_dot_1"));
       WebElement  target = $(By.id("io.appium.android.apis:id/drag_dot_2"));

       //Getting center of the element
       Point sourceElementCenter = getCenterOfElement(source.getLocation(), source.getSize());
           Point targetElementCenter = getCenterOfElement(target.getLocation(), target.getSize());

           PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
           Sequence sequence = new Sequence (finger1,1)
           .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
           .addAction(finger1.createPointerDown( PointerInput.MouseButton.LEFT.asArg()))
                   .addAction( new Pause(finger1, Duration.ofMillis(500)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(),targetElementCenter))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList( sequence));




       }

       //Got the center of element
    private Point getCenterOfElement(Point location, Dimension size) {
        return new Point(location.getX() + size.getWidth() / 2 ,
                location.getY() + size.getHeight() / 2);
    }


    @Test
    public void focusTextBox() throws MalformedURLException, InterruptedException {
        configureAppium();
        ApiElements.ViewsOption.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView2\"));"));
        ApiElements.WebView2.click();
        ApiElements.Textbox.click();
//        ApiElements.Textbox.should(Condition.focused, Duration.ofSeconds(5));
    }
}

