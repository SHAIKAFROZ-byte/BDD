package Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class AllUtilities {

    public static WebDriver driver;
    private static Logger log;

    private WebDriverWait wait;
    public AllUtilities() throws IOException {
        initialize();
    }

    public WebDriver getDriver() {

        return driver;
    }

    public Logger getLog() {
        return log;

    }
    public WebDriverWait getWait(WebElement element){
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
        return wait;
    }




    @Before(order=1)

    public void initialize() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        log = LogManager.getLogger(AllUtilities.class);
    }



}
