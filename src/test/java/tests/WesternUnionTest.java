package tests;

import com.sun.java.util.jar.pack.DriverResource;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import objects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class WesternUnionTest {

    AndroidDriver<AndroidElement> driver;
    CountryObject obj;
    LanguageObject obj2;
    WelcomeObject obj3;
    RastrearTransferenciaObject obj4;
    InformacionTransferenciaObject obj5;

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

         obj = new CountryObject(driver);
         obj2 = new LanguageObject(driver);
         obj3 = new WelcomeObject(driver);
         obj4= new RastrearTransferenciaObject(driver);
         obj5 = new InformacionTransferenciaObject(driver);
        System.out.println("se ejecuto setup");
    }

    @Test(priority = 1)
    public void TestRatrearEstadoTransferencia() throws InterruptedException {


        obj.SeleccionarPeru();
        obj.SeleccionarNext();
        obj2.SeleccionarEspañol();
        obj2.SeleccionarDone();
        obj3.EsperarMenu();
        obj4.horizontalSwipeByScreenSize(0.90,  0.10, 0.50);
        Thread.sleep(4000);

     /*
        obj3.SeleccionarMenu();
        obj3.SeleccionarRastrearTrasferencia();
        obj4.RegistrarTransacción();
        String resultadoObtenido= obj5.TransferenciaRecibida();
        Assert.assertEquals(resultadoObtenido, "Recibido");
        Thread.sleep(3000);
*/
    }



    @AfterTest
    public void quit() {

        driver.quit();

    }
}
