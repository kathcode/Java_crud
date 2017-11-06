/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author esneider.serna
 */
public class ModelUsuario {
    private String Id_Usuario;
    private String Nombre_Usuario;
    private String Apellidos_Usuario;
    private String Telefono_Usuario;
    private String Direccion_Usuario;
    private String Email_Usuario;
    private String Genero_Usuario;
    private String Usuario_Usuario;
    private String Password_Usuario;
    private int Id_TipoUsuario;    
    private String Nombre_TipoUsuario;
    private Date Fecha_Creacion;

    public String getNombre_TipoUsuario() {
        return Nombre_TipoUsuario;
    }

    public void setNombre_TipoUsuario(String Nombre_TipoUsuario) {
        this.Nombre_TipoUsuario = Nombre_TipoUsuario;
    }

    public ModelUsuario() {
    }

    public String getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(String Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public String getApellidos_Usuario() {
        return Apellidos_Usuario;
    }

    public void setApellidos_Usuario(String Apellidos_Usuario) {
        this.Apellidos_Usuario = Apellidos_Usuario;
    }

    public String getTelefono_Usuario() {
        return Telefono_Usuario;
    }

    public void setTelefono_Usuario(String Telefono_Usuario) {
        this.Telefono_Usuario = Telefono_Usuario;
    }

    public String getDireccion_Usuario() {
        return Direccion_Usuario;
    }

    public void setDireccion_Usuario(String Direccion_Usuario) {
        this.Direccion_Usuario = Direccion_Usuario;
    }

    public String getEmail_Usuario() {
        return Email_Usuario;
    }

    public void setEmail_Usuario(String Email_Usuario) {
        this.Email_Usuario = Email_Usuario;
    }

    public String getGenero_Usuario() {
        return Genero_Usuario;
    }

    public void setGenero_Usuario(String Genero_Usuario) {
        this.Genero_Usuario = Genero_Usuario;
    }

    public String getUsuario_Usuario() {
        return Usuario_Usuario;
    }

    public void setUsuario_Usuario(String Usuario_Usuario) {
        this.Usuario_Usuario = Usuario_Usuario;
    }

    public String getPassword_Usuario() {
        return Password_Usuario;
    }

    public void setPassword_Usuario(String Password_Usuario) {
        this.Password_Usuario = Password_Usuario;
    }

    public int getId_TipoUsuario() {
        return Id_TipoUsuario;
    }

    public void setId_TipoUsuario(int Id_TipoUsuario) {
        this.Id_TipoUsuario = Id_TipoUsuario;
    }

    public Date getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(Date Fecha_Creacion) {
        this.Fecha_Creacion = Fecha_Creacion;
    }
}
