package US_04_Ihs_Computer;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class US_04_Ihs_ComputerPOM extends BaseDriver {

    @Test
    @Parameters("searchComputer")
    public void US_04_02_tabMenuComputer(String aranan) {

        US_04_Ihs_ComputerElement e= new US_04_Ihs_ComputerElement();

        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);

        e.computers.click();
        MyFunc.Wait(2);

        e.desktop.click();
        MyFunc.Wait(2);

        List<WebElement> desktopElements = driver.findElements(By.xpath("//h2[@class='product-title']"));

        boolean arananBulundu = false;
        String arananDesktop = "Lenovo IdeaCentre";

        for (WebElement dsktp : desktopElements ) {
            String deskText = dsktp.getText();
            if (deskText.contains(arananDesktop)) {
                arananBulundu = true;
                break;
            }
        }

        e.searchBox.sendKeys(aranan + Keys.ENTER);
        MyFunc.Wait(2);

        e.searchBtn.click();
        MyFunc.Wait(2);

        Assert.assertTrue(arananBulundu, "Aranan bilgisayar listede yok");
    }



}
