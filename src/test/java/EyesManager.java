import com.applitools.eyes.selenium.Eyes;

public class EyesManager {

    private Eyes eyes;

    public EyesManager() {
        eyes = new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));
    }

    public void abort() {
        eyes.abortIfNotClosed();
    }
}
