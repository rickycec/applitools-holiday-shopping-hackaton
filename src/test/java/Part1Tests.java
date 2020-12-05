import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.visualgrid.model.DesktopBrowserInfo;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class Part1Tests extends BaseTest {

    WebDriver d;

    @BeforeAll
    public static void part1TestsSetUp() {
        var suiteConfig = new Configuration();
        suiteConfig
                .addBrowser(new DesktopBrowserInfo(1200, 800, BrowserType.CHROME))
                .setViewportSize(new RectangleSize(1200, 800))
                .setAppName("AppliFashion")
                .setBatch(new BatchInfo("Holiday Shopping"));
        eyesManager = new EyesManager(driver, suiteConfig);
    }

    @BeforeEach
    public void setUpDriverInstance(TestInfo testInfo) {
        d = eyesManager.open(testInfo.getDisplayName());
    }

    @DisplayName("Test 1")
    @Test
    public void mainPageVerification() {
        d.get(TestConsts.urlV1);

        eyesManager.validateWindow("Main page");
    }

    @DisplayName("Test 2")
    @Test
    public void filterVerification() {

    }

    @DisplayName("Test 3")
    @Test
    public void detailPageVerification() {

    }

    @AfterEach
    public void teardownDriverInstance() {
        d.quit();
        eyesManager.abort();
    }

}
