package US_02;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_02_POM extends BaseDriver {
    @Test
    public void US_02_Ethem_login()
    {
        US_02_Element us2=new US_02_Element();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);

        us2.login.click();
        MyFunc.Wait(2);

        us2.emailInput.sendKeys("t.ten.techno@gmail.com");
        MyFunc.Wait(1);

        us2.passwordInput.sendKeys("TTtechno10");
        MyFunc.Wait(2);

        us2.button.click();

        Assert.assertTrue(us2.loginoldumu.isDisplayed(), "Log in işlemi başarısız");

    }

}
