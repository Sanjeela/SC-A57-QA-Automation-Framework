import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class PlaylistTest extends BaseTest{

    @Test
    public void deletePlaylist() {

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

    @Test
    public void renamePlaylist(){
        String updatedPlaylistMsg ="Updated playlist \"Sanjeela Edited Playlist 22.\"";

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("sanjeela.chitrakar@testpro.io" , "te$t$tudent1");

        HomePage homePage = new HomePage(getDriver());
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName("Sanjeela Edited Playlist 22");
        String notification = homePage.getRenamePlaylistSuccessMsg();

        Assert.assertEquals(notification, updatedPlaylistMsg);

    }

}



