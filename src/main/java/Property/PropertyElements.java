package Property;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PropertyElements {
    public static SelenideElement Explore = $(By.id("com.propertyaroundyou.app:id/get-started-btn"));
    public static SelenideElement Email = $(By.id("com.propertyaroundyou.app:id/email"));
    public static SelenideElement Password = $(By.id("com.propertyaroundyou.app:id/password"));
    public static SelenideElement Submit = $(By.id("com.propertyaroundyou.app:id/submit"));
    public static SelenideElement AlertMessage = $x("/hierarchy/android.widget.FrameLayout");

}
