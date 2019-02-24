package objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RastrearTransferenciaObject {

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;


    public RastrearTransferenciaObject( AndroidDriver<AndroidElement> driver){

        this.driver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        wait = new WebDriverWait(this.driver,20);


    }

    @AndroidFindBy(id = "tracnum")
    private AndroidElement txt_tracnum;

    @AndroidFindBy(id = "tat_mtcn_btn")
    private AndroidElement btn_Siguiente;

//Actions

    public void  RegistrarTransacción()
    {
        wait.until(ExpectedConditions.visibilityOf(txt_tracnum)).sendKeys("7478398776");
        btn_Siguiente.click();
    }



}
