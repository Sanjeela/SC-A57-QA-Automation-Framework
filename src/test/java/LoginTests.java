import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

        @Test
        public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
            navigateToLoginPage();
            clickSubmit();

            Assert.assertEquals(driver.getCurrentUrl(),url);

        }

        @Test
        public void loginValidEmailPassword() {
            //Steps
            navigateToLoginPage();
            provideEmail("demo@class.com");
            providePassword("te$t$tudent");
            clickSubmit();


            WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
            //Expected Result
            Assert.assertTrue(avatarIcon.isDisplayed());



        }

        @Test
        public void loginInvalidEmailValidPassword() {

            //Steps
            navigateToLoginPage();
            provideEmail("invalid@class.com");
            providePassword("te$t$tudent");
            clickSubmit();

            WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
            //Expected Result
            Assert.assertTrue(avatarIcon.isDisplayed());


        }

        @Test
        public void loginValidEmailNoPassword() {
            //Steps
            navigateToLoginPage();
            provideEmail("demo@class.com");
            clickSubmit();

            WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        }
    }