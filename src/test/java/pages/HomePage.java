package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath="//section[@id='playlists']//a[contains(text(),'Sanjeelas Playlist1')]")
    WebElement playlist;



    public HomePage clickPlaylist(){
        wait.until(ExpectedConditions.visibilityOf(playlist));
        playlist.click();
        return this;

    }





   //***************************************************************************************************
    private By doubleClickPlaylistLocator = By.cssSelector("li.playlist:nth-child(3)");
    private By enterNewPlaylistNameLocator = By.cssSelector("[name='name']");
    private By getRenamePlaylistSuccessMsgLocator = By.cssSelector("div.success.show");

    public void doubleClickPlaylist(){
        WebElement clickPlaylist = findElement(doubleClickPlaylistLocator);
        actions.doubleClick(clickPlaylist).perform();

    }

    public void enterNewPlaylistName(String newPlaylistName){
        WebElement playlistName = findElement(enterNewPlaylistNameLocator);
        playlistName.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistName.sendKeys(newPlaylistName);
        playlistName.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = findElement(getRenamePlaylistSuccessMsgLocator);
        return notification.getText();
    }


}


