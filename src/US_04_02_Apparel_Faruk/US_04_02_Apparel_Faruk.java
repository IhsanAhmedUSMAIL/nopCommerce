package US_04_02_Apparel_Faruk;

import US_03_Faruk.Elementlerim;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class US_04_02_Apparel_Faruk extends BaseDriver {
    /*
    - Kullanıcı olarak, web sitesinin başlangıç sayfasında sekme menüsündeki (ve varsa alt menülerindeki) isimleri listeleyebilmeliyim
    (Tab Menü List<>, Alt Menüleri ise bu listin listesi yani List<List<>> olmalı).
    - Ana Sayfada bulunan Arama kutusuna XML dosyasından alınan bir ürün adını girebilmeliyim ve "Search" (Ara) butonuna tıklayabilmeliyim.
    - Arama sonucundan rastgele bir ürüne tıklayarak, bu ürünün oluşturduğum listede bulunup bulunmadığını doğrulayabilmeliyim.

     */

    @Test()
    @Parameters("searchApparel")
    public void US_04_02_tabMenuApparel(String aranan)
  //  public void US_04_02_tabMenuApparel()
    {
        Elementlerim e = new Elementlerim();
        driver.navigate().to("https://demo.nopcommerce.com/");
        List <String> apparelTumUrunler = new ArrayList<>();
        Actions actDrive = new Actions(driver);
        actDrive.moveToElement(e.apparelButton).build().perform();
        for (int i = 0; i <e.apparelAltBasliklar.size() ; i++) {
            MyFunc.Wait(1);
            actDrive.moveToElement(e.apparelButton).build().perform();
            e.apparelAltBasliklar.get(i).click();
            MyFunc.Wait(1);
            List<WebElement> urunler = driver.findElements(By.xpath("//h2[@class='product-title']"));
            for (WebElement w : urunler) {
                apparelTumUrunler.add(w.getText());
            }
            driver.navigate().back();
        }
        String urunlerStr = apparelTumUrunler.toString();
        Assert.assertTrue(urunlerStr.contains(aranan));

        driver.navigate().to("https://demo.nopcommerce.com/");
        MyFunc.Wait(1);
        e.searchInput.sendKeys(aranan);
        MyFunc.Wait(1);
        e.searchButton.click();
        MyFunc.Wait(2);

        Assert.assertTrue(e.aramaSonucu.getText().contains(aranan),"Aranan ürün Apparel listesinde bulunamadı");
    }

}
