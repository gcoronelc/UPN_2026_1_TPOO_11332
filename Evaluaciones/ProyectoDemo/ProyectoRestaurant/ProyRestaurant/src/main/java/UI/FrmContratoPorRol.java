
package UI;

import BEAN.Rol;
import DAO.RolDao;
import UTIL.DbBean;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import net.sf.jasperreports.engine.JRException;

public class FrmContratoPorRol extends javax.swing.JInternalFrame {
    RolDao rolDao = new RolDao();
    public FrmContratoPorRol() {
        initComponents();
        this.llenaCmbRol();
    }
    private void llenaCmbRol(){
    
        Vector<Rol> listaRol = new Vector<Rol>();
        
        this.cmb_rol_contratoxrol.addItem("");
        listaRol = rolDao.llenaRol();
        
        for(int i=0; i<listaRol.size();i++){
        
            this.cmb_rol_contratoxrol.addItem(listaRol.get(i).getDescripRol());
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmb_rol_contratoxrol = new javax.swing.JComboBox<>();
        btn_producirReporte_contratoxrol = new javax.swing.JButton();
        btn_salir_contratoxrol = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("REPORTE CONTRATO POR ROL");

        jLabel2.setText("Rol");

        btn_producirReporte_contratoxrol.setText("Producir Reporte");
        btn_producirReporte_contratoxrol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_producirReporte_contratoxrolActionPerformed(evt);
            }
        });

        btn_salir_contratoxrol.setText("SALIR");
        btn_salir_contratoxrol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_contratoxrolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmb_rol_contratoxrol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_producirReporte_contratoxrol, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(273, 273, 273))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_salir_contratoxrol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmb_rol_contratoxrol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btn_producirReporte_contratoxrol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btn_salir_contratoxrol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salir_contratoxrolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_contratoxrolActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_contratoxrolActionPerformed

    private void btn_producirReporte_contratoxrolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_producirReporte_contratoxrolActionPerformed
        String seleccionRol;
        
        seleccionRol = this.cmb_rol_contratoxrol.getSelectedItem().toString();
        
        HashMap map = new HashMap();
        
        map.put("DESCRIPCION", seleccionRol);
        
        try{
        
            String r = "C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\REPORTES\\repContratoPorRol.jasper";
            DbBean db = new DbBean();
            db.connectRep(r, map, true);
        }catch(SQLException e){
        
            e.printStackTrace();
        }catch(JRException ex){
        
            ex.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_btn_producirReporte_contratoxrolActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_producirReporte_contratoxrol;
    private javax.swing.JButton btn_salir_contratoxrol;
    private javax.swing.JComboBox<String> cmb_rol_contratoxrol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
