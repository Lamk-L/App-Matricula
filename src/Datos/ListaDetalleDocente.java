package Datos;

import Entidad.DetalleDocente;
import Entidad.Docente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lamk
 */
public class ListaDetalleDocente {
    private ArrayList<DetalleDocente> LDD ;

    public ListaDetalleDocente()
    {
       LDD = new ArrayList<DetalleDocente>();
    }

    public void agregar(DetalleDocente e)
    {
      LDD.add(e);
    }

            // el indexOf busca usando el equals de las clases
    public int buscar(Docente li)
    {
      return LDD.indexOf(li);
    }

    public void eliminar(int i)
    {
      LDD.remove(i);
    }

    public DetalleDocente getElemento(int i)
    {
       return LDD.get(i);
    }

    public int getN()
    {
      return LDD.size();
    }

    public void inserta(int i, DetalleDocente e)
    {
        LDD.add(i,e);
    }

    public void reemplaza(int i, DetalleDocente e)
    {
       LDD.set(i,e);
    }

    public ArrayList<DetalleDocente> getL()
    {
      return LDD;
    }
            
    public void mostrar(DefaultTableModel modelo)
    {
        Object datos[][]=new Object[LDD.size()][3];
        String titulos[]={"ID-ALUMNO","NOMBRES","APELLIDOS"};

        for(int i=0;i<LDD.size();i++)
        {
            DetalleDocente x=LDD.get(i);
            datos[i][0]=x.getAlumno().getIdAlumno();
            datos[i][1]=x.getAlumno().getNombres();
            datos[i][2]=x.getAlumno().getApellidos();
        }
        modelo.setDataVector(datos, titulos);
    }
}
