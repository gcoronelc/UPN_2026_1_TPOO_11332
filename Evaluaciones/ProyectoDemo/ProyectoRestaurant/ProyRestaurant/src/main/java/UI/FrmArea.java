
package UI;

import BEAN.Area;
import DAO.AreaDao;
import UTIL.Util;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmArea extends javax.swing.JInternalFrame{
    DefaultTableModel dtmArea;
    AreaDao areaDao = new AreaDao();
    Util u = new Util();
    public FrmArea() {
        initComponents();
        dtmArea = new DefaultTableModel(new Object[]{"AREA ID", "DESCRIPCION"}, 0){
          @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tbl_area.setModel(dtmArea);
        this.llenaTblArea(false, "");
    }
    private void llenaTblArea(boolean valida, String cadena){
    
        Vector<Area> listaArea;
        
        this.txt_id_area.setText(Integer.toString(u.idNext("Area", "areaID")));
        
        listaArea = areaDao.listaArea(valida, cadena);
        dtmArea.setRowCount(0);
        
        for(int i=0;i<listaArea.size();i++){
            
            Vector vector = new Vector();
            vector.addElement(listaArea.get(i).getAreaID());
            vector.addElement(listaArea.get(i).getDescripArea());
            
            dtmArea.addRow(vector);
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_id_area = new javax.swing.JTextField();
        txt_descripcion_area = new javax.swing.JTextField();
        btn_grabar_area = new javax.swing.JButton();
        btn_limpiar_area = new javax.swing.JButton();
        btn_eliminar_area = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_area = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txt_buscar_area = new javax.swing.JTextField();
        btn_salir_area = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FORMULARIO AREA");

        jLabel2.setText("AREA ID");

        jLabel3.setText("DESCRIPCION");

        txt_id_area.setEditable(false);

        btn_grabar_area.setText("GRABAR");
        btn_grabar_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabar_areaActionPerformed(evt);
            }
        });

        btn_limpiar_area.setText("LIMPIAR");
        btn_limpiar_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_areaActionPerformed(evt);
            }
        });

        btn_eliminar_area.setText("ELIMINAR");
        btn_eliminar_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_areaActionPerformed(evt);
            }
        });

        tbl_area.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "AREA ID", "DESCRIPCION"
            }
        ));
        tbl_area.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_areaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_area);

        jLabel4.setText("BUSCAR");

        txt_buscar_area.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar_areaKeyReleased(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btn_salir_area, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_grabar_area, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_limpiar_area)
                                .addGap(18, 18, 18)
                                .addComponent(btn_eliminar_area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_descripcion_area, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_id_area, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(45, 45, 45)
                        .addComponent(txt_buscar_area, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_id_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_buscar_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_descripcion_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_grabar_area)
                            .addComponent(btn_limpiar_area)
                            .addComponent(btn_eliminar_area))
                        .addGap(75, 75, 75)
                        .addComponent(btn_salir_area, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscar_areaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_areaKeyReleased
        if(this.txt_buscar_area.getText().isEmpty()){
            this.llenaTblArea(false, "");
        }else{
            this.llenaTblArea(true, this.txt_buscar_area.getText());
        }
    }//GEN-LAST:event_txt_buscar_areaKeyReleased

    private void tbl_areaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_areaMouseClicked
        int idx = this.tbl_area.getSelectedRow();
        
        this.txt_id_area.setText(this.dtmArea.getValueAt(idx, 0).toString());
        this.txt_descripcion_area.setText(this.dtmArea.getValueAt(idx, 1).toString());
        
        this.btn_grabar_area.setText("Actualizar");
    }//GEN-LAST:event_tbl_areaMouseClicked

    private void btn_salir_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_areaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_areaActionPerformed

    private void btn_grabar_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabar_areaActionPerformed
        Area area = new Area();
        if(this.valida() == true){
            
            if(this.btn_grabar_area.getText().equals("Grabar")){
            
                area.setAreaID(Integer.parseInt(this.txt_id_area.getText()));
                area.setDescripArea(this.txt_descripcion_area.getText());
                
                this.areaDao.insertaArea(area);
                this.limpia();
                this.llenaTblArea(false, "");
            }else{
            
                area.setAreaID(Integer.parseInt(this.txt_id_area.getText()));
                area.setDescripArea(this.txt_descripcion_area.getText());
                
                this.areaDao.actualizarArea(area);
                this.limpia();
                this.llenaTblArea(false, "");
            }
        
        }
    }//GEN-LAST:event_btn_grabar_areaActionPerformed

    private void btn_eliminar_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_areaActionPerformed
        Area area = new Area();
        area.setAreaID(Integer.parseInt(this.txt_id_area.getText()));
        this.areaDao.eliminarArea(area);
        this.limpia();
        this.llenaTblArea(false, "");
    }//GEN-LAST:event_btn_eliminar_areaActionPerformed

    private void btn_limpiar_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_areaActionPerformed
        this.limpia();
    }//GEN-LAST:event_btn_limpiar_areaActionPerformed

        private void limpia(){
    
        this.txt_descripcion_area.setText("");
        this.txt_id_area.setText(Integer.toString(u.idNext("Area", "areaID")));
        this.btn_grabar_area.setText("Grabar");
    }
    
    private boolean valida(){
    
        if (this.txt_id_area.getText().isEmpty() && this.txt_descripcion_area.getText().isEmpty()){
        
            JOptionPane.showMessageDialog(null, "Falta llenar campos...");
        }else if(this.txt_id_area.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Falta llenar area ID...");
        }else if(this.txt_descripcion_area.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Falta llenar Descripción...");
        }else {
            return true;
        }
        
        return false;
    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar_area;
    private javax.swing.JButton btn_grabar_area;
    private javax.swing.JButton btn_limpiar_area;
    private javax.swing.JButton btn_salir_area;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_area;
    private javax.swing.JTextField txt_buscar_area;
    private javax.swing.JTextField txt_descripcion_area;
    private javax.swing.JTextField txt_id_area;
    // End of variables declaration//GEN-END:variables
}
