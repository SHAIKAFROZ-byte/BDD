package PageObjects;

import Utilities.AllUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    private String id;
    private WebDriver driver;
    private AllUtilities utilities;

    public Header(WebDriver driver, AllUtilities utilities) {
        this.driver = driver;
        this.utilities = utilities;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//li[@class='oxd-userdropdown']")
    private WebElement ProfileIcon;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement Logout;

    public Header AndClickProfileIcon(){
        ProfileIcon.click();
        return this;
    }

    public Header AndClickOnLogout(){
        Logout.click();
        return this;
    }

}
