package DATABASE;

import ENTIDADES.Cuenta;
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
    public boolean agregarCuentasUsuario(int idUsuario, String nombreCuenta,String tipoCuenta, String operacion, double monto ) throws SQLException{
        Connection c = con.getConnection();
        boolean agrego = false;
        String query = "INSERT INTO Movimiento(idCategoria,idCuenta,idOperacion,IdUsuario,Monto) VALUES (?,?,?,?,?)";
        String query3 = "INSERT INTO Categoria (Nombre) VALUES (?);";//Insertar en la tabla categoria
        String query4 = "SELECT Movimiento.Monto, Cuenta.Nombre AS tipoCuenta , Operacion.Nombre AS Operacion, Categoria.Nombre AS NombreCuenta\n" +
                        "FROM Movimiento, Cuenta, Operacion, Categoria\n" +
                        "WHERE Movimiento.idUsuario = ? AND Movimiento.idCuenta = Cuenta.idCuenta \n" +
                        "AND Movimiento.idOperacion = Operacion.idOperacion AND Movimiento.idCategoria = Categoria.idCategoria \n" +
                        "AND Categoria.Nombre = ?;";//muestra si se agrego la cuenta
        
        
        String obteneridcategoria = "SELECT Categoria.idCategoria FROM Categoria ORDER BY idCategoria DESC;";
        
        try{
            PreparedStatement ps = c.prepareStatement(query);            
            PreparedStatement ps3 = c.prepareStatement(query3);
            PreparedStatement ps4 = c.prepareStatement(query4);
            
            PreparedStatement ox = c.prepareStatement(obteneridcategoria);
            ResultSet rs = ox.executeQuery();
            
            int ca = rs.getInt("idCategoria") + 1;
            
            ps.setInt(1, ca);
            if(tipoCuenta.equals("Debito")){// en la base de datos el id de debito es 1
                ps.setInt(2, 1);
            }else if(tipoCuenta.equals("Efectivo")){// en la base de datos el id de efectivo es 3
                ps.setInt(2, 3);
            }else if(tipoCuenta.equals("Credito")){// en la base de datos el id de credito es 2
                ps.setInt(2, 2);
            }
            if(operacion.equals("Abono")){// en la base de datos el id de Abono es 1 
                ps.setInt(3, 1);
            }else if(operacion.equals("Cargo")){// en la base de datos el id de cargo es 2
                ps.setInt(3, 2);
            }
            ps.setInt(4, idUsuario);
            ps.setDouble(5, monto);                   
            ps3.setString(1, nombreCuenta);
            ps4.setInt(1, idUsuario);
            ps4.setString(2, nombreCuenta);
                 

            if(!ps4.executeQuery().isFirst()){
                ps3.executeQuery();
                ps.executeQuery();
                agrego = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return agrego;
    }
    
    public boolean actualizarCuentasUsuario(int idUsuario,String nombreCuenta,String nOperacion, String nCuenta, double nMonto,String nTipo) throws SQLException{
        Connection c = con.getConnection();
        boolean actualizo = false;
        String query = "UPDATE Movimiento SET idCuenta = ?,idOperacion = ?,Monto = ?\n" +
                       "WHERE Movimiento.idUsuario = ? AND Movimiento.idCategoria = ?;";
        
        String query2 = "SELECT Categoria.idCategoria FROM Categoria WHERE Categoria.Nombre = ?;";
        
        String query3 = "UPDATE Categoria SET Nombre = ? WHERE Categoria.idCategoria = ?;";
        
        try{
            PreparedStatement ps = c.prepareStatement(query);
            PreparedStatement ps2 = c.prepareStatement(query2);
            PreparedStatement ps3 = c.prepareStatement(query3);
            ps2.setString(1, nombreCuenta);
            ResultSet rs = ps2.executeQuery();
            int n = rs.getInt("idCategoria");
            
            if(nTipo.equals("Debito")){// en la base de datos el id de debito es 1
                ps.setInt(1, 1);
            }else if(nTipo.equals("Credito")){// en la base de datos el id de credito es 2
                ps.setInt(1, 2);
            }else if(nTipo.equals("Efectivo")){// en la base de datos el id de efectivo es 3
                ps.setInt(1, 3);
            }
            if(nOperacion.equals("Abono")){// en la base de datos el id de Abono es 1
                ps.setInt(2, 1);
            }else if(nOperacion.equals("Cargo")){// en la base de datos el id de cargo es 2
                ps.setInt(2, 2);
            }
            ps.setDouble(3, nMonto);
            ps.setInt(4, idUsuario);
            ps.setInt(5,n);
            
            ps3.setString(1, nCuenta);
            ps3.setInt(2, n);
            
            if(ps3.executeUpdate()!=0 && ps.executeUpdate()!=0)
                actualizo = true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return actualizo;
    }
    
    public List<Cuenta> obtenerCuentasUsuario(int idUsuario) throws SQLException{
        Connection c = con.getConnection();
        List<Cuenta> listaCuenta = new ArrayList();
        String query = "SELECT Movimiento.Monto, Cuenta.Nombre AS tipoCuenta , Operacion.Nombre AS Operacion, Categoria.Nombre AS NombreCuenta\n" +
                       "FROM Movimiento, Cuenta, Operacion, Categoria\n" +
                       "WHERE Movimiento.idUsuario = ? AND Movimiento.idCuenta=Cuenta.idCuenta \n" +
                       "AND Movimiento.idOperacion=Operacion.idOperacion AND Movimiento.idCategoria=Categoria.idCategoria;";
        
        try{
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Cuenta unaCuenta = new Cuenta();
                unaCuenta.setNombreCuenta(rs.getString("NombreCuenta"));
                unaCuenta.setSaldo(rs.getInt("Monto"));
                unaCuenta.setTipoCuenta(rs.getString("TipoCuenta"));
                unaCuenta.setOperacion(rs.getString("Operacion"));
                listaCuenta.add(unaCuenta);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaCuenta;
    }
    
    public boolean eliminarCuentaUsuario(int idUsuario, String nombreCuenta) throws SQLException{
        boolean elimino = false;
        Connection c = con.getConnection();
        String query = "SELECT Categoria.idCategoria FROM Categoria WHERE Categoria.Nombre = ?;";
        String query1 = "DELETE FROM Movimiento WHERE Movimiento.idCategoria = ? AND Moviemiento.idUsuario = ?;";
        String query2 = "DELETE FROM Categoria WHERE Categoria.idCategoria = ?;";
        
        try{
            PreparedStatement ps = c.prepareStatement(query);
            PreparedStatement ps1 = c.prepareStatement(query1);
            PreparedStatement ps2 = c.prepareStatement(query2);
            ps.setString(1, nombreCuenta);
            ResultSet rs = ps.executeQuery();
            int m = rs.getInt("idCategoria");
            
            ps1.setInt(1,m);
            ps1.setInt(2,idUsuario);
            
            ps2.setInt(1, m);
            
            int p = ps1.executeUpdate();
            int p1 = ps2.executeUpdate();
            if( p!= 0 && p1!= 0)
                elimino = true;
            c.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return elimino;
    }
    
    public double totalSegunCuenta(int idUsuario,String tipoCuenta) throws SQLException{//tipo cuenta abono o cargo
        double total = 0 ;
        Connection c = con.getConnection();
        String query = "SELECT Cuenta.Nombre AS TipoCuenta,SUM(Movimiento.Monto) AS TOTAL\n" +
                       "FROM Movimiento, Cuenta, Usuario\n" +
                       "WHERE Movimiento.idUsuario = Usuario.idUsuario AND Movimiento.idCuenta = Cuenta.idCuenta\n" +
                       "AND Usuario.idUsuario = ? AND Cuenta.idCuenta = ?\n" +
                       "GROUP BY TipoCuenta;";
        
        try{
            PreparedStatement ps = c.prepareStatement(query);
            
            ps.setInt(1, idUsuario);
            if(tipoCuenta.equals("Debito")){// en la base de datos el id de debito es 1
                ps.setInt(2, 1);
            }else if(tipoCuenta.equals("Credito")){// en la base de datos el id de credito es 2
                ps.setInt(2, 2);
            }else if(tipoCuenta.equals("Efectivo")){// en la base de datos el id de efectivo es 3
                ps.setInt(2, 3);
            }           
            ResultSet rs = ps.executeQuery();
            total = rs.getDouble("TOTAL");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return total;
    }
}
