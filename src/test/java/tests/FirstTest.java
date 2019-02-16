package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {



    @Parameters({"deviceName", "version", "platformName", "appPackage", "appActivity"})
    @Test
    public void testSuma(String p1,String p2,String p3,String p4,String p5) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver;
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", p1);
        cap.setCapability(CapabilityType.VERSION, p2);
        cap.setCapability("platformName", p3);
        cap.setCapability("appPackage", p4);
        cap.setCapability("appActivity", p5);

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);


//Suma
        driver.findElement(By.id("digit_5")).click();
        driver.findElement(By.id("op_add")).click();
        driver.findElement(By.id("digit_2")).click();
        driver.findElement(By.id("eq")).click();

        String ResObtenido =driver.findElement(By.id("result")).getText();

        Assert.assertEquals(ResObtenido,"7");

//Multiplicación

        driver.findElement(By.id("digit_6")).click();
        driver.findElement(By.id("op_mul")).click();
        driver.findElement(By.id("digit_3")).click();
        driver.findElement(By.id("eq")).click();

        String ResObtenido2 =driver.findElement(By.id("result")).getText();
        Assert.assertEquals(ResObtenido2,"18");

//Resta
        driver.findElement(By.id("digit_9")).click();
        driver.findElement(By.id("op_sub")).click();
        driver.findElement(By.id("digit_3")).click();
        driver.findElement(By.id("eq")).click();

        String ResObtenido3 =driver.findElement(By.id("result")).getText();
        Assert.assertEquals(ResObtenido3,"6");

//División

        driver.findElement(By.id("digit_8")).click();
        driver.findElement(By.id("op_div")).click();
        driver.findElement(By.id("digit_2")).click();
        driver.findElement(By.id("eq")).click();

        String ResObtenido4 =driver.findElement(By.id("result")).getText();
        Assert.assertEquals(ResObtenido4,"4");

        driver.quit();


    }
}
