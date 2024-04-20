package Datos;

import java.sql.*;

public class Conexion {
    private static Conexion instancia;
    
    public static Conexion getInstancia(){
        if(instancia==null){
            instancia=new Conexion();
        }
        return instancia;
    }
    public Conexion(){
        
    }
    public Connection miConexion(){
        Connection cn=null;
        
        try {    
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error falta cargar el driver" + e.getMessage());
        }
        
        try{
            String url="jdbc:mysql://localhost:3306/bdcolegio?useSSL=false";
            String user="root";
            String password="LamkSword";
            cn = DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
            System.out.println("Error no se puede establecer la conexion"+ e.getMessage());
        }
        
        return cn;
    }
}
