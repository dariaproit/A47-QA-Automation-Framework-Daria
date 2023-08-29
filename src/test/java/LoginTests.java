import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test (description = "Login with valid email and password")
    public void loginValidEmailPassword() {

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement avatar = driver.findElement(By.cssSelector("[class='avatar']")); //or "img[class='avatar']"
        Assert.assertTrue(avatar.isDisplayed(), "Avatar icon is not displayed");
    }

    @Test (description = "Login with not existing email")
    public void loginNotExistingEmail() {

        navigateToPage();
        provideEmail("NotExistingEmail@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), loginUrl, "Wrong login url shows after unsuccessful login");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
    }
    @Test (description = "Login with empty password")
    public void loginEmptyEmailPasswordTest() {

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), loginUrl, "Wrong login url shows after unsuccessful login");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
    }
    @Test (description = "Login with empty email and password")
    public void loginEmptyEmailPassword() {

        navigateToPage();
        provideEmail("");
        providePassword("");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), loginUrl, "Wrong login url shows after unsuccessful login");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
    }

    @Test (description = "Login with incorrect password")
    public void loginIncorrectPassword() {

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
    }
}
