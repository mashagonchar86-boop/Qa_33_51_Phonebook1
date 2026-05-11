package tests;

import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setApp(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }

}
