package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testCases.Constants;

public class ProductPage {
    public WebDriver driverPP;

    //data members:
    By openingTheListOfColorsLocator=By.xpath("//*[@id=\"dk_container_Colour-971597\"]/a");
    By productColorSelectionLocator=By.xpath("//*[@id=\"dk_container_Colour-971597\"]/div/ul/li[1]/a");
    By productColorSelectionToDisplayLocator=By.xpath("/html/body/section[1]/section[1]/div/div[2]/div[2]/div/section[2]/article/section/div[4]/div[1]/div/a");
    By openingTheListOfSizesLocator=By.xpath("//*[@id=\"dk_container_Size-U40-704\"]/a");
    By productSizeSelectionLocator=By.xpath("//*[@id=\"dk_container_Size-U40-704\"]/div/ul/li[5]/a");
    By productSizeSelectionToDisplayLocator=By.xpath("/html/body/section[1]/section[1]/div/div[2]/div[2]/div/section[2]/article/section/div[4]/div[2]/div/div/a");
    By addToCartBtnLocator=By.cssSelector("a[onclick=\"ProductPage.Styles.AddToBagCTA.AddItem(this); return false;\"]");
    //By shoppingCartIconLocator=By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[7]/div[2]/div/a");
    By shoppingCartLocator=By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[7]/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/a");
    By quantityOfProductsInTheCartLocator=By.xpath("//*[@id=\"dk_container_Qty_1\"]/a");
    By detailsOfTheProductInTheCartLocator=By.xpath("//*[@id=\"1\"]/td[2]/div/h3");

    By cashRegisterBtnLocator=By.linkText("לקופה");




    //constractors:
    public ProductPage(WebDriver driver){

        this.driverPP=driver;
    }

    //mathods:


    //Product color selection function:
    public void productColorSelection() throws InterruptedException {
        driverPP.findElement(openingTheListOfColorsLocator).click();
        Constants.wait1();
        driverPP.findElement(productColorSelectionLocator).click();
        Constants.wait3();
    }
    //Function to verify product color selection:
    public Boolean verifyProductColorSelection() throws InterruptedException {
        WebElement displayColor=driverPP.findElement(productColorSelectionToDisplayLocator);
        boolean display;
        if (displayColor.isDisplayed()){
            display=true;
        }else {
            display=false;
        }
        return display;
    }


    //Function for selecting product sizes:
    public void productSizeSelection() throws InterruptedException {
        driverPP.findElement(openingTheListOfSizesLocator).click();
        Constants.wait1();
        driverPP.findElement(productSizeSelectionLocator).click();
    }
    //Function to verify product size selection:
    public Boolean verifyProductSizeSelection() throws InterruptedException {
        WebElement displaySize=driverPP.findElement(productSizeSelectionToDisplayLocator);
        Constants.wait1();
        boolean display;
        if (displaySize.isDisplayed())
            display=true;
        else {
            display=false;
        }
        return display;
    }

    //Function to add a product to the shopping cart:
    public void addingProductToTheCart(){
        driverPP.findElement(addToCartBtnLocator).click();
    }

    //A function to display the shopping cart:
    public void shoppingCart () throws InterruptedException {
       // driverPP.findElement(shoppingCartIconLocator).click();
       // Constants.wait1();
        driverPP.findElement(shoppingCartLocator).click();
    }

    //A function to check the amount of products added to the shopping cart:
    public String quantityOfProducts(){
        String sum=driverPP.findElement(quantityOfProductsInTheCartLocator).getText();
        return sum  ;
    }

    //A function to display the details of the products in the shopping cart:
    public String detailsOfTheProductInTheCart(){
        String details=driverPP.findElement(detailsOfTheProductInTheCartLocator).getText();
        return details  ;
    }

    //Function beyond the checkout:
    public void toTheCashRegisterBtn(){

        driverPP.findElement(cashRegisterBtnLocator).click();
    }




}
