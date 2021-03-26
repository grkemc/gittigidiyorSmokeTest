import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    private By navbarBy = By.className("jAtBcS");
    //The navbar section for checking if the Homepage loading

    private By loginButtonBy = By.className("icMLoL");
    //Mouse over "Giriş yap" Button. The login process has 2 steps. 1) click logginButtonBy 2)After that clicking the opened new "Giriş Yap" section

    private By enterButtonBy = By.className("kNKwwK");
    //Separate part that opens when hovering with the mouse.

    private By accountUserBy = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div/div[2]/span");
    //The text area which is using for get the user's text

    private By searchBoxBy = By.className("sc-4995aq-0");
    //The search box item which is using for searching keyword

    public boolean isPageLoaded(){
        return driver.findElement(navbarBy).isDisplayed();
    }

    public void getLoginPage(){
        driver.findElement(loginButtonBy).click();
        driver.findElement(enterButtonBy).click();
    }

    public String getAccountUserText(){
        return driver.findElement(accountUserBy).getText();
    }

    public void search(String keyword){
        driver.findElement(searchBoxBy).sendKeys(keyword+ Keys.ENTER);

    }
}
