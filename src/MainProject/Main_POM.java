package MainProject;

import Utility.BaseDriver;
import org.openqa.selenium.support.PageFactory;

public class Main_POM {
    public Main_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }




}
