package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GeneralStoreElements {
    public static SelenideElement CountrySelection = $(By.id("android:id/text1"));
    public static SelenideElement DropDownList = $x("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView");
    public static SelenideElement Zimbabwe =   $x("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[11]");
    public static SelenideElement Aruba =   $x("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[7]");
    public static SelenideElement Name = $(By.id("com.androidsample.generalstore:id/nameField"));
    public static SelenideElement femaleRadioButton = $(By.id("com.androidsample.generalstore:id/radioFemale"));
    public static SelenideElement maleRadioButton = $(By.id("com.androidsample.generalstore:id/radioMale"));
    public static SelenideElement LetsShop = $(By.id("com.androidsample.generalstore:id/btnLetsShop"));
    public static SelenideElement PageHeader = $(By.id("com.androidsample.generalstore:id/toolbar_title"));
    public static SelenideElement cartIcon = $(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
    public static SelenideElement AddToCart = $x("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]");

    public static SelenideElement Proceed = $(By.id("com.androidsample.generalstore:id/btnProceed"));


}
