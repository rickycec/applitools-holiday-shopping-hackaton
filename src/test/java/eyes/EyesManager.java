package eyes;

import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.services.RunnerOptions;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Manage all the access to the Eyes SDK
 */
public class EyesManager {

    private final Eyes eyes;
    private final WebDriver driver;

    public EyesManager(WebDriver driver, Configuration configuration) {
        this.driver = driver;
        configuration.setApiKey(System.getProperty("applitools.api.key"));
        var runner = new VisualGridRunner(new RunnerOptions().testConcurrency(10));
        eyes = new Eyes(runner);
        eyes.setConfiguration(configuration);
    }

    /**
     * @param testName The name of the test to supply to the Eyes SDK
     * @return A wrapper for the webdriver to be used in the tests
     */
    public WebDriver open(String testName) {
        return eyes.open(this.driver, eyes.getAppName(), testName);
    }

    /**
     * Abort the eyes session if it hasn't been already closed
     */
    public void abort() {
        eyes.abortIfNotClosed();
    }

    public void validateWindow(String stepName) {
        eyes.checkWindow(stepName);
        eyes.closeAsync();
    }

    public void validateRegion(By locator, String stepName) {
        eyes.checkRegion(locator, stepName);
        eyes.closeAsync();
    }
}
