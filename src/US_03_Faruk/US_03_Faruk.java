package US_03_Faruk;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class US_03_Faruk extends BaseDriver {
    /*
   cek@gmail.com
   far123
- Kullanıcı, web sitesinin başlangıç sayfasında "Login" butonuna tıklayarak giriş sayfasına erişebilmelidir.
- Giriş sayfasında, kullanıcıdan aşağıdaki bilgileri girmesi istenmelidir:
- E-posta Adresi (Email) , Şifre (Password)
- Kullanıcı, veri sağlayıcı (data provider) yöntemi kullanarak önce 6 geçersiz e-posta ve şifre kombinasyonuyla giriş yapmayı denemelidir.
- Kullanıcı, geçersiz giriş denemeleri sırasında sistemden uyarı almalıdır.
- Ardından, veri sağlayıcı (data provider) tarafından sağlanan geçerli e-posta ve şifre kombinasyonuyla "LOGIN" düğmesine tıklayarak bu sefer başarılı bir şekilde giriş yapabilmelidir.
- Giriş işlemi sonucunda kullanıcının başarılı bir şekilde giriş yapıp yapmadığı doğrulanmalıdır.
*/
    @Test(dataProvider = "loginVerileri")
    public void US_03_Faruk_loginKombinasyon(String email, String password) {

        Elementlerim e = new Elementlerim();
        driver.get("https://demo.nopcommerce.com/");
        e.loginMain.click();
        MyFunc.Wait(1);
        e.emailInput.clear();
        e.passwordInput.clear();
        e.emailInput.sendKeys(email);
        e.passwordInput.sendKeys(password);
        MyFunc.Wait(1);
        e.loginButton.click();
        MyFunc.Wait(1);
        String basariliUrl = "https://demo.nopcommerce.com/";
        SoftAssert _softAssert = new SoftAssert();

        if (driver.getCurrentUrl().equals(basariliUrl)){
            wait.until(ExpectedConditions.elementToBeClickable(e.myAccountButton));
            _softAssert.assertTrue(e.myAccountButton.getText().toLowerCase().contains("account"), "Giriş işlemi başarısız");
        }
        else {
            wait.until(ExpectedConditions.visibilityOf(e.loginHataMsg));
            _softAssert.assertTrue(e.loginHataMsg.getText().toLowerCase().contains("error"),"Hatalı bilgiler yazarak giriş yapıldı");
        }
        _softAssert.assertAll();
    }

    @DataProvider
    public Object [][] loginVerileri (){
        Object [][] data = {
                {"gathr@gmail.com","0f0dsf"},
                {"werr@tmail.com","0a0dsf"},
                {"123pwerwe@gmail.com","4894"},
                {"sadas@hotmail.com","asd4564"},
                {"adsaasd@tsdf.com","asd561"},
                {"16498498@ewge.com","8wer@gmail.com"},
                {"cek@gmail.com","far123"}
        };
        return data;
    }
}
