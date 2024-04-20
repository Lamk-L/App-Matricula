package Presentacion;

import Datos.AlumnoDAO;
import Datos.ApoderadoDAO;
import Entidad.Alumno;
import Entidad.Apoderado;
import java.sql.SQLException;
import java.util.Date;
import static Presentacion.Globales.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

public class DialogAlumno extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel();
    int posicion, x, y;
    Apoderado apoderado=null;
    boolean reg;
    
    JFreeChart grafico;
    DefaultPieDataset Datos = new DefaultPieDataset();
    
    public DialogAlumno() {
        super(FrmPrincipal.getInst(),true);
        initComponents();
        setLocationRelativeTo(null);
        try{
            aldao.mostrarAlumnos(modelo);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
        grafico();
        limpiarTextos();
        textos(false);
        controles(true);
    }
    
    public void grafico(){
        int a1=0,a2=0;
        for(int i=0;i<modelo.getRowCount();i++){
            if("Masculino".equalsIgnoreCase(modelo.getValueAt(i, 3).toString())){
                a1++;
                Datos.setValue("Masculino",a1);
            }else{
                a2++;
                Datos.setValue("Femenino",a2);  
            }
        }
        grafico=ChartFactory.createPieChart("GRÁFICO DE SEXO", Datos, true, true,false);
        ChartPanel Panel = new ChartPanel(grafico);
        BufferedImage graficoBarra=grafico.createBufferedImage
        (labelGrafico.getWidth(), labelGrafico.getHeight());
        labelGrafico.setSize(labelGrafico.getSize());
        labelGrafico.setIcon(new ImageIcon(graficoBarra));
        labelGrafico.updateUI();
    }
    
    public void limpiarTextos(){
        txtidAlumno.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        cboSexo.setSelectedIndex(0);
        txtDireccion.setText("");
        choFechaNacimiento.setCalendar(null);
        txtIdApoderado.setText("");
        txtANombre.setText("");
        txtApellidos1.setText("");
        txtATelefono.setText("");
        txtADireccion.setText("");
        txtEstadoCivil.setText("");
    }
    public void textos(boolean tf){
        txtidAlumno.setEnabled(tf);
        txtNombres.setEnabled(tf);
        txtApellidos.setEnabled(tf);
        txtIdApoderado.setEnabled(tf);
        txtTelefono.setEnabled(tf);
        cboSexo.setEnabled(tf);
        txtDireccion.setEnabled(tf);
        choFechaNacimiento.setEnabled(tf);
    }
    public void controles(boolean tf){
        btnNuevo.setEnabled(tf);
        btnRegistrar.setEnabled(!tf);
        btnCancelar.setEnabled(!tf);
        btnModificar.setEnabled(tf);
        btnEliminar.setEnabled(tf);
        btnBuscarApoderado.setEnabled(!tf);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtANombre = new javax.swing.JTextField();
        btnBuscarApoderado = new javax.swing.JButton();
        txtApellidos1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEstadoCivil = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtATelefono = new javax.swing.JTextField();
        txtIdApoderado = new javax.swing.JTextField();
        txtADireccion = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtidAlumno = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        cboSexo = new javax.swing.JComboBox();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        choFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        labelGrafico4 = new javax.swing.JLabel();
        labelGrafico = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(244, 244, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(modelo);
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 1172, 280));

        jPanel2.setBackground(new java.awt.Color(252, 222, 249));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)), "DATOS DEL APODERADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("IdApoderado:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtANombre.setEditable(false);
        txtANombre.setBackground(new java.awt.Color(255, 255, 255));
        txtANombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        txtANombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtANombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtANombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 210, 30));

        btnBuscarApoderado.setText("...");
        btnBuscarApoderado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarApoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarApoderadoActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarApoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 60, 30));

        txtApellidos1.setEditable(false);
        txtApellidos1.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidos1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        txtApellidos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidos1KeyTyped(evt);
            }
        });
        jPanel2.add(txtApellidos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 210, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Apellidos:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Estado Civil:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 80, 30));

        txtEstadoCivil.setEditable(false);
        txtEstadoCivil.setBackground(new java.awt.Color(255, 255, 255));
        txtEstadoCivil.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        jPanel2.add(txtEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 120, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Nombres:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Teléfono:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 60, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Dirección:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 70, 40));

        txtATelefono.setEditable(false);
        txtATelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtATelefono.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        txtATelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtATelefonoKeyTyped(evt);
            }
        });
        jPanel2.add(txtATelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 210, 30));

        txtIdApoderado.setEditable(false);
        txtIdApoderado.setBackground(new java.awt.Color(255, 255, 255));
        txtIdApoderado.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        txtIdApoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdApoderadoActionPerformed(evt);
            }
        });
        jPanel2.add(txtIdApoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 120, 30));

        txtADireccion.setEditable(false);
        txtADireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtADireccion.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        jPanel2.add(txtADireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 210, 30));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 330, 320));

        jPanel6.setBackground(new java.awt.Color(255, 51, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("INFORMACIÓN DEL ALUMNO");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 59));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insigniac.png"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 60, 60));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 60));

        jPanel1.setBackground(new java.awt.Color(252, 222, 249));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)), "DATOS DEL ALUMNO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("IdAlumno:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombres:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Apellidos:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 60, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Sexo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 140, 40, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Telefono:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 60, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Dirección:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Fecha Nacimiento:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 50));

        txtidAlumno.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        jPanel1.add(txtidAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 126, 30));

        txtNombres.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 154, 30));

        txtApellidos.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 154, 30));

        cboSexo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Escoger>", "Masculino", "Femenino" }));
        jPanel1.add(cboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 154, 30));

        txtTelefono.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 154, 30));

        txtDireccion.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 154, 30));

        choFechaNacimiento.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        jPanel1.add(choFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 154, 30));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 294, 320));

        jPanel5.setBackground(new java.awt.Color(252, 222, 249));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel5.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        btnRegistrar.setBackground(new java.awt.Color(204, 204, 204));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 51, 102));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/registrarse.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel5.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 120, 30));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 51, 102));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel5.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, 120, 30));

        btnModificar.setBackground(new java.awt.Color(204, 204, 204));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 51, 102));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizado.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel5.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 120, 28));

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 51, 102));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel5.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 120, 30));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 51, 102));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-x.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel5.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 120, 30));

        btnReporte.setBackground(new java.awt.Color(204, 204, 204));
        btnReporte.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(0, 51, 102));
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel5.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 120, 30));

        btnSalir.setBackground(new java.awt.Color(204, 204, 204));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 51, 102));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salida.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel5.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 120, 30));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 140, 320));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(labelGrafico4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 590, 300));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 590, 300));
        jPanel9.add(labelGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 373, 322));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(808, 70, 373, 322));

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
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 700));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        reg=true;
        limpiarTextos();
        textos(true);
        controles(false);
        txtidAlumno.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String idAlumno;
        idAlumno = JOptionPane.showInputDialog("INGRESE EL ID DEL APODERADO A ELIMINAR: ");
        Alumno  a;
        try{
            a = AlumnoDAO.getInstancia().buscarAlumno(idAlumno);
            if(a != null){
                txtidAlumno.setText(a.getIdAlumno());
                txtNombres.setText(a.getNombres());
                txtApellidos.setText(a.getApellidos());
                cboSexo.setSelectedItem(a.getSexo());
                txtTelefono.setText(a.getTelefono());
                txtDireccion.setText(a.getDireccion());
                choFechaNacimiento.setDate(a.getFechaNacimiento());
                txtIdApoderado.setText(a.getApoderado().getIdApoderado());
                txtANombre.setText(a.getApoderado().getNombresp());
                txtApellidos1.setText(a.getApoderado().getApellidosp());
                txtATelefono.setText(a.getApoderado().getTelefono());
                txtADireccion.setText(a.getApoderado().getDireccion());
                txtEstadoCivil.setText(a.getApoderado().getEstadoCivil());
                //DDatos Apoderado
                txtIdApoderado.setText(a.getApoderado().getIdApoderado());
                txtANombre.setText(a.getApoderado().getNombresp());
                txtApellidos1.setText(a.getApoderado().getApellidosp());
                txtATelefono.setText(a.getApoderado().getTelefono());
                txtADireccion.setText(a.getApoderado().getDireccion());
                txtEstadoCivil.setText(a.getApoderado().getEstadoCivil());
                int resp = JOptionPane.showConfirmDialog(this,"¿DESEAS ELIMINARLO? ","ELIMINAR DATO",JOptionPane.YES_NO_OPTION );
                if(resp == JOptionPane.YES_OPTION){
                    AlumnoDAO.getInstancia().eliminar(idAlumno);
                    JOptionPane.showMessageDialog(this,"REGISTRO ELIMINADO");
                }
                limpiarTextos();
                txtIdApoderado.setText("");
                txtANombre.setText("");
                txtApellidos1.setText("");
                aldao.mostrarAlumnos(modelo);
            }else{
                JOptionPane.showMessageDialog(this,"EL ID ALUMNO NO EXISTE");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        grafico();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(txtIdApoderado.getText().compareTo("")==0 && txtANombre.getText().compareTo("")==0
                && txtApellidos1.getText().compareTo("")==0 && txtATelefono.getText().compareTo("")==0 
                && txtADireccion.getText().compareTo("")==0 && txtEstadoCivil.getText().compareTo("")==0){
            int resp = JOptionPane.showConfirmDialog(this,"¿DESEAS BUSCAR UN APODERADO? ","NO SE INGRESO EL APODERADO",JOptionPane.YES_NO_OPTION );
            if(resp ==JOptionPane.YES_OPTION){
                DialogBuscarApoderado buscarApoderado = new DialogBuscarApoderado();
                buscarApoderado.setVisible(true);
                apoderado = buscarApoderado.apoderadoSelec;
                txtIdApoderado.setText(apoderado.getIdApoderado());
                txtANombre.setText(apoderado.getNombresp());
                txtApellidos1.setText(apoderado.getApellidosp());
                txtATelefono.setText(apoderado.getTelefono());
                txtADireccion.setText(apoderado.getDireccion());
                txtEstadoCivil.setText(apoderado.getEstadoCivil());
            }
            return;
        }
        if(txtidAlumno.getText().equals("")){
            JOptionPane.showMessageDialog(this, "INGRESAR ID");
            txtidAlumno.requestFocus();
            return;
        }
        if(txtNombres.getText().equals("")){
            JOptionPane.showMessageDialog(this, "INGRESAR UN NOMBRE(S)");
            txtANombre.requestFocus();
            return;
        }
        if(txtApellidos.getText().equals("")){
            JOptionPane.showMessageDialog(this, "INGRESAR UN APELLIDO(S)");
            txtApellidos.requestFocus();
            return;
        }
        if(cboSexo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "SELECCIONAR SEXO");
            cboSexo.requestFocus();
            return;
        }
        if(txtTelefono.getText().equals("")){
            JOptionPane.showMessageDialog(this, "INGRESAR UN TELEFONO");
            txtTelefono.requestFocus();
            return;
        }
        if(txtDireccion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "INGRESAR UNA DIRECCION");
            txtDireccion.requestFocus();
            return;
        }
        if(choFechaNacimiento.getCalendar()==null){
            JOptionPane.showMessageDialog(this, "INGRESAR UNA FECHA DE NACIMIENTO");
            choFechaNacimiento.requestFocusInWindow();
            return;
        }
        String idAlumno = txtidAlumno.getText();
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String sexo = cboSexo.getSelectedItem().toString();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        Date fechaNacimiento = choFechaNacimiento.getDate();
        //Atributos apoderado
        String apod = txtIdApoderado.getText();
        Apoderado bs = new Apoderado();
        try {
            ArrayList<Apoderado> a = ApoderadoDAO.getInstancia().mostrarApoderado();
            for(int i=0;i<a.size();i++){
                Apoderado apoderado = a.get(i);
                if(apoderado.getIdApoderado().equals(apod)){
                    bs = ApoderadoDAO.getInstancia().buscarApoderado(apod);  
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Alumno alumno = new Alumno(idAlumno,nombres,apellidos,sexo,telefono,direccion,fechaNacimiento,bs);
        
        if(reg){
            try{
                AlumnoDAO.getInstancia().insertar(alumno);
                JOptionPane.showMessageDialog(null, "ALUMNO REGISTRADO");
                aldao.mostrarAlumnos(modelo);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }else{
            try{
                AlumnoDAO.getInstancia().actualizar(alumno);
                JOptionPane.showMessageDialog(null, "EL ALUMNO SE HA MODIFICADO CORRECTAMENTE");
                aldao.mostrarAlumnos(modelo);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        limpiarTextos();
        textos(false);
        controles(true);
        txtIdApoderado.setText("");
        txtANombre.setText("");
        txtApellidos1.setText("");
        grafico();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarTextos();
        textos(false);
        controles(true);
        grafico();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String idAlumno;
        idAlumno = JOptionPane.showInputDialog("INGRESAR EL ID DEL ALUMNO A MODIFICAR: ");
        Alumno  a;
        try{
            a = AlumnoDAO.getInstancia().buscarAlumno(idAlumno);
            if(a != null){
                txtidAlumno.setText(a.getIdAlumno());
                txtNombres.setText(a.getNombres());
                txtApellidos.setText(a.getApellidos());
                cboSexo.setSelectedItem(a.getSexo());
                txtTelefono.setText(a.getTelefono());
                txtDireccion.setText(a.getDireccion());
                choFechaNacimiento.setDate(a.getFechaNacimiento());
                txtIdApoderado.setText(a.getApoderado().getIdApoderado());
                txtANombre.setText(a.getApoderado().getNombresp());
                txtApellidos1.setText(a.getApoderado().getApellidosp());
                txtATelefono.setText(a.getApoderado().getTelefono());
                txtADireccion.setText(a.getApoderado().getDireccion());
                txtEstadoCivil.setText(a.getApoderado().getEstadoCivil());
                //DDatos Apoderado
                txtIdApoderado.setText(a.getApoderado().getIdApoderado());
                txtANombre.setText(a.getApoderado().getNombresp());
                txtApellidos1.setText(a.getApoderado().getApellidosp());
                txtATelefono.setText(a.getApoderado().getTelefono());
                txtADireccion.setText(a.getApoderado().getDireccion());
                txtEstadoCivil.setText(a.getApoderado().getEstadoCivil());
                reg=false;
                textos(true);
                txtidAlumno.setEnabled(false);
                btnBuscarApoderado.setEnabled(true);
                controles(false);
            }else{
                JOptionPane.showMessageDialog(this,"EL ALUMNO NO SE ENCUENTRA REGISTRADO");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        try {
            aldao.mostrarAlumnos(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        grafico();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnBuscarApoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarApoderadoActionPerformed
        DialogBuscarApoderado f = new DialogBuscarApoderado();
        f.setVisible(true);
        apoderado = f.apoderadoSelec;
        txtIdApoderado.setText(apoderado.getIdApoderado());
        txtANombre.setText(apoderado.getNombresp());
        txtApellidos1.setText(apoderado.getApellidosp());
        txtATelefono.setText(apoderado.getTelefono());
        txtADireccion.setText(apoderado.getDireccion());
        txtEstadoCivil.setText(apoderado.getEstadoCivil());
    }//GEN-LAST:event_btnBuscarApoderadoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String idalumno;
        idalumno = JOptionPane.showInputDialog("INGRESAR EL ID DEL ALUMNO A BUSCAR: ");
        Alumno  a;
        try{
            a = AlumnoDAO.getInstancia().buscarAlumno(idalumno);
            if(a != null){
                txtidAlumno.setText(a.getIdAlumno());
                txtNombres.setText(a.getNombres());
                txtApellidos.setText(a.getApellidos());
                cboSexo.setSelectedItem(a.getSexo());
                txtTelefono.setText(a.getTelefono());
                txtDireccion.setText(a.getDireccion());
                choFechaNacimiento.setDate(a.getFechaNacimiento());
                txtIdApoderado.setText(a.getApoderado().getIdApoderado());
                txtANombre.setText(a.getApoderado().getNombresp());
                txtApellidos1.setText(a.getApoderado().getApellidosp());
                txtATelefono.setText(a.getApoderado().getTelefono());
                txtADireccion.setText(a.getApoderado().getDireccion());
                txtEstadoCivil.setText(a.getApoderado().getEstadoCivil());
            }else{
                JOptionPane.showMessageDialog(this,"EL ALUMNO NO SE ENCUENTRA REGISTRADO");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        try {
             aldao.mostrarAlumnos(modelo);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtIdApoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdApoderadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdApoderadoActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        try {
            dispose();
            ral.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(DialogAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(DialogAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void txtATelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtATelefonoKeyTyped
        char validar= evt.getKeyChar();
        if (txtATelefono.getText().length()>8)
            evt.consume();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"INGRESAR SOLO NUMEROS");
        }
    }//GEN-LAST:event_txtATelefonoKeyTyped

    private void txtANombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtANombreKeyTyped
        char validar= evt.getKeyChar();
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"INGRESAR SOLO LETRAS");
        }
    }//GEN-LAST:event_txtANombreKeyTyped

    private void txtApellidos1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidos1KeyTyped
        char validar= evt.getKeyChar();
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"INGRESAR SOLO LETRAS");
        }
    }//GEN-LAST:event_txtApellidos1KeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        char validar= evt.getKeyChar();
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"INGRESAR SOLO LETRAS");
        }
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        char validar= evt.getKeyChar();
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"INGRESAR SOLO LETRAS");
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char validar= evt.getKeyChar();
        if (txtTelefono.getText().length()>8)
            evt.consume();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"INGRESAR SOLO NUMEROS");
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel15MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel15MouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarApoderado;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboSexo;
    private com.toedter.calendar.JDateChooser choFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelGrafico;
    private javax.swing.JLabel labelGrafico4;
    private javax.swing.JTextField txtADireccion;
    private javax.swing.JTextField txtANombre;
    private javax.swing.JTextField txtATelefono;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidos1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEstadoCivil;
    private javax.swing.JTextField txtIdApoderado;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtidAlumno;
    // End of variables declaration//GEN-END:variables
}
