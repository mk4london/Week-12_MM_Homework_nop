package utility;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility {
    public WebDriver driver;


    /**
     * this methode click on elements
     *
     * @param by
     */
    public void click_On_Element(By by) {

        driver.findElement(by).click();

    }

    /**
     * This method will  get the text from element
     *
     * @param by
     * @return
     */

    public String get_Text_From_Element(By by) {
        return driver.findElement(by).getText();

    }

    /***
     * This method will send text on elements
     * @param by
     * @param text
     */
    public void send_text_from_elements(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    /***
     *
     * @param by
     * @param value
     */
    public void select_By_Value_From_Drop_down(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);

    }

    /***
     *
     * @param driver
     * @param element
     * @param timeout
     * @param value
     */
    public void sendKeys_wait(WebDriver driver, WebElement element, int timeout, String value) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    /***
     *
     * @param driver
     * @param element
     * @param timeout
     */
    public void click_on_wait(WebDriver driver, WebElement element, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * This method will used to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    /**
     * This method will used to hover mouse on element
     */
    public void mouseclickToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    /**
     * This method will used to hover mouse on element
     */
    public void mouseclickToElement(WebDriver driver, WebElement element, int timeout) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }


}






