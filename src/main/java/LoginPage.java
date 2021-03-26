import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailBy = By.id("L-UserNameField");
    //E-mail section in login form

    private By passwordBy = By.id("L-PasswordField");
    //Password section in login form

    private By submitBy = By.id("gg-login-enter");
    //Submit button in login form


    public void userLoginForm(String email, String password) {
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(submitBy).click();
    }



}
