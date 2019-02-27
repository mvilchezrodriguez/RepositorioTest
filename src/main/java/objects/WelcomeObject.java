package objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomeObject {

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;


    public WelcomeObject( AndroidDriver<AndroidElement> driver){

        this.driver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        wait = new WebDriverWait(this.driver,20);


    }

    @AndroidFindBy(id = "menuBtn")
    private AndroidElement btn_Menu;

    @AndroidFindBy(xpath="//android.view.View[@instance='14']")
    private AndroidElement btn_RastrearTrasferencia;

    //Actions metodo


    public void  EsperarMenu()
    {
        wait.until(ExpectedConditions.visibilityOf(btn_Menu));

    }

    public void  SeleccionarMenu()
    {
        wait.until(ExpectedConditions.visibilityOf(btn_Menu)).click();

    }

    public void  SeleccionarRastrearTrasferencia()
    {
        wait.until(ExpectedConditions.visibilityOf(btn_RastrearTrasferencia)).click();

    }
}
