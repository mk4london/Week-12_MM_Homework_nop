package electronics;


import base_Set_up.Base_Set_up;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
/*
 * Create the class ElectronicsTest

 */

public class ElectronicsTest extends Base_Set_up {
    // Base Url
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openbrowser() {
        open_Browser(baseUrl);


    }

    /* * Write the following test
     * Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
     * 1.1 Mouse Hover on “Electronics” Tab
     * 1.2 Mouse Hover on “Cell phones” and click
     * 1.3 Verify the text “Cell phones”
     */

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        mouseHoverToElement(By.xpath("//a[contains(text(),'Electronics ')]"));
        mouseclickToElement(By.xpath("//ul[@class='sublist first-level']/li/a[contains(text(),'Cell phones ')]"));
        String expectedMessage = "Cell phones";
        String actualMessage = get_Text_From_Element(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage, actualMessage);


    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        /*
         * * 1.1 Mouse Hover on “Electronics” Tab
         * 1.2 Mouse Hover on “Cell phones” and click
         * 1.3 Verify the text “Cell phones”
         */
        mouseHoverToElement(By.xpath("//a[contains(text(),'Electronics ')]"));
        Thread.sleep(100);
        mouseclickToElement(By.xpath("//ul[@class='sublist first-level']/li/a[contains(text(),'Cell phones ')]"));
        String expectedMessage = "Cell phones";
        String actualMessage = get_Text_From_Element(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage, actualMessage);
        /*
        *2.4 Click on List View Tab
	    2.5 Click on product name “Nokia Lumia 1020” link
	    2.6 Verify the text “Nokia Lumia 1020”
	    2.7 Verify the price “$349.00”
	    2.8 Change quantity to 2
	    2.9 Click on “ADD TO CART” tab
	    2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
          */
        Thread.sleep(100);
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(10);
        mouseclickToElement(By.xpath("//a[contains(text(),'List')]"));

