
package UTIL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

public class DbBean {
    //credenciales para usar la funcion de envios de archivo por correo
    String emailFrom = "";
    String passwordFrom = "";
    
    private Connection dbCon;
    private String login = "sa";
    private String password = "123456789"; 
    String rutaCompletada;

    public DbBean() {
        this.conecta();
    }   

    public boolean conecta(){ //CONEXION A BASE DE DATOS POR DEFAULT
        
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=restaurante;encrypt=true;trustServerCertificate=true";
        String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        
        try{
            Class.forName(dbDriver);
        }catch(java.lang.ClassNotFoundException e){
            System.out.println("Error en clase");
            return false;
        }
        try{
            this.dbCon = DriverManager.getConnection(dbURL, login, this.password);
            
        }catch(SQLException ex){
            System.out.println("No hay conexion al servidor");
            return false;
        }
        return true;
    }
    
    public boolean conectaConBd(String nombreServidor){
        
        String dbURLConBD = "jdbc:sqlserver://"+nombreServidor+":1433;databaseName=restaurante;encrypt=true;trustServerCertificate=true";
        String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            try{
                Class.forName(dbDriver);
            }catch(java.lang.ClassNotFoundException e){
                System.out.println("Error en clase");
                return false;
            }
            try{
                this.dbCon = DriverManager.getConnection(dbURLConBD, this.login, this.password);

            }catch(SQLException ex){
                System.out.println("No hay conexion al servidor");
                return false;
            }
            return true;
    }
    
    public  boolean databaseExiste() {
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=restaurante;encrypt=true;trustServerCertificate=true";
        String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try (Connection connection = DriverManager.getConnection(dbURL, this.login, this.password)) {
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public void desconecta()throws SQLException{
        this.dbCon.close();
    }
    
       
    public ResultSet resultadoSQL(String sql)throws SQLException{
        Statement s = this.dbCon.createStatement();
        ResultSet r = s.executeQuery(sql);
        if(r==null){
            return null;
        }else{
            return r;
        }
    }
    public int ejecutaSQL(String sql)throws SQLException{
        Statement s = this.dbCon.createStatement();
        int r = s.executeUpdate(sql);
        if(r == 0){
            return 0;
        }else{
            return r;
        }
    }

    public void connectRep(String ruta, HashMap m, boolean sw)throws SQLException, JRException{
            conecta();
            JasperReport reporte = null;
            JasperPrint imp;
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            
            if(sw == false){
                imp = JasperFillManager.fillReport(reporte, null, dbCon);
            }else{
                imp = JasperFillManager.fillReport(reporte, m, dbCon);
            }
            JFrame frame = new JFrame("Reporte");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setUndecorated(true);
            frame.setLayout(new BorderLayout());
    
            JRViewer viewer = new JRViewer(imp);
            frame.add(viewer, BorderLayout.CENTER);
            
            
//Cerrar
            JButton closeButton = new JButton("Cerrar");
            closeButton.setForeground(Color.WHITE); 
            closeButton.setBackground(Color.DARK_GRAY);
            closeButton.setFont(new Font("Arial", Font.BOLD, 18));
   
    closeButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    });
        frame.add(closeButton, BorderLayout.SOUTH);
    
        
        
//Pdf
            JButton botoPdf = new JButton("PDF");
            botoPdf.setForeground(Color.WHITE); 
            botoPdf.setBackground(Color.DARK_GRAY);
            botoPdf.setFont(new Font("Arial", Font.BOLD, 18));
            
            
botoPdf.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        DbBean con = new DbBean();
        String ruta = System.getProperty("user.home");
        String nombreArchivo = "Reporte.pdf";
        String rutaCompleta = ruta + "/downloads/" + nombreArchivo;

        try {
            File archivo = new File(rutaCompleta);
            int contador = 1;

            while (archivo.exists()) {
                nombreArchivo = "Reporte(" + contador + ").pdf";
                rutaCompleta = ruta + "/downloads/" + nombreArchivo;
                rutaCompletada = rutaCompleta;
                archivo = new File(rutaCompleta);
                contador++;
            }

            // Generar el reporte en formato PDF y guardarlo en la ruta especificada
            JasperExportManager.exportReportToPdfFile(imp, rutaCompleta);

            JOptionPane.showMessageDialog(null, "El reporte se ha guardado correctamente en: DESCARGAS");

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Error al generar el reporte PDF: " + ex.getMessage());
        }
    }
});
            frame.add(botoPdf, BorderLayout.EAST);
    
    
 //Compartir  
            JButton botonGmail = new JButton("Gmail");
            botonGmail.setForeground(Color.WHITE); 
            botonGmail.setBackground(Color.DARK_GRAY);
            botonGmail.setFont(new Font("Arial", Font.BOLD, 18));
            
    botonGmail.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                // Crear una ventana de diálogo para ingresar la dirección de correo y los comentarios
                JFrame dialog = new JFrame("Enviar por correo electrónico");
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                dialog.setResizable(false);
                dialog.setLayout(new BorderLayout());
                dialog.setSize(400, 200);
                // Panel para los componentes
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(3, 3));

                // Etiqueta y campo de texto para la dirección de correo
                JLabel emailLabel = new JLabel("Correo:");
                JTextField emailField = new JTextField();
                panel.add(emailLabel);
                panel.add(emailField);
                
                JLabel subjectLabel = new JLabel("Asunto:");
                JTextField subjectField = new JTextField();
                panel.add(subjectLabel);
                panel.add(subjectField);

                // Etiqueta y campo de texto para los comentarios
                JLabel commentsLabel = new JLabel("Comentarios:");
                JTextField commentsField = new JTextField();
                panel.add(commentsLabel);
                panel.add(commentsField);

                // Botón de enviar
                JButton sendButton = new JButton("Enviar");
                sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Obtiene los valores de los campos de texto
                String emailTo = emailField.getText();
                String comments = commentsField.getText();
                String subject = subjectField.getText();
                // Configuración de las propiedades para la conexión SMTP
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");

                // Autenticación del remitente
                Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(emailFrom, passwordFrom);
                    }
                });

                try {
                    // Creación del mensaje de correo electrónico
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(emailFrom));
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));

                    message.setSubject(subject); 
                    // Crea la parte del mensaje que contendrá el texto y el archivo adjunto
                    MimeBodyPart messageBodyPart = new MimeBodyPart();
                    messageBodyPart.setText(comments);

                    // Crea la parte del mensaje que contendrá el archivo adjunto
                    Multipart multipart = new MimeMultipart();
                    multipart.addBodyPart(messageBodyPart);

                    // Adjunta el archivo de reporte PDF
                    
                    MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                    botoPdf.doClick();
                    attachmentBodyPart.attachFile(rutaCompletada);
                    multipart.addBodyPart(attachmentBodyPart);

                    // Establece las partes del mensaje
                    message.setContent(multipart);

                    // Envía el mensaje
                    Transport.send(message);

                    JOptionPane.showMessageDialog(null, "Correo Enviado...");

                    dialog.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al enviar el correo electrónico " );
                }
            }
                });

                // Agregar componentes al diálogo
                dialog.add(panel, BorderLayout.CENTER);
                dialog.add(sendButton, BorderLayout.SOUTH);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
        }
    });
            
            frame.add(botonGmail, BorderLayout.WEST);
    
            frame.setSize(800, 580);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
    }
}