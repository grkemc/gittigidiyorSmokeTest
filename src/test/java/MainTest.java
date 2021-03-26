import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainTest extends BaseTest{

    @Test
    public void should1HomePageDisplayed() {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isPageLoaded(),true);
    }
    @Test
    public void should2LoginSuccesfully(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.getLoginPage();
        loginPage.userLoginForm("uitestingdemo", "qwert12345");
        String actualAccountText = homePage.getAccountUserText();
        Assert.assertEquals(actualAccountText,"uitestingdemo");
    }
    @Test
    public void should3Page2Displayed(){
        String keyword ="bilgisayar";
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        homePage.search(keyword);
        searchResultPage.getSecondPage();
        Assert.assertTrue(driver.getTitle().contains("Bilgisayar - GittiGidiyor - 2/100"));
    }
    @Test
    public void should4PricesSame(){
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        searchResultPage.getRandomProduct();
        String productPriceOnSearchPage = driver.findElement(By.id("sp-price-lowPrice")).getText();
        searchResultPage.throwProductToBasket();
        searchResultPage.goToBasketPage();
        assertEquals(productPriceOnSearchPage,basketPage.getBasketPagePrice());
    }
    @Test
    public void should5IncreaseProductConfirmed(){

        BasketPage basketPage = new BasketPage(driver);
        basketPage.increaseProduct();
        String expectedProductNumber = "2";
        assertEquals(basketPage.currentProductNumber(),expectedProductNumber);
    }
    @Test
    public void should6ProductBeDeleted(){
        BasketPage basketPage = new BasketPage(driver);
        basketPage.deleteProduct();
        assertTrue(driver.findElement(By.className("clearfix")).isDisplayed());
    }
}