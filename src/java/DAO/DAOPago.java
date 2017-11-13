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

/**
 *
 * @author esneiderserna
 */
public class DAOPago extends Conexion {
    
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
