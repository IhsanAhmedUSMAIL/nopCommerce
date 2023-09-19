package US_04_01_Faruk;

import US_03_Faruk.Elementlerim;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

/*
- Platformun ana sayfasına erişebilmeliyim.
- Sayfa üzerinde sekme menüsünün bulunduğunu ve bu menünün elemanlarının listelendiğini doğrulayabilmeliyim.
- Sekme menüsündeki her bir elemana tıklayabilmeliyim.
- Sekme menüsündeki her bir elemana tıkladığımda beni kendi sayfasına yönlendirdiğine emin olmalıyım.
-  Alt menü içeren bir sekme elemanı varsa her birinin tıklanabilir olduğuna ve kendi sayfasına yönlendirdiğine emin olmalıyım.
 */
public class US_04_01_Faruk extends BaseDriver {

    @Test()
    public void US_04_01_Faruk_tabMenuKontrol() {
        Elementlerim e = new Elementlerim();
        driver.navigate().to("https://demo.nopcommerce.com/");
        Actions actDrive = new Actions(driver);
        Assert.assertEquals(e.tabMenuAnaBasliklar.size(),7,"Ana başlıkta eksik kategori");
        for (int i = 0; i <3 ; i++) {
            String elementText = e.tabMenuAnaBasliklar.get(i).getText().toLowerCase().replaceAll("[^a-z]","");
            actDrive.moveToElement(e.tabMenuAnaBasliklar.get(i)).build().perform();
            e.tabMenuAnaBasliklar.get(i).click();
            String mevcutUrl = driver.getCurrentUrl();
            Assert.assertTrue(mevcutUrl.contains(elementText),"Hatalı ana başlık sayfası");
            for (int j = 0; j <e.altMenuler.size() ; j++) {
                String altMenuText= e.altMenuler.get(j).getText().toLowerCase().replaceAll("[^a-z]","");
                e.altMenuler.get(j).click();
                MyFunc.Wait(1);
                String yeniUrl = driver.getCurrentUrl().replaceAll("[^a-z]","");
                Assert.assertTrue(yeniUrl.contains(altMenuText), "Hatalı ürün sayfasına yönlendirildi");
                driver.navigate().back();
            }
        }
        driver.navigate().to("https://demo.nopcommerce.com/");
        for (int i = 3; i <e.tabMenuAnaBasliklar.size() ; i++) {
            String elementText = e.tabMenuAnaBasliklar.get(i).getText().toLowerCase().replaceAll("[^a-z]","");
            actDrive.moveToElement(e.tabMenuAnaBasliklar.get(i)).build().perform();
            e.tabMenuAnaBasliklar.get(i).click();
            String mevcutUrl = driver.getCurrentUrl().replaceAll("[^a-z]","");
            Assert.assertTrue(mevcutUrl.contains(elementText),"Hatalı ana başlık sayfası");
            driver.navigate().back();
        }
        }
    }



