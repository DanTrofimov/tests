package org.example.helpers;
import org.example.AppManager;
import org.openqa.selenium.By;

public class FindItemsHelper extends HelperBase {

    public FindItemsHelper(AppManager appManager) {
        this.appManager = appManager;
        this.driver = appManager.getDriver();
    }

    public boolean hasElementByText(String text) {
        try {
            driver.findElement(By.xpath("//*[text()='" + text + "']"));
        } catch (Exception ex) {
            return false;
        }

        return true;
    }
}
