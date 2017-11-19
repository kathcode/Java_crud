package Model;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author esneiderserna
 */
public class ModelTipoTarjeta {
    
    private int Codigo_TipoTarjeta;
    private String Nombre_TipoTarjeta;
    private String Acronimo_TipoTarjeta;
    private double Interes_TipoTarjeta;
    private int PlazoMax_TipoTarjeta;
    private double CupoMax_TipoTarjeta;
    private int Multa_TipoTarjeta;
    private int Codigo_Franquicia;
    private Date Fecha_Creacion;
    
    private String Acronimo_Franquicia;

    public ModelTipoTarjeta() {
    }

    public ModelTipoTarjeta(int Codigo_TipoTarjeta, String Nombre_TipoTarjeta, String Acronimo_TipoTarjeta, double Interes_TipoTarjeta, int PlazoMax_TipoTarjeta, double CupoMax_TipoTarjeta, int Multa_TipoTarjeta, int Codigo_Franquicia) {
        this.Codigo_TipoTarjeta = Codigo_TipoTarjeta;
        this.Nombre_TipoTarjeta = Nombre_TipoTarjeta;
        this.Acronimo_TipoTarjeta = Acronimo_TipoTarjeta;
        this.Interes_TipoTarjeta = Interes_TipoTarjeta;
        this.PlazoMax_TipoTarjeta = PlazoMax_TipoTarjeta;
        this.CupoMax_TipoTarjeta = CupoMax_TipoTarjeta;
        this.Multa_TipoTarjeta = Multa_TipoTarjeta;
        this.Codigo_Franquicia = Codigo_Franquicia;
    }

    public int getCodigo_TipoTarjeta() {
        return Codigo_TipoTarjeta;
    }

    public void setCodigo_TipoTarjeta(int Codigo_TipoTarjeta) {
        this.Codigo_TipoTarjeta = Codigo_TipoTarjeta;
    }

    public String getNombre_TipoTarjeta() {
        return Nombre_TipoTarjeta;
    }

    public void setNombre_TipoTarjeta(String Nombre_TipoTarjeta) {
        this.Nombre_TipoTarjeta = Nombre_TipoTarjeta;
    }

    public String getAcronimo_TipoTarjeta() {
        return Acronimo_TipoTarjeta;
    }

    public void setAcronimo_TipoTarjeta(String Acronimo_TipoTarjeta) {
        this.Acronimo_TipoTarjeta = Acronimo_TipoTarjeta;
    }

    public double getInteres_TipoTarjeta() {
        return Interes_TipoTarjeta;
    }

    public void setInteres_TipoTarjeta(double Interes_TipoTarjeta) {
        this.Interes_TipoTarjeta = Interes_TipoTarjeta;
    }

    public int getPlazoMax_TipoTarjeta() {
        return PlazoMax_TipoTarjeta;
    }

    public void setPlazoMax_TipoTarjeta(int PlazoMax_TipoTarjeta) {
        this.PlazoMax_TipoTarjeta = PlazoMax_TipoTarjeta;
    }

    public double getCupoMax_TipoTarjeta() {
        return CupoMax_TipoTarjeta;
    }

    public void setCupoMax_TipoTarjeta(double CupoMax_TipoTarjeta) {
        this.CupoMax_TipoTarjeta = CupoMax_TipoTarjeta;
    }

    public int getMulta_TipoTarjeta() {
        return Multa_TipoTarjeta;
    }

    public void setMulta_TipoTarjeta(int Multa_TipoTarjeta) {
        this.Multa_TipoTarjeta = Multa_TipoTarjeta;
    }

    public int getCodigo_Franquicia() {
        return Codigo_Franquicia;
    }

    public void setCodigo_Franquicia(int Codigo_Franquicia) {
        this.Codigo_Franquicia = Codigo_Franquicia;
    }

    public Date getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(Date Fecha_Creacion) {
        this.Fecha_Creacion = Fecha_Creacion;
    }

    public String getAcronimo_Franquicia() {
        return Acronimo_Franquicia;
    }

    public void setAcronimo_Franquicia(String Acronimo_Franquicia) {
        this.Acronimo_Franquicia = Acronimo_Franquicia;
    }
    
    
    
}
