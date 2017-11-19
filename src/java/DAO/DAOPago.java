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
import java.util.Calendar;

import Model.ModelPagoCuota;
import Model.ModelPago;
import Model.ModelCompra;
import Model.ModelProyeccion;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author esneiderserna
 */
public class DAOPago extends Conexion {
    Calendar calendar = Calendar.getInstance();
    
    public void CreatePay(ModelPago model)
    {
        try {
            
            ResultSet rs = null;
            String query = "INSERT INTO Programacion_Pagos(Id_Pago, Fecha_de_Pago, Valor_Saldo, Abono_Capital, Valor_Interes, Valor_Cuota, Nuevo_Saldo, Estado_Pago, Id_Compra,	Fecha_Realizado, Fecha_Creacion)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

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
            System.out.println(e.getMessage());
        }
    }
    
    public List<ModelCompra> getInfoToPay(String Id_Tarjeta) throws SQLException {
        try {
            List<ModelCompra> listaCompras = new LinkedList<>();
            Statement st = con.createStatement();
            ResultSet rs = null;
            String sql = "SELECT * FROM compras where Numero_TarjetaXCliente =" + Id_Tarjeta;
            rs = st.executeQuery(sql);

            while(rs.next()) {
                int Id_Compra = rs.getInt("Id_Compra");
                Date Fecha_Compra = rs.getDate("Fecha_Compra");
                int DeudaInicial_Compra = rs.getInt("DeudaInicial_Compra");
                int NumeroCuotas_Compra = rs.getInt("NumeroCuotas_Compra");
                String Descripcion_Compra = rs.getString("Descripcion_Compra");
                double Interes_Compra = rs.getDouble("Interes_Compra");
                int DeudaActual_Compra = rs.getInt("DeudaActual_Compra");
                String Numero_TarjetaXCliente = rs.getString("Numero_TarjetaXCliente");
    
                ModelCompra compra = new ModelCompra(Id_Compra, Fecha_Compra, DeudaInicial_Compra, NumeroCuotas_Compra, Descripcion_Compra, Interes_Compra, DeudaActual_Compra, Numero_TarjetaXCliente);
                listaCompras.add(compra);
            }
            
            return listaCompras;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ModelPagoCuota getCuota(int id_compra) {
        try {
            Statement st = con.createStatement();
            ResultSet rs = null;
            String sql = "SELECT * FROM programacion_pagos where id_Compra=" + id_compra + " and Estado_Pago=0";
            rs = st.executeQuery(sql);
            
            if (rs.next()) {
                int valor_cuota = rs.getInt("Valor_Cuota");
                int id_pago = rs.getInt("id_Pago");
            
                Date fecha_actual = new java.sql.Date(calendar.getTime().getTime());
                Date fecha_pago = rs.getDate("Fecha_de_Pago");

                // date1 < date2, devuelve un valor menor que 0
                // date2 > date1, devuelve un valor mayor que 0
                // date1 = date3, se mostrará un 0 en la consola

                int result = fecha_actual.compareTo(fecha_pago);

                if (result > 0) {
                    valor_cuota = valor_cuota + 10000;
                }

                ModelPagoCuota pago = new ModelPagoCuota(valor_cuota, id_pago);

                return pago;
            }
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public void realizarPago(int id_pago, int valor_pago) {
        
    }
}