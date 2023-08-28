import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestHomework17 extends BaseTest {

    //For adding the song to newly created playlist per Homework requirements
    @Test(description = "Create New Unique Playlist")
    public void createNewPlaylist() throws InterruptedException {

        loginToKoel();
        WebElement createNewPlaylistIcon = driver.findElement(By.cssSelector("[title='Create a new playlist']"));
        createNewPlaylistIcon.click();
        Thread.sleep(1000);
        WebElement newPlaylistMenu = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlaylistMenu.click();
        Thread.sleep(1000);
        WebElement enterPlaylistNameField = driver.findElement(By.cssSelector("input[name='name']"));
        enterPlaylistNameField.click();
        enterPlaylistNameField.clear();
        enterPlaylistNameField.sendKeys("Unique Playlist");
        Thread.sleep(1000);
        enterPlaylistNameField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement uniquePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Unique Playlist")));
        Assert.assertTrue(uniquePlaylist.isDisplayed());
    }

    @Test(priority = 1, description = "Add Song To Playlist")
    public void addSongToPlaylist() throws InterruptedException {

        loginToKoel();
        searchSong("rainday");
        clickViewAllSearchedSongs();
        pickFirstSong();
        clickAddToButton();
        chooseUniquePlaylist();
        String expectedSongAddedMessage = "Added 1 song into \"Unique Playlist.\"";
        Assert.assertEquals(getActualSongAddedMessage(), expectedSongAddedMessage);
    }
}


//    //TO WORK ON CODE
//    @Test (priority = 2, description = "Delete Playlist")
//    public void deleteUniquePlaylist() throws InterruptedException {
//        loginToKoel();
//        WebElement uniquePlaylist = driver.findElement(By.partialLinkText("Unique Playlist"));
//        uniquePlaylist.click();
//        uniquePlaylist.sendKeys(Keys.DELETE);
//        Thread.sleep(2000);
//        driver.navigate().refresh();
//        WebElement uniquePlaylistAfterRefresh = driver.findElement(By.partialLinkText("Unique Playlist"));
//        Assert.assertFalse(uniquePlaylistAfterRefresh.isDisplayed());
//    }



