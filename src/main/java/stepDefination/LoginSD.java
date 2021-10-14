package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginSD {

    public static WebDriver driver;
    @Given("I am on login page of billing")
    public void i_am_on_login_page_of_billing() {
        System.out.println("I am on login page of billing");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.get("https://stock.scriptinglogic.net/");
    }
    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        System.out.println("I enter valid username and password");
        driver.findElement(By.id("login-username")).sendKeys("admin");
        driver.findElement(By.id("login-password")).sendKeys("admin");
    }

    @When("I click on login button")
    public void i_click_On_Login_button()
    {
        System.out.println("I click on login button");
        driver.findElement(By.name("submit")).click();
    }
    @Then("I should be redirected to home page")
    public void i_should_be_redirected_to_home_page() {
        System.out.println("I should be redirected to home page");
        String expected="https://stock.scriptinglogic.net/dashboard.php";
        String actual=driver.getCurrentUrl();
        Assert.assertEquals("wrong page",actual,expected);
    }
}
