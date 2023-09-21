package MainProject;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class MainElements  {

    public MainElements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//a[text()='Register']")
    public WebElement register;

    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
    public WebElement dateOfBirthDDM;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']//option[contains(text(),'5')]")
    public WebElement dateOfBirth;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement monthOfBirthDDM;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']//option[contains(text(),'May')]")
    public WebElement monthOfBirth;

    @FindBy(name = "DateOfBirthYear")
    public WebElement yearOfBirthDDM;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']//option[contains(text(),'1995')]")
    public WebElement yearOfBirth;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(id = "register-button")
    public WebElement registerBtn;

    @FindBy(id="Email")
    public WebElement emailInput;

    @FindBy(id="Password")
    public WebElement passwordInput;

    @FindBy(css="[class='ico-login']")
    public WebElement login;

    @FindBy(css="[class='button-1 login-button']")
    public  WebElement button;

    @FindBy(xpath = "//a[text()='Log out']")
    public WebElement loginoldumu;

    @FindBy (css = "a[class='ico-login']")
    public WebElement loginMain;

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

    @FindBy(xpath = "(//a[contains(text(),'Computers')])[1]")
    public WebElement computers;

    @FindBy(xpath = "//a[contains(text(),' Desktops ')]")
    public WebElement desktop;

    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement searchBtn;

    @FindBy(xpath = "(//a[@href='/gift-cards'])[1]")
    public WebElement giftCard;

    @FindBy(xpath = "//div[@class='products-container']")
    public WebElement giftSection;

    public WebElement randomPhysicalGift() {

        List<WebElement> randomGift = giftSection.findElements(By.xpath("//h2[@class='product-title']//a[contains(text(),'Physical')]"));  //yanı bu 6 tane - her bırını sectırmıs
        int randomIndex = new Random().nextInt(randomGift.size());

        return randomGift.get(randomIndex);
    }

    @FindBy(xpath = "//button[text()='Add to cart']")
    public WebElement addToChartButton;

    @FindBy(xpath = "(//p[@class='content'])[1]")
    public WebElement warningMessg;

    @FindBy(xpath = "//span[@class='close']")
    public WebElement closeWarningMessg;

    @FindBy(xpath = "//input[@class='recipient-name']")
    public WebElement recipName;

    @FindBy(xpath = "//input[@class='sender-name']")
    public WebElement senderName;

    @FindBy(xpath = "//textarea[@class='message']")
    public WebElement addMessage;

    @FindBy(xpath = "//p[text()='The product has been added to your ']")
    public WebElement positiveMessg;

    @FindBy(xpath = "(//ul[@class='top-menu notmobile']/li)[2]")
    public WebElement electronicButton;

    @FindBy(xpath = "(//ul[@class='sublist first-level'])[2]//a")
    public List<WebElement> electronicInList;

    @FindBy(xpath = "(//div[@class='item-grid'])//h2[@class='product-title']")
    public List<WebElement> items;

    @FindBy(xpath = "(//a[@href='/build-your-own-computer'] | //div[@class='item-box'])[3]")
    public WebElement customComputer;

    @FindBy(name = "product_attribute_1")
    public WebElement processorList;

    @FindBy(name = "product_attribute_2")
    public WebElement ramList;

    @FindBy(xpath = "//label[contains(text(),'HDD')]")
    public WebElement hddList;

    @FindBy(xpath = "//label[contains(text(),'OS')]")
    public WebElement osList;

    @FindBy(xpath = "//label[contains(text(),'Software')]")
    public WebElement softwareList;

    @FindBy(id = "add-to-cart-button-1")
    public WebElement addToCart;

    public WebElement getRandomProcessor() {

        List<WebElement> locationElements =
                processorList.findElements
                        (By.xpath("//dd[@id='product_attribute_input_1']//option[not(@value='0')]"));
        int randomIndex = new Random().nextInt(locationElements.size());

        return locationElements.get(randomIndex);
    }

    public WebElement getRandomRam() {

        List<WebElement> locationElements =
                ramList.findElements
                        (By.xpath("//dd[@id='product_attribute_input_2']//option[not(@value='0')]"));
        int randomIndex = new Random().nextInt(locationElements.size());

        return locationElements.get(randomIndex);
    }

    public WebElement getRandomHDD() {

        List<WebElement> locationElements =
                hddList.findElements
                        (By.xpath("//input[@name='product_attribute_3']"));
        int randomIndex = new Random().nextInt(locationElements.size());

        return locationElements.get(randomIndex);
    }

    public WebElement osRandomHDD() {

        List<WebElement> locationElements =
                osList.findElements
                        (By.xpath("//dd[@id='product_attribute_input_4']//li"));
        int randomIndex = new Random().nextInt(locationElements.size());

        return locationElements.get(randomIndex);
    }

    public WebElement softwareRandomHDD() {

        List<WebElement> locationElements =
                softwareList.findElements
                        (By.xpath("//dd[@id='product_attribute_input_5']//li"));
        int randomIndex = new Random().nextInt(locationElements.size());

        return locationElements.get(randomIndex);
    }

    @FindBy(css = "[id='small-searchterms']")

    public WebElement searchInputBox;


    @FindBy(xpath = "//a[text()='Adobe Photoshop CS4']")

    public WebElement productTitle;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[text()='Books ']")
    public WebElement books;

    @FindBy (xpath = "//h2[@class='product-title']")
    public List<WebElement> booksItems;



}
