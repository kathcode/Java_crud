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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author esneiderserna
 */
public class DAOTipoTarjeta extends Conexion{
    
    
    public List<ModelTipoTarjeta> ListTipoTarjeta() throws SQLException
    {
        List<ModelTipoTarjeta> list =  new LinkedList<>();
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "Select Codigo_TipoTarjeta, Nombre_TipoTarjeta, Acronimo_TipoTarjeta, Interes_TipoTarjeta, PlazoMax_TipoTarjeta, CupoMax_TipoTarjeta, TT.Codigo_Franquicia,"
                        +" Multa_TipoTarjeta, Acronimo_Franquicia FROM Tipo_Tarjeta TT INNER JOIN franquicia F ON TT.Codigo_Franquicia = F.Codigo_Franquicia";
        rs = st.executeQuery(query);
        
        while(rs.next()){
            
            ModelTipoTarjeta m = new ModelTipoTarjeta();
            m.setCodigo_TipoTarjeta(rs.getInt("Codigo_TipoTarjeta"));
            m.setNombre_TipoTarjeta(rs.getString("Nombre_TipoTarjeta"));
            m.setAcronimo_TipoTarjeta(rs.getString("Acronimo_TipoTarjeta"));
            m.setInteres_TipoTarjeta(rs.getDouble("Interes_TipoTarjeta"));
            m.setPlazoMax_TipoTarjeta(rs.getInt("PlazoMax_TipoTarjeta"));
            m.setCupoMax_TipoTarjeta(rs.getDouble("CupoMax_TipoTarjeta"));
            m.setMulta_TipoTarjeta(rs.getDouble("Codigo_Franquicia"));            
            m.setCodigo_Franquicia(rs.getInt("Multa_TipoTarjeta"));            
            m.setAcronimo_Franquicia(rs.getString("Acronimo_Franquicia"));

            list.add(m);
        }
        
        return list;  
    }
    
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
            m.setMulta_TipoTarjeta(rs.getDouble("Multa_TipoTarjeta"));            
            m.setCodigo_Franquicia(rs.getInt("Codigo_Franquicia"));
            return m;
        }
        
        return null;  
    }
    
}
