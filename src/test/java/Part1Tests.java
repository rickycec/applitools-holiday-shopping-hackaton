import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.visualgrid.model.DesktopBrowserInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Part1Tests extends BaseTest {

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

    @Test
    public void mainPageVerification() {
        driver.get(TestConsts.urlV1);

        eyesManager.validateWindow("Test 1", "Main page");
    }

}
