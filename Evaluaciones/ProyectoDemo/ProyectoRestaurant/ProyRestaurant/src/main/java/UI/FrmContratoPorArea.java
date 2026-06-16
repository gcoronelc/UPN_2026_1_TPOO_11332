
package UI;

import BEAN.Area;
import DAO.AreaDao;
import UTIL.DbBean;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import net.sf.jasperreports.engine.JRException;

public class FrmContratoPorArea extends javax.swing.JInternalFrame{
    AreaDao areaDao = new AreaDao();
    public FrmContratoPorArea() {
        initComponents();
        this.llenaCmbArea();
    }
    private void llenaCmbArea(){
        
        Vector<Area> listaArea = new Vector<Area>();
        listaArea = this.areaDao.llenaArea();
        this.cmb_area.addItem("");
        
        for(int i=0;i<listaArea.size();i++){
        
            this.cmb_area.addItem(listaArea.get(i).getDescripArea());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmb_area = new javax.swing.JComboBox<>();
        btn_reporte_area = new javax.swing.JButton();
        btn_salir_area = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("REPORTE POR AREA");

        jLabel2.setText("AREA");

        cmb_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_areaActionPerformed(evt);
            }
        });

        btn_reporte_area.setText("Producir Reporte");
        btn_reporte_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reporte_areaActionPerformed(evt);
            }
        });

        btn_salir_area.setText("SALIR");
        btn_salir_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_areaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41)
                        .addComponent(cmb_area, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_salir_area, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_reporte_area, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmb_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reporte_area))
                .addGap(57, 57, 57)
                .addComponent(btn_salir_area, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salir_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_areaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_areaActionPerformed

    private void btn_reporte_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reporte_areaActionPerformed
        String seleccionArea;
        
        seleccionArea = this.cmb_area.getSelectedItem().toString();
        
        HashMap map = new HashMap();
        
        map.put("DESCRIPCIONAREA", seleccionArea);
        
        try{
        
            String r = "C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\REPORTES\\repContratoPorArea.jasper";
            DbBean db = new DbBean();
            db.connectRep(r, map, true);
        }catch(SQLException e){
        
            e.printStackTrace();
        }catch(JRException ex){
        
            ex.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_btn_reporte_areaActionPerformed

    private void cmb_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_areaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reporte_area;
    private javax.swing.JButton btn_salir_area;
    private javax.swing.JComboBox<String> cmb_area;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
