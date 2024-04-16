import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PlaylistPage;

public class Homework23 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {

        String playlistDeletedNotification = "Deleted playlist \"Sanjeelas Playlist1.\"";

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("sanjeela.chitrakar@testpro.io")
                .providePassword("te$t$tudent1")
                .clickSubmitBtn();

        HomePage homePage = new HomePage(getDriver());
        homePage.clickPlaylist();

        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        playlistPage.clickDeleteThisPlaylist();

        Assert.assertEquals(playlistPage.getDeletePlaylistNotification(), playlistDeletedNotification);
    }
}

