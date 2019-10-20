package beru_tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import beru_tests.pages.BeruHomePage;

public class FirstWebTest {
    private static BeruHomePage homePage;
    @BeforeAll
    static void createDriver(){
//       DriverFactory.createDriver();
//       homePage = new BeruHomePage();
        homePage = new BeruHomePage(DriverFactory.createDriver());
    }

    @Test
    void checkPageOpened(){
//        WebElement searchField = DriverFactory.driver.findElements(By.name("text")).get(1);
//        WebElement findButton = DriverFactory.driver.findElement(By.xpath("//button/span[text()='Найти']"));
//        assertThat(searchField.isDisplayed(), equalTo(true));
//        Assertions.assertTrue(findButton.isDisplayed());

        homePage.checkPageOpened();
    }

    @Test
    void searchForNoCheck(){
        homePage.searchFor("Пылесос");
    }

    @AfterEach
    void goToMain(){
        homePage.clickLogo();
    }

    @AfterAll
    static void tearDown(){
        DriverFactory.tearDown();
    }
}