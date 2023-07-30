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

public class IfmgSabaraTest {

    WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");

        driver = new FirefoxDriver();
    }

    @Test
    public void meuIfmgTest() {
        driver.navigate().to("https://www.ifmg.edu.br/sabara");

        List<WebElement> element = driver.findElements(By.id("portalservicos-meu-ifmg"));
        element.get(0).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("meuIFMG"));

        assertTrue("Erro - Página Meu IFMG não encontrada.", driver.getTitle().equals("meuIFMG"));

    }

    @Test
    public void cpaTest() {
        driver.navigate().to("https://www.ifmg.edu.br/sabara");

        List<WebElement> element = driver.findElements(By.id("portalservicos-cpa-1"));
        element.get(0).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Instituto Federal"));

        assertTrue("Erro - Página CPA não encontrada.",
                driver.getCurrentUrl().equals("https://www.ifmg.edu.br/portal/home"));
    }

    @Test
    public void webmailTest() {
        driver.navigate().to("https://www.ifmg.edu.br/sabara");

        List<WebElement> element = driver.findElements(By.id("portalservicos-webmail"));
        element.get(0).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Sign in - Google Accounts"));

        assertTrue("Erro - Página Webmail não encontrada.",
                driver.getTitle().equals("Sign in - Google Accounts"));
    }

    @Test
    public void contatoTest() {
        driver.navigate().to("https://www.ifmg.edu.br/sabara");

        List<WebElement> element = driver.findElements(By.id("portalservicos-fale-conosco"));
        element.get(0).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Instituto Federal de"));

        assertTrue("Erro - link contato não encontrada.",
                driver.getCurrentUrl().equals("https://www.ifmg.edu.br/sabara/contato"));
    }

    @Test
    public void exAlunosTest() {
        driver.navigate().to("https://www.ifmg.edu.br/sabara");

        List<WebElement> element = driver.findElements(By.id("portalservicos-ex-alunos"));
        element.get(0).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Instituto Federal de"));

        assertTrue("Erro - link ex-alunos não encontrada.",
                driver.getCurrentUrl().equals("https://www2.ifmg.edu.br/sabara/formulario-contato-ex-alunos"));
    }

    @Test
    public void acessoSistemasTest() {
        driver.navigate().to("https://www.ifmg.edu.br/sabara");

        List<WebElement> element = driver.findElements(By.id("portalservicos-acesso-a-sistemas"));
        element.get(0).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Instituto Federal de"));

        assertTrue("Erro - Página acesso a sistemas não encontrada.",
                driver.getCurrentUrl().equals("https://www.ifmg.edu.br/portal/acesso-a-sistemas"));
    }

    @Test
	public void searchTest() {

	    driver.navigate().to("https://www.ifmg.edu.br/sabara");

	    WebElement element = driver.findElement(By.name("SearchableText"));

	    
	    element.sendKeys("Calendario");

	    List<WebElement> elementName = driver.findElements(By.className("searchButton"));
	    elementName.get(0).click();

	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.titleContains("Instituto Federal de"));

	    assertTrue("Erro - Página de busca de não encontrada.",
                driver.getCurrentUrl().equals("https://www.ifmg.edu.br/sabara/@@busca?SearchableText=Calendario"));
	}

    @After
    public void closing() throws Exception {
        // Espera 5 segundos e fecha a janela do browser
        Thread.sleep(5000);
        driver.quit();
    }
}


