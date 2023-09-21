package US_01_Ihs;

import US_01_Ihs.US_01_POM;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_01_POM extends BaseDriver {

    @Test
    public void US_01_Ihsan_register() {

        US_01_Element e=new US_01_Element();

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

        e.email.sendKeys("t.ten.techno@gmail.com");
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

}
