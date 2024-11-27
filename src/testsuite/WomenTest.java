package testsuite;

import Utilities.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WomenTest extends Utility {
    String baseURL = "https://magento.softwaretestingboard.com";

    @Before
    public void setup() {
        openBrowser(baseURL);
    }

@Test
public void verifyTheSortByProductNameFilter() {
//click on cookie

    clickOnElement(By.xpath("//body/div[3]/div[2]/div[2]/div[2]/div[2]/button[1]"));

//* Mouse Hover on the ‘Women’ Menu
    WebElement women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
    Actions actionwomen = new Actions(driver);
    actionwomen.moveToElement(women).build().perform();


//* Mouse Hover on the ‘Tops’
    WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
    Actions womentop = new Actions(driver);
    womentop.moveToElement(tops).build().perform();


//            * Click on the ‘Jackets’

    clickOnElement(By.xpath("//a[@id='ui-id-11']"));


//            * Select Sort By filter “Product Name”
    WebElement productname = driver.findElement(By.id("sorter"));
    Select product = new Select(productname);
    product.selectByVisibleText("Product Name");

//            * Verify the product name displayed in alphabatical order
    Assert.assertEquals("not by product name", "Product Name",
            getText(By.xpath("//body/div[2]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]")));
}

   @Test
public void verifyTheSortByPriceFilter(){
//* Mouse Hover on the ‘Women’ Menu
       clickOnElement(By.xpath("//body/div[3]/div[2]/div[2]/div[2]/div[2]/button[1]"));
       WebElement women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
       Actions actionwomen = new Actions(driver);
       actionwomen.moveToElement(women).build().perform();



//* Mouse Hover on the ‘Tops’
       WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
       Actions womentop = new Actions(driver);
       womentop.moveToElement(tops).build().perform();


//            * Click on the ‘Jackets’
       clickOnElement(By.xpath("//a[@id='ui-id-11']"));

//            * Select Sort By filter “Price”
       WebElement price = driver.findElement(By.id("sorter"));
       Select productprice = new Select(price);
       productprice.selectByVisibleText("Price");


//            * Verify the product price displayed in Low to High
       Assert.assertEquals("not sorted by price", "Price",
               getText(By.xpath("//body/div[2]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]")));
}
    public void tearDown(){
        driver.quit();
    }

}