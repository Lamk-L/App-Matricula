package Datos;

import Entidad.Horario;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HorarioDAO {
    private Connection cnn=null;
    private ResultSet rs = null;
    private static HorarioDAO instancia;
    
    public static HorarioDAO getInstancia(){
        if(instancia==null){
            instancia = new HorarioDAO();
        }
        return instancia;
    }
    
    public void insertar(Horario a) throws SQLException{
       cnn = Conexion.getInstancia().miConexion();
       PreparedStatement ps = null;
       try{
           ps = cnn.prepareCall("call insertar_horario(?,?,?,?,?,?)"); 
           ps.setString(1, a.getIdHorario());
           ps.setString(2, a.getGrado());
           ps.setString(3, a.getTurno());
           ps.setDate(4, Convertir.convertJavaDateTOSQLDate(a.getFecha()));
           ps.setString(5,a.getHoraInicio());
           ps.setString(6, a.getHoraSalida());
           ps.executeUpdate();
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error al insertar horario: "+ ex.getMessage());
       }finally{
           cnn.close();
           ps.close();
       } 
    }
    
    public Horario buscarHorario(String idHorario) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        Horario horario = null;
        try{
            String sql="call buscar_horario(?)";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idHorario);
            rs = ps.executeQuery();
            if(rs.next()){
                String grado = rs.getString("grado");
                String turno = rs.getString("turno");               
                Date fecha = rs.getDate("fechaInicio");
                String horaInicio = rs.getString("horaEntrada");
                String horaSalida = rs.getString("horaSalida"); 
                horario = new Horario(idHorario,grado,turno,fecha,horaInicio,horaSalida);                      
            }
        }catch(SQLException ex){
            System.out.println("Error buscar horario: " + ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
        return horario;
    }
    
    public void actualizar(Horario a) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            String sql="call modificar_horario(?,?,?,?,?,?)";
            ps = cnn.prepareCall(sql);  
            ps.setString(1,a.getIdHorario());
            ps.setString(2, a.getGrado());
            ps.setString(3, a.getTurno());
            ps.setDate(4,   Convertir.convertJavaDateTOSQLDate(a.getFecha()));
            ps.setString(5, a.getHoraInicio());
            ps.setString(6, a.getHoraSalida());        
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error a actualizar horario: " + ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void eliminar(String idHorario)throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            String sql="call eliminar_horario(?)";
            ps= cnn.prepareCall(sql);
            ps.setString(1, idHorario);
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al eliminar horario" + ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void mostrarHorarios(DefaultTableModel modelo) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[]={"IDHORARIO","GRADO","TURNO","FECHA DE INICIO","HORA DE ENTRADA","HORA DE SALIDA"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try{
            String sql = "call mostrarHorarios()";
            ps = cnn.prepareCall(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String idhorario = rs.getString("idhorario");
                String grado = rs.getString("grado");
                String turno = rs.getString("turno");
                Date fecha = rs.getDate("fechaInicio");
                String horaInicio = rs.getString("horaEntrada");
                String horaSalida = rs.getString("horaSalida");
                Object fila[]={idhorario,grado,turno,fecha,horaInicio,horaSalida};
                modelo.addRow(fila);
            }        
        }catch(SQLException ex){
            System.out.println("Error mostrar horarios: " + ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }       
    }
    
    public void buscarPorTurno(String tur ,DefaultTableModel modelo) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        String titulos[]={"IDHORARIO","GRADO","TURNO","FECHA DE INICIO","HORA DE ENTRADA","HORA DE SALIDA"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            String sql=("SELECT * FROM horario where turno like ?");
            ps=cnn.prepareStatement(sql);
            ps.setString(1, tur+"%");
            rs=ps.executeQuery();
            while (rs.next()) {
                String idHorario = rs.getString("idhorario");
                String grado = rs.getString("grado");
                String turno = rs.getString("turno");
                Date fecha = rs.getDate("fechaInicio");
                String horaInicio = rs.getString("horaEntrada");
                String horaSalida = rs.getString("horaSalida");
                Object fila[]= {idHorario,grado, turno, fecha, horaInicio,horaSalida};
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("Error buscar por turno: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }
    
}