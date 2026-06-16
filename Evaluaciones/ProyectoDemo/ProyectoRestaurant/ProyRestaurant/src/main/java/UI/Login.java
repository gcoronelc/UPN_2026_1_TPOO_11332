
package UI;

import BEAN.Usuario;
import DAO.UsuarioDao;
import UTIL.DbBean;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    UsuarioDao usuarioDao = new UsuarioDao();
    DbBean con = new DbBean();
    Usuario user = new Usuario();
    private boolean mostrarContraseña = false;
    public Login() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.txt_pass_login.setEchoChar('*');
        this.btn_ojito.setFocusable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_id_local_login = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_usuario_login = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_entrar_login = new javax.swing.JButton();
        btn_salir_login = new javax.swing.JButton();
        txt_pass_login = new javax.swing.JPasswordField();
        btn_limpiar_login = new javax.swing.JButton();
        btn_ojito = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("VERIFICACION DE USUARIO");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID LOCAL");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("USUARIO");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CONTRASEÑA");

        btn_entrar_login.setText("ENTRAR");
        btn_entrar_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrar_loginActionPerformed(evt);
            }
        });

        btn_salir_login.setText("SALIR");
        btn_salir_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_loginActionPerformed(evt);
            }
        });

        txt_pass_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pass_loginActionPerformed(evt);
            }
        });

        btn_limpiar_login.setText("Limpiar");
        btn_limpiar_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_loginActionPerformed(evt);
            }
        });

        btn_ojito.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\ojito.png")); // NOI18N
        btn_ojito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ojitoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(btn_entrar_login, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_limpiar_login, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_id_local_login, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txt_usuario_login)
                                .addComponent(txt_pass_login)))))
                .addGap(18, 18, 18)
                .addComponent(btn_ojito, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_salir_login, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_salir_login, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_entrar_login, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_limpiar_login, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_id_local_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_usuario_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txt_pass_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_ojito, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));

        lbl_logo.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\simbolo.jpg")); // NOI18N
        lbl_logo.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbl_logo)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lbl_logo)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean valida(){
        String pass = new String(this.txt_pass_login.getPassword());
        if(pass.isEmpty() || this.txt_id_local_login.getText().isEmpty() || this.txt_usuario_login.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Faltan Datos");
            return false;
        }
        return true;
    }
    
    private void limpiar(){
        this.txt_id_local_login.setText("");
        this.txt_pass_login.setText("");
        this.txt_usuario_login.setText("");
    } 
    
    private void btn_salir_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_loginActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_loginActionPerformed

    private void txt_pass_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pass_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pass_loginActionPerformed

    private void btn_limpiar_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_loginActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btn_limpiar_loginActionPerformed

    private void btn_entrar_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrar_loginActionPerformed
           if(valida() == true){
                String Pass = new String(this.txt_pass_login.getPassword());
                if(usuarioDao.consultaLogin(this.txt_usuario_login.getText(), Pass, this.txt_id_local_login.getText())){
                    
                    if(usuarioDao.confirmaUsuario(this.txt_usuario_login.getText(), Pass, this.txt_id_local_login.getText()) ==1){
                        //admin
                        int n=1;
                        MdiEscritorio mdi = new MdiEscritorio(n);
                        mdi.setVisible(true);
                        dispose();                         
                    }else if (usuarioDao.confirmaUsuario(this.txt_usuario_login.getText(), Pass, this.txt_id_local_login.getText()) ==2){
                        //mantenimiento
                        int n=2;
                        MdiEscritorio mdi = new MdiEscritorio(n);
                        mdi.setVisible(true);
                        dispose(); 
                    }else if(usuarioDao.confirmaUsuario(this.txt_usuario_login.getText(), Pass, this.txt_id_local_login.getText()) ==3){
                        //reportes
                        int n=3;
                        MdiEscritorio mdi = new MdiEscritorio(n);
                        mdi.setVisible(true);
                        dispose(); 
                    }else{
                        //transacciones
                        int n=4;
                        MdiEscritorio mdi = new MdiEscritorio(n);
                        mdi.setVisible(true);
                        dispose(); 
                    }
                    
                }  
            } 
    }//GEN-LAST:event_btn_entrar_loginActionPerformed

    private void btn_ojitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ojitoActionPerformed
        mostrarContraseña = !mostrarContraseña;

        if (mostrarContraseña) {
            this.txt_pass_login.setEchoChar((char) 0); // Muestra la contraseña

            // Cargar imagen desde el sistema de archivos
            ImageIcon icono = new ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\ojo_libre.png");
            Image img = icono.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            this.btn_ojito.setIcon(new ImageIcon(img));

        } else {
            this.txt_pass_login.setEchoChar('*'); // Oculta la contraseña

            // Cargar imagen desde el sistema de archivos
            ImageIcon icono = new ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\ojito.png");
            Image img = icono.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            this.btn_ojito.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_btn_ojitoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrar_login;
    private javax.swing.JButton btn_limpiar_login;
    private javax.swing.JButton btn_ojito;
    private javax.swing.JButton btn_salir_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JTextField txt_id_local_login;
    private javax.swing.JPasswordField txt_pass_login;
    private javax.swing.JTextField txt_usuario_login;
    // End of variables declaration//GEN-END:variables
}
