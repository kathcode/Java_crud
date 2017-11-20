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
    private Date Fecha_de_Pago;
    private int Valor_Saldo;
    private int Abono_Capital;
    private double Valor_Interes;
    private double Valor_Cuota;
    private int Nuevo_Saldo;
    private boolean Estado_Pago;
    private int Id_Compra;
    private Date Fecha_Realizado;
    private Date Fecha_Creacion;
    
    private int Multa_Mora;

    public ModelPago() {
    }

    public ModelPago(int Id_Pago, Date Fecha_de_Pago, int Valor_Saldo, int Abono_Capital, double Valor_Interes, double Valor_Cuota, int Nuevo_Saldo, boolean Estado_Pago, int Id_Compra) {
        this.Id_Pago = Id_Pago;
        this.Fecha_de_Pago = Fecha_de_Pago;
        this.Valor_Saldo = Valor_Saldo;
        this.Abono_Capital = Abono_Capital;
        this.Valor_Interes = Valor_Interes;
        this.Valor_Cuota = Valor_Cuota;
        this.Nuevo_Saldo = Nuevo_Saldo;
        this.Estado_Pago = Estado_Pago;
        this.Id_Compra = Id_Compra;
    }

    public int getId_Pago() {
        return Id_Pago;
    }

    public void setId_Pago(int Id_Pago) {
        this.Id_Pago = Id_Pago;
    }

    public Date getFecha_de_Pago() {
        return Fecha_de_Pago;
    }

    public void setFecha_de_Pago(Date Fecha_de_Pago) {
        this.Fecha_de_Pago = Fecha_de_Pago;
    }

    public int getValor_Saldo() {
        return Valor_Saldo;
    }

    public void setValor_Saldo(int Valor_Saldo) {
        this.Valor_Saldo = Valor_Saldo;
    }

    public int getAbono_Capital() {
        return Abono_Capital;
    }

    public void setAbono_Capital(int Abono_Capital) {
        this.Abono_Capital = Abono_Capital;
    }

    public double getValor_Interes() {
        return Valor_Interes;
    }

    public void setValor_Interes(double Valor_Interes) {
        this.Valor_Interes = Valor_Interes;
    }

    public double getValor_Cuota() {
        return Valor_Cuota;
    }

    public void setValor_Cuota(double Valor_Cuota) {
        this.Valor_Cuota = Valor_Cuota;
    }

    public int getNuevo_Saldo() {
        return Nuevo_Saldo;
    }

    public void setNuevo_Saldo(int Nuevo_Saldo) {
        this.Nuevo_Saldo = Nuevo_Saldo;
    }

    public boolean getEstado_Pago() {
        return Estado_Pago;
    }

    public void setEstado_Pago(boolean Estado_Pago) {
        this.Estado_Pago = Estado_Pago;
    }

    public int getId_Compra() {
        return Id_Compra;
    }

    public void setId_Compra(int Id_Compra) {
        this.Id_Compra = Id_Compra;
    }

    public Date getFecha_Realizado() {
        return Fecha_Realizado;
    }

    public void setFecha_Realizado(Date Fecha_Realizado) {
        this.Fecha_Realizado = Fecha_Realizado;
    }

    public Date getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(Date Fecha_Creacion) {
        this.Fecha_Creacion = Fecha_Creacion;
    }
    
    

    public int getMulta_Mora() {
        return Multa_Mora;
    }

    public void setMulta_Mora(int Multa_Mora) {
        this.Multa_Mora = Multa_Mora;
    }
    
    

}
