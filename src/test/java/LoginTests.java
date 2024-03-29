import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "LoginData")
    public void loginTests (String email,String password) throws InterruptedException{
        provideEmail(email);
        providePassword(password);

        Thread.sleep(2000);
        clickLoginBtn();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickLoginBtn();
        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        provideEmail("Invalid@class.com");
        providePassword("te$t$tudent");
        clickLoginBtn();
        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); // https://qa.koel.app/
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        //steps

        provideEmail("demo@class.com");
        providePassword("");
        clickLoginBtn();
        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/

    }

}