package DAO;

import Model.ModelTarjetaXCliente;
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
public class DAOTarjetaXCliente extends Conexion{
    
    
    public void CreateCard(ModelTarjetaXCliente model)
    {
        try {
            ResultSet rs = null;
            String query = "INSERT INTO tarjeta_x_cliente(Numero_TarjetaXCliente, Cupo_TarjetaXCliente, CupoDisp_TarjetaXCliente, Id_Usuario," 
                    +"Codigo_TipoTarjeta, Fecha_Creacion)" 
                    +" VALUES (?,?,?,?,?,?);";
            
            Calendar calendar = Calendar.getInstance();
            Date fecha_creacion = new Date(calendar.getTime().getTime());
            
            java.sql.PreparedStatement preparedStmt = (java.sql.PreparedStatement) con.prepareStatement(query);
            preparedStmt.setString(1, model.getNumero_TarjetaXCliente());
            preparedStmt.setDouble(2, model.getCupo_TarjetaXCliente());
            preparedStmt.setDouble(3, model.getCupoDisp_TarjetaXCliente());
            preparedStmt.setString(4, model.getId_Usuario());
            preparedStmt.setInt(5, model.getCodigo_TipoTarjeta());
            preparedStmt.setDate(6, fecha_creacion);
            
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<ModelTarjetaXCliente> ListCards () throws SQLException
    {
        List<ModelTarjetaXCliente> list = new LinkedList<>();
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "SELECT Numero_TarjetaXCliente, Cupo_TarjetaXCliente, CupoDisp_TarjetaXCliente, TC.Id_Usuario, TC.Codigo_TipoTarjeta, TC.Fecha_Creacion," 
                        +" Nombre_Usuario, Apellidos_Usuario, Nombre_TipoTarjeta " 
                        +"FROM Usuario U INNER JOIN Tarjeta_X_Cliente TC ON U.Id_Usuario = TC.Id_Usuario "
                        +"INNER JOIN Tipo_Tarjeta TT ON TC.Codigo_TipoTarjeta = TT.Codigo_TipoTarjeta";
        rs = st.executeQuery(query);
        
        while (rs.next()){
            ModelTarjetaXCliente m = new ModelTarjetaXCliente();
            m.setNumero_TarjetaXCliente(rs.getString("Numero_TarjetaXCliente")); 
            m.setCupo_TarjetaXCliente(rs.getDouble("Cupo_TarjetaXCliente"));
            m.setCupoDisp_TarjetaXCliente(rs.getDouble("CupoDisp_TarjetaXCliente"));
            m.setId_Usuario(rs.getString("Id_Usuario"));
            m.setCodigo_TipoTarjeta(rs.getInt("Codigo_TipoTarjeta"));            
            m.setFecha_Creacion(rs.getDate("Fecha_Creacion"));
            m.setNombre_TipoTarjeta(rs.getString("Nombre_TipoTarjeta"));
            m.setNombre_Cliente(rs.getString("Nombre_Usuario") + " " + rs.getString("Apellidos_Usuario"));
            list.add(m);
        }
        
        return list;
    }
    
    public ModelTarjetaXCliente GetInfoCard (String nTarjeta) throws SQLException
    {
        ModelTarjetaXCliente m = new ModelTarjetaXCliente();
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "SELECT Numero_TarjetaXCliente, Cupo_TarjetaXCliente, CupoDisp_TarjetaXCliente, TC.Id_Usuario, TC.Codigo_TipoTarjeta, TC.Fecha_Creacion," 
                        +" Nombre_Usuario, Apellidos_Usuario, Nombre_TipoTarjeta, Interes_TipoTarjeta " 
                        +"FROM Usuario U INNER JOIN Tarjeta_X_Cliente TC ON U.Id_Usuario = TC.Id_Usuario "
                        +"INNER JOIN Tipo_Tarjeta TT ON TC.Codigo_TipoTarjeta = TT.Codigo_TipoTarjeta "
                        +"WHERE Numero_TarjetaXCliente = " + nTarjeta;
        
        rs = st.executeQuery(query);
        
        if (rs.next()){
            m.setNumero_TarjetaXCliente(rs.getString("Numero_TarjetaXCliente")); 
            m.setCupo_TarjetaXCliente(rs.getDouble("Cupo_TarjetaXCliente"));
            m.setCupoDisp_TarjetaXCliente(rs.getDouble("CupoDisp_TarjetaXCliente"));
            m.setId_Usuario(rs.getString("Id_Usuario"));
            m.setCodigo_TipoTarjeta(rs.getInt("Codigo_TipoTarjeta"));
            m.setFecha_Creacion(rs.getDate("Fecha_Creacion"));
            m.setNombre_TipoTarjeta(rs.getString("Nombre_TipoTarjeta"));            
            m.setInteres_TipoTarjeta(rs.getDouble("Interes_TipoTarjeta"));
            m.setNombre_Cliente(rs.getString("Nombre_Usuario") + " " + rs.getString("Apellidos_Usuario"));

            return m;
        }
        
        return null;
    }
    
    public boolean UpdateInfoCard (ModelTarjetaXCliente model)
    {
        
        try {
            
            ResultSet rs = null;
            String query = "UPDATE Tarjeta_X_Cliente SET Numero_TarjetaXCliente=?, Cupo_TarjetaXCliente=?, CupoDisp_TarjetaXCliente=?, Id_Usuario=?,"
                    + "Codigo_TipoTarjeta=?, Fecha_Creacion=? WHERE Numero_TarjetaXCliente=?";

            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            preparedStmt.setString(1, model.getNumero_TarjetaXCliente());
            preparedStmt.setDouble(2, model.getCupo_TarjetaXCliente());
            preparedStmt.setDouble(3, model.getCupoDisp_TarjetaXCliente());
            preparedStmt.setString(4, model.getId_Usuario());
            preparedStmt.setInt(5, model.getCodigo_TipoTarjeta());
            preparedStmt.setDate(6, (Date) model.getFecha_Creacion());            
            preparedStmt.setString(7, model.getNumero_TarjetaXCliente());

            preparedStmt.executeUpdate();
            
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
        return false;
    }
    
}
