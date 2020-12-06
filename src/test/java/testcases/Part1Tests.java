package testcases;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.visualgrid.model.DesktopBrowserInfo;
import eyes.EyesManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pom.MainPage;
import static utils.TestConsts.urlV1;

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
        d.get(urlV1);

        eyesManager.validateWindow("main page");
    }

    @DisplayName("Test 2")
    @Test
    public void filterVerification() {
        d.get(urlV1);

        var mainPage = new MainPage(d);
        mainPage.filterByBlack();
        eyesManager.validateRegion(mainPage.getShoesGridLocator(), "filter by color");
    }

    @DisplayName("Test 3")
    @Test
    public void detailPageVerification() {
        d.get(urlV1);

        var mainPage = new MainPage(d);
        var ProductDetailPage = mainPage.selectProductByName("Appli Air x Night");
        eyesManager.validateWindow("product details");
    }

    @AfterEach
    public void abortEyes() {
        eyesManager.abort();
    }

}
