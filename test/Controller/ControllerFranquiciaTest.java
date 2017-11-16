/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFranquicia;
import Model.ModelFranquicias;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ubikath
 */
public class ControllerFranquiciaTest {
    DAOFranquicia dao = new DAOFranquicia();
    Calendar calendar = Calendar.getInstance();
    
    public ControllerFranquiciaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crearFranquicia method, of class ControllerFranquicia.
     * @throws java.lang.Exception
     */
    @Test
    public void testCrearFranquicia() throws Exception {
        System.out.println("crearFranquicia");
        
        Integer codigo = null;
        String nombre = "nombre";
        String acronimo = "acronimo";
        int max = 200;
        int min = 300;
        java.sql.Date fecha_creacion = new java.sql.Date(calendar.getTime().getTime());

        Model.ModelFranquicias franquiciaEnviada = new Model.ModelFranquicias(codigo, nombre, acronimo, max, min, fecha_creacion);
        
        // Si el método devuelve null, es porque no pudo crear la franquicia y falla el test.
        // De lo contrarío me devuelve el modelo que le envíe.
        Model.ModelFranquicias franquiciaRecibida = dao.crearFranquicia(franquiciaEnviada);

        assertEquals(franquiciaEnviada, franquiciaRecibida);
    }
    
}