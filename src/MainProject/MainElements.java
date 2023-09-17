package MainProject;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class MainElements  {

    public MainElements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(linkText="Wish List")
    public WebElement wishListLink;

    @FindBy(xpath="//td[@class='text-left']/a")
    public List<WebElement> wishList;




}
