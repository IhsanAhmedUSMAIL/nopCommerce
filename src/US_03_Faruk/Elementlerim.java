package US_03_Faruk;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Elementlerim {
    public Elementlerim() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy (css = "a[class='ico-login']")
    public WebElement loginMain;

    @FindBy (id = "Email")
    public WebElement emailInput;

    @FindBy (id = "Password")
    public WebElement passwordInput;

    @FindBy (css = "button[class='button-1 login-button']")
    public WebElement loginButton;

    @FindBy (css = "div[class='message-error validation-summary-errors']")
    public WebElement loginHataMsg;

    @FindBy (css = "a[class='ico-account']")
    public WebElement myAccountButton;

    @FindBy (css = "ul[class='top-menu notmobile']>li")
    public List<WebElement> tabMenuAnaBasliklar;

    @FindBy (css = "div[class='sub-category-item']")
    public List<WebElement> altMenuler;

    @FindBy (xpath = "(//ul[@class='top-menu notmobile']/li)[3]")
    public WebElement apparelButton;

    @FindBy (xpath = "(//ul[@class='top-menu notmobile']/li)[3]//li")
    public List<WebElement> apparelAltBasliklar;

    @FindBy (id = "small-searchterms")
    public WebElement searchInput;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy (xpath = "//h2[@class='product-title']")
    public WebElement aramaSonucu;





}
