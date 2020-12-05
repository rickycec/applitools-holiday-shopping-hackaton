import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.services.RunnerOptions;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
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
        var runner = new VisualGridRunner(new RunnerOptions().testConcurrency(10));
        eyes = new Eyes(runner);
        eyes.setConfiguration(configuration);
    }

    public WebDriver open(String testName) {
        return eyes.open(driver, eyes.getAppName(), testName);
    }

    public void abort() {
        eyes.abortIfNotClosed();
    }

    public void validateWindow(String stepName) {
        eyes.checkWindow(stepName);
        eyes.close();
    }
}
