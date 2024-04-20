package Entidad;

import java.util.Date;
import java.util.Objects;

public class Alumno{  
    private String idAlumno;
    private String nombres;
    private String apellidos;
    private String sexo;
    private String telefono;
    private String direccion;
    private Date fechaNacimiento;
    private Apoderado apoderado;
    
    public Alumno() {
    }

    public Alumno(String idAlumno, String nombres, String apellidos, String sexo, String telefono, String direccion, Date fechaNacimiento, Apoderado apoderado) {
        this.idAlumno = idAlumno;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.apoderado = apoderado;
    }
    
    public String getIdAlumno() {
        return idAlumno;
    }
    
    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }
    
    public String getNombres() {
        return nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public Apoderado getApoderado() {
        return apoderado;
    }
    
    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idAlumno);
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
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.idAlumno, other.idAlumno)) {
            return false;
        }
        return true;
    }
    
}
