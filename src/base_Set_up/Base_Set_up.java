package base_Set_up;

import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.concurrent.TimeUnit;

/*
 * Basic set up for open and close the chrome Browser
 *
 *
 */

public class Base_Set_up extends Utility {
    public void open_Browser(String baseUrl) {

        // use the .setproperty() method
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        // create the object
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // for maximize the window
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); // for get the extra time
        driver.get(baseUrl); // get method to get the url
    }

    public void close_Browser() {
        if (driver != null) {
            driver.quit();
        }
    }

}





