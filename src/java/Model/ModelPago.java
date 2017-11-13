/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author esneiderserna
 */
public class ModelPago {
    private int Id_Pago;
    private Date Fecha_Pago;
    private int Valor_Pago;
    private int Interes_Pago;
    private int Mora_Pago;
    private int Id_Compra;

    public ModelPago(int Id_Pago, Date Fecha_Pago, int Valor_Pago, int Interes_Pago, int Mora_Pago, int Id_Compra) {
        this.Id_Pago = Id_Pago;
        this.Fecha_Pago = Fecha_Pago;
        this.Valor_Pago = Valor_Pago;
        this.Interes_Pago = Interes_Pago;
        this.Mora_Pago = Mora_Pago;
        this.Id_Compra = Id_Compra;
    }

    public int getId_Pago() {
        return Id_Pago;
    }

    public void setId_Pago(int Id_Pago) {
        this.Id_Pago = Id_Pago;
    }

    public Date getFecha_Pago() {
        return Fecha_Pago;
    }

    public void setFecha_Pago(Date Fecha_Pago) {
        this.Fecha_Pago = Fecha_Pago;
    }

    public int getValor_Pago() {
        return Valor_Pago;
    }

    public void setValor_Pago(int Valor_Pago) {
        this.Valor_Pago = Valor_Pago;
    }

    public int getInteres_Pago() {
        return Interes_Pago;
    }

    public void setInteres_Pago(int Interes_Pago) {
        this.Interes_Pago = Interes_Pago;
    }

    public int getMora_Pago() {
        return Mora_Pago;
    }

    public void setMora_Pago(int Mora_Pago) {
        this.Mora_Pago = Mora_Pago;
    }

    public int getId_Compra() {
        return Id_Compra;
    }

    public void setId_Compra(int Id_Compra) {
        this.Id_Compra = Id_Compra;
    }
    
}
