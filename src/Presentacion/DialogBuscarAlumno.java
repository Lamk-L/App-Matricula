package Presentacion;

import Entidad.Alumno;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static Presentacion.Globales.*;
import javax.swing.table.DefaultTableModel;


public class DialogBuscarAlumno extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel();
    String[] nombreColumnas = {"IDALUMNO","NOMBRE","APELLIDOS","SEXO","TELEFONO","DIRECCION","FECHA DE NACIMIENTO","IDAPODERADO"};
    Alumno alumnoSelec = new Alumno();
    public Alumno ejemplarSelec = new Alumno();
    int x,y;
    public DialogBuscarAlumno() {
        super(FrmPrincipal.getInst(), true);
        initComponents();
        setLocationRelativeTo(null);
        txtIdAlumno.requestFocus();
        try{
            aldao.mostrarAlumnos(modelo);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtIdAlumno = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Alumno");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(232, 232, 232));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Buscar por IdAlumno:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        btnSeleccionar.setBackground(new java.awt.Color(204, 204, 204));
        btnSeleccionar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(0, 51, 102));
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/seleccione.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setToolTipText("Seleccionar un alumno de la lista de alumnos.");
        btnSeleccionar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        btnSeleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 130, 30));

        btnTodos.setBackground(new java.awt.Color(204, 204, 204));
        btnTodos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTodos.setForeground(new java.awt.Color(0, 51, 102));
        btnTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/casilla-de-verificacion.png"))); // NOI18N
        btnTodos.setText("Todos");
        btnTodos.setToolTipText("Muestra todos los alumnos registrados.");
        btnTodos.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        btnTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });
        jPanel2.add(btnTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 110, 30));

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
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 110, 30));

        tabla.setModel(modelo);
        jScrollPane2.setViewportView(tabla);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 670, 210));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        btnBuscar.setToolTipText("");
        btnBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 40, 30));

        txtIdAlumno.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204))));
        txtIdAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdAlumnoActionPerformed(evt);
            }
        });
        txtIdAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdAlumnoKeyReleased(evt);
            }
        });
        jPanel2.add(txtIdAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 297, 30));

        jPanel1.setBackground(new java.awt.Color(255, 51, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("BUSCAR ALUMNO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 28));

        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 350));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdAlumnoActionPerformed
        // TODO add your handling code here

    }//GEN-LAST:event_txtIdAlumnoActionPerformed

    private void txtIdAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdAlumnoKeyReleased
        String idalumno = txtIdAlumno.getText();
        try{
            aldao.mostrarPorIdAlumno(idalumno, modelo);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
    }//GEN-LAST:event_txtIdAlumnoKeyReleased

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int i = tabla.getSelectedRow();
        if(i != -1) {
            alumnoSelec.setIdAlumno(modelo.getValueAt(i, 0).toString());
            alumnoSelec.setNombres(modelo.getValueAt(i, 1).toString());
            alumnoSelec.setApellidos(modelo.getValueAt(i, 2).toString());
            alumnoSelec.setSexo(modelo.getValueAt(i, 3).toString());
            alumnoSelec.setTelefono(modelo.getValueAt(i, 4).toString());
            alumnoSelec.setDireccion(modelo.getValueAt(i, 5).toString());
            alumnoSelec.setFechaNacimiento(Date.valueOf(modelo.getValueAt(i, 6).toString()));
            this.dispose();
        } else
        JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR UN ELEMENTO");
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String idalumno = txtIdAlumno.getText();
        try{
            aldao.mostrarPorIdAlumno(idalumno, modelo);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        try{
            aldao.mostrarAlumnos(modelo);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel2MouseDragged

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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtIdAlumno;
    // End of variables declaration//GEN-END:variables
}
