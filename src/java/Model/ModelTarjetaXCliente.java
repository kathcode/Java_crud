package Model;

import java.util.Date;

/**
 *
 * @author esneiderserna
 */
public class ModelTarjetaXCliente {
    
    private String Numero_TarjetaXCliente;    
    private int Cupo_TarjetaXCliente;
    private int CupoDisp_TarjetaXCliente;
    private String Id_Usuario;
    private int Codigo_TipoTarjeta;
    private Date Fecha_Creacion;
    
    private String Nombre_TipoTarjeta;
    private double Interes_TipoTarjeta;
    private String Nombre_Cliente;


    public ModelTarjetaXCliente() {
    }

    public ModelTarjetaXCliente(String Numero_TarjetaXCliente, int Cupo_TarjetaXCliente, int CupoDisp_TarjetaXCliente, String Id_Usuario, int Codigo_TipoTarjeta) {
        this.Numero_TarjetaXCliente = Numero_TarjetaXCliente;
        this.Cupo_TarjetaXCliente = Cupo_TarjetaXCliente;
        this.CupoDisp_TarjetaXCliente = CupoDisp_TarjetaXCliente;
        this.Id_Usuario = Id_Usuario;
        this.Codigo_TipoTarjeta = Codigo_TipoTarjeta;
    }
    
    

    public String getNumero_TarjetaXCliente() {
        return Numero_TarjetaXCliente;
    }

    public void setNumero_TarjetaXCliente(String Numero_TarjetaXCliente) {
        this.Numero_TarjetaXCliente = Numero_TarjetaXCliente;
    }

    public int getCupo_TarjetaXCliente() {
        return Cupo_TarjetaXCliente;
    }

    public void setCupo_TarjetaXCliente(int Cupo_TarjetaXCliente) {
        this.Cupo_TarjetaXCliente = Cupo_TarjetaXCliente;
    }

    public int getCupoDisp_TarjetaXCliente() {
        return CupoDisp_TarjetaXCliente;
    }

    public void setCupoDisp_TarjetaXCliente(int CupoDisp_TarjetaXCliente) {
        this.CupoDisp_TarjetaXCliente = CupoDisp_TarjetaXCliente;
    }

    public String getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(String Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public int getCodigo_TipoTarjeta() {
        return Codigo_TipoTarjeta;
    }

    public void setCodigo_TipoTarjeta(int Codigo_TipoTarjeta) {
        this.Codigo_TipoTarjeta = Codigo_TipoTarjeta;
    }

    public Date getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(Date Fecha_Creacion) {
        this.Fecha_Creacion = Fecha_Creacion;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public String getNombre_TipoTarjeta() {
        return Nombre_TipoTarjeta;
    }

    public void setNombre_TipoTarjeta(String Nombre_TipoTarjeta) {
        this.Nombre_TipoTarjeta = Nombre_TipoTarjeta;
    }

    public double getInteres_TipoTarjeta() {
        return Interes_TipoTarjeta;
    }

    public void setInteres_TipoTarjeta(double Interes_TipoTarjeta) {
        this.Interes_TipoTarjeta = Interes_TipoTarjeta;
    }
    
    
    
}
