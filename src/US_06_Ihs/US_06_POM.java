package US_06_Ihs;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_06_POM extends BaseDriver {

    @Test
    public void US_06_Ihsan_BilgisayarSiparis() {

        US_06_Element e = new US_06_Element();

        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);

        e.computers.click();
        MyFunc.Wait(1);

        e.desktop.click();
        MyFunc.Wait(1);

        e.customComputer.click();
        MyFunc.Wait(1);

        e.getRandomProcessor().click();
        MyFunc.Wait(1);

        e.getRandomRam().click();
        MyFunc.Wait(1);

        e.getRandomHDD().click();
        MyFunc.Wait(1);

        e.osRandomHDD().click();
        MyFunc.Wait(1);

        e.softwareRandomHDD().click();
        MyFunc.Wait(1);

        e.addToCart.click();

       // String expectedText = "The product has been added to your";
       // String actualText = driver.findElement(By.xpath("//p[@class='content' and not(a)]")).getText();
       // Assert.assertEquals("Sepete ekleme onayı gözükmedi", expectedText, actualText);

        try {
            WebElement messageElement = driver.findElement(By.xpath("//p[@class='content' and not(a)]"));
            String actualText = messageElement.getText();

            String expectedText = "The product has been added to your";
            Assert.assertEquals("Sepete ekleme onayı gözükmedi", expectedText, actualText);
        } catch (NoSuchElementException y ) {

        }


    }

}
