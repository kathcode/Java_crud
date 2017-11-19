/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ModelTipousuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author esneiderserna
 */
public class DAOTipoUsuario extends Conexion{
    
    public List<ModelTipousuario> ListTypeUser() throws SQLException
    {
        List<ModelTipousuario> list =  new LinkedList<>();
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "Select * from tipo_tsuario";
        rs = st.executeQuery(query);
        
        while(rs.next())
        {
            ModelTipousuario u = new ModelTipousuario();
            u.setId_TipoUsuario(rs.getInt("Id_TipoUsuario"));            
            u.setNombre_TipoUsuario(rs.getString("Nombre_TipoUsuario"));
            list.add(u);
            
        }
        
        return list;
    }
    
    
}
