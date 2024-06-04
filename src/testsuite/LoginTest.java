package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {


    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //* Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        //* Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //* Verify the text “PRODUCTS”
        Assert.assertEquals("PRODUCTS", getTextFromElement(By.xpath("//span[@class='title']")));
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //* Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        //* Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //* Verify that six products are displayed on page
        List<WebElement> productTotalCount = driver.findElements(By.className("inventory_item"));
        //System.out.println(productTotalCount.size());
        Assert.assertEquals("Not redirected to login page", 6,driver.findElements(By.className("inventory_item")).size());
    }
    @After
    public void tearDown() {
        // closeBrowser();
    }
}
