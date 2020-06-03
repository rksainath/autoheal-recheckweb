import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.file.Paths;

public class SeleniumTest {
    public WebDriver driver;

    @BeforeEach
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void breakableTest() throws Exception {
        String url = Paths.get("src/test/resources/loginpage.html").toUri().toURL().toString();
        driver.get(url);
        driver.findElement(By.id("username-field")).sendKeys("user");
        driver.findElement(By.id("password-field")).sendKeys("dev");
        driver.findElement(By.id("login-form-submit")).click();

        String result = driver.findElement(By.id("login-success-msg")).getText().equals("You have successfully logged in") ? "Login Pass" : "Login Fail";
        System.out.println(result);
    }

    @AfterEach
    public void windUp(){
        driver.quit();
    }
}
