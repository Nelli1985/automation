import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class MyStepdefs {

    WebDriver driver = new ChromeDriver();

    @Given("^I have opened the application main page url: \"([^\"]*)\"$")
    public void iHaveOpenedTheApplicationMainPageUrl(String url) {
        driver.manage()
                .window();
        driver.get(url);
    }


    @Given("I have opened the login page")
    public void i_have_opened_the_login_page() {
        driver.findElement(By.className("login"))
                .click();
    }

    @When("^I will enter \"([^\"]*)\" as username and \"([^\"]*)\" as password and try to login$")
    public void iWillEnterAsUsernameAndAsPasswordAndTryToLogin(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Then("I will be promted error message")
    public void i_will_be_promted_error_message() {
        String actualerrormessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/p")).getText();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String expectederrormessage = "There is 1 error";
        Assert.assertEquals(actualerrormessage, expectederrormessage);
    }

    @Then("I'm not logged into the application")
    public void i_m_not_logged_into_the_application() {
        if(driver.getCurrentUrl().equalsIgnoreCase("http://automationpractice.com/index.php?controller=authentication&back=my-account")){
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Failed");
        }
        driver.close();
    }

    @Then("I'm logged into the application")
    public void i_m_logged_into_the_application() {
        String actualerrormessage = driver.findElement(By.className("navigation_page")).getText();
        String expectederrormessage = "My account";
        Assert.assertEquals(actualerrormessage, expectederrormessage);
    }

    @Then("I log off successfully")
    public void i_log_off_successfully() {
        driver.findElement(By.className("logout"))
                .click();
        driver.close();
    }


    @When("^I will enter the Email ([^\"]*) and Password ([^\"]*)$")
    public void iWillEnterTheEmailEmailAndPasswordPassword(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
    }
}


