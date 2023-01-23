package testCases;

import org.openqa.selenium.By;

public class Constants {

    //Chrome browser's path:
    public static final String URL_CHROME_DRIVER= "C:\\Automation\\driver\\update2\\chromedriver.exe";

    //FireFox browser's path:
    public static final String URL_FIRE_FOX_DRIVER= "C:\\Automation\\driver\\firefox\\geckodriver.exe";

    // pictures's path:
    public static final String URL_PICTRUES= "target\\spark\\pictures\\";

    //config's path:
    public static final String URL_CONFIGXML= "C:\\Automation\\nextProject\\nextProject\\target\\config.xml";

    //reports's path:
    public static final String URL_REPORTS= "target/Spark/index.html";







    //title of pages:
    public static final String LOGIN_PAGE_TITLE= "Sign In | My Account | Next Directory Online";
    public static final String HOME_PAGE_TITLE= "Next Official Site: Online Fashion, Kids Clothes & Homeware";
    public static final String BOYS_CATEGORY_TITLE= "Buy Boys Clothes | Boyswear and Clothing | Next Official Site";
    public static final String LEFT_CATEGORY_TITLE= "Boys Coats & Jackets | Winter Coats, Baseball Jackets, Gilets | Next Israel";
    public static final String TABLE_WARE_TITLE= "Tableware & Serveware | Dinner sets & Serving Dishes | Next Israel";
    public static final String PRODUCT_SEARCH_TITLE= "Blue/black hoodie from | נקסט ישראל";
    public static final String TITLE_OF_THE_SELECTED_PRODUCT_PAGE= "קנה קפוצ'ון בצבע מדורג (גילאי 3 עד 16) מנקסט ישראל";
    public static final String SHOPING_CART_TITLE= "Next Israel";
    public static final String CHECKOUT_TITLE= "Next Israel";



