package Datos;

import Entidad.Apoderado;
import Entidad.Alumno;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class AlumnoDAO {
    private Connection cnn = null;
    private ResultSet rs = null;
    private static AlumnoDAO instancia;
    
    public static AlumnoDAO getInstancia(){
        if(instancia == null)
            instancia = new AlumnoDAO();
        return instancia;
    }
    
    public void insertar(Alumno x) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps=cnn.prepareCall("call insertar_alumno(?,?,?,?,?,?,?,?)");
            ps.setString(1, x.getIdAlumno());
            ps.setString(2, x.getNombres());
            ps.setString(3, x.getApellidos());
            ps.setString(4, x.getSexo());
            ps.setString(5, x.getTelefono());
            ps.setString(6, x.getDireccion());
            ps.setDate(7, Convertir.convertJavaDateTOSQLDate(x.getFechaNacimiento()));
            ps.setString(8, x.getApoderado().getIdApoderado());
            ps.executeUpdate();
        }catch(SQLException ex){
                System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public int numeroAlumnos() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall("Call numero_alumnos()");
            rs = ps.executeQuery();
            if(rs.next()){
               return rs.getInt("num");
            }else {
                return 0;
            }
        }catch(SQLException e){
            System.out.println("Error numero de alumnos: " + e.getMessage());
            return 0;
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public Alumno buscarAlumno(String idalumno) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        Alumno alu = null;
        try{
            String sql = "call buscar_alumno(?)";
            ps = cnn.prepareCall(sql);
            ps.setString(1, idalumno);
            rs = ps.executeQuery();
            if(rs.next()){
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String sexo = rs.getString("sexo");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                String idapoderado = rs.getString("idapoderado");
                Apoderado ap = ApoderadoDAO.getInstancia().buscarApoderado(idapoderado);
                alu = new Alumno(idalumno,nombres,apellidos,sexo,telefono,direccion,fechaNacimiento,ap);
            }
        }catch(SQLException ex){
                System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
        return alu;
    }
    
    public void actualizar(Alumno x) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            String sql = "call modificar_alumno(?,?,?,?,?,?,?,?)";
            ps = cnn.prepareCall(sql);
            ps.setString(1, x.getIdAlumno());
            ps.setString(2, x.getNombres());
            ps.setString(3, x.getApellidos());
            ps.setString(4, x.getSexo());
            ps.setString(5, x.getTelefono());
            ps.setString(6, x.getDireccion());
            ps.setDate(7, Convertir.convertJavaDateTOSQLDate( x.getFechaNacimiento()));
            ps.setString(8, x.getApoderado().getIdApoderado());
            ps.executeUpdate();
        }catch (SQLException ex){
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void eliminar(String idalumno) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall("call eliminar_alumno(?)");
            ps.setString(1, idalumno);
            ps.executeUpdate();
        }catch (SQLException ex){
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void mostrarAlumnos(DefaultTableModel modelo) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[]={"IDALUMNO","NOMBRES","AELLIDOS","SEXO","TEEFONO","DIRECCION","F-NACIMIENTO","IDAPODERADO"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try{
            String sql = "call mostrarAlumnos()";
            ps = cnn.prepareCall(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String idalumno = rs.getString("idalumno");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String sexo = rs.getString("sexo");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                String idapoderado = rs.getString("idapoderado");
                Object fila[] = {idalumno,nombres,apellidos,sexo,telefono,direccion,fechaNacimiento,idapoderado};
                modelo.addRow(fila);
            }
        }catch (SQLException ex){
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void mostrarPorIdAlumno(String cd,DefaultTableModel modelo) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[]={"IDALUMNO","NOMBRES","AELLIDOS","SEXO","TEEFONO","DIRECCION","F-NACIMIENTO","IDAPODERADO"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try{
            String sql = "SELECT * FROM alumno WHERE idalumno like ?";
            ps = cnn.prepareCall(sql);
            ps.setString(1, cd+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                String idalumno = rs.getString("idalumno");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String sexo = rs.getString("sexo");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                String idapoderado = rs.getString("idapoderado");
                Object fila[] = {idalumno,nombres,apellidos,sexo,telefono,direccion,fechaNacimiento,idapoderado};
                modelo.addRow(fila);
            }
        }catch (SQLException ex){
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public ArrayList<Alumno> mostrarAlumno() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList<Alumno> lista = new ArrayList<Alumno>();
        try{
            ps = cnn.prepareCall("call mostrarAlumnos()");
            rs = ps.executeQuery();
            while(rs.next()){
                String idalumno = rs.getString("idalumno");
                Alumno alumno = buscarAlumno(idalumno);
                lista.add(alumno);
            }
        }catch (SQLException ex){
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    public ArrayList<Alumno> mostrarAlumnosApo(String idcodigo)throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        ResultSet rs1=null;
        ArrayList<Alumno> lista = new ArrayList<Alumno>();
        try {
            ps=cnn.prepareStatement("SELECT * FROM alumno where idapoderado = ?");
            ps.setString(1, idcodigo);
            rs1=ps.executeQuery();
            while (rs1.next()) {
                String idal=rs1.getString("idalumno");
                Alumno alu = buscarAlumno(idal);
                lista.add(alu);
            }
        } catch (SQLException ex) {
            System.out.println("error mostrar alumnos de apoderado: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
}
