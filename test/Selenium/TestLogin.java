package Selenium;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author esneiderserna
 */
public class TestLogin {
    
    public static WebDriver driver = null;

    @Test
    public void TestLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement TextBox;
        TextBox = driver.findElement(By.id("usuario"));
        TextBox.sendKeys("esneider.serna");
        TextBox = driver.findElement(By.id("password"));
        TextBox.sendKeys("12345678");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
        WebElement link = driver.findElement(By.id("submit"));
        link.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TipoTarjeta")));
//        WebElement link2 = driver.findElement(By.id("TipoTarjeta"));
//        link2.click();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("NuevaTarjeta")));
//        WebElement link3 = driver.findElement(By.id("NuevaTarjeta"));
//        link3.click();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        TextBox = driver.findElement(By.id("Codigo_TipoTarjeta"));
//        TextBox.sendKeys("10");
//        TextBox = driver.findElement(By.id("Nombre_TipoTarjeta"));
//        TextBox.sendKeys("Master Azul");
//        TextBox = driver.findElement(By.id("Acronimo_TipoTarjeta"));
//        TextBox.sendKeys("MA");
//        TextBox = driver.findElement(By.id("Interes_TipoTarjeta"));
//        TextBox.sendKeys("0.7");
//        TextBox = driver.findElement(By.id("PlazoMax_TipoTarjeta"));
//        TextBox.sendKeys("40");
//        TextBox = driver.findElement(By.id("CupoMax_TipoTarjeta"));
//        TextBox.sendKeys("1000000");
//        TextBox = driver.findElement(By.id("Multa_TipoTarjeta"));
//        TextBox.sendKeys("1000");
//        TextBox = driver.findElement(By.id("Codigo_Franquicia"));
//        TextBox.sendKeys("10");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CrearTarjeta")));
//        WebElement link4 = driver.findElement(By.id("CrearTarjeta"));
//        link4.click();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        TextBox = driver.findElement(By.id("Codigo_TipoTarjeta2"));
//        TextBox.sendKeys("1");
//         try {
//            Thread.sleep(2000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
//        WebElement link5 = driver.findElement(By.id("search"));
//        link5.click();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "ExternalLibs/chromedriver");

    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/PPI-Proyecto-Bato/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    
}