    //message:
    public static final String MESSAGE_TITLE_EQUALS= "the titles are equals, the title that apear is: ";
    public static final String MESSAGE_TITLE_NOT_EQUALS= "the titles are not equals, the title that apear is: ";
    public static final String ERROR_MESSAGE_BEYOND_THE_LOGIN_PAGE= "Failed to navigate to login page";
    public static final String MESSAGE_BEYOND_THE_LOGIN_PAGE= "You have been successfully redirected to the login page";
    public static final String ERROR_MESSAGE_ACCOUNT_LOGIN= "Login to your account failed";
    public static final String MESSAGE_ACCOUNT_LOGIN= "You have successfully logged into your account,The account name is: ";
    public static final String ACCOUNT_LOGIN_ERROR_MESSAGE= "The error message did not appear";
    public static final String ACCOUNT_LOGIN_MESSAGE= "The error message appeared";
    public static final String MESSAGE_BLACK_IS_SELECTED= "The black red sweater is selected";
    public static final String MESSAGE_BLACK_IS_NOT_SELECTED= "The blue black sweater is selected";
    public static final String MESSAGE_CORRECT_SIZE_IS_SELECTED= "The correct size is selected";
    public static final String MESSAGE_CORRECT_SIZE_IS_NOT_SELECTED= "The correct size was not selected";
    public static final String ERROR_MESSAGE_BEYOND_THE_SHOPING_CART= "The transition to the shopping cart page failed";
    public static final String MESSAGE_BEYOND_THE_SHOPING_CART= "You have been successfully transferred to the shopping cart page";
    public static final String ERROR_MESSAGE_QUANTITY_OF_PRODUCTS= "The products were not successfully added to the cart, The amount of products in the cart is: ";
    public static final String MESSAGE_QUANTITY_OF_PRODUCTS= "The products have been successfully added to the cart";
    public static final String ERROR_MESSAGE_DETAILS_OF_PRODUCTS= "The products were not successfully added to the cart, The item that appears in the cart is: ";
    public static final String MESSAGE_DETAILS_OF_PRODUCTS= "The products have been successfully added to the cart";
    public static final String ERROR_MESSAGE_BEYOND_THE_CHECKOUT= "Transfer to payment page failed";
    public static final String MESSAGE_BEYOND_THE_CHECKOUT= "You have been successfully transferred to the payment page";
    public static final String ERROR_MESSAGE_CREDIT_RADIO_PAY_BTN= "No credit card payment was selected";
    public static final String MESSAGE_CREDIT_RADIO_PAY_BTN= "Payment by credit card is selected";
    public static final String CARD_MESSAGE_ERROR= "The card number is incorrect";
    public static final String CARD_MESSAGE= "The card number is correct";
    public static final String CARD_MONTH_ERROR_MESSAGE= "The month of card is incorrect";
    public static final String CARD_MONTH_MESSAGE= "The month of card is correct";
    public static final String CARD_YEAR_ERROR_MESSAGE= "The year of card is incorrect";
    public static final String CARD_YEAR_MESSAGE= "The year of card is correct";
    public static final String A_NON_FUTURE_DATE_CARD_ERROR_MESSAGE= "The date of card is incorrect";
    public static final String A_NON_FUTURE_DATE_CARD_MESSAGE= "The date of card is correct";
    public static final String SECURITY_CODE_ERROR_MESSAGE= "The securityCode of card is incorrect";
    public static final String SECURITY_CODE_MESSAGE= "The securityCode of card is correct";
    public static final String CARD_HOLDER_MESSAGE= "The name of card holder is correct";
    public static final String CARD_HOLDER_ERROR_MESSAGE= "The name of card holder is incorrect";
    public static final String ERROR_MESSAGE_VERIFICATION_BEYOND_THE_BOYS_CATEGORY= "The transition to the boys' category failed";
    public static final String MESSAGE_VERIFICATION_BEYOND_THE_BOYS_CATEGORY= "You have been successfully transferred to the boys category";
    public static final String ERROR_MESSAGE_VERIFICATION_BEYOND_THE_LEFT_CATEGORY= "The transition to the left category failed";
    public static final String MESSAGE_VERIFICATION_BEYOND_THE_LEFT_CATEGORY= "You have been successfully transferred to the left category";
    public static final String ERROR_MESSAGE_NEVIGATE_TO_HOME_PAGE= "Failed to move to home page";
    public static final String MESSAGE_NEVIGATE_TO_HOME_PAGE= "You have been successfully transferred to the home page";
    public static final String ERROR_MESSAGE_VERIFICATION_BEYOND_THE_TABLEWARE_PAGE= "Failed to switch to tableware page";
    public static final String MESSAGE_VERIFICATION_BEYOND_THE_TABLEWARE_PAGE= "You have been successfully transferred to the tableware page";
    public static final String ERROR_MESSAGE_LANGUAGE_CHANGE_TO_HEBREW= "Changing the language to Hebrew failed, the url that appears is: ";
    public static final String MESSAGE_LANGUAGE_CHANGE_TO_HEBREW= "Changing the language to Hebrew was done successfully";
    public static final String ERROR_MESSAGE_PRODUCT_SEARCH_RESULT= "Product search failed";
    public static final String MESSAGE_PRODUCT_SEARCH_RESULT= "The product search was successfully performed";
    public static final String ERROR_MESSAGE_SELECTSP_RODUCT_FIRST= "The first product selection failed";
    public static final String MESSAGE_SELECTS_PRODUCT_FIRST= "The first product has been successfully selected";


