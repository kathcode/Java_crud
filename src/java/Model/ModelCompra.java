
package Model;

import java.util.Date;

/**
 *
 * @author esneiderserna
 */
public class ModelCompra {
    
    private int Id_Compra;
    private Date Fecha_Compra;
    private int DeudaInicial_Compra;
    private int NumeroCuotas_Compra;
    private String Descripcion_Compra;
    private double Interes_Compra;
    private int DeudaActual_Compra;
    private String Numero_TarjetaXCliente;
    
    private String Id_Usuario;
    private String Nombre_Cliente;

    public ModelCompra() {
    }

    public ModelCompra(int Id_Compra, Date Fecha_Compra, int DeudaInicial_Compra, int NumeroCuotas_Compra, String Descripcion_Compra, double Interes_Compra, int DeudaActual_Compra, String Numero_TarjetaXCliente) {
        this.Id_Compra = Id_Compra;
        this.Fecha_Compra = Fecha_Compra;
        this.DeudaInicial_Compra = DeudaInicial_Compra;
        this.NumeroCuotas_Compra = NumeroCuotas_Compra;
        this.Descripcion_Compra = Descripcion_Compra;
        this.Interes_Compra = Interes_Compra;
        this.DeudaActual_Compra = DeudaActual_Compra;
        this.Numero_TarjetaXCliente = Numero_TarjetaXCliente;
    }
    
    public int getId_Compra() {
        return Id_Compra;
    }

    public void setId_Compra(int Id_Compra) {
        this.Id_Compra = Id_Compra;
    }

    public Date getFecha_Compra() {
        return Fecha_Compra;
    }

    public void setFecha_Compra(Date Fecha_Compra) {
        this.Fecha_Compra = Fecha_Compra;
    }

    public int getDeudaInicial_Compra() {
        return DeudaInicial_Compra;
    }

    public void setDeudaInicial_Compra(int DeudaInicial_Compra) {
        this.DeudaInicial_Compra = DeudaInicial_Compra;
    }

    public int getNumeroCuotas_Compra() {
        return NumeroCuotas_Compra;
    }

    public void setNumeroCuotas_Compra(int NumeroCuotas_Compra) {
        this.NumeroCuotas_Compra = NumeroCuotas_Compra;
    }

    public String getDescripcion_Compra() {
        return Descripcion_Compra;
    }

    public void setDescripcion_Compra(String Descripcion_Compra) {
        this.Descripcion_Compra = Descripcion_Compra;
    }

    public double getInteres_Compra() {
        return Interes_Compra;
    }

    public void setInteres_Compra(double Interes_Compra) {
        this.Interes_Compra = Interes_Compra;
    }

    public int getDeudaActual_Compra() {
        return DeudaActual_Compra;
    }

    public void setDeudaActual_Compra(int DeudaActual_Compra) {
        this.DeudaActual_Compra = DeudaActual_Compra;
    }

    public String getNumero_TarjetaXCliente() {
        return Numero_TarjetaXCliente;
    }

    public void setNumero_TarjetaXCliente(String Numero_TarjetaXCliente) {
        this.Numero_TarjetaXCliente = Numero_TarjetaXCliente;
    }
    
    public String getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(String Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    
    
    
    
}
