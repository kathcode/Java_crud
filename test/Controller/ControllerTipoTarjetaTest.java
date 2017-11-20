/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOTipoTarjeta;
import Model.ModelTipoTarjeta;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import DAO.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubikath
 */
public class ControllerTipoTarjetaTest extends Conexion {
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
    public void tearDown() throws SQLException {
        DropInfo();
    }

    /**
     * Test of CreateTipoTarjeta method, of class ControllerTipoTarjeta.
     */
    @Test
    public void testCreateTipoTarjeta() {
        
        ModelTipoTarjeta tipo_tarjeta_enviada = new ModelTipoTarjeta();
        tipo_tarjeta_enviada.setCodigo_TipoTarjeta(31);
        tipo_tarjeta_enviada.setNombre_TipoTarjeta("nombre");
        tipo_tarjeta_enviada.setAcronimo_TipoTarjeta("Acronimo");
        tipo_tarjeta_enviada.setInteres_TipoTarjeta(0.05);
        tipo_tarjeta_enviada.setPlazoMax_TipoTarjeta(60);
        tipo_tarjeta_enviada.setCupoMax_TipoTarjeta(9000000);
        tipo_tarjeta_enviada.setMulta_TipoTarjeta(2000);
        tipo_tarjeta_enviada.setCodigo_Franquicia(1);

        ModelTipoTarjeta tipo_tarjeta_recibida = DAO.CreateTarjeta(tipo_tarjeta_enviada);
        
        assertEquals(tipo_tarjeta_enviada, tipo_tarjeta_recibida);
    }
    
    public void DropInfo() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = null;
            String query = "DELETE FROM tipo_tarjeta WHERE Codigo_TipoTarjeta=31";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTipoTarjetaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
