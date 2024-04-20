package Datos;

import Entidad.DetalleMatricula;
import Entidad.Matricula;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ListaDetalleMatricula {
    private ArrayList<DetalleMatricula> LDM ;

    public ListaDetalleMatricula()
    {
       LDM = new ArrayList<DetalleMatricula>();
    }

    public void agregar(DetalleMatricula e)
    {
      LDM.add(e);
    }

            // el indexOf busca usando el equals de las clases
    public int buscar(Matricula li)
    {
      return LDM.indexOf(li);
    }

    public void eliminar(int i)
    {
      LDM.remove(i);
    }

    public DetalleMatricula getElemento(int i)
    {
       return LDM.get(i);
    }

    public int getN()
    {
      return LDM.size();
    }

    public void inserta(int i, DetalleMatricula e)
    {
        LDM.add(i,e);
    }

    public void reemplaza(int i, DetalleMatricula e)
    {
       LDM.set(i,e);
    }

    public ArrayList<DetalleMatricula> getL()
    {
      return LDM;
    }
            
    public void mostrar(DefaultTableModel modelo)
    {
        Object datos[][]=new Object[LDM.size()][2];
        String titulos[]={"IDCURSO","NOMBRE"};

        for(int i=0;i<LDM.size();i++)
        {
            DetalleMatricula x=LDM.get(i);
            datos[i][0]=x.getCurso().getIdCurso();
            datos[i][1]=x.getCurso().getNombre();
        }
        modelo.setDataVector(datos, titulos);
    } 

}
