import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;
    public String loginUrl = "https://qa.koel.app/";

    @BeforeSuite
    void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        options.addArguments("disable-notifications=*");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }@AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    //HELPER METHODS for LoginTests:
    public void navigateToPage() {
        String loginUrl = "https://qa.koel.app/";
        driver.get(loginUrl);
    }
    public void provideEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void providePassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }
    //HELPER METHOD for Successful Login to Koel:
    public void loginToKoel () {
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }

    //HELPER METHOD for ProfileTests:


}