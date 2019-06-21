/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

import ENTIDADES.Usuario;
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
