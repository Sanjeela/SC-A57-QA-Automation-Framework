package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath = "//section[@id='playlists']//a[contains(text(),'Sanjeelas Playlist1')]")
    WebElement playlist;

    @FindBy(xpath = "//i[@data-testid='play-next-btn']")
    WebElement playNextSong;

    @FindBy(xpath = "//span[@title='Play or resume']")
    WebElement play;

    @FindBy(xpath = "//span[@data-testid='pause-btn']")
    WebElement pauseBtn;

    @FindBy(css = "input[type='search']")
    WebElement search;

    @FindBy(css = "button[data-test='view-all-songs-btn']")
    WebElement viewAll;

    @FindBy(xpath = "//div[@class='song-list-wrap main-scroll-wrap search-results']//table[@class='items']//tr[position()=1]")
    WebElement song;

    @FindBy(css = "button[class='btn-add-to']")
    WebElement AddTo;

    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[contains(text(),'Sanjeelas Playlist2')]")
    WebElement playlistChoose;

    @FindBy(css = "div.success.show")
    WebElement notification;

    @FindBy(css = "div[class='side player-controls']")
    WebElement playControlBar;

    @FindBy(css = "i[data-testid='sidebar-create-playlist-btn']")
    WebElement plusSign;

    @FindBy(css="li[data-testid='playlist-context-menu-create-smart']")
    WebElement smartPlaylist;

    @FindBy(css = "input[name='name']")
    WebElement playlistDialogBox;

    @FindBy(xpath = "//select[@name='model[]']//option[contains(text(),'Album')]")
    WebElement ruleCriteria1;

    @FindBy(css = "input[name='value[]']")
    WebElement ruleCriteria2;

    @FindBy(xpath = "//div[@class='modal-wrapper overlay']//button[@type='submit']")
    WebElement save;

    public HomePage searchSongName(String songName) {
        wait.until(ExpectedConditions.visibilityOf(search));
        search.clear();
        search.sendKeys(songName);
        return this;
    }

    public HomePage clickViewAllBtn() {
        wait.until(ExpectedConditions.visibilityOf(viewAll));
        viewAll.click();
        return this;
    }

    public HomePage clickFirstSong() {
        wait.until(ExpectedConditions.visibilityOf(song));
        song.click();
        return this;
    }

    public HomePage clickAddToBtn() {
        wait.until(ExpectedConditions.visibilityOf(AddTo));
        AddTo.click();
        return this;
    }

    public HomePage choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOf(playlistChoose));
        playlistChoose.click();
        return this;
    }

    public String getAddToPlaylistNotification() {
        wait.until(ExpectedConditions.visibilityOf(notification));
        return notification.getText();
    }

    public HomePage clickPlaylist() {
        wait.until(ExpectedConditions.visibilityOf(playlist));
        playlist.click();
        return this;

    }

    public HomePage clickPlayNextBtn() {
        wait.until(ExpectedConditions.visibilityOf(playNextSong));
        playNextSong.click();
        return this;
    }

    public HomePage clickPlayBtn() {
        wait.until(ExpectedConditions.visibilityOf(play));
        play.click();
        return this;

    }

    public boolean pauseBthDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(pauseBtn));
        return (pauseBtn.isDisplayed());
    }

    public HomePage hoverToPlayBtn() {
        wait.until(ExpectedConditions.visibilityOf(playControlBar));
        actions.moveToElement(playControlBar).perform();
        return this;
    }

    public HomePage clickPlusSignBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(plusSign));
        plusSign.click();
        return this;
    }

    public HomePage clickNewSmartPlaylist(){
        wait.until(ExpectedConditions.visibilityOf(smartPlaylist));
        smartPlaylist.click();
        return this;
    }

    public HomePage provideSmartPlaylistName(String playlistname){
        wait.until(ExpectedConditions.visibilityOf(playlistDialogBox));
        playlistDialogBox.clear();
        playlistDialogBox.sendKeys(playlistname);
        return this;
    }

    public HomePage provideRuleCriteria(){
        wait.until(ExpectedConditions.visibilityOf(ruleCriteria1));
        ruleCriteria1.click();
        return this;
    }

    public HomePage provideRuleCriteriaName(String songName){
        wait.until(ExpectedConditions.visibilityOf(ruleCriteria2));
        ruleCriteria2.clear();
        ruleCriteria2.sendKeys(songName);
        return this;
    }

    public HomePage clickSaveBtn(){
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return this;
    }

    public String getCreatePlaylistNotification(){
        wait.until(ExpectedConditions.visibilityOf(notification));
        return notification.getText();
    }













   //***************************************************************************************************
    private By doubleClickPlaylistLocator = By.xpath("//section[@id='playlists']//a[contains(text(),'Sanjeela Rename 22')]");
    private By enterNewPlaylistNameLocator = By.cssSelector("[name='name']");
    private By getRenamePlaylistSuccessMsgLocator = By.cssSelector("div.success.show");

    private By getAvatar = By.cssSelector("img.avatar");

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

    public boolean isUserAvatarDisplayed() {
        WebElement avatarIcon = findElement(getAvatar);
        return avatarIcon.isDisplayed();
    }





}


