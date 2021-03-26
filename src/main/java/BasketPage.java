import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    private By basketPagePriceBy = By.className("total-price");
    //Product's price on Basket Page

    private By numberSectionBy = By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[4]/div/div[2]/select");
    // The option box which is using for increasing product number

    private By select2By = By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[4]/div/div[2]/select/option[2]");
    //Selecting 2 on option box

    private By deleteButtonBy = By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[3]/div/div[2]/div/a[1]");
    //Delete button for product to be deleted

    public String getBasketPagePrice(){
        return driver.findElement(basketPagePriceBy).getText();
    }
    public void increaseProduct(){
        driver.findElement(numberSectionBy).click();
        driver.findElement(select2By).click();
        driver.findElement(numberSectionBy).click();
    }

    public String currentProductNumber(){
        return driver.findElement(numberSectionBy).getAttribute("value");
    }

    public void deleteProduct(){
        driver.findElement(deleteButtonBy).click();
    }
}
