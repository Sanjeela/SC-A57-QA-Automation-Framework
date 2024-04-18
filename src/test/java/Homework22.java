import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{

    @Test
    public void renamePlaylist(){
        String updatedPlaylistMsg ="Updated playlist \"Sanjeela Edited Playlist 22.\"";

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("sanjeela.chitrakar@testpro.io" , "te$t$tudent1");

        HomePage homePage = new HomePage(driver);

        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName("Sanjeela Edited Playlist 22");

        String notification = homePage.getRenamePlaylistSuccessMsg();
        Assert.assertEquals(notification, updatedPlaylistMsg);

    }

}
