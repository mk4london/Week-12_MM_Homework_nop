package computer;

import base_Set_up.Base_Set_up;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 *  Create the package name computer
 * 1. Create class “TestSuite”
 *
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 	1.1 Click on Computer Menu.
 * 	1.2 Click on Desktop
 * 	1.3 Select Sort By position "Name: Z to A"
 * 	1.4 Verify the Product will arrange in Descending order.
 *
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 	2.1 Click on Computer Menu.
 * 	2.2 Click on Desktop
 * 	2.3 Select Sort By position "Name: A to Z"
 * 	2.4 Click on "Add To Cart"
 * 	2.5 Verify the Text "Build your own computer"
 * 	2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
 * 	2.7.Select "8GB [+$60.00]" using Select class.
 * 	2.8 Select HDD radio "400 GB [+$100.00]"
 * 	2.9 Select OS radio "Vista Premium [+$60.00]"
 *            	2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
 * 	2.11 Verify the price "$1,475.00"
 * 	2.12 Click on "ADD TO CARD" Button.
 * 	2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
 * After that close the bar clicking on the cross button.
 * 	2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 	2.15 Verify the message "Shopping cart"
 * 	2.16 Change the Qty to "2" and Click on "Update shopping cart"
 * 	2.17 Verify the Total"$2,950.00"
 * 	2.18 click on checkbox “I agree with the terms of service”
 * 	2.19 Click on “CHECKOUT”
 * 	2.20 Verify the Text “Welcome, Please Sign In!”
 * 	2.21Click on “CHECKOUT AS GUEST” Tab
 * 	2.22 Fill the all mandatory field
 * 	2.23 Click on “CONTINUE”
 * 	2.24 Click on Radio Button “Next Day Air($0.00)”
 * 2.25 Click on “CONTINUE”
 * 2.26 Select Radio Button “Credit Card”
 * 2.27 Select “Master card” From Select credit card dropdown
 * 2.28 Fill all the details
 * 2.29 Click on “CONTINUE”
 * 2.30 Verify “Payment Method” is “Credit Card”
 * 2.32 Verify “Shipping Method” is “Next Day Air”
 * 	2.33 Verify Total is “$2,950.00”
 * 	2.34 Click on “CONFIRM”
 * 	2.35 Verify the Text “Thank You”
 * 	2.36 Verify the message “Your order has been successfully processed!”
 * 	2.37 Click on “CONTINUE”
 * 2.37 Verify the text “Welcome to our store”
 */

public class Test_Suite extends Base_Set_up {
    /**
     * *  Create the package name computer
     * * 1. Create class “TestSuite”
     */
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openbrowser() {
        open_Browser(baseUrl);

    }

    /***
     *Write the following Test:
     *  * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
     *  * 	1.1 Click on Computer Menu.
     *  * 	1.2 Click on Desktop
     *  * 	1.3 Select Sort By position "Name: Z to A"
     *  * 	1.4 Verify the Product will arrange in Descending order.
     */

    @Test
    public void verify_ProductArrange_In_AlphaBatical_Order() {
        //  click_On_Element(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        WebElement desktop = driver.findElement(By.xpath("//ul[@class='sublist first-level']/li[1]"));
        actions.moveToElement(computer).moveToElement(desktop).click().build().perform();
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='products-orderby']"));
        Select select = new Select(dropdown);
        select.selectByValue("6");
        String expectedMessage = "Name: Z to A";
        String actualMessage = get_Text_From_Element(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("Electronics is not display", expectedMessage, actualMessage);


    }

