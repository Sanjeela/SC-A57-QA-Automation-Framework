package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage{

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css="[class='del btn-delete-playlist']")
    WebElement deleteThisPlaylist;

    @FindBy(css="[class='ok']")
    WebElement clickOk;

    @FindBy(css="div.success.show")
    WebElement notification;

    public PlaylistPage clickDeleteThisPlaylist(){
        wait.until(ExpectedConditions.visibilityOf(deleteThisPlaylist));
        deleteThisPlaylist.click();
        wait.until(ExpectedConditions.visibilityOf(clickOk));
        clickOk.click();
        return this;
    }

    public String getDeletePlaylistNotification(){
        wait.until(ExpectedConditions.visibilityOf(notification));
        return notification.getText();
    }
}
