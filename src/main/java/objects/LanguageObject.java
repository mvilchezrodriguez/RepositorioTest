package objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LanguageObject {

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;


    public LanguageObject( AndroidDriver<AndroidElement> driver){

        this.driver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        wait = new WebDriverWait(this.driver,20);


    }


    @AndroidFindBy(xpath="//android.widget.RelativeLayout[@instance='1']")
    private AndroidElement btn_English;

    @AndroidFindBy(xpath="//android.widget.RelativeLayout[@instance='2']")
    private AndroidElement btn_Español;

    @AndroidFindBy(id = "textViewLocaleNext")
    private AndroidElement btn_done;



    //Actions metodos


    public void  SeleccionarEnglish()
    {
        wait.until(ExpectedConditions.visibilityOf(btn_English)).click();

    }

    public void  SeleccionarEspañol()
    {
        wait.until(ExpectedConditions.visibilityOf(btn_Español)).click();

    }

    public void  SeleccionarDone()
    {
        wait.until(ExpectedConditions.visibilityOf(btn_done)).click();

    }


}
