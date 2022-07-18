package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreateAccountBankPage {

    private WebDriver driver;

    public CreateAccountBankPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isBankPage(){

        String url = driver.getCurrentUrl();

        return url.contains("/bancos-credenciados/provedores");
    }


}
