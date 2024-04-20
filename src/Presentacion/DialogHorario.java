package Presentacion;

import Entidad.Horario;
import Datos.HorarioDAO;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DialogHorario extends javax.swing.JDialog {
    HorarioDAO h=new HorarioDAO();
    boolean reg;
    DefaultTableModel modelo = new DefaultTableModel();
    String nombreColumnas[] = {"IDHORARIO","GRADO","TURNO","FECHA DE INICIO","HORA DE ENTRADA","HORA DE SALIDA"};
    Horario horarioSelec = new Horario();
    int x,y;
    
    public DialogHorario() {
        super(FrmPrincipal.getInst(),true);
        initComponents();
        try {
             h.mostrarHorarios(modelo);
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
         }
        //buscar
        txtBuscarTurno.requestFocus();
        //INGRESAR DATOS HORARIO
        limpiarTextos();
        textos(false);
        controles(true);
        setLocationRelativeTo(null);
       
    }

    public void limpiarTextos(){
        txtidHorario.setText("");
        cboTurno.setSelectedIndex(0);
        chFecha.setDate(null);
        txtHoraEntrada.setText("");
        txthoraSalida.setText("");
        txtBuscarTurno.setText("");
        cboSecundaria.setSelectedIndex(0);

    }
    public void textos(boolean tf){
        txtidHorario.setEditable(tf);
        cboTurno.setEditable(tf);
        chFecha.setEnabled(tf);
        txtHoraEntrada.setEditable(tf);
        txthoraSalida.setEditable(tf);
        txtBuscarTurno.setEditable(!tf);
        cboSecundaria.setEditable(tf);
    }
    public void controles(boolean tf){
        btnNuevo.setEnabled(tf);
        btnRegistrar.setEnabled(!tf);
        btnCancelar.setEnabled(!tf);
        btnModificar.setEnabled(tf);
        btnEliminar.setEnabled(tf);
        btnSeleccionar.setEnabled(tf);
        btnBuscarTurno.setEnabled(tf);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtidHorario = new javax.swing.JTextField();
        txtHoraEntrada = new javax.swing.JTextField();
        cboTurno = new javax.swing.JComboBox();
        chFecha = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        txthoraSalida = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cboSecundaria = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtBuscarTurno = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();
        btnBuscarTurno = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
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
        setTitle("Horario");
        setMinimumSize(new java.awt.Dimension(650, 600));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 51, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 204));
        jLabel13.setText("HORARIO");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, 50));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insigniac.png"))); // NOI18N
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 56, 56));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 56));

        jPanel4.setBackground(new java.awt.Color(244, 244, 244));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("IdHorario:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 17, 60, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Hora de Entrada:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 77, 100, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Turno:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 47, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Fecha de inicio:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 47, 90, 20));

        txtidHorario.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        jPanel4.add(txtidHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 17, 110, 25));

        txtHoraEntrada.setEditable(false);
        txtHoraEntrada.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        txtHoraEntrada.setEnabled(false);
        txtHoraEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraEntradaActionPerformed(evt);
            }
        });
        jPanel4.add(txtHoraEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 77, 110, 28));

        cboTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Escoger>", "Mañana", "Tarde" }));
        cboTurno.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        cboTurno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTurnoActionPerformed(evt);
            }
        });
        jPanel4.add(cboTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 47, 110, 25));

        chFecha.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        jPanel4.add(chFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 47, 130, 25));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Hora Salida:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 77, -1, 20));

        txthoraSalida.setEditable(false);
        txthoraSalida.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        txthoraSalida.setEnabled(false);
        txthoraSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthoraSalidaActionPerformed(evt);
            }
        });
        jPanel4.add(txthoraSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 77, 110, 25));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Grado:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 17, -1, 20));

        cboSecundaria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Escoger>", "1°GRADO", "2°GRADO", "3°GRADO", "4°GRADO", "5°GRADO", "6°GRADO" }));
        cboSecundaria.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102))));
        cboSecundaria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(cboSecundaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 17, 110, 25));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))), "BUSCAR POR TURNO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("Ingresar Turno:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, -1, 20));

        txtBuscarTurno.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));
        txtBuscarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarTurnoActionPerformed(evt);
            }
        });
        txtBuscarTurno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarTurnoKeyReleased(evt);
            }
        });
        jPanel2.add(txtBuscarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 26, 150, 20));

        tabla.setModel(modelo);
        jScrollPane3.setViewportView(tabla);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 55, 580, 190));

        btnSeleccionar.setBackground(new java.awt.Color(216, 216, 216));
        btnSeleccionar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/seleccione.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51))));
        btnSeleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 120, -1));

        btnBuscarTurno.setBackground(new java.awt.Color(216, 216, 216));
        btnBuscarTurno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscarTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnBuscarTurno.setText("Buscar");
        btnBuscarTurno.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51))));
        btnBuscarTurno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTurnoActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 110, -1));

        btnSalir.setBackground(new java.awt.Color(216, 216, 216));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salidab.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51))));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 100, -1));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 187, 610, 310));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)), "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevo.setBackground(new java.awt.Color(216, 216, 216));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anadir.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51))));
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 30));

        btnRegistrar.setBackground(new java.awt.Color(216, 216, 216));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/registrarse.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51))));
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 110, 30));

        btnModificar.setBackground(new java.awt.Color(216, 216, 216));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizado.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51))));
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 110, 30));

        btnEliminar.setBackground(new java.awt.Color(216, 216, 216));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51))));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 105, 30));

        btnCancelar.setBackground(new java.awt.Color(216, 216, 216));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-x.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51))));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 20, 110, 30));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 117, 610, 60));

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
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -56, 630, 588));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 56, 630, 532));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoraEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraEntradaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        reg=true;
        limpiarTextos();
        textos(true);
        controles(false);
        txtidHorario.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       String idHorario;
        idHorario = JOptionPane.showInputDialog("INGRESAR ID HORARIO A ELIMINAR: ");
        Horario horario;
        try{
            horario = HorarioDAO.getInstancia().buscarHorario(idHorario);
            if(horario != null){
                txtidHorario.setText(horario.getIdHorario());
                cboSecundaria.setSelectedItem(horario.getGrado());
                cboTurno.setSelectedItem(horario.getTurno());
                chFecha.setDate(horario.getFecha());
                txtHoraEntrada.setText(horario.getHoraInicio());
                txthoraSalida.setText(horario.getHoraSalida());
                int resp = JOptionPane.showConfirmDialog(this,"¿DESEAS ELIMINARLO? ","ELIMINAR DATO",JOptionPane.YES_NO_OPTION );
                if(resp == JOptionPane.YES_OPTION){
                    HorarioDAO.getInstancia().eliminar(idHorario);
                    JOptionPane.showMessageDialog(this,"REGISTRO ELIMINADO");
                }
                try {
                  h.mostrarHorarios(modelo);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                txtBuscarTurno.requestFocus();
                limpiarTextos();
            }else{
                JOptionPane.showMessageDialog(this,"EL ID DEL HORARIO NO EXISTE");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }  
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarTextos();
        textos(false);
        controles(true);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String idHorario;
        idHorario = JOptionPane.showInputDialog("INGRESAR ID DEL HORARIO A MODIFICAR: ");
        Horario horario;
        try{
            horario = HorarioDAO.getInstancia().buscarHorario(idHorario);
            if(horario != null){
                txtidHorario.setText(horario.getIdHorario());
                cboSecundaria.setSelectedItem(horario.getGrado());
                cboTurno.setSelectedItem(horario.getTurno());
                chFecha.setDate(horario.getFecha());
                txtHoraEntrada.setText(horario.getHoraInicio());
                txthoraSalida.setText(horario.getHoraSalida());
                reg=false;
                textos(true);
                txtidHorario.setEnabled(false);
                controles(false);
            }else{
                JOptionPane.showMessageDialog(this,"EL ID HORARIO NO EXISTE");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }  
         try {
             h.mostrarHorarios(modelo);
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
         }
        txtBuscarTurno.requestFocus();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
       if(txtidHorario.getText().equals("")){
           JOptionPane.showMessageDialog(this, "INGRESAR UN ID");
           txtidHorario.requestFocus();
           return;
       }
       if(cboSecundaria.getSelectedIndex() == 0){
           JOptionPane.showMessageDialog(this, "INGRESAR GRADO DE ESTUDIO");
           cboSecundaria.requestFocus();
           return;
       }
       if(cboTurno.getSelectedIndex() == 0){
           JOptionPane.showMessageDialog(this, "INGRESAR TURNO");
           cboTurno.requestFocus();
           return;
       }
       if(chFecha.getDate()==null){
           JOptionPane.showMessageDialog(this, "INGRESAR FECHA");
           chFecha.requestFocus();
           return;
       }
       if(txtHoraEntrada.getText().equals("")){
           JOptionPane.showMessageDialog(this, "INGRESAR HORA DE INICIO");
           txtHoraEntrada.requestFocus();
           return;
       }
       if(txthoraSalida.getText().equals("")){
           JOptionPane.showMessageDialog(this, "INGRESAR HORA DE SALIDA");
           txthoraSalida.requestFocus();
       }
       
       String idHorario,turno,grado,horaInicio,horaSalida;
       Date fecha;
       idHorario = txtidHorario.getText();
       grado = cboSecundaria.getSelectedItem().toString();
       turno = cboTurno.getSelectedItem().toString();
       fecha = chFecha.getDate();
       horaInicio = txtHoraEntrada.getText();
       horaSalida = txthoraSalida.getText();
       if(turno == "Mañana"){
           horaInicio = "7:20 AM";
           horaSalida = "13:00 PM";
       }else{
           horaInicio = "13:20 PM";
           horaSalida = "18:00 PM";
       }
       Horario x=new Horario(idHorario,grado,turno,fecha, 
            horaInicio,horaSalida);
       if(reg){
            try{
                h.insertar(x);
                JOptionPane.showMessageDialog(this, "HORARIO REGISTRADO");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            } 
       }else{
           try{
                h.actualizar(x);
                JOptionPane.showMessageDialog(this, "HORARIO MODIFICADO");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            } 
       }
       txtBuscarTurno.requestFocus();
       try {
             h.mostrarHorarios(modelo);
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
         }
       limpiarTextos();
       textos(false);
       controles(true);
       
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtBuscarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarTurnoActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int i = tabla.getSelectedRow();
        if(i!=-1) {
            horarioSelec.setIdHorario(modelo.getValueAt(i, 0).toString());
            horarioSelec.setGrado(modelo.getValueAt(i, 1).toString());
            horarioSelec.setTurno(modelo.getValueAt(i, 2).toString());
            horarioSelec.setFecha(java.sql.Date.valueOf(modelo.getValueAt(i, 3).toString()));
            horarioSelec.setHoraInicio(modelo.getValueAt(i, 4).toString());
            horarioSelec.setHoraSalida(modelo.getValueAt(i, 5).toString());
            this.dispose();
        } else
        JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR UN ELEMENTO");
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnBuscarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTurnoActionPerformed
       String turno=txtBuscarTurno.getText();

        try {
             h.buscarPorTurno(turno, modelo);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"ERROR: "+ ex.getMessage() );
        }
    }//GEN-LAST:event_btnBuscarTurnoActionPerformed

    private void txtBuscarTurnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarTurnoKeyReleased
        String turno=txtBuscarTurno.getText();
        try {
             h.buscarPorTurno(turno, modelo);
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"ERROR: "+ ex.getMessage() );
         }
        
    }//GEN-LAST:event_txtBuscarTurnoKeyReleased

    private void cboTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTurnoActionPerformed
        // TODO add your handling code here:
        String turno;
        turno = cboTurno.getSelectedItem().toString();
        if(turno=="Mañana"){
            txtHoraEntrada.setText("7:20 AM");
            txthoraSalida.setText("13:00 PM");
        }else{
        txtHoraEntrada.setText("13:20 PM");
            txthoraSalida.setText("18:00 PM");
        }
    }//GEN-LAST:event_cboTurnoActionPerformed

    private void txthoraSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthoraSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthoraSalidaActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel1MouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarTurno;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox cboSecundaria;
    private javax.swing.JComboBox cboTurno;
    private com.toedter.calendar.JDateChooser chFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscarTurno;
    private javax.swing.JTextField txtHoraEntrada;
    private javax.swing.JTextField txthoraSalida;
    private javax.swing.JTextField txtidHorario;
    // End of variables declaration//GEN-END:variables
}
