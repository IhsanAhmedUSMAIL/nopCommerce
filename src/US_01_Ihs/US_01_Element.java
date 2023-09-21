package US_01_Ihs;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_01_Element {

    public US_01_Element () {
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


}
