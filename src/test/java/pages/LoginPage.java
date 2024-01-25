package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage {

    @FindBy(className = "login-website-logo")
    WebElement imageurlElement;
    @FindBy(className = "sign-in-heading")
    WebElement headingurl;
    @FindBy(xpath ="//label[text()='USERNAME']" )
    WebElement usernameurl;
    @FindBy(xpath = "//label[text()='PASSWORD']")
    WebElement passwordurl;
    @FindBy(className = "login-button")
    WebElement submitbutton;
    @FindBy(className = "error-message")
    WebElement errormessage;
    @FindBy(id = "usernameInput")
    WebElement username;
    @FindBy(id = "passwordInput")
    WebElement password;
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));

    }
    public WebElement imageelement(){
        return imageurlElement;
    }
    public WebElement headingelement(){
        return headingurl;
    }
    public WebElement usernamelinkl(){
        return usernameurl;
    }
    public WebElement passwordLink(){
        return passwordurl;
    }
    public  void submitLink(){
        submitbutton.click();
    }
    public WebElement erroeLink(){
        return errormessage;
    }
    public void userLink(String name){
        username.sendKeys(name);
    }
    public  void passwordLink2(String name2){
        password.sendKeys(name2);
    }
    public  void loginToApplication(String name,String name2){
        userLink(name);
        passwordLink2(name2);
        submitLink();
    }
    public String errorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return errormessage.getText();
    }
}


