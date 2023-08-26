import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test (description = "Successful Login")
    public void SuccessfulLogin() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications=*");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String loginUrl = "https://qa.koel.app/";
        driver.get(loginUrl);

        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("demo@class.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement avatar = driver.findElement(By.cssSelector("[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed(), "Avatar icon is not displayed");

        driver.quit();
    }

    @Test (description = "Login with not existing email")
    public void LoginNotExistingEmail() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications=*");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String loginUrl = "https://qa.koel.app/";
        driver.get(loginUrl);

        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("NotExistingEmail@gmail.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        emailInput.sendKeys("te$t$tudent");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), loginUrl, "Wrong login url shows after unsuccessful login");
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
        driver.quit();
    }

    @Test (description = "Login with empty password")
    public void LoginEmptyEmailPasswordTest() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications=*");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String loginUrl = "https://qa.koel.app/";
        driver.get(loginUrl);

        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("demo@class.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), loginUrl, "Wrong login url shows after unsuccessful login");
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
        driver.quit();
    }
    @Test (description = "Login with empty email and password")
    public void LoginEmptyEmailPassword() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications=*");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String loginUrl = "https://qa.koel.app/";
        driver.get(loginUrl);

        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), loginUrl, "Wrong login url shows after unsuccessful login");
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
        driver.quit();
    }

    @Test (description = "Login with incorrect password")
    public void LoginIncorrectPassword() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications=*");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String loginUrl = "https://qa.koel.app/";
        driver.get(loginUrl);

        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("demo@class.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        emailInput.sendKeys("IncorrectPassword");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), loginUrl, "Wrong login url shows after unsuccessful login");
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
        driver.quit();
    }
}
