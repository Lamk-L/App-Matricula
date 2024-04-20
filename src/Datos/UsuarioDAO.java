package Datos;

import Entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lamk
 */
public class UsuarioDAO {
    private Connection cnn = null;
    private ResultSet rs = null;
    ApoderadoDAO dao = null;
    
    private static UsuarioDAO instancia;
    
    public static UsuarioDAO getInstancia(){
        if(instancia == null)
            instancia = new UsuarioDAO();
        return instancia;
    }
    
    public void insertar(Usuario x) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps=cnn.prepareCall("call insertar_usuario(?,?)");
            ps.setString(1, x.getUsuario());
            ps.setString(2, x.getClave());
            ps.executeUpdate();
        }catch(SQLException ex){
                System.out.println(" ");
        }finally{
            cnn.close();
            ps.close();
        }
    }
}
