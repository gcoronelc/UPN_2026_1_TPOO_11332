
package UI;

import UTIL.DbBean;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;

public class FrmInsumoPorPrecioUnitario extends javax.swing.JInternalFrame {

    public FrmInsumoPorPrecioUnitario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_desde_insumoxprecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_hasta_insumoxprecio = new javax.swing.JTextField();
        btn_producirReporte_insumoxprecio = new javax.swing.JButton();
        btn_salir_insumoxprecio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("REPORTE INSUMO POR PRECIO UNITARIO");

        jLabel2.setText("Desde");

        jLabel3.setText("Hasta");

        btn_producirReporte_insumoxprecio.setText("Producir Reporte");
        btn_producirReporte_insumoxprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_producirReporte_insumoxprecioActionPerformed(evt);
            }
        });

        btn_salir_insumoxprecio.setText("SALIR");
        btn_salir_insumoxprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_insumoxprecioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(txt_desde_insumoxprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel3)
                        .addGap(32, 32, 32)
                        .addComponent(txt_hasta_insumoxprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_producirReporte_insumoxprecio)
                            .addComponent(btn_salir_insumoxprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_desde_insumoxprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_hasta_insumoxprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_producirReporte_insumoxprecio))
                .addGap(33, 33, 33)
                .addComponent(btn_salir_insumoxprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salir_insumoxprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_insumoxprecioActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_insumoxprecioActionPerformed

    private void btn_producirReporte_insumoxprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_producirReporte_insumoxprecioActionPerformed
         Double d,a;
        d=Double.parseDouble(this.txt_desde_insumoxprecio.getText());
        a=Double.parseDouble(this.txt_hasta_insumoxprecio.getText());
        HashMap map = new HashMap();
        map.put("precioMin",d);
        map.put("precioMax",a);
        try{
            String r = "C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\REPORTES\\repInsumoPorPrecio.jasper";
            DbBean db = new DbBean();
            db.connectRep(r, map, true);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException ex){
            ex.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_btn_producirReporte_insumoxprecioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_producirReporte_insumoxprecio;
    private javax.swing.JButton btn_salir_insumoxprecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_desde_insumoxprecio;
    private javax.swing.JTextField txt_hasta_insumoxprecio;
    // End of variables declaration//GEN-END:variables
}
