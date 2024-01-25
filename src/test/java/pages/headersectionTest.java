package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.HeaderSection;
import java.time.Duration;

public class headersectionTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    HeaderSection headerSection;
    @BeforeMethod
    @Test
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");



        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        headerSection=new HeaderSection(driver);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
    @Test(priority = 1)
    public void websitelogo(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(headerSection.logoNavigation().isDisplayed(),"notdisplayed");
    }
    @Test(priority = 2)
    public void navigationpage(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(headerSection.homeNavigation().isDisplayed(),"not dis");
        Assert.assertTrue(headerSection.popularNavigation().isDisplayed(),"not dis");
        Assert.assertTrue(headerSection.avatarNaviagtion().isDisplayed(),"not dis");
    }
}


