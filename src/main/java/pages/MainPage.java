package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {

    private WebDriver driver;

    private final By navigationBar = By.id("tabroot");
    private final By informationContent = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-jvvksu.gFkOTo.px-\\[20px\\].py-\\[30px\\].md\\:p-\\[96px\\] > div.sc-jlsrNB.keXkmc");
    private final By formNavItem = By.cssSelector("#tabroot > div > div:nth-child(2) > div.sc-eCImPb.fLouw > div");
    private final By typeOfForms = By.className("lkJEWa");
    private final By questionnaires = By.className("sc-JkixQ");
    private final By quizSchoolViewButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-iWVNaa.eCsXSR.mb-\\[20px\\].w-\\[100\\%\\] > div:nth-child(2) > div:nth-child(2) > div.sc-gGPzkF.cDmuyY.flex.justify-start.sm\\:justify-end > button:nth-child(1) > img");
    private final By quizDemographicViewButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-iWVNaa.eCsXSR.mb-\\[20px\\].w-\\[100\\%\\] > div:nth-child(2) > div:nth-child(3) > div.sc-gGPzkF.cDmuyY.flex.justify-start.sm\\:justify-end > button:nth-child(1) > img");
    private final By quizStudentViewButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-iWVNaa.eCsXSR.mb-\\[20px\\].w-\\[100\\%\\] > div:nth-child(3) > div.sc-JkixQ.iaICsq.grid.grid-cols-1.sm\\:flex > div.sc-gGPzkF.cDmuyY.flex.justify-start.sm\\:justify-end > button:nth-child(1) > img");
    private final By schoolDocumentModal = By.cssSelector(".sc-hZpJaK:nth-child(2) > .sc-JkixQ:nth-child(2) .sc-bSqaIl:nth-child(1) > .sc-jivBlf");
    private final By demographicDocumentModal = By.cssSelector(".sc-JkixQ:nth-child(3) .sc-bSqaIl:nth-child(1) > .sc-jivBlf");
    private final By studentDocumentModal = By.cssSelector(".sc-hZpJaK:nth-child(3) .sc-bSqaIl:nth-child(1) > .sc-jivBlf");
    private final By modalCloseButton = By.cssSelector(".mt-3");
    private final By quizSchoolDownloadButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-iWVNaa.eCsXSR.mb-\\[20px\\].w-\\[100\\%\\] > div:nth-child(2) > div:nth-child(2) > div.sc-gGPzkF.cDmuyY.flex.justify-start.sm\\:justify-end > button:nth-child(2)");
    private final By quizDemographicDownloadButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-iWVNaa.eCsXSR.mb-\\[20px\\].w-\\[100\\%\\] > div:nth-child(2) > div:nth-child(3) > div.sc-gGPzkF.cDmuyY.flex.justify-start.sm\\:justify-end > button:nth-child(2)");
    private final By quizStudentDownloadButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-iWVNaa.eCsXSR.mb-\\[20px\\].w-\\[100\\%\\] > div:nth-child(3) > div.sc-JkixQ.iaICsq.grid.grid-cols-1.sm\\:flex > div.sc-gGPzkF.cDmuyY.flex.justify-start.sm\\:justify-end > button:nth-child(2)");
    private final By informativeText = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-dSfdvi.lnAGKN.pb-\\[20px\\].text-left.sm\\:text-justify");
    private By appDownloadLink = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-dSfdvi.lnAGKN.pb-\\[20px\\].text-left.sm\\:text-justify > a");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isVisibleMainPage(){

        boolean isVisible = driver.findElement(navigationBar).isDisplayed();

        return isVisible;
    }

    public boolean isVisibleInformationContent(){
        boolean isVisible = driver.findElement(informationContent).isDisplayed();

        return isVisible;
    }

    public void clickOnFormNavItem() {
        driver.findElement(formNavItem).click();
    }

    public boolean verifyTypesOfForms(){

        List<WebElement> formsList = driver.findElements(typeOfForms);

        WebElement form1 = formsList.get(0);
        WebElement form2 = formsList.get(1);

        boolean isValid = form1.getText().contains("Escola")
                && form2.getText().contains("Estudante");

        return isValid;
    }

    public boolean getAllQuestionnaires(){

        List<WebElement> questionnairesList = driver.findElements(questionnaires);

        WebElement quiz1 = questionnairesList.get(0);
        WebElement quiz2 = questionnairesList.get(1);

        boolean isValid = quiz1.getText().contains("Questionário da Escola por Aluno")
                && quiz2.getText().contains("Questionário do Estudante");

        return isValid;
    }

    public void clickOnSchoolViewIcon(){
        driver.findElement(quizSchoolViewButton).click();
    }

    public void clickOnSchoolDownloadIcon(){
        driver.findElement(quizSchoolDownloadButton).click();
    }

    public void clickOnDemographicViewIcon(){
        driver.findElement(quizDemographicViewButton).click();
    }

    public void clickOnDemographicDownloadIcon(){
        driver.findElement(quizDemographicDownloadButton).click();
    }

    public void clickOnStudentViewIcon(){
        driver.findElement(quizStudentViewButton).click();
    }

    public void clickOnStudentDownloadIcon(){
        driver.findElement(quizStudentDownloadButton).click();
    }

    public boolean isSchoolModalDisplayed(){

        boolean isDisplayed = driver.findElement(schoolDocumentModal).isDisplayed();

        return isDisplayed;
    }

    public boolean isSchoolModalSelected(){

        boolean isSelected = driver.findElement(schoolDocumentModal).isSelected();

        return isSelected;
    }

    public boolean isDemographicModalDisplayed(){

        boolean isDisplayed = driver.findElement(demographicDocumentModal).isDisplayed();

        return isDisplayed;
    }

    public boolean isDemographicModalSelected(){

        boolean isSelected = driver.findElement(demographicDocumentModal).isSelected();

        return isSelected;
    }

    public boolean isStudentModalDisplayed(){

        boolean isDisplayed = driver.findElement(studentDocumentModal).isDisplayed();

        return isDisplayed;
    }

    public boolean isStudentModalSelected(){

        boolean isSelected = driver.findElement(studentDocumentModal).isSelected();

        return isSelected;
    }

    public void closeModal(){
        driver.findElement(modalCloseButton).click();
    }

    public boolean isDisplayedInformativeText(){

        boolean isDisplayed = driver.findElement(informativeText).isDisplayed();

        return isDisplayed;
    }

    public boolean isDisplayedAppDownloadLink(){

        boolean isDisplayed = driver.findElement(appDownloadLink).isDisplayed();

        return isDisplayed;
    }

    public void clickOnAppDownloadLink(){
        driver.findElement(appDownloadLink).click();
    }

}
