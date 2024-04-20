package Datos;

import Entidad.Curso;
import Entidad.Docente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CursoDAO {
    private Connection cnn = null;
    private ResultSet rs=null;
    private static CursoDAO instancia;
    
    public static CursoDAO getInstancia(){
        if(instancia==null)
            instancia=new CursoDAO();
        return instancia;
    }
    
    public void insertar(Curso curso)throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall("call insertar_curso(?,?,?)");
            ps.setString(1, curso.getIdCurso());
            ps.setString(2, curso.getNombre());
            ps.setString(3, curso.getProfesor().getIddocente());
            ps.executeUpdate();
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error en SQL: "+ ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }
    
    public void actualizar(Curso curso) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall("call modificar_curso(?,?,?)");
            ps.setString(1, curso.getIdCurso());
            ps.setString(2, curso.getNombre());
            ps.setString(3, curso.getProfesor().getIddocente());
            ps.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error en SQL: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void eliminar(String idCurso)throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall("call eliminar_curso (?)");
            ps.setString(1, idCurso);
            ps.executeUpdate();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error en SQL: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public Curso buscarCurso(String idCurso) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        Curso curso = null;
        try {
            ps = cnn.prepareCall("call buscar_curso (?)");
            ps.setString(1, idCurso);
            rs = ps.executeQuery();
            if (rs.next()){     
                String nombre = rs.getString("nombre");
                String iddocente = rs.getString("iddocente");
                Docente docente = DocenteDAO.getInstancia().buscarProfesor(iddocente);
                curso = new Curso(idCurso,nombre,docente);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en SQL: "+ ex.getMessage());
        }finally {
            cnn.close();
            ps.close();
        }
        return curso;
    }
    
    public ArrayList<Curso> mostrarCursosProfesor(String idProfesor)throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        ResultSet rs1=null;
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try {
            ps=cnn.prepareStatement("SELECT * FROM curso where iddocente = ?");
            ps.setString(1, idProfesor);
            rs1=ps.executeQuery();
            while (rs1.next()) {
                String idCurso=rs1.getString("idcurso");
                Curso curso = buscarCurso(idCurso);
                lista.add(curso);
            }
        } catch (SQLException ex) {
            System.out.println("error mostrar cursos de profesores: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
        return lista;
    }
    public ArrayList<Curso> mostrarCurso() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try{
            ps = cnn.prepareCall("call mostrarCursos()");
            rs = ps.executeQuery();
            while(rs.next()){
                String Idc = rs.getString("idcurso");
                String nombre = rs.getString("nombre");
                String iddocente = rs.getString("iddocente");
                Docente docente = DocenteDAO.getInstancia().buscarProfesor(iddocente);
                Curso m= new Curso(Idc,nombre,docente);
                lista.add(m);
            }
        }catch (SQLException ex){
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    public void mostrarCursos(DefaultTableModel modelo) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[]={"IDCURSO","NOMBRES","ID-DOCENTE"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try{
            String sql = "call mostrarCursos()";
            ps = cnn.prepareCall(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String Idc = rs.getString("idcurso");
                String nombre = rs.getString("nombre");
                String iddocente = rs.getString("iddocente");
                Object fila[] = {Idc,nombre,iddocente};
                modelo.addRow(fila);
            }
        }catch (SQLException ex){
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    public void buscarPorNombre(String nom,DefaultTableModel modelo) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[]={"IDCURSO","NOMBRES","ID-DOCENTE"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            String sql="select * from curso where nombre like ?";
            ps=cnn.prepareCall(sql);
            ps.setString(1,nom+"%");
            rs=ps.executeQuery();
            while(rs.next()){
                String Idc = rs.getString("idcurso");
                String nombre = rs.getString("nombre");
                String iddocente = rs.getString("iddocente");
                Object fila[] = {Idc,nombre,iddocente};
                modelo.addRow(fila);
            }
        }catch (SQLException ex) {
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public int numeroCursos() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareStatement("SELECT COUNT(*) AS num FROM curso");
            rs = ps.executeQuery();
            if(rs.next()){
               return rs.getInt("num");
            }else {
                return 0;
            }
        }catch(SQLException e){
            System.out.println("Error numero de cursos: " + e.getMessage());
            return 0;
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    
    
}
