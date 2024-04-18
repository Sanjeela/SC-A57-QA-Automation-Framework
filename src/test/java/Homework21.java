import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    String newPlaylistName = "Sanjeela Edited Playlist 21";

    @Test
    public void renamePlaylist() {
       String updatedPlaylistMsg ="Updated playlist \"Sanjeela Edited Playlist 21.\"";

        provideEmail("sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();

        doubleClickPlaylist();

        enterNewPlaylistName();

        Assert.assertEquals(getRenamePlaylistSuccessMsg(),updatedPlaylistMsg);

    }

    public void doubleClickPlaylist(){
        WebElement clickPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//a[contains(text(),'Sanjeela Rename 21')]")));
        actions.doubleClick(clickPlaylist).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistName.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistName.sendKeys(newPlaylistName);
        playlistName.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}
