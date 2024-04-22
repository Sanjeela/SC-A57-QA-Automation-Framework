import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends BaseTest {

    @Test
    public void playSong(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("sanjeela.chitrakar@testpro.io")
                .providePassword("te$t$tudent1")
                .clickSubmitBtn();

        HomePage homePage = new HomePage(getDriver());
        homePage.hoverToPlayBtn()
                .clickPlayNextBtn()
                .clickPlayBtn();
        Assert.assertTrue(homePage.pauseBthDisplayed());
    }

    @Test
    public void addSongPlaylist(){
        String songAddedNotification = "Added 1 song into \"Sanjeelas Playlist2.\"";

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("sanjeela.chitrakar@testpro.io")
                .providePassword("te$t$tudent1")
                .clickSubmitBtn();

        HomePage homePage = new HomePage(getDriver());
        homePage.searchSongName("of")
        .clickViewAllBtn()
        .clickFirstSong()
        .clickAddToBtn()
        .choosePlaylist();

        Assert.assertEquals(homePage.getAddToPlaylistNotification(), songAddedNotification );
    }



}
