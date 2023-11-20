package Property;

import com.codeborne.selenide.Condition;
import Base.Base;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Property extends Base {
@BeforeMethod
public void openApp() throws MalformedURLException, InterruptedException {
configureAppium();
}
@AfterMethod
public void closeApp(){
    driver.close();
}




    @Test
    @Order(1)
    public void t1exploreButtonShouldVisible() throws MalformedURLException, InterruptedException {
//        configureAppium();
        PropertyElements.Explore.should(Condition.visible);
//        driver.closeApp();
 }
     @Test
     @Order(2)
    public void t2exploreButtonShouldClickedAndMovedToAnotherPage() throws MalformedURLException, InterruptedException {

//             configureAppium();
        PropertyElements.Explore.click();
//         driver.closeApp();
 }
      @Test
      @Order(3)
    public void t3singInPageShouldGetVisible() throws InterruptedException, MalformedURLException {
//          configureAppium();
          PropertyElements.Explore.click();
          PropertyElements.Email.should(Condition.visible);
//          driver.closeApp();
      }
        @Test
      @Order(4)
    public void t4signInWithOutCreatingTheAccount() throws MalformedURLException, InterruptedException {
//            configureAppium();
       PropertyElements.Explore.click();
       PropertyElements.Email.sendKeys("Anything@gmail.com");
       PropertyElements.Password.sendKeys("Anything@123");
       PropertyElements.Submit.click();
       PropertyElements.AlertMessage.should(Condition.visible);
//            driver.closeApp();

 }        @Test
      @Order(4)
    public void t5LongPressAction() throws MalformedURLException, InterruptedException {
//            configureAppium();
       PropertyElements.Explore.click();
       PropertyElements.Email.sendKeys("Anything@gmail.com");
       PropertyElements.Password.sendKeys("Anything@123");
       PropertyElements.Submit.click();
       PropertyElements.AlertMessage.should(Condition.visible);
 }

}
