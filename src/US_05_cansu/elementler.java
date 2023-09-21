package US_05_cansu;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class elementler {
    public elementler() {
        PageFactory.initElements(BaseDriver.driver, this);
    }


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



//    @FindBy(xpath = "//p[text()='The product has been added to your ']")
//    public WebElement positiveMessg;
//
//    @FindBy(xpath = "//p[text()='The product has been added to your ']")
//    public WebElement positiveMessg;
//
//    @FindBy(xpath = "//p[text()='The product has been added to your ']")
//    public WebElement positiveMessg;
//


}









