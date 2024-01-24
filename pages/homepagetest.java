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
import  pages.HomePage;

public class homepagetest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    @BeforeMethod
    @Test
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
    @Test(priority = 1)
    public void validinputs2(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String expectedurl2="https://qamoviesapp.ccbp.tech/login";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedurl2));
        String actualUL= driver.getCurrentUrl();
        Assert.assertEquals(actualUL,expectedurl2,"url doesnot match");
        Assert.assertEquals(homePage.homeText().getText(),"Home","didnot");
        Assert.assertEquals(homePage.popularText().getText(),"Popular","didnot");
    }
    @Test(priority = 2)
    public void playbuttoncheck(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(homePage.button().isDisplayed(),"play button is not dis");
    }
    @Test(priority  =3)
    public void moviedisplay(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(homePage.trendingsec(),"not displayed");
        Assert.assertTrue(homePage.originalsec(),"not displayed");
    }
    @Test(priority = 4)
    public void contactsection(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(homePage.paragraphcontext().isDisplayed(),"not displayed");
    }

}


