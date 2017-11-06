/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

/**
 *
 * @author Catalina
 */
public class ModelFranquicias {
    private Integer Codigo_Franquicia = null;
    private String Nombre_Franquicia;
    private String Acronimo_Franquicia;
    private int RangoPingMax_Franquicia;
    private int RangoPingMin_Franquicia;
    private Date Fecha_Creacion;

    public ModelFranquicias(Integer Codigo_Franquicia, String Nombre_Franquicia, String Acronimo_Franquicia, int RangoPingMax_Franquicia, int RangoPingMin_Franquicia, Date Fecha_Creacion) {
        this.Codigo_Franquicia = Codigo_Franquicia;
        this.Nombre_Franquicia = Nombre_Franquicia;
        this.Acronimo_Franquicia = Acronimo_Franquicia;
        this.RangoPingMax_Franquicia = RangoPingMax_Franquicia;
        this.RangoPingMin_Franquicia = RangoPingMin_Franquicia;
        this.Fecha_Creacion = Fecha_Creacion;
    }

    

    public int getCodigo_Franquicia() {
        return Codigo_Franquicia;
    }

    public String getNombre_Franquicia() {
        return Nombre_Franquicia;
    }

    public String getAcronimo_Franquicia() {
        return Acronimo_Franquicia;
    }

    public int getRangoPingMax_Franquicia() {
        return RangoPingMax_Franquicia;
    }

    public int getRangoPingMin_Franquicia() {
        return RangoPingMin_Franquicia;
    }

    public Date getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setCodigo_Franquicia(int Codigo_Franquicia) {
        this.Codigo_Franquicia = Codigo_Franquicia;
    }

    public void setNombre_Franquicia(String Nombre_Franquicia) {
        this.Nombre_Franquicia = Nombre_Franquicia;
    }

    public void setAcronimo_Franquicia(String Acronimo_Franquicia) {
        this.Acronimo_Franquicia = Acronimo_Franquicia;
    }

    public void setRangoPingMax_Franquicia(int RangoPingMax_Franquicia) {
        this.RangoPingMax_Franquicia = RangoPingMax_Franquicia;
    }

    public void setRangoPingMin_Franquicia(int RangoPingMin_Franquicia) {
        this.RangoPingMin_Franquicia = RangoPingMin_Franquicia;
    }

    public void setFecha_Creacion(Date Fecha_Creacion) {
        this.Fecha_Creacion = Fecha_Creacion;
    }
}

