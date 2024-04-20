package Entidad;

import Datos.ListaDetalleMatricula;
import java.util.Date;
import java.util.Objects;
import javax.swing.table.DefaultTableModel;

public class Matricula {
    private String idMatricula;
    private Date fecha;
    private Alumno alumno;
    private Programacion programacion;
    private ListaDetalleMatricula LM;
    
    public Matricula(){
        LM = new ListaDetalleMatricula();
    }
    
    public Matricula(String idMatricula, Date fecha, Alumno alumno,Programacion programacion) {
        this.idMatricula = idMatricula;
        this.fecha = fecha;
        this.alumno = alumno;
        this.programacion = programacion;
        LM = new ListaDetalleMatricula();
    }
    
    public String getIdMatricula() {
        return idMatricula;
    }
    
    public void setIdMatricula(String idMatricula) {
        this.idMatricula = idMatricula;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Programacion getProgramacion() {
        return programacion;
    }
    
    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }
    
    public Alumno getAlumno() {
        return alumno;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idMatricula);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matricula other = (Matricula) obj;
        if (!Objects.equals(this.idMatricula, other.idMatricula)) {
            return false;
        }
        return true;
    }
    public void regitrarDetalleMatricula (Curso a){
        DetalleMatricula d=new DetalleMatricula(a);
        LM.agregar(d);
    }
    
    public void mostrar(DefaultTableModel modelo)
    {
        LM.mostrar(modelo);
    }
    
    public ListaDetalleMatricula getLD() {
        return LM;
    }

    public void setLD(ListaDetalleMatricula LM) {
        this.LM = LM;
    }
    
    @Override
    public String toString(){
        return idMatricula + fecha +programacion+ alumno.getNombres();
    }
    
}
