
package UI;

import BEAN.Rol;
import DAO.RolDao;
import UTIL.Util;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmRol extends javax.swing.JInternalFrame {
    DefaultTableModel dtmRol;
    RolDao rolDao = new RolDao();
    Util u = new Util();
    public FrmRol() {
        initComponents();
        dtmRol = new DefaultTableModel(new Object [] {"ID", "DESCRIPCION"},0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tbl_rol.setModel(dtmRol);
        this.llenaTblRol(false, "");
    }
    private void llenaTblRol(boolean valida, String cadena){
        Vector<Rol> listaRol;
        
        this.txt_id_rol.setText(Integer.toString(u.idNext("Rol", "rolID")));
        listaRol = rolDao.listaRol(valida, cadena);
        dtmRol.setRowCount(0);
        
        for(int i=0;i<listaRol.size();i++){
            
            Vector vector = new Vector();
            vector.addElement(listaRol.get(i).getRolID());
            vector.addElement(listaRol.get(i).getDescripRol());
            
            dtmRol.addRow(vector);
        }
    }
    private boolean valida(){
    
        if (this.txt_id_rol.getText().isEmpty() && this.txt_descripcion_rol.getText().isEmpty()){
        
            JOptionPane.showMessageDialog(null, "Falta llenar campos...");
        }else if(this.txt_id_rol.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Falta llenar rol ID...");
        }else if(this.txt_descripcion_rol.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Falta llenar Descripción...");
        }else {
            return true;
        }
        
        return false;
    
    }
    
    private void limpia(){
    
        this.txt_descripcion_rol.setText("");
        this.txt_id_rol.setText(Integer.toString(u.idNext("Rol", "rolID")));
        this.btn_grabar_rol.setText("Grabar");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_rol = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txt_id_rol = new javax.swing.JTextField();
        txt_descripcion_rol = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_buscar_rol = new javax.swing.JTextField();
        btn_grabar_rol = new javax.swing.JButton();
        btn_eliminar_rol = new javax.swing.JButton();
        btn_limpiar_rol = new javax.swing.JButton();
        btn_salir_rol = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FORMULARIO ROL");

        jLabel2.setText("ID ROL");

        tbl_rol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "DESCRIPCION"
            }
        ));
        tbl_rol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_rolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_rol);

        jLabel3.setText("DESCRIPCION");

        txt_id_rol.setEditable(false);

        jLabel4.setText("Buscar");

        txt_buscar_rol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar_rolKeyReleased(evt);
            }
        });

        btn_grabar_rol.setText("Grabar");
        btn_grabar_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabar_rolActionPerformed(evt);
            }
        });

        btn_eliminar_rol.setText("Eliminar");
        btn_eliminar_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_rolActionPerformed(evt);
            }
        });

        btn_limpiar_rol.setText("Limpiar");
        btn_limpiar_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_rolActionPerformed(evt);
            }
        });

        btn_salir_rol.setText("Salir");
        btn_salir_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_rolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(btn_salir_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(btn_grabar_rol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)))
                                .addComponent(btn_eliminar_rol)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_limpiar_rol))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_descripcion_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_buscar_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_buscar_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_descripcion_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_grabar_rol)
                            .addComponent(btn_eliminar_rol)
                            .addComponent(btn_limpiar_rol))
                        .addGap(55, 55, 55)
                        .addComponent(btn_salir_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscar_rolKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_rolKeyReleased
        if(this.txt_buscar_rol.getText().isEmpty()){
            this.llenaTblRol(false, "");
        }else{
            this.llenaTblRol(true, this.txt_buscar_rol.getText());
        }
    }//GEN-LAST:event_txt_buscar_rolKeyReleased

    private void tbl_rolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_rolMouseClicked
        int idx = this.tbl_rol.getSelectedRow();
        
        this.txt_id_rol.setText(this.dtmRol.getValueAt(idx, 0).toString());
        this.txt_descripcion_rol.setText(this.dtmRol.getValueAt(idx, 1).toString());
        
        this.btn_grabar_rol.setText("Actualizar");
    }//GEN-LAST:event_tbl_rolMouseClicked

    private void btn_salir_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_rolActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_rolActionPerformed

    private void btn_grabar_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabar_rolActionPerformed
        Rol rol = new Rol();
        if(this.valida() == true){
            
            if(this.btn_grabar_rol.getText().equals("Grabar")){
                rol.setRolID(Integer.parseInt(this.txt_id_rol.getText()));
                rol.setDescripRol(this.txt_descripcion_rol.getText());
                
                this.rolDao.insertaRol(rol);
                this.limpia();
                this.llenaTblRol(false, "");
            }else{
            
                rol.setRolID(Integer.parseInt(this.txt_id_rol.getText()));
                rol.setDescripRol(this.txt_descripcion_rol.getText());
                
                this.rolDao.actualizarRol(rol);
                this.limpia();
                this.llenaTblRol(false, "");
            }
        
        }
    }//GEN-LAST:event_btn_grabar_rolActionPerformed

    private void btn_limpiar_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_rolActionPerformed
        this.limpia();
        this.llenaTblRol(false, "");
    }//GEN-LAST:event_btn_limpiar_rolActionPerformed

    private void btn_eliminar_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_rolActionPerformed
        Rol rol = new Rol();
        rol.setRolID(Integer.parseInt(this.txt_id_rol.getText()));
        this.rolDao.eliminarRol(rol);
        this.limpia();
        this.llenaTblRol(false, "");
    }//GEN-LAST:event_btn_eliminar_rolActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar_rol;
    private javax.swing.JButton btn_grabar_rol;
    private javax.swing.JButton btn_limpiar_rol;
    private javax.swing.JButton btn_salir_rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_rol;
    private javax.swing.JTextField txt_buscar_rol;
    private javax.swing.JTextField txt_descripcion_rol;
    private javax.swing.JTextField txt_id_rol;
    // End of variables declaration//GEN-END:variables
}
