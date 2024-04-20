package Datos;

import Entidad.Apoderado;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ApoderadoDAO {
    private Connection cnn = null;
    private ResultSet rs = null;
    ApoderadoDAO dao = null;
    
    private static ApoderadoDAO instancia;
    
    public static ApoderadoDAO getInstancia(){
        if(instancia == null)
            instancia = new ApoderadoDAO();
        return instancia;
    }
    
    public void insertar(Apoderado x) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps=cnn.prepareCall("call insertar_apoderado(?,?,?,?,?,?)");
            ps.setString(1, x.getIdApoderado());
            ps.setString(2, x.getNombresp());
            ps.setString(3, x.getApellidosp());
            ps.setString(4, x.getTelefono());
            ps.setString(5, x.getDireccion());
            ps.setString(6, x.getEstadoCivil());
            ps.executeUpdate();
        }catch(SQLException ex){
                System.out.println(" ");
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public int numeroApoderados() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall("call numero_apoderados()");
            rs = ps.executeQuery();
            if(rs.next()){
               return rs.getInt("num");
            }else {
                return 0;
            }
        }catch(SQLException e){
            System.out.println("");
            return 0;
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public Apoderado buscarApoderado(String idapoderado) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        Apoderado ap = null;
        try{
            String sql = "call buscar_apoderado(?)";
            ps = cnn.prepareCall(sql);
            ps.setString(1, idapoderado);
            rs = ps.executeQuery();
            if(rs.next()){
                String nombresp = rs.getString("nombresp");
                String apellidosp = rs.getString("apellidosp");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String estadoCivil = rs.getString("estadoCivil");
                ap = new Apoderado(idapoderado,nombresp,apellidosp,telefono,direccion,estadoCivil);
            }
        }catch(SQLException ex){
                System.out.println("");
        }finally{
            cnn.close();
            ps.close();
        }
        return ap;
    }
    
    public void actualizar(Apoderado ap) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            String idapoderado = ap.getIdApoderado();
            String nombresp = ap.getNombresp();
            String apellidosp = ap.getApellidosp();
            String telefono = ap.getTelefono();
            String direccion = ap.getDireccion();
            String estadoCivil = ap.getEstadoCivil();
            String sql = "call modificar_apoderado(?,?,?,?,?,?)";
            ps = cnn.prepareCall(sql);
            ps.setString(1, idapoderado);
            ps.setString(2, nombresp);
            ps.setString(3, apellidosp);
            ps.setString(4, telefono);
            ps.setString(5, direccion);
            ps.setString(6, estadoCivil);  
            ps.executeUpdate();
        }catch (SQLException ex){
            System.out.println("");
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void eliminar(String idapoderado) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            String sql = "call eliminar_apoderado(?)";
            ps = cnn.prepareCall(sql);
            ps.setString(1, idapoderado);
            ps.executeUpdate();
        }catch (SQLException ex){
            System.out.println(" ");
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void mostrarApoderados(DefaultTableModel modelo) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[]={"IDAPODERADO","NOMBRES","APELLIDOS","TELEFONO","DIRECCION","E-CIVIL"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try{
            String sql = "call mostrarApoderados()";
            ps = cnn.prepareCall(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String idapoderado = rs.getString("idapoderado");
                String nombresp = rs.getString("nombresp");
                String apellidosp = rs.getString("apellidosp");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String estadoCivil = rs.getString("estadoCivil");
                String fila[] = {idapoderado,nombresp,apellidosp,telefono,direccion,estadoCivil};
                modelo.addRow(fila);
            }
        }catch (SQLException ex){
            System.out.println(" ");
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void mostrarPorIdApoderado(String cd,DefaultTableModel modelo) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[]={"IDAPODERADO","NOMBRES","APELLIDOS","TELEFONO","DIRECCION","E-CIVIL"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try{
            String sql = "SELECT * FROM apoderado WHERE idapoderado like ?";
            ps = cnn.prepareCall(sql);
            ps.setString(1, cd+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                String idapoderado = rs.getString("idapoderado");
                String nombresp = rs.getString("nombresp");
                String apellidosp = rs.getString("apellidosp");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String estadoCivil = rs.getString("estadoCivil");
                String fila[] = {idapoderado,nombresp,apellidosp,telefono,direccion,estadoCivil};
                modelo.addRow(fila);
            }
        }catch (SQLException ex){
            System.out.println("");
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public ArrayList<Apoderado> mostrarApoderado() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList<Apoderado> lista = new ArrayList<Apoderado>();
        try{
            ps = cnn.prepareCall("call mostrarApoderados()");
            rs = ps.executeQuery();
            while(rs.next()){
                String idapoderado = rs.getString("idapoderado");
                String nombresp = rs.getString("nombresp");
                String apellidosp = rs.getString("apellidosp");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String estadoCivil = rs.getString("estadoCivil");
                Apoderado ap = new Apoderado(idapoderado,nombresp,apellidosp,telefono,direccion,estadoCivil); 
                lista.add(ap);
            }
        }catch (SQLException ex){
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
}
