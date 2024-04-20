package Entidad;

import java.util.Objects;

/**
 *
 * @author Lamk
 */
public class DetalleDocente {
    private Alumno alumno;

    public DetalleDocente() {
    }

    public DetalleDocente(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
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
        final DetalleDocente other = (DetalleDocente) obj;
        if (!Objects.equals(this.alumno, other.alumno)) {
            return false;
        }
        return true;
    }
}
