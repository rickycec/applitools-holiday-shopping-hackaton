package testcases;

import eyes.EyesManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.TestConsts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Base test class to manage activities related to all tests
 */
public class BaseTest {

    static WebDriver driver;
    static EyesManager eyesManager;

    @BeforeAll
    public static void setUp() {

        //Loading properties from test.properties file and then loading them into System properties
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File(TestConsts.propPath)));
        } catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }

        driver = new EdgeDriver();
    }

    @AfterAll
    public static void tearDown() {
        eyesManager.abort();
        driver.quit();
    }

}
