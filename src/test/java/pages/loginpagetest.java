package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import pages.LoginPage;

public class loginpagetest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64//chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");
        loginPage=new LoginPage(driver);


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void imagewebapplication(){
        Assert.assertTrue(loginPage.imageurlElement.isDisplayed(),"App logo is not displayed");
        Assert.assertTrue(loginPage.headingurl.isDisplayed(),"heading is not displayed");
        Assert.assertTrue(loginPage.usernameurl.isDisplayed(),"url doesnotmatch");
        Assert.assertTrue(loginPage.passwordurl.isDisplayed(),"password doesnot match");

    }
    @Test(priority = 1)
    public void emptylogin(){
        loginPage.submitLink();
        String actualUrl=loginPage.errorMessage();
        Assert.assertEquals(actualUrl,"*Username or password is invalid","Error text does not match");
    }
    @Test(priority = 2)
    public void emptyusername(){
        loginPage.loginToApplication("","rahul@2021");
        loginPage.submitLink();
        String actualUrl=loginPage.errorMessage();
        Assert.assertEquals(actualUrl,"*Username or password is invalid","Error text does not match");

    }
    @Test(priority  =3)
    public void emptypassword(){
        loginPage.loginToApplication("rahul","");
        loginPage.submitLink();
        String actualUrl=loginPage.errorMessage();
        Assert.assertEquals(actualUrl,"*Username or password is invalid","Error text does not match");

    }
    @Test(priority = 4)
    public void invalidnames(){
        loginPage.loginToApplication("rahul","rahul");
        loginPage.submitLink();
        String actualUrl=loginPage.errorMessage();
        Assert.assertEquals(actualUrl,"*username and password didn't match","Error text does not match");


    }
    @Test(priority = 5)
    public void validinputs(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String expectedurl="https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedurl));
        String actualUL= driver.getCurrentUrl();
        Assert.assertEquals(actualUL,expectedurl,"url doesnot match");
    }






}


