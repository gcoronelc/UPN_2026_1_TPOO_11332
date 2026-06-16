
package UI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Compartir extends javax.swing.JInternalFrame {
    
    // credenciales para envio de archivos y mensajes por correo
    private static String emailFrom = "";
    private static String passwordFrom = "";
    
    private String paraEmail;
    private String asunto;
    private String contenido;

    private Properties mProperties;
    private Session mSesion;
    private MimeMessage mCorreo;

    private List<File> mArchivoAdjuntos;
    private String nombresArchivos = "";
    public Compartir() {
        initComponents();
        mProperties = new Properties();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mArchivoAdjuntos = new ArrayList<>();
    }
    private void crearEmail() throws AddressException, MessagingException {

        paraEmail = this.txt_email_compartir.getText().trim();
        asunto = this.txt_asunto_compartir.getText().trim();
        contenido = this.area_comentarios_compartir.getText().trim();

        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSesion = Session.getDefaultInstance(mProperties);

        MimeMultipart mElementosCorreo = new MimeMultipart();

        MimeBodyPart mContenido = new MimeBodyPart();
        mContenido.setContent(contenido, "text/html; charset=utf-8");
        mElementosCorreo.addBodyPart(mContenido);

        MimeBodyPart mAdjuntos;
        for (File archivo : mArchivoAdjuntos) {
            mAdjuntos = new MimeBodyPart();
            mAdjuntos.setDataHandler(new DataHandler(new FileDataSource(archivo.getAbsolutePath())));
            mAdjuntos.setFileName(archivo.getName());
            mElementosCorreo.addBodyPart(mAdjuntos);
        }

        mCorreo = new MimeMessage(mSesion);
        mCorreo.setFrom(new InternetAddress(emailFrom));
        mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(paraEmail));
        mCorreo.setSubject(asunto);
        mCorreo.setContent(mElementosCorreo);
    }
    private void enviarEmail() throws NoSuchProviderException, MessagingException {

        Transport mTransport = mSesion.getTransport("smtp");
        mTransport.connect(emailFrom, passwordFrom);
        mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
        mTransport.close();

        JOptionPane.showMessageDialog(this, "Correo Enviado...");
        this.lbl_archivos_adjuntos_compartir.setText("");
        nombresArchivos = "";

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_email_compartir = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_asunto_compartir = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_comentarios_compartir = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        lbl_archivos_adjuntos_compartir = new javax.swing.JLabel();
        btn_compartir = new javax.swing.JButton();
        btn_agrega_archivos_compartir = new javax.swing.JButton();
        btn_eliminar_compartir = new javax.swing.JButton();
        btn_salir_compartir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("COMPARTIR");

        jLabel2.setText("EMAIL: ");

        jLabel3.setText("ASUNTO:");

        jLabel4.setText("COMENTARIOS:");

        area_comentarios_compartir.setColumns(20);
        area_comentarios_compartir.setRows(5);
        jScrollPane1.setViewportView(area_comentarios_compartir);

        jLabel5.setText("ARCHIVOS ADJUNTOS:");

        lbl_archivos_adjuntos_compartir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_compartir.setText("COMPARTIR");
        btn_compartir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_compartirActionPerformed(evt);
            }
        });

        btn_agrega_archivos_compartir.setText("AGREGAR ARCHIVOS");
        btn_agrega_archivos_compartir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agrega_archivos_compartirActionPerformed(evt);
            }
        });

        btn_eliminar_compartir.setText("ELIMINAR");
        btn_eliminar_compartir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_compartirActionPerformed(evt);
            }
        });

        btn_salir_compartir.setText("SALIR");
        btn_salir_compartir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_compartirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_compartir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_agrega_archivos_compartir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar_compartir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addComponent(jLabel5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addComponent(lbl_archivos_adjuntos_compartir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(txt_asunto_compartir, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(jLabel2)
                            .addGap(40, 40, 40)
                            .addComponent(txt_email_compartir, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(214, 214, 214))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_salir_compartir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_email_compartir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_asunto_compartir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lbl_archivos_adjuntos_compartir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_compartir)
                    .addComponent(btn_agrega_archivos_compartir)
                    .addComponent(btn_eliminar_compartir))
                .addGap(18, 18, 18)
                .addComponent(btn_salir_compartir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salir_compartirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_compartirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_compartirActionPerformed

    private void btn_compartirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_compartirActionPerformed
        try {
            crearEmail();
        } catch (MessagingException ex) {
            java.util.logging.Logger.getLogger(Compartir.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            enviarEmail();
        } catch (MessagingException ex) {
            java.util.logging.Logger.getLogger(Compartir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_compartirActionPerformed

    private void btn_agrega_archivos_compartirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agrega_archivos_compartirActionPerformed
        JFileChooser elejir = new JFileChooser();

        elejir.setMultiSelectionEnabled(true);
        elejir.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (elejir.showOpenDialog(this) != JFileChooser.CANCEL_OPTION) {
            File[] archivosSeleccionados = elejir.getSelectedFiles();
            for (File archivo : archivosSeleccionados) {
                mArchivoAdjuntos.add(archivo);
                nombresArchivos += archivo.getName() + "<br>";
            }
            this.lbl_archivos_adjuntos_compartir.setText("<html><p>" + nombresArchivos + "</p></html>");
        }
    }//GEN-LAST:event_btn_agrega_archivos_compartirActionPerformed

    private void btn_eliminar_compartirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_compartirActionPerformed
        if (!mArchivoAdjuntos.isEmpty()) {
            mArchivoAdjuntos.remove(mArchivoAdjuntos.size() - 1);
            nombresArchivos = "";

            for (File archivo : mArchivoAdjuntos) {
                nombresArchivos += archivo.getName() + "<br>";
            }

            this.lbl_archivos_adjuntos_compartir.setText("<html><p>" + nombresArchivos + "</p></html>");
        } else {

            JOptionPane.showMessageDialog(null, "No se puede eliminar...");
        }
    }//GEN-LAST:event_btn_eliminar_compartirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_comentarios_compartir;
    private javax.swing.JButton btn_agrega_archivos_compartir;
    private javax.swing.JButton btn_compartir;
    private javax.swing.JButton btn_eliminar_compartir;
    private javax.swing.JButton btn_salir_compartir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_archivos_adjuntos_compartir;
    private javax.swing.JTextField txt_asunto_compartir;
    private javax.swing.JTextField txt_email_compartir;
    // End of variables declaration//GEN-END:variables
}
