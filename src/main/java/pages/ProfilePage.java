package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private WebDriver driver;

    private final By headerH1 = By.cssSelector("#root > div > div > div > div.br-breadcrumb.bg-blue-warm-vivid-70.d-flex > div");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isVisibleHeader(){

        boolean isVisible = driver.findElement(headerH1).isDisplayed();

        return isVisible;

    }
}
