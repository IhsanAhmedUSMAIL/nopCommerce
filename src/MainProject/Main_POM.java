package MainProject;

import Utility.BaseDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Main_POM extends BaseDriver{

    Main_POM e= new Main_POM();

    //register verileri
    //- İsim (First Name): Team Ten
    //- Soyisim (Last Name): TechnoTeam10
    //- Doğum Tarihi (Date of Birth): 5 Mayıs 1995
    //- E-posta Adresi (Email): t.ten.techno@gmail.com
    //- Şifre (Password): TTtechno10

    @Test()
    public void US_01_Ihsan_register() {



    }

    @Test()
    public void US_02_Ethem_login() {

    }

    @Test()
    public void US_03_Faruk_loginKombinasyon() {


    }


    @Test()
    public void US_04_01_Faruk_tabMenuKontrol() {

    }

    @Test()
    @Parameters("searchComputer")
    public void US_04_02_tabMenuComputer(String aranan) {

    }

    @Test()
    @Parameters("searchElectronics")
    public void US_04_02_tabMenuElectronics(String aranan) {

    }

    @Test()
    @Parameters("searchApparel")
    public void US_04_02_tabMenuApparel(String aranan) {

    }

    @Test()
    @Parameters("searchBooks")
    public void US_04_02_tabMenuBooks(String aranan) {


    }


    @Test()
    public void US_05_Cansu_HediyeSiparis() {

    }


    @Test()
    public void US_06_Ihsan_BilgisayarSiparis() {

    }



    @Test()
    @Parameters("searchText")
    public void US_07_Vildan_ParametreliArama(String aranacakkelime) {

        //driver.findElement(By.name("search"));
        //searchBox.sendKeys(aranacakKelime + Keys.ENTER);

    }

}
