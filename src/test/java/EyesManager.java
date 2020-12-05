import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;

/**
 *Manage all the access to Eyes SDK
 */
public class EyesManager {

    private Eyes eyes;
    private WebDriver driver;
    private Configuration configuration;

    public EyesManager(WebDriver driver, Configuration configuration) {
        this.driver = driver;
        this.configuration = configuration;
        this.configuration.setApiKey(System.getProperty("applitools.api.key"));

        eyes = new Eyes();
        eyes.setConfiguration(configuration);
    }

    public void abort() {
        eyes.abortIfNotClosed();
    }

    public void validateWindow(String testName, String stepName) {
        eyes.open(driver, eyes.getAppName(), testName);
        eyes.checkWindow(stepName);
        eyes.close();
    }
}
