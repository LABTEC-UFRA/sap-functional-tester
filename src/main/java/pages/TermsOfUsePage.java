package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TermsOfUsePage {

    private WebDriver driver;

    private final By checkBoxTermLabel = By.cssSelector("label");
    private final By checkBoxDivHumanCaptcha = By.cssSelector("#anchor > div.label-container");
    private final By continueButton = By.cssSelector(".primary");


    public TermsOfUsePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickCheckBoxesCaptcha(){

        driver.findElement(checkBoxTermLabel).click();

        driver.switchTo().frame(1);

        System.out.println("asdasddas");

        driver.findElement(checkBoxDivHumanCaptcha).click();

        driver.switchTo().defaultContent();
        driver.findElement(continueButton).click();

    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    public boolean isVisibleCheckBoxTermCaptcha(){

        String label = driver.findElement(checkBoxTermLabel).getTagName();

        return label.contains("input");
    }
}
