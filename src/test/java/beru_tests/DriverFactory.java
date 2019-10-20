package beru_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver;

    static WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//        driver.wait(5000);
//        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.get("https://beru.ru");
        return driver;
    }

    static void tearDown(){
        driver.close();
    }
}
