package US_02;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_02_Element {
    public US_02_Element(){PageFactory.initElements(BaseDriver.driver,this);}

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

}
