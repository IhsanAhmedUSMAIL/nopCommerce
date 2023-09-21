package MainProject;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class Main_POM extends BaseDriver {

    MainElements e = new MainElements();

    //register verileri
    //- İsim (First Name): Team Ten
    //- Soyisim (Last Name): TechnoTeam10
    //- Doğum Tarihi (Date of Birth): 5 Mayıs 1995
    //- E-posta Adresi (Email): t.ten.techno@gmail.com
    //- Şifre (Password): TTtechno10

    @Test(priority = 1)
    public void US_01_Ihsan_register() {

        MainElements e = new MainElements();

        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);

        e.register.click();
        MyFunc.Wait(1);

        e.firstName.sendKeys("Team Ten");
        MyFunc.Wait(1);

        e.lastName.sendKeys("TechnoTeam10");
        MyFunc.Wait(1);

        e.dateOfBirthDDM.click();
        MyFunc.Wait(1);

        e.dateOfBirth.click();
        MyFunc.Wait(1);

        e.monthOfBirthDDM.click();
        MyFunc.Wait(1);

        e.monthOfBirth.click();
        MyFunc.Wait(1);

        e.yearOfBirthDDM.click();
        MyFunc.Wait(1);

        e.yearOfBirth.click();
        MyFunc.Wait(1);

        e.email.sendKeys("t.te3.techno@gmail.com");
        MyFunc.Wait(1);

        e.password.sendKeys("TTtechno10");
        MyFunc.Wait(1);

        e.confirmPassword.sendKeys("TTtechno10");
        MyFunc.Wait(1);

        e.registerBtn.click();
        MyFunc.Wait(1);

        String expectedText = "Your registration completed";

        String actualText = driver.findElement(By.className("result")).getText();

        Assert.assertEquals(actualText, expectedText, "Kayıt onay bildirimi gözükmedi");

    }

    @Test(priority = 2)
    public void US_02_Ethem_login() {

        MainElements e = new MainElements();

        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);

        e.login.click();
        MyFunc.Wait(2);

        e.emailInput.sendKeys("t.te3.techno@gmail.com");
        MyFunc.Wait(1);

        e.passwordInput.sendKeys("TTtechno10");
        MyFunc.Wait(2);

        e.button.click();

        Assert.assertTrue(e.loginoldumu.isDisplayed(), "Log in işlemi başarısız");

        e.loginoldumu.click();

    }

    @Test( dataProvider = "loginVerileri", priority = 3)
    public void US_03_Faruk_loginKombinasyon(String email, String password) {

        MainElements e = new MainElements();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);
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

        if (driver.getCurrentUrl().equals(basariliUrl)) {
            wait.until(ExpectedConditions.elementToBeClickable(e.myAccountButton));
            _softAssert.assertTrue(e.myAccountButton.getText().toLowerCase().contains("account"), "Giriş işlemi başarısız");
        } else {
            wait.until(ExpectedConditions.visibilityOf(e.loginHataMsg));
            _softAssert.assertTrue(e.loginHataMsg.getText().toLowerCase().contains("error"), "Hatalı bilgiler yazarak giriş yapıldı");
        }
        _softAssert.assertAll();
    }

    @DataProvider
    public Object[][] loginVerileri() {
        Object[][] data = {
                {"gathr@gmail.com", "0f0dsf"},
                {"werr@tmail.com", "0a0dsf"},
                {"123pwerwe@gmail.com", "4894"},
                {"sadas@hotmail.com", "asd4564"},
                {"adsaasd@tsdf.com", "asd561"},
                {"16498498@ewge.com", "8wer@gmail.com"},
                {"cek@gmail.com", "far123"}
        };
        return data;
    }


    @Test(priority = 6)
    public void US_04_01_Faruk_tabMenuKontrol() {

        MainElements e = new MainElements();

        driver.navigate().to("https://demo.nopcommerce.com/");
        Actions actDrive = new Actions(driver);
        Assert.assertEquals(e.tabMenuAnaBasliklar.size(), 7, "Ana başlıkta eksik kategori");
        for (int i = 0; i < 3; i++) {
            String elementText = e.tabMenuAnaBasliklar.get(i).getText().toLowerCase().replaceAll("[^a-z]", "");
            actDrive.moveToElement(e.tabMenuAnaBasliklar.get(i)).build().perform();
            e.tabMenuAnaBasliklar.get(i).click();
            String mevcutUrl = driver.getCurrentUrl();
            Assert.assertTrue(mevcutUrl.contains(elementText), "Hatalı ana başlık sayfası");
            for (int j = 0; j < e.altMenuler.size(); j++) {
                String altMenuText = e.altMenuler.get(j).getText().toLowerCase().replaceAll("[^a-z]", "");
                e.altMenuler.get(j).click();
                MyFunc.Wait(1);
                String yeniUrl = driver.getCurrentUrl().replaceAll("[^a-z]", "");
                Assert.assertTrue(yeniUrl.contains(altMenuText), "Hatalı ürün sayfasına yönlendirildi");
                driver.navigate().back();
            }
        }
        driver.navigate().to("https://demo.nopcommerce.com/");
        for (int i = 3; i < e.tabMenuAnaBasliklar.size(); i++) {
            String elementText = e.tabMenuAnaBasliklar.get(i).getText().toLowerCase().replaceAll("[^a-z]", "");
            actDrive.moveToElement(e.tabMenuAnaBasliklar.get(i)).build().perform();
            e.tabMenuAnaBasliklar.get(i).click();
            String mevcutUrl = driver.getCurrentUrl().replaceAll("[^a-z]", "");
            Assert.assertTrue(mevcutUrl.contains(elementText), "Hatalı ana başlık sayfası");
            driver.navigate().back();
        }

    }

    @Test(priority = 11)
    @Parameters("searchComputer")
    public void US_04_02_tabMenuComputer(String aranan) {

        MainElements e = new MainElements();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);

        e.computers.click();
        MyFunc.Wait(2);

        e.desktop.click();
        MyFunc.Wait(2);

        List<WebElement> desktopElements = driver.findElements(By.xpath("//h2[@class='product-title']"));

        boolean arananBulundu = false;
        String arananDesktop = "Lenovo IdeaCentre";

        for (WebElement dsktp : desktopElements) {
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

    @Test(priority = 4)
    @Parameters("searchElectronics")
    public void US_04_02_tabMenuElectronics(String aranan)
   // public void US_04_02_tabMenuElectronics()
    {

        MainElements e=new MainElements();

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
    Assert.assertTrue(strItemsList.contains(aranan),"aranan ürün elektronik listesinde yok.");

    }

    @Test(priority = 7)
    @Parameters("searchApparel")
    public void US_04_02_tabMenuApparel(String aranan) {

        MainElements e=new MainElements();

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

    @Test(priority = 8)
    @Parameters("searchBooks")
    public void US_04_02_tabMenuBooks(String aranan) {

        MainElements e=new MainElements();

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


    @Test(priority = 9)
    public void US_05_Cansu_HediyeSiparis() {

        MainElements e=new MainElements();

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


    @Test(priority = 10)
    public void US_06_Ihsan_BilgisayarSiparis() {

        MainElements e=new MainElements();

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

        try {
            WebElement messageElement = driver.findElement(By.xpath("//p[@class='content' and not(a)]"));
            String actualText = messageElement.getText();

            String expectedText = "The product has been added to your";
            Assert.assertEquals("Sepete ekleme onayı gözükmedi", expectedText, actualText);
        } catch (NoSuchElementException y ) {

        }

    }



    @Test(priority = 5)
    @Parameters("searchText")
    public void US_07_Vildan_ParametreliArama(String aranan) {

        MainElements e=new MainElements();

        driver.get("https://demo.nopcommerce.com/");

        MyFunc.Wait(2);


        e.searchInputBox.click();

        e.searchInputBox.sendKeys(aranan+Keys.ENTER);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", e.productTitle);

        Assert.assertTrue(e.productTitle.getText().contains("Adobe"),"Arama sonucu cikan urun, arama terimini icermiyor");


    }

}
