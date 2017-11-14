
package Model;

import java.util.Date;

/**
 *
 * @author esneiderserna
 */
public class ModelInfoProyeccion {
    
    private int Numero_Couta;
    private Date Fecha;
    private int Valor_Saldo;
    private int Abono_Capital;
    private double Valor_Interes;
    private double Valor_Cuota;
    private int Nuevo_Saldo;

    public ModelInfoProyeccion() {
    }

    public int getNumero_Couta() {
        return Numero_Couta;
    }

    public void setNumero_Couta(int Numero_Couta) {
        this.Numero_Couta = Numero_Couta;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
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
    
    
    
    
}
