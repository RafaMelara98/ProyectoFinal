/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

/**
 *
 * @author Van
 */
public class Movimientosrealizados {
    private String categoria, cuenta, operacion, monto, fecha;
    public Movimientosrealizados(){
        
    }

    public Movimientosrealizados(String categoria, String cuenta, String operacion, String monto, String fecha) {
        this.categoria = categoria;
        this.cuenta = cuenta;
        this.operacion = operacion;
        this.monto = monto;
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    
}
