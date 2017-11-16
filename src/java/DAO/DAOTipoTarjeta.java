/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ModelTipoTarjeta;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author esneiderserna
 */
public class DAOTipoTarjeta extends Conexion{
    
    
    public ModelTipoTarjeta GetInfoTypeCard(int codigoTarjeta) throws SQLException
    {
        
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "Select * FROM Tipo_Tarjeta WHERE Codigo_TipoTarjeta = " + codigoTarjeta;
        rs = st.executeQuery(query);
        
        if(rs.next()){
            ModelTipoTarjeta m = new ModelTipoTarjeta();
            m.setCodigo_TipoTarjeta(rs.getInt("Codigo_TipoTarjeta"));
            m.setNombre_TipoTarjeta(rs.getString("Nombre_TipoTarjeta"));
            m.setAcronimo_TipoTarjeta(rs.getString("Acronimo_TipoTarjeta"));
            m.setInteres_TipoTarjeta(rs.getDouble("Interes_TipoTarjeta"));
            m.setPlazoMax_TipoTarjeta(rs.getInt("PlazoMax_TipoTarjeta"));
            m.setCupoMax_TipoTarjeta(rs.getDouble("CupoMax_TipoTarjeta"));
            m.setMulta_TipoTarjeta(rs.getDouble("Codigo_Franquicia"));            
            m.setCodigo_Franquicia(rs.getInt("Multa_TipoTarjeta"));
            return m;
        }
        
        
        return null;
        
    }
    
}
