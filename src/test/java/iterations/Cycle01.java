package iterations;

import base.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementClickInterceptedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Cycle01 extends BaseTest {

    @Test
    public void successfulLandingPage_CT1001(){

        String entryButtonLabel = super.homePage.getEntryButtonLabel();

        assertThat(entryButtonLabel.contains("gov.br"), is(true));
    }

    @Test
    public void verifyLoginButtons_CT1002() throws InterruptedException {

        super.homePage.clickEntryButton();

        boolean isVisible = super.loginPage.isVisibleUserField();

        assertThat(isVisible, is(true));

    }

    @Test
    public void verifyLoginUserField_CT1003(){

        super.homePage.clickEntryButton();

        super.loginPage.fillUser(user);
        super.loginPage.clickContinueLoginButton();

        boolean isVisible = loginPage.isVisiblePasswordField();

        assertThat(isVisible, is(true));

    }


    @Test
    public void proceedToSignUp_CT1004() throws InterruptedException {

        super.homePage.clickEntryButton();

        // use an invalid user

        super.loginPage.fillUser("124.043.740-44");
        super.loginPage.clickContinueLoginButton();

        Thread.sleep(2000);

        boolean isVisible = super.termOfUsePage.isVisibleCheckBoxTermCaptcha();

        assertThat(isVisible, is(true));

    }

    @Test @Disabled
    public void verifyCheckBoxes_CT1005() throws InterruptedException {

        //CTs 1005 ~ 1008 need to be performed manually (human captcha)

        super.homePage.clickEntryButton();

        super.loginPage.fillUser("124.043.740-44");
        super.loginPage.clickContinueLoginButton();

        super.termOfUsePage.clickCheckBoxesCaptcha();
        super.termOfUsePage.clickContinueButton();

        boolean isBankPage = super.createAccountBankPage.isBankPage();

        assertThat(isBankPage, is(true));
    }

    @Test
    public void verifyValidLogin_CT1009() throws InterruptedException {

        super.homePage.clickEntryButton();

        super.loginPage.fillUser(user);
        super.loginPage.clickContinueLoginButton();

        Thread.sleep(1000);

        super.loginPage.fillPassword(password);
        super.loginPage.clickEnterLoginButton();

        Thread.sleep(2000);

        boolean isOnWelcomePage = super.welcomePage.isOnWelcomePage();

        assertThat(isOnWelcomePage, is(true));

    }

    @Test
    public void verifyDropDownMenu_CT1010() throws InterruptedException {

        verifyValidLogin_CT1009();

        boolean areVisible = super.welcomePage.areDropDownItemsVisible();

        assertThat(areVisible, is(true));

    }

    @Test
    public void verifyQuitButton_CT1011() throws InterruptedException {

        verifyValidLogin_CT1009();

        super.welcomePage.clickOnQuitButton();

        String loginUrl = url;

        assertThat(getCurrentUrl(), is(loginUrl));

    }

    @Test
    public void verifyQuitAndEnterAgain_CT_1012() throws InterruptedException {

        verifyQuitButton_CT1011();

        Thread.sleep(2000);

        super.homePage.clickEntryButton();

        String currentUrl = getCurrentUrl();

        assertThat(currentUrl, is(url));

    }

    @Test
    public void verifyManageProfile_CT1013() throws InterruptedException {

        verifyValidLogin_CT1009();

        super.welcomePage.clickOnManageProfileButton();

        Thread.sleep(2000);

        boolean isVisibleHeader = super.profilePage.isVisibleHeader();

        assertThat(isVisibleHeader, is(true));

    }


    @Test
    public void accessSapMainArea_CT1014() throws InterruptedException {

        verifyValidLogin_CT1009();

        welcomePage.clickOnSeeMoreButton();

        boolean isVisible = super.mainPage.isVisibleMainPage();

        assertThat(isVisible, is(true));

    }

    @Test
    public void isSapContentDisplayed_CT1015() throws InterruptedException {

        accessSapMainArea_CT1014();

        boolean isVisible = super.mainPage.isVisibleInformationContent();

        assertThat(isVisible, is(true));

    }

    @Test
    public void accessFormFromSapMainArea_CT1016() throws InterruptedException {
        accessSapMainArea_CT1014();

        Thread.sleep(3000);

        super.mainPage.clickOnFormNavItem();

        boolean isValid = super.mainPage.verifyTypesOfForms();

        assertThat(isValid, is(true));

    }

    @Test
    public void verifyQuestionnairesSapFormsArea_CT_1017() throws InterruptedException {

        accessFormFromSapMainArea_CT1016();

        boolean isValid = super.mainPage.getAllQuestionnaires();

        assertThat(isValid, is(true));

    }

    @Test
    public void viewStudentQuiz_CT_1018() throws InterruptedException {
        accessFormFromSapMainArea_CT1016();

        super.mainPage.clickOnSchoolViewIcon();

        Thread.sleep(1000);

        boolean isDisplayed = super.mainPage.isSchoolModalDisplayed();

        assertThat(isDisplayed, is(true));

    }

    @Test
    public void quitStudentQuiz_CT_1019() throws InterruptedException {
        accessFormFromSapMainArea_CT1016();

        super.mainPage.clickOnSchoolViewIcon();

        Thread.sleep(1000);

        super.mainPage.closeModal();

        Thread.sleep(2000);

        boolean isSelected = super.mainPage.isSchoolModalSelected();

        assertThat(isSelected, is(false));

    }


    @Test
    public void accessItemOutsideStudentQuizModal_CT_1020() throws InterruptedException {

        // I can't click outside the modal, thus it will generate an ElementClickInterceptedException

        assertThrows(ElementClickInterceptedException.class,
                ()->{

                    accessFormFromSapMainArea_CT1016();

                    super.mainPage.clickOnSchoolViewIcon();

                    Thread.sleep(1000);

                    super.mainPage.clickOnStudentViewIcon();
                });
    }


    @Test
    public void downloadSchoolQuiz_CT_1021() throws InterruptedException {
        accessFormFromSapMainArea_CT1016();

        super.mainPage.clickOnSchoolDownloadIcon();

        // should I verify a downloaded file?

    }


    @Test
    public void viewDemographicQuiz_CT_1022() throws InterruptedException {
        accessFormFromSapMainArea_CT1016();

        super.mainPage.clickOnDemographicViewIcon();

        Thread.sleep(1000);

        boolean isDisplayed = super.mainPage.isDemographicModalDisplayed();

        assertThat(isDisplayed, is(true));

    }

    @Test
    public void quitDemographicQuiz_CT_1023() throws InterruptedException {
        accessFormFromSapMainArea_CT1016();

        super.mainPage.clickOnDemographicViewIcon();

        Thread.sleep(1000);

        super.mainPage.closeModal();

        Thread.sleep(2000);

        boolean isSelected = super.mainPage.isDemographicModalSelected();

        assertThat(isSelected, is(false));

    }

    @Test
    public void accessItemOutsideDemographicQuiz_CT_1024(){
        // I can't click outside the modal, thus it will generate an ElementClickInterceptedException

        assertThrows(ElementClickInterceptedException.class,
                ()->{

                    accessFormFromSapMainArea_CT1016();

                    super.mainPage.clickOnDemographicViewIcon();

                    Thread.sleep(1000);

                    super.mainPage.clickOnStudentViewIcon();
                });
    }

    @Test
    public void downloadDemographicQuiz_CT_1025() throws InterruptedException {
        accessFormFromSapMainArea_CT1016();

        super.mainPage.clickOnDemographicDownloadIcon();

        // should I verify a downloaded file?

    }

    //CT1026?????

    @Test
    public void viewStudentQuiz_CT_1027() throws InterruptedException {
        accessFormFromSapMainArea_CT1016();

        super.mainPage.clickOnStudentViewIcon();

        Thread.sleep(1000);

        boolean isDisplayed = super.mainPage.isStudentModalDisplayed();

        assertThat(isDisplayed, is(true));
    }

    @Test
    public void quitStudentQuiz_CT_1028() throws InterruptedException {
        accessFormFromSapMainArea_CT1016();

        super.mainPage.clickOnStudentViewIcon();

        Thread.sleep(1000);

        super.mainPage.closeModal();

        Thread.sleep(2000);

        boolean isSelected = super.mainPage.isStudentModalSelected();

        assertThat(isSelected, is(false));
    }

    @Test
    public void accessItemOutsideStudentQuiz_CT_1029(){
        // I can't click outside the modal, thus it will generate an ElementClickInterceptedException

        assertThrows(ElementClickInterceptedException.class,
                ()->{

                    accessFormFromSapMainArea_CT1016();

                    super.mainPage.clickOnStudentViewIcon();

                    Thread.sleep(1000);

                    super.mainPage.clickOnSchoolViewIcon();
                });
    }

    @Test
    public void downloadStudentQuiz_CT_1030() throws InterruptedException {
        accessFormFromSapMainArea_CT1016();

        super.mainPage.clickOnStudentDownloadIcon();

        // should I verify a downloaded file?
    }

    @Test
    public void verifyInformativeText_CT_1031() throws InterruptedException {
        accessFormFromSapMainArea_CT1016();

        boolean isDisplayed = super.mainPage.isDisplayedInformativeText();

        assertThat(isDisplayed, is(true));

    }

    @Test
    public void verifyDownloadAppLinkCT_1032() throws InterruptedException {
        accessFormFromSapMainArea_CT1016();

        boolean isDisplayed = super.mainPage.isDisplayedAppDownloadLink();

        assertThat(isDisplayed, is(true));
    }

    @Test
    public void CT_1033() throws InterruptedException {
        accessFormFromSapMainArea_CT1016();

        super.mainPage.clickOnAppDownloadLink();

        // should I verify a downloaded file?

    }
}
