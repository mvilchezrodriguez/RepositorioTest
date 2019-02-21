package objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CountryObject {

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;


    public CountryObject( AndroidDriver<AndroidElement> driver){

        this.driver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        wait = new WebDriverWait(this.driver,20);


    }

    //locator

    @AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='0']")
    private AndroidElement btn_Argentina;

    @AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='1']")
    private AndroidElement btn_Panama;

    @AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='2']")
    private AndroidElement btn_Peru;

    @AndroidFindBy(id = "textViewLocaleNext")
    private AndroidElement btn_Next;




    //Actions metodos


    public void  SeleccionaraArgentina()
    {

        //wait.until(ExpectedConditions.visibilityOf(txtFormula)).sendKeys(texto);

        wait.until(ExpectedConditions.visibilityOf(btn_Argentina)).click();


    }

    public void  SeleccionarPanama()
    {
        wait.until(ExpectedConditions.visibilityOf(btn_Panama)).click();

    }

    public void  SeleccionarPeru()
    {
        wait.until(ExpectedConditions.visibilityOf(btn_Peru)).click();

    }

    public void  SeleccionarNext()
    {
        btn_Next.click();

    }
}
