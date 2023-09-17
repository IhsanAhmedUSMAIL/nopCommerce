package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    public void baslangicIslemleri(){


        Logger logger = Logger.getLogger(""); // output yapılan tüm logları al
        logger.setLevel(Level.SEVERE); // sadece errorları gosterir

        driver = new ChromeDriver(); //jendkinste sen head olmadan yeni hafızada calıs diyecez
        driver.manage().window().maximize(); //tam ekran yapar
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

     @AfterClass
    public void bitisIslemleri(){ //tearDown diyorlar genel olarak ingilizcede

        MyFunc.Wait(2);
        driver.quit();
    }


}
