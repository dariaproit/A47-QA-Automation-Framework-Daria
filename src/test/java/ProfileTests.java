import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.InterruptedException;
public class ProfileTests extends BaseTest {
    @Test(description = "Change Profile Name")
    public void ChangeProfileName() throws InterruptedException {

        loginToKoel();
        clickAvatar();
        provideCurrentPassword();
        String randomName = generateRandomName();
        provideProfileName(randomName);
        clickSaveProfile();
        Thread.sleep(2000);

        WebElement currentProfileName = driver.findElement(By.cssSelector("span[class='name']"));
        Assert.assertEquals(currentProfileName.getText(),randomName, "New Random name doesn't match");
    }
}
