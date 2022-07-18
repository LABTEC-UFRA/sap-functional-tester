package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class BaseTest {

    private static WebDriver driver;
    protected static String url;
    protected static String user;
    protected static String password;

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected TermsOfUsePage termOfUsePage;
    protected CreateAccountBankPage createAccountBankPage;
    protected WelcomePage welcomePage;
    protected  ProfilePage profilePage;
    protected MainPage mainPage;

    // selenium
    JavascriptExecutor js;
    private Map<String, Object> vars;

    @BeforeAll
    public static void initializer(){

        // get operational system name
        String os = System.getProperty("os.name");

        // get project path
        String path = System.getProperty("user.dir");

        Properties props = new Properties();
        InputStream input;

        try {

            // windows
            if(os.contains("Windows")){
                System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\webdrivers\\chrome\\103\\chromedriver.exe");
                input = new FileInputStream(path + "\\src\\main\\resources\\local.properties");
            }

            //linux
            else{
                System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/webdrivers/chrome/103/chromedriver");
                input = new FileInputStream("/src/main/resources/local.properties");
            }

            // load file info in props attribute
            props.load(input);
        }
        catch (IOException exception){
            System.out.println("Create local.properties file in the resources folder of the project and add the \"url\", \"email\" and \"password\" values to it.");
            return;
        }

        // get the url, email and password from properties file
        url = props.getProperty("url");
        user = props.getProperty("user");
        password = props.getProperty("password");


        // load the driver
        driver = new ChromeDriver();

        // adjust window size
        driver.manage().window().setSize(new Dimension(1223, 847));

        // a timer to guarantee that elements will load (implicit wait of 5 seconds)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @BeforeEach
    public void loadHomePage() throws InterruptedException {
        driver.get(url);

        // selenium
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        // pages
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        termOfUsePage = new TermsOfUsePage(driver);
        createAccountBankPage = new CreateAccountBankPage(driver);
        welcomePage = new WelcomePage(driver);
        profilePage = new ProfilePage(driver);
        mainPage = new MainPage(driver);

        Thread.sleep(2000);

    }

    @AfterAll
    public static void finish(){
        driver.quit();
    }


    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }


}
