package ENTIDADES;

import java.math.BigDecimal;
import java.sql.Date;

public class Cuenta {
    private String nombreCuenta;
    private BigDecimal Saldo;
    private String tipoCuenta;
    private String Operacion;
    private Date fecha;
    private String descripcion;
    
    public Cuenta(){
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public BigDecimal getSaldo() {
        return Saldo;
    }

    public void setSaldo(BigDecimal Saldo) {
        this.Saldo = Saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getOperacion() {
        return Operacion;
    }

    public void setOperacion(String Operacion) {
        this.Operacion = Operacion;
    }

}
