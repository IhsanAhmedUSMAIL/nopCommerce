package US_06_Ihs;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

import static Utility.BaseDriver.driver;

public class US_06_Element {

    public US_06_Element () {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[contains(text(),'Computers')])[1]")
    public WebElement computers;

    @FindBy(xpath = "//a[contains(text(),' Desktops ')]")
    public WebElement desktop;

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



}
