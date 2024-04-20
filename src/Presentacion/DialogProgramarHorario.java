package Presentacion;

import Datos.ProgramacionDAO;
import Entidad.Aula;
import Entidad.Horario;
import Entidad.Programacion;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class DialogProgramarHorario extends javax.swing.JDialog {
    boolean reg;
  
    Horario idHorario;
    Horario horarioSelecc = new Horario();
    Aula idAula;
    Aula aulaSelec = new Aula();
    DefaultTableModel modelo = new DefaultTableModel();
    ProgramacionDAO p=new ProgramacionDAO();
    String nombreColumnas[]={"IDPROGRAMACION","GRADO","TURNO","FECHA DE INICIO","NUMERO DE AULA","CAPACIDAD"};
    int x,y;
    public DialogProgramarHorario() {
        super(FrmPrincipal.getInst(),true);
        initComponents();
      
        limpiarTextos();
        textos(false);
        controles(true);
        setLocationRelativeTo(null);
        modelo.setColumnIdentifiers(nombreColumnas);
        try {
            p.mostrarProgramaciones(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
    }
    public void limpiarTextos(){
        txtidProgramacion.setText("");
        txtidHorario.setText("");
        txtTurno.setText("");
        txtFecha.setText("");
        txtHoraInicio.setText("");
        txtHoraSalida.setText("");
        txtGrado.setText("");
        txtidAula.setText("");
        txtNumeroAula.setText("");
        txtCapacidad.setText("");
    }
    public void textos(boolean tf){
        txtidProgramacion.setEnabled(tf);
    }
    public void controles(boolean tf){
        btnNuevo.setEnabled(tf);
        btnRegistrar.setEnabled(!tf);
        btnCancelar.setEnabled(!tf);
        btnModificar.setEnabled(tf);
        btnEliminar.setEnabled(tf);
        btnBuscarHorario.setEnabled(!tf);
        btnBuscarAula.setEnabled(!tf);
    }
    public void insertarTabla(){
        String idProgramacion,grado,turno,fecha,numeroAula,capacidad;
        idProgramacion = txtidProgramacion.getText();
        grado = txtGrado.getText();
        turno = txtTurno.getText();
        fecha = txtFecha.getText();
        numeroAula = txtNumeroAula.getText();
        capacidad = txtCapacidad.getText();
        Object datos[][] = new Object[WIDTH][6];
        datos[0][0] = idProgramacion;
        datos[0][1] = grado;
        datos[0][2] = turno;
        datos[0][3] = fecha;
        datos[0][4] = numeroAula;
        datos[0][5] = capacidad;
        modelo.setDataVector(datos, nombreColumnas);
    }
   
    public void limpiarTabla()
    {
        for(int i=0;i<tabla.getRowCount();i++){
            modelo.removeRow(i);
            i-=1;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNumeroAula = new javax.swing.JTextField();
        txtidAula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBuscarAula = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtidHorario = new javax.swing.JTextField();
        txtHoraSalida = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnBuscarHorario = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtHoraInicio = new javax.swing.JTextField();
        txtTurno = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtGrado = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txtidProgramacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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
        setTitle("HORARIO");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("PROGRAMACIÓN DE HORARIO");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 0, 440, 56));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insigniac.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 56));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 612, 56));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(800, 700));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabla.setModel(modelo);
        jScrollPane2.setViewportView(tabla);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 322, 590, 280));

        jPanel5.setBackground(new java.awt.Color(252, 222, 249));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anadir.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-x.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel5.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, 30));

        btnRegistrar.setBackground(new java.awt.Color(204, 204, 204));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/registrarse.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel5.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 120, 30));

        btnSalir.setBackground(new java.awt.Color(204, 204, 204));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salida.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel5.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 120, 30));

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel5.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 120, 30));

        btnModificar.setBackground(new java.awt.Color(204, 204, 204));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizado.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel5.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 120, 30));

        jPanel6.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 182, 290, 130));

        jPanel2.setBackground(new java.awt.Color(252, 222, 249));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)), "SELECCIONAR AULA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 51, 102))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNumeroAula.setEditable(false);
        txtNumeroAula.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        txtNumeroAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroAulaActionPerformed(evt);
            }
        });
        jPanel2.add(txtNumeroAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 45, 89, -1));

        txtidAula.setEditable(false);
        txtidAula.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        jPanel2.add(txtidAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 17, 89, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Capacidad:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 73, -1, -1));

        txtCapacidad.setEditable(false);
        txtCapacidad.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        txtCapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacidadActionPerformed(evt);
            }
        });
        jPanel2.add(txtCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 71, 89, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("idAula:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 19, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Numero Aula:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 47, -1, -1));

        btnBuscarAula.setText("...");
        btnBuscarAula.setToolTipText("Click para buscar aula");
        btnBuscarAula.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));
        btnBuscarAula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAulaActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 40, 25));

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 70, 290, 100));

        jPanel3.setBackground(new java.awt.Color(252, 222, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)), "SELECCIONAR HORARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 51, 102))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtidHorario.setEditable(false);
        txtidHorario.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        jPanel3.add(txtidHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 95, 25));

        txtHoraSalida.setEditable(false);
        txtHoraSalida.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        txtHoraSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraSalidaActionPerformed(evt);
            }
        });
        jPanel3.add(txtHoraSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 125, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Hora entrada:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, -1, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Turno:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 50, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("idHorario:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Fecha de inicio:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        btnBuscarHorario.setText("...");
        btnBuscarHorario.setToolTipText("Click para buscar horario");
        btnBuscarHorario.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));
        btnBuscarHorario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHorarioActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscarHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 40, 25));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Hora salida:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 20));

        txtHoraInicio.setEditable(false);
        txtHoraInicio.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        txtHoraInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraInicioActionPerformed(evt);
            }
        });
        jPanel3.add(txtHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 125, 30));

        txtTurno.setEditable(false);
        txtTurno.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        jPanel3.add(txtTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 125, 25));

        txtFecha.setEditable(false);
        txtFecha.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        jPanel3.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 125, 125, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Grado:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 50, 30));

        txtGrado.setEditable(false);
        txtGrado.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        txtGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGradoActionPerformed(evt);
            }
        });
        jPanel3.add(txtGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 55, 125, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 100, 30));

        jPanel6.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 70, 290, 240));

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtidProgramacion.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        txtidProgramacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidProgramacionKeyReleased(evt);
            }
        });
        jPanel8.add(txtidProgramacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 5, 100, 20));

        jLabel2.setBackground(new java.awt.Color(255, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 102));
        jLabel2.setText("IdProgramación:");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 0, 110, 30));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 28, 590, 30));

        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel7MouseDragged(evt);
            }
        });
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 610, 668));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 610, 602));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 612, 672));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        reg=true;
        limpiarTextos();
        textos(true);
        controles(false);
        txtidProgramacion.requestFocus();
        btnBuscarHorario.setText("...");
        btnBuscarAula.setText("...");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String idProgramacion;
        idProgramacion = JOptionPane.showInputDialog("INGRESAR ID DE PROGRAMACION A MODIFICAR: ");
        Programacion programacion;
        try{
            programacion = ProgramacionDAO.getInstancia().buscarProgramacion(idProgramacion);
            if(programacion != null){
                txtidProgramacion.setText(programacion.getIdProgramacion());
                //ATRIBUTOS HORARIO
                txtidHorario.setText(programacion.getHorario().getIdHorario());
                txtGrado.setText(programacion.getHorario().getGrado());
                txtTurno.setText(programacion.getHorario().getTurno());
                txtFecha.setText(""+programacion.getHorario().getFecha());
                txtHoraInicio.setText(programacion.getHorario().getHoraInicio());
                txtHoraSalida.setText(programacion.getHorario().getHoraSalida());
                //ATRIBUTOS AULA
                txtidAula.setText(programacion.getAula().getIdAula());
                txtNumeroAula.setText(""+programacion.getAula().getNumeroAula());
                txtCapacidad.setText(""+programacion.getAula().getCapacidad());
                int resp = JOptionPane.showConfirmDialog(this,"¿DESEAS ELIMINARLO? ","ELIMINAR DATO",JOptionPane.YES_NO_OPTION );
                if(resp == JOptionPane.YES_OPTION){
                    ProgramacionDAO.getInstancia().eliminar(idProgramacion);
                    JOptionPane.showMessageDialog(this,"REGISTRO ELIMINADO");
                }
                try {
                  p.mostrarProgramaciones(modelo);
                } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
                }
                limpiarTextos();

            }else{
                JOptionPane.showMessageDialog(this,"EL ID DE PROGRAMACION NO EXISTE");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarTextos();
        textos(false);
        controles(true);
        try {
            p.mostrarProgramaciones(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
        btnBuscarHorario.setText("...");
        btnBuscarAula.setText("...");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String idProgramacion;
        idProgramacion = JOptionPane.showInputDialog("INGRESAR ID DE PROGRAMACION A MODIFICAR: ");
        Programacion programacion;
        try{
            programacion = ProgramacionDAO.getInstancia().buscarProgramacion(idProgramacion);
            if(programacion != null){
                txtidProgramacion.setText(programacion.getIdProgramacion());
                //ATRIBUTOS HORARIO
                txtidHorario.setText(programacion.getHorario().getIdHorario());
                txtGrado.setText(programacion.getHorario().getGrado());
                txtTurno.setText(programacion.getHorario().getTurno());
                txtFecha.setText(""+programacion.getHorario().getFecha());
                txtHoraInicio.setText(programacion.getHorario().getHoraInicio());
                txtHoraSalida.setText(programacion.getHorario().getHoraSalida());
                //ATRIBUTOS AULA
                txtidAula.setText(programacion.getAula().getIdAula());
                txtNumeroAula.setText(""+programacion.getAula().getNumeroAula());
                txtCapacidad.setText(""+programacion.getAula().getCapacidad());
                reg=false;
                textos(true);
                btnBuscarHorario.setText("¿MODIFICAR?");
                btnBuscarAula.setText("¿MODIFICAR?");
                txtidProgramacion.setEnabled(false);
                controles(false);
            }else{
                JOptionPane.showMessageDialog(this,"EL ID DE PROGRAMACION NO EXISTE");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(txtidProgramacion.getText().equals("")){
           JOptionPane.showMessageDialog(this, "INGRESAR UN ID");
           txtidProgramacion.requestFocus();
           return;
       }
        if(txtidHorario.getText().compareTo("")==0 && txtTurno.getText().compareTo("")==0 && txtFecha.getText().compareTo("")==0 &&
              txtHoraInicio.getText().compareTo("")==0 && txtHoraSalida.getText().compareTo("")==0){
           JOptionPane.showMessageDialog(this, "INGRESAR HORARIO");
           DialogHorario horario = new DialogHorario();
           horario.setVisible(true);
           txtidHorario.setText(idHorario.getIdHorario());
            txtGrado.setText(idHorario.getGrado());
            txtTurno.setText(idHorario.getTurno());
            txtFecha.setText(""+idHorario.getFecha());
            txtHoraInicio.setText(idHorario.getHoraInicio());
            txtHoraSalida.setText(idHorario.getHoraSalida());
            
           return;
        }
        if(txtidAula.getText().equals("") && txtNumeroAula.getText().equals("") && txtCapacidad.getText().equals("")){
         JOptionPane.showMessageDialog(this, "INGRESAR AULA");
         btnBuscarAula.requestFocus();
         return;
        }
        String idProgramacion;
        idProgramacion = txtidProgramacion.getText();
      
        if(reg){
            if(idHorario.getIdHorario() != null){
                if(idAula.getIdAula() != null){
                    try{
                        Programacion programacion = new Programacion(idProgramacion, idHorario, idAula);
                        ProgramacionDAO.getInstancia().insertar(programacion);
                        JOptionPane.showMessageDialog(null, "PROGRAMACION REGISTRADA");            
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }else{
                  JOptionPane.showMessageDialog(null, "INGRESARCORRECTAMENTE! LOS DATOS...AULA");
                  btnBuscarAula.requestFocus();
                  return;
                }  
            }else{
              JOptionPane.showMessageDialog(null, "INGRESAR CORRECTAMENTE! LOS DATOS...HORARIO");
              btnBuscarHorario.requestFocus();
              return;
            }
        }else{
            if(idHorario.getIdHorario() != null){
                if(idAula.getIdAula() != null){
                    try{
                       Programacion programacion = new Programacion(idProgramacion, idHorario, idAula);
                        ProgramacionDAO.getInstancia().actualizar(programacion);
                        JOptionPane.showMessageDialog(null, "PROGRAMACION MODIFICADA");
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "INGRESAR CORRECTAMENTE! LOS DATOS..AULA");
                    btnBuscarAula.requestFocus();
                    return;
                }
            }else{
              JOptionPane.showMessageDialog(null, "INGRESAR CORRECTAMENTE! LOS DATOS...HORARIO");
              btnBuscarHorario.requestFocus();
              return;
            }
        }
        try {
            p.mostrarProgramaciones(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
        limpiarTextos();
        textos(false);
        controles(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtHoraSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraSalidaActionPerformed

    private void btnBuscarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHorarioActionPerformed
        DialogHorario horario = new DialogHorario();
        horario.setVisible(true);
        idHorario = horario.horarioSelec;
        txtidHorario.setText(idHorario.getIdHorario());
        txtGrado.setText(idHorario.getGrado());
        txtTurno.setText(idHorario.getTurno());
        txtFecha.setText(""+idHorario.getFecha());
        txtHoraInicio.setText(idHorario.getHoraInicio());
        txtHoraSalida.setText(idHorario.getHoraSalida());
        insertarTabla(); 
    }//GEN-LAST:event_btnBuscarHorarioActionPerformed

    private void txtHoraInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraInicioActionPerformed

    private void txtNumeroAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroAulaActionPerformed

    private void txtCapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacidadActionPerformed

    private void btnBuscarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAulaActionPerformed
        DialogAula aula = new DialogAula();
        aula.setVisible(true);
        idAula = aula.aulaSelec;
        txtidAula.setText(idAula.getIdAula());
        txtNumeroAula.setText(""+idAula.getNumeroAula());
        txtCapacidad.setText(""+idAula.getCapacidad());
        try {
            p.mostrarProgramaciones(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
        insertarTabla();
    }//GEN-LAST:event_btnBuscarAulaActionPerformed

    private void txtidProgramacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidProgramacionKeyReleased
       try {
            p.mostrarProgramaciones(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
        insertarTabla();
    }//GEN-LAST:event_txtidProgramacionKeyReleased

    private void txtGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGradoActionPerformed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel7MouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAula;
    private javax.swing.JButton btnBuscarHorario;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtNumeroAula;
    private javax.swing.JTextField txtTurno;
    private javax.swing.JTextField txtidAula;
    private javax.swing.JTextField txtidHorario;
    private javax.swing.JTextField txtidProgramacion;
    // End of variables declaration//GEN-END:variables
}