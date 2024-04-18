import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException{

        String playlistDeletedNotification = "Deleted playlist \"Sanjeelas Playlist1.\"";

        navigateToLoginPage();
        provideEmail("sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();

        Thread.sleep(5000);

        clickPlaylist();
        Thread.sleep(5000);

        clickDeleteThisPlaylist();
        Thread.sleep(5000);

        Assert.assertEquals(getDeletePlaylistNotification(), playlistDeletedNotification);


    }

    public void clickPlaylist(){
        WebElement playlist = getDriver().findElement(By.xpath("//section[@id='playlists']//a[contains(text(),'Sanjeelas Playlist1')]"));
        playlist.click();

    }

    public void clickDeleteThisPlaylist() throws InterruptedException{
        WebElement deleteThisPlaylist = getDriver().findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        deleteThisPlaylist.click();

        Thread.sleep(2000);

        WebElement clickOk = getDriver().findElement(By.cssSelector("button[class='ok']"));
        clickOk.click();
    }

    public String getDeletePlaylistNotification(){
        WebElement notification = getDriver().findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}
