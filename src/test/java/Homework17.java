import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException{

        String songAddedNotification = "Added 1 song into \"Sanjeelas Playlist1.\"";

        navigateToPage();
        provideEmail("sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        clickLoginBtn();

        Thread.sleep(2000);

        searchSongName("of");
        Thread.sleep(2000);

        clickViewAllBtn();
        Thread.sleep(2000);

        clickFirstSong();
        Thread.sleep(2000);

        clickAddToBtn();
        Thread.sleep(2000);

        choosePlaylist();
        Thread.sleep(2000);

        Assert.assertEquals(getAddToPlaylistNotification(), songAddedNotification);






    }
    public void searchSongName(String songName){
        WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
        search.clear();
        search.sendKeys(songName);
    }

    public void clickViewAllBtn(){
        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();
    }

    public void clickFirstSong(){
        WebElement song = driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap search-results']//table[@class='items']//tr[position()=1]"));
        song.click();
    }

    public void clickAddToBtn(){
        WebElement AddTo = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        AddTo.click();
    }

    public void choosePlaylist(){
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Sanjeelas Playlist1')]"));
        playlist.click();
    }

    public String getAddToPlaylistNotification(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

}