package Presentacion;


import Entidad.Curso;
import Datos.CursoDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DialogBuscarCurso extends javax.swing.JDialog {
    CursoDAO p=new CursoDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    String[] nombreColumnas = {"IDCURSO","NOMBRE","ID-DOCENTE"};
    Curso cursoSelec = new Curso();
    int x,y;
    public DialogBuscarCurso() {
        super(FrmPrincipal.getInst(),true);
        initComponents();
        
        setLocationRelativeTo(null);
        txtBuscaNombre.requestFocus();
        try {
              p.mostrarCursos(modelo);
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnSeleccionar = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscaNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Buscar por nombre:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        btnBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 40, 30));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSeleccionar.setBackground(new java.awt.Color(204, 204, 204));
        btnSeleccionar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(0, 51, 102));
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/seleccione.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setToolTipText("Seleccionar un curso de la lista.");
        btnSeleccionar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnSeleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 89, 110, 30));

        btnBuscar1.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar1.setForeground(new java.awt.Color(0, 51, 102));
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/casilla-de-verificacion.png"))); // NOI18N
        btnBuscar1.setText("Todos");
        btnBuscar1.setToolTipText("Muestra todos los cursos registrados.");
        btnBuscar1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 89, 110, 30));

        btnSalir.setBackground(new java.awt.Color(204, 204, 204));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 51, 102));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salidab.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 89, 110, 30));

        tabla.setModel(modelo);
        jScrollPane2.setViewportView(tabla);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 132, 680, 185));

        jPanel1.setBackground(new java.awt.Color(255, 51, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("BUSCAR CURSO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 30));

        txtBuscaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaNombreActionPerformed(evt);
            }
        });
        txtBuscaNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaNombreKeyReleased(evt);
            }
        });
        jPanel2.add(txtBuscaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 51, 270, 30));

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
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 330));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaNombreActionPerformed
     
    }//GEN-LAST:event_txtBuscaNombreActionPerformed

    private void txtBuscaNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNombreKeyReleased
        String nombre=txtBuscaNombre.getText();
        try {
             p.buscarPorNombre(nombre, modelo);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"ERROR: "+ ex.getMessage() );
        }
    }//GEN-LAST:event_txtBuscaNombreKeyReleased

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int i = tabla.getSelectedRow();
        if(i!=-1) {
            cursoSelec.setIdCurso(modelo.getValueAt(i, 0).toString());
            cursoSelec.setNombre(modelo.getValueAt(i, 1).toString());
            //cursoSelec.setApellidos(modelo.getValueAt(i, 2).toString());
            this.dispose();
        } else
        JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR UN ELEMENTO");
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nombre=txtBuscaNombre.getText();
        try {
             p.buscarPorNombre(nombre, modelo);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"ERROR: "+ ex.getMessage() );
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        try {
            p.mostrarCurso();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        txtBuscaNombre.setText("");
        txtBuscaNombre.requestFocus();
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscaNombre;
    // End of variables declaration//GEN-END:variables
}
