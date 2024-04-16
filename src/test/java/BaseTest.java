import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
//Reference start here
    public static WebDriver driver;

    public WebDriverWait wait;

    public Actions actions;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadDriver.get();
    }


    //Reference End here


    @BeforeSuite
    static void setupClass() {
       // WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
      //  ChromeOptions options = new ChromeOptions();
       // options.addArguments("--remote-allow-origins=*");
      //  driver = new ChromeDriver(options);
       // driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(pickBrowser(System.getProperty("browser")));
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        actions=new Actions(driver);
        driver.manage().window().maximize();
        navigateToLoginPage(BaseURL);
    }

    @AfterMethod
   /* public void closeBrowser(){
        //driver.quit();
    }*/

    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }

    public void navigateToLoginPage(){
        String url = "https://qa.koel.app/";
        driver.get(url);

    }
    public void navigateToLoginPage(String BaseURL) {
        String url = "https://qa.koel.app/";
        driver.get(BaseURL);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = " http://192.168.0.28:4444";

        switch (browser) {

            case "grid-edge":
                caps.setCapability("browser", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud":
                return driver = lamdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);

        }
    }

    public WebDriver lamdaTest() throws MalformedURLException {
        String username = "sanjeela.chitrakar";
        String authKey = "ZUx1VlYo28ZZQgAqvnuLGmeTSWs7sEIELUaCX5eBV0ehIzG9Mw";
        String hub = "https://hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName","Chrome");
        caps.setCapability("browserVersion","124.0");

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "sanjeela.chitrakar");
        ltOptions.put("accessKey", "ZUx1VlYo28ZZQgAqvnuLGmeTSWs7sEIELUaCX5eBV0ehIzG9Mw");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        caps.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hub), caps);

    }


        public void provideEmail(String email){
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void providePassword(String password){
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public void clickSubmit(){
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();

    }
}