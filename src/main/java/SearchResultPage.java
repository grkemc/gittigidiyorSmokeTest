import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class SearchResultPage extends BasePage{

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    private String secondPageUrl = "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2";
    //Second Page's URL

    private By addToBasketBy = By.id("add-to-basket");
    //Add to basket button when selecting a product in searchresultspage

    private By goToBasketBy = By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/div/div/div/div[2]/div[4]/div[1]/a");
    //Clickable go To Basket button just after adding a product on the basket

    public void getSecondPage(){
        driver.navigate().to(secondPageUrl);
    }

    public void getRandomProduct(){
        Random random=new Random();
        int upper=48;
        int rand_item= random.nextInt(upper);
        WebElement item= driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[3]/div[2]/ul/li["+rand_item+"]"));
        item.click();
    }

    public void throwProductToBasket(){
        driver.findElement(addToBasketBy).click();
    }

    public void goToBasketPage(){
        driver.findElement(goToBasketBy).click();
    }

}
