package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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

public class FirstTest2 {

    //AndroidDriver
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
    public void TestSuma()
    {

        driver.findElement(By.id("digit_5")).click();
        driver.findElement(By.id("op_add")).click();
        driver.findElement(By.id("digit_2")).click();
        driver.findElement(By.id("eq")).click();

        String ResObtenido =driver.findElement(By.id("result")).getText();

        Assert.assertEquals(ResObtenido,"7");
    }

    @Test
    public void TestResta()
    {

        driver.findElement(By.id("digit_9")).click();
        driver.findElement(By.id("op_sub")).click();
        driver.findElement(By.id("digit_3")).click();
        driver.findElement(By.id("eq")).click();

        String ResObtenido3 =driver.findElement(By.id("result")).getText();
        Assert.assertEquals(ResObtenido3,"6");
    }

    @Test
    public void TestMultiplicacion()
    {

        driver.findElement(By.id("digit_6")).click();
        driver.findElement(By.id("op_mul")).click();
        driver.findElement(By.id("digit_3")).click();
        driver.findElement(By.id("eq")).click();

        String ResObtenido2 =driver.findElement(By.id("result")).getText();
        Assert.assertEquals(ResObtenido2,"18");
    }

    @Test
    public void TestDivision()
    {

        driver.findElement(By.id("digit_8")).click();
        driver.findElement(By.id("op_div")).click();
        driver.findElement(By.id("digit_2")).click();
        driver.findElement(By.id("eq")).click();

        String ResObtenido4 =driver.findElement(By.id("result")).getText();
        Assert.assertEquals(ResObtenido4,"4");
    }


    @AfterTest
    public void quit() {

        driver.quit();
    }


}
