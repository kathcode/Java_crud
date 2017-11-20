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
            String query = "INSERT INTO programacion_pagos(Id_Pago, Fecha_de_Pago, Valor_Saldo, Abono_Capital, Valor_Interes, Valor_Cuota, Nuevo_Saldo, Estado_Pago, Id_Compra,	Fecha_Realizado, Fecha_Creacion)"
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
            preparedStmt.setBoolean(8, model.getEstado_Pago());
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
    
    public ModelPago getCuota(int id_compra) {
        try {
            
            Statement st = con.createStatement();
            ResultSet rs = null;
            String sql = "SELECT * FROM programacion_pagos where id_Compra=" + id_compra + " and Estado_Pago=0 limit 1";
            rs = st.executeQuery(sql);
            
            if (rs.next()) {
                ModelPago cuota = new ModelPago();
                
                cuota.setId_Pago(rs.getInt("Id_Pago"));
                cuota.setFecha_de_Pago(rs.getDate("Fecha_de_Pago"));
                cuota.setValor_Saldo(rs.getInt("Valor_Saldo"));
                cuota.setAbono_Capital(rs.getInt("Abono_Capital"));
                cuota.setValor_Interes(rs.getDouble("Valor_Interes"));
                cuota.setValor_Cuota(rs.getDouble("Valor_Cuota"));
                cuota.setNuevo_Saldo(rs.getInt("Nuevo_Saldo"));
                cuota.setEstado_Pago(rs.getBoolean("Estado_Pago"));
                cuota.setId_Compra(rs.getInt("Id_Compra"));
                cuota.setFecha_Realizado(rs.getDate("Fecha_Realizado"));
                cuota.setFecha_Creacion(rs.getDate("Fecha_Realizado"));

                return cuota;
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    
    public ModelPago SearchPayById(int id_compra)
    {
        try {
            
            Statement st = con.createStatement();
            ResultSet rs = null;
            String sql = "SELECT * FROM programacion_pagos where id_Pago=" + id_compra;
            rs = st.executeQuery(sql);
            
            if (rs.next()) {
                ModelPago cuota = new ModelPago();
                
                cuota.setId_Pago(rs.getInt("Id_Pago"));
                cuota.setFecha_de_Pago(rs.getDate("Fecha_de_Pago"));
                cuota.setValor_Saldo(rs.getInt("Valor_Saldo"));
                cuota.setAbono_Capital(rs.getInt("Abono_Capital"));
                cuota.setValor_Interes(rs.getDouble("Valor_Interes"));
                cuota.setValor_Cuota(rs.getDouble("Valor_Cuota"));
                cuota.setNuevo_Saldo(rs.getInt("Nuevo_Saldo"));
                cuota.setEstado_Pago(rs.getBoolean("Estado_Pago"));
                cuota.setId_Compra(rs.getInt("Id_Compra"));
                cuota.setFecha_Realizado(rs.getDate("Fecha_Realizado"));
                cuota.setFecha_Creacion(rs.getDate("Fecha_Realizado"));

                Date fecha_actual = new java.sql.Date(calendar.getTime().getTime());
                Date fecha_pago = rs.getDate("Fecha_de_Pago");

                return cuota;
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public void UpdatePay(ModelPago cuota)
    {
        try {
            ResultSet rs = null;
            String query = "UPDATE programacion_pagos SET Id_Pago=?, Fecha_de_Pago=?, Valor_Saldo=?, Abono_Capital=?,"
                    + "Valor_Interes=?, Valor_Cuota=?, Nuevo_Saldo=?, Estado_Pago=?, Id_Compra=?,"
                    + "Fecha_Realizado=?, Fecha_Creacion=? WHERE Id_Pago=?";

            calendar = Calendar.getInstance();
            Date fecha_pago = new Date(calendar.getTime().getTime());
            
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            preparedStmt.setInt(1, cuota.getId_Pago());
            preparedStmt.setDate(2, (Date) cuota.getFecha_de_Pago());
            preparedStmt.setInt(3, cuota.getValor_Saldo());
            preparedStmt.setInt(4, cuota.getAbono_Capital());
            preparedStmt.setDouble(5, cuota.getValor_Interes());
            preparedStmt.setDouble(6, cuota.getValor_Cuota());
            preparedStmt.setInt(7, cuota.getNuevo_Saldo());
            preparedStmt.setBoolean(8, cuota.getEstado_Pago());
            preparedStmt.setInt(9, cuota.getId_Compra());
            preparedStmt.setDate(10, fecha_pago);
            preparedStmt.setDate(11, (Date) cuota.getFecha_Creacion());
            preparedStmt.setInt(12, cuota.getId_Pago());

            preparedStmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<ModelPago> GetCuotas(int id_Compra)
    {
        try {
            
            List<ModelPago> listCuotas = new LinkedList<>();
            Statement st = con.createStatement();
            ResultSet rs = null;
            String sql = "SELECT * FROM programacion_pagos where id_Compra=" + id_Compra + " and Estado_Pago=0";
            rs = st.executeQuery(sql);
            
            while(rs.next()) {
                ModelPago cuota = new ModelPago();
                
                cuota.setId_Pago(rs.getInt("Id_Pago"));
                cuota.setFecha_de_Pago(rs.getDate("Fecha_de_Pago"));
                cuota.setValor_Saldo(rs.getInt("Valor_Saldo"));
                cuota.setAbono_Capital(rs.getInt("Abono_Capital"));
                cuota.setValor_Interes(rs.getDouble("Valor_Interes"));
                cuota.setValor_Cuota(rs.getDouble("Valor_Cuota"));
                cuota.setNuevo_Saldo(rs.getInt("Nuevo_Saldo"));
                cuota.setEstado_Pago(rs.getBoolean("Estado_Pago"));
                cuota.setId_Compra(rs.getInt("Id_Compra"));
                cuota.setFecha_Realizado(rs.getDate("Fecha_Realizado"));
                cuota.setFecha_Creacion(rs.getDate("Fecha_Realizado"));

                listCuotas.add(cuota);
            }
            
            
            return  listCuotas;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
}