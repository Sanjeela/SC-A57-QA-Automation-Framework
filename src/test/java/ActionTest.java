import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import java.util.List;


public class ActionTest extends BaseTest{
    String newPlaylistName="Sample Edited Playlist";

//Test#1 Contextual Click
    @Test
    public void playSong() throws InterruptedException{
        //Background Steps / Login
        provideEmail("Sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();
        Thread.sleep(2000);

        //Choose All Songs List
        chooseAllSongsList();

        //Contextual/ Right Click on the first Song
        contextClickFirstSong();

        //Click on Play from the menu
        choosePlayOption();

        //Assertion
        Assert.assertTrue(isPlaying());
    }

    //Helper Methods
    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    public void contextClickFirstSong(){
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSong).perform();
    }
    public void choosePlayOption(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();

    }

    public boolean isPlaying(){
        WebElement soundbarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundbarVisualizer.isDisplayed();
    }
    //*************************************************************************************************************************

    //Test#2 Mouse Hover
    @Test
    public void hoverOverPlayButton()throws InterruptedException{
        //bg Steps
        provideEmail("Sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();
        Thread.sleep(2000);

        //hover and verify play
        Assert.assertTrue(hoverPlay().isDisplayed());
    }

    public WebElement hoverPlay(){
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }

    //*************************************************************************************************************************

    //Test#3 WebElements
    @Test
    public void countSongsInPlaylist()throws InterruptedException{
        provideEmail("Sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();
        Thread.sleep(2000);

        //Choose Playlist by Name
        choosePlaylistByName("Sanjeelas Playlist1");
        Thread.sleep(2000);

       //Display all Songs
        displayAllSongs();
        Thread.sleep(2000);

        //Assertion
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }
     public void choosePlaylistByName(String playlistName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]"))).click();

     }
     public void displayAllSongs(){
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        //count and display songs name
         System.out.println("Number of Songs in the playlist: "+countSongs());
         for(WebElement e : songList){
             System.out.println(e.getText());

         }

     }

     public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
     }

     public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
     }

     //************************************************************************************************************************

    @Test
    public void renamePlaylist() throws InterruptedException{
       String updatedPlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";

        //Login
        provideEmail("Sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();
        Thread.sleep(2000);

        //Double Click
        doubleClickPlaylist();
        Thread.sleep(2000);
        //Enter new name for Playlist
        enterNewPlaylistName();
        Thread.sleep(2000);
        //Assert
        Assert.assertEquals(getRenamePlaylistSuccessMsg(),updatedPlaylistMsg);


    }

    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
       WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
       return notification.getText();
    }
}
