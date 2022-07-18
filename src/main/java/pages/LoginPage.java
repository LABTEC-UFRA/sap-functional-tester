package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private final By userField = By.name("accountId");
    private final By passwordField = By.id("password");
    private final By continueLogInButton = By.name("action");
    private final By enterLoginButton = By.id("submit-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isVisibleUserField(){

        boolean isVisible = driver.findElement(userField).isDisplayed();

        return isVisible;
    }

    public boolean isVisiblePasswordField(){

        boolean isVisible = driver.findElement(passwordField).isDisplayed();

        return isVisible;
    }

    public void fillUser(String user){
        driver.findElement(userField).sendKeys(user);
    }

    public void fillPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickContinueLoginButton(){
        driver.findElement(continueLogInButton).click();
    }

    public void clickEnterLoginButton(){
        driver.findElement(enterLoginButton).click();
    }


}
