package Presentacion;

import Entidad.Curso;
import Entidad.Docente;
import Datos.CursoDAO;
import static Presentacion.Globales.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class DialogCurso extends javax.swing.JDialog {
    CursoDAO p = new CursoDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    boolean reg;
    int posicion, x, y;
    
    JFreeChart grafico;
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();
    
    Docente idProfesor;
    public DialogCurso() {
        super(FrmPrincipal.getInst(),true);
        initComponents();
         try {
             p.mostrarCursos(modelo);
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this, ex.getMessage());
         }
         grafico();
        limpiarTextos();
        textos(false);
        controles(true);
        setLocationRelativeTo(null);
    }

    public void grafico(){
        int a1=0,a2=0,a3=0,a4=0,a5=0,a6=0;
        String b;
        for(int i=0;i<modelo.getRowCount();i++){
            b=(String)modelo.getValueAt(i, 1);
            switch(b){
                case "Comunicación": a1++;
                Datos.addValue(a1,"Central",b);
                break;
                case "Matemática": a2++;
                Datos.addValue(a2,"Central",b);
                break;
                case "Religión": a3++;
                Datos.addValue(a3,"Central",b);
                break;
                case "Física": a4++;
                Datos.addValue(a4,"Central",b);
                break;
                case "Ciencias Sociales": a5++;
                Datos.addValue(a5,"Central",b);
                break;
                case "Ciencias Naturales": a6++;
                Datos.addValue(a6,"Central",b);
                break;
        }
        grafico=ChartFactory.createBarChart("GRÁFICA DE ASIGNATURAS","CURSOS","Numero de Docentes", 
                Datos, PlotOrientation.HORIZONTAL,true,true,false);
        ChartPanel Panel = new ChartPanel(grafico);
        BufferedImage graficoBarra=grafico.createBufferedImage
        (labelGrafico.getWidth(), labelGrafico.getHeight());
        labelGrafico.setSize(labelGrafico.getSize());
        labelGrafico.setIcon(new ImageIcon(graficoBarra));
        labelGrafico.updateUI();
            
        }
    }
    
    public void limpiarTextos(){
        txtidCurso.setText("");
        cboNombre.setSelectedIndex(0);
        txtidProfesor.setText("");
        txtDni.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
    }
    public void textos(boolean tf){
        txtidCurso.setEditable(tf);
        cboNombre.setEditable(tf);
    }
    public void controles(boolean tf){
        btnNuevo.setEnabled(tf);
        btnRegistrar.setEnabled(!tf);
        btnCancelar.setEnabled(!tf);
        btnModificar.setEnabled(tf);
        btnEliminar.setEnabled(tf);
        btnBuscarProfesor.setEnabled(!tf);
        btnMostrar.setEnabled(tf);
        btnBuscar.setEnabled(tf);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtNombres = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtidProfesor = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        btnBuscarProfesor = new javax.swing.JButton();
        cboNombre = new javax.swing.JComboBox();
        txtidCurso = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        btnReporte = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        labelGrafico = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setText("jLabel6");

        jLabel10.setText("jLabel10");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Curso");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(244, 244, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(252, 222, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nombre:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 59, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("IdCurso:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(234, 234, 234));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL PROFESOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombres.setEditable(false);
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 190, 25));

        txtTelefono.setEditable(false);
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 190, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Dni:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 20, 30, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Apellidos:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("IdProfesor:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Nombres:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtidProfesor.setEditable(false);
        jPanel2.add(txtidProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 72, 25));

        txtApellidos.setEditable(false);
        jPanel2.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 190, 25));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Dirección:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Teléfono:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 145, -1, 20));

        txtDireccion.setEditable(false);
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 190, 25));

        txtDni.setEditable(false);
        jPanel2.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 79, 25));

        btnBuscarProfesor.setText("...");
        btnBuscarProfesor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProfesorActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 50, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 87, 360, 230));

        cboNombre.setEditable(true);
        cboNombre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Escoger>", "Comunicación", "Matemática", "Religión", "Física", "Ciencias Sociales", "Ciencias Naturales" }));
        cboNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNombreActionPerformed(evt);
            }
        });
        jPanel3.add(cboNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 133, 28));
        jPanel3.add(txtidCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 15, 133, 27));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 380, 330));

        btnRegistrar.setBackground(new java.awt.Color(204, 204, 204));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 51, 102));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/registrarse.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel4.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 120, 30));

        btnSalir.setBackground(new java.awt.Color(204, 204, 204));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 51, 102));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salida.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 120, 30));

        btnMostrar.setBackground(new java.awt.Color(204, 204, 204));
        btnMostrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(0, 51, 102));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/casilla-de-verificacion.png"))); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        btnMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        jPanel4.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 120, 30));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 51, 102));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 120, 30));

        btnNuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 51, 102));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anadir.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 120, 30));

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 51, 102));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 120, 30));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 51, 102));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-x.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 120, 30));

        btnModificar.setBackground(new java.awt.Color(204, 204, 204));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 51, 102));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizado.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel4.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 120, 30));

        jPanel1.setBackground(new java.awt.Color(255, 51, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("INFORMACIÓN DE CURSO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 0, -1, 60));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insigniac.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 60, 60));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1148, 60));

        jTable3.setModel(modelo);
        jScrollPane3.setViewportView(jTable3);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 380, 450));

        btnReporte.setBackground(new java.awt.Color(204, 204, 204));
        btnReporte.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(0, 51, 102));
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel4.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 120, 30));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(labelGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 336, 450));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 336, 450));

        jLabel15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel15MouseDragged(evt);
            }
        });
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1146, 542));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1148, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        reg=true;
        limpiarTextos();
        textos(true);
        controles(false);
        txtidCurso.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String idCurso;
        idCurso = JOptionPane.showInputDialog("INGRESAR ID DEL CURSO A ELIMINAR: ");
        Curso  curso;
        try{
            curso = CursoDAO.getInstancia().buscarCurso(idCurso);
            if(curso != null){
                txtidCurso.setText(curso.getIdCurso());
                cboNombre.setSelectedItem(curso.getNombre());
                //Daatos profesor
                txtidProfesor.setText(curso.getProfesor().getIddocente());
                txtDni.setText(curso.getProfesor().getDni());
                txtNombres.setText(curso.getProfesor().getNombresd());
                txtApellidos.setText(curso.getProfesor().getApellidosd());
                txtTelefono.setText(curso.getProfesor().getTelefono());
                txtDireccion.setText(curso.getProfesor().getDireccion());
                int resp = JOptionPane.showConfirmDialog(this,"¿DESEAS ELIMINARLO? ","ELIMINAR DATO",JOptionPane.YES_NO_OPTION );
                if(resp == JOptionPane.YES_OPTION){
                    CursoDAO.getInstancia().eliminar(idCurso);
                    JOptionPane.showMessageDialog(this,"REGISTRO ELIMINADO");
                }
                limpiarTextos();
                
            }else{
                JOptionPane.showMessageDialog(this,"EL CURSO NO SE ENCUENTRA REGISTRADO");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        try {
             p.mostrarCursos(modelo);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        grafico();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarTextos();
        textos(false);
        controles(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String idCurso;
        idCurso = JOptionPane.showInputDialog("INGRESAR ID DEL CURSO A MODIFICAR: ");
        Curso  curso;
        try{
            curso = CursoDAO.getInstancia().buscarCurso(idCurso);
            if(curso != null){
                txtidCurso.setText(curso.getIdCurso());
                cboNombre.setSelectedItem(curso.getNombre());
                //Datos profesor
                txtidProfesor.setText(curso.getProfesor().getIddocente());
                txtDni.setText(curso.getProfesor().getDni());
                txtNombres.setText(curso.getProfesor().getNombresd());
                txtApellidos.setText(curso.getProfesor().getApellidosd());
                txtTelefono.setText(curso.getProfesor().getTelefono());
                txtDireccion.setText(curso.getProfesor().getDireccion());
                reg=false;
                textos(true);
                txtidCurso.setEnabled(false);
                btnBuscarProfesor.setEnabled(true);
                controles(false);
            }else{
                JOptionPane.showMessageDialog(this,"EL CURSO NO SE ENCUENTRA REGISTRADO");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        try {
            p.mostrarCursos(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        grafico();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
       if(txtidCurso.getText().equals("")){
           JOptionPane.showMessageDialog(this, "INGRESAR UN ID");
           txtidCurso.requestFocus();
           return;
        }
        if(cboNombre.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "INGRESAR UN NOMBRE");
            cboNombre.requestFocus();
            return;
        }
        if(txtidProfesor.getText().equals("") && txtDni.getText().equals("") && txtNombres.getText().equals("")&&
                txtApellidos.getText().equals("") && txtTelefono.getText().equals("") && txtDireccion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "SELECCIONAR PROFESOR");
            DialogBuscarDocente buscarProfesor;
           try {
               buscarProfesor = new DialogBuscarDocente();
               buscarProfesor.setVisible(true);
           } catch (SQLException ex) {
               Logger.getLogger(DialogCurso.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        String idCurso,nombre;
        idCurso = txtidCurso.getText();
        nombre = cboNombre.getSelectedItem().toString();
        Curso curso = new Curso(idCurso,nombre,idProfesor);
        if(reg){
            try{
                CursoDAO.getInstancia().insertar(curso);
                JOptionPane.showMessageDialog(null, "CURSO REGISTRADO");            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }else{
            try{
                CursoDAO.getInstancia().actualizar(curso);
                JOptionPane.showMessageDialog(null, "CURSO MODIFICADO"); 
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
        limpiarTextos();
        textos(false);
        controles(true);
        try {
             p.mostrarCursos(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        grafico();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void btnBuscarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProfesorActionPerformed
        DialogBuscarDocente buscarDocente;
        try {
            buscarDocente = new DialogBuscarDocente();
            buscarDocente.setVisible(true);
            idProfesor = buscarDocente.profesorSelec;
            txtidProfesor.setText(idProfesor.getIddocente());
            txtDni.setText(idProfesor.getDni());
            txtApellidos.setText(idProfesor.getApellidosd());
            txtNombres.setText(idProfesor.getNombresd());
            txtTelefono.setText(idProfesor.getTelefono());
            txtDireccion.setText(idProfesor.getDireccion());
        } catch (SQLException ex) {
            Logger.getLogger(DialogCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarProfesorActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        DialogReporteCurso reporteCurso = new DialogReporteCurso();
        reporteCurso.setVisible(true);
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String idCurso;
        idCurso = JOptionPane.showInputDialog("INGRESAR ID CURSO A BUSCAR: ");
        Curso  curso;
        try{
            curso = CursoDAO.getInstancia().buscarCurso(idCurso);
            if(curso != null){
                txtidCurso.setText(curso.getIdCurso());
                cboNombre.setSelectedItem(curso.getNombre());
                //Datos profesor
                txtidProfesor.setText(curso.getProfesor().getIddocente());
                txtDni.setText(curso.getProfesor().getDni());
                txtNombres.setText(curso.getProfesor().getNombresd());
                txtApellidos.setText(curso.getProfesor().getApellidosd());
                txtTelefono.setText(curso.getProfesor().getTelefono());
                txtDireccion.setText(curso.getProfesor().getDireccion());
            }else{
                JOptionPane.showMessageDialog(this,"EL CURSO NO SE ENCUENTRA REGISTRADO");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        try {
             p.mostrarCursos(modelo);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        try {
            dispose();
            rcu.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(DialogCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(DialogCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void cboNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNombreActionPerformed

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel15MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel15MouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarProfesor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel labelGrafico;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtidCurso;
    private javax.swing.JTextField txtidProfesor;
    // End of variables declaration//GEN-END:variables
}
