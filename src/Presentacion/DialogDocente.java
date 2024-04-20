package Presentacion;

import Datos.AlumnoDAO;
import Entidad.Docente;
import static Presentacion.Globales.*;
import Datos.DocenteDAO;
import Entidad.Alumno;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;


public class DialogDocente extends javax.swing.JDialog {
    DocenteDAO p=new DocenteDAO();
    boolean reg;
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo1 = new DefaultTableModel();
    Alumno alumno;
    int x,y;
    
    public DialogDocente() {
        super(FrmPrincipal.getInst(),true);
        initComponents();
        try {
            p.mostrarProfesor(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        String nombreColumnas[]={"ID-ALUMNO","NOMBRES","APELLIDOS","F-NAC"};
        modelo1.setColumnIdentifiers(nombreColumnas);
        limpiarTextos();
        textos(false);
        controles(true);
        setLocationRelativeTo(null);
    }

    public void limpiarTextos(){
        txtidDocente.setText("");
        txtDni.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtANombre.setText("");
        txtAApellidos.setText("");
        txtAFNacimiento.setText("");
    }
    
    public void limpiarAlumno(){
        txtidAlumno.setText("");
        txtANombre.setText("");
        txtAApellidos.setText("");
        txtAFNacimiento.setText("");
    }
    
    public void textos(boolean tf){
        txtidDocente.setEnabled(tf);
        txtDni.setEnabled(tf);
        txtApellidos.setEnabled(tf);
        txtNombres.setEnabled(tf);
        txtDireccion.setEnabled(tf);
        txtTelefono.setEnabled(tf);
    }
    public void controles(boolean tf){
       btnNuevo.setEnabled(tf);
       btnRegistrar.setEnabled(!tf);
       btnCancelar.setEnabled(!tf);
       btnBuscarAlumno.setEnabled(!tf);
       btnEliminar.setEnabled(!tf);
       btnAgregar.setEnabled(!tf);
    }
    
    public void limpiarTabla()
    {
        for(int i=0;i<tabla.getRowCount();i++){
            modelo1.removeRow(i);
            i-=1;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtidDocente = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnReporte1 = new javax.swing.JButton();
        btnReporte2 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnEliminar1 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtidAlumno = new javax.swing.JTextField();
        txtANombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnBuscarAlumno = new javax.swing.JButton();
        txtAFNacimiento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtAApellidos = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Profesor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(244, 244, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(252, 202, 249));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)), "DATOS DEL DOCENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Apellidos:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Telefono:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nombres:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 85, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Dni:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 14, -1, 28));

        txtApellidos.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 224, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Direccion:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txtNombres.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 85, 224, 25));

