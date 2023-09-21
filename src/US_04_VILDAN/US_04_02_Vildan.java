package US_04_VILDAN;

import US_07_VILDAN.VildanElements;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class US_04_02_Vildan extends BaseDriver {

    @Test
    @Parameters("searchBooks")

    public void searchBooks(String aranan){
        VildanElements e = new VildanElements();

        driver.get("https://demo.nopcommerce.com/");

        MyFunc.Wait(2);

        e.books.click();



        List<String> productList = new ArrayList<>();
        for(WebElement b: e.booksItems){
            productList.add(b.getText());
        }

       e.searchInputBox.click();
        e.searchInputBox.sendKeys(aranan+ Keys.ENTER);

        Assert.assertTrue(productList.contains(aranan),"Aranan kitap bulunamadi");
















    }
}
