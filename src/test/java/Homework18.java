import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException{
        navigateToLoginPage();
        provideEmail("sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();

        Thread.sleep(2000);

        clickPlay();
        Thread.sleep(2000);

        clickPlayBtn();
        Thread.sleep(2000);

        pauseBthDisplayed();

    }

    public void clickPlay(){
        WebElement playNextSong = getDriver().findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextSong.click();
    }

    public void clickPlayBtn(){
        WebElement play = getDriver().findElement(By.xpath("//span[@title='Play or resume']"));
        play.click();

    }
    public void pauseBthDisplayed(){
        WebElement pauseBtn = getDriver().findElement(By.xpath("//span[@data-testid='pause-btn']"));
        Assert.assertTrue(pauseBtn.isDisplayed());
    }


}
