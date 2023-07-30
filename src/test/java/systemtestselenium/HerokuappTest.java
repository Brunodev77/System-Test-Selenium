package systemtestselenium;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HerokuappTest {

    WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");

        driver = new FirefoxDriver();
    }

    @Test
    public void loginTest() {
        driver.navigate().to("http://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");

        List<WebElement> elementName = driver.findElements(By.className("radius"));
        elementName.get(0).click();
        

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("The Internet"));

        assertTrue("Erro - Login não aceito.",driver.getCurrentUrl()
        .equals("http://the-internet.herokuapp.com/secure"));
    }

    @After
	public void closing() throws Exception{
		// Espera 5 segundos e fecha a janela do browser
	    Thread.sleep(5000);
		driver.quit();
	}

}
