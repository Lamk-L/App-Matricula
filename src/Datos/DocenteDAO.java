package Datos;

import Entidad.Alumno;
import Entidad.DetalleDocente;
import Entidad.Docente;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DocenteDAO {
    private Connection cnn=null;
    private ResultSet rs = null;
    private static DocenteDAO instancia;
    
    public static DocenteDAO getInstancia(){
        if(instancia==null){
            instancia = new DocenteDAO();
        }
        return instancia;
    }
    
    public void insertar(Docente p) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall(" call insertar_docente(?,?,?,?,?,?)"); 
            ps.setString(1, p.getIddocente());
            ps.setString(2, p.getDni());
            ps.setString(3, p.getApellidosd());
            ps.setString(4, p.getNombresd());
            ps.setString(5, p.getTelefono());
            ps.setString(6, p.getDireccion());      
            ps.executeUpdate();
            ListaDetalleDocente LD=p.getLD();
            for(int i=0;i<LD.getN();i++){
                DetalleDocente x=LD.getElemento(i);
                String sql="call insertar_docente_alumno(?,?)";
                ps = cnn.prepareCall(sql);
                ps.setString(1, p.getIddocente()) ;
                ps.setString(2, x.getAlumno().getIdAlumno());
                ps.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println("Error insertar Docente-Dao: " + e.getMessage());
        }finally{
            cnn.close();
            ps.close();
        } 
    }
    
    public int numeroProfesores() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall("call numero_docentes()");
            rs = ps.executeQuery();
            if(rs.next()){
               return rs.getInt("num");
            }else {
                return 0;
            }
        }catch(SQLException e){
            System.out.println("Error numero de profesores: " + e.getMessage());
            return 0;
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public Docente buscarProfesor(String iddocente) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        Docente docente = null;
        try{
            ps = cnn.prepareCall("Call buscar_docente(?)");
            ps.setString(1, iddocente);
            rs = ps.executeQuery();
            if (rs.next()) {
                String dni = rs.getString("dni");
                String apellidos = rs.getString("apellidosd");
                String nombres = rs.getString("nombresd");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                docente = new Docente(iddocente,dni,apellidos,nombres,telefono,direccion);
                ps1=cnn.prepareCall("call buscar_docente_alumno(?)");
                ps1.setString(1, iddocente);
                rs=ps1.executeQuery();
                    while(rs.next()){
                        String idalumno = rs.getString("idalumno");
                        Alumno alumno = AlumnoDAO.getInstancia().buscarAlumno(idalumno);
                        docente.regitrarDetalleDocente(alumno);
                    }
                    ps1.close();
            }
        }catch(SQLException e){
            System.out.println("Error buscar profesor -Dao: " + e.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
        return docente;
    }
    
    public void actualizar(Docente p) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall(" call modificar_docente(?,?,?,?,?,?)"); 
            ps.setString(1, p.getIddocente());
            ps.setString(2, p.getDni());
            ps.setString(3, p.getApellidosd());
            ps.setString(4, p.getNombresd());
            ps.setString(5, p.getTelefono());
            ps.setString(6, p.getDireccion());      
            ps.executeUpdate();
            ListaDetalleDocente LD=p.getLD();
            for(int i=0;i<LD.getN();i++){
                DetalleDocente x=LD.getElemento(i);
                String sql="call modificar_docente_alumno(?,?)";
                ps = cnn.prepareCall(sql);
                ps.setString(1, p.getIddocente()) ;
                ps.setString(2, x.getAlumno().getIdAlumno());
                ps.executeUpdate();
            }
           ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error modificicar Docente-Dao: " + e.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void eliminar(String iddocente)throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall(" call eliminar_docente(?)");
            ps.setString(1, iddocente);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error eliminar Docente-Dao" + e.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
     public void mostrarProfesor(DefaultTableModel modelo) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[]={"IDDOCENTE","DNI","APELLIDOS","NOMBRES","TELEFONO","DIRECCION"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try{
            ps = cnn.prepareCall("call mostrarDocentes()");
            rs = ps.executeQuery();
            while(rs.next()){
                String idProfesor = rs.getString("iddocente");
                String dni = rs.getString("dni");
                String apellidos = rs.getString("apellidosd");
                String nombres = rs.getString("nombresd");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                Object fila[] = {idProfesor,dni,apellidos,nombres,telefono,direccion};
                modelo.addRow(fila);
            }
        }catch (SQLException ex){
            System.out.println("ERROR MOSTRAR : "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    public ArrayList<Docente> mostrarPro() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList<Docente> lista = new ArrayList<Docente>();
        try{
            ps = cnn.prepareCall("call mostrarDocentes()");
            rs = ps.executeQuery();
            while(rs.next()){
                String iddoc = rs.getString("iddocente");
                String dni = rs.getString("dni");
                String apellidos = rs.getString("apellidosd");
                String nombres = rs.getString("nombresd");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                Docente m= new Docente(iddoc,dni,apellidos,nombres,telefono,direccion);
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
    public void buscarPorIdDocente(String iddocente,DefaultTableModel modelo) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[]={"IDDOCENTE","DNI","APELLIDOS","NOMBRES","TELEFONO","DIRECCION"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            String sql="select * from docente where iddocente like ?";
            ps=cnn.prepareCall(sql);
            ps.setString(1,iddocente+"%");
            rs=ps.executeQuery();
            while(rs.next()){
                String idProfesor=rs.getString("iddocente");
                String dni=rs.getString("dni");
                String apellidosd=rs.getString("apellidosd");
                String nombresd=rs.getString("nombresd");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                Object fila[] = {idProfesor,dni,apellidosd,nombresd,telefono,direccion};
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR BUSCAR POR APELLIDO: "+ ex.getMessage());
        }
        finally{
            cnn.close();
            ps.close();
        }
    } 
    
}
