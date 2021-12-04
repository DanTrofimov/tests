package org.example.tests.base;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.AppManager;
import org.example.config.Config;
import org.example.helpers.FindItemsHelper;
import org.example.helpers.LoginHelper;
import org.example.helpers.NavigationHelper;
import org.example.helpers.TodoHelper;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestBase {
    protected static AppManager appManager;
    protected NavigationHelper navigationHelper;
    protected LoginHelper loginHelper;
    protected TodoHelper todoHelper;
    protected FindItemsHelper findItemsHelper;
    protected static Config config;

    static {
        appManager = new AppManager();
        config = TestBase.getCfg();
    };

    public void setUp() {
        this.navigationHelper = appManager.getNavigationHelper();
        this.loginHelper = appManager.getLoginHelper();
        this.todoHelper = appManager.getTodoHelper();
        this.findItemsHelper = appManager.getFindItemsHelper();
    };

    public static Config getCfg()  {
        try {
            String xml = new String(Files.readAllBytes(Paths.get("src/test/java/org/example/config/settings.xml")));
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(xml, Config.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean hasItemByText(String text) {
        return this.findItemsHelper.hasElementByText(text);
    }

    public String getCurrentUrl() {
        return this.navigationHelper.getCurrentUrl();
    }

    public void destruct() {
        appManager.destruct();
    }
}
