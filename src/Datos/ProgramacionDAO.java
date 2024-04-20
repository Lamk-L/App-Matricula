package Datos;

import Entidad.Aula;
import Entidad.Horario;
import Entidad.Programacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ProgramacionDAO {
    private Connection cnn = null;
    private ResultSet rs=null;
    private static ProgramacionDAO instancia;
    
    public static ProgramacionDAO getInstancia(){
        if(instancia==null)
            instancia=new ProgramacionDAO();
        return instancia;
    }
    
    public void insertar(Programacion programacion)throws SQLException{
        
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        
        try{
            ps = cnn.prepareCall("call insertar_programacion (?,?,?)");
            ps.setString(1, programacion.getIdProgramacion());
            ps.setString(2, programacion.getHorario().getIdHorario());
            ps.setString(3, programacion.getAula().getIdAula());
            ps.executeUpdate();
            
        }catch (SQLException e) {
            System.out.println("Error insertar programacion: " + e.getMessage());
            e.printStackTrace();
        } finally {
            cnn.close();
            ps.close();
        }
    }
    
    public void actualizar(Programacion programacion) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        
        try{
            ps = cnn.prepareCall("call modificar_programacion (?,?,?)");
            ps.setString(1, programacion.getIdProgramacion());
            ps.setString(2, programacion.getHorario().getIdHorario());
            ps.setString(3, programacion.getAula().getIdAula());
            ps.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Error actualizar programacion: " + e.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void eliminar(String idProgramacion)throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall("call eliminar_programacion (?)");
            ps.setString(1, idProgramacion);
            ps.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Error eliminar programacion" + e.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public Programacion buscarProgramacion(String idProgramacion) throws SQLException{
        
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        Programacion programacion = null;
        try {
            ps = cnn.prepareCall("call buscar_programacion (?)");
            ps.setString(1, idProgramacion);
            rs = ps.executeQuery();
            
            if (rs.next()){          
                String idHorario = rs.getString("idhorario");
                Horario horario = HorarioDAO.getInstancia().buscarHorario(idHorario);
                String idAula = rs.getString("idaula");
                Aula aula = AulaDAO.getInstancia().buscaAula(idAula);
                programacion = new Programacion(idProgramacion, horario, aula);
            }
        } catch (SQLException ex) {
            System.out.println("error buscar programacion:  " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
        return programacion;
    }
    public ArrayList<Programacion> mostrarProgramacion() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList<Programacion> lista = new ArrayList<Programacion>();
        try{
            ps = cnn.prepareCall("call mostrarProgramacion()");
            rs = ps.executeQuery();
            while(rs.next()){
                String Idc = rs.getString("idprogramacion");
                String idh = rs.getString("idhorario");
                String idau = rs.getString("idaula");
                Horario horario = HorarioDAO.getInstancia().buscarHorario(idh);
                Aula aula = AulaDAO.getInstancia().buscaAula(idau);
                Programacion m= new Programacion(Idc,horario,aula);
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
    
    public void mostrarProgramaciones(DefaultTableModel modelo) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[]={"IDPROGRAMACIÓN","GRADO","TURNO","F-INICIO","N-AULA","CAPACIDAD"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try{
            String sql = "call mostrarProgramacion()";
            ps = cnn.prepareCall(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String Idc = rs.getString("idprogramacion");
                String idh = rs.getString("idhorario");
                String idau = rs.getString("idaula");
                Horario h = HorarioDAO.getInstancia().buscarHorario(idh);
                Aula a = AulaDAO.getInstancia().buscaAula(idau);
                Programacion m= new Programacion(Idc,h,a);
                Object fila[] = {Idc,h.getGrado(),h.getTurno(),h.getFecha(),a.getNumeroAula(),a.getCapacidad()};
                modelo.addRow(fila);
            }
        }catch (SQLException ex){
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }

}
