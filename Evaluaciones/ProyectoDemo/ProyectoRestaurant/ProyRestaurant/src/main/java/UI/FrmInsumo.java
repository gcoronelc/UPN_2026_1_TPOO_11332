
package UI;

import BEAN.Insumo;
import BEAN.TipInsumo;
import DAO.InsumoDao;
import DAO.TipInsumoDao;
import UTIL.Util;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmInsumo extends javax.swing.JInternalFrame {
    TipInsumoDao tipinsu = new TipInsumoDao();
    InsumoDao insuDao = new InsumoDao();
    DefaultTableModel dtmInsumo;
    String tipInsumo;
    Util util = new Util();
    public FrmInsumo() {
        initComponents();
        dtmInsumo = new DefaultTableModel(new Object[]{"ID", "Tipo Insumo", "UnidadMedida", "Descripcion", "Precio", "Cantidad"}, 0){
          @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tbl_insumo.setModel(dtmInsumo);
        this.llenaTblIns(false, "");
        this.llenaCmbTipo();
    }
    public void llenaTblIns(boolean sw, String cad){
        
        this.txt_id_insumo.setText(Integer.toString(util.idNext("Insumo", "insumoID")));
        Vector<Insumo> listaInsumo;
        listaInsumo = insuDao.ListaItem(sw, cad);
        dtmInsumo.setRowCount(0);
        
        for(int i=0;i<listaInsumo.size();i++){
            
            Vector vector = new Vector();
            vector.addElement(listaInsumo.get(i).getInsumoID());
            tipInsumo = tipinsu.devTipInsumo(listaInsumo.get(i).getIdTipInsumo());
            vector.addElement(tipInsumo);
            vector.addElement(listaInsumo.get(i).getUnidadMedida());
            vector.addElement(listaInsumo.get(i).getDescripInsumo());
            vector.addElement(listaInsumo.get(i).getPrecioUnit());
            vector.addElement(listaInsumo.get(i).getCantidad());
            dtmInsumo.addRow(vector);
        }
        
    }
    
   public void llenaCmbTipo(){

        Vector<TipInsumo> listaTipInsu = new Vector<TipInsumo>();
        listaTipInsu = this.tipinsu.llenaTipInsumo();
        this.cmb_tipo_insumo.addItem("");
        for (int i=0; i<listaTipInsu.size();i++){
            this.cmb_tipo_insumo.addItem(listaTipInsu.get(i).getDescripcion());
        }
        
    }
    public void limpiar(){
        this.txt_id_insumo.setText(Integer.toString(util.idNext("Insumo", "insumoID")));
        this.cmb_tipo_insumo.setSelectedItem("");
        this.txt_unidad_medida_insumo.setText("");
        this.txt_precio_insumo.setText("");
        this.txt_descipcion_insumo.setText("");
        this.txt_cantidad_insumo.setText("");
        this.btn_grabar_insumo.setText("Grabar");
    
    }
    
    public boolean valida(){
    
        if(this.cmb_tipo_insumo.getSelectedItem().equals("") && this.txt_unidad_medida_insumo.getText().isEmpty() &&
           this.txt_descipcion_insumo.getText().isEmpty() && this.txt_cantidad_insumo.getText().isEmpty() && this.txt_precio_insumo.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "FALTA LLENAR LOS CAMPOS...");
        }else if(this.cmb_tipo_insumo.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "FALTA LLENAR TIPO INSUMO...");
        }else if(this.txt_unidad_medida_insumo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "FALTA LLENAR UNIDAD DE MEDIDA...");
        }else if(this.txt_descipcion_insumo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "FALTA LLENAR DESCRIPCION...");
        }else if(this.txt_cantidad_insumo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "FALTA LLENAR CANTIDAD...");
        }else if(this.txt_precio_insumo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "FALTA LLENAR PRECIO...");
        }else{
            return true;
        }
        
        return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_id_insumo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmb_tipo_insumo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_unidad_medida_insumo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_precio_insumo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_cantidad_insumo = new javax.swing.JTextField();
        btn_grabar_insumo = new javax.swing.JButton();
        btn_limpiar_insumo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_insumo = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txt_buscar_insumo = new javax.swing.JTextField();
        btn_eliminar_insumo = new javax.swing.JButton();
        btn_salir_insumo = new javax.swing.JButton();
        txt_descipcion_insumo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FORMULARIO INSUMO");

        jLabel2.setText("ID");

        txt_id_insumo.setEditable(false);

        jLabel3.setText("Tipo Insumo");

        jLabel4.setText("Unidad Medida");

        jLabel5.setText("Descripcion");

        jLabel6.setText("Precio Unidad");

        jLabel7.setText("Cantidad");

        btn_grabar_insumo.setText("Grabar");
        btn_grabar_insumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabar_insumoActionPerformed(evt);
            }
        });

        btn_limpiar_insumo.setText("Limpiar");
        btn_limpiar_insumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_insumoActionPerformed(evt);
            }
        });

        tbl_insumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tipo Insumo", "UnidadMedida", "Descripcion", "Precio", "Cantidad"
            }
        ));
        tbl_insumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_insumoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_insumo);

        jLabel8.setText("Buscar");

        txt_buscar_insumo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar_insumoKeyReleased(evt);
            }
        });

        btn_eliminar_insumo.setText("Eliminar");
        btn_eliminar_insumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_insumoActionPerformed(evt);
            }
        });

        btn_salir_insumo.setText("Salir");
        btn_salir_insumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_insumoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(386, 386, 386))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(btn_grabar_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_cantidad_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_precio_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(btn_limpiar_insumo)))
                                .addGap(28, 28, 28)
                                .addComponent(btn_eliminar_insumo))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_descipcion_insumo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmb_tipo_insumo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_unidad_medida_insumo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txt_id_insumo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(30, 30, 30)
                                .addComponent(txt_buscar_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 735, Short.MAX_VALUE)
                        .addComponent(btn_salir_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(29, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_id_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_tipo_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_unidad_medida_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_descipcion_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_precio_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_cantidad_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_buscar_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_grabar_insumo)
                    .addComponent(btn_limpiar_insumo)
                    .addComponent(btn_eliminar_insumo)
                    .addComponent(btn_salir_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salir_insumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_insumoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_insumoActionPerformed

    private void btn_eliminar_insumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_insumoActionPerformed
        if (valida() == true){
        
                Insumo insumo = new Insumo();

                insumo.setInsumoID(Integer.parseInt(this.txt_id_insumo.getText()));
                
                this.insuDao.eliminarInsumo(insumo.getInsumoID());
                this.llenaTblIns(false, "");
                this.limpiar();
        }
    }//GEN-LAST:event_btn_eliminar_insumoActionPerformed

    private void txt_buscar_insumoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_insumoKeyReleased
        if(this.txt_buscar_insumo.getText().isEmpty()){
        
            this.llenaTblIns(false, "");
        }else{
        
            this.llenaTblIns(true, this.txt_buscar_insumo.getText());
        }
    }//GEN-LAST:event_txt_buscar_insumoKeyReleased

    private void tbl_insumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_insumoMouseClicked
        int idx;
        
        this.btn_grabar_insumo.setText("Actualizar");
        idx = this.tbl_insumo.getSelectedRow();
        
        this.txt_id_insumo.setText(this.dtmInsumo.getValueAt(idx, 0).toString());
        this.cmb_tipo_insumo.setSelectedItem(this.dtmInsumo.getValueAt(idx, 1).toString());
        this.txt_unidad_medida_insumo.setText(this.dtmInsumo.getValueAt(idx, 2).toString());
        this.txt_descipcion_insumo.setText(this.dtmInsumo.getValueAt(idx, 3).toString());
        this.txt_precio_insumo.setText(this.dtmInsumo.getValueAt(idx, 4).toString());
        this.txt_cantidad_insumo.setText(this.dtmInsumo.getValueAt(idx, 5).toString());
    }//GEN-LAST:event_tbl_insumoMouseClicked

    private void btn_grabar_insumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabar_insumoActionPerformed
        if(this.valida() == true){
        
            if(this.btn_grabar_insumo.getText().equals("Grabar")){
                
                Insumo insumo = new Insumo();

                insumo.setInsumoID(Integer.parseInt(this.txt_id_insumo.getText()));
                
                insumo.setIdTipInsumo(this.tipinsu.devIDTipInsumo(this.cmb_tipo_insumo.getSelectedItem().toString()));

                insumo.setUnidadMedida(this.txt_unidad_medida_insumo.getText());
                insumo.setDescripInsumo(this.txt_descipcion_insumo.getText());
                insumo.setPrecioUnit(Double.parseDouble(this.txt_precio_insumo.getText()));
                insumo.setCantidad(Integer.parseInt(this.txt_cantidad_insumo.getText()));
                
                this.insuDao.insertaInsumo(insumo);
                this.limpiar();
                
                this.llenaTblIns(false, "");
            }else{
                
                Insumo insumo = new Insumo();

                insumo.setInsumoID(Integer.parseInt(this.txt_id_insumo.getText()));
                
                insumo.setIdTipInsumo(this.tipinsu.devIDTipInsumo(this.cmb_tipo_insumo.getSelectedItem().toString()));

                insumo.setUnidadMedida(this.txt_unidad_medida_insumo.getText());
                insumo.setDescripInsumo(this.txt_descipcion_insumo.getText());
                insumo.setPrecioUnit(Double.parseDouble(this.txt_precio_insumo.getText()));
                insumo.setCantidad(Integer.parseInt(this.txt_cantidad_insumo.getText()));
                
                this.insuDao.actualizarInsumo(insumo);
                this.limpiar();
                
                this.llenaTblIns(false, "");           
            }
        }
    }//GEN-LAST:event_btn_grabar_insumoActionPerformed

    private void btn_limpiar_insumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_insumoActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btn_limpiar_insumoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar_insumo;
    private javax.swing.JButton btn_grabar_insumo;
    private javax.swing.JButton btn_limpiar_insumo;
    private javax.swing.JButton btn_salir_insumo;
    private javax.swing.JComboBox<String> cmb_tipo_insumo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_insumo;
    private javax.swing.JTextField txt_buscar_insumo;
    private javax.swing.JTextField txt_cantidad_insumo;
    private javax.swing.JTextField txt_descipcion_insumo;
    private javax.swing.JTextField txt_id_insumo;
    private javax.swing.JTextField txt_precio_insumo;
    private javax.swing.JTextField txt_unidad_medida_insumo;
    // End of variables declaration//GEN-END:variables
}
