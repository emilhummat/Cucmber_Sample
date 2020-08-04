package steps;

import POM.BasePOM;
import POM.PersonalInfoPOM;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

public class firstNameEditSteps {
    public WebDriver driver = BaseDriver.getDriver();
    BasePOM basePOM = new BasePOM();
    PersonalInfoPOM personalInfoPOM = new PersonalInfoPOM();
    String name = "Kevin De Bruyne";
    String previousName = "Kun Aguero";
    String password = "123456789";

    @Given("^Navigate to the website$")
    public void navigate_to_the_website() {
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php ");
    }

    @When("^I use legit username and password$")
    public void i_use_legit_username_and_password() {
        basePOM.waitAndClick(By.cssSelector(".login"));
        basePOM.waitAndSendKeys(By.id("email"), "qwerty0123@gmail.com");
        basePOM.waitAndSendKeys(By.id("passwd"), "123456789");
        basePOM.waitAndClick(By.cssSelector(".icon-lock.left"));
    }

    @Then("^I am logged in$")
    public void i_am_logged_in() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("My account - My Store"));
    }

    @Given("^I navigate to My personal information page$")
    public void i_navigate_to_My_personal_information_page() {
        basePOM.waitAndClick(personalInfoPOM.myPersonalInformationButton);
    }

    @When("^I edit personal info$")
    public void i_edit_personal_info() {
        basePOM.waitAndSendKeys(personalInfoPOM.firstnameInput, name);
        basePOM.waitAndSendKeys(personalInfoPOM.passwordInput, password);
        basePOM.waitAndClick(personalInfoPOM.saveButton);
    }

    @Then("^The first name is edited successfully$")
    public void the_first_name_is_edited_successfully() {
        basePOM.waitAndClick(personalInfoPOM.accountName);
        basePOM.waitAndConfirm(personalInfoPOM.accountName, name);
    }

    @When("^I change the first name back to the previous one$")
    public void iChangeTheFirstNameBackToThePreviousOne() {
        basePOM.waitAndSendKeys(personalInfoPOM.firstnameInput, previousName);
        basePOM.waitAndSendKeys(personalInfoPOM.passwordInput, password);
        basePOM.waitAndClick(personalInfoPOM.saveButton);
    }

    @Then("^The first name is the same as the previous name$")
    public void theFirstNameIsTheSameAsThePreviousName() {
        basePOM.waitAndClick(personalInfoPOM.accountName);
        basePOM.waitAndConfirm(personalInfoPOM.accountName, previousName);
    }
}
