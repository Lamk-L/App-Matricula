package Entidad;

import java.util.Objects;

public class Programacion {
    private String idProgramacion;
    private Horario horario;
    private Aula aula;

    public Programacion() {
    }
    
    public Programacion(String idProgramacion, Horario horario, Aula aula) {
        this.idProgramacion = idProgramacion;
        this.horario = horario;
        this.aula = aula;
    }
    
    public String getIdProgramacion() {
        return idProgramacion;
    }
    
    public void setIdProgramacion(String idProgramacion) {
        this.idProgramacion = idProgramacion;
    }
    
    public Horario getHorario() {
        return horario;
    }
    
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    public Aula getAula() {
        return aula;
    }
    
    public void setAula(Aula aula) {
        this.aula = aula;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.idProgramacion);
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
        final Programacion other = (Programacion) obj;
        if (!Objects.equals(this.idProgramacion, other.idProgramacion)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return idProgramacion + horario + aula;
    }
    
}
