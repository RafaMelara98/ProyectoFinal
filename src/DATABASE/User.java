/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

import ENTIDADES.Usuario;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Van
 */
public class User {
    
    public Conexion bd;
    public User(){
        bd = new Conexion();
        
    }
    
    public Usuario Login(String usuario, String contraseña) throws SQLException{
        boolean flag = false;
        Connection conn = bd.getConnection();
        Usuario obusuario = new Usuario();
        String query = "SELECT * FROM usuario WHERE usuario = ? AND contraseña = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, usuario);
            pstm.setString(2, contraseña);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                obusuario.setUsername(rs.getString("usuario"));
                obusuario.setPassword(rs.getString("contraseña"));
                flag = true;
            }
            if(!flag) obusuario = null;
            //conn.close();
        }catch(SQLException ex){
            obusuario = null;
            ex.printStackTrace();
        }
        return obusuario;
        
        
    }
    public boolean signUp(String usuario,String contraseña) throws SQLException{
        Connection conn = bd.getConnection();
        boolean isSuccess = false;
        
        String query = "INSERT INTO usuario VALUES (default,?,?)";
        String query2 = "SELECT * FROM usuario  WHERE usuario= ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            PreparedStatement pstm2 = conn.prepareStatement(query2);
            pstm.setString(1, usuario);
            pstm.setString(2, contraseña);
            
            pstm2.setString(1, usuario);
            if(!pstm2.executeQuery().isFirst()){
                pstm.execute();
                isSuccess = true;
            }
        }catch(SQLException ex){
            isSuccess = false;
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    public boolean Operacion(int idcategoria, int idcuenta, int idoperacion, int idusuario,BigDecimal dinero, java.sql.Date fecha,String descripcion) throws SQLException{
        Connection conn = bd.getConnection();
        boolean isSuccess = false;
        String query3 = "INSERT INTO movimiento(idcategoria,idcuenta,idoperacion,idusuario,monto,fecha,descripcion) VALUES(?,?,?,?,?,?,?)";
        String query4 = "SELECT * FROM movimiento WHERE idmovimiento= ?";
   
        
        String lastCrawlDate = "2014-01-28";

        //p.setDate(1, Date.valueOf(lastCrawlDate));
        
        try{
            PreparedStatement pstm3 = conn.prepareStatement(query3);
            PreparedStatement pstm4 = conn.prepareStatement(query4);
            
            
       /*     pstm3.setString(1, "2");
            pstm3.setString(2, "1");
            pstm3.setString(3, "1");
            pstm3.setString(4, "1");
            pstm3.setString(5, "1");
            pstm3.execute();
       */
            pstm3.setInt(1, idcategoria);
            pstm3.setInt(2, idcuenta);
            pstm3.setInt(3, idoperacion);
            pstm3.setInt(4, idusuario);
            pstm3.setBigDecimal(5, dinero);
            pstm3.setDate(6,fecha);
            pstm3.setString(7,descripcion);
//*/
//            pstm3.setDate(6, Date.valueOf("2018-05-21"));
//            pstm3.setString(7, "descripcionxd");
            pstm3.execute();
            
            pstm4.setInt(1, 1);
            if(!pstm4.executeQuery().isFirst()){
                pstm4.execute();
                isSuccess = true;
            }
        }catch(SQLException ex){
            isSuccess = false;
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    public ArrayList<Movimientosrealizados> getAllMovimientos(int idusuario){
        ConsultaCuentas id = new ConsultaCuentas();
        Connection conn = bd.getConnection();
        ArrayList<Movimientosrealizados> movList = new ArrayList();
        String query = "SELECT ca.nombre as Categoria, cu.nombre as Cuenta, o.nombre as Operacion, mo.monto, mo.fecha\n" +
        "FROM movimiento mo, usuario u, categoria ca, cuenta cu, operacion o\n" +
        "WHERE mo.idcategoria=ca.idcategoria AND mo.idcuenta=cu.idcuenta AND o.idoperacion=mo.idoperacion AND u.idusuario=mo.idusuario AND mo.fecha is not null AND mo.idusuario = ?  ORDER BY mo.fecha";
        try{
            System.out.println(idusuario);
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1,idusuario);
            ResultSet rs = stm.executeQuery();
            Movimientosrealizados mov;
            
            
            while(rs.next()){
                mov= new Movimientosrealizados(rs.getString("categoria"),rs.getString("cuenta"),rs.getString("operacion"),rs.getString("monto"),rs.getString("fecha"));
                movList.add(mov);
            }
            //conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return movList;
    }
    
    public ArrayList<Cuentascreadas> getAllCuentas(){
        Connection conn = bd.getConnection();
        ArrayList<Cuentascreadas> cueList = new ArrayList();
        String query = "SELECT c.nombre\n" + "FROM cuenta c";
        try{
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            Cuentascreadas cue;
            
            while(rs.next()){
                cue= new Cuentascreadas(rs.getString("nombre"));
                cueList.add(cue);
            }
            //conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return cueList;
    }
    
    public int obteneridCuenta(String nombre){
        int id=0;
        Connection conn = bd.getConnection();
        String query = "SELECT c.idcuenta FROM Cuenta c WHERE c.nombre = ?;";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
                id = rs.getInt("idcuenta");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return id;
    } 
    
    public boolean cambiarContraseña(Usuario user){
        Connection conn = bd.getConnection();
        boolean update = false;
        String query = "UPDATE USUARIO SET contraseña = ? WHERE Usuario.usuario = ?;";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getUsername());
            
            if(ps.executeUpdate() != 0)
                update = true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return update;
    }
  
    /*public List<Usuario> getAllMovimientos(){
        Connection conn = bd.getConnection();
        List<Usuario> users = new ArrayList();
        String query = "SELECT * FROM movimiento";
        try{
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setUsername(rs.getString("usuario"));
                usuario.setPassword(rs.getString("contraseña"));
                users.add(usuario);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return users;
    }*/

    
}
