package systemtestselenium;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {

	WebDriver driver;
	
	@Before
	public void setUp(){
		
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

	    // submete os dados; como se fosse dado um "enter"
	    element.submit();	

	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.titleContains("software"));
	    
	    System.out.println("Título: " + driver.getTitle());

	    assertTrue("Erro - Página não retornou valor esperado.", driver.getTitle()
	    															.toLowerCase()
	    															.startsWith("software"));
	}



	@After
	public void closing() throws Exception{
		// Espera 5 segundos e fecha a janela do browser
	    Thread.sleep(5000);
		driver.quit();
	}
}
