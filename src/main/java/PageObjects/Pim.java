package PageObjects;

import Utilities.AllUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Utilities.Property.random;

public class Pim {

    private String FirstName;
    private String LastName;

    private String id;
    private WebDriver driver;
    private AllUtilities utilitiy;

    public Pim(WebDriver driver, AllUtilities utilitiy) {
        this.driver = driver;
        this.utilitiy = utilitiy;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='oxd-main-menu']/li[2]")
    private WebElement Pim_Section;

    @FindBy(xpath = "//ul[@class='oxd-main-menu']")
    private WebElement section;

    @FindBy(xpath = "//nav/ul/li[position() = 3]")
    private WebElement Addemp;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstname;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastname;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement Submit;

    @FindBy(xpath = "//div[@id='oxd-toaster_1']")
    private WebElement SuccessNotifcation;

    @FindBy(xpath = "//nav/ul/li[position() = 2]")
    private WebElement Employeelist;

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    private WebElement SearchEmployeeName;

    @FindBy(xpath = "//button[@type='reset']/following-sibling::button")
    private WebElement SearchButton;

    @FindBy(xpath = "//label[contains(text(),'Employee Id')]/parent::div/following-sibling::div/input")
    private WebElement EmployeeId;

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/button[@type='button']")
    private WebElement No0fRecords;

    @FindBy(xpath = "//label[contains(text(),'Employee Id')]/parent::div/following-sibling::div/input")
    private WebElement SearchEmployeeId;

    @FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[position()=4]")
    private WebElement LastNameInRecord;

    @FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[position()=3]")
    private WebElement FirstNameAndMiddleNameInRecord;

    @FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[position()=2]")
    private WebElement IdInRecord;

    public Pim AddEmployeeSection(){
        Pim_Section.click();
        return this;
    }

    public Pim EmployeeListSection(){
        Employeelist.click();
        return this;
    }

    public Pim AddEmployee(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(Addemp));
        Addemp.click();
        return this;
    }

    public Pim Employee_SetFirstName(){
        FirstName = random();
        firstname.sendKeys(FirstName);
        return this;
    }

    public Pim Employee_SetLastName(){
        LastName = random();
        lastname.sendKeys(LastName);
        return this;
    }

    public Pim AndClickSaveButton(){
        id = EmployeeId.getAttribute("value");
        Submit.click();
        return this;
    }

    public Pim Success(){
        utilitiy.getWait(SuccessNotifcation);
        SuccessNotifcation.isDisplayed();
        return this;
    }


    public Pim AndClickOnSearchButton(){
        SearchEmployeeName.sendKeys(FirstName + " " + LastName );
        EmployeeId.sendKeys(id);
        SearchButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", No0fRecords);
        return this;
    }

    public Pim VerifyDataWithSearchrecord(){
        SoftAssert softAssert = new SoftAssert();
        try{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        softAssert.assertEquals(FirstName,FirstNameAndMiddleNameInRecord.getText());
        softAssert.assertEquals(LastName,LastNameInRecord.getText());
        softAssert.assertEquals(id,IdInRecord.getText());
        }catch (Exception e){
          System.out.println("Stale element");
        }
        softAssert.assertAll();
        return this;
    }

}
