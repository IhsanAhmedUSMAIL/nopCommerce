package US_05_cansu;

import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class US_05_pom extends BaseDriver {
    @Test
    public void US_05_Cansu_HediyeSiparis() {
        elementler e=new elementler();
        driver.get("https://demo.nopcommerce.com/");
        e.giftCard.click();
        e.randomPhysicalGift().click();
        e.addToChartButton.click();

        SoftAssert _softAssert = new SoftAssert();
        _softAssert.assertTrue(e.warningMessg.getText().contains("Enter valid"),"Zorunlu alanları doldurmadan ilerledi.");
        _softAssert.assertAll();

        e.closeWarningMessg.click(); //esc ile olmyor manuel denedım
        e.recipName.sendKeys("iris");
        e.senderName.sendKeys("faruk");
        e.addMessage.sendKeys("luvG");
        e.addToChartButton.click();

        Assert.assertTrue(e.positiveMessg.getText().contains("added"),"ürün eklenmedi!");
    }
}
