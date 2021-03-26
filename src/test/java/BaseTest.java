import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;


    @BeforeClass
    public static void SetUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); //Disabled notifications when chromedriver starts
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); //Disabled "Chrome is being controlled by automated software" when chromedriver starts
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //max implicity waiting time for driver to begin next step
        driver.get("https://www.gittigidiyor.com");
        driver.findElement(By.className("fEwnjq")).click(); //Close Cookies Policy
    }

    @AfterClass
    public static void finishedTest(){
        driver.quit();
    }
}