        txtDireccion.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 224, 25));

        txtDni.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });
        jPanel2.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 14, 84, 25));

        txtidDocente.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        jPanel2.add(txtidDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 79, 25));

        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 107, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("IdDocente:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, 30));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 70, 322, 210));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 774, -1));

        jPanel4.setBackground(new java.awt.Color(252, 202, 249));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)), "OPCIONES:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel4.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, 30));

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
        jPanel4.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, 30));

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
        jPanel4.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 120, 30));

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
        jPanel4.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, 30));

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
        jPanel4.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 30));

        btnSalir.setBackground(new java.awt.Color(204, 204, 204));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 51, 102));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salida.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 120, 30));

        btnReporte.setBackground(new java.awt.Color(204, 204, 204));
        btnReporte.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(0, 51, 102));
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel4.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 120, 30));

        btnReporte1.setBackground(new java.awt.Color(204, 204, 204));
        btnReporte1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReporte1.setForeground(new java.awt.Color(0, 51, 102));
        btnReporte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        btnReporte1.setText("Reporte");
        btnReporte1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnReporte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 120, 30));

        btnReporte2.setBackground(new java.awt.Color(204, 204, 204));
        btnReporte2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReporte2.setForeground(new java.awt.Color(0, 51, 102));
        btnReporte2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        btnReporte2.setText("Reporte");
        btnReporte2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnReporte2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnReporte2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 120, 30));

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
        jPanel4.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 120, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 290, 210));

        jPanel6.setBackground(new java.awt.Color(255, 51, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("GESTIONAR DOCENTE");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 0, 410, 56));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insigniac.png"))); // NOI18N
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 60, 60));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1078, 60));

        jTable2.setModel(modelo);
        jScrollPane2.setViewportView(jTable2);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 294, 630, 310));

        jPanel5.setBackground(new java.awt.Color(252, 202, 249));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)), "DATOS DEL ALUMNO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Constantia", 1, 15))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar1.setBackground(new java.awt.Color(242, 242, 242));
        btnEliminar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnEliminar1.setText("ELIMINAR");
        btnEliminar1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        btnEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 168, 120, -1));

        btnAgregar.setBackground(new java.awt.Color(242, 242, 242));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-agregar.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel5.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 168, 120, -1));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("idAlmno:");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 14, 56, -1));

        txtidAlumno.setEditable(false);
        txtidAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidAlumnoActionPerformed(evt);
            }
        });
        jPanel9.add(txtidAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 14, 109, -1));

        txtANombre.setEditable(false);
        jPanel9.add(txtANombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 42, 182, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("F-Nac:");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 98, 56, -1));

        btnBuscarAlumno.setText("...");
        btnBuscarAlumno.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));
        btnBuscarAlumno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlumnoActionPerformed(evt);
            }
        });
        jPanel9.add(btnBuscarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 14, 40, 23));

        txtAFNacimiento.setEditable(false);
        jPanel9.add(txtAFNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 98, 126, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Nombres:");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 42, 56, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Apellidos:");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 70, 56, -1));

        txtAApellidos.setEditable(false);
        jPanel9.add(txtAApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 182, -1));

        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 28, 280, 126));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 70, 406, 210));

        tabla.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204))));
        tabla.setModel(modelo1);
        jScrollPane3.setViewportView(tabla);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 294, 406, 308));

        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1078, 616));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1078, 616));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        reg=true;
        limpiarTextos();
        textos(true);
        controles(false);
        txtidDocente.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String idProfespor;
        limpiarTextos();
        idProfespor = JOptionPane.showInputDialog("INGRESAR ID DEL DOCENTE A ELIMINAR: ");
        Docente profesor;
        try{
            profesor = DocenteDAO.getInstancia().buscarProfesor(idProfespor);
            if(profesor != null){
                txtidDocente.setText(profesor.getIddocente());
                txtDni.setText(profesor.getDni());
                txtApellidos.setText(profesor.getApellidosd());
                txtNombres.setText(profesor.getNombresd());
                txtTelefono.setText(profesor.getTelefono());
                txtDireccion.setText(profesor.getDireccion());
                int resp = JOptionPane.showConfirmDialog(this,"¿DESEAS ELIMINARLO ","ELIMINAR DATO",JOptionPane.YES_NO_OPTION );
                if(resp == JOptionPane.YES_OPTION){
                    DocenteDAO.getInstancia().eliminar(idProfespor);
                    DocenteDAO.getInstancia().mostrarProfesor(modelo);
                    JOptionPane.showMessageDialog(this,"REGISTRO ELIMINADO");
                }
                limpiarTextos();
            }else{
                JOptionPane.showMessageDialog(this,"ID DEL DOCENTE NO REGISTRADO");
            }     
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        try {
            p.mostrarProfesor(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarTextos();
        textos(false);
        controles(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String idProfesor,nombres,apellidos,telefono,direccion,dni;
        idProfesor = txtidDocente.getText();
        dni = txtDni.getText();
        apellidos = txtApellidos.getText();
        nombres = txtNombres.getText();
        telefono = txtTelefono.getText();
        direccion = txtDireccion.getText();
        Docente x=new Docente(idProfesor, dni, apellidos, nombres, telefono, direccion);
        try {
            p.buscarProfesor(idProfesor);
            p.actualizar(x);
            p.mostrarProfesor(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        limpiarTextos();
        textos(false);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
       if(txtidDocente.getText().equals("")){
           JOptionPane.showMessageDialog(this, "INGRESAR UN ID");
           txtidDocente.requestFocus();
           return;
       }
       if(txtDni.getText().equals("")){
           JOptionPane.showMessageDialog(this, "INGRESAR UN DNI");
           txtDni.requestFocus();
           return;
       }
       if(txtApellidos.getText().equals("")){
           JOptionPane.showMessageDialog(this, "INGRESAR UN APELLIDO(S)");
           txtApellidos.requestFocus();
           return;
       }
       if(txtNombres.getText().equals("")){
           JOptionPane.showMessageDialog(this, "INGRESAR UN NOMBRE(S)");
           txtNombres.requestFocus();
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
       
       if(alumno != null){
            try{
                                
                String idProfesor,nombres,apellidos,telefono,direccion,dni;
                idProfesor = txtidDocente.getText();
                dni = txtDni.getText();
                apellidos = txtApellidos.getText();
                nombres = txtNombres.getText();
                telefono = txtTelefono.getText();
                direccion = txtDireccion.getText();
                Docente x=new Docente(idProfesor, dni, apellidos, nombres, telefono, direccion);            
                //REGISTRA DOCENTE
                int filas = modelo1.getRowCount();
                for (int i = 0; i < filas; i++) {
                    String idalumno = (String) modelo1.getValueAt(i, 0);
                    Alumno alumno = AlumnoDAO.getInstancia().buscarAlumno(idalumno);
                    x.regitrarDetalleDocente(alumno);
                }
                DocenteDAO.getInstancia().insertar(x);
                JOptionPane.showMessageDialog(null, "DOCENTE REGISTRADO");
                
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
        }
        try {
            p.mostrarProfesor(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        limpiarTextos();
        textos(false);
        controles(true);
        limpiarTabla();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String idProfesor;
        idProfesor = JOptionPane.showInputDialog("INGRESAR ID DEL DOCENTE A BUSCAR: ");
        Docente  profesor;
        try{
            profesor = DocenteDAO.getInstancia().buscarProfesor(idProfesor);
            if(profesor != null){
                txtidDocente.setText(profesor.getIddocente());
                txtDni.setText(profesor.getDni());
                txtApellidos.setText(profesor.getApellidosd());
                txtNombres.setText(profesor.getNombresd());
                txtTelefono.setText(profesor.getTelefono());
                txtDireccion.setText((profesor.getDireccion()));
            }else{
                JOptionPane.showMessageDialog(this,"EL ID DEL DOCENTE NO ESTA REGISTRADO");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        textos(true);
        txtidDocente.setEnabled(false);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporte1ActionPerformed

    private void btnReporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte2ActionPerformed
        try {
            dispose();
            rdo.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(DialogDocente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(DialogDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporte2ActionPerformed

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        char validar= evt.getKeyChar();
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"INGRESAR SOLO LETRAS");
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        char validar= evt.getKeyChar();
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"INGRESAR SOLO LETRAS");
        }
    }//GEN-LAST:event_txtNombresKeyTyped

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

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        char validar= evt.getKeyChar();
        if (txtDni.getText().length()>7)
            evt.consume();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"INGRESAR SOLO NUMEROS");
        }
    }//GEN-LAST:event_txtDniKeyTyped

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        int i = tabla.getSelectedRow();
        if (i != -1) {
            int rpta = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO?", "ELIMINAR", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (rpta == JOptionPane.OK_OPTION) {
                modelo1.removeRow(i);
            }
        } else
        JOptionPane.showMessageDialog(null, "SELECCIONE UN ALUMNO", "ELIMINAR", 1);
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Object[] fila = {txtidAlumno.getText(),txtANombre.getText(),txtAApellidos.getText(),txtAFNacimiento.getText()};
        if(txtidAlumno.getText().compareTo("")!=0 && txtANombre.getText().compareTo("")!=0 && txtAApellidos.getText().compareTo("")!=0
                && txtAFNacimiento.getText().compareTo("")!=0)
        modelo1.addRow(fila);
        else {
            JOptionPane.showMessageDialog(null, "Alumno", "Warning", 1);
            btnBuscarAlumno.requestFocus();
        }
        limpiarAlumno();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtidAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidAlumnoActionPerformed

    private void btnBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlumnoActionPerformed
        DialogBuscarAlumno buscarAlumno = new DialogBuscarAlumno();
        buscarAlumno.setVisible(true);
        alumno = buscarAlumno.alumnoSelec;
        txtidAlumno.setText(alumno.getIdAlumno());
        txtANombre.setText(alumno.getNombres());
        txtAApellidos.setText(alumno.getApellidos());
        txtAFNacimiento.setText(alumno.getFechaNacimiento().toString());
    }//GEN-LAST:event_btnBuscarAlumnoActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel1MouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarAlumno;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnReporte1;
    private javax.swing.JButton btnReporte2;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtAApellidos;
    private javax.swing.JTextField txtAFNacimiento;
    private javax.swing.JTextField txtANombre;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtidAlumno;
    private javax.swing.JTextField txtidDocente;
    // End of variables declaration//GEN-END:variables
}
