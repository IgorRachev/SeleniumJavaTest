package beru_tests.pages;

import beru_tests.DriverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

//First approach - extend Driver Factory
/*
public class BeruHomePAge extends DriverFactory {
    private WebElement searchField = driver.findElements(By.name("text")).get(1);
    private WebElement findButton = driver.findElement(By.xpath("//button/span[text()='Найти']"));

    public void checkPageOpened(){
        assertThat(searchField.isDisplayed(), equalTo(true));
        Assertions.assertTrue(findButton.isDisplayed());
    }

    public void searchFor(String text){
        searchField.sendKeys(text);
        findButton.click();
    }
*/

//Second approach - use constructor
public class BeruHomePage{
    WebDriver driver;

    public BeruHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "text")
    private List<WebElement> searchField;

    @FindBy(xpath = "//button/span[text()='Найти']")
    private WebElement findButton;

    @FindAll({
            @FindBy(tagName = "span"),
            @FindBy(className = "_1G9kMUZOVq")
    })
    private WebElement logo;

    @FindBys( {
            @FindBy(className = "class1"),
            @FindBy(className = "class2")
    } )
    private List<WebElement> elementsWithBoth_class1A;


    public void checkPageOpened(){
        assertThat(searchField.get(1).isDisplayed(), equalTo(true));
        Assertions.assertTrue(findButton.isDisplayed());
    }

    public void searchFor(String text){
        searchField.get(1).sendKeys(text);
        findButton.click();
    }

    public void clickLogo(){
        WebElement logo = driver.findElement(By.xpath("//a[@href=\"/\"]"));
        logo.click();
    }
}
