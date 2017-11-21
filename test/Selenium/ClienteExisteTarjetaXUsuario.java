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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClienteExisteTarjetaXUsuario {
     public static WebDriver driver = null;

    @Test
    public void CrearTarjetaPruebasFuncionales() {
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
            Logger.getLogger(CrearTipoTarjetaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AsignarTarjetaCliente")));
        WebElement link2 = driver.findElement(By.id("AsignarTarjetaCliente"));
        link2.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CrearTipoTarjetaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AsignarTarjeta")));
        WebElement link3 = driver.findElement(By.id("AsignarTarjeta"));
        link3.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CrearTipoTarjetaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        TextBox = driver.findElement(By.id("IdClient"));
        TextBox.sendKeys("123");
        TextBox = driver.findElement(By.id("yTipoTarjeta"));
        TextBox.sendKeys("Azul");
        TextBox = driver.findElement(By.id("CTarjeta"));
        TextBox.sendKeys("2300");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CrearTarjetaxuser")));
        WebElement link4 = driver.findElement(By.id("CrearTarjetaxuser"));
        link4.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CrearTipoTarjetaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\pruebas\\chromedriver.exe");

    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:43479/PPI-Proyecto-Bato/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
