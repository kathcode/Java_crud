/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author esneider.serna
 */
public class ModelListProyeccion {
    
    private ModelCompra InfoCompra;
    private List<ModelInfoProyeccion> InfoProyeccion;
    private int Cuota_Mensual;

    public ModelListProyeccion() {
    }

    public ModelCompra getInfoCompra() {
        return InfoCompra;
    }

    public void setInfoCompra(ModelCompra InfoCompra) {
        this.InfoCompra = InfoCompra;
    }

    public List<ModelInfoProyeccion> getInfoProyeccion() {
        return InfoProyeccion;
    }

    public void setInfoProyeccion(List<ModelInfoProyeccion> InfoProyeccion) {
        this.InfoProyeccion = InfoProyeccion;
    }
    
    public int getCuota_Mensual() {
        return Cuota_Mensual;
    }

    public void setCuota_Mensual(int Cuota_Mensual) {
        this.Cuota_Mensual = Cuota_Mensual;
    }
    
}
