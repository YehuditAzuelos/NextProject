package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import testCases.Constants;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class HomePage {

    public WebDriver driverHP;

    By categoryCenterBoys= By.xpath("//*[@id=\"baby-circular-swipe2_slide_3\"]/a/div[1]/img");
    By navigateToHomePageLocator=By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[1]/a/div[2]/img");
    By categoriesOnTheLeftCoatsLocator=By.linkText("Coats & Jackets");
    By linkInTheBannerHomeDesignLocator=By.xpath("//*[@id=\"meganav-link-6\"]/div");
    By listedLinkInTheBannerLocator= By.xpath("//*[@id=\"catalogue\"]/div[3]/div/ul/li[4]/a/div/span");
    By tablewareLocator=By.xpath("/html/body/main/div/div/div[2]/div[2]/div[1]/div[1]/div/div[1]/span/div/h1");
    By iconLanguageChangeLocator=By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[8]/div/button/img");
    By languageChangeLocator=By.cssSelector("button[data-ga-v3=\"עברית \"]");
    By buttonLanguageChangeLocator=By.cssSelector("button[data-testid=\"country-selector-CTA-button\"]");
    By searchButtonLocator=By.id("header-big-screen-search-box");
    By searchIconLocator=By.xpath("//*[@id=\"header-search-form\"]/button/span[1]/img");
    By boysPageTextLocator=By.xpath("/html/body/section[1]/section[1]/div/div[1]/div[3]/div/div/div[2]/div[2]/div[1]/div/div[1]/div/div/div/div/div/div/p/strong/span/span");
    By leftCategoryTextLocator=By.xpath("/html/body/main/div/div/div[2]/div[2]/div[1]/div[1]/div/div[1]/span/div/h1");
    By productSearchTextLocator=By.xpath("/html/body/main/div/div/div[2]/div[2]/div[1]/div[1]/div/div[1]/h1/span[1]");

    //constractors:
    public HomePage(WebDriver driver){

        this.driverHP=driver;
    }

    //function:
    //Entry to the category link in the center - boys:
    public void clickCategoryCenterBoys(){
        driverHP.findElement(categoryCenterBoys).click();
    }

    //A function that returns text from the boys page:
    public String returningTextFromTheBoysPage(){
       String text= driverHP.findElement(boysPageTextLocator).getText();
        return text;
    }

    //A function that returns text from the left category:
    public String returningTextFromTheLeftCategory(){
        String text=driverHP.findElement(leftCategoryTextLocator).getText();
        return text;
    }

    //A function that navigates back to the home page:
    public void navigateToHomePage(){
        driverHP.findElement(navigateToHomePageLocator).click();
    }

    //A function that clicks on the link on the left side of the home page:
    public void clickCategoriesOnTheLeftCoats(){
        driverHP.findElement(categoriesOnTheLeftCoatsLocator).click();
    }

    //A function that Click on a link in the banner (home design):
    public void clickLinkInTheBannerHomeDesign(){
        driverHP.findElement(linkInTheBannerHomeDesignLocator).click();
        driverHP.findElement(listedLinkInTheBannerLocator).click();
    }

    //A function that Click double click on a link in the banner (home design):
    //not used
    public void doubleClickLowerHeaderLinkTablrWare(){
        //Actions
        Actions actions = new Actions(driverHP);
        WebElement homeLowerHeaderBabyLinkElement=driverHP.findElement(linkInTheBannerHomeDesignLocator);
        actions.doubleClick(homeLowerHeaderBabyLinkElement).perform();
    }


    //A function that returns text from the tableware page:
    public String returningTextFromTheTablewarePage(){
        String text=driverHP.findElement(tablewareLocator).getText();
        return text;
    }

    //A function to change the language to Hebrew:
    public void changeTheLanguage() throws InterruptedException {
        driverHP.findElement(iconLanguageChangeLocator).click();
        Constants.wait3();
        driverHP.findElement(languageChangeLocator).click();
        Constants.wait3();
        driverHP.findElement(buttonLanguageChangeLocator).click();
    }

    //Product search function:
    public void productSearch() throws InterruptedException, ParserConfigurationException, IOException, SAXException {
        driverHP.findElement(searchButtonLocator).click();
        Constants.wait1();
        driverHP.findElement(searchButtonLocator).sendKeys(getDataItem("SEARCH",0));
        Constants.wait1();
        driverHP.findElement(searchIconLocator).click();
    }
    //A function that returns text from the product's search page:
    public String returningTextFromTheProductSearchPage(){
        String text=driverHP.findElement(productSearchTextLocator).getText();
        return text;
    }


    //A function that reading from an xml file:
    private static String getDataItem (String keyName,int index) throws ParserConfigurationException, IOException, SAXException {
        File configXmlFile = new File("C:\\Automation\\nextProject\\nextProject\\target\\config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        assert dBuilder != null;
        doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(index).getTextContent();
    }

}
