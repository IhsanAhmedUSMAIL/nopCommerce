package US_07_VILDAN;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VildanElements {


public  VildanElements() {PageFactory.initElements(BaseDriver.driver,this);}



//    @FindBy(id = "Email")
//    public WebElement email;
//
//    @FindBy(id="Password")
//    public WebElement password;
//
//    @FindBy(xpath = "//button[text()='Log in']")
//    WebElement logInBtn;

    @FindBy(css = "[id='small-searchterms']")

   public WebElement searchInputBox;


    @FindBy(xpath = "//a[text()='Adobe Photoshop CS4']")

    public WebElement productTitle;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[text()='Books ']")
    public WebElement books;

@FindBy (xpath = "//h2[@class='product-title']")
    public List<WebElement> booksItems;


}