        Thread.sleep(2000);
        WebElement nokia = driver.findElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
        click_on_wait(driver, nokia, 50);
        // verify mobile
        Thread.sleep(100);
        String expectedMessage1 = "Nokia Lumia 1020";
        String actualMessage1 = get_Text_From_Element(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage1, actualMessage1);
        // verify price
        Thread.sleep(20);
        String expectedMessage2 = "$349.00";
        String actualMessage2 = get_Text_From_Element(By.cssSelector("#price-value-20"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage2, actualMessage2);
        //2.8 Change quantity to 2
        driver.findElement(By.cssSelector("#product_enteredQuantity_20")).clear();
        WebElement quantity = driver.findElement(By.cssSelector("#product_enteredQuantity_20"));

        //2.8 Change quantity to 2
        sendKeys_wait(driver, quantity, 10, "2");

        // 2.9 Click on “ADD TO CART” tab
        WebElement addtocart = driver.findElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        click_on_wait(driver, addtocart, 15);

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(100);
        String expectedMessage3 = "The product has been added to your ";
        String actualMessage3 = get_Text_From_Element(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Please try again ", expectedMessage1, actualMessage1);

        // close the green bar
        WebElement closethebar = driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        click_on_wait(driver, closethebar, 15);

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        click_on_wait(driver, element1, 30);

        //2.12 Verify the message "Shopping cart"
        Thread.sleep(100);
        String expectedMessage4 = "Shopping cart";
        String actualMessage4 = get_Text_From_Element(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage4, actualMessage4);

        //2.13 Verify the quantity is 2
       /* Thread.sleep(5000);
        String expectedMessage5= "2";
        String actualMessage5 = get_Text_From_Element(By.xpath("//input[@class='qty-input']"));
        Thread.sleep(1000);
        Assert.assertEquals("Cell phone  is not display", expectedMessage5, actualMessage5); */


        // 2.14 Verify the Total $698.00
        Thread.sleep(100);
        String expectedMessage6 = "$698.00";
        String actualMessage6 = get_Text_From_Element(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage6, actualMessage6);

        //2.15 click on checkbox “I agree with the terms of service”

        WebElement click = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        click_on_wait(driver, click, 10);

        // 2.16 Click on “CHECKOUT”

        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        click_on_wait(driver, checkout, 10);

        // 2.17 Verify the Text “Welcome, Please Sign In!”

        Thread.sleep(1000);
        String expectedMessage7 = "Welcome, Please Sign In!";
        String actualMessage7 = get_Text_From_Element(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage7, actualMessage7);

        //2.18 Click on “REGISTER” tab
        WebElement register = driver.findElement(By.xpath("//button[contains(text(),'Register')]"));
        click_on_wait(driver, register, 10);

        // 2.19 Verify the text “Register”
        Thread.sleep(1000);
        String expectedMessage8 = "Register";
        String actualMessage8 = get_Text_From_Element(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage8, actualMessage8);

        // 2.20 Fill the mandatory fields

        WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement firstname = driver.findElement(By.xpath("//input[@id='FirstName']"));
        WebElement lastname = driver.findElement(By.xpath("//input[@id='LastName']"));
        //WebElement day = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        // WebElement month = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        //   WebElement year = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        WebElement companyname = driver.findElement(By.xpath("//input[@id='Company']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        WebElement confirmpassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        WebElement registerbutton = driver.findElement(By.xpath("//button[@id='register-button']"));
        click_on_wait(driver, male, 10);
        sendKeys_wait(driver, firstname, 10, "asdfgrf");
        sendKeys_wait(driver, lastname, 10, "jkjkjkkjj");
        select_By_Value_From_Drop_down(By.xpath("//select[@name='DateOfBirthDay']"), "15");
        select_By_Value_From_Drop_down(By.xpath("//select[@name='DateOfBirthMonth']"), "10");
        select_By_Value_From_Drop_down(By.xpath("//select[@name='DateOfBirthYear']"), "1998");
        sendKeys_wait(driver, email, 10, "aabccd@gmail.com");
        sendKeys_wait(driver, password, 10, "abc122");
        sendKeys_wait(driver, confirmpassword, 10, "abc122");
        click_on_wait(driver, registerbutton, 10);

        // 2.22 Verify the message “Your registration completed”
        Thread.sleep(1000);
        String expectedMessage9 = "Your registration completed";
        String actualMessage9 = get_Text_From_Element(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage9, actualMessage9);

        // 2.24 Verify the text “Shopping card”
        Thread.sleep(10000);
        String expectedMessage10 = "Shopping cart";
        Thread.sleep(500);
        String actualMessage10 = get_Text_From_Element(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage10, actualMessage10);

        //  2.25 click on checkbox “I agree with the terms of service”
        // 2.26 Click on “CHECKOUT”

        WebElement clickterms = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        WebElement checkoutbutton = driver.findElement(By.xpath("//button[@id='checkout']"));
        click_on_wait(driver, clickterms, 10);
        click_on_wait(driver, checkoutbutton, 10);
        // 2.27 Fill the Mandatory fields
        WebElement firstname1 = driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
        WebElement lastname1 = driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']"));
        WebElement mail = driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']"));
        WebElement company = driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']"));
        WebElement country = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
        WebElement state = driver.findElement(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"));
        WebElement city = driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
        WebElement postcode = driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
        WebElement phone = driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
        WebElement continuebutton = driver.findElement(By.xpath("//button[@class='button-1 new-address-next-step-button']"));
        sendKeys_wait(driver, firstname1, 10, "hi");
        sendKeys_wait(driver, lastname1, 10, "hi");
        sendKeys_wait(driver, mail, 10, "abccd@gmail.com");
        sendKeys_wait(driver, company, 10, "abcltd");
        select_By_Value_From_Drop_down(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "15");
        select_By_Value_From_Drop_down(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "0");
        sendKeys_wait(driver, city, 10, "london");
        sendKeys_wait(driver, postcode, 10, "london");
        sendKeys_wait(driver, phone, 10, "0731254887");
        click_on_wait(driver, checkoutbutton, 10);

        // 2.28 Click on “CONTINUE”
        //	2.29 Click on Radio Button “2nd Day Air ($0.00)”
        //2.30 Click on “CONTINUE”

        mouseclickToElement(By.cssSelector("#shippingoption_2"));
        WebElement continuebuton = driver.findElement(By.xpath("// button[@class='button-1 shipping-method-next-step-button']"));
        click_on_wait(driver, continuebuton, 10);

        // 2.31 Select Radio Button “Credit Card”
        //2.32 Select “Visa” From Select credit card dropdown
        //2.33 Fill all the details
        //2.34 Click on “CONTINUE”
        WebElement clickon = driver.findElement(By.cssSelector("#paymentmethod_1"));
        click_on_wait(driver, clickon, 10);
        // 2.33 Fill all the details
        select_By_Value_From_Drop_down(By.xpath("//select[@id='CreditCardType']"), "2");
        WebElement cardholder = driver.findElement(By.xpath("//input[@id='CardholderName']"));
        sendKeys_wait(driver, cardholder, 10, "abcd");
        WebElement cardnumber = driver.findElement(By.xpath("//input[@id='CardNumber']"));
        sendKeys_wait(driver, cardnumber, 10, "514254123256");
        select_By_Value_From_Drop_down(By.xpath("//select[@id='ExpireMonth']"), "10");
        select_By_Value_From_Drop_down(By.xpath("//select[@id='ExpireYear']"), "10");
        WebElement sendcode = driver.findElement(By.xpath("//input[@id='CardCode']"));
        sendKeys_wait(driver, sendcode, 10, "123");
        WebElement conbutton = driver.findElement(By.xpath("//button[@class ='button-1 payment-info-next-step-button']"));
        click_on_wait(driver, conbutton, 10);
        // 2.35 Verify “Payment Method” is “Credit Card”
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        //	2.37 Verify Total is “$698.00”
        //	2.38 Click on “CONFIRM”
        //	2.39 Verify the Text “Thank You”
        //	2.40 Verify the message “Your order has been successfully processed!”
        //	2.41 Click on “CONTINUE”
        //2.42 Verify the text “Welcome to our store”
        //2.43 Click on “Logout” link
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        WebElement paymentmethod = driver.findElement(By.xpath("//h2[contains(text(),'Payment method')]"));
        click_on_wait(driver, paymentmethod, 10);
        Thread.sleep(2000);
        String expectedMessage11 = "Credit Card";
        String actualMessage11 = get_Text_From_Element(By.xpath("//label[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage11, actualMessage11);

        // //2.36 Verify “Shipping Method” is “2nd Day Air”
        WebElement shipping = driver.findElement(By.xpath("//h2[contains(text(),'Shipping method')]"));
        click_on_wait(driver, shipping, 10);
        Thread.sleep(2000);
        String expectedMessage12 = "2nd Day Air___Shipping.FixedByWeightByTotal";
        String actualMessage12 = get_Text_From_Element(By.cssSelector("#shippingoption_2"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage12, actualMessage12);

        // 2.37 Verify Total is “$698.00”
        Thread.sleep(2000);
        String expectedMessage13 = "$698.00";
        String actualMessage13 = get_Text_From_Element(By.xpath("//td[@class='cart-total-right']/span/strong"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage13, actualMessage13);

        WebElement confirm = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
        click_on_wait(driver, confirm, 10);

        // 2.39 Verify the Text “Thank You
        Thread.sleep(2000);
        String expectedMessage14 = "Thank you";
        String actualMessage14 = get_Text_From_Element(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage14, actualMessage14);

        // 2.37 Verify Total is “Your order has been successfully processed!”
        Thread.sleep(2000);
        String expectedMessage15 = "Your order has been successfully processed!";
        String actualMessage15 = get_Text_From_Element(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage15, actualMessage15);
        // click button
        WebElement continueb = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
        click_on_wait(driver, continueb, 10);


        // 2.37 Verify Total is “Welcome to our store”
        Thread.sleep(2000);
        String expectedMessage16 = "Welcome to our store";
        String actualMessage16 = get_Text_From_Element(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Cell phone  is not display", expectedMessage16, actualMessage16);

        // logout
        WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        click_on_wait(driver, logout, 15);

        String actuelurl=driver.getCurrentUrl();
        Assert.assertEquals("Url not found",baseUrl,actuelurl);


    }

    @After
    public void close_Browser() {
        super.close_Browser();
    }
}
