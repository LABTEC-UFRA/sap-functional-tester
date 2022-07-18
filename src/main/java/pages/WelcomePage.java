package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WelcomePage {

    private WebDriver driver;

    private final By welcomeLabel = By.cssSelector("#root > div > div > div.bg-center.w-auto.bg-\\[url\\(\\'\\/src\\/assets\\/images\\/banner\\.png\\'\\)\\].bg-no-repeat.bg-cover.resize.flex.items-center > div > h1");
    private final By dropDownMenu = By.id("headlessui-menu-button-:r0:");
    private final By manageProfileButton = By.cssSelector("#headlessui-menu-item-\\3Ar4\\3A > .ml-3");
    private final By quitButton = By.cssSelector("#headlessui-menu-item-\\3Ar5\\3A > .ml-3");

    private final By seeMoreButton = By.cssSelector(".ml-10:nth-child(2) .flex > .mr-3");

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnWelcomePage(){

        String message = driver.findElement(welcomeLabel).getText();

        return message.contains("vindo");

    }

    public void clickOnDropDownMenu(){
        driver.findElement(dropDownMenu).click();
    }

    public boolean areDropDownItemsVisible() throws InterruptedException {

        clickOnDropDownMenu();
        Thread.sleep(1000);

        return  driver.findElement(manageProfileButton).isDisplayed();

    }

    public void clickOnQuitButton(){
        clickOnDropDownMenu();
        driver.findElement(quitButton).click();
    }

    public void clickOnManageProfileButton(){
        clickOnDropDownMenu();
        driver.findElement(manageProfileButton).click();
    }

    public void clickOnSeeMoreButton(){
        driver.findElement(seeMoreButton).click();
    }

}
