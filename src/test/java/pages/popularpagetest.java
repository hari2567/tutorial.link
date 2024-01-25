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
import pages.PopularPage;
import java.time.Duration;

public class popularpagetest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    HeaderSection headerSection;
    PopularPage popularPage;
    @BeforeMethod
    @Test
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");



        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        headerSection=new HeaderSection(driver);
        popularPage=new PopularPage(driver);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
    @Test(priority = 1)
    public void popularsearch(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        boolean vlaue=popularPage.checkpopulaesec();
        Assert.assertTrue(vlaue,"failed");
    }
    @Test(priority = 2)
    public void moviessearch(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int value= popularPage.checkpopularmovies();
        if(value==30){
            System.out.println("movies are displayed");
        }else{
            System.out.println("not displated");
        }

    }
}