    //tests's names:
    public static final String HOME_PAGE_TITLE_TEST_NAME= "Verify home page title";
    public static final String LOGIN_TITLE_TEST_NAME= "Verify login page title";
    public static final String LOGIN_TO_SITE_TEST_NAME= "Identity verification check";
    public static final String NEGATIVE_IDENTITY_VERIFICATION_TEST_NAME= "Negative identity verification check";
    public static final String GO_TO_THE_LOGIN_PAGE_TEST_NAME= "Checking the transition to the login page";
    public static final String GO_TO_THE_SHOPING_CART_PAGE_TEST_NAME= "Checking the transition to the shopping cart page";
    public static final String SHOPING_CART_PAGE_TITLE_TEST_NAME= "Checking the title of the shopping cart page";
    public static final String QUANTITY_OF_PRODUCT_TEST_NAME= "Quantity of products";
    public static final String DETAILS_OF_PRODUCT_TEST_NAME= "Details of products";
    public static final String PRODUCT_COLOR_TEST_NAME= "Product color selection";
    public static final String PRODUCT_SIZE_SELECTION_TEST_NAME= "Product size selection";
    public static final String BEYOND_THE_CHECKOUT_TEST_NAME= "Beyond the checkout";
    public static final String CHECKOUT_PAGE_TITLE_TEST_NAME= "Checking the title of the checkout page";
    public static final String CREDIT_RADIO_PAY_BTN_TEST_NAME= "Choosing to pay by credit card";
    public static final String CARD_NUMBER_ERROR_MESSAGE_TEST_NAME= "Card error message";
    public static final String CARD_MONTH_ERROR_MESSAGE_TEST_NAME= "Month of card error message";
    public static final String CARD_YEAR_ERROR_MESSAGE_TEST_NAME= "Year of card error message";
    public static final String SECURITY_CODE_ERROR_MESSAGE_TEST_NAME= "Security Code of card error message";
    public static final String CARD_HOLDER_ERROR_MESSAGE_TEST_NAME= "Card holder error message";
    public static final String A_NON_FUTURE_DATE_TEST_NAME= "A non future date error message";
    public static final String BOYS_CATEGORY_TITLE_TEST_NAME= "Verify boys page title";
    public static final String VERIFICATION_BEYOND_THE_BOYS_CATEGORY_TEST_NAME= "Verification beyond the boys page";
    public static final String VERIFY_THE_CATEGORY_TITLE_ON_THE_LEFT_TEST_NAME= "Verify the category title on the left";
    public static final String VERIFICATION_BEYOND_THE_LEFT_CATEGORY_TEST_NAME= "Verification beyond the left category";
    public static final String NEVIGATE_TO_HOME_PAGE_TEST_NAME= "Nevigate to home page";
    public static final String VERIFICATION_BEYOND_THE_TABLEWARE_PAGE_TEST_NAME= "Verification beyond the tableware page";
    public static final String TABLEWARE_PAGE_TITLE_VALIDATION_TEST_NAME= "Tableware page title validation";
    public static final String LANGUAGE_CHANGE_TO_HEBREW_TEST_NAME= "Language change to Hebrew";
    public static final String PRODUCT_SEARCH_RESULT_TEST_NAME= "Validation of product search results";
    public static final String TITLE_OF_PRODUCT_SEARCH_RESULT_TEST_NAME= "Verify the title on the product search page";
    public static final String TITLE_OF_THE_FIRST_PRODUCT_PAGE_SELECTED_TES_TNAME= "Verify the title on the first product page selected\n";
    public static final String SELECTED_PRODUCT_PAGE_TITLE_TEST_NAME= "Checking the title of the first selected product page";



    //Account holder name text:
    public static final String NAME_OF_ACCOUNT_TEXT= "yehudit";

    //Text on the boys page:
    public static final String BOYS_CATEGORY_TEXT= "THE BOYS' SHOP";

    //Text in the left category:
    public static final String LEFT_CATEGORY_TEXT= "Boys Coats & Jackets";

    //Banner text - tableware:
    public static final String TABLEWARE_TEXT= "Tableware";

    //Product search text:
    public static final String PRODUCT_SEARCH_TEXT= "\"Blue/black hoodie\"";


    //Product details in the basket:
    public static final String DETAILS_OF_PRODUCTS= "שחור/אדום - קפוצ'ון בצבע מדורג (גילאי 3 עד 16)";


    //credit card details:
    public static final String CREDIT_CARD_NUMBER= "1876495738574993";
    public static final String MONTH_OF_CARD= "00";
    public static final String A_NON_FUTURE_YEAR_OF_CARD= "22";
    public static final String A_NON_FUTURE_MONTH_OF_CARD= "01";
    public static final String YEAR_OF_CARD= "00";
    public static final String SECURITY_CODE= "00";
    public static final String CARD_HOLDER_NAME= "israel israeli";


    //Wait:
    public static final void wait1() throws InterruptedException {
        Thread.sleep(1000);
    }
    public static final void wait3() throws InterruptedException {
        Thread.sleep(3000);
    }
    public static final void wait4() throws InterruptedException {
        Thread.sleep(4000);
    }
    public static final void wait5() throws InterruptedException {
        Thread.sleep(5000);
    }
}

