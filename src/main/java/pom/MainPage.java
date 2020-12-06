package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private By filterBlack = By.id("colors__Black");
    private By filterButton = By.id("filterBtn");
    private By shoesGrid = By.id("product_grid");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getShoesGridLocator() {
        return shoesGrid;
    }

    public void filterByBlack() {
        driver.findElement(filterBlack).click();
        driver.findElement(filterButton).click();
    }

    public ProductDetailPage selectProductByName(String name) {
        driver.findElement(By.linkText(name)).click();
        return new ProductDetailPage(driver);
    }

}
