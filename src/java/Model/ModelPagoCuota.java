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
public class ModelPagoCuota {
    private int valor_a_pagar;
    private int id_pago;

    public ModelPagoCuota(int valor_a_pagar, int id_pago) {
        this.valor_a_pagar = valor_a_pagar;
        this.id_pago = id_pago;
    }

    public int getValor_a_pagar() {
        return valor_a_pagar;
    }

    public void setValor_a_pagar(int valor_a_pagar) {
        this.valor_a_pagar = valor_a_pagar;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }
    
    
}
