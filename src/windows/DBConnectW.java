/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.*;
import java.lang.*;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.ImageIcon;
import sb_jtorres.DBConnect; //Importa la clase de otro paquete en el mismo proyecto.
import sb_jtorres.WinRegistry;

/**
 *
 * @author FaNaTiKoRn
 */

public class DBConnectW extends javax.swing.JFrame {

    private static String OS = System.getProperty("os.name");
    private static String OSArch = System.getProperty("os.arch").toLowerCase();
    private static String OSVersion = System.getProperty("os.version").toLowerCase();
    public boolean SesentaY4 = false;
    public String base = null;

    /**
     * Creates new form DBConnectW
     */
    public DBConnectW() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../img/tr.png")).getImage()); //Carga ícono de la Aplicación
        String edicion = null;
        try {
            edicion = WinRegistry.readString (
                    WinRegistry.HKEY_LOCAL_MACHINE,                             //HKEY
                    "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion",           //Key
                    "ProductName"); //ValueName
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DBConnectW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBConnectW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DBConnectW.class.getName()).log(Level.SEVERE, null, ex);
        }
        labelVersion.setText(labelVersion.getText() + OSVersion); // Informa la versión por medio de un Label
        labelOS.setText(labelOS.getText() + edicion); // Informa la edición por medio de un Label
        //A continuación se define la Arch y se informa al User por medio de labelArch
        if("amd64".equals(OSArch)) //No funciona con == porque se compara un Objeto (almacenado como heap). Sólo funcionará con == si se compara elementos de un Stack (tipos básicos)
        {                           // Stack (==) Vs. Heap (String.equals(object))...
            labelArch.setText(labelArch.getText() + "64-bit");
            SesentaY4 = true;
        }
        /*else
        {
            labelArch.setText(labelArch.getText() + "32-bit");
            SesentaY4 = false;
        }*/
                String regKey = null;
        if(SesentaY4)
        {
            regKey = "SOFTWARE\\Wow6432Node\\Sistemas Bejerman";
        }
        else
        {
            regKey = "SOFTWARE\\Sistemas Bejerman";
        }

        String regServer = null;
        String regManager = null;
        String regUpdates = null;
        String regBases = null;
        
        try {
            regServer = WinRegistry.readString (
                    WinRegistry.HKEY_LOCAL_MACHINE,                             //HKEY
                    regKey, //Key
                    "Server ODBC"); //ValueName
            regManager = WinRegistry.readString (
                    WinRegistry.HKEY_LOCAL_MACHINE,                             //HKEY
                    regKey, //Key
                    "Nombre de la base de datos 'Manager' - SQL"); //ValueName
            regUpdates = WinRegistry.readString (
                    WinRegistry.HKEY_LOCAL_MACHINE,                             //HKEY
                    regKey, //Key
                    "Ruta Instalador"); //ValueName
            regBases = WinRegistry.readString (
                    WinRegistry.HKEY_LOCAL_MACHINE,                             //HKEY
                    regKey, //Key
                    "Ruta UNC al Servidor - SQL"); //ValueName                    
                    
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DBConnectW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBConnectW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DBConnectW.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("URL Server = " + regServer);
        System.out.println("URL Manager = " + regManager);
        System.out.println("URL Updates = " + regUpdates);
        System.out.println("URL Bases = " + regBases);
        //System.out.println("Version: " + OSVersion);
        //System.out.println("Aquitectura: " + OSArch);
        this.setLocationRelativeTo(null); //Centra la ventana
    }
    
    static int contador = 0;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainWindows = new javax.swing.JFrame();
        grupoLogin = new javax.swing.ButtonGroup();
        grupoServidores = new javax.swing.ButtonGroup();
        conectar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        estado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        queryInput = new javax.swing.JTextArea();
        iconEstado = new javax.swing.JLabel();
        labelServer = new javax.swing.JLabel();
        campoServer = new javax.swing.JTextField();
        labelDB = new javax.swing.JLabel();
        campoDB = new javax.swing.JTextField();
        opcionBejerman = new javax.swing.JRadioButton();
        opcionSQL = new javax.swing.JRadioButton();
        labelUser = new javax.swing.JLabel();
        campoUser = new javax.swing.JTextField();
        labelPass = new javax.swing.JLabel();
        campoPass = new javax.swing.JPasswordField();
        checkVerPass = new javax.swing.JCheckBox();
        opcionMySQL = new javax.swing.JRadioButton();
        opcionSQLServer = new javax.swing.JRadioButton();
        labelArch = new javax.swing.JLabel();
        labelOS = new javax.swing.JLabel();
        labelVersion = new javax.swing.JLabel();

        mainWindows.setTitle("Conexión a la Base de Datos");
        mainWindows.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainWindows.setResizable(false);

        javax.swing.GroupLayout mainWindowsLayout = new javax.swing.GroupLayout(mainWindows.getContentPane());
        mainWindows.getContentPane().setLayout(mainWindowsLayout);
        mainWindowsLayout.setHorizontalGroup(
            mainWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        mainWindowsLayout.setVerticalGroup(
            mainWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conexión a la Base de Datos");
        setFocusable(false);
        setName("ventana"); // NOI18N

        conectar.setText("Conectar");
        conectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conectarMouseClicked(evt);
            }
        });
        conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        estado.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        estado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estado.setText("Desconectado");
        estado.setToolTipText("Estado de la conexión.");

        queryInput.setColumns(20);
        queryInput.setRows(5);
        jScrollPane1.setViewportView(queryInput);

        iconEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/green_33x33.png"))); // NOI18N
        iconEstado.setToolTipText("Estado Desconectado");
        iconEstado.setEnabled(false);
        iconEstado.setMaximumSize(new java.awt.Dimension(10, 10));
        iconEstado.setMinimumSize(new java.awt.Dimension(10, 10));
        iconEstado.setPreferredSize(new java.awt.Dimension(25, 25));

        labelServer.setText("Servidor:");
        labelServer.setToolTipText("Ingrese la URL del servidor");

        labelDB.setText("Base de Datos:");
        labelDB.setToolTipText("Nombre de la Base de Datos a conectar");

        grupoLogin.add(opcionBejerman);
        opcionBejerman.setSelected(true);
        opcionBejerman.setText("Login con usuario 'bejerman'");
        opcionBejerman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionBejermanActionPerformed(evt);
            }
        });
        opcionBejerman.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                opcionBejermanPropertyChange(evt);
            }
        });

        grupoLogin.add(opcionSQL);
        opcionSQL.setText("Autenticación SQL");
        opcionSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionSQLActionPerformed(evt);
            }
        });

        labelUser.setText("Usuario:");
        labelUser.setEnabled(false);
        labelUser.setFocusable(false);

        campoUser.setEnabled(false);

        labelPass.setText("Contraseña:");
        labelPass.setEnabled(false);
        labelPass.setFocusable(false);

        campoPass.setColumns(12);
        campoPass.setEnabled(false);

        checkVerPass.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        checkVerPass.setText("Visualizar la Clave");
        checkVerPass.setEnabled(false);
        checkVerPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkVerPassActionPerformed(evt);
            }
        });

        grupoServidores.add(opcionMySQL);
        opcionMySQL.setText("MySQL");

        grupoServidores.add(opcionSQLServer);
        opcionSQLServer.setSelected(true);
        opcionSQLServer.setText("SQL Server.");

        labelArch.setText("Arquitectura: ");

        labelOS.setText("OS: ");

        labelVersion.setText("Versión: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelPass))
                            .addComponent(labelOS)
                            .addComponent(labelArch)
                            .addComponent(labelVersion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoPass, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkVerPass)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opcionBejerman)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(opcionSQL))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addComponent(conectar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(iconEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(336, 336, 336)
                                    .addComponent(salir))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(labelServer)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoServer, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(labelDB)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoDB)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(opcionSQLServer)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(opcionMySQL))))))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(estado)
                .addGap(0, 386, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelServer)
                    .addComponent(campoServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionSQLServer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDB)
                    .addComponent(campoDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionMySQL))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(opcionBejerman)
                            .addComponent(opcionSQL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelUser)
                            .addComponent(campoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPass)
                            .addComponent(campoPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkVerPass)
                        .addGap(6, 6, 6)
                        .addComponent(labelOS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelVersion)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(conectar)
                            .addComponent(labelArch))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(iconEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estado))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salir))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarActionPerformed
        // TODO add your handling code here:
        //Icon icono;
        DBConnect conectando = new DBConnect(); ///Crea el objeto de la clase DBConnect que permite conectar a la Base de Datos.
        iconEstado.setEnabled(rootPaneCheckingEnabled);
        String conectado = "C:\\green_33x33.png";
        String desconectado = "C:\\red_33x33.png";
        //Icon conectado = new javax.swing.ImageIcon(conectado);
            
        if( "Desconectado".equals(estado.getText()))
        {
            try {
                base = conectando.Conectar();
                estado.setText("Conectado");          
                iconEstado.setIcon(new javax.swing.ImageIcon(conectado));
                conectar.setText("Desconectar");
                labelServer.setEnabled(false);
                labelDB.setEnabled(false);
                campoServer.setEnabled(false);
                campoDB.setEnabled(false);
                opcionBejerman.setEnabled(false);
                opcionSQL.setEnabled(false);
                campoUser.setEnabled(false);
                campoPass.setEnabled(false);
                opcionMySQL.setEnabled(false);
                opcionSQLServer.setEnabled(false);
                this.setTitle("Conectado a '" + base.toUpperCase() + "'");
                System.out.println(base.toUpperCase());
                
                /* //Toma imagen de Directorio y la establece como ICON de un LABEL.
                ImageIcon iconConn = new ImageIcon(conectado);
                iconConn.getImage().flush();
                iconEstado.setIcon( iconConn );
                */
                
                //icono = ImageIcon(getClass().getResource());
                //icono = ImageIcon("/img/red_33x33.png");
                //iconEstado.setIcon(icono);
                //iconEstado.setIcon(new ImageIcon(getClass().getResource("../img/tr.png")).getImage());
                //iconEstado.setIcon(getClass().getResource("../img/tr.png")).getImage();
                //iconEstado.setIcon(new ImageIcon(ImageIO.read(new File(conectado))));
                //Image icono = new javax.swing.ImageIcon(getClass().getResource("red_33x33.png")).getImage();
                //iconEstado.setIcon((Icon) icono);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DBConnectW.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            estado.setText("Desconectado");            
            iconEstado.setIcon(new javax.swing.ImageIcon(desconectado));
            conectar.setText("Conectar");
            labelServer.setEnabled(true);
            labelDB.setEnabled(true);
            campoServer.setEnabled(true);
            campoDB.setEnabled(true);
            opcionBejerman.setEnabled(true);
            opcionSQL.setEnabled(true);
            campoUser.setEnabled(true);
            campoPass.setEnabled(true);
            opcionMySQL.setEnabled(true);
            opcionSQLServer.setEnabled(true);
            this.setTitle("Conexión a la Base de Datos");
            /*
            ImageIcon iconDeconn = new ImageIcon(desconectado);
            iconDeconn.getImage().flush();
            iconEstado.setIcon( iconDeconn );
            */
        }
        
    }//GEN-LAST:event_conectarActionPerformed

    private void conectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conectarMouseClicked
        // TODO add your handling code here:
        //DBConnect conn = new DBConnect();
        //conn.Conectar();
    }//GEN-LAST:event_conectarMouseClicked

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_salirMouseClicked

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        dispose();
        //System.exit(0); // Cerrar el sistema.
    }//GEN-LAST:event_salirActionPerformed

    private void opcionBejermanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionBejermanActionPerformed
        // TODO add your handling code here:
            campoUser.setEnabled(false);
            campoPass.setEnabled(false);
            labelUser.setEnabled(false);
            labelPass.setEnabled(false);
            checkVerPass.setEnabled(false);
    }//GEN-LAST:event_opcionBejermanActionPerformed

    private void opcionBejermanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_opcionBejermanPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_opcionBejermanPropertyChange

    private void opcionSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionSQLActionPerformed
        // TODO add your handling code here:
            campoUser.setEnabled(true);
            campoPass.setEnabled(true);
            labelUser.setEnabled(true);
            labelPass.setEnabled(true);
            checkVerPass.setEnabled(true);
    }//GEN-LAST:event_opcionSQLActionPerformed

    private void checkVerPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkVerPassActionPerformed
        // TODO add your handling code here:
        if(checkVerPass.isSelected())
        {
            campoPass.setEchoChar((char)0);
        }
        else
        {
            campoPass.setEchoChar('*');
        }
    }//GEN-LAST:event_checkVerPassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
         /*Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(DBConnectW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DBConnectW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DBConnectW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DBConnectW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DBConnectW().setVisible(true);
            }
        });        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoDB;
    private javax.swing.JPasswordField campoPass;
    private javax.swing.JTextField campoServer;
    private javax.swing.JTextField campoUser;
    private javax.swing.JCheckBox checkVerPass;
    public javax.swing.JButton conectar;
    public javax.swing.JLabel estado;
    private javax.swing.ButtonGroup grupoLogin;
    private javax.swing.ButtonGroup grupoServidores;
    public javax.swing.JLabel iconEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelArch;
    private javax.swing.JLabel labelDB;
    private javax.swing.JLabel labelOS;
    private javax.swing.JLabel labelPass;
    private javax.swing.JLabel labelServer;
    private javax.swing.JLabel labelUser;
    private javax.swing.JLabel labelVersion;
    public javax.swing.JFrame mainWindows;
    private javax.swing.JRadioButton opcionBejerman;
    private javax.swing.JRadioButton opcionMySQL;
    private javax.swing.JRadioButton opcionSQL;
    private javax.swing.JRadioButton opcionSQLServer;
    private javax.swing.JTextArea queryInput;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables

   /* private Icon ImageIcon(URL resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
}
