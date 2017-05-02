package com.fujitsu.webframework.tests;

import com.fujitsu.webframework.PageObjects.MainBasePageObject;
import com.fujitsu.webframework.PageObjects.authentication.LoginPage;
import com.fujitsu.webframework.PageObjects.commonComponents.NavigationBar;
import com.fujitsu.webframework.common.templates.NewTestTemplate;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by ONUR BASKIRT on 26.08.2015.
 */
public class MyTests extends NewTestTemplate{

    //We should add @Test annotation that JUnit will run below method
    @Test
    //Start to write our test method. It should ends with "Test"
    public void chromeTest(){

//        //Step 1- Driver Instantiation: Instantiate driver object as FirefoxDriver
//        WebDriver driver = new ChromeDriver();
//
//        //Step 2- Navigation: Open a website
//        driver.navigate().to("https://www.teknosa.com/");
//
//        //Step 3- Assertion: Check its title is correct
//        //assertEquals method Parameters: Message, Expected Value, Actual Value
//        Assert.assertEquals("Title check failed!", "Teknosa Alışveriş Sitesi - Herkes İçin Teknoloji", driver.getTitle());
//
//        //Step 4- Close Driver
//        driver.close();
//
//        //Step 5- Quit Driver
//        driver.quit();
//        Assert.assertEquals(true,true);
        //Credentials cn = new Credentials();

        MainBasePageObject base = new MainBasePageObject();
        NavigationBar SignIn = new NavigationBar(driver);
        LoginPage login = SignIn.clickOnSignIn();
        Assert.assertTrue(login.isSignOnPageOpen());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}