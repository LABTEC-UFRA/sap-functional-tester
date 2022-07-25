package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MainPage {

    private WebDriver driver;

    private final By navigationBar = By.id("tabroot");
    private final By homePageNavItem = By.cssSelector("#tabroot > div > div:nth-child(1) > div.sc-eCImPb.fLouw > div");
    private final By homePageInformationContent = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-edERGn.gDDlek.px-\\[20px\\].py-\\[30px\\].md\\:p-\\[96px\\] > div.sc-cVAmsi.jiHEzy.border-solid.p-\\[24px\\] > div");


    // Forms

    private final By formNavItem = By.cssSelector("#tabroot > div > div:nth-child(2) > div.sc-eCImPb.fLouw > div");
    private final By formsTypeOfForms = By.className("lkJEWa");
    private final By formsQuestionnaires = By.className("sc-JkixQ");
    private final By formsQuizSchoolViewButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-iWVNaa.eCsXSR.mb-\\[20px\\].w-\\[100\\%\\] > div:nth-child(2) > div:nth-child(2) > div.sc-gGPzkF.cDmuyY.flex.justify-start.sm\\:justify-end > button:nth-child(1) > img");
    private final By formsQuizDemographicViewButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-iWVNaa.eCsXSR.mb-\\[20px\\].w-\\[100\\%\\] > div:nth-child(2) > div:nth-child(3) > div.sc-gGPzkF.cDmuyY.flex.justify-start.sm\\:justify-end > button:nth-child(1) > img");
    private final By formsQuizStudentViewButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-iWVNaa.eCsXSR.mb-\\[20px\\].w-\\[100\\%\\] > div:nth-child(3) > div.sc-JkixQ.iaICsq.grid.grid-cols-1.sm\\:flex > div.sc-gGPzkF.cDmuyY.flex.justify-start.sm\\:justify-end > button:nth-child(1) > img");
    private final By formsSchoolDocumentModal = By.cssSelector(".sc-hZpJaK:nth-child(2) > .sc-JkixQ:nth-child(2) .sc-bSqaIl:nth-child(1) > .sc-jivBlf");
    private final By formsDemographicDocumentModal = By.cssSelector(".sc-JkixQ:nth-child(3) .sc-bSqaIl:nth-child(1) > .sc-jivBlf");
    private final By formsStudentDocumentModal = By.cssSelector(".sc-hZpJaK:nth-child(3) .sc-bSqaIl:nth-child(1) > .sc-jivBlf");
    private final By formsModalCloseButton = By.cssSelector(".mt-3");
    private final By formsQuizSchoolDownloadButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-iWVNaa.eCsXSR.mb-\\[20px\\].w-\\[100\\%\\] > div:nth-child(2) > div:nth-child(2) > div.sc-gGPzkF.cDmuyY.flex.justify-start.sm\\:justify-end > button:nth-child(2)");
    private final By formsQuizDemographicDownloadButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-iWVNaa.eCsXSR.mb-\\[20px\\].w-\\[100\\%\\] > div:nth-child(2) > div:nth-child(3) > div.sc-gGPzkF.cDmuyY.flex.justify-start.sm\\:justify-end > button:nth-child(2)");
    private final By formsQuizStudentDownloadButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-iWVNaa.eCsXSR.mb-\\[20px\\].w-\\[100\\%\\] > div:nth-child(3) > div.sc-JkixQ.iaICsq.grid.grid-cols-1.sm\\:flex > div.sc-gGPzkF.cDmuyY.flex.justify-start.sm\\:justify-end > button:nth-child(2)");
    private final By formsInformativeText = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-dSfdvi.lnAGKN.pb-\\[20px\\].text-left.sm\\:text-justify");
    private final By appDownloadLink = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-dSfdvi.lnAGKN.pb-\\[20px\\].text-left.sm\\:text-justify > a");

    // Mapping

    private final By mappingInformativeMessage = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-fyrocj.bpVhgf.pb-\\[30px\\]");
    private final By mappingNavItem = By.cssSelector("#tabroot > div > div:nth-child(3) > div.sc-eCImPb.fLouw > div");
    private final By selectMappingCycle = By.id("select-data-options");
    private final By mappingRiskFactorFilterButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-XxNYO.iTFtAx.grid.grid-cols-1.mb-\\[20px\\].lg\\:flex > div.sc-kYHfwS.kainxu.grid.grid-cols-1.p-\\[3px\\].mt-\\[6px\\].ml-\\[6px\\] > div.sc-bilyIR.hbAzRT.grid.grid-cols-1.md\\:flex > button.sc-eGPXGI.cosjaf");
    private final By mappingYearTeamFilterButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-XxNYO.iTFtAx.grid.grid-cols-1.mb-\\[20px\\].lg\\:flex > div.sc-kYHfwS.kainxu.grid.grid-cols-1.p-\\[3px\\].mt-\\[6px\\].ml-\\[6px\\] > div.sc-bilyIR.hbAzRT.grid.grid-cols-1.md\\:flex > button:nth-child(2)");
    private final By mappingNumberOfRiskFactorsFilterButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-XxNYO.iTFtAx.grid.grid-cols-1.mb-\\[20px\\].lg\\:flex > div.sc-kYHfwS.kainxu.grid.grid-cols-1.p-\\[3px\\].mt-\\[6px\\].ml-\\[6px\\] > div.sc-bilyIR.hbAzRT.grid.grid-cols-1.md\\:flex > button:nth-child(3)");
    private final By mappingFirstSchoolButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-jHkVzv.bkFCMd > div > div.sc-fXEqDS.dORALW");
    private final By mappingFirstRiskFactorButton = By.cssSelector("#group-1 > div.sc-fXeWAj.geNgCu > div > div:nth-child(1)");
    private final By mappingFirstStudentOnRiskID = By.cssSelector("#factor-1 > div.sc-gjNHFA.bwLOgA.grid.grid-cols-1.sm\\:grid-cols-2");
    private final By mappingViewRiskFactorButton = By.cssSelector("#factor-1 > div.sc-gjNHFA.bwLOgA.grid.grid-cols-1.sm\\:grid-cols-2 > button");
    private final By mappingDownloadRiskFactorFileButton = By.cssSelector("#factor-1 > div.sc-jWUzzU.cbtPsP.overflow-x-scroll.scrollbar-hide > div:nth-child(2) > div.sc-kTLmzF.hepMYZ > button > div");


    // Following

    private final By followingNavItem = By.cssSelector("#tabroot > div > div:nth-child(4) > div.sc-eCImPb.fLouw > div");
    private final By followingInformativeText = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-dkYRCH.kWocAH.pb-\\[30px\\]");
    private final By followingViewButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-dFtzxp.ddsClR.grid.grid-cols-1.gap-\\[10px\\].sm\\:grid-cols-2 > div.sc-evcjhq.gFA-dEU.flex.justify-center.sm\\:justify-end > button:nth-child(1)");
    private final By followingDownloadButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-dFtzxp.ddsClR.grid.grid-cols-1.gap-\\[10px\\].sm\\:grid-cols-2 > div.sc-evcjhq.gFA-dEU.flex.justify-center.sm\\:justify-end > button:nth-child(2)");
    private final By followingModalView = By.cssSelector("body > div.ReactModalPortal > div > div > div.fixed.z-10.inset-0.overflow-y-auto > div > div");


    // forwarding

    private final By forwardingNavItem = By.cssSelector("#tabroot > div > div:nth-child(5) > div.sc-eCImPb.fLouw > div");
    private final By forwardingInformativeText = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-hOGkXu.kbFkHs.pb-\\[30px\\]");
    private final By forwardingUniversalButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-ehCJOs.gygaTB > div.sc-lcepkR.iwRvvA.grid.grid-cols-1.w-\\[100\\%\\].pb-\\[20px\\].lg\\:flex > div.sc-fWCJzd.lcEDXg.py-\\[15px\\].px-\\[30px\\].lg\\:pt-\\[30px\\].lg\\:mx-\\[5px\\]");
    private final By forwardingSelectiveButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-ehCJOs.gygaTB > div.sc-lcepkR.iwRvvA.grid.grid-cols-1.w-\\[100\\%\\].pb-\\[20px\\].lg\\:flex > div:nth-child(2)");
    private final By forwardingIndicatedButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-ehCJOs.gygaTB > div.sc-lcepkR.iwRvvA.grid.grid-cols-1.w-\\[100\\%\\].pb-\\[20px\\].lg\\:flex > div.sc-fWCJzd.lcEDXg.py-\\[15px\\].px-\\[30px\\].lg\\:pt-\\[30px\\].lg\\:mx-\\[5px\\]");

    private final By forwardingInputTextFilter = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-ehCJOs.gygaTB > div.sc-gGCDDS.incWIJ > div > input");

    private final By forwardingUniversalViewButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-ehCJOs.gygaTB > div.sc-Galmp.fUiyKz > div > div.sc-eLwHnm.ktEDFe.justify-center.mt-\\[10px\\] > button:nth-child(1)");
    private final By forwardingUniversalDownloadButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-ehCJOs.gygaTB > div.sc-Galmp.fUiyKz > div > div.sc-eLwHnm.ktEDFe.justify-center.mt-\\[10px\\] > button:nth-child(2)");

    private final By forwardingSelectiveFirstViewButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-ehCJOs.gygaTB > div.sc-Galmp.fUiyKz > div:nth-child(1) > div.sc-eLwHnm.ktEDFe.justify-center.mt-\\[10px\\] > button:nth-child(1)");
    private final By forwardingSelectiveFirstDownloadButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-ehCJOs.gygaTB > div.sc-Galmp.fUiyKz > div:nth-child(1) > div.sc-eLwHnm.ktEDFe.justify-center.mt-\\[10px\\] > button:nth-child(2)");

    private final By forwardingIndicatedFirstViewButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-ehCJOs.gygaTB > div.sc-Galmp.fUiyKz > div:nth-child(1) > div.sc-eLwHnm.ktEDFe.justify-center.mt-\\[10px\\] > button:nth-child(1)");
    private final By forwardingIndicatedFirstDownloadButton = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-ehCJOs.gygaTB > div.sc-Galmp.fUiyKz > div:nth-child(1) > div.sc-eLwHnm.ktEDFe.justify-center.mt-\\[10px\\] > button:nth-child(2)");

    private final By forwardingDivFilesWrapper = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.w-\\[100\\%\\] > div.sc-ehCJOs.gygaTB > div.sc-Galmp.fUiyKz");
    private final By forwardingModalViewer = By.cssSelector("body > div.ReactModalPortal > div > div > div.fixed.z-10.inset-0.overflow-y-auto > div > div > iframe");


    // monitoring

    private final By monitoringNavItem = By.cssSelector("#tabroot > div > div:nth-child(6) > div.sc-eCImPb.fLouw > div");
    private final By monitoringInformativeText = By.cssSelector("");
    private final By monitoringNumberOfStudentRegistered = By.cssSelector("#root > div:nth-child(1) > main > div > div > div.sc-itWPBs.iwEkvV > div:nth-child(2) > div:nth-child(1) > div.sc-kHdrYz.hoPktj.grid.grid-cols-1.sm\\:grid-cols-2.xl\\:grid-cols-4 > div:nth-child(1) > div.sc-gfqkcP.eblUOK > div.sc-ciFQTS.bMYvuX");


    // Constructor
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    // Forms Methods
    public boolean isVisibleMainPage(){

        boolean isVisible = driver.findElement(navigationBar).isDisplayed();

        return isVisible;
    }

    public boolean isVisibleHomePageInformationContent(){
        boolean isVisible = driver.findElement(homePageInformationContent).isDisplayed();

        return isVisible;
    }

    public void clickOnHomePageNavItem() {
        driver.findElement(homePageNavItem).click();
    }

    public void clickOnFormNavItem() {
        driver.findElement(formNavItem).click();
    }

    public boolean verifyTypesOfForms(){

        List<WebElement> formsList = driver.findElements(formsTypeOfForms);

        WebElement form1 = formsList.get(0);
        WebElement form2 = formsList.get(1);

        boolean isValid = form1.getText().contains("Escola")
                && form2.getText().contains("Estudante");

        return isValid;
    }

    public boolean getAllQuestionnaires(){

        List<WebElement> questionnairesList = driver.findElements(formsQuestionnaires);

        WebElement quiz1 = questionnairesList.get(0);
        WebElement quiz2 = questionnairesList.get(1);

        boolean isValid = quiz1.getText().contains("Questionário da Escola por Aluno")
                && quiz2.getText().contains("Questionário do Estudante");

        return isValid;
    }

    public void clickOnSchoolViewIcon(){
        driver.findElement(formsQuizSchoolViewButton).click();
    }

    public void clickOnSchoolDownloadIcon(){
        driver.findElement(formsQuizSchoolDownloadButton).click();
    }

    public void clickOnDemographicViewIcon(){
        driver.findElement(formsQuizDemographicViewButton).click();
    }

    public void clickOnDemographicDownloadIcon(){
        driver.findElement(formsQuizDemographicDownloadButton).click();
    }

    public void clickOnStudentViewIcon(){
        driver.findElement(formsQuizStudentViewButton).click();
    }

    public void clickOnStudentDownloadIcon(){
        driver.findElement(formsQuizStudentDownloadButton).click();
    }

    public boolean isSchoolModalDisplayed(){

        boolean isDisplayed = driver.findElement(formsSchoolDocumentModal).isDisplayed();

        return isDisplayed;
    }

    public boolean isSchoolModalSelected(){

        boolean isSelected = driver.findElement(formsSchoolDocumentModal).isSelected();

        return isSelected;
    }

    public boolean isDemographicModalDisplayed(){

        boolean isDisplayed = driver.findElement(formsDemographicDocumentModal).isDisplayed();

        return isDisplayed;
    }

    public boolean isDemographicModalSelected(){

        boolean isSelected = driver.findElement(formsDemographicDocumentModal).isSelected();

        return isSelected;
    }

    public boolean isStudentModalDisplayed(){

        boolean isDisplayed = driver.findElement(formsStudentDocumentModal).isDisplayed();

        return isDisplayed;
    }

    public boolean isStudentModalSelected(){

        boolean isSelected = driver.findElement(formsStudentDocumentModal).isSelected();

        return isSelected;
    }

    public void closeModal(){
        driver.findElement(formsModalCloseButton).click();
    }

    public boolean isDisplayedFormsInformativeText(){

        boolean isDisplayed = driver.findElement(formsInformativeText).isDisplayed();

        return isDisplayed;
    }

    public boolean isDisplayedAppDownloadLink(){

        boolean isDisplayed = driver.findElement(appDownloadLink).isDisplayed();

        return isDisplayed;
    }

    public void clickOnAppDownloadLink(){
        driver.findElement(appDownloadLink).click();
    }


    // Mapping methods

    public void clickOnMappingNavItem() {
        driver.findElement(mappingNavItem).click();
    }

    public boolean isDisplayedMappingInformativeText(){

        boolean isDisplayed = driver.findElement(mappingInformativeMessage).isEnabled();

        return isDisplayed;
    }

    public void clickOnMappingRiskFactorButton(){
        driver.findElement(mappingRiskFactorFilterButton).click();
    }

    public void clickOnMappingYearTeamButton(){
        driver.findElement(mappingYearTeamFilterButton).click();
    }

    public void clickOnMappingNumberOfRiskFactorsButton(){
        driver.findElement(mappingNumberOfRiskFactorsFilterButton).click();
    }

    public int getNumberOfMappingCycle(){

        // find the dropdown
        Select s = new Select(driver.findElement(selectMappingCycle));

        // get the options from the dropdown
        List <WebElement> options = s.getOptions();

        return options.size();
    }

    public void clickOnMappingFirstSchoolButton(){
        driver.findElement(mappingFirstSchoolButton).click();
    }

    public void clickOnMappingFirstRiskFactorButton(){
        driver.findElement(mappingFirstRiskFactorButton).click();
    }

    public boolean isDisplayedFirstStudentRisk(){

        boolean isDisplayed = driver.findElement(mappingFirstStudentOnRiskID).isDisplayed();
        return isDisplayed;
    }

    public void clickOnMappingViewRiskFactorButton(){
        driver.findElement(mappingViewRiskFactorButton).click();
    }

    public void clickOnMappingDownloadRiskFactorFileButton(){
        driver.findElement(mappingDownloadRiskFactorFileButton).click();
    }


    // Following Methods

    public void clickOnFollowingNavItem(){
        driver.findElement(followingNavItem).click();
    }

    public boolean isDisplayedFollowingInformativeText(){

        boolean isDisplayed = driver.findElement(followingInformativeText).isDisplayed();
        return isDisplayed;
    }

    public void clickOnFollowingViewButton(){
        driver.findElement(followingViewButton).click();
    }

    public void clickOnFollowingDownloadButton(){
        driver.findElement(followingDownloadButton).click();
    }

    public boolean isFollowingViewModalDisplayed(){

        boolean isDisplayed = driver.findElement(followingModalView).isDisplayed();

        return isDisplayed;
    }


    // forwarding

    public void clickOnForwardingNavItem(){
        driver.findElement(forwardingNavItem).click();
    }

    public boolean isDisplayedforwardingInformativeText(){
        boolean isDisplayed = driver.findElement(forwardingInformativeText).isDisplayed();

        return isDisplayed;
    }

    public void clickOnForwardingUniversalButton(){
        driver.findElement(forwardingUniversalButton).click();
    }

    public void clickOnForwardingSelectiveButton(){
        driver.findElement(forwardingSelectiveButton).click();
    }

    public void clickOnForwardingIndicatedButton(){
        driver.findElement(forwardingIndicatedButton).click();
    }

    public String getNameOfFirstDocumentInForwardingArea(){

        List<WebElement> listOfChildren = driver.findElements(forwardingDivFilesWrapper);

        String firstDocument = listOfChildren.get(0).getText();

        return firstDocument;
    }

    public int [] getNumberOfFilesInForwardingAreaBeforeAndAfterFilter(String filter){

        List<WebElement> listOfChildrenBefore = driver.findElements(forwardingDivFilesWrapper);

        int elementsBeforeFilter = listOfChildrenBefore.size();

        driver.findElement(forwardingInputTextFilter).sendKeys(filter);

        List<WebElement> listOfChildrenAfter = driver.findElements(forwardingDivFilesWrapper);

        int elementsAfterFilter = listOfChildrenAfter.size();

        int[] results = {elementsBeforeFilter,elementsAfterFilter};

        return results;
    }

    public void clickOnForwardingUniversalViewButton(){
        driver.findElement(forwardingUniversalViewButton).click();
    }

    public void clickOnForwardingUniversalDownloadButton(){
        driver.findElement(forwardingUniversalDownloadButton).click();
    }

    public void clickOnForwardingSelectiveFirstViewButton(){
        driver.findElement(forwardingSelectiveFirstViewButton).click();
    }

    public void clickOnForwardingSelectiveFirstDownloadButton(){
        driver.findElement(forwardingSelectiveFirstDownloadButton).click();
    }

    public void clickOnForwardingIndicatedFirstViewButton(){
        driver.findElement(forwardingIndicatedFirstViewButton).click();
    }

    public void clickOnForwardingIndicatedFirstDownloadButton(){
        driver.findElement(forwardingIndicatedFirstDownloadButton).click();
    }

    public boolean isDisplayedModalOnForwardingArea(){

        boolean isDisplayed = driver.findElement(forwardingModalViewer).isDisplayed();

        return isDisplayed;

    }


    // monitoring methods

    public void clickOnMonitoringNavItem(){
        driver.findElement(monitoringNavItem).click();
    }

    public boolean isDisplayedInformativeTextOnMonitoringArea(){

        boolean isDisplayed = driver.findElement(monitoringInformativeText).isDisplayed();

        return isDisplayed;
    }


    public int getNumberOfStudentRegisteredOnMonitoringArea(){

        String stringNumber = driver.findElement(monitoringNumberOfStudentRegistered).getText();
        System.out.println(stringNumber);
        int numberOfStudentRegistered = Integer.parseInt(stringNumber);

        return numberOfStudentRegistered;
    }


}
