import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.web.selenium.RecheckDriver;
//import de.retest.web.selenium.By;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

public class UnbreakableSeleniumTest {
//    public WebDriver driver;
//    public Recheck recheck;
    RecheckDriver driver;

    @BeforeEach
    public void setupRecheck() {
//        recheck = new RecheckImpl();
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
        driver = new RecheckDriver(new ChromeDriver());
    }

    @Test
    public void unBreakableTest() throws Exception {
//        recheck.startTest();
        String url = Paths.get("src/test/resources/loginpage.html").toUri().toURL().toString();
        driver.get(url);
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("dev");
        driver.findElement(By.id("login-form-submit")).click();
//        driver.findElement(By.retestId("usernamefield")).sendKeys("user");
//        driver.findElement(By.retestId("passwordfield")).sendKeys("dev");
//        driver.findElement(By.retestId("loginformsubmit")).click();
//        recheck.check(driver,"Login Page");
//        recheck.capTest();
    }

    @AfterEach
    public void windUp(){
        driver.quit();
//        recheck.cap();
    }
}
