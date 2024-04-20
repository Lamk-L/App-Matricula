/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Docente;
import java.util.ArrayList;
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
public class ProfesorDAOTest {
    
    public ProfesorDAOTest() {
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

   //Funcionara 1 sola vez por la clave primaria
    @Test
    public void testInsertar() throws Exception {
        System.out.println("insertar");
        Docente profe = new Docente("doc002", "74152638", "Garcia", "Alfredo", "201030", "alfredo.garcia@gmail.com");
        DocenteDAO instance = new DocenteDAO();
        instance.insertar(profe);
    }

    
    @Test
    public void testNumeroProfesores() throws Exception {
        System.out.println("numeroProfesores");
        DocenteDAO instance = new DocenteDAO();
        int expResult = 3;
        int result = instance.numeroProfesores();
        assertEquals(expResult, result);
        if(expResult!=result)
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarProfesor() throws Exception {
        System.out.println("buscarProfesor");
        String idProfesor = "doc001";
         Docente expResult =new Docente("doc001","76485123","Geronimo Dionicio","Percy","202928","percy.geronimo@gmail.com") ;
        DocenteDAO instance = new DocenteDAO();
        Docente result = instance.buscarProfesor(idProfesor);
        assertEquals(expResult, result);
        if(!expResult.equals(result))
         fail("The test case is a prototype.");
    }

 
    @Test
    public void testActualizar() throws Exception {
        System.out.println("actualizar");
        Docente profe = new Docente("doc002", "74152638", "Garcia", "Alfredo", "201030", "alfredo.garcia@gmail.com");
        DocenteDAO instance = new DocenteDAO();
        instance.actualizar(profe);
    }

   
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        String idProfesor = "doc002";
        DocenteDAO instance = new DocenteDAO();
        instance.eliminar(idProfesor);
    }

//    @Test
//    public void testMostrarProfesores() throws Exception {
//        System.out.println("mostrarProfesores");
//        DocenteDAO instance = new DocenteDAO();
//        ArrayList<Profesor> expResult = null;
//        ArrayList<Profesor> result = instance.mostrarProfesores();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

   
//    @Test
//    public void testBucarPorApellidos() throws Exception {
//        System.out.println("bucarPorApellidos");
//        String ape = "";
//        DocenteDAO instance = new DocenteDAO();
//        ArrayList<Profesor> expResult = null;
//        ArrayList<Profesor> result = instance.bucarPorApellidos(ape);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
