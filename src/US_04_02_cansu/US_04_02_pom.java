package US_04_02_cansu;
import US_05_cansu.elementler;
import Utility.BaseDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class US_04_02_pom extends BaseDriver {

    @Test
    @Parameters("searchElectronics")
    public void US_04_02_tabMenuElectronics(String aranan){
        elementler e=new elementler();
        driver.get("https://demo.nopcommerce.com/");
        Actions action = new Actions(driver);
        action.moveToElement(e.electronicButton).build().perform();

        List<String> itemsList= new ArrayList<>();

        for (int i = 0 ; i <e.electronicInList.size() ; i++) {
            e.electronicInList.get(i).click();

            for (int j = 0; j <e.items.size() ; j++) {
                itemsList.add(e.items.get(j).getText());
                action.moveToElement(e.electronicButton).build().perform();
            }
        }
        String strItemsList = itemsList.toString();
        Assert.assertTrue(itemsList.contains(aranan),"aranan ürün elektronik listesinde yok.");
    }
}
