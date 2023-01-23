package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    public WebDriver driverSP;


    By firstProductSelection= By.xpath("//*[@id=\"platform_modernisation_product_summary_T14621\"]/div/div[1]/div[1]/div/div/div[1]/a/img");

    //constructore:
    public SearchPage (WebDriver driver) {
        this.driverSP = driver;
    }

    //methods:
    //A function that selects the product first:
    public void selectsProductFirst(){
        driverSP.findElement(firstProductSelection).click();
    }


}
