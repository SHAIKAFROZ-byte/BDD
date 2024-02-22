package Stepdefintions;

import PageObjects.Header;
import PageObjects.LoginPage;
import PageObjects.Pim;
import Utilities.AllUtilities;
import Utilities.Property;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class Login_PageTest {

    private AllUtilities utilitiy;
    private LoginPage loginPage;

    private Header header;

    private Pim pim;

    public Login_PageTest() throws IOException {
        this.utilitiy = new AllUtilities();
    }

    @Given("Opening the login portal")
    public void opening_The_Login_portal() throws IOException {
        loginPage = new LoginPage(utilitiy.getDriver(), utilitiy);
        utilitiy.getDriver().get(Property.URL);
        String expectedUrl = utilitiy.getDriver().getCurrentUrl();
        Assert.assertEquals(Property.URL, expectedUrl);
    }

    @When("user should enter my valid username and password")
    public void userShouldEnterMyValidUsernameAndPassword() throws IOException {
        loginPage.setUsername(Property.USERNAME)
                .setPassword(Property.PASSWORD)
                .AndClickLoginButton();
    }

    @Then("user should login and verify the title")
    public void userShouldLoginAndVerifyTheTitle() {
        String actualTitle = utilitiy.getDriver().getTitle();
        Assert.assertEquals(Property.Title, actualTitle);
        utilitiy.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("user clicks on PIM Section")
    public void userClicksOnPIMSection() {
        pim = new Pim(utilitiy.getDriver(), utilitiy);
        pim.AddEmployeeSection();
    }


    @And("user creates an employee record")
    public void userCreatesAnEmployeeRecord() {
        pim.AddEmployee()
                .Employee_SetFirstName()
                .Employee_SetLastName()
                .AndClickSaveButton()
                .Success();

    }

    @Then("user checks for created employee record")
    public void userChecksForCreatedEmployeeRecord() throws InterruptedException {
        pim.EmployeeListSection()
                .AndClickOnSearchButton()
                .VerifyDataWithSearchrecord();
    }



    @And("user should profile icon")
    public void userShouldProfileIcon() {
        header = new Header(utilitiy.getDriver(), utilitiy);
        header.AndClickProfileIcon();
    }

    @Then("user should logout")
    public void userShouldLogout() {
        header.AndClickOnLogout();

    }

    @After
    public void teardown() throws IOException {
        utilitiy.getDriver().quit();

    }

}
