/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ModelUsuario;
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
 * @author esneider.serna
 */
public class DAOUsuario extends Conexion{
    
    public List<ModelUsuario> ListUsers() throws SQLException
    {
        List<ModelUsuario> list = new LinkedList<>();
        
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "SELECT Id_Usuario, Nombre_Usuario, Apellidos_Usuario, Telefono_Usuario, Direccion_Usuario, Email_Usuario, Genero_Usuario, Usuario_Usuario, Nombre_TipoUsuario FROM tipo_usuario TU INNER JOIN usuario U ON TU.Id_TipoUsuario = U.Id_TipoUsuario";
        rs = st.executeQuery(query);
        
        while (rs.next()) {
            
            ModelUsuario u = new ModelUsuario();
            u.setId_Usuario(rs.getString("Id_Usuario"));            
            u.setNombre_Usuario(rs.getString("Nombre_Usuario"));
            u.setApellidos_Usuario(rs.getString("Apellidos_Usuario"));
            u.setTelefono_Usuario(rs.getString("Telefono_Usuario"));
            u.setDireccion_Usuario(rs.getString("Direccion_Usuario"));
            u.setEmail_Usuario(rs.getString("Email_Usuario"));
            u.setGenero_Usuario(rs.getString("Genero_Usuario"));
            u.setUsuario_Usuario(rs.getString("Usuario_Usuario"));
            u.setNombre_TipoUsuario(rs.getString("Nombre_TipoUsuario"));
            list.add(u);
        }
        
        return list;
    }
    
    public void CreateUser(ModelUsuario user) throws SQLException 
    {
        
        try {
            ResultSet rs = null;
            String query = "INSERT INTO usuario(Id_Usuario, Nombre_Usuario, Apellidos_Usuario, Telefono_Usuario, Direccion_Usuario, Email_Usuario, Genero_Usuario, Usuario_Usuario, Password_Usuario, Id_TipoUsuario, Fecha_Creacion)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            Calendar calendar = Calendar.getInstance();
            Date fecha_creacion = new Date(calendar.getTime().getTime());

            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            preparedStmt.setString(1, user.getId_Usuario());
            preparedStmt.setString(2, user.getNombre_Usuario());
            preparedStmt.setString(3, user.getApellidos_Usuario());
            preparedStmt.setString(4, user.getTelefono_Usuario());
            preparedStmt.setString(5, user.getDireccion_Usuario());
            preparedStmt.setString(6, user.getEmail_Usuario());
            preparedStmt.setString(7, user.getGenero_Usuario());
            preparedStmt.setString(8, user.getUsuario_Usuario());
            preparedStmt.setString(9, user.getPassword_Usuario());        
            preparedStmt.setInt(10, user.getId_TipoUsuario());
            preparedStmt.setDate(11, fecha_creacion);

            preparedStmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public boolean ValidateByDocumentId(String idUser) throws SQLException 
    {
        
        try {
            
            Statement st = con.createStatement();
            ResultSet rs = null;
            String query = "SELECT * FROM usuario WHERE Id_Usuario =" + idUser;
            rs = st.executeQuery(query);

            if(rs.next())
            {
                return true;
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    public ModelUsuario InfoUser(String idUser) throws SQLException
    {
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "SELECT * FROM usuario WHERE Id_Usuario =" + idUser;
        rs = st.executeQuery(query);
        
        if(rs.next()) {

            ModelUsuario u = new ModelUsuario();
            u.setId_Usuario(rs.getString("Id_Usuario"));            
            u.setNombre_Usuario(rs.getString("Nombre_Usuario"));
            u.setApellidos_Usuario(rs.getString("Apellidos_Usuario"));
            u.setTelefono_Usuario(rs.getString("Telefono_Usuario"));
            u.setDireccion_Usuario(rs.getString("Direccion_Usuario"));
            u.setEmail_Usuario(rs.getString("Email_Usuario"));
            u.setGenero_Usuario(rs.getString("Genero_Usuario"));
            u.setUsuario_Usuario(rs.getString("Usuario_Usuario"));
            u.setId_TipoUsuario(rs.getInt("Id_TipoUsuario"));
            u.setFecha_Creacion(rs.getDate("Fecha_Creacion"));

            return u;
        }
        
        return null;
        
    }
    
    public void UpdateUser(ModelUsuario oldUser , ModelUsuario user) throws SQLException 
    {
        
        try {
            ResultSet rs = null;
            String query = "UPDATE usuario SET Id_Usuario=?, Nombre_Usuario=?, Apellidos_Usuario=?, Telefono_Usuario=?,"
                    + "Direccion_Usuario=?, Email_Usuario=?, Genero_Usuario=?, Usuario_Usuario=?, Password_Usuario=?,"
                    + "Id_TipoUsuario=?, Fecha_Creacion=? WHERE Id_Usuario=?";

            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            preparedStmt.setString(1, user.getId_Usuario());
            preparedStmt.setString(2, user.getNombre_Usuario());
            preparedStmt.setString(3, user.getApellidos_Usuario());
            preparedStmt.setString(4, user.getTelefono_Usuario());
            preparedStmt.setString(5, user.getDireccion_Usuario());
            preparedStmt.setString(6, user.getEmail_Usuario());
            preparedStmt.setString(7, user.getGenero_Usuario());
            preparedStmt.setString(8, user.getUsuario_Usuario());
            preparedStmt.setString(9, user.getPassword_Usuario());        
            preparedStmt.setInt(10, user.getId_TipoUsuario());
            preparedStmt.setDate(11, (Date) oldUser.getFecha_Creacion());            
            preparedStmt.setString(12, oldUser.getId_Usuario());

            preparedStmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
          
    public void DeleteUser(String idUser) throws SQLException
    {
        try 
        {
            String query = "DELETE FROM usuario WHERE Id_Usuario =?";
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            preparedStmt.setString(1, idUser);
            preparedStmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public List<ModelUsuario> SearchByDocumentId(String idUser) throws SQLException
    {
        List<ModelUsuario> list = new LinkedList<>();
        
        Statement st = con.createStatement();
        ResultSet rs = null;
        String query = "SELECT * FROM usuario WHERE Id_Usuario =" + idUser;
        rs = st.executeQuery(query);
        
        while (rs.next()) {
            
            ModelUsuario u = new ModelUsuario();
            u.setId_Usuario(rs.getString("Id_Usuario"));            
            u.setNombre_Usuario(rs.getString("Nombre_Usuario"));
            u.setApellidos_Usuario(rs.getString("Apellidos_Usuario"));
            u.setTelefono_Usuario(rs.getString("Telefono_Usuario"));
            u.setDireccion_Usuario(rs.getString("Direccion_Usuario"));
            u.setEmail_Usuario(rs.getString("Email_Usuario"));
            u.setGenero_Usuario(rs.getString("Genero_Usuario"));
            u.setUsuario_Usuario(rs.getString("Usuario_Usuario"));
            u.setId_TipoUsuario(rs.getInt("Id_TipoUsuario"));
            u.setFecha_Creacion(rs.getDate("Fecha_Creacion"));
            list.add(u);
        }
        
        return list;
    }
}
