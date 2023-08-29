import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomework18 extends BaseTest {

    @Test(description = "Play a song")
    public void playSong() throws InterruptedException {

        loginToKoel();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
        clickPlayNext();
        Assert.assertTrue(isSongPlaying());
    }

}
