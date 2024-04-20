package Presentacion;


import Entidad.Docente;
import Datos.DocenteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DialogBuscarDocente extends javax.swing.JDialog {
    DocenteDAO pr=new DocenteDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    String[] nombreColumnas = {"IDPROFESOR","DNI","APELLIDOS","NOMBRE","TELEFONO","DIRECCION"};
    DefaultTableModel modelo1 = new DefaultTableModel();
    String nombreColumnas1[] = {"IDCURSO","NOMBRE"};
    Docente profesorSelec = new Docente();
    int x,y;
    
    public DialogBuscarDocente() throws SQLException {
        super(FrmPrincipal.getInst(),true);
        initComponents();
        setLocationRelativeTo(null);
        modelo1.setColumnIdentifiers(nombreColumnas1);
        ArrayList<Docente> LD = DocenteDAO.getInstancia().mostrarPro();
        for(int i=0;i<LD.size();i++)
            cboidDocente.addItem(LD.get(i).getIddocente());
        try {
            pr.mostrarProfesor(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void limpiarTabla(){
        try {
            modelo1 = (DefaultTableModel) tabla1.getModel();
            int filas = tabla1.getRowCount();
            for (int i = 0;i<=filas; i++) {
            modelo1.removeRow(0);
            }
        } catch (Exception e) {
            try {
                pr.mostrarProfesor(modelo);
            } catch (SQLException ex) {
                Logger.getLogger(DialogBuscarDocente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cboidDocente = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Profesor");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("BUSCAR DOCENTE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(modelo);
        jScrollPane2.setViewportView(tabla);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 56, 597, 200));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Buscar por Id - Docente:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 13, -1, 30));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        btnBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 13, 40, 30));

        btnSeleccionar.setBackground(new java.awt.Color(204, 204, 204));
        btnSeleccionar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(0, 51, 102));
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/seleccione.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setToolTipText("Seleccionar un profesor de la lista.");
        btnSeleccionar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnSeleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 284, 112, 30));

        btnTodos.setBackground(new java.awt.Color(204, 204, 204));
        btnTodos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTodos.setForeground(new java.awt.Color(0, 51, 102));
        btnTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/casilla-de-verificacion.png"))); // NOI18N
        btnTodos.setText("Todos");
        btnTodos.setToolTipText("Muestra todos los profesores registrados.");
        btnTodos.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        btnTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });
        jPanel2.add(btnTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 341, 112, 30));

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
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 396, 112, 30));

        tabla1.setBorder(new javax.swing.border.MatteBorder(null));
        tabla1.setModel(modelo1);
        jScrollPane1.setViewportView(tabla1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 310, 467, 116));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lista De Alumnos A Cargo Del Docente");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 274, 467, -1));

        cboidDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboidDocenteKeyReleased(evt);
            }
        });
        jPanel2.add(cboidDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 13, 334, 30));

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
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -42, 700, 504));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 42, 700, 462));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int i = tabla.getSelectedRow();
        if(i!=-1) {
            profesorSelec.setIddocente(modelo.getValueAt(i, 0).toString());
            profesorSelec.setDni(modelo.getValueAt(i, 1).toString());
            profesorSelec.setApellidosd(modelo.getValueAt(i, 2).toString());
            profesorSelec.setNombresd(modelo.getValueAt(i, 3).toString());
            profesorSelec.setTelefono(modelo.getValueAt(i, 4).toString());
            profesorSelec.setDireccion(modelo.getValueAt(i, 5).toString());
            this.dispose();
        } else
        JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR UN ELEMENTO");
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String iddocente = cboidDocente.getSelectedItem().toString();
        try {
            Docente docente = DocenteDAO.getInstancia().buscarProfesor(iddocente);
            if(docente != null)
            {
                docente.mostrar(modelo1);
            }
            else{
                JOptionPane.showMessageDialog(null, "EL ID DE LA MATRICULA NO EXISTE");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        try {
            pr.mostrarProfesor(modelo);
            limpiarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cboidDocenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboidDocenteKeyReleased
        String iddocente = cboidDocente.getSelectedItem().toString();
        try {
            pr.buscarPorIdDocente(iddocente, modelo);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"ERROR: "+ ex.getMessage() );
        }
    }//GEN-LAST:event_cboidDocenteKeyReleased

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
    private javax.swing.JComboBox cboidDocente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
