package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    private WebDriver driver;

    private final By entryButton = By.linkText("Entrar com gov.br");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getEntryButtonLabel(){

        String label = driver.findElement(entryButton).getText();

        return label;
    }

    public void clickEntryButton(){
        driver.findElement(entryButton).click();
    }

}
