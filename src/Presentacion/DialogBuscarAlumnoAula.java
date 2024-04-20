package Presentacion;

import Datos.MatriculaDAO;
import Entidad.Matricula;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DialogBuscarAlumnoAula extends javax.swing.JDialog {

    
    DefaultTableModel modelo = new DefaultTableModel();
    String nombreColumnas[]={"IDALUMNO","NOMBRE","APELLIDOS","SEXO","FECHA DE NACIMIENTO"};
    int x,y;
    public DialogBuscarAlumnoAula() {
        super(FrmPrincipal.getInst(),true);
        initComponents();
        setLocationRelativeTo(null);
        modelo.setColumnIdentifiers(nombreColumnas);
        try{
            ArrayList<Matricula> lista = MatriculaDAO.getInstancia().mostrarMatricula();
            for(int i=0;i<lista.size();i++){
                cboaula.addItem(lista.get(i).getProgramacion().getAula().getIdAula());
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnBuscarAula = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cboaula = new javax.swing.JComboBox();
        txtnumeroAula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(232, 232, 232));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscarAula.setBackground(new java.awt.Color(232, 232, 232));
        btnBuscarAula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        btnBuscarAula.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        btnBuscarAula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAulaActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 40, 28));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Seleccionar idAula:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 45, -1, 30));

        jPanel2.add(cboaula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 123, 25));

        txtnumeroAula.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        txtnumeroAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroAulaActionPerformed(evt);
            }
        });
        jPanel2.add(txtnumeroAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 109, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Numero de aula:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jTable1.setModel(modelo);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 650, 170));

        jPanel3.setBackground(new java.awt.Color(255, 51, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("BUSCAR ALUMNOS EN UN AULA");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 410, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 706, -1));

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
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 56, 108, 30));

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
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 706, 322));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumeroAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroAulaActionPerformed

    private void btnBuscarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAulaActionPerformed
        // TODO add your handling code here:
        String idaula = (String) cboaula.getSelectedItem();
        try{
            ArrayList<Matricula> m = MatriculaDAO.getInstancia().mostrarMatricula();
            Object datos[][] = new Object[m.size()][5];
            for(int i=0;i<m.size();i++){
                Matricula matricula = m.get(i);
                if(matricula.getProgramacion().getAula().getIdAula().equals(idaula)){
                    txtnumeroAula.setText(""+matricula.getProgramacion().getAula().getNumeroAula());
                    //for(int j=i;j<m.size();j++){
                    if(i==0){
                        datos[i][0]=matricula.getAlumno().getIdAlumno();
                        datos[i][1]=matricula.getAlumno().getNombres();
                        datos[i][2]=matricula.getAlumno().getApellidos();
                        datos[i][3]=matricula.getAlumno().getSexo();
                        datos[i][4]=matricula.getAlumno().getFechaNacimiento();
                    //}
                    }else{
                        datos[i][0]=matricula.getAlumno().getIdAlumno();
                        datos[i][1]=matricula.getAlumno().getNombres();
                        datos[i][2]=matricula.getAlumno().getApellidos();
                        datos[i][3]=matricula.getAlumno().getSexo();
                        datos[i][4]=matricula.getAlumno().getFechaNacimiento();
                    }
                }
            }
            modelo.setDataVector(datos, nombreColumnas);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnBuscarAulaActionPerformed

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
    private javax.swing.JButton btnBuscarAula;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboaula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtnumeroAula;
    // End of variables declaration//GEN-END:variables
}
