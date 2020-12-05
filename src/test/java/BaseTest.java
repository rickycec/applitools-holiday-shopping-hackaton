import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    static WebDriver driver;
    static EyesManager eyesManager;

    @BeforeAll
    public static void setUp() {
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("src/test/resources/test.properties")));
        } catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }

        driver = new EdgeDriver();
        eyesManager = new EyesManager();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        eyesManager.abort();
    }

}
