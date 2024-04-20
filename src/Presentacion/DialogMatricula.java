package Presentacion;

import Datos.CursoDAO;
import Datos.MatriculaDAO;
import Datos.ProgramacionDAO;
import Entidad.Alumno;
import Entidad.Aula;
import Entidad.Curso;
import Entidad.Horario;
import Entidad.Matricula;
import Entidad.Programacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class DialogMatricula extends javax.swing.JDialog {
    DefaultTableModel modelo = new DefaultTableModel();
    boolean reg;
    Alumno idAlumno;
    Curso curso;
    Programacion idPro;
    int x,y;
    public DialogMatricula() {
        
        super(FrmPrincipal.getInst(),true);
        initComponents();
        limpiarTextos();
        textos(false);
        controles(true);
        String nombreColumnas[]={"IDCURSO","NOMBRE"};
        modelo.setColumnIdentifiers(nombreColumnas);
        setLocationRelativeTo(null);       
//        mostrar los horarios programados
        try {
            ArrayList<Programacion> lista = ProgramacionDAO.getInstancia().mostrarProgramacion();
            for(int i=0;i<lista.size();i++){
                cboProgramacion.addItem(lista.get(i).getIdProgramacion());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void limpiarCapacidad(){
        txtidHorario.setText("");
        txtGrado.setText("");
        txtTurno.setText("");
        txtFecha.setDate(null);
        txtHoraInicio.setText("");
        txtHoraSalida.setText("");
        txtidAula.setText("");
        txtNumeroAula.setText("");
        txtCapacidad.setText("");
    }
    public void limpiarTextos(){
        txtidMatricula.setText("");
        chFechaMatricula.setDate(null);
        txtidAlumno.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtSexo.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtFechaNacimiento.setText("");
        txtidHorario.setText("");
        txtGrado.setText("");
        txtTurno.setText("");
        txtFecha.setDate(null);
        txtHoraInicio.setText("");
        txtHoraSalida.setText("");
        txtidAula.setText("");
        txtNumeroAula.setText("");
        txtCapacidad.setText("");
        txtidCurso.setText("");
        txtNombre.setText("");
   }
    public void textos(boolean tf){
       txtidMatricula.setEditable(tf);
       chFechaMatricula.setEnabled(tf);
       cboProgramacion.setEnabled(tf);
   }
    public void controles(boolean tf){
       btnNuevo.setEnabled(tf);
       btnRegistrar.setEnabled(!tf);
       btnCancelar.setEnabled(!tf);
       btnBuscarAlumno.setEnabled(!tf);
       btnBuscarHorario.setEnabled(!tf);
       btnBuscarCurso.setEnabled(!tf);
       btnEliminar.setEnabled(!tf);
       btnAgregar.setEnabled(!tf);
   }
    public void limpiarTabla()
    {
        for(int i=0;i<tabla.getRowCount();i++){
            modelo.removeRow(i);
            i-=1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtidAlumno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        btnBuscarAlumno = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtidCurso = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnBuscarCurso = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cboProgramacion = new javax.swing.JComboBox();
        btnBuscarHorario = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtHoraSalida = new javax.swing.JTextField();
        txtidHorario = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtHoraInicio = new javax.swing.JTextField();
        txtGrado = new javax.swing.JTextField();
        txtTurno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtNumeroAula = new javax.swing.JTextField();
        txtCapacidad = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtidAula = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtalumnos = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        txtidMatricula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        chFechaMatricula = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Regitrar Matricula");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(244, 244, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(720, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 790));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 51, 102));
        jPanel5.setForeground(new java.awt.Color(0, 0, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 153, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("REGISTRAR  MATRÍCULA");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insigniac.png"))); // NOI18N
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 56, 56));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 56));

        jPanel2.setBackground(new java.awt.Color(252, 222, 249));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)), "DATOS DEL ALUMNO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Constantia", 1, 15), new java.awt.Color(255, 51, 102))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(247, 247, 247));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Dirección:");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 147, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Fecha Nacimiento:");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 173, -1, -1));

        txtDireccion.setEditable(false);
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel8.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 145, 170, -1));

        txtApellidos.setEditable(false);
        jPanel8.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 67, 170, -1));

        txtTelefono.setEditable(false);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel8.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 119, 94, -1));

        txtSexo.setEditable(false);
        txtSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexoActionPerformed(evt);
            }
        });
        jPanel8.add(txtSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 93, 170, -1));

        txtFechaNacimiento.setEditable(false);
        txtFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoActionPerformed(evt);
            }
        });
        jPanel8.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 171, 96, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Nombres:");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 43, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Apellidos:");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 69, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Telefono:");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 121, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Sexo:");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 95, -1, -1));

        txtidAlumno.setEditable(false);
        jPanel8.add(txtidAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 13, 94, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("IdAlumno:");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 16, -1, -1));

        txtNombres.setEditable(false);
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        jPanel8.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 41, 170, -1));

        btnBuscarAlumno.setText("...");
        btnBuscarAlumno.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));
        btnBuscarAlumno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlumnoActionPerformed(evt);
            }
        });
        jPanel8.add(btnBuscarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 12, 56, 23));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 21, 310, 200));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 126, 350, 230));

        jPanel3.setBackground(new java.awt.Color(252, 222, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)), "DATOS DEL CURSO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Constantia", 1, 15), new java.awt.Color(255, 51, 102))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(242, 242, 242));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 120, -1));

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
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 120, -1));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("idCurso:");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 17, -1, -1));

        txtidCurso.setEditable(false);
        txtidCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidCursoActionPerformed(evt);
            }
        });
        jPanel9.add(txtidCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 15, 109, -1));

        txtNombre.setEditable(false);
        jPanel9.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 43, 172, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Nombre:");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 45, -1, -1));

        btnBuscarCurso.setText("...");
        btnBuscarCurso.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));
        btnBuscarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCursoActionPerformed(evt);
            }
        });
        jPanel9.add(btnBuscarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 14, 40, 23));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 21, 260, 80));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 126, 290, 160));

        jPanel4.setBackground(new java.awt.Color(252, 222, 249));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)), "PROGRAMAR HORARIO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Constantia", 1, 15), new java.awt.Color(255, 51, 102))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboProgramacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(cboProgramacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 100, 23));

        btnBuscarHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        btnBuscarHorario.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));
        btnBuscarHorario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHorarioActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscarHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 40, 23));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("idProgramacion:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Fecha de inicio:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Hora inicio:");

        txtHoraSalida.setEditable(false);
        txtHoraSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraSalidaActionPerformed(evt);
            }
        });

        txtidHorario.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Hora final:");

        txtFecha.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("idHorario:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Grado:");

        txtHoraInicio.setEditable(false);
        txtHoraInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraInicioActionPerformed(evt);
            }
        });

        txtGrado.setEditable(false);

        txtTurno.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Turno:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel21))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtGrado, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTurno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNumeroAula.setEditable(false);
        txtNumeroAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroAulaActionPerformed(evt);
            }
        });
        jPanel7.add(txtNumeroAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 38, 92, -1));

        txtCapacidad.setEditable(false);
        txtCapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacidadActionPerformed(evt);
            }
        });
        jPanel7.add(txtCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 64, 92, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("idAula:");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 14, -1, -1));

        txtidAula.setEditable(false);
        jPanel7.add(txtidAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 12, 92, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Capacidad:");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 66, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Numero Aula:");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 40, -1, -1));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 252, 308, 92));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 364, 350, 364));

        tabla.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204))));
        tabla.setModel(modelo);
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 294, 293, 214));

        btnCancelar.setBackground(new java.awt.Color(226, 226, 226));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-x.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setToolTipText("click para cancelar la operación");
        btnCancelar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 616, 140, 40));

        btnSalir1.setBackground(new java.awt.Color(226, 226, 226));
        btnSalir1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salidab.png"))); // NOI18N
        btnSalir1.setText("SALIR");
        btnSalir1.setToolTipText("Click para salir");
        btnSalir1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        btnSalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 616, 120, 40));

        btnRegistrar.setBackground(new java.awt.Color(226, 226, 226));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/registrarse.png"))); // NOI18N
        btnRegistrar.setText("REGISTRARSE");
        btnRegistrar.setToolTipText("Click para regitrar al alumno.");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 560, 140, 40));

        btnNuevo.setBackground(new java.awt.Color(226, 226, 226));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new1 .png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 560, 120, 40));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("*Numero de Alumnos incritos en Horario");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 518, -1, 24));
        jLabel24.getAccessibleContext().setAccessibleName("*Numero de Alumnos incritos en\n Horario:");
        jLabel24.getAccessibleContext().setAccessibleDescription("");

        txtalumnos.setEditable(false);
        txtalumnos.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));
        txtalumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalumnosActionPerformed(evt);
            }
        });
        jPanel1.add(txtalumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 518, 70, 25));

        jPanel10.setBackground(new java.awt.Color(249, 249, 249));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153))));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtidMatricula.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtidMatricula.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));
        jPanel10.add(txtidMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 120, 22));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Codigo Matricula:");
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Fecha:");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        chFechaMatricula.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));
        jPanel10.add(chFechaMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 122, 22));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 70, 660, 40));

        jLabel23.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel23MouseDragged(evt);
            }
        });
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel23MousePressed(evt);
            }
        });
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 742));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 742));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        reg=true;
        limpiarTextos();
        textos(true);
        controles(false);
        txtidMatricula.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int i = tabla.getSelectedRow();
        if (i != -1) {
            int rpta = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO?", "ELIMINAR", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (rpta == JOptionPane.OK_OPTION) {
                modelo.removeRow(i);
            }
        } else
            JOptionPane.showMessageDialog(null, "SELECCIONE UN CURSO", "ELIMINAR", 1);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(txtidMatricula.getText().equals("")){
            JOptionPane.showMessageDialog(this, "INGRESAR UN ID DE MATRICULA");
            txtidMatricula.requestFocus();
            return;
        }
        if(chFechaMatricula.getDate()==null){
            JOptionPane.showMessageDialog(this, "INGRESAR FECHA");
            chFechaMatricula.requestFocus();
            return;
        }
                
        if(curso != null){
            try{
                                
                String idMatricula = txtidMatricula.getText();
                Date fechaMatricula = chFechaMatricula.getDate();
                //Captura Programacion - Horario
                String idHorario = txtidHorario.getText();
                String grado = txtGrado.getText();
                String turno = txtTurno.getText();
                Date fechaInicio = txtFecha.getDate();
                String horaSalida = txtHoraSalida.getText();
                String horaInicio = txtHoraInicio.getText();
                Horario horario = new Horario(idHorario, grado, turno,fechaInicio, horaInicio, horaSalida);
                //Capura Programacion - Aula
                String idAula = txtidAula.getText();
                int numeroAula = Integer.parseInt(txtNumeroAula.getText());
                int capacidad = Integer.parseInt(txtCapacidad.getText());
                Aula aula = new Aula(idAula, numeroAula, capacidad);
                //Captura Programacion 
                String idProgramacion = (String) cboProgramacion.getSelectedItem();
                Programacion programacion = new Programacion(idProgramacion, horario, aula);
                //VALIDA CAPACIDAD EN EL AULA
                int a = programacion.getAula().getCapacidad();
                int cont=0;
                try{
                    ArrayList<Matricula> m = MatriculaDAO.getInstancia().mostrarMatricula();
                    for(int i=0;i<m.size();i++){
                        Matricula matricula1 = m.get(i);
                        if(matricula1.getProgramacion().getAula().getCapacidad()==a){
                            cont++;
                        }
                    }
                    if(cont==a){
                        JOptionPane.showMessageDialog(this, "PROGRAMACION: " +programacion.getIdProgramacion()+
                            " .COMPLETO CAPACIDAD DE ALUMNOS REGISTRADOS, SELECCIONE OTRA PROGRAMACION.");
                        limpiarCapacidad();
                        btnBuscarHorario.requestFocus();
                        return;
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }              
                //REGISTRA MATRICULA
                Matricula matricula = new Matricula(idMatricula, fechaMatricula, idAlumno,programacion);
                int filas = modelo.getRowCount();
                for (int i = 0; i < filas; i++) {
                    String idCurso = (String) modelo.getValueAt(i, 0);
                    Curso curso = CursoDAO.getInstancia().buscarCurso(idCurso);
                    matricula.regitrarDetalleMatricula(curso);
                }
                MatriculaDAO.getInstancia().insertar(matricula);
                JOptionPane.showMessageDialog(null, "MATRICULA REGISTRADA");
                
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
        }
        textos(false);
        limpiarTextos();
        controles(true);
        limpiarTabla();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       limpiarTextos();
       textos(false);
       controles(true);
       limpiarTabla();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSexoActionPerformed

    private void txtFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacimientoActionPerformed

    private void btnBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlumnoActionPerformed
        DialogBuscarAlumno buscarAlumno = new DialogBuscarAlumno();
        buscarAlumno.setVisible(true);
        idAlumno = buscarAlumno.alumnoSelec;
        txtidAlumno.setText(idAlumno.getIdAlumno());
        txtNombres.setText(idAlumno.getNombres());
        txtApellidos.setText(idAlumno.getApellidos());
        txtSexo.setText(idAlumno.getSexo());
        txtTelefono.setText(idAlumno.getTelefono());
        txtDireccion.setText(idAlumno.getDireccion());
        txtFechaNacimiento.setText(""+idAlumno.getFechaNacimiento());
    }//GEN-LAST:event_btnBuscarAlumnoActionPerformed

    private void btnBuscarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCursoActionPerformed
        DialogBuscarCurso buscarCurso = new DialogBuscarCurso();
        buscarCurso.setVisible(true);
        curso = buscarCurso.cursoSelec;
        txtidCurso.setText(curso.getIdCurso());
        txtNombre.setText(curso.getNombre());
    }//GEN-LAST:event_btnBuscarCursoActionPerformed

    private void txtidCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidCursoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       Object[] fila = {txtidCurso.getText(),txtNombre.getText()};
        if(txtidCurso.getText().compareTo("")!=0 && txtNombre.getText().compareTo("")!=0)
            modelo.addRow(fila);
        else {
            JOptionPane.showMessageDialog(null, "Cursoo", "Warning", 1);
            btnBuscarCurso.requestFocus();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtHoraInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraInicioActionPerformed

    private void txtHoraSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraSalidaActionPerformed

    private void txtNumeroAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroAulaActionPerformed

    private void txtCapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacidadActionPerformed

    private void btnBuscarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHorarioActionPerformed
        String idProgramacion = (String) cboProgramacion.getSelectedItem();
        if(idProgramacion != null){
            try {
                Programacion programacion = ProgramacionDAO.getInstancia().buscarProgramacion(idProgramacion);
                txtidHorario.setText(programacion.getHorario().getIdHorario());
                txtGrado.setText(programacion.getHorario().getGrado());
                txtTurno.setText(programacion.getHorario().getTurno());
                txtFecha.setDate(programacion.getHorario().getFecha());
                txtHoraInicio.setText(programacion.getHorario().getHoraInicio());
                txtHoraSalida.setText(programacion.getHorario().getHoraSalida());
                txtidAula.setText(programacion.getAula().getIdAula());
                txtNumeroAula.setText(""+programacion.getAula().getNumeroAula());
                txtCapacidad.setText(""+programacion.getAula().getCapacidad());
                //Mostrar numero de alumnos
                int numAlumnos = MatriculaDAO.getInstancia().cantidad();
                txtalumnos.setText("");
                if(numAlumnos>0){
                    txtalumnos.setText(""+numAlumnos);
                }

            }catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
   
    }//GEN-LAST:event_btnBuscarHorarioActionPerformed

    private void txtalumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalumnosActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void jLabel23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel23MousePressed

    private void jLabel23MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel23MouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarAlumno;
    private javax.swing.JButton btnBuscarCurso;
    private javax.swing.JButton btnBuscarHorario;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JComboBox cboProgramacion;
    private com.toedter.calendar.JDateChooser chFechaMatricula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtDireccion;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNumeroAula;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTurno;
    private javax.swing.JTextField txtalumnos;
    private javax.swing.JTextField txtidAlumno;
    private javax.swing.JTextField txtidAula;
    private javax.swing.JTextField txtidCurso;
    private javax.swing.JTextField txtidHorario;
    private javax.swing.JTextField txtidMatricula;
    // End of variables declaration//GEN-END:variables
}
