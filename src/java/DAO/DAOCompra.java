/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ModelCompra;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
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
public class DAOCompra extends Conexion{
    
    public List<ModelCompra> ListShopping () throws SQLException
    {
        List<ModelCompra> list = new LinkedList<>();
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "Select * FROM Compras";
        rs = st.executeQuery(query);
        
        while (rs.next()){
            ModelCompra m = new ModelCompra();
            m.setId_Compra(rs.getInt("Id_Compra")); 
            m.setFecha_Compra(rs.getDate("Fecha_Compra"));
            m.setDeudaInicial_Compra(rs.getInt("DeudaInicial_Compra"));
            m.setNumeroCuotas_Compra(rs.getInt("NumeroCuotas_Compra"));
            m.setDescripcion_Compra(rs.getString("Descripcion_Compra"));
            m.setInteres_Compra(rs.getDouble("Interes_Compra"));
            m.setDeudaActual_Compra(rs.getInt("DeudaActual_Compra"));
            
            list.add(m);
        }
        
        return list;
    }
    
    public ModelCompra DetailShopping(int idCompra) throws SQLException 
    {
         
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "Select * FROM Compras WHERE Id_Compra = " +  idCompra;
        rs = st.executeQuery(query);
        
        if(rs.next())
        {
            ModelCompra m = new ModelCompra();
            m.setId_Compra(rs.getInt("Id_Compra")); 
            m.setFecha_Compra(rs.getDate("Fecha_Compra"));
            m.setDeudaInicial_Compra(rs.getInt("DeudaInicial_Compra"));
            m.setNumeroCuotas_Compra(rs.getInt("NumeroCuotas_Compra"));
            m.setDescripcion_Compra(rs.getString("Descripcion_Compra"));
            m.setInteres_Compra(rs.getDouble("Interes_Compra"));
            m.setDeudaActual_Compra(rs.getInt("DeudaActual_Compra"));
            return m;
        }
        
        return null;
        
    }
    
    public int CreateShopping(ModelCompra model)
    {
        int id = 0;
        
        try {
                
            ResultSet rs = null;
            String query = "INSERT INTO COMPRAS(Id_Compra,Fecha_Compra, DeudaInicial_Compra, NumeroCuotas_Compra, Descripcion_Compra, Interes_Compra, DeudaActual_Compra, Numero_TarjetaXCliente)" 
                    + "VALUES(?,?,?,?,?,?,?,?)";
            
            Calendar calendar = Calendar.getInstance();
            Date fecha_compra = new Date(calendar.getTime().getTime());
            
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query,
                                      Statement.RETURN_GENERATED_KEYS);
            
            preparedStmt.setInt(1, model.getId_Compra());
            preparedStmt.setDate(2, fecha_compra);
            preparedStmt.setInt(3, model.getDeudaInicial_Compra());
            preparedStmt.setInt(4, model.getNumeroCuotas_Compra());
            preparedStmt.setString(5, model.getDescripcion_Compra());
            preparedStmt.setDouble(6, model.getInteres_Compra());
            preparedStmt.setInt(7, model.getDeudaActual_Compra());
            preparedStmt.setString(8, model.getNumero_TarjetaXCliente());
            
            preparedStmt.executeUpdate();
            
            rs = preparedStmt.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }
            
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return id;
    }
    
}
