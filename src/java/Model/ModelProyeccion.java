/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ubikath
 */
public class ModelProyeccion {
    private int Id_Proyeccion;
    private int Id_Tarjeta;
    private int Valor_Cuota;
    private int Id_Compra;

    public ModelProyeccion(int Id_Proyeccion, int Id_Tarjeta, int Valor_Cuota, int Id_Compra) {
        this.Id_Proyeccion = Id_Proyeccion;
        this.Id_Tarjeta = Id_Tarjeta;
        this.Valor_Cuota = Valor_Cuota;
        this.Id_Compra = Id_Compra;
    }

    public int getId_Proyeccion() {
        return Id_Proyeccion;
    }

    public void setId_Proyeccion(int Id_Proyeccion) {
        this.Id_Proyeccion = Id_Proyeccion;
    }

    public int getId_Tarjeta() {
        return Id_Tarjeta;
    }

    public void setId_Tarjeta(int Id_Tarjeta) {
        this.Id_Tarjeta = Id_Tarjeta;
    }

    public int getValor_Cuota() {
        return Valor_Cuota;
    }

    public void setValor_Cuota(int Valor_Cuota) {
        this.Valor_Cuota = Valor_Cuota;
    }

    public int getId_Compra() {
        return Id_Compra;
    }

    public void setId_Compra(int Id_Compra) {
        this.Id_Compra = Id_Compra;
    }
    
}
