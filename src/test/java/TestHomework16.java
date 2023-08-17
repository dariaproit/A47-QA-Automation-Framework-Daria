import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.Duration;

public class TestHomework16 {
    @Test
    public void registrationNavigation() {

        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationLink.click();

        String actualRegistrationURL = driver.getCurrentUrl();
        String expectedRegistrationURL = "https://qa.koel.app/registration.php";
        Assert.assertEquals(actualRegistrationURL,expectedRegistrationURL, "Wrong registration URL");

        driver.quit();
    }
}

