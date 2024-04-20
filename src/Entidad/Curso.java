package Entidad;

import java.util.Objects;

public class Curso {
    private String idCurso;
    private String nombre;
    private Docente profesor;
    
    public Curso(){
    }
    
    public Curso(String idCurso, String nombre, Docente profesor) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.profesor = profesor;
    }
    
    public String getIdCurso() {
        return idCurso;
    }
    
    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }
    
    public Docente getProfesor() {
        return profesor;
    }
    
    public void setProfesor(Docente profesor) {
        this.profesor = profesor;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idCurso);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.idCurso, other.idCurso)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return idCurso + profesor + nombre ;
    }
    
}
