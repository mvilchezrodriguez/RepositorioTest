package objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CalculadoraObject {

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;

    public CalculadoraObject( AndroidDriver<AndroidElement> driver){

        this.driver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        wait = new WebDriverWait(this.driver,20);


    }

    //locator

    @AndroidFindBy(id="digit_5")
    private AndroidElement btn_5;

    @AndroidFindBy(id="digit_6")
    private AndroidElement btn_6;

    @AndroidFindBy(id="digit_2")
    private AndroidElement btn_2;

    @AndroidFindBy(id="digit_9")
    private AndroidElement btn_9;


    @AndroidFindBy(id="digit_3")
    private AndroidElement btn_3;

    @AndroidFindBy(id="digit_8")
    private AndroidElement btn_8;

    @AndroidFindBy(id="op_add")
    private AndroidElement btn_sumar;

    @AndroidFindBy(id="op_mul")
    private AndroidElement btn_multiplicar;


    @AndroidFindBy(id="op_div")
    private AndroidElement btn_dividir;

    @AndroidFindBy(id="op_sub")
    private AndroidElement btn_restar;

    @AndroidFindBy(id="eq")
    private AndroidElement btn_igual;

    @AndroidFindBy(id="result")
    private AndroidElement txt_resultado;

    //Actions metodos


    public void  Sumar()
    {
        btn_5.click();
        btn_sumar.click();
        btn_2.click();
        btn_igual.click();

    }

    public void Restar()
    {
        btn_9.click();
        btn_restar.click();
        btn_3.click();
        btn_igual.click();
    }

    public void Multiplicar()
    {
        btn_6.click();
        btn_multiplicar.click();
        btn_3.click();
        btn_igual.click();
    }

    public void  Dividir()
    {
        btn_8.click();
        btn_dividir.click();
        btn_2.click();
        btn_igual.click();
    }

    public String ObtenerResultado()
    {
        String resultado= txt_resultado.getText();
        return resultado;
    }


}
