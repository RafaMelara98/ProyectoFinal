package DATABASE;

import ENTIDADES.Cuenta;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaCuentas {
    public Conexion con;
    
    public ConsultaCuentas() {
        con = new Conexion();
    }
    public boolean agregarCuentasUsuario(int idUsuario, Cuenta cuenta, int idOperacion) throws SQLException{
        Connection c = con.getConnection();
        int a=0;
        boolean agrego = false;
        String query = "INSERT INTO cuenta(Nombre, descripcion) VALUES (?,?);";
        String query2= "SELECT * FROM cuenta WHERE cuenta.Nombre = ?;";
        
        String query3="SELECT cuenta.idcuenta FROM cuenta WHERE cuenta.Nombre = ?;";
        String query4="INSERT INTO movimiento(idcuenta,idoperacion,idusuario,monto,fecha,descripcion) VALUES (?,?,?,?,?,?);";
        
        try{
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, cuenta.getNombreCuenta());
            ps.setString(2, cuenta.getTipoCuenta());
            boolean execute = ps.execute();
            
            PreparedStatement ps2 = c.prepareStatement(query2);
            ps2.setString(1, cuenta.getNombreCuenta());
            
            PreparedStatement ps3 = c.prepareStatement(query3);
            ps3.setString(1, cuenta.getNombreCuenta());
            ResultSet rs = ps3.executeQuery();
            
            if(rs.next()){
                a = rs.getInt("idCuenta");
            }
            
            PreparedStatement ps4 = c.prepareStatement(query4);
            ps4.setInt(1, a);
            ps4.setInt(2,idOperacion);
            ps4.setInt(3, idUsuario);
            ps4.setBigDecimal(4, cuenta.getSaldo());
            ps4.setDate(5, cuenta.getFecha());
            ps4.setString(6, cuenta.getDescripcion());
            

            if(!ps2.executeQuery().isFirst() || execute){
                ps4.execute();
                agrego = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return agrego;
    }
    
    public boolean actualizarCuentasUsuario(String nombreCuenta,Cuenta cuenta) throws SQLException{
        Connection c = con.getConnection();
        boolean actualizo = false;
        String query = "UPDATE cuenta SET nombre = ?, descripcion = ? WHERE nombre = ?;";
        String query2 = "UPDATE movimiento SET monto = ? FROM cuenta WHERE movimiento.idCuenta = Cuenta.idCuenta AND Cuenta.nombre = ?;";
        
        try{
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, cuenta.getNombreCuenta());
            ps.setString(2, cuenta.getTipoCuenta());
            ps.setString(3, nombreCuenta);
            
            PreparedStatement ps2 = c.prepareStatement(query2);
            ps2.setBigDecimal(1, cuenta.getSaldo());
            ps2.setString(2, cuenta.getNombreCuenta());
            
            if(ps.executeUpdate() != 0)
                if(ps2.executeUpdate() != 0)
                    actualizo = true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return actualizo;
    }
    
    public List<Cuenta> obtenerCuentasUsuario(int idUsuario, String Operacion) {
        Connection c = con.getConnection();
        List<Cuenta> listaCuenta = new ArrayList();
        String query = "SELECT cuenta.nombre, cuenta.descripcion, movimiento.monto, operacion.nombre AS operacion\n" +
                        "FROM cuenta, movimiento, operacion, usuario\n" +
                        "WHERE cuenta.idCuenta = movimiento.idCuenta AND operacion.idOperacion = movimiento.idOperacion \n" +
                        "AND usuario.idUsuario = movimiento.idUsuario AND usuario.idUsuario = ? AND operacion.nombre = ?;";
        
        try{
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, idUsuario);
            ps.setString(2,Operacion);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Cuenta unaCuenta = new Cuenta();
                unaCuenta.setNombreCuenta(rs.getString("nombre"));
                unaCuenta.setSaldo(rs.getBigDecimal("monto"));
                unaCuenta.setTipoCuenta(rs.getString("descripcion"));
                unaCuenta.setOperacion(rs.getString("operacion"));
                listaCuenta.add(unaCuenta);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaCuenta;
    }
    
    public boolean eliminarCuentaUsuario(int idUsuario, Cuenta cuenta) throws SQLException{
        boolean elimino = false;
        int a = 0;
        Connection c = con.getConnection();
        String query = "SELECT Cuenta.idCuenta FROM Cuenta WHERE Cuenta.nombre = ?;";
        String query1 = "DELETE FROM Movimiento WHERE Movimiento.idCuenta = ? AND Movimiento.idUsuario = ?;";
        String query2 = "DELETE FROM Cuenta WHERE Cuenta.idCuenta = ?;";
        
        try{
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, cuenta.getNombreCuenta());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                a = rs.getInt("idCuenta");
            }
            
            PreparedStatement ps1 = c.prepareStatement(query1);
            ps1.setInt(1, a);
            ps1.setInt(2, idUsuario);
            
            PreparedStatement ps2 = c.prepareStatement(query2);
            ps2.setInt(1, a);
            
            if(ps1.executeUpdate() != 0)
                if(ps2.executeUpdate() !=0)
                    elimino = true;
            
            c.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return elimino;
    }
    
    public BigDecimal totalSegunCuenta(int idUsuario,String Operacion) throws SQLException{
        BigDecimal bd = BigDecimal.valueOf(0.0);
        Connection c = con.getConnection();
        String query =  "SELECT SUM(Movimiento.Monto) AS Total\n" +
                        "FROM Movimiento, Operacion, Usuario\n" +
                        "WHERE Movimiento.idUsuario = Usuario.idUsuario AND Movimiento.idOperacion=Operacion.idOperacion\n" +
                        "AND Usuario.idUsuario = ? AND Operacion.Nombre = ?;";
        
        try{
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, idUsuario);
            ps.setString(2, Operacion);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                double cp = rs.getDouble("Total");
                bd = BigDecimal.valueOf(cp);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return bd;
    }
    
    public int obtnerIdUsuario(String usuario){
        int id=0;
        Connection c = con.getConnection();
        String query = "SELECT Usuario.idUsuario FROM Usuario WHERE usuario.usuario = ?;";
        
        try{
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
                id = rs.getInt("idUsuario");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return id;
    }

}