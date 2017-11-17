/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Model.ModelPago;
import Model.ModelProyeccion;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author esneiderserna
 */
public class DAOPago extends Conexion {
    
    public void CreatePay(ModelPago model)
    {
        try {
            
            ResultSet rs = null;
            String query = "INSERT INTO Programacion_Pagos(Id_Pago, Fecha_de_Pago, Valor_Saldo, Abono_Capital, Valor_Interes, Valor_Cuota, Nuevo_Saldo, Estado_Pago, Id_Compra,	Fecha_Realizado, Fecha_Creacion)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            Calendar calendar = Calendar.getInstance();
            Date fecha_creacion = new Date(calendar.getTime().getTime());

            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            preparedStmt.setInt(1, model.getId_Pago());
            preparedStmt.setDate(2, fecha_creacion);
            preparedStmt.setInt(3, model.getValor_Saldo());
            preparedStmt.setInt(4, model.getAbono_Capital());
            preparedStmt.setDouble(5, model.getValor_Interes());
            preparedStmt.setDouble(6, model.getValor_Cuota());
            preparedStmt.setInt(7, model.getNuevo_Saldo());
            preparedStmt.setBoolean(8, model.isEstado_Pago());
            preparedStmt.setInt(9, model.getId_Compra());        
            preparedStmt.setDate(10, fecha_creacion);
            preparedStmt.setDate(11, fecha_creacion);

            preparedStmt.executeUpdate();
            
        } catch (SQLException e) {
        }
    }
    
    public ModelProyeccion getInfoToPay(int Id_Tarjeta) throws SQLException {
        try {
            Statement st = con.createStatement();
            ResultSet rs = null;
            String sql = "SELECT * FROM PROYECCION WHERE ID_TARJETA =" + Id_Tarjeta;
            rs = st.executeQuery(sql);

            while(rs.next()) {
                int id_proyeccion = rs.getInt("id_proyeccion");
                int id_tarjeta = rs.getInt("id_tarjeta");
                int valor_cuota = rs.getInt("valor_cuota");
                int id_compra = rs.getInt("id_Compra");

                ModelProyeccion proyeccion = new ModelProyeccion(id_proyeccion, id_tarjeta, valor_cuota, id_compra);
                return proyeccion;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
