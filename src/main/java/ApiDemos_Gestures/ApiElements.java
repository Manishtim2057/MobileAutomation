package ApiDemos_Gestures;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ApiElements {

    public static SelenideElement Preference = $x("//android.widget.TextView[@content-desc=\"Preference\"]");
    public static SelenideElement Switch = $x("//android.widget.TextView[@content-desc='9. Switch']");
    public static SelenideElement CheckBoxPreference = $(By.id("android:id/checkbox"));
    public static SelenideElement SwitchPerference = $x(("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.Switch"));
    public static SelenideElement ViewsOption = $x(("//android.widget.TextView[@content-desc=\"Views\"]"));
    public static SelenideElement TextSwitcher = $x(("//android.widget.TextView[@content-desc=\"TextSwitcher\"]"));
    public static SelenideElement Gallery = $x(("//android.widget.TextView[@content-desc=\"Gallery\"]"));
    public static SelenideElement Photos = $x(("//android.widget.TextView[@content-desc=\"1. Photos\"]"));
    public static SelenideElement seekBar = $x(("//android.widget.TextView[@content-desc=\"Seek Bar\"]"));
    public static SelenideElement seekPoint = $x(("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.SeekBar"));
    public static SelenideElement touchVal = $x(("io.appium.android.apis:id/progress/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));

    public static SelenideElement LastImage = $x(("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[3]"));
    public static SelenideElement FirstImage = $x("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[1]");
    public static SelenideElement nextButton = $(By.id("io.appium.android.apis:id/next"));
    public static SelenideElement count = $x(("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextSwitcher/android.widget.TextView"));
    public static SelenideElement Target = $(By.id("io.appium.android.apis:id/drag_dot_1"));
    public static SelenideElement source = $(By.id("io.appium.android.apis:id/drag_dot_2"));
    public static SelenideElement dragAndDrop = $x(("//android.widget.TextView[@content-desc=\"Drag and Drop\"]"));
    public static SelenideElement WebView2 = $x(("//android.widget.TextView[@content-desc=\"WebView2\"]"));
    public static SelenideElement Textbox = $x(("hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.webkit.WebView/android.webkit.WebView/android.view.View[2]"));




//    public static SelenideElement TextSwitcher =  $x(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextSwitcher\"));"));

}
