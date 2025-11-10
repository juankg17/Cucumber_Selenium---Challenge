package seleniumgluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import runner.broser_manager.DriverManager;
import runner.broser_manager.DriverManagerFactory;
import runner.broser_manager.DriverType;

import java.io.File;

public class Hooks {

    private static WebDriver driver;
    private DriverManager driverManager;

    @Before
    public void setUp(){
        driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
        driver = driverManager.getDriver();
        String filePath = new File("./src/test/resources/form/Prueba.html").getAbsolutePath();
        driver.get(filePath);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driverManager.quitDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