    // 2. Test name verifyProductAddedToShoppingCartSuccessFully()
    @Test
    public void verify_Product_Added_To_ShoppingCart_SuccessFully() throws InterruptedException {

        Actions actions = new Actions(driver);
      /*  2.1 Click on Computer Menu.
        2.2 Click on Desktop
        2.3 Select Sort By position "Name: A to Z" */

        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        WebElement desktop = driver.findElement(By.xpath("//ul[@class='sublist first-level']/li[1]"));
        actions.moveToElement(computer).moveToElement(desktop).click().build().perform();

        select_By_Value_From_Drop_down(By.xpath("//select[@id='products-orderby']"), "5");
        Thread.sleep(3000);

        // 2.4 Click on "Add To Cart"
        WebElement buildComputer = driver.findElement(By.xpath("//div[@class='buttons']/button[1]"));
        actions.moveToElement(buildComputer).click().build().perform();

        //2.5 Verify the Text "Build your own computer"
        String expectedMessage = "Build your own computer";
        String actualMessage = get_Text_From_Element(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Thread.sleep(1000);
        Assert.assertEquals("Build your own computer is not display", expectedMessage, actualMessage);

        //* 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        select_By_Value_From_Drop_down(By.xpath("//select[@id='product_attribute_1']"), "1");

        // * 2.7.Select "8GB [+$60.00]" using Select class.
        select_By_Value_From_Drop_down(By.xpath("//select[@id='product_attribute_2']"), "5");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        click_On_Element(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(1000);

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        click_On_Element(By.xpath("//input[@id='product_attribute_4_9']"));
        Thread.sleep(2000);

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        click_On_Element(By.xpath("//input[@id='product_attribute_5_12']"));
        Thread.sleep(2000);


        String expectedMessage1 = "Build your own computer";
        String actualMessage1 = get_Text_From_Element(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Thread.sleep(100);
        Assert.assertEquals("Build your own computer is not display", expectedMessage1, actualMessage1);
        Thread.sleep(1000);
        //* 2.12 Click on "ADD TO CARD" Button.
        click_On_Element(By.xpath("//button[@id='add-to-cart-button-1']"));


// * 2.11 Verify the price "$1,475.00"
        String expectedMessage2 = "$1,475.00";
        String actualMessage2 = get_Text_From_Element(By.cssSelector("#price-value-1"));
        Thread.sleep(1000);
        Assert.assertEquals("Price not match", expectedMessage2, actualMessage2);


// * 2.13 Verify the Message "The product has been added to your shopping cart" on Top
        Thread.sleep(2000);
        String expectedMessage3 = "The product has been added to your shopping cart";
        String actualMessage3 = get_Text_From_Element(By.xpath("//p[@class='content']"));
        Thread.sleep(3000);
        Assert.assertEquals("Price not match", expectedMessage3, actualMessage3);

        Thread.sleep(2000);
        WebElement close = driver.findElement(By.xpath("//span[@class='close']"));
        actions.moveToElement(close).click().build().perform();
// 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(3000);
        WebElement shoppingcart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        actions.moveToElement(shoppingcart).click().build().perform();

// 2.15 Verify the message "Shopping cart"
        Thread.sleep(100);
        String expectedMessage4 = "Shopping cart";
        String actualMessage4 = get_Text_From_Element(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(100);
        Assert.assertEquals("Price not match", expectedMessage4, actualMessage4);


        //  2.16 Change the Qty to "2" and Click on "Update shopping cart"

        driver.findElement(By.xpath("//td[@class='quantity']/child::input")).clear();
        send_text_from_elements((By.xpath("//td[@class='quantity']/child::input")), "2");
        click_On_Element(By.xpath("//button[contains(text(),'Update shopping cart')]"));
        // 2.17 Verify the Total"$2,950.00"
        String expectedMessage5 = "$2,950.00";
        String actualMessage5 = get_Text_From_Element(By.xpath("//td[@class='subtotal']/child::span"));
        Thread.sleep(100);
        Assert.assertEquals("Price not match", expectedMessage5, actualMessage5);


        // 2.18 click on checkbox “I agree with the terms of service”
        Thread.sleep(3000);
        WebElement click = driver.findElement(By.xpath("//div[@class='terms-of-service']/child::input"));
        actions.moveToElement(click).click().build().perform();

// 2.19 Click on “CHECKOUT”
        click_On_Element(By.xpath("//button[@id='checkout']"));

// 2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage6 = "Welcome, Please Sign In!";
        String actualMessage6 = get_Text_From_Element(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Thread.sleep(100);
        Assert.assertEquals("User is not on welcome page", expectedMessage6, actualMessage6);


        //2.21Click on “CHECKOUT AS GUEST” Tab
        WebElement checkout = driver.findElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        click_on_wait(driver, checkout, 10);
        //  click_On_Element(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        // Thread.sleep(6000);
        //2.22 Fill the all mandatory field
        WebElement firstname = driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
        sendKeys_wait(driver, firstname, 15, "abcdef");
        //  send_text_from_elements(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "abcdef");
        send_text_from_elements(By.xpath("//input[@id='BillingNewAddress_LastName']"), "123456");
        send_text_from_elements(By.xpath("//input[@id='BillingNewAddress_Email']"), "abc@gmail.com");
        select_By_Value_From_Drop_down(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "133");
        select_By_Value_From_Drop_down(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "0");
        send_text_from_elements(By.xpath("//input[@id='BillingNewAddress_City']"), "Baroda");
        WebElement address = driver.findElement(By.cssSelector("#BillingNewAddress_Address1"));
        sendKeys_wait(driver, address, 5, "waghodia road");
        // send_text_from_elements(By.xpath("//div[@class='inputs']/child::input[@id='BillingNewAddress_Address1']']"), "waghodia road");
        send_text_from_elements(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "500000");
        send_text_from_elements(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "500000");
        click_On_Element(By.xpath("//div[@class='buttons']/child::button[@class='button-1 new-address-next-step-button']"));


        //  2.24 Click on Radio Button “Next Day Air($0.00)”
        // 2.25 Click on “CONTINUE”
        //2.26 Select Radio Button “Credit Card”
        //2.27 Select “Master card” From Select credit card dropdown
        //2.28 Fill all the details
        //2.29 Click on “CONTINUE”
        WebElement radiobutton = driver.findElement(By.cssSelector("#shippingoption_1"));
        WebElement creditcard = driver.findElement(By.cssSelector("#paymentmethod_1"));
        WebElement clickoncontinue = driver.findElement(By.cssSelector("#paymentmethod_1"));
        select_By_Value_From_Drop_down(By.xpath("//option[contains(text(),'Master card')]"), "2");
        WebElement sendCardholderName = driver.findElement(By.xpath("//input[@id='CardholderName']"));
        WebElement sendCardnumber = driver.findElement(By.xpath("//input[@id='CardNumber']"));
        WebElement cardcode = driver.findElement(By.xpath("//input[@id='CardCode']"));
        select_By_Value_From_Drop_down(By.cssSelector("#ExpireMonth"), "10");
        select_By_Value_From_Drop_down(By.cssSelector("#ExpireYear"), "10");
        click_on_wait(driver, radiobutton, 5);
        click_on_wait(driver, creditcard, 5);
        click_on_wait(driver, clickoncontinue, 5);
        sendKeys_wait(driver, sendCardholderName, 5, "sksjsjddj");
        sendKeys_wait(driver, sendCardnumber, 5, "12345678910");
        sendKeys_wait(driver, cardcode, 5, "123456");
        WebElement continuebutton = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        click_on_wait(driver, continuebutton, 5);




    }

    @Override
    public void close_Browser() {
        super.close_Browser();
    }
}
