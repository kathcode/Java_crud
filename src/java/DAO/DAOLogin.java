/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author esneider.serna
 */
public class DAOLogin extends Conexion{
    
    public boolean Autenticacion(String usuario, String password) throws SQLException{
        
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "Select * from usuario";
        rs = st.executeQuery(query);
        
        while (rs.next()) {
            
            if(usuario.equals(rs.getString("Usuario_Usuario")) && password.equals(rs.getString("Password_Usuario")))
            {
                return true;
            }
            
        }
        
        return false;
    }
    
}
