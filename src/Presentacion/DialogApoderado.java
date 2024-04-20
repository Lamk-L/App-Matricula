package Presentacion;

import Datos.ApoderadoDAO;
import Entidad.Apoderado;
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
import org.jfree.data.category.DefaultCategoryDataset;

public class DialogApoderado extends javax.swing.JDialog {
    DefaultTableModel modelo= new DefaultTableModel();
    int posicion;
    boolean reg;
    int x,y;
    
    JFreeChart grafico;
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();
    
    public DialogApoderado() {
        super(FrmPrincipal.getInst(),true);
        initComponents();
        try{
            apdao.mostrarApoderados(modelo);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
        grafico();
        limpiarTextos();
        textos(false);
        controles(true);
        setLocationRelativeTo(null);
    }
    public void grafico(){
        int a1=0,a2=0;
        String b;
        for(int i=0;i<modelo.getRowCount();i++){
            b=(String)modelo.getValueAt(i, 5);
            if("Casado(a)".equalsIgnoreCase(modelo.getValueAt(i, 5).toString())){
                a1++;
                Datos.addValue(a1,"Central",b);  
            }else{
                a2++;
                Datos.addValue(a2,"Central",b);  
              }
        }
        grafico=ChartFactory.createBarChart3D("GRÁFICO DE ESTADO CIVIL","Estado Civil","Numero de Personas", 
                Datos, PlotOrientation.VERTICAL,true,true,false);
        ChartPanel Panel = new ChartPanel(grafico);
        BufferedImage graficoBarra=grafico.createBufferedImage
        (labelGrafico.getWidth(), labelGrafico.getHeight());
        labelGrafico.setSize(labelGrafico.getSize());
        labelGrafico.setIcon(new ImageIcon(graficoBarra));
        labelGrafico.updateUI();
    }
    
    public void limpiarTextos(){
        txtIdApoderado.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        cboEstadoCivil.setSelectedIndex(0);
        txtDireccion.setText("");
    }
    public void textos(boolean tf){
        txtIdApoderado.setEditable(tf);
        txtNombres.setEditable(tf);
        txtApellidos.setEditable(tf);
        txtTelefono.setEditable(tf);
        cboEstadoCivil.setEnabled(tf);
        txtDireccion.setEditable(tf);
        
    }
    public void controles(boolean tf){
        btnNuevo.setEnabled(tf);
        btnRegistrar.setEnabled(!tf);
        btnCancelar.setEnabled(!tf);
        btnModificar.setEnabled(tf);
        btnEliminar.setEnabled(tf);
        btnBuscar.setEnabled(tf);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdApoderado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboEstadoCivil = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        labelGrafico = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

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
        setTitle("Apoderado");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setForeground(new java.awt.Color(102, 102, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(244, 244, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 710, -1));

        jPanel3.setBackground(new java.awt.Color(252, 222, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)), "DATOS PERSONALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("IdApoderado:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, -1, 20));
        jPanel3.add(txtIdApoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 120, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombres:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 60, 80, 20));

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
        jPanel3.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 220, 30));

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });
        jPanel3.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 220, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Apellidos:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 105, 73, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Telefono:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 60, 30));

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
        jPanel3.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 220, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Dirección:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 73, 20));
        jPanel3.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 220, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Estado Civil:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 80, 30));

        cboEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Escoger>", "Soltero(a)", "Casado(a)" }));
        jPanel3.add(cboEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 120, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 340, 260));

        jTable2.setModel(modelo);
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 690, 270));

        jPanel4.setBackground(new java.awt.Color(252, 222, 249));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)), "OPCIONES", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel4.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 189, 112, 40));

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
        jPanel4.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 189, 112, 40));

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 51, 102));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/expediente.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 136, 112, 40));

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
        jPanel4.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 136, 112, 40));

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
        jPanel4.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 83, 112, 40));

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
        jPanel4.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 83, 112, 40));

        btnNuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 51, 102));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anadir.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 30, 112, 40));

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
        jPanel4.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 30, 112, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 340, 260));

        jPanel5.setBackground(new java.awt.Color(255, 51, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INFORMACIÓN DEL APODERADO");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1162, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insigniac.png"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1162, 60));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelGrafico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 434, 540));

        jLabel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel10MouseDragged(evt);
            }
        });
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1162, 630));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1162, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        reg=true;
        limpiarTextos();
        textos(true);
        controles(false);
        txtIdApoderado.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        limpiarTextos();
        String idApoderado;
        idApoderado = JOptionPane.showInputDialog("Ingrese Id del apoderado a eliminar:");
        Apoderado apoderado;
        try{
            apoderado = ApoderadoDAO.getInstancia().buscarApoderado(idApoderado);
            if(apoderado != null){
                txtIdApoderado.setText(apoderado.getIdApoderado());
                txtNombres.setText(apoderado.getNombresp());
                txtApellidos.setText(apoderado.getApellidosp());
                txtTelefono.setText(apoderado.getTelefono());
                txtDireccion.setText(apoderado.getDireccion());
                cboEstadoCivil.setSelectedItem(apoderado.getEstadoCivil());
                int resp = JOptionPane.showConfirmDialog(this,"Deseas Eliminarlo ","Eliminar Dato",JOptionPane.YES_NO_OPTION );
                if(resp == JOptionPane.YES_OPTION){
                    ApoderadoDAO.getInstancia().eliminar(idApoderado);
                    JOptionPane.showMessageDialog(this,"Registro eliminado");
                    apdao.mostrarApoderados(modelo);
                }
                limpiarTextos();
            }else
                JOptionPane.showMessageDialog(this,"id apoderado no existe");   
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        grafico();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarTextos();
        textos(false);
        controles(true);
        grafico();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String idApoderado;
        idApoderado = JOptionPane.showInputDialog("Ingrese Id del apoderado a modificar: ");
        Apoderado  apoderado;
        try{
            apoderado = ApoderadoDAO.getInstancia().buscarApoderado(idApoderado);
            if(apoderado != null){
                txtIdApoderado.setText(apoderado.getIdApoderado());
                txtNombres.setText(apoderado.getNombresp());
                txtApellidos.setText(apoderado.getApellidosp());
                txtTelefono.setText(apoderado.getTelefono());
                txtDireccion.setText(apoderado.getDireccion());
                cboEstadoCivil.setSelectedItem(apoderado.getEstadoCivil());
                reg=false;
                textos(true);
                txtIdApoderado.setEnabled(false);
                controles(false);
            }else
                JOptionPane.showMessageDialog(this,"El id apoderado no existe");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        grafico();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(txtIdApoderado.getText().equals("")){
            JOptionPane.showMessageDialog(this, "ingresar un id");
            txtIdApoderado.requestFocus();
            return;
        }
        if(txtNombres.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ingresar un nombre(s)");
            txtNombres.requestFocus();
            return;
        }
        if(txtApellidos.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ingresar un apellido(s)");
            txtApellidos.requestFocus();
            return;
        }
        if(txtTelefono.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ingresar un telefono");
            txtTelefono.requestFocus();
            return;
        }
        if(txtDireccion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ingresar un dirección");
            txtDireccion.requestFocus();
            return;
        }
        if(cboEstadoCivil.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Seleccionar un estado civil");
            cboEstadoCivil.requestFocus();
            return;
        }
        String idapoderado,nombres,apellidos,telefono,direccion,estadoCivil;
        idapoderado = txtIdApoderado.getText();
        nombres = txtNombres.getText();
        apellidos = txtApellidos.getText();
        telefono = txtTelefono.getText();
        direccion = txtDireccion.getText();
        estadoCivil = cboEstadoCivil.getSelectedItem().toString();
        Apoderado x = new Apoderado(idapoderado,nombres,apellidos,telefono,direccion,estadoCivil);
        if(reg){
            try{
                apdao.insertar(x);
                JOptionPane.showMessageDialog(this, "Apoderado registrado");
                apdao.mostrarApoderados(modelo);
            }catch(SQLException e){
                 System.out.println(e.getMessage());
            }         
        }else{
            try{
                apdao.actualizar(x);
                JOptionPane.showMessageDialog(this, "Apoderado modificado");
                apdao.mostrarApoderados(modelo);
            }catch(SQLException e){
                 System.out.println(e.getMessage());
            }
        }
        limpiarTextos();
        textos(false);
        controles(true);
        grafico();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String idapoderado = txtIdApoderado.getText();
        textos(true);
        if(idapoderado.equalsIgnoreCase(""))
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UN CODIGO");
        else{
            try{
                Apoderado a = apdao.buscarApoderado(idapoderado);
                if(a==null){
                   JOptionPane.showMessageDialog(null, "CODIGO NO ENCONTRADO");
                   limpiarTextos();
                }else{
                    txtNombres.setText(a.getNombresp());
                    txtApellidos.setText(a.getApellidosp());
                    txtTelefono.setText(a.getTelefono());
                    txtDireccion.setText(a.getDireccion());
                    cboEstadoCivil.setSelectedItem(a.getEstadoCivil());
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

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

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        char validar= evt.getKeyChar();
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"INGRESAR SOLO LETRAS");
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        try {
            dispose();
            rap.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(DialogApoderado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(DialogApoderado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel10MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel10MouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboEstadoCivil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel labelGrafico;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdApoderado;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
