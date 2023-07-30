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

public class GoogleClickTest {

	WebDriver driver;
	
	@Before
	public void setUp(){
	  	// Indica onde está o driver do firefox
	  	System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() {
	    // instrui o driver para "navegar" pelo Google
	    driver.navigate().to("http://www.google.com");

	    // obtém um campo de entrada de dados, de nome "q"
	    WebElement element = driver.findElement(By.name("q"));

	    // preenche esse campo com as palavras "software"
	    element.sendKeys("software");

	    List<WebElement> elementName = driver.findElements(By.name("btnK"));
	    elementName.get(1).click();

	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.titleContains("software"));
	    
	    System.out.println("Título: " + driver.getTitle());

	    assertTrue("Erro - Página não retornou valor esperado.", driver.getTitle()
	    															.toLowerCase()
	    															.startsWith("software"));
	}



	// teste google deadles
	@Test
	public void doodlesTest(){
		driver.navigate().to("http://www.google.com");

		List<WebElement> elementName = driver.findElements(By.name("btnI"));
	    elementName.get(1).click();


		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.titleContains("Google Doodles"));

		 assertTrue("Erro - Página Google Doodles não retornada.", driver.getTitle().equals("Google Doodles"));
	
		}



	@After
	public void closing() throws Exception{
		// Espera 5 segundos e fecha a janela do browser
	    Thread.sleep(5000);
		driver.quit();
	}
}
