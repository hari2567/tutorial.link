package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderSection {
    @FindBy(linkText = "Home")
    WebElement hompeLink;
    @FindBy(linkText = "Popular")
    WebElement popularLink;
    @FindBy(className = "website-logo")
    WebElement logolink;
    @FindBy(className = "avatar-button")
    WebElement avatarLink;
    WebDriver driver;
    WebDriverWait wait;
    public HeaderSection(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public  WebElement homeNavigation(){
        return hompeLink;
    }
    public  WebElement popularNavigation(){
        return popularLink;
    }
    public  WebElement logoNavigation(){
        return  logolink;
    }
    public  WebElement avatarNaviagtion(){
        return  avatarLink;
    }
}


