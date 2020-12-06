package testcases;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.visualgrid.model.*;
import eyes.EyesManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pom.MainPage;

import static utils.TestConsts.urlV2;

/**
 * Tests for the Part 1 of the Applitools Holiday Shopping Hackathon
 */
public class Part3Tests extends BaseTest {

    //Setting up default viewport as 1200x800
    static final int viewportWidth = 1200;
    static final int viewportHeight = 800;
    WebDriver d;

    @BeforeAll
    public static void part1TestsSetUp() {
        var suiteConfig = new Configuration();
        suiteConfig
                .addBrowser(new DesktopBrowserInfo(viewportWidth, viewportHeight, BrowserType.CHROME))
                .addBrowser(new DesktopBrowserInfo(viewportWidth, viewportHeight, BrowserType.FIREFOX))
                .addBrowser(new DesktopBrowserInfo(viewportWidth, viewportHeight, BrowserType.EDGE_CHROMIUM))
                .addBrowser(new DesktopBrowserInfo(viewportWidth, viewportHeight, BrowserType.SAFARI))
                .addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_X))
                .setViewportSize(new RectangleSize(viewportWidth, viewportHeight))
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
        d.get(urlV2);
        eyesManager.validateWindow("main page");
    }

    @DisplayName("Test 2")
    @Test
    public void filterVerification() {
        d.get(urlV2);
        var mainPage = new MainPage(d);
        mainPage.filterByBlack();
        eyesManager.validateRegion(mainPage.getShoesGridLocator(), "filter by color");
    }

    @DisplayName("Test 3")
    @Test
    public void detailPageVerification() {
        d.get(urlV2);
        var mainPage = new MainPage(d);

        //If no element with the given name is present the test should fail
        try {
            mainPage.selectProductByName("Appli Air x Night");
        } catch (NoSuchElementException e) {
            Assertions.fail(e.getMessage());
        }
        eyesManager.validateWindow("product details");
    }

    /**
     * Abort eyes instance if the test ended but eyes hasn't been closed
     */
    @AfterEach
    public void abortEyes() {
        eyesManager.abort();
    }

}
