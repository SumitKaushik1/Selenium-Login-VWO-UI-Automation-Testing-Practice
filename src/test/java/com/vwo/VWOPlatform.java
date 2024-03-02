package com.vwo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Unit test for simple App.
 */
public class VWOPlatform
{

    WebDriver driver;
    /**
     * Rigorous Test :-)
     */

    @BeforeSuite
    public void navigateToTheURL() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","J:\\3. automation testing\\day39---Selenium full ui elements testing\\Assignment1 Answers\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");
        String title=driver.getTitle();
        Assert.assertEquals(title,"Login - VWO","Unable to open the App");

    }



    /*

    2. / -> means root node
//->anywhere
.->selects the current node
..->select the parent of the current node(or simpl go to the previous one )
@->select attribute
nodename->select all nodes with  name ="nodename"

     */

    @Test
    public void loginCrdentials() throws InterruptedException
    {
        WebElement emailAddress= driver.findElement(By.xpath("//input[@id='login-username']"));
        emailAddress.sendKeys("WrongCred94npu2yyb0@esiix.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='login-password']"));
        password.sendKeys("Wingify@123");
        WebElement signInButton = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        signInButton.click();

        String errorMessage = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']")).getText();
        Assert.assertEquals(errorMessage, "Your email, password, IP address or location did not match");


    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
