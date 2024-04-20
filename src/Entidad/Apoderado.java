package Entidad;

import java.util.Objects;

public class Apoderado{
    private String idApoderado;
    private String nombresp;
    private String apellidosp;
    private String telefono;
    private String direccion;
    private String estadoCivil;

    
    public Apoderado(){ 
    }

    public Apoderado(String idApoderado, String nombresp, String apellidosp, String telefono, String direccion, String estadoCivil) {
        this.idApoderado = idApoderado;
        this.nombresp = nombresp;
        this.apellidosp = apellidosp;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
    }

    public String getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(String idApoderado) {
        this.idApoderado = idApoderado;
    }

    public String getNombresp() {
        return nombresp;
    }

    public void setNombresp(String nombresp) {
        this.nombresp = nombresp;
    }

    public String getApellidosp() {
        return apellidosp;
    }

    public void setApellidosp(String apellidosp) {
        this.apellidosp = apellidosp;
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    @Override
    public String toString() {
        return   idApoderado +super.toString() + estadoCivil ;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idApoderado);
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
        final Apoderado other = (Apoderado) obj;
        if (!Objects.equals(this.idApoderado, other.idApoderado)) {
            return false;
        }
        return true;
    }
    
}
