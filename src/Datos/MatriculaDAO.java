package Datos;

import Entidad.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class MatriculaDAO {
    private Connection cnn = null;
    private ResultSet rs=null;
    private static MatriculaDAO instancia;
    
    public static MatriculaDAO getInstancia(){
        if(instancia==null)
            instancia=new MatriculaDAO();
        return instancia;
    }
    
    public void insertar(Matricula a) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        try {
            ps = cnn.prepareCall("call insertar_matricula(?,?,?,?)");            
            ps.setString(1, a.getIdMatricula());
            ps.setDate(2, Convertir.convertJavaDateTOSQLDate(a.getFecha()));
            ps.setString(3, a.getAlumno().getIdAlumno());
            ps.setString(4, a.getProgramacion().getIdProgramacion());       
            ps.executeUpdate();
            ListaDetalleMatricula LM=a.getLD();
            for(int i=0;i<LM.getN();i++){
                DetalleMatricula x=LM.getElemento(i);
                String sql="call insertar_matricula_curso(?,?)";
                ps = cnn.prepareCall(sql);
                ps.setString(1,a.getIdMatricula()) ;
                ps.setString(2,x.getCurso().getIdCurso());
                ps.executeUpdate();
            }             
        } catch (SQLException ex) {
            System.out.println("error insertar matricula: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }
    
    public int cantidad() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareStatement("SELECT COUNT(*) AS num FROM matricula");
            rs = ps.executeQuery();
            if(rs.next()){
               return rs.getInt("num");
            }else {
                return 0;
            }
        }catch(SQLException e){
            System.out.println("Error cantidad matricula: " + e.getMessage());
            return 0;
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public Matricula buscarMatricula(String idMatricula) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        Matricula  matricula = null;
        try {
            String sql="call buscar_matricula(?)";
            ps = cnn.prepareCall(sql);
            ps.setString(1, idMatricula);
            rs = ps.executeQuery();
            if (rs.next()) {
                Date fecha = rs.getDate("fecha");
                String idAlumno = rs.getString("idalumno");
                Alumno alumno = AlumnoDAO.getInstancia().buscarAlumno(idAlumno);
                String idProgramacion = rs.getString("idprogramacion");
                Programacion programacion = ProgramacionDAO.getInstancia().buscarProgramacion(idProgramacion);
                matricula = new Matricula(idMatricula,fecha,alumno,programacion);
                ps1=cnn.prepareCall("call buscar_matricula_curso(?)");
                ps1.setString(1, idMatricula);
                rs=ps1.executeQuery();
                    while(rs.next()){
                        String idCurso = rs.getString("idcurso");
                        Curso curso = CursoDAO.getInstancia().buscarCurso(idCurso);
                        matricula.regitrarDetalleMatricula(curso);
                    }
                    ps1.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error buscar matricula : " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
            ps1.close();        
        }
        return matricula;
    }
    
    
    public ArrayList<Matricula> mostrarMatricula() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList<Matricula> lista = new ArrayList<Matricula>();
        try{
            ps = cnn.prepareCall("call mostrarMatriculas()");
            rs = ps.executeQuery();
            while(rs.next()){
                String idMatricula = rs.getString("idmatricula");
                Date fecha = rs.getDate("fecha");
                String idProgramacion = rs.getString("idprogramacion");
                Programacion programacion = ProgramacionDAO.getInstancia().buscarProgramacion(idProgramacion);
                String idAlumno = rs.getString("idalumno");
                Alumno alumno = AlumnoDAO.getInstancia().buscarAlumno(idAlumno);
                Matricula m= new Matricula(idMatricula,fecha,alumno,programacion);
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
    public void eliminar(String idMatricula)throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            String sql="call eliminar_matricula(?)";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idMatricula);
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error eliminar matricula" + ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
}