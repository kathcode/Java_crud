/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author ubikath
 */
public class ValidacionRangosSolapadosFraquiciaTest {
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SeleccionarFranquicia")));
        WebElement link2 = driver.findElement(By.id("SeleccionarFranquicia"));
        link2.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CrearTipoTarjetaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nuevaFranquicia")));
        WebElement link3 = driver.findElement(By.id("nuevaFranquicia"));
        link3.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CrearTipoTarjetaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        TextBox = driver.findElement(By.id("nombre"));
        TextBox.sendKeys("Test");
        TextBox = driver.findElement(By.id("acronimo"));
        TextBox.sendKeys("Test");
        TextBox = driver.findElement(By.id("min"));
        TextBox.sendKeys("2300");
        TextBox = driver.findElement(By.id("max"));
        TextBox.sendKeys("3300");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("botonCrearFranquicia")));
        WebElement link4 = driver.findElement(By.id("botonCrearFranquicia"));
        link4.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CrearTipoTarjetaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
}
