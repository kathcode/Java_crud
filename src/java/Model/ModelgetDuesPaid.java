/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author ubikath
 */
public class ModelgetDuesPaid {
    private int id_pago;
    private Date fecha_pago;
    private int estado_pago;
    private int id_compra;
    private Date fecha_realizado;
    private int valor_cuota;

    public ModelgetDuesPaid(int id_pago, Date fecha_pago, int estado_pago, int id_compra, Date fecha_realizado, int valor_cuota) {
        this.id_pago = id_pago;
        this.fecha_pago = fecha_pago;
        this.estado_pago = estado_pago;
        this.id_compra = id_compra;
        this.fecha_realizado = fecha_realizado;
        this.valor_cuota = valor_cuota;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public int getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(int estado_pago) {
        this.estado_pago = estado_pago;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public Date getFecha_realizado() {
        return fecha_realizado;
    }

    public void setFecha_realizado(Date fecha_realizado) {
        this.fecha_realizado = fecha_realizado;
    }

    public int getValor_cuota() {
        return valor_cuota;
    }

    public void setValor_cuota(int valor_cuota) {
        this.valor_cuota = valor_cuota;
    }
    
}
