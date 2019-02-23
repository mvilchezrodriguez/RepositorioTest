package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import objects.CalculadoraObject;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraTest {

    //Tarea 3.2 - CalculadoraTest

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
//driver
        driver = new AndroidDriver<>(new URL(url),capabilities);

    }

    @Test
    public void TestSumar()
    {
        CalculadoraObject obj = new CalculadoraObject(driver);
        obj.Sumar();
        String resultado=obj.ObtenerResultado();
        Assert.assertEquals(resultado,"7");

    }

    @Test
    public void TestRestar()
    {
        CalculadoraObject obj = new CalculadoraObject(driver);
         obj.Restar();
        String resultado=obj.ObtenerResultado();
        Assert.assertEquals(resultado,"6");
    }

    @Test
    public void TestMultiplar()
    {
        CalculadoraObject obj = new CalculadoraObject(driver);
        obj.Multiplicar();
        String resultado=obj.ObtenerResultado();
        Assert.assertEquals(resultado,"18");
    }

    @Test
    public void TestDividir()
    {
        CalculadoraObject obj = new CalculadoraObject(driver);
        obj.Dividir();
        String resultado=obj.ObtenerResultado();
        Assert.assertEquals(resultado,"4");

    }


    @AfterTest
    public void quit() {

        driver.quit();
    }
}
