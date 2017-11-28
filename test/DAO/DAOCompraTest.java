/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.ControllerTipoTarjetaTest;
import Model.ModelCompra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubikath
 */
public class DAOCompraTest extends Conexion {
    Calendar calendar = Calendar.getInstance();
    
    public DAOCompraTest() {
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
        DropInfo();
    }

    /**
     * Test of CreateShopping method, of class DAOCompra.
     */
    @Test
    public void testCreateShopping() {
        System.out.println("CreateShopping");
        
        ModelCompra model = new ModelCompra();
        model.setDescripcion_Compra("TestCreateShopping");
        model.setNumero_TarjetaXCliente("1100112345671");
        model.setDeudaInicial_Compra(100000);
        model.setDeudaActual_Compra(100000);
        model.setInteres_Compra(0.05);
        model.setNumeroCuotas_Compra(1);
        
        DAOCompra instance = new DAOCompra();
        int expResult = 0;
        int result = instance.CreateShopping(model);
        assertNotEquals(expResult, result);
    }
    
    public void DropInfo() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = null;
            String query = "DELETE FROM compras WHERE Descripcion_Compra='TestCreateShopping'";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTipoTarjetaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
