import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import java.util.List;


public class ActionTest extends BaseTest{

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
        WebElement soundbarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bars")));
        return soundbarVisualizer.isDisplayed();
    }
    //Test#2 Mouse Hover
    @Test
    public void hoverOverPlayButton(){
        //bg Steps
        provideEmail("Sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();
        //hover and verify play
        Assert.assertTrue(hoverPlay().isDisplayed());
    }

    public WebElement hoverPlay(){
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }

    //Test#3 WebElements
    @Test
    public void countSongsInPlaylist(){
        provideEmail("Sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();
        //
        choosePlaylistByName("Sanjeelas Playlist1");
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }
     public void choosePlaylistByName(String playlistName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]")));

     }
     public void displayAllSongs(){
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        //count and display songs name
         System.out.println("Number ofSongs in the playlist: "+ countSongs());
         for(WebElement e : songList){
             System.out.println(e.getText());

         }

     }

     public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
     }

     public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary")).getText();
     }
}
