package US_07_VILDAN;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*Arama kutusuna XML dosyasından alınan "Adobe Photoshop CS4" arama terimini girebilmeliyim.

        "Search" (Ara) butonuna tıklayabilmeliyim. Veya "Enter'a basarak da arama yapabilmeliyim.

        Açılan sayfadaki ürün başlığının "Adobe Photoshop CS4" arama terimini içerdiğini doğrulayabilmeliyim.*/
public class US_07_Vildan extends BaseDriver {

    @Test
    @Parameters("searchText")
    public void searchWithParameters(String aranan) {

        VildanElements e = new VildanElements();

        driver.get("https://demo.nopcommerce.com/");

        MyFunc.Wait(2);


        e.searchInputBox.click();

        e.searchInputBox.sendKeys(aranan+Keys.ENTER);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", e.productTitle);

        Assert.assertTrue(e.productTitle.getText().contains("Adobe"),"Arama sonucu cikan urun, arama terimini icermiyor");


    }

}
