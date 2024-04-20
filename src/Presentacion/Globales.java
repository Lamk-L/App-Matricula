package Presentacion;

import Datos.ApoderadoDAO;
import Datos.AlumnoDAO;
import Datos.MatriculaDAO;
import Datos.UsuarioDAO;
import Reportes.*;

/**
 *
 * @author Lamk
 */
public class Globales {
    static ApoderadoDAO apdao = new ApoderadoDAO();
    static AlumnoDAO aldao = new AlumnoDAO();
    static MatriculaDAO mdao = new MatriculaDAO();
    static UsuarioDAO udao = new UsuarioDAO();
    static ReportApoderado rap = new ReportApoderado();
    static ReportAlumno ral = new ReportAlumno();
    static ReportDocente rdo = new ReportDocente();
    static ReportCurso rcu = new ReportCurso();
    static ReportApoderadoNomAsc rapna = new ReportApoderadoNomAsc();
    static ReportApoderadoApeAsc rapa = new ReportApoderadoApeAsc();
    static ReportAlumnoNomAsc ralna = new ReportAlumnoNomAsc();
    static ReportAlumnoApeAsc rala = new ReportAlumnoApeAsc();
    static ReportDocenteNomAsc rdna = new ReportDocenteNomAsc();
    static ReportDocenteApeAsc rdap = new ReportDocenteApeAsc();
    static ReportRelacionAlumno rra = new ReportRelacionAlumno();
    static ReportRelacionDocente_Alumno rda = new ReportRelacionDocente_Alumno();
    static ReportRelacionCurso rrc = new ReportRelacionCurso();
    static ReportRelacionProgramacion rrp = new ReportRelacionProgramacion();
    static ReportRelacionMatricula rrm = new ReportRelacionMatricula();
    static ReportRelacionMatricula_Curso rrmc = new ReportRelacionMatricula_Curso();
}
