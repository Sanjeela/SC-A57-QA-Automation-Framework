import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class BaseTest {

    @DataProvider(name="LoginData")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"demo@class.com","te$t$tudent"},
                {"Invalid@class.com","te$t$tudent"},
                {"demo@class.com","Invalidpassword"},
                {"",""}
        };
    }

    public WebDriver driver;

    public WebDriverWait wait;

    public String url ="https://qa.koel.app/";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        navigateToLoginPage(BaseURL);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void navigateToLoginPage(){
        String url = "https://qa.koel.app/";
        driver.get(url);

    }
    public void navigateToLoginPage(String BaseURL) {
        String url = "https://qa.koel.app/";
        driver.get(BaseURL);
    }

        public void provideEmail(String email){
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void providePassword(String password){
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        // WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public void clickSubmit(){
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

    }
}