package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import testCases.Constants;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LoginPage {

    public WebDriver driverLP;

//data members:
    By iconLocator=By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[3]/div[2]/div/a/span");
    By accountNameLocator=By.xpath("/html/body/div[1]/section/header/div[1]/nav/div[3]/div[2]/div/a/span");
    By emailAdressLocator=By.cssSelector("input[name=EmailOrAccountNumber]");
    By passwordLocator=By.xpath("//*[@id=\"Password\"]");
    By loginBtnLocator=By.name("SignInNow");
    By errorMessageLocator=By.xpath("//*[@id=\"pri\"]/div/div/div/div/div");

    //constractors:
    public LoginPage(WebDriver driver){

        this.driverLP=driver;
    }

    //methods:

    //A function that clicks on an account login button:
    public void iconeLoginClick(){
        driverLP.findElement(iconLocator).click();};

    //A function that returns the name of the user account:
    public String returningTheAccountName(){
        String name=driverLP.findElement(accountNameLocator).getText();
    return name;};

    //A function that types the emailAdress:
    public void enterEmailAdress(String emailAdress){
        driverLP.findElement(emailAdressLocator).sendKeys(emailAdress);
    }

    //A function that types the password:
    public void enterPassword(String password){
        driverLP.findElement(passwordLocator).sendKeys(password);
    }

    //A function that clicks on the login button:
    public void loginClick(){
        driverLP.findElement(loginBtnLocator).click();
    }


    //A function that returns whether the error message appeared:
    public boolean errorMessage(){
        boolean message=false;
        WebElement messageElement=driverLP.findElement(errorMessageLocator);
        if (messageElement.isDisplayed()){
        message=true;
        }else{
            message=false;}
    return message;
    }


    //A function that navigates back to the home page:
    public void navigateToHomePage() throws ParserConfigurationException, IOException, SAXException {
        driverLP.navigate().to(getDataItem("URL",0));
    }

    //A function for tests that require a connection to the website:
    public void testLoginToSiteForAllTests() throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        LoginPage login=new LoginPage(driverLP);
        Constants.wait1();
        login.iconeLoginClick();
        Constants.wait3();
        login.enterEmailAdress(getDataItem("EMAILADRESS",0));
        Constants.wait1();
        login.enterPassword(getDataItem("PASSWORD",0));
        Constants.wait1();
        login.loginClick();
        Constants.wait1();
        login.navigateToHomePage();
        Constants.wait1();
    }
  //Login to the site to pay:
    public void testLoginToSiteForPayTests() throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        LoginPage login=new LoginPage(driverLP);
        login.enterEmailAdress(getDataItem("EMAILADRESS",0));
        Constants.wait1();
        login.enterPassword(getDataItem("PASSWORD",0));
        Constants.wait1();
        login.loginClick();
        Constants.wait3();

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