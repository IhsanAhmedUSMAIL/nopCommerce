package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {

    public WebDriver driver; //static i silince 1 den fazla driver ile işlem yapıyor
    public static WebDriverWait wait;
    @BeforeClass
    @Parameters ("browserTipi")
    public void baslangicIslemleri(String secilenBrowser){

        Logger logger = Logger.getLogger(""); // output yapılan tüm logları al
        logger.setLevel(Level.SEVERE); // sadece errorları gosterir

        switch (secilenBrowser.toLowerCase()){
            case "firefox" : driver=new FirefoxDriver(); break;
            case "edge" : driver=new EdgeDriver(); break;
            case "safari" : driver=new SafariDriver(); break;
            default: driver=new ChromeDriver(); break; // jenkins deyken : sen head olmadan yani hafızada çalış
        }

        //   driver.manage().window().maximize(); //tam ekran yapar
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        loginTesti();
    }

    public void loginTesti(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        MyFunc.Wait(1);
        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys("cek@gmail.com");
        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("far123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        Assert.assertTrue(driver.getTitle().equals("My Account"));


    }
    @AfterClass
    public void bitisIslemleri(){ //tearDown diyorlar genel olarak ingilizcede
        MyFunc.Wait(2);
        driver.quit();
    }


}
