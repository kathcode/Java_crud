/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ModelTipoTarjeta;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author esneiderserna
 */
public class DAOTipoTarjeta extends Conexion{
    
    public ModelTipoTarjeta CreateTarjeta(ModelTipoTarjeta tipotarjeta)
    {
        try {
            
            ResultSet rs = null;
            String query = "INSERT INTO tipo_tarjeta(Codigo_TipoTarjeta, Nombre_TipoTarjeta, Acronimo_TipoTarjeta, Interes_TipoTarjeta," 
                    +"PlazoMax_TipoTarjeta, CupoMax_TipoTarjeta, Multa_TipoTarjeta, Codigo_Franquicia, Fecha_Creacion)" 
                    +" VALUES (?,?,?,?,?,?,?,?,?);";
            
            Calendar calendar = Calendar.getInstance();
            Date fecha_creacion = new Date(calendar.getTime().getTime());
            
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            preparedStmt.setInt(1, tipotarjeta.getCodigo_TipoTarjeta());
            preparedStmt.setString(2, tipotarjeta.getNombre_TipoTarjeta());
            preparedStmt.setString(3, tipotarjeta.getAcronimo_TipoTarjeta());
            preparedStmt.setDouble(4, tipotarjeta.getInteres_TipoTarjeta());
            preparedStmt.setInt(5, tipotarjeta.getPlazoMax_TipoTarjeta());
            preparedStmt.setDouble(6, tipotarjeta.getCupoMax_TipoTarjeta());
            preparedStmt.setDouble(7, tipotarjeta.getMulta_TipoTarjeta());
            preparedStmt.setInt(8, tipotarjeta.getCodigo_Franquicia());
            preparedStmt.setDate(9, fecha_creacion);
            
            preparedStmt.executeUpdate();
            
            return tipotarjeta;
            
        } catch (SQLException e) {
        }
        return null;
    }
    
    
    public List<ModelTipoTarjeta> ListTipoTarjeta() throws SQLException
    {
        List<ModelTipoTarjeta> list =  new LinkedList<>();
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "Select Codigo_TipoTarjeta, Nombre_TipoTarjeta, Acronimo_TipoTarjeta, Interes_TipoTarjeta, PlazoMax_TipoTarjeta, CupoMax_TipoTarjeta, TT.Codigo_Franquicia,"
                +" Multa_TipoTarjeta, Acronimo_Franquicia, TT.Fecha_Creacion "
                +" FROM tipo_tarjeta TT "
                +"INNER JOIN franquicia F ON TT.Codigo_Franquicia = F.Codigo_Franquicia";
        rs = st.executeQuery(query);
        
        while(rs.next()){
            
            ModelTipoTarjeta m = new ModelTipoTarjeta();
            m.setCodigo_TipoTarjeta(rs.getInt("Codigo_TipoTarjeta"));
            m.setNombre_TipoTarjeta(rs.getString("Nombre_TipoTarjeta"));
            m.setAcronimo_TipoTarjeta(rs.getString("Acronimo_TipoTarjeta"));
            m.setInteres_TipoTarjeta(rs.getDouble("Interes_TipoTarjeta"));
            m.setPlazoMax_TipoTarjeta(rs.getInt("PlazoMax_TipoTarjeta"));
            m.setCupoMax_TipoTarjeta(rs.getDouble("CupoMax_TipoTarjeta"));
            m.setMulta_TipoTarjeta(rs.getInt("Multa_TipoTarjeta"));            
            m.setCodigo_Franquicia(rs.getInt("Codigo_Franquicia"));            
            m.setAcronimo_Franquicia(rs.getString("Acronimo_Franquicia"));

            list.add(m);
        }
        
        return list;  
    }
    
    public ModelTipoTarjeta GetInfoTypeCard(int codigoTarjeta) throws SQLException
    {
        
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "Select Codigo_TipoTarjeta, Nombre_TipoTarjeta, Acronimo_TipoTarjeta, Interes_TipoTarjeta, PlazoMax_TipoTarjeta, CupoMax_TipoTarjeta, TT.Codigo_Franquicia, "
                +"Multa_TipoTarjeta, Acronimo_Franquicia, TT.Fecha_Creacion "
                +"FROM tipo_tarjeta TT " 
                +"INNER JOIN franquicia F ON TT.Codigo_Franquicia = F.Codigo_Franquicia " 
                +"WHERE Codigo_TipoTarjeta = " + codigoTarjeta;
        rs = st.executeQuery(query);
        
        if(rs.next()){
            ModelTipoTarjeta m = new ModelTipoTarjeta();
            m.setCodigo_TipoTarjeta(rs.getInt("Codigo_TipoTarjeta"));
            m.setNombre_TipoTarjeta(rs.getString("Nombre_TipoTarjeta"));
            m.setAcronimo_TipoTarjeta(rs.getString("Acronimo_TipoTarjeta"));
            m.setInteres_TipoTarjeta(rs.getDouble("Interes_TipoTarjeta"));
            m.setPlazoMax_TipoTarjeta(rs.getInt("PlazoMax_TipoTarjeta"));
            m.setCupoMax_TipoTarjeta(rs.getDouble("CupoMax_TipoTarjeta"));
            m.setMulta_TipoTarjeta(rs.getInt("Multa_TipoTarjeta"));            
            m.setCodigo_Franquicia(rs.getInt("Codigo_Franquicia"));
            m.setFecha_Creacion(rs.getDate("Fecha_Creacion"));
            m.setAcronimo_Franquicia(rs.getString("Acronimo_Franquicia"));
            return m;
        }
        
        return null;  
    }
    
    public List<ModelTipoTarjeta> SearchByCodigoId(int Codigo_TipoTarjeta) throws SQLException
    {
        List<ModelTipoTarjeta> list = new LinkedList<>();
        
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "Select Codigo_TipoTarjeta, Nombre_TipoTarjeta, Acronimo_TipoTarjeta, Interes_TipoTarjeta, PlazoMax_TipoTarjeta, CupoMax_TipoTarjeta, TT.Codigo_Franquicia,"
                +" Multa_TipoTarjeta, Acronimo_Franquicia FROM tipo_tarjeta TT "
                +"INNER JOIN franquicia F ON TT.Codigo_Franquicia = F.Codigo_Franquicia "
                +"WHERE Codigo_TipoTarjeta = " + Codigo_TipoTarjeta;
        rs = st.executeQuery(query);
        
        while (rs.next()) {
            
            ModelTipoTarjeta m = new ModelTipoTarjeta();           
            m.setCodigo_TipoTarjeta(rs.getInt("Codigo_TipoTarjeta"));
            m.setNombre_TipoTarjeta(rs.getString("Nombre_TipoTarjeta"));
            m.setAcronimo_TipoTarjeta(rs.getString("Acronimo_TipoTarjeta"));
            m.setInteres_TipoTarjeta(rs.getDouble("Interes_TipoTarjeta"));
            m.setPlazoMax_TipoTarjeta(rs.getInt("PlazoMax_TipoTarjeta"));
            m.setCupoMax_TipoTarjeta(rs.getDouble("CupoMax_TipoTarjeta"));
            m.setMulta_TipoTarjeta(rs.getInt("Multa_TipoTarjeta"));            
            m.setCodigo_Franquicia(rs.getInt("Codigo_Franquicia"));            
            m.setAcronimo_Franquicia(rs.getString("Acronimo_Franquicia"));
        
            list.add(m);
        }
        
        return list;
    }
    
    public boolean ValidateByCodigoId(int Codigo_TipoTarjeta) throws SQLException {

        try {

            Statement st = con.createStatement();
            ResultSet rs = null;
            String query = "SELECT * FROM tipo_tarjeta WHERE Codigo_TipoTarjeta =" + Codigo_TipoTarjeta;
            rs = st.executeQuery(query);

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
    
    public void UpdateTarjeta(ModelTipoTarjeta oldTarjeta , ModelTipoTarjeta tipotarjeta) throws SQLException 
    {
        
        try {
            ResultSet rs = null;
            String query = "UPDATE tipo_tarjeta SET Codigo_TipoTarjeta=?, Nombre_TipoTarjeta=?, Acronimo_TipoTarjeta=?, Interes_TipoTarjeta=?," 
                    +"PlazoMax_TipoTarjeta=?, CupoMax_TipoTarjeta=?, Multa_TipoTarjeta=?, Codigo_Franquicia=?, Fecha_Creacion=? "
                    +"WHERE Codigo_TipoTarjeta=?";
                 
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            preparedStmt.setInt(1, tipotarjeta.getCodigo_TipoTarjeta());
            preparedStmt.setString(2, tipotarjeta.getNombre_TipoTarjeta());
            preparedStmt.setString(3, tipotarjeta.getAcronimo_TipoTarjeta());
            preparedStmt.setDouble(4, tipotarjeta.getInteres_TipoTarjeta());
            preparedStmt.setInt(5, tipotarjeta.getPlazoMax_TipoTarjeta());
            preparedStmt.setDouble(6, tipotarjeta.getCupoMax_TipoTarjeta());
            preparedStmt.setInt(7, tipotarjeta.getMulta_TipoTarjeta());
            preparedStmt.setInt(8, tipotarjeta.getCodigo_Franquicia());
            preparedStmt.setDate(9, (Date) oldTarjeta.getFecha_Creacion());            
            preparedStmt.setInt(10, oldTarjeta.getCodigo_TipoTarjeta());


            preparedStmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}