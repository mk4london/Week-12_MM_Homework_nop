package home_Page;

import base_Set_up.Base_Set_up;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

/**
 * Create the package homepage
 * <p>
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of  type string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select
 * the Menu and click on it and verify the page navigation.
 */
// create class "TopMenuTest"
public class Top_Menu_Test extends Base_Set_up {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        open_Browser(baseUrl);

    }

    // 1.1 create method with name "selectMenu" it has one parameter name "menu" of  type string
    public void select_Menu(String menu) throws InterruptedException {

      //  List<WebElement> elementList = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/child::li"));
        List<WebElement> elementList2 = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/child::li"));
        for (WebElement element : elementList2) {


            if (element.getText().equalsIgnoreCase(menu)) {
                element.click();
                break;
            }
        }


    }

    @Test
    public void verify_Page_Navigation() throws InterruptedException {


        Thread.sleep(5000);
        select_Menu("apparel");
        Thread.sleep(5000);
        String expectedMessage = "Apparel";

        String actualMessage = get_Text_From_Element(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("Name is not  not display", expectedMessage, actualMessage);


    }

    @After
    public void close_Browser() {
        super.close_Browser();
    }
}
