package iterations;

import base.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Cycle02 extends BaseTest {

    @Test
    public void accessSapMainArea_CT2000() throws InterruptedException {

        super.homePage.clickEntryButton();

        super.loginPage.fillUser(user);
        super.loginPage.clickContinueLoginButton();

        Thread.sleep(1000);

        super.loginPage.fillPassword(password);
        super.loginPage.clickEnterLoginButton();

        Thread.sleep(2000);

        welcomePage.clickOnSeeMoreButton();

        boolean isVisible = super.mainPage.isVisibleMainPage();

        assertThat(isVisible, is(true));

    }


    @Test
    public void verifyMappingInformativeText_CT_2001() throws InterruptedException {
        accessSapMainArea_CT2000();

        super.mainPage.clickOnMappingNavItem();

        boolean isDisplayed = super.mainPage.isDisplayedMappingInformativeText();

        assertThat(isDisplayed, is(true));

    }

    @Test
    public void checkNumberOfMappingCycle_CT_2002() throws InterruptedException {
        accessSapMainArea_CT2000();

        super.mainPage.clickOnMappingNavItem();

        Thread.sleep(1000);

        int numberOfOption = super.mainPage.getNumberOfMappingCycle();

        // have at least one option
        boolean expected = numberOfOption > 0;

        assertThat(expected, is(true));

    }

    @Test
    public void verifyNavigationFromMappingToHome_CT_2003() throws InterruptedException {
        accessSapMainArea_CT2000();

        super.mainPage.clickOnMappingNavItem();

        super.mainPage.clickOnHomePageNavItem();

        Thread.sleep(1000);

        boolean isVisible = super.mainPage.isVisibleHomePageInformationContent();

        assertThat(isVisible, is(true));

    }

    @Test
    public void verifyStudentAtRisk_CT_2004() throws InterruptedException {
        accessSapMainArea_CT2000();

        super.mainPage.clickOnMappingNavItem();

        Thread.sleep(1000);

        super.mainPage.clickOnMappingRiskFactorButton();

        Thread.sleep(1000);

        super.mainPage.clickOnMappingFirstSchoolButton();

        Thread.sleep(1000);

        super.mainPage.clickOnMappingFirstRiskFactorButton();

        Thread.sleep(1000);

        boolean isDisplayed = super.mainPage.isDisplayedFirstStudentRisk();

        assertThat(isDisplayed, is(true));

    }

    @Test
    public void visualizeStudentRiskFactor_CT_2005() throws InterruptedException {
        verifyStudentAtRisk_CT_2004();

        super.mainPage.clickOnMappingViewRiskFactorButton();

        // should happen something (nothing happens)

    }

    @Test
    public void downloadStudentRiskFactor_CT_2006() throws InterruptedException {
        verifyStudentAtRisk_CT_2004();

        super.mainPage.clickOnMappingDownloadRiskFactorFileButton();

        // should happen something (nothing happens)
    }

    @Test
    public void accessFollowingArea_CT_2007() throws InterruptedException {
        accessSapMainArea_CT2000();

        super.mainPage.clickOnFormNavItem();

        boolean isDisplayed = super.mainPage.isDisplayedFollowingInformativeText();

        assertThat(isDisplayed, is(true));
    }

    @Test
    public void verifyFollowingAreaModalView_CT_2008() throws InterruptedException {
        accessSapMainArea_CT2000();

        super.mainPage.clickOnFollowingNavItem();
        super.mainPage.clickOnFollowingViewButton();

        Thread.sleep(1000);

        boolean isDisplayed = super.mainPage.isFollowingViewModalDisplayed();

        Thread.sleep(1000);

        assertThat(isDisplayed, is(true));
    }

    @Test
    public void verifyFollowingAreaDownloadButton_CT_2009() throws InterruptedException {
        accessSapMainArea_CT2000();

        super.mainPage.clickOnFollowingNavItem();
        super.mainPage.clickOnFollowingDownloadButton();

        Thread.sleep(1000);

        // should I verify something??

    }

    @Test
    public void verifyGroupingMappingByRiskFactor_CT_2010() throws InterruptedException {
        accessSapMainArea_CT2000();

        super.mainPage.clickOnMappingNavItem();

        super.mainPage.clickOnMappingNumberOfRiskFactorsButton();

        // I can't verify the behaviour without more items

    }

    @Test
    public void verifyGroupingMappingByYearTeam_CT_2011() throws InterruptedException {
        accessSapMainArea_CT2000();

        super.mainPage.clickOnMappingNavItem();

        super.mainPage.clickOnMappingYearTeamButton();

        // I can't verify the behaviour without more items
    }

    @Test
    public void verifyAccompanimentInformativeText_CT_2012() throws InterruptedException {
        accessSapMainArea_CT2000();

        super.mainPage.clickOnForwardingNavItem();

        boolean isDisplayed = super.mainPage.isDisplayedforwardingInformativeText();

        assertThat(isDisplayed, is(true));
    }

    @Test
    public void fromAccompanimentAreaGetBackToMainArea_CT_2013() throws InterruptedException {
        accessSapMainArea_CT2000();

        super.mainPage.clickOnForwardingNavItem();

        Thread.sleep(1000);

        super.mainPage.clickOnHomePageNavItem();

        boolean isDisplayed = super.mainPage.isVisibleHomePageInformationContent();

        assertThat(isDisplayed, is(true));

    }

    @Test
    public void verifyBehaviourOfUniversalActionButtonInForwardingArea_CT_2014() throws InterruptedException {

        accessSapMainArea_CT2000();

        super.mainPage.clickOnForwardingNavItem();

        String firstItemBeforeAnyClick = super.mainPage.getNameOfFirstDocumentInForwardingArea();

        super.mainPage.clickOnForwardingSelectiveButton();

        String firstItemAfterClick = super.mainPage.getNameOfFirstDocumentInForwardingArea();

        // they should be different because each action have a different set of documents
        boolean areEquals = firstItemBeforeAnyClick.contentEquals(firstItemAfterClick);

        assertThat(areEquals, is(false));

    }

    @Test
    public void verifyBehaviourOfSelectiveActionButtonInForwardingArea_CT_2015() throws InterruptedException {

        accessSapMainArea_CT2000();

        super.mainPage.clickOnForwardingNavItem();

        super.mainPage.clickOnForwardingSelectiveButton();

        String firstItemBeforeAnyClick = super.mainPage.getNameOfFirstDocumentInForwardingArea();

        super.mainPage.clickOnForwardingIndicatedButton();

        String firstItemAfterClick = super.mainPage.getNameOfFirstDocumentInForwardingArea();

        // they should be different because each action have a different set of documents
        boolean areEquals = firstItemBeforeAnyClick.contentEquals(firstItemAfterClick);

        assertThat(areEquals, is(false));

    }

    @Test
    public void verifyBehaviourOfIndicativeActionButtonInForwardingArea_CT_2016() throws InterruptedException {

        accessSapMainArea_CT2000();

        super.mainPage.clickOnForwardingNavItem();

        super.mainPage.clickOnForwardingIndicatedButton();

        String firstItemBeforeAnyClick = super.mainPage.getNameOfFirstDocumentInForwardingArea();

        super.mainPage.clickOnForwardingUniversalButton();

        String firstItemAfterClick = super.mainPage.getNameOfFirstDocumentInForwardingArea();

        // they should be different because each action have a different set of documents
        boolean areEquals = firstItemBeforeAnyClick.contentEquals(firstItemAfterClick);

        assertThat(areEquals, is(false));

    }

    @Test
    public void verifyModalAfterClickOnDocumentOnForwardingArea_CT_2017() throws InterruptedException {

        accessSapMainArea_CT2000();

        super.mainPage.clickOnForwardingNavItem();

        super.mainPage.clickOnForwardingIndicatedButton();
        super.mainPage.clickOnForwardingIndicatedFirstViewButton();

        boolean isDisplayedModal = super.mainPage.isDisplayedModalOnForwardingArea();

        assertThat(isDisplayedModal, is(true));

        // There aren't any PDF related to the document? I can see the modal but no PDF is loaded

    }

    @Test
    public void verifyDownloadDocumentAfterClickOnDocumentOnForwardingArea_CT_2018() throws InterruptedException {

        accessSapMainArea_CT2000();

        super.mainPage.clickOnForwardingNavItem();
        super.mainPage.clickOnForwardingSelectiveButton();

        super.mainPage.clickOnForwardingSelectiveFirstDownloadButton();

        // There aren't any PDF related to the document? The browser is downloading an empty file

        // should I verify a download action?


    }

    @Test
    public void verifyBehaviourOfFilterInForwardingArea_CT_2019() throws InterruptedException {

        accessSapMainArea_CT2000();

        super.mainPage.clickOnForwardingNavItem();
        super.mainPage.clickOnForwardingSelectiveButton();

        // no file name should be named like that
        String garbage = "asdadqwe";

        int[] numberOfDocumentsBeforeAndAfterFilter;

        // thus filter should display no item
        numberOfDocumentsBeforeAndAfterFilter = super.mainPage.getNumberOfFilesInForwardingAreaBeforeAndAfterFilter(garbage);

        int before = numberOfDocumentsBeforeAndAfterFilter[0];
        int after  = numberOfDocumentsBeforeAndAfterFilter[1];

        // this should be false
        boolean areDifferent = before == after;

        assertThat(areDifferent, is(false));

    }

    @Test
    public void isDisplayedInformativeTextOnMonitoringArea_CT_2020() throws InterruptedException {

        accessSapMainArea_CT2000();

        super.mainPage.clickOnMonitoringNavItem();

        boolean isDisplayed = super.mainPage.isDisplayedInformativeTextOnMonitoringArea();

        assertThat(isDisplayed, is(true));

        // There are no informative text on Monitoring Area!

    }

    @Test
    public void verifyIfMonitoringAreaIsDisplayingDataCorrectly_CT_2021() throws InterruptedException {

        accessSapMainArea_CT2000();

        super.mainPage.clickOnMonitoringNavItem();

        int numberOfStudentRegistered = super.mainPage.getNumberOfStudentRegisteredOnMonitoringArea();

        boolean areGreaterThenZero = numberOfStudentRegistered > 0;

        assertThat(areGreaterThenZero, is(true));


        // number of students registered should be GREATER than ZERO

    }



}
