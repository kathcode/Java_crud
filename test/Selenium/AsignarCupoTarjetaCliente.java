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
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AsignarCupoTarjetaCliente {
    public static WebDriver driver = null;
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "/home/ubikath/Downloads/chromedriver");

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
    
    // Variables del login
    By inputUsuario = By.id("usuario");
    By inputPassword = By.id("password");
    By botonEntrar = By.id("submit");
    
    
    // Funcio para el login
    public void login() {
        driver.findElement(inputUsuario).sendKeys("esneider.serna");
        driver.findElement(inputPassword).sendKeys("12345678");
        driver.findElement(botonEntrar).click();
        
        By tituloDespuesLogin = By.id("listado_clientes");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(tituloDespuesLogin));
       
        String title = driver.findElement(tituloDespuesLogin).getText();
        Assert.assertTrue(title.contains("Lista de clientes"));
    }

    @Test
    public void Login() {
        login();
    }
    
    @Test
    public void CrearTarjetaPruebasFuncionales() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement TextBox;
        
        login();
        
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
        TextBox.sendKeys("567");
        TextBox = driver.findElement(By.id("yTipoTarjeta"));
        TextBox.sendKeys("Azul");
        TextBox = driver.findElement(By.id("CTarjeta"));
        TextBox.sendKeys("23000000000");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CrearTarjetaxuser")));
        WebElement link4 = driver.findElement(By.id("CrearTarjetaxuser"));
        link4.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CrearTipoTarjetaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
