package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testCases.Constants;

import java.util.List;

public class PaymentPage {
    public WebDriver driverPP;


    //data members:
    By radioPayListLocator= By.id("PaymentId");
    By radioPayBtnLocator= By.cssSelector("input[value=\"5\"]");
    By creditCardNumberLocator=By.xpath("//*[@id=\"cardNumber\"]");
    By crediCardValidityMonthLocator= By.cssSelector("input#expiryMonth");
    By crediCardValidityYearLocator=By.cssSelector("input#expiryYear");
    By securityCodeLocator=By.cssSelector("input#securityCode");
    By cardHolderNameLocator=By.cssSelector("input#cardholderName");
    By payMentBtnLocator=By.xpath("//*[@id=\"submitButton\"]");
    By cardErrorMessageLocator=By.xpath("//*[@id=\"cardNumber-hint\"]");
    By cardMonthErrorMessageLocator=By.xpath("//*[@id=\"expiryDate-hint\"]");
    By aNonFutureDateOfCardErrorMessageLocaror=By.xpath("//*[@id=\"expiryDate-hint\"]");
    By securityCodeErrorMessageLocator=By.xpath("//*[@id=\"securityCode-hint\"]");
    By textOfCardHolderNameLocator= By.xpath("//*[@id=\"cardholderName\"]");
    By exitFromCreditDataFieldLocator= By.cssSelector("section#ContentArea");


    //constractors:
    public PaymentPage(WebDriver driver){

        this.driverPP=driver;
    }

    //methods:

    //Choosing to pay by credit card:
    public WebElement creditRadioPayBtn(){
         driverPP.findElement(radioPayBtnLocator).click();
         return driverPP.findElement(radioPayBtnLocator);
    }


    //Entering credit card number:
    public void enterCreditCardNumber(String cardNum){
        driverPP.findElement(creditCardNumberLocator).click();
        driverPP.findElement(creditCardNumberLocator).sendKeys(cardNum);
    }

    //card number error message:
    public boolean cardErrorMessage(){
        WebElement message=driverPP.findElement(cardErrorMessageLocator);
        boolean errorDisplay;
        if (message.isDisplayed()){
            errorDisplay=true;
        }else {
            errorDisplay=false;
        }
        return  errorDisplay ;
    }


    //Entering card validity (month):
    public void  enterCrediCardMonth(String month){
        driverPP.findElement(crediCardValidityMonthLocator).sendKeys(month);
    }

    //Entering card validity (year):
    public void  enterCrediCardYear(String year){

        driverPP.findElement(crediCardValidityYearLocator).sendKeys(year);
    }
    //Inserting non-future dates into the validity of the card:
    public void  enterANonFutureDateCrediCard(String year,String month) throws InterruptedException {
        driverPP.findElement(crediCardValidityYearLocator).sendKeys(year);
        Constants.wait1();
        driverPP.findElement(crediCardValidityMonthLocator).sendKeys(month);
    }

    //Card validity error message (month+year):
    public boolean dateOfCardErrorMessage(){
        WebElement message=driverPP.findElement(cardMonthErrorMessageLocator);
        boolean errorDisplay;
        if (message.isDisplayed()){
            errorDisplay=true;
        }else {
            errorDisplay=false;
        }
        return  errorDisplay ;
    }
    //Error message of non-future card validity (month+year):
    public boolean aNonFutureDateOfCardErrorMessage(){
        WebElement message=driverPP.findElement(aNonFutureDateOfCardErrorMessageLocaror);
        boolean errorDisplay;
        if (message.isDisplayed()){
            errorDisplay=true;
        }else {
            errorDisplay=false;
        }
        return  errorDisplay ;
    }

    //Entering security code for a credit card:
    public void  enterSecurityCode(String code){

        driverPP.findElement(securityCodeLocator).sendKeys(code);
    }


    //Security code error message:
    public boolean securityCodeErrorMessage(){
        WebElement message=driverPP.findElement(securityCodeErrorMessageLocator);
        boolean errorDisplay;
        if (message.isDisplayed()){
            errorDisplay=true;
        }else {
            errorDisplay=false;
        }
        return  errorDisplay ;
    }

    //Entering the name of the credit card holder:
    public void enterCardHolderName(String name){
        driverPP.findElement(cardHolderNameLocator).clear();
        driverPP.findElement(cardHolderNameLocator).sendKeys(name);
    }
    //Displaying the name of the cardholder:
    public boolean textOfCardHolderName(){
        boolean name;
        String actualName=driverPP.findElement(textOfCardHolderNameLocator).getText();
        String exeptedName=Constants.CARD_HOLDER_NAME;
        if (exeptedName.equalsIgnoreCase(actualName)){
           name=true;
        }
        else {
            name=false;
        }
        return name;
    }

   //Exit from credit data field:
    public void exitFromCreditDataField(){
        driverPP.findElement(exitFromCreditDataFieldLocator).click();
    }


    //Clicking on the payment button:
    public void payment(){
        driverPP.findElement(payMentBtnLocator).click();
    }


}
