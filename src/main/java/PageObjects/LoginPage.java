package PageObjects;

import Utilities.AllUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;

public class LoginPage {

    private AllUtilities utilitiy;

    private WebDriver driver;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement verifyText;



    public LoginPage(WebDriver driver, AllUtilities utilities) {
        this.driver = driver;
        this.utilitiy = utilities;
        PageFactory.initElements(driver, this);
    }

    public LoginPage setUsername(String Username) {
        username.sendKeys(Username);
        return this;
    }

    public LoginPage setPassword(String passwd) throws IOException {
        password.sendKeys(passwd);
        return this;
    }

    public LoginPage AndClickLoginButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        signInButton.click();
        return this;
    }


}
