package Presentacion;

import Entidad.Apoderado;
import static Presentacion.Globales.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DialogBuscarApoderado extends javax.swing.JDialog {

    
    DefaultTableModel modelo = new DefaultTableModel();
    String[] nombreColumnas = {"IDAPODERADO","NOMBRE","APELLIDOS","TELEFONO","DIRECCION","ESTADO CIVIL"};
    Apoderado apoderadoSelec = new Apoderado();
    int x,y;
    public DialogBuscarApoderado() {
        super(FrmPrincipal.getInst(), true);
        initComponents();
        try{
            apdao.mostrarApoderados(modelo);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
        setLocationRelativeTo(null);
        txtIdApoderado.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIdApoderado = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Apoderado");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdApoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdApoderadoActionPerformed(evt);
            }
        });
        txtIdApoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdApoderadoKeyReleased(evt);
            }
        });
        getContentPane().add(txtIdApoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 270, 30));

        tabla.setModel(modelo);
        jScrollPane2.setViewportView(tabla);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 650, 220));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 567, -1));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 670, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(204, 204, 204));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 51, 102));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salidab.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 140, 30));

        btnSeleccionar.setBackground(new java.awt.Color(204, 204, 204));
        btnSeleccionar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(0, 51, 102));
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/seleccione.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setToolTipText("Seleccionar un apoderado de la lista.");
        btnSeleccionar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnSeleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel4.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 130, 30));

        btnTodos.setBackground(new java.awt.Color(204, 204, 204));
        btnTodos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTodos.setForeground(new java.awt.Color(0, 51, 102));
        btnTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/casilla-de-verificacion.png"))); // NOI18N
        btnTodos.setText("Todos");
        btnTodos.setToolTipText("Muestra todos los apoderados registrados.");
        btnTodos.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });
        jPanel4.add(btnTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 120, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Buscar por idApoderado:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 160, 30));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        btnBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 40, 30));

        jPanel3.setBackground(new java.awt.Color(255, 51, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("BUSCAR APODERADO");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, -2, -1, 30));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 686, 30));

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
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 686, 364));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 686, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdApoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdApoderadoActionPerformed
        // TODO add your handling code here

    }//GEN-LAST:event_txtIdApoderadoActionPerformed

    private void txtIdApoderadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdApoderadoKeyReleased
        String idapoderado = txtIdApoderado.getText();
        try{
            apdao.mostrarPorIdApoderado(idapoderado, modelo);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
    }//GEN-LAST:event_txtIdApoderadoKeyReleased

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int i = tabla.getSelectedRow();
        if(i!=-1) {
            apoderadoSelec.setIdApoderado(modelo.getValueAt(i, 0).toString());
            apoderadoSelec.setNombresp(modelo.getValueAt(i, 1).toString());
            apoderadoSelec.setApellidosp(modelo.getValueAt(i, 2).toString());
            apoderadoSelec.setTelefono(modelo.getValueAt(i, 3).toString());
            apoderadoSelec.setDireccion(modelo.getValueAt(i, 4).toString());
            apoderadoSelec.setEstadoCivil(modelo.getValueAt(i, 5).toString());
        } else
            JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR UN ELEMENTO");
        dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String idapoderado = txtIdApoderado.getText();
        try{
            apdao.mostrarPorIdApoderado(idapoderado, modelo);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        try{
            apdao.mostrarApoderados(modelo);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel1MouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtIdApoderado;
    // End of variables declaration//GEN-END:variables
}
