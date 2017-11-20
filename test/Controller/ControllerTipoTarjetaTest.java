/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOTipoTarjeta;
import Model.ModelTipoTarjeta;
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
public class ControllerTipoTarjetaTest {
    private final DAOTipoTarjeta DAO = new DAOTipoTarjeta();
    
    public ControllerTipoTarjetaTest() {
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
     * Test of getServletInfo method, of class ControllerTipoTarjeta.
     */
    @Test
    public void testGetServletInfo() {
        
        int Codigo_TipoTarjeta = 1;
        String Nombre_TipoTarjeta = "Test";
        String setAcronimo_TipoTarjeta = "Acronimo_test";
        double Interes_TipoTarjeta = 2.5;
        int PlazoMax_TipoTarjeta = 60;
        double CupoMax_TipoTarjeta = 9000000;
        int Multa_TipoTarjeta = 20000;
        int Codigo_Franquicia = 1;
        
        ModelTipoTarjeta newTarjeta = new ModelTipoTarjeta();
        newTarjeta.setCodigo_TipoTarjeta(1);
        newTarjeta.setNombre_TipoTarjeta("sasas");
        newTarjeta.setAcronimo_TipoTarjeta("ssas");
        newTarjeta.setInteres_TipoTarjeta(0.6);
        newTarjeta.setPlazoMax_TipoTarjeta(60);
        newTarjeta.setCupoMax_TipoTarjeta(9000000);
        newTarjeta.setMulta_TipoTarjeta(20000);
        newTarjeta.setCodigo_Franquicia(1);

        ModelTipoTarjeta tipo_tarjeta_recibida = DAO.CreateTarjeta(newTarjeta);

        ModelTipoTarjeta tipo_tarjeta_enviada = new ModelTipoTarjeta(Codigo_TipoTarjeta, Nombre_TipoTarjeta, setAcronimo_TipoTarjeta, Interes_TipoTarjeta, PlazoMax_TipoTarjeta, CupoMax_TipoTarjeta, Multa_TipoTarjeta, Codigo_Franquicia);
        
        assertEquals(tipo_tarjeta_enviada, tipo_tarjeta_recibida);
    }
    
}
