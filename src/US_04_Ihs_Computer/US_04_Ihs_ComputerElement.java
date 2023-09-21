package US_04_Ihs_Computer;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_04_Ihs_ComputerElement {
    public US_04_Ihs_ComputerElement () {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "(//a[contains(text(),'Computers')])[1]")
    public WebElement computers;

    @FindBy(xpath = "//a[contains(text(),' Desktops ')]")
    public WebElement desktop;

    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement searchBtn;

}
