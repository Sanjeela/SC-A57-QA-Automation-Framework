import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PlaylistPage;

public class Homework23 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {

        String playlistDeletedNotification = "Deleted playlist \"Sanjeelas Playlist1.\"";

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("sanjeela.chitrakar@testpro.io")
                .providePassword("te$t$tudent1")
                .clickSubmitBtn();

        HomePage homePage = new HomePage(driver);
        homePage.clickPlaylist();

        PlaylistPage playlistPage = new PlaylistPage(driver);
        playlistPage.clickDeleteThisPlaylist();

        Assert.assertEquals(playlistPage.getDeletePlaylistNotification(), playlistDeletedNotification);
    }
}

