package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import objects.CountryObject;
import objects.LanguageObject;
import objects.WelcomeObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class WesternUnionTest {

    AndroidDriver<AndroidElement> driver;

    @Parameters({"deviceName", "version", "platformName", "appPackage", "appActivity","url"})
    @BeforeTest
    public void setUp(String deviceName, String version, String platformName, String appPackage, String appActivity, String url) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability(CapabilityType.VERSION, version);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        driver = new AndroidDriver<>(new URL(url),capabilities);

    }


    @Test
    public void TestRegistro() throws InterruptedException {

        CountryObject obj = new CountryObject(driver);
        LanguageObject obj2 = new LanguageObject(driver);
        obj.SeleccionarPeru();
        obj.SeleccionarNext();
        obj2.SeleccionarEspañol();
        obj2.SeleccionarDone();

        Thread.sleep(15000);

        WelcomeObject obj3 = new WelcomeObject(driver);
        obj3.SeleccionarMenu();

        Thread.sleep(10000);


    }

    @AfterTest
    public void quit() {

        driver.quit();
    }
}
