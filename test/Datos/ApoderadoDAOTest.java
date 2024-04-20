package Datos;

import Entidad.Apoderado;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class ApoderadoDAOTest {
    
    public ApoderadoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testInsertar() throws Exception {
        System.out.println("insertar");
        Apoderado x = new Apoderado("apo002", "Casado","Jorge","Samame Gonzales", "589030","samame.jorge@gmail.com");
        ApoderadoDAO instance = new ApoderadoDAO();
        instance.insertar(x);
    }
  
    
    @Test
    public void testNumeroApoderados() throws Exception {
        System.out.println("numero de Apoderados");
        ApoderadoDAO instance = new ApoderadoDAO();
        int expResult = 0;
        int result = instance.numeroApoderados();
        assertEquals(expResult, result);
       if(expResult != result)
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarApoderado() throws Exception {
        System.out.println("buscarApoderado");
        //Damos valores de entrada
        String idapoderado = "apo002";
        
        //Damos resultado esperado
         Apoderado expResult = new  Apoderado("apo002", "Jorge","Samame Gonazales", "589030","samame.jorge@gmail.com","soltero");
         
         //creamos un objeto del metodo
        ApoderadoDAO instance = new ApoderadoDAO();
        
        //Resultado del metodo
        Apoderado result = instance.buscarApoderado(idapoderado);
        
        //Comparamos ambos resultados
        assertEquals(expResult, result);
        
      if(!expResult.equals(result))
        fail("The test case is a prototype.");
    }

    @Test
    public void testActualizar() throws Exception {
        System.out.println("actualizar");
       Apoderado ap= new Apoderado("apo002", "Casado","Jorge","Samame Gonzales", "589030","samame.jorge@gmail.com");
        ApoderadoDAO instance = new ApoderadoDAO();
        instance.actualizar(ap);
    }
    
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        String idapoderado = "apo002";
        ApoderadoDAO instance = new ApoderadoDAO();
        instance.eliminar(idapoderado);
    }
   
 
}
