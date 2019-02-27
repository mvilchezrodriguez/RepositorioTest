package objects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

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
// 7478398776 -> Recibido
    public void  RegistrarTransacción(String tracnum)
    {
        wait.until(ExpectedConditions.visibilityOf(txt_tracnum)).sendKeys(tracnum);
        btn_Siguiente.click();
    }

    public void horizontalSwipeByScreenSize(double startPercentage, double endPercentage, double verticalPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * verticalPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);

        new TouchAction(driver)
                .press(PointOption.point(startPoint, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint, anchor))
                .release().perform();
    }

    public void takeScreenshot(int result) throws IOException {
        String path = "out/test/resources/";
        File sourceFile = driver.getScreenshotAs(OutputType.FILE);
        String filename = this.getClass().getName();
        switch (result) {
            case 1:
                filename += ".PASS.jpg";
                break;
            case 2:
                filename += ".FAILED.jpg";
                break;
            default: filename += ".OTHER.jpg";
                break;
        }
        File targetFile = new File(path + filename);
        FileUtils.copyFile(sourceFile, targetFile);
    }


}
