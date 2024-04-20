package Entidad;

import Datos.ListaDetalleDocente;
import java.util.Objects;
import javax.swing.table.DefaultTableModel;

public class Docente{
    private String iddocente;
    private String dni;
    private String apellidosd;
    private String nombresd;
    private String telefono;
    private String direccion;
    private ListaDetalleDocente LD;
    
    public Docente() {
        LD = new ListaDetalleDocente();
    }

    public Docente(String iddocente, String dni, String apellidosd, String nombresd, String telefono, String direccion) {
        this.iddocente = iddocente;
        this.dni = dni;
        this.apellidosd = apellidosd;
        this.nombresd = nombresd;
        this.telefono = telefono;
        this.direccion = direccion;
        LD = new ListaDetalleDocente();
    }

    public String getIddocente() {
        return iddocente;
    }

    public void setIddocente(String iddocente) {
        this.iddocente = iddocente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidosd() {
        return apellidosd;
    }

    public void setApellidosd(String apellidosd) {
        this.apellidosd = apellidosd;
    }

    public String getNombresd() {
        return nombresd;
    }

    public void setNombresd(String nombresd) {
        this.nombresd = nombresd;
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
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Docente other = (Docente) obj;
        if (!Objects.equals(this.iddocente, other.iddocente)) {
            return false;
        }
        return true;
    }
    
    public void regitrarDetalleDocente (Alumno a){
        DetalleDocente d=new DetalleDocente(a);
        LD.agregar(d);
    }
    
    public void mostrar(DefaultTableModel modelo)
    {
        LD.mostrar(modelo);
    }
    
    public ListaDetalleDocente getLD() {
        return LD;
    }

    public void setLD(ListaDetalleDocente LD) {
        this.LD = LD;
    }
    
    @Override
    public String toString() {
        return iddocente  + dni + super.toString() ;
    }
    
}
