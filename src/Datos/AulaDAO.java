package Datos;

import Entidad.Aula;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AulaDAO {
    private Connection cnn=null;
    private ResultSet rs = null;
    private static AulaDAO instancia;
    
    public static AulaDAO getInstancia(){
        if(instancia==null){
            instancia = new AulaDAO();
        }
        return instancia;
    }
    
    public void insertar(Aula a) throws SQLException{
       cnn = Conexion.getInstancia().miConexion();
       PreparedStatement ps = null;
       try{
            ps = cnn.prepareCall("call insertar_aula(?,?,?)"); 
           ps.setString(1, a.getIdAula());
           ps.setInt(2, a.getNumeroAula());
           ps.setInt(3, a.getCapacidad());
           ps.executeUpdate();
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error en SQL: "+ ex.getMessage());
       }finally{
           cnn.close();
           ps.close();
       } 
    }
    
    public Aula buscaAula(String idAula) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        Aula aula = null;
        try{
            ps = cnn.prepareCall("call buscar_aula (?)");
            ps.setString(1, idAula);
            rs = ps.executeQuery();
            if(rs.next()){
                int numeroAula = rs.getInt("numeroAula");
                int cantidad = rs.getInt("capacidad");
                aula = new Aula(idAula, numeroAula, cantidad);
            }
        }catch(SQLException ex){
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
        return aula;
    }
    
    public void actualizar(Aula a) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall("call modificar_aula (?,?,?)");
            ps.setString(1, a.getIdAula());
            ps.setInt(2, a.getNumeroAula());
            ps.setInt(3, a.getCapacidad());        
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void eliminar(String idAula)throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall("call eliminar_aula (?)");
            ps.setString(1, idAula);
            ps.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void mostrarAula(DefaultTableModel modelo) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[]={"IDAULA","NUMERO DE AULA","CAPACIDAD"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try{
            String sql = "call mostrarAulas()";
            ps = cnn.prepareCall(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String Idaula = rs.getString("idaula");
                String nAula = rs.getString("numeroAula");
                String capacidad = rs.getString("capacidad");
                Object fila[] = {Idaula,nAula,capacidad};
                modelo.addRow(fila);
            }
        }catch (SQLException ex){
            System.out.println("ERROR: "+ ex.getMessage());
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void buscarPorCodigo(String n,DefaultTableModel modelo) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[]={"IDAULA","NUMERO DE AULA","CAPACIDAD"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            String sql="select * from aula where idaula like ?";
            ps=cnn.prepareCall(sql);
            ps.setString(1,n+"%");
            rs=ps.executeQuery();
            while(rs.next()){
                String Idaula = rs.getString("idaula");
                String nAula = rs.getString("numeroAula");
                String capacidad = rs.getString("capacidad");
                Object fila[] = {Idaula,nAula,capacidad};
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ ex.getMessage());
        }
        finally{
            cnn.close();
            ps.close();
        }
    } 
    
}
