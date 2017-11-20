/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package DAO;
import Model.ModelFranquicias;
import DAO.Conexion;
import Model.ModelUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Catalina
 */
public class DAOFranquicia extends Conexion {

    public List<ModelFranquicias> getFranquicias() throws SQLException {
        List<ModelFranquicias> listaFranquicias = new LinkedList<>();
        
        Statement st = con.createStatement();
        ResultSet rs = null;
        String sql = "SELECT * FROM franquicia";
        rs = st.executeQuery(sql);

        while (rs.next()) {
            Integer codigo_franquicia = rs.getInt("CODIGO_FRANQUICIA");
            String nombre = rs.getString("NOMBRE_FRANQUICIA");
            String acronimo = rs.getString("ACRONIMO_FRANQUICIA");
            int rango_max = rs.getInt("RANGOPINGMAX_FRANQUICIA");
            int rango_min = rs.getInt("RANGOPINGMIN_FRANQUICIA");
            Date date = rs.getDate("FECHA_CREACION");

            ModelFranquicias f = new ModelFranquicias(codigo_franquicia, nombre, acronimo, rango_max, rango_min, date);
            listaFranquicias.add(f);
        }

        return listaFranquicias;
    }
    
    public void validateRango(int min, int max) {
        try {
            Statement st = con.createStatement();
            ResultSet rs = null;
            String sql = "SELECT * FROM franquicia where RangoPingMax_Franquicia=" + max + " and RangoPingMin_Franquicia=" + min;
            rs = st.executeQuery(sql);
            
        } catch (Exception e) {
        }
    }
    
    public ModelFranquicias crearFranquicia(ModelFranquicias franquicia) {
        try {
            String query = "INSERT INTO franquicia(NOMBRE_FRANQUICIA, ACRONIMO_FRANQUICIA, RANGOPINGMAX_FRANQUICIA, RANGOPINGMIN_FRANQUICIA, FECHA_CREACION"+ ")"
                        + "VALUES (?,?,?,?,?)";

            Calendar calendar = Calendar.getInstance();
            
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            preparedStmt.setString(1, franquicia.getNombre_Franquicia());
            preparedStmt.setString(2, franquicia.getAcronimo_Franquicia());
            preparedStmt.setInt(3, franquicia.getRangoPingMax_Franquicia());
            preparedStmt.setInt(4, franquicia.getRangoPingMin_Franquicia());
            preparedStmt.setDate(5, (java.sql.Date) franquicia.getFecha_Creacion());

            preparedStmt.executeUpdate();
            
            return franquicia;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // Return null if the method cant create the franquicia
        return null;
    }
    
    public ModelFranquicias getFranquiciaByid(int id) throws SQLException {
        Statement st = con.createStatement();
        String sql = "SELECT * FROM franquicia WHERE CODIGO_FRANQUICIA=" + id;
        ResultSet rs = st.executeQuery(sql);

        if (rs.next()) {
            Integer codigo = rs.getInt("CODIGO_FRANQUICIA");
            String nombre = rs.getString("NOMBRE_FRANQUICIA");
            String acronimo = rs.getString("ACRONIMO_FRANQUICIA");
            int rango_max = rs.getInt("RANGOPINGMAX_FRANQUICIA");
            int rango_min = rs.getInt("RANGOPINGMIN_FRANQUICIA");
            Date date = rs.getDate("FECHA_CREACION");

            ModelFranquicias f = new ModelFranquicias(codigo, nombre, acronimo, rango_max, rango_min, date);
            return f;
        }
        
        return null;
    }
    
    public void actualizarFranquicia(ModelFranquicias oldFranquicia , ModelFranquicias franquicia) throws SQLException 
    {
        
        try {
            ResultSet rs = null;
            String query = "UPDATE franquicia SET NOMBRE_FRANQUICIA=?, ACRONIMO_FRANQUICIA=?, RANGOPINGMAX_FRANQUICIA=?,"
                    + "RANGOPINGMIN_FRANQUICIA=? WHERE CODIGO_FRANQUICIA=?";

            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            
            preparedStmt.setString(1, franquicia.getNombre_Franquicia());
            preparedStmt.setString(2, franquicia.getAcronimo_Franquicia());
            preparedStmt.setInt(3, franquicia.getRangoPingMax_Franquicia());
            preparedStmt.setInt(4, franquicia.getRangoPingMin_Franquicia());
            preparedStmt.setInt(5, oldFranquicia.getCodigo_Franquicia());
            
            preparedStmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void eliminarFranquicia(int id) {
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("DELETE FROM franquicia WHERE CODIGO_FRANQUICIA=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
