package Stepdefintions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class MyStepDef {
    private int accountBalance;
    private int amountToWithdraw;

    @Given("I have a balance of ${int} in my account")
    public void i_have_a_balance_of_$_in_my_account(int balance) {
        accountBalance = balance;
    }

    @When("I request ${int}")
    public void i_request_$(int amountToWithdraw1) {
        amountToWithdraw = amountToWithdraw1;
        if (amountToWithdraw > accountBalance) {
            throw new RuntimeException("Insufficient funds to withdraw $" + amountToWithdraw);
        }
        accountBalance -= amountToWithdraw;
        System.out.println("Withdrawn $" + amountToWithdraw + ". New balance: $" + accountBalance);
    }

    @Then("${int} should be dispensed")
    public void $_should_be_dispensed(int dispensedAmount) {
      Assert.assertEquals(dispensedAmount, amountToWithdraw, "Dispensed amount does not match requested amount");
    }
}
