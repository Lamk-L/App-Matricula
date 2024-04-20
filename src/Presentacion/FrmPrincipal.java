package Presentacion;

import images.DesktopConFondo;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Presentacion.Globales.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.sf.jasperreports.engine.JRException;

public class FrmPrincipal extends javax.swing.JFrame implements Runnable{

    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    int x, y;
    private static FrmPrincipal inst;

    public static FrmPrincipal getInst() {
        if(inst==null){
            inst = new FrmPrincipal();
        }
        return inst;
    }
    
    public FrmPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        lblFecha.setText(fecha());
        h1 = new Thread(this);
        h1.start();
    }
    
    @Override
        public void run() {
            Thread ct = Thread.currentThread();
            
            while(ct == h1){
                calcula();
                lblRelog.setText(hora+":"+minutos+":"+segundos+" "+ampm);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
            }
        }
        
        private void calcula() {
            Calendar  calendario = new GregorianCalendar();
            Date fha = new Date();
            
            calendario.setTime(fha);
            ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
            
            if(ampm.equals("PM")){
                int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
                hora = h>9?""+h:"0"+h;
            }else{
                hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
            }
            minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
        }
    
    
    
    public static String fecha(){
        Date f = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
        return formato.format(f);
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpnEscritorio = new DesktopConFondo();
        lblRelog = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        Label = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem16 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuRDAPO = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        mnuRDA = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        mnuRDPRO = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        mnuRDC = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        mnuROrdenados = new javax.swing.JMenu();
        mnuApodAsc = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        mniRAlmunoOrdenNom = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        jMenuItem20 = new javax.swing.JMenuItem();
        jSeparator24 = new javax.swing.JPopupMenu.Separator();
        jMenuItem21 = new javax.swing.JMenuItem();
        jSeparator27 = new javax.swing.JPopupMenu.Separator();
        jMenu10 = new javax.swing.JMenu();
        RAlumApod = new javax.swing.JMenuItem();
        jSeparator28 = new javax.swing.JPopupMenu.Separator();
        RDocAlum = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        RCurDoc = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        RProgram = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        RMatrProg = new javax.swing.JMenuItem();
        jSeparator26 = new javax.swing.JPopupMenu.Separator();
        RMatrCur = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        menuAcercaDe = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Matricula Colegio - Ciro Alegria");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        dpnEscritorio.setBackground(new java.awt.Color(153, 153, 153));
        dpnEscritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dpnEscritorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRelog.setFont(new java.awt.Font("Comic Sans MS", 0, 38)); // NOI18N
        lblRelog.setForeground(new java.awt.Color(255, 255, 255));
        lblRelog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRelog.setText("00:00:00 (AM/PM)");
        dpnEscritorio.add(lblRelog, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 364, 47));
        dpnEscritorio.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 123, -1, 130));

        lblUsuario.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dpnEscritorio.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 150, 47));

        lblUsuario1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario1.setText("Usuario:");
        dpnEscritorio.add(lblUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 0, 130, 47));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Prin.jpg"))); // NOI18N
        dpnEscritorio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 70, 798, 420));

        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel3MouseDragged(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        dpnEscritorio.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -37, 920, 602));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bienvenido Al Sistema De Matricula");

        lblFecha.setBackground(new java.awt.Color(255, 255, 255));
        lblFecha.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("00/00/00");

        Label.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Label.setForeground(new java.awt.Color(255, 255, 255));
        Label.setText("Fecha:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Label)
                .addGap(18, 18, 18)
                .addComponent(lblFecha)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Label, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arbol-de-familia.png"))); // NOI18N
        jMenu2.setText("Apoderado");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem12.setText("Contenedor Apoderado");
        jMenuItem12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);
        jMenu2.add(jSeparator3);

        jMenuItem16.setText("Buscar Apoderado");
        jMenuItem16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);
        jMenu2.add(jSeparator5);

        mnuRDAPO.setText("Reporte de Apoderados");
        mnuRDAPO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuRDAPO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRDAPOActionPerformed(evt);
            }
        });
        jMenu2.add(mnuRDAPO);

        jMenuBar1.add(jMenu2);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/graduacion (1).png"))); // NOI18N
        jMenu1.setText("Alumno  ");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem15.setText("Contenedor Alumno");
        jMenuItem15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem15);
        jMenu1.add(jSeparator4);

        jMenuItem3.setText("Buscar Alumno");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator17);

        mnuRDA.setText("Reporte de Alumnos");
        mnuRDA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuRDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRDAActionPerformed(evt);
            }
        });
        jMenu1.add(mnuRDA);
        jMenu1.add(jSeparator7);

        jMenuItem17.setText("Reporte Alumno-Apoderado");
        jMenuItem17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem17);

        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profesor.png"))); // NOI18N
        jMenu3.setText("Profesor   ");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem5.setText("Contenedor Profesor");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);
        jMenu3.add(jSeparator9);

        jMenuItem6.setText("Buscar Profesor");
        jMenuItem6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);
        jMenu3.add(jSeparator10);

        mnuRDPRO.setText("Reporte de Profesores");
        mnuRDPRO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuRDPRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRDPROActionPerformed(evt);
            }
        });
        jMenu3.add(mnuRDPRO);

        jMenuBar1.add(jMenu3);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadernos.png"))); // NOI18N
        jMenu6.setText("Curso     ");
        jMenu6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem8.setText("Contenedor Curso");
        jMenuItem8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jSeparator11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu6.add(jSeparator11);

        jMenuItem1.setText("Buscar Curso");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);
        jMenu6.add(jSeparator12);

        mnuRDC.setText("Reporte de Cursos");
        mnuRDC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuRDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRDCActionPerformed(evt);
            }
        });
        jMenu6.add(mnuRDC);
        jMenu6.add(jSeparator13);

        jMenuItem9.setText("Reportar Curso de un Profesor");
        jMenuItem9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);

        jMenuBar1.add(jMenu6);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendario.png"))); // NOI18N
        jMenu4.setText("Programacion de Horario  ");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem7.setText("Programar Horario");
        jMenuItem7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/matricula.png"))); // NOI18N
        jMenu5.setText("Matricula    ");
        jMenu5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem11.setText("Registrar Matricula");
        jMenuItem11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);
        jMenu5.add(jSeparator14);

        jMenuItem13.setText("Reportar Matricula");
        jMenuItem13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);
        jMenu5.add(jSeparator15);

        jMenuItem14.setText("Reportar Alunmos en un aula");
        jMenuItem14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuBar1.add(jMenu5);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        jMenu9.setText("Reporte     ");
        jMenu9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mnuROrdenados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf1.png"))); // NOI18N
        mnuROrdenados.setText("Reportes Ordenados");
        mnuROrdenados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mnuApodAsc.setText("Apoderado - Nombre");
        mnuApodAsc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuApodAsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuApodAscActionPerformed(evt);
            }
        });
        mnuROrdenados.add(mnuApodAsc);
        mnuROrdenados.add(jSeparator22);

        jMenuItem18.setText("Apoderado - Apellido");
        jMenuItem18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        mnuROrdenados.add(jMenuItem18);
        mnuROrdenados.add(jSeparator21);

        mniRAlmunoOrdenNom.setText("Alumno - Nombre");
        mniRAlmunoOrdenNom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniRAlmunoOrdenNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRAlmunoOrdenNomActionPerformed(evt);
            }
        });
        mnuROrdenados.add(mniRAlmunoOrdenNom);
        mnuROrdenados.add(jSeparator23);

        jMenuItem19.setText("Alumno - Apellido");
        jMenuItem19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        mnuROrdenados.add(jMenuItem19);
        mnuROrdenados.add(jSeparator20);

        jMenuItem20.setText("Docente - Nombre");
        jMenuItem20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        mnuROrdenados.add(jMenuItem20);
        mnuROrdenados.add(jSeparator24);

        jMenuItem21.setText("Docente - Apellido");
        jMenuItem21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        mnuROrdenados.add(jMenuItem21);

        jMenu9.add(mnuROrdenados);
        jMenu9.add(jSeparator27);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf1.png"))); // NOI18N
        jMenu10.setText("Reportes Agrupados");
        jMenu10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        RAlumApod.setText("Alumno - Apoderado");
        RAlumApod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RAlumApod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAlumApodActionPerformed(evt);
            }
        });
        jMenu10.add(RAlumApod);
        jMenu10.add(jSeparator28);

        RDocAlum.setText("Docente - Alumno");
        RDocAlum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RDocAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDocAlumActionPerformed(evt);
            }
        });
        jMenu10.add(RDocAlum);
        jMenu10.add(jSeparator6);

        RCurDoc.setText("Curso -Docente");
        RCurDoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RCurDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RCurDocActionPerformed(evt);
            }
        });
        jMenu10.add(RCurDoc);
        jMenu10.add(jSeparator8);

        RProgram.setText("Programacion");
        RProgram.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RProgramActionPerformed(evt);
            }
        });
        jMenu10.add(RProgram);
        jMenu10.add(jSeparator16);

        RMatrProg.setText("Matricula -Programación");
        RMatrProg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RMatrProg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RMatrProgActionPerformed(evt);
            }
        });
        jMenu10.add(RMatrProg);
        jMenu10.add(jSeparator26);

        RMatrCur.setText("Matricula_Curso");
        RMatrCur.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RMatrCur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RMatrCurActionPerformed(evt);
            }
        });
        jMenu10.add(RMatrCur);

        jMenu9.add(jMenu10);

        jMenuBar1.add(jMenu9);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ayuda.png"))); // NOI18N
        jMenu7.setText("Ayuda");
        jMenu7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuAcercaDe.setText("Acerca de");
        menuAcercaDe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcercaDeActionPerformed(evt);
            }
        });
        jMenu7.add(menuAcercaDe);
        jMenu7.add(jSeparator2);

        menuSalir.setText("Salir");
        menuSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu7.add(menuSalir);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dpnEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dpnEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ((DesktopConFondo) dpnEscritorio).setImagen("/images/portada.png");
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
         DialogBuscarMatricula reporteMatricula = null;
        try {
            reporteMatricula = new DialogBuscarMatricula();
        } catch (SQLException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
         reporteMatricula.setVisible(true);
        
        
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        DialogMatricula matricula = new DialogMatricula();
        matricula.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        DialogProgramarHorario programarHorario = new DialogProgramarHorario();
        programarHorario.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        DialogMostrarCursoDocente cursosDocente = new DialogMostrarCursoDocente();
        cursosDocente.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DialogBuscarCurso buscarCurso = new DialogBuscarCurso();
        buscarCurso.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        DialogCurso curso = new DialogCurso();
        curso.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        DialogBuscarDocente buscarProfesor;
        try {
            buscarProfesor = new DialogBuscarDocente();
            buscarProfesor.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        DialogDocente profesor = new DialogDocente();
        profesor.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        DialogBuscarAlumno buscarAlumno = new DialogBuscarAlumno();
        buscarAlumno.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        DialogAlumno alum = new DialogAlumno();
        alum.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        DialogBuscarAlumnoAula buscarAlumnoAula = new DialogBuscarAlumnoAula();
        buscarAlumnoAula.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcercaDeActionPerformed
        new DialogAcercaDe(this).setVisible(true);
    }//GEN-LAST:event_menuAcercaDeActionPerformed

    private void mnuRDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRDAActionPerformed
       DialogReporteAlumno apo = new DialogReporteAlumno();
        apo.setVisible(true);
    }//GEN-LAST:event_mnuRDAActionPerformed

    private void mnuRDAPOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRDAPOActionPerformed
        DialogReporteApoderado apo = new DialogReporteApoderado();
        apo.setVisible(true);
    }//GEN-LAST:event_mnuRDAPOActionPerformed

    private void mnuRDPROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRDPROActionPerformed
        DialogReporteDocente apo = new DialogReporteDocente();
        apo.setVisible(true);
    }//GEN-LAST:event_mnuRDPROActionPerformed

    private void mnuRDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRDCActionPerformed
        DialogReporteCurso c = new DialogReporteCurso();
        c.setVisible(true);
    }//GEN-LAST:event_mnuRDCActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        DialogBuscarApoderado buscarApoderado = new DialogBuscarApoderado();
        buscarApoderado.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        DialogMostrarAlumnoPorApoderado dmapa = new DialogMostrarAlumnoPorApoderado();
        dmapa.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void RMatrCurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RMatrCurActionPerformed
        try {
            rrmc.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RMatrCurActionPerformed

    private void RMatrProgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RMatrProgActionPerformed
        try {
            rrm.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RMatrProgActionPerformed

    private void RProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RProgramActionPerformed
        try {
            rrp.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RProgramActionPerformed

    private void RCurDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RCurDocActionPerformed
        try {
            rrc.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RCurDocActionPerformed

    private void RDocAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDocAlumActionPerformed
        try {
            rda.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RDocAlumActionPerformed

    private void RAlumApodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAlumApodActionPerformed
        try {
            rra.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RAlumApodActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        try {
            rdap.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        try {
            rdna.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        try {
            rala.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void mniRAlmunoOrdenNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRAlmunoOrdenNomActionPerformed
        try {
            ralna.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniRAlmunoOrdenNomActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        try {
            rapa.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void mnuApodAscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuApodAscActionPerformed
        try {
            rapna.reportesPDF();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuApodAscActionPerformed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel3MouseDragged

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        DialogApoderado apo = new DialogApoderado();
        apo.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JMenuItem RAlumApod;
    private javax.swing.JMenuItem RCurDoc;
    private javax.swing.JMenuItem RDocAlum;
    private javax.swing.JMenuItem RMatrCur;
    private javax.swing.JMenuItem RMatrProg;
    private javax.swing.JMenuItem RProgram;
    private javax.swing.JDesktopPane dpnEscritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator20;
    private javax.swing.JPopupMenu.Separator jSeparator21;
    private javax.swing.JPopupMenu.Separator jSeparator22;
    private javax.swing.JPopupMenu.Separator jSeparator23;
    private javax.swing.JPopupMenu.Separator jSeparator24;
    private javax.swing.JPopupMenu.Separator jSeparator26;
    private javax.swing.JPopupMenu.Separator jSeparator27;
    private javax.swing.JPopupMenu.Separator jSeparator28;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblRelog;
    public javax.swing.JLabel lblUsuario;
    public javax.swing.JLabel lblUsuario1;
    private javax.swing.JMenuItem menuAcercaDe;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JMenuItem mniRAlmunoOrdenNom;
    private javax.swing.JMenuItem mnuApodAsc;
    private javax.swing.JMenuItem mnuRDA;
    private javax.swing.JMenuItem mnuRDAPO;
    private javax.swing.JMenuItem mnuRDC;
    private javax.swing.JMenuItem mnuRDPRO;
    private javax.swing.JMenu mnuROrdenados;
    // End of variables declaration//GEN-END:variables
}
