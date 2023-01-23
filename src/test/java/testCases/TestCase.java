package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import pages.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static testCases.Constants.wait1;
import static testCases.Constants.wait3;

public class TestCase {
    private static WebDriver driverCh;
    // private static WebDriver driverfx;
    private static ExtentReports extentReports = new ExtentReports();
    static ExtentSparkReporter sparkReporter = new ExtentSparkReporter(Constants.URL_REPORTS);
    LoginPage login = new LoginPage(driverCh);
    HomePage home = new HomePage(driverCh);
    SearchPage search = new SearchPage(driverCh);
    ProductPage product = new ProductPage(driverCh);
    PaymentPage pay = new PaymentPage(driverCh);


    @BeforeClass
    public static void beforeclass() throws ParserConfigurationException, IOException, SAXException {
        System.setProperty("webdriver.chrome.driver", Constants.URL_CHROME_DRIVER);
        ChromeOptions options = new ChromeOptions();
        System.out.println("before class");
        driverCh = new ChromeDriver(options);
        driverCh.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driverCh.manage().window().maximize();
        driverCh.get(getDataItem("URL", 0));
        extentReports.attachReporter(sparkReporter);
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    //Checking the correctness of the home page title:
    @Test
    public void testVerifyHomePageTitle() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        ExtentTest verifyHomePageTitle = extentReports.createTest(Constants.HOME_PAGE_TITLE_TEST_NAME);
        String actualTitle = driverCh.getTitle();
        String exeptedTitle = Constants.HOME_PAGE_TITLE;
        if (actualTitle.equalsIgnoreCase(exeptedTitle))
            verifyHomePageTitle.pass(Constants.MESSAGE_TITLE_EQUALS + Constants.HOME_PAGE_TITLE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            verifyHomePageTitle.fail(Constants.MESSAGE_TITLE_NOT_EQUALS + driverCh.getTitle(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Checking the transition to the login page:
    @Test
    public void goToTheLoginPage() throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        ExtentTest goToTheLoginPage = extentReports.createTest(Constants.GO_TO_THE_LOGIN_PAGE_TEST_NAME);
        wait1();
        login.iconeLoginClick();
        wait3();
        String actualUrl = driverCh.getCurrentUrl();
        String exeptedUrl = getDataItem("LOGINURL",0);
        if (actualUrl.equalsIgnoreCase(exeptedUrl))
            goToTheLoginPage.pass(Constants.MESSAGE_BEYOND_THE_LOGIN_PAGE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            goToTheLoginPage.fail(Constants.ERROR_MESSAGE_BEYOND_THE_LOGIN_PAGE,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Checking the correctness of the login page title:
    @Test
    public void testVerifyLoginPageTitle() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        driverCh.navigate().to(getDataItem("LOGINURL", 0));
        ExtentTest verifyLoginPageTitle = extentReports.createTest(Constants.LOGIN_TITLE_TEST_NAME);
        String actualTitle = driverCh.getTitle();
        String exeptedTitle = Constants.LOGIN_PAGE_TITLE;
        if (actualTitle.equalsIgnoreCase(exeptedTitle))
            verifyLoginPageTitle.pass(Constants.MESSAGE_TITLE_EQUALS + Constants.LOGIN_PAGE_TITLE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            verifyLoginPageTitle.fail(Constants.MESSAGE_TITLE_NOT_EQUALS + driverCh.getTitle(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //A positive identity verification check:
    @Test
    public void testLoginToSite() throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        ExtentTest testLoginToSite = extentReports.createTest(Constants.LOGIN_TO_SITE_TEST_NAME);
        wait1();
        login.iconeLoginClick();
        wait3();
        login.enterEmailAdress(getDataItem("EMAILADRESS", 0));
        wait1();
        login.enterPassword(getDataItem("PASSWORD", 0));
        wait1();
        login.loginClick();
        Constants.wait5();
        String exeptedAccount=Constants.NAME_OF_ACCOUNT_TEXT;
        String actualAccount=login.returningTheAccountName();
        if (exeptedAccount.equalsIgnoreCase(actualAccount))
            testLoginToSite.pass(Constants.MESSAGE_ACCOUNT_LOGIN + exeptedAccount);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            testLoginToSite.fail(Constants.ERROR_MESSAGE_ACCOUNT_LOGIN, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
        login.navigateToHomePage();
        //Checking the transition to the home page:
        ExtentTest navigateToHomePage = extentReports.createTest(Constants.NEVIGATE_TO_HOME_PAGE_TEST_NAME);
        String actualHomeTitle = driverCh.getTitle();
        String exeptedHomeTitle = Constants.HOME_PAGE_TITLE;
        if (actualHomeTitle.equalsIgnoreCase(exeptedHomeTitle))
            navigateToHomePage.pass(Constants.MESSAGE_NEVIGATE_TO_HOME_PAGE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            navigateToHomePage.fail(Constants.ERROR_MESSAGE_NEVIGATE_TO_HOME_PAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Negative identity verification check(Incorrect Account & Incorrect password):
    @Test
    public void testNegativeLoginToSite01() throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        ExtentTest testNegativeLoginToSite01 = extentReports.createTest(Constants.NEGATIVE_IDENTITY_VERIFICATION_TEST_NAME);
        wait1();
        login.iconeLoginClick();
        wait3();
        login.enterEmailAdress(getDataItem("EMAILADRESS", 1));
        wait1();
        login.enterPassword(getDataItem("PASSWORD", 1));
        wait1();
        login.loginClick();
        Constants.wait5();
        boolean exeptedMessage=login.errorMessage();
        if (exeptedMessage)
            testNegativeLoginToSite01.pass(Constants.ACCOUNT_LOGIN_MESSAGE );
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            testNegativeLoginToSite01.fail(Constants.ACCOUNT_LOGIN_ERROR_MESSAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Negative identity verification check(Correct email & Incorrect password):
    @Test
    public void testNegativeLoginToSite02() throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        ExtentTest testNegativeLoginToSite02 = extentReports.createTest(Constants.NEGATIVE_IDENTITY_VERIFICATION_TEST_NAME);
        wait1();
        login.iconeLoginClick();
        wait3();
        login.enterEmailAdress(getDataItem("EMAILADRESS", 0));
        wait1();
        login.enterPassword(getDataItem("PASSWORD", 1));
        wait1();
        login.loginClick();
        Constants.wait5();
        boolean exeptedMessage=login.errorMessage();
        if (exeptedMessage)
            testNegativeLoginToSite02.pass(Constants.ACCOUNT_LOGIN_MESSAGE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            testNegativeLoginToSite02.fail(Constants.ACCOUNT_LOGIN_ERROR_MESSAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Negative identity verification check(Incorrect email & correct password):
    @Test
    public void testNegativeLoginToSite03() throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        ExtentTest testNegativeLoginToSite03 = extentReports.createTest(Constants.NEGATIVE_IDENTITY_VERIFICATION_TEST_NAME);
        wait1();
        login.iconeLoginClick();
        wait3();
        login.enterEmailAdress(getDataItem("EMAILADRESS", 1));
        wait1();
        login.enterPassword(getDataItem("PASSWORD", 0));
        wait1();
        login.loginClick();
        Constants.wait5();
        boolean exeptedMessage=login.errorMessage();
        if (exeptedMessage)
            testNegativeLoginToSite03.pass(Constants.ACCOUNT_LOGIN_MESSAGE );
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            testNegativeLoginToSite03.fail(Constants.ACCOUNT_LOGIN_ERROR_MESSAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }
    //Negative identity verification check(empty fields):
    @Test
    public void testNegativeLoginToSite04() throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        ExtentTest testNegativeLoginToSite04 = extentReports.createTest(Constants.NEGATIVE_IDENTITY_VERIFICATION_TEST_NAME);
        wait1();
        login.iconeLoginClick();
        wait3();
        login.loginClick();
        Constants.wait5();
        boolean exeptedMessage=login.errorMessage();
        if (exeptedMessage)
            testNegativeLoginToSite04.pass(Constants.ACCOUNT_LOGIN_MESSAGE );
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            testNegativeLoginToSite04.fail(Constants.ACCOUNT_LOGIN_ERROR_MESSAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }
    
    //Checking the categories in the center of the homePage and returning to the home page:
    @Test
    public void checkingCategoriesCenter() throws ParserConfigurationException, IOException, InterruptedException, SAXException {
        ExtentTest verificationBeyondTheBoysPage = extentReports.createTest(Constants.VERIFICATION_BEYOND_THE_BOYS_CATEGORY_TEST_NAME);
        home.clickCategoryCenterBoys();
        Constants.wait5();
        String actualText = home.returningTextFromTheBoysPage();
        String exeptedText = Constants.BOYS_CATEGORY_TEXT;
        wait3();
        if (actualText.equalsIgnoreCase(exeptedText)) {
            String currentTime = String.valueOf(System.currentTimeMillis());
            verificationBeyondTheBoysPage.pass(Constants.MESSAGE_VERIFICATION_BEYOND_THE_BOYS_CATEGORY, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            verificationBeyondTheBoysPage.fail(Constants.ERROR_MESSAGE_VERIFICATION_BEYOND_THE_BOYS_CATEGORY, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
        home.navigateToHomePage();
        wait3();
        //Checking the transition to the home page:
        ExtentTest navigateToHomePage = extentReports.createTest(Constants.NEVIGATE_TO_HOME_PAGE_TEST_NAME);
        String actualUrl = driverCh.getCurrentUrl();
        String exeptedUrl = getDataItem("URL",0);
        if (actualUrl.equalsIgnoreCase(exeptedUrl))
            navigateToHomePage.pass(Constants.MESSAGE_NEVIGATE_TO_HOME_PAGE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            navigateToHomePage.fail(Constants.ERROR_MESSAGE_NEVIGATE_TO_HOME_PAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Checking the correctness of the boys category title:
    @Test
    public void testVerifyBoysePageTitle() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        ExtentTest verifyBoysPageTitle = extentReports.createTest(Constants.BOYS_CATEGORY_TITLE_TEST_NAME);
        home.clickCategoryCenterBoys();
        Constants.wait1();
        String actualTitle = driverCh.getTitle();
        String exeptedTitle = Constants.BOYS_CATEGORY_TITLE;
        wait3();
        if (actualTitle.equalsIgnoreCase(exeptedTitle))
            verifyBoysPageTitle.pass(Constants.MESSAGE_TITLE_EQUALS + Constants.BOYS_CATEGORY_TITLE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            verifyBoysPageTitle.fail(Constants.MESSAGE_TITLE_NOT_EQUALS + driverCh.getTitle(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Check the link on the left side of the home page and returning to the home page:
    @Test
    public void checkCategoriesOnTheLeft() throws ParserConfigurationException, IOException, InterruptedException, SAXException {
        ExtentTest leftCategoryPassVerification = extentReports.createTest(Constants.VERIFICATION_BEYOND_THE_LEFT_CATEGORY_TEST_NAME);
        home.clickCategoryCenterBoys();
        wait1();
        home.clickCategoriesOnTheLeftCoats();
        wait3();
        String actualText = home.returningTextFromTheLeftCategory();
        String exeptedText = Constants.LEFT_CATEGORY_TEXT;
        wait3();
        if (actualText.equalsIgnoreCase(exeptedText)) {
            String currentTime = String.valueOf(System.currentTimeMillis());
            leftCategoryPassVerification.pass(Constants.MESSAGE_VERIFICATION_BEYOND_THE_LEFT_CATEGORY, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            leftCategoryPassVerification.fail(Constants.ERROR_MESSAGE_VERIFICATION_BEYOND_THE_LEFT_CATEGORY, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
        home.navigateToHomePage();
        wait3();
        //Checking the transition to the home page:
        ExtentTest navigateToHomePage = extentReports.createTest(Constants.NEVIGATE_TO_HOME_PAGE_TEST_NAME);
        String actualUrl = driverCh.getCurrentUrl();
        String exeptedUrl = getDataItem("URL",0);
        if (actualUrl.equalsIgnoreCase(exeptedUrl))
            navigateToHomePage.pass(Constants.MESSAGE_NEVIGATE_TO_HOME_PAGE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            navigateToHomePage.fail(Constants.ERROR_MESSAGE_NEVIGATE_TO_HOME_PAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Check the category title on the left:
    @Test
    public void checkOutTheCategoryTitleOnTheLeft() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        ExtentTest categoryTitleOnTheLeft = extentReports.createTest(Constants.VERIFY_THE_CATEGORY_TITLE_ON_THE_LEFT_TEST_NAME);
        home.clickCategoryCenterBoys();
        Constants.wait1();
        home.clickCategoriesOnTheLeftCoats();
        wait3();
        String actualTitle = driverCh.getTitle();
        String exeptedTitle = Constants.LEFT_CATEGORY_TITLE;
        wait3();
        if (actualTitle.equalsIgnoreCase(exeptedTitle))
            categoryTitleOnTheLeft.pass(Constants.MESSAGE_TITLE_EQUALS + Constants.LEFT_CATEGORY_TITLE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            categoryTitleOnTheLeft.fail(Constants.MESSAGE_TITLE_NOT_EQUALS + driverCh.getTitle(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    // Clicking on a link from the banner:
    @Test
    public void ClickinglinkFromBanner() throws InterruptedException, ParserConfigurationException, IOException, SAXException {
        ExtentTest leftCategoryPassVerification = extentReports.createTest(Constants.VERIFICATION_BEYOND_THE_TABLEWARE_PAGE_TEST_NAME);
        Constants.wait5();
        home.clickLinkInTheBannerHomeDesign();
        //home.doubleClickLowerHeaderLinkTablrWare();
        wait3();
        String actualText = home.returningTextFromTheTablewarePage();
        String exeptedText = Constants.TABLEWARE_TEXT;
        wait3();
        if (actualText.equalsIgnoreCase(exeptedText)) {
            String currentTime = String.valueOf(System.currentTimeMillis());
            leftCategoryPassVerification.pass(Constants.MESSAGE_VERIFICATION_BEYOND_THE_TABLEWARE_PAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            leftCategoryPassVerification.fail(Constants.ERROR_MESSAGE_VERIFICATION_BEYOND_THE_TABLEWARE_PAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
        home.navigateToHomePage();
        wait1();
        //Checking the transition to the home page:
        ExtentTest navigateToHomePage = extentReports.createTest(Constants.NEVIGATE_TO_HOME_PAGE_TEST_NAME);
        String actualUrl = driverCh.getCurrentUrl();
        String exeptedUrl = getDataItem("URL",0);
        if (actualUrl.equalsIgnoreCase(exeptedUrl))
            navigateToHomePage.pass(Constants.MESSAGE_NEVIGATE_TO_HOME_PAGE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            navigateToHomePage.fail(Constants.ERROR_MESSAGE_NEVIGATE_TO_HOME_PAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Check the category title on the tableware page:
    @Test
    public void tablewarePageTitleValidation() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        ExtentTest tablewarePageTitleValidation = extentReports.createTest(Constants.TABLEWARE_PAGE_TITLE_VALIDATION_TEST_NAME);
        Constants.wait1();
        home.clickLinkInTheBannerHomeDesign();
        wait3();
        String actualTitle = driverCh.getTitle();
        String exeptedTitle = Constants.TABLE_WARE_TITLE;
        wait3();
        if (actualTitle.equalsIgnoreCase(exeptedTitle))
            tablewarePageTitleValidation.pass(Constants.MESSAGE_TITLE_EQUALS + Constants.TABLE_WARE_TITLE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            tablewarePageTitleValidation.fail(Constants.MESSAGE_TITLE_NOT_EQUALS + driverCh.getTitle(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Checking the correctness of changing the language to Hebrew:
    @Test
    public void languageChangeToHebrew() throws ParserConfigurationException, IOException, InterruptedException, SAXException {
        ExtentTest languageChangeToHebrew = extentReports.createTest(Constants.LANGUAGE_CHANGE_TO_HEBREW_TEST_NAME);
        Constants.wait1();
        home.changeTheLanguage();
        Constants.wait5();
        String exeptedUrl = getDataItem("URLHEBREW", 0);
        String actualUrl = driverCh.getCurrentUrl();
        if (actualUrl.equalsIgnoreCase(exeptedUrl)) {
            String currentTime = String.valueOf(System.currentTimeMillis());
            languageChangeToHebrew.pass(Constants.MESSAGE_LANGUAGE_CHANGE_TO_HEBREW, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            languageChangeToHebrew.fail(Constants.ERROR_MESSAGE_LANGUAGE_CHANGE_TO_HEBREW + actualUrl, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Product search integrity check:
    @Test
    public void productSearchIntegrityCheck() throws ParserConfigurationException, IOException, InterruptedException, SAXException {
        ExtentTest productsearchresult = extentReports.createTest(Constants.PRODUCT_SEARCH_RESULT_TEST_NAME);
        driverCh.navigate().to(getDataItem("URL", 1));
        wait3();
        home.productSearch();
        wait3();
        String actualText = home.returningTextFromTheProductSearchPage();
        String exeptedText = Constants.PRODUCT_SEARCH_TEXT;
        if (actualText.equalsIgnoreCase(exeptedText)) {
            String currentTime = String.valueOf(System.currentTimeMillis());
            productsearchresult.pass(Constants.MESSAGE_PRODUCT_SEARCH_RESULT, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            productsearchresult.fail(Constants.ERROR_MESSAGE_PRODUCT_SEARCH_RESULT, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Checking the title of the search page:
    @Test
    public void productSearchPageTitleValidation() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        driverCh.navigate().to(getDataItem("URL", 1));
        ExtentTest productSearchPageTitleValidation = extentReports.createTest(Constants.TITLE_OF_PRODUCT_SEARCH_RESULT_TEST_NAME);
        wait3();
        home.productSearch();
        wait3();
        String actualTitle = driverCh.getTitle();
        String exeptedTitle = Constants.PRODUCT_SEARCH_TITLE;
        wait3();
        if (actualTitle.equalsIgnoreCase(exeptedTitle))
            productSearchPageTitleValidation.pass(Constants.MESSAGE_TITLE_EQUALS + Constants.PRODUCT_SEARCH_TITLE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            productSearchPageTitleValidation.fail(Constants.MESSAGE_TITLE_NOT_EQUALS + driverCh.getTitle(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }


    //The correctness of the first product selection:
    @Test
    public void selectsProductFirst() throws ParserConfigurationException, IOException, InterruptedException, SAXException {
        ExtentTest selectsProductFirst = extentReports.createTest(Constants.SELECTED_PRODUCT_PAGE_TITLE_TEST_NAME);
        driverCh.get(getDataItem("URL", 1));
        home.productSearch();
        search.selectsProductFirst();
        Constants.wait5();
        String exeptedUrl = getDataItem("URLSELECTEDPRODUCT", 0);
        String actualUrl = driverCh.getCurrentUrl();
        if (actualUrl.equalsIgnoreCase(exeptedUrl)) {
            String currentTime = String.valueOf(System.currentTimeMillis());
            selectsProductFirst.pass(Constants.MESSAGE_SELECTS_PRODUCT_FIRST, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            selectsProductFirst.fail(Constants.ERROR_MESSAGE_SELECTSP_RODUCT_FIRST + actualUrl, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }


    //Checking the title of the first product page in the selected list:
    @Test
    public void titleValidationOfTheSelectedProductPage() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        driverCh.navigate().to(getDataItem("URL", 1));
        ExtentTest titleOfTheFirstProductPageSelected = extentReports.createTest(Constants.TITLE_OF_THE_FIRST_PRODUCT_PAGE_SELECTED_TES_TNAME);
        wait3();
        home.productSearch();
        wait3();
        search.selectsProductFirst();
        wait3();
        String actualTitle = driverCh.getTitle();
        String exeptedTitle = Constants.TITLE_OF_THE_SELECTED_PRODUCT_PAGE;
        wait3();
        if (actualTitle.equalsIgnoreCase(exeptedTitle))
            titleOfTheFirstProductPageSelected.pass(Constants.MESSAGE_TITLE_EQUALS + Constants.TITLE_OF_THE_SELECTED_PRODUCT_PAGE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            titleOfTheFirstProductPageSelected.fail(Constants.MESSAGE_TITLE_NOT_EQUALS + driverCh.getTitle(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Checking the correct color selection for the product:
    @Test
    public void productColorSelection() throws InterruptedException, ParserConfigurationException, IOException, SAXException {
        ExtentTest productColorSelection = extentReports.createTest(Constants.PRODUCT_COLOR_TEST_NAME);
        driverCh.get(getDataItem("URL", 2));
        Constants.wait5();
        product.productColorSelection();
        Boolean displayColor=product.verifyProductColorSelection();
        wait1();
        if (displayColor==true) {
            productColorSelection.pass(Constants.MESSAGE_BLACK_IS_SELECTED);
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            productColorSelection.fail(Constants.MESSAGE_BLACK_IS_NOT_SELECTED, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
        wait3();
    }

    //Checking correct size selection for the product:
    @Test
    public void productSizeSelection() throws InterruptedException, ParserConfigurationException, IOException, SAXException {
        ExtentTest productSizeSelection = extentReports.createTest(Constants.PRODUCT_SIZE_SELECTION_TEST_NAME);
        driverCh.get(getDataItem("URL", 2));
        Constants.wait5();
        product.productColorSelection();
        product.productSizeSelection();
        wait1();
        Boolean displaySize=product.verifyProductSizeSelection();
        wait1();
        if (displaySize==true) {
            productSizeSelection.pass(Constants.MESSAGE_CORRECT_SIZE_IS_SELECTED);
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            productSizeSelection.fail(Constants.MESSAGE_CORRECT_SIZE_IS_NOT_SELECTED,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());

        }
        Constants.wait5();
    }


    //Adding a product to the cart and displaying the shopping cart:
    @Test
    public void addingProductToTheCart() throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        ExtentTest goToTheShoppingCartPage = extentReports.createTest(Constants.GO_TO_THE_SHOPING_CART_PAGE_TEST_NAME);
        ExtentTest quantityOfProducts = extentReports.createTest(Constants.QUANTITY_OF_PRODUCT_TEST_NAME);
        ExtentTest detailsOfTheProduct = extentReports.createTest(Constants.DETAILS_OF_PRODUCT_TEST_NAME);
        //Size and color selection:
        driverCh.get(getDataItem("URL", 2));
        Constants.wait5();
        product.productColorSelection();
        wait1();
        product.productSizeSelection();
        wait1();
        //Adding to the cart:
        product.addingProductToTheCart();
        wait3();
        product.addingProductToTheCart();
        //Displaying the shopping cart:
        product.shoppingCart();
        Constants.wait5();
        String exeptedtUrl=getDataItem("SHOPINGCARTURL",0);
        String actualUrl=driverCh.getCurrentUrl();
        if (exeptedtUrl.equalsIgnoreCase(actualUrl)) {
            goToTheShoppingCartPage.pass(Constants.MESSAGE_BEYOND_THE_SHOPING_CART);
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
           goToTheShoppingCartPage.fail(Constants.ERROR_MESSAGE_BEYOND_THE_SHOPING_CART, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
        String sum = product.quantityOfProducts();
        if (sum.equalsIgnoreCase("2")) {
            quantityOfProducts.pass(Constants.MESSAGE_QUANTITY_OF_PRODUCTS);
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            quantityOfProducts.fail(Constants.ERROR_MESSAGE_QUANTITY_OF_PRODUCTS + product.quantityOfProducts(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
        String details = product.detailsOfTheProductInTheCart();
        if (details.equalsIgnoreCase(Constants.DETAILS_OF_PRODUCTS)) {
            detailsOfTheProduct.pass(Constants.MESSAGE_DETAILS_OF_PRODUCTS);
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            detailsOfTheProduct.fail(Constants.ERROR_MESSAGE_DETAILS_OF_PRODUCTS + (product.detailsOfTheProductInTheCart()), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }
    //Checking the title of the shopping cart page:
    @Test
    public void shoppingCartPageTitleValidation() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        driverCh.navigate().to(getDataItem("URL", 1));
        ExtentTest shoppingCartPageTitleValidation = extentReports.createTest(Constants.SHOPING_CART_PAGE_TITLE_TEST_NAME);
        driverCh.get(getDataItem("URL", 2));
        Constants.wait5();
        product.productColorSelection();
        wait1();
        product.productSizeSelection();
        wait1();
        product.addingProductToTheCart();
        wait3();
        product.addingProductToTheCart();
        Constants.wait1();
        product.shoppingCart();
        Constants.wait1();
        String actualTitle = driverCh.getTitle();
        String exeptedTitle = Constants.SHOPING_CART_TITLE;
        if (actualTitle.equalsIgnoreCase(exeptedTitle))
            shoppingCartPageTitleValidation.pass(Constants.MESSAGE_TITLE_EQUALS + Constants.SHOPING_CART_TITLE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            shoppingCartPageTitleValidation.fail(Constants.MESSAGE_TITLE_NOT_EQUALS + driverCh.getTitle(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Checking the transition to the checkout
    @Test
    public void test1() throws InterruptedException, ParserConfigurationException, IOException, SAXException {
        ExtentTest beyondTheCheckout = extentReports.createTest(Constants.BEYOND_THE_CHECKOUT_TEST_NAME);
        driverCh.get(getDataItem("URL", 2));
        Constants.wait5();
        product.productColorSelection();
        wait1();
        product.productSizeSelection();
        wait1();
        //Adding to the cart:
        product.addingProductToTheCart();
        wait3();
        product.addingProductToTheCart();
        //Displaying the shopping cart:
        product.shoppingCart();
        //Beyond payment at the cash register:
        product.toTheCashRegisterBtn();
        Constants.wait1();
        //Account login:
        login.testLoginToSiteForPayTests();
        if (driverCh.getCurrentUrl().equalsIgnoreCase(getDataItem("PAYMENTURL", 0))) {
            String currentTime = String.valueOf(System.currentTimeMillis());
            beyondTheCheckout.pass(Constants.MESSAGE_BEYOND_THE_CHECKOUT, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            beyondTheCheckout.fail(Constants.ERROR_MESSAGE_BEYOND_THE_CHECKOUT, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Checking the title of the checkout page:
    @Test
    public void checkoutPageTitleVerification() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        driverCh.navigate().to(getDataItem("URL", 1));
        ExtentTest shoppingCartPageTitleValidation = extentReports.createTest(Constants.CHECKOUT_PAGE_TITLE_TEST_NAME);
        driverCh.get(getDataItem("URL", 2));
        Constants.wait5();
        product.productColorSelection();
        wait1();
        product.productSizeSelection();
        wait1();
        //Adding to the cart:
        product.addingProductToTheCart();
        wait3();
        product.addingProductToTheCart();
        //Displaying the shopping cart:
        product.shoppingCart();
        //Beyond payment at the cash register:
        product.toTheCashRegisterBtn();
        Constants.wait1();
        //Account login:
        login.testLoginToSiteForPayTests();
        String actualTitle = driverCh.getTitle();
        String exeptedTitle = Constants.CHECKOUT_TITLE;
        if (actualTitle.equalsIgnoreCase(exeptedTitle))
            shoppingCartPageTitleValidation.pass(Constants.MESSAGE_TITLE_EQUALS + Constants.CHECKOUT_TITLE);
        else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            shoppingCartPageTitleValidation.fail(Constants.MESSAGE_TITLE_NOT_EQUALS + driverCh.getTitle(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }


    @Test
    //Choosing to pay by credit card:
    public void creditRadioPayBtn2() throws IOException, ParserConfigurationException, SAXException, InterruptedException {
        ExtentTest creditRadioPayBtn = extentReports.createTest(Constants.CREDIT_RADIO_PAY_BTN_TEST_NAME);
        driverCh.get(getDataItem("URL", 2));
        Constants.wait5();
        product.productColorSelection();
        wait1();
        product.productSizeSelection();
        wait1();
        //Adding to the cart:
        product.addingProductToTheCart();
        wait3();
        product.addingProductToTheCart();
        //Displaying the shopping cart:
        product.shoppingCart();
        //Beyond payment at the cash register:
        product.toTheCashRegisterBtn();
        wait1();
        //Account login::
        login.testLoginToSiteForPayTests();
        Constants.wait5();
        pay.creditRadioPayBtn();
        Constants.wait3();
        WebElement choosenpay=pay.creditRadioPayBtn();
        if (choosenpay.isSelected()){
            creditRadioPayBtn.pass(Constants.MESSAGE_CREDIT_RADIO_PAY_BTN);
        }else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            creditRadioPayBtn.fail(Constants.ERROR_MESSAGE_CREDIT_RADIO_PAY_BTN, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
        Constants.wait1();
    }


    //Entering an incorrect credit card number:
    @Test
    public void enterCreditCardNumber() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        driverCh.get(getDataItem("URL", 2));
        Constants.wait5();
        product.productColorSelection();
        wait1();
        product.productSizeSelection();
        wait1();
        //Adding to the cart:
        product.addingProductToTheCart();
        wait3();
        product.addingProductToTheCart();
        //Displaying the shopping cart:
        product.shoppingCart();
        //Beyond payment at the cash register:
        product.toTheCashRegisterBtn();
        wait1();
        ////Account login::
        login.testLoginToSiteForPayTests();
        Constants.wait5();
        pay.creditRadioPayBtn();
        Constants.wait5();
        pay.enterCreditCardNumber(Constants.CREDIT_CARD_NUMBER);
        Constants.wait1();
        pay.exitFromCreditDataField();
        Constants.wait1();
        // Checking the card number error message that appears:
        ExtentTest cardErrorMessage = extentReports.createTest(Constants.CARD_NUMBER_ERROR_MESSAGE_TEST_NAME);
        boolean message = pay.cardErrorMessage();
        if (message==true) {
            cardErrorMessage.pass(Constants.CARD_MESSAGE_ERROR);
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            cardErrorMessage.fail(Constants.CARD_MESSAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Entering credit card validity (month):
    @Test
    public void enterCreditCardValidityMonth() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        driverCh.get(getDataItem("URL", 2));
        Constants.wait5();
        product.productColorSelection();
        wait1();
        product.productSizeSelection();
        wait1();
        //Adding to the cart:
        product.addingProductToTheCart();
        wait3();
        product.addingProductToTheCart();
        //Displaying the shopping cart:
        product.shoppingCart();
        //Beyond payment at the cash register:
        product.toTheCashRegisterBtn();
        wait1();
        ////Account login::
        login.testLoginToSiteForPayTests();
        Constants.wait5();
        pay.creditRadioPayBtn();
        Constants.wait5();
        pay.enterCrediCardMonth(Constants.MONTH_OF_CARD);
        Constants.wait1();
        pay.exitFromCreditDataField();
        Constants.wait1();
        // Checking the card month error message that appears:
        ExtentTest cardMonthErrorMessage = extentReports.createTest(Constants.CARD_MONTH_ERROR_MESSAGE_TEST_NAME);
        boolean message = pay.dateOfCardErrorMessage();
        if (message==true) {
            cardMonthErrorMessage.pass(Constants.CARD_MONTH_ERROR_MESSAGE);
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            cardMonthErrorMessage.fail(Constants.CARD_MONTH_MESSAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

     //Entering credit card validity (year):
    @Test
    public void enterCreditCardValidityYear() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        driverCh.get(getDataItem("URL", 2));
        Constants.wait5();
        product.productColorSelection();
        wait1();
        product.productSizeSelection();
        wait1();
        //Adding to the cart:
        product.addingProductToTheCart();
        wait3();
        product.addingProductToTheCart();
        //Displaying the shopping cart:
        product.shoppingCart();
        //Beyond payment at the cash register:
        product.toTheCashRegisterBtn();
        wait1();
        ////Account login::
        login.testLoginToSiteForPayTests();
        Constants.wait5();
        pay.creditRadioPayBtn();
        Constants.wait5();
        pay.enterCrediCardYear(Constants.YEAR_OF_CARD);
        Constants.wait1();
        pay.exitFromCreditDataField();
        Constants.wait1();
        // Checking the card year error message that appears:
        ExtentTest cardYearErrorMessage = extentReports.createTest(Constants.CARD_YEAR_ERROR_MESSAGE_TEST_NAME);
        boolean message = pay.dateOfCardErrorMessage();
        if (message==true) {
            cardYearErrorMessage.pass(Constants.CARD_YEAR_ERROR_MESSAGE);
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            cardYearErrorMessage.fail(Constants.CARD_YEAR_MESSAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }
    //Entering credit card validity which is not future(year + month):
    @Test
    public void enterFutureDateCreditCardValidity() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        driverCh.get(getDataItem("URL", 2));
        Constants.wait5();
        product.productColorSelection();
        wait1();
        product.productSizeSelection();
        wait1();
        //Adding to the cart:
        product.addingProductToTheCart();
        wait3();
        product.addingProductToTheCart();
        //Displaying the shopping cart:
        product.shoppingCart();
        //Beyond payment at the cash register:
        product.toTheCashRegisterBtn();
        wait1();
        ////Account login::
        login.testLoginToSiteForPayTests();
        Constants.wait5();
        pay.creditRadioPayBtn();
        Constants.wait5();
        pay.enterANonFutureDateCrediCard(Constants.A_NON_FUTURE_YEAR_OF_CARD,Constants.A_NON_FUTURE_MONTH_OF_CARD);
        Constants.wait1();
        pay.exitFromCreditDataField();
        Constants.wait1();
        //Checking the error message that appears:
        ExtentTest aNonFutureDatecardErrorMessage = extentReports.createTest(Constants.A_NON_FUTURE_DATE_TEST_NAME);
        boolean message = pay.aNonFutureDateOfCardErrorMessage();
        if (message==true) {
            aNonFutureDatecardErrorMessage.pass(Constants.A_NON_FUTURE_DATE_CARD_ERROR_MESSAGE);
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            aNonFutureDatecardErrorMessage.fail(Constants.A_NON_FUTURE_DATE_CARD_MESSAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Entering an incorrect security code for a credit card:
    @Test
    public void entersecurityCode() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        driverCh.get(getDataItem("URL", 2));
        Constants.wait5();
        product.productColorSelection();
        wait1();
        product.productSizeSelection();
        wait1();
        //Adding to the cart:
        product.addingProductToTheCart();
        wait3();
        product.addingProductToTheCart();
        //Displaying the shopping cart:
        product.shoppingCart();
        //Beyond payment at the cash register:
        product.toTheCashRegisterBtn();
        wait1();
        ////Account login::
        login.testLoginToSiteForPayTests();
        Constants.wait5();
        pay.creditRadioPayBtn();
        Constants.wait5();
        pay.enterSecurityCode(Constants.SECURITY_CODE);
        Constants.wait1();
        pay.exitFromCreditDataField();
        Constants.wait1();
        //Checking the error message that appears:
        ExtentTest securityCodeErrorMessage = extentReports.createTest(Constants.SECURITY_CODE_ERROR_MESSAGE_TEST_NAME);
        boolean message = pay.securityCodeErrorMessage();
        if (message==true) {
            securityCodeErrorMessage.pass(Constants.SECURITY_CODE_MESSAGE);
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            securityCodeErrorMessage.fail(Constants.SECURITY_CODE_ERROR_MESSAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }

    //Entering the name of the credit card holder:
    @Test
    public void enterCreditCardHolderName() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        driverCh.get(getDataItem("URL", 2));
        Constants.wait5();
        product.productColorSelection();
        wait1();
        product.productSizeSelection();
        wait1();
        //Adding to the cart:
        product.addingProductToTheCart();
        wait3();
        product.addingProductToTheCart();
        Constants.wait1();
        //Displaying the shopping cart:
        product.shoppingCart();
        //Beyond payment at the cash register:
        product.toTheCashRegisterBtn();
        wait1();
        ////Account login::
        login.testLoginToSiteForPayTests();
        Constants.wait5();
        Constants.wait5();
        pay.creditRadioPayBtn();
        Constants.wait5();
        Constants.wait5();
        pay.enterCardHolderName(Constants.CARD_HOLDER_NAME);
        Constants.wait1();
        // Checking the correctness of entering the name:
        ExtentTest creditCardHolderName = extentReports.createTest(Constants.CARD_HOLDER_ERROR_MESSAGE_TEST_NAME);
        boolean name = pay.textOfCardHolderName();
        if (name==true) {
            creditCardHolderName.pass(Constants.CARD_HOLDER_MESSAGE);
        } else {
            String currentTime = String.valueOf(System.currentTimeMillis());
            creditCardHolderName.fail(Constants.CARD_HOLDER_ERROR_MESSAGE, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.URL_PICTRUES + currentTime)).build());
        }
    }


    @AfterClass
    public static void afterclass() throws InterruptedException {
        System.out.println("after class");
        Thread.sleep(1000);
        driverCh.quit();
        extentReports.flush();
    }
    //functions:

    //A function that reading from an xml file:
    private static String getDataItem (String keyName,int index) throws ParserConfigurationException, IOException, SAXException {
        File configXmlFile = new File(Constants.URL_CONFIGXML);
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

    // A function to create a screenshot:
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driverCh;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }
}



















