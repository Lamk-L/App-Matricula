package Reportes;

import Datos.Conexion;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
 
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lamk
 */
public class ReportDocente {
    public void reportesPDF() throws IOException,JRException{
        final String nombreArchivo = "";
        Path rutaRelativa = Paths.get(nombreArchivo);
        Path rutaAbsoluta = rutaRelativa.toAbsolutePath();
        String nombre = rutaAbsoluta.toString();
        JasperReport archivo = JasperCompileManager.compileReport(nombre+"/src/Reportes/ReportDocente.jrxml");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Logo1", nombre+"/src/images/insignia.png");
        JasperPrint prin = JasperFillManager.fillReport(archivo, map, Conexion.getInstancia().miConexion());
        JasperViewer ver = new JasperViewer(prin, false);
        ver.setVisible(true);
        ver.setTitle("Reporte Docentes");
    }
}
