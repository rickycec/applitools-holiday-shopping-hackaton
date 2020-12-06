package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Object representation of the main page of the application
 */
public class MainPage {

    private final WebDriver driver;
    private final By filterBlack = By.id("colors__Black");
    private final By filterButton = By.id("filterBtn");
    private final By shoesGrid = By.id("product_grid");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getShoesGridLocator() {
        return shoesGrid;
    }

    /**
     * Filter the products by clicking on the "Black" filter
     */
    public void filterByBlack() {
        driver.findElement(filterBlack).click();
        driver.findElement(filterButton).click();
    }

    /**
     * @param name The name of the product to select
     * @return A new instance of the Product Detail Page
     * @throws NoSuchElementException If no product with the given can be selected an exception should be thrown and intercepted in the test cases
     */
    public ProductDetailPage selectProductByName(String name) throws NoSuchElementException {
        driver.findElement(By.linkText(name)).click();
        return new ProductDetailPage(driver);
    }

}
