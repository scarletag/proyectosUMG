/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.director;
import controladores.Conexion;
import modelos.*; 
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author GBorisHP
 */
public class Asignaciones extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    /**
     * Creates new form Asignaciones
     */
    public Asignaciones() {
        initComponents();
        llenarCiclo();
        llenarAlumnos();
        llenarCurso();
        llenarJornada();
        llenarHorario();
        llenarSecciones();
        llenarGrados();
    }
    void llenarCiclo(){
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM ciclo_escolar");
            rs = ps.executeQuery();
            while(rs.next()){
                c_cicloEscolar.addItem(rs.getString("ciclo_escolar"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    void llenarAlumnos(){
                try {
            con = Conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM usuarios WHERE roles_idroles = 2");
            rs = ps.executeQuery();
            while(rs.next()){
                c_usuario.addItem(rs.getString("usuario"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    void llenarCurso(){
            try {
            con = Conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM cursoS");
            rs = ps.executeQuery();
            while(rs.next()){
                c_curso.addItem(rs.getString("nombre_curso"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }        
    }
    void llenarJornada(){
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM jornadas");
            rs = ps.executeQuery();
            while(rs.next()){
                c_jornada.addItem(rs.getString("tipo_jornada"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
    }
    void llenarHorario(){
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM horarios");
            rs = ps.executeQuery();
            while(rs.next()){
                c_horario.addItem(rs.getString("horario"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
    }
    void llenarSecciones(){
         try {
            con = Conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM secciones");
            rs = ps.executeQuery();
            while(rs.next()){
                c_seccion.addItem(rs.getString("nombre_seccion"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
    }
    void llenarGrados(){
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM grados");
            rs = ps.executeQuery();
            while(rs.next()){
                c_grado.addItem(rs.getString("nombre_grado"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
    }
    String getIdByNameCurso(String name){
        boolean encontrado = false;
        String idCurso = "";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM cursos WHERE nombre_curso = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            if(rs.next()){
                idCurso = rs.getString("idcurso");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return idCurso;
    }
    int getIdByNameHorario(String name){
        boolean encontrado = false;
        int idHorario = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM horarios WHERE horario = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            if(rs.next()){
                idHorario = rs.getInt("idhorarios");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return idHorario;
    }
    int getIdByNameJornada(String name){
        boolean encontrado = false;
        int idJornada = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM jornadas WHERE tipo_jornada = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            if(rs.next()){
                idJornada = rs.getInt("idjornadas");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return idJornada;
    }
    int getIdByNameSeccion(String name){
        boolean encontrado = false;
        int idSeccion = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM secciones WHERE nombre_seccion = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            if(rs.next()){
                idSeccion = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return idSeccion;
    }
    int getIdByNameGrado(String name){
        boolean encontrado = false;
        int idGrado = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM grados WHERE nombre_grado = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            if(rs.next()){
                idGrado = rs.getInt("idsecciones");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return idGrado;
    }
    int getIdByNameCiclo(String name){
        boolean encontrado = false;
        int idCiclo = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM grados WHERE nombre_grado = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            if(rs.next()){
                idCiclo = rs.getInt("idsecciones");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return idCiclo;
    }
    void generarAsignacion(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int respuesta = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement("INSERT INTO asignaciones VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, getIdByNameCurso(((String) c_curso.getSelectedItem())));
            ps.setInt(2, getIdByNameHorario((String) c_horario.getSelectedItem()));
            ps.setInt(3, getIdByNameJornada((String) c_jornada.getSelectedItem()));
            ps.setInt(4, getIdByNameSeccion((String) c_seccion.getSelectedItem()));
            ps.setInt(5, getIdByNameGrado((String) c_grado.getSelectedItem()));
            ps.setInt(6, getIdByNameCiclo((String) c_cicloEscolar.getSelectedItem()));
            ps.setString(7, (String) c_usuario.getSelectedItem());
            respuesta = ps.executeUpdate();
            if(respuesta != 0){
                JOptionPane.showMessageDialog(null, "Error al generar la asginacion");
                con.close();
                return;
            }
            JOptionPane.showMessageDialog(null, "Curso asignado correctamene");
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        c_cicloEscolar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        c_usuario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        c_curso = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        c_jornada = new javax.swing.JComboBox<>();
        c_horario = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        c_seccion = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        c_grado = new javax.swing.JComboBox<>();
        menu_dire = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CICLO ESCOLAR: ");

        jLabel2.setText("ASIGNACIONES:");

        jLabel3.setText("USUARIO DE ALUMNO:");

        jLabel4.setText("CURSO A ASIGNAR:");

        jLabel5.setText("JORNADA:");

        jLabel6.setText("HORARIO DE CURSO:");

        jLabel7.setText("SECCION:");

        jButton1.setText("ASIGNAR CURSO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("GRADO:");

        menu_dire.setText("IR A MENU");
        menu_dire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_direActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_usuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_cicloEscolar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_seccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c_horario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c_curso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c_jornada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c_grado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(menu_dire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(76, 76, 76))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_cicloEscolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(c_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_grado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(8, 8, 8)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(c_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(c_jornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu_dire))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_seccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generarAsignacion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void menu_direActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_direActionPerformed
        menu_director director = new menu_director();
        director.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_direActionPerformed

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
            java.util.logging.Logger.getLogger(Asignaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asignaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asignaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asignaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asignaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> c_cicloEscolar;
    private javax.swing.JComboBox<String> c_curso;
    private javax.swing.JComboBox<String> c_grado;
    private javax.swing.JComboBox<String> c_horario;
    private javax.swing.JComboBox<String> c_jornada;
    private javax.swing.JComboBox<String> c_seccion;
    private javax.swing.JComboBox<String> c_usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton menu_dire;
    // End of variables declaration//GEN-END:variables
}
