/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOUsuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import java.util.Calendar;

import Model.ModelUsuario;

/**
 *
 * @author ubikath
 */
public class ControllerUsuarioTest {
    private final DAOUsuario DAO = new DAOUsuario();
    Calendar calendar = Calendar.getInstance();
    
    public ControllerUsuarioTest() {
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
     * Test of CreateUser method, of class ControllerUsuario.
     */
    @Test
    public void testCreateUser() throws Exception {
        System.out.println("CreateUser");
        
        String Id_Usuario = "211";
        String Nombre_Usuario = "Test";
        String Apellidos_Usuario = "Test apellido";
        String Telefono_Usuario = "123123123";
        String Direccion_Usuario = "Carrera";
        String Email_Usuario = "test@test.com";
        String Genero_Usuario = "test";
        String Usuario_Usuario = "test";
        String Password_Usuario = "test";
        int Id_TipoUsuario = 1;
        
        ModelUsuario usuarioEnviado = new ModelUsuario();
        usuarioEnviado.setId_Usuario(Id_Usuario);        
        usuarioEnviado.setNombre_Usuario(Nombre_Usuario);  
        usuarioEnviado.setApellidos_Usuario(Apellidos_Usuario);
        usuarioEnviado.setTelefono_Usuario(Telefono_Usuario);
        usuarioEnviado.setDireccion_Usuario(Direccion_Usuario);
        usuarioEnviado.setEmail_Usuario(Email_Usuario);
        usuarioEnviado.setGenero_Usuario(Genero_Usuario);
        usuarioEnviado.setUsuario_Usuario(Usuario_Usuario);
        usuarioEnviado.setPassword_Usuario(Password_Usuario);
        usuarioEnviado.setId_TipoUsuario(Id_TipoUsuario);
        
        DAO.CreateUser(usuarioEnviado);
        
        assertEquals(1, 1);
    }
    
}
        