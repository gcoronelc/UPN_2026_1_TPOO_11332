
package UI;

import UTIL.DbBean;
import javax.swing.JOptionPane;

public class Entrada extends javax.swing.JFrame {

    DbBean bd = new DbBean();
    public Entrada() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_fondo_entrada = new javax.swing.JLabel();
        btn_entrar_entrada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_fondo_entrada.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\restaurant.jpg")); // NOI18N
        lbl_fondo_entrada.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_entrar_entrada.setText("ENTRAR");
        btn_entrar_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrar_entradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_fondo_entrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(btn_entrar_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_fondo_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_entrar_entrada)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void validaConexion(){
    
        if (bd.databaseExiste() == true){
            Login login = new Login();
            
            JOptionPane.showMessageDialog(null, "Conexión Exitosa...");
            login.setVisible(true);
            this.dispose();
        }else{
            LoginDefecto log = new LoginDefecto();
            JOptionPane.showMessageDialog(null,"NO EXISTE LA BD NECESARIA..." );
            JOptionPane.showMessageDialog(null,"INGRESE DATOS PARA GENERAR LA BD..." );
            
            log.setVisible(true); 
            this.dispose();
        }
    }
    
    private void btn_entrar_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrar_entradaActionPerformed
        this.validaConexion();
    }//GEN-LAST:event_btn_entrar_entradaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrar_entrada;
    private javax.swing.JLabel lbl_fondo_entrada;
    // End of variables declaration//GEN-END:variables
}
