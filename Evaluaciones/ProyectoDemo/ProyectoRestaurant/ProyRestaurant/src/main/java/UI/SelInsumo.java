
package UI;

import BEAN.Insumo;
import DAO.InsumoDao;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelInsumo extends javax.swing.JDialog {
    InsumoDao insumoDao= new InsumoDao();
    DefaultTableModel dtm;
    Insumo insumo= new Insumo();
    public SelInsumo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        dtm = (DefaultTableModel)this.tbl_insumos_selInsumos.getModel();
        this.llenaTblInsumo(false, "");
        this.setLocationRelativeTo(this);
    }
    public void llenaTblInsumo(boolean sw, String cad){
        Vector<Insumo> listInsumo = insumoDao.ListaItem(sw, cad);
        dtm.setRowCount(0);
        for(int i = 0; i<listInsumo.size();i++){
            Vector vec = new Vector();
            vec.addElement(listInsumo.get(i).getInsumoID());
            vec.addElement(listInsumo.get(i).getUnidadMedida());
            vec.addElement(listInsumo.get(i).getDescripInsumo());
            vec.addElement(listInsumo.get(i).getPrecioUnit());
            dtm.addRow(vec);
            
        }  
    }
         public Insumo devInsumo(){
            return insumo;
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_insumo_buscarInsumos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_insumos_selInsumos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("BUSCAR INSUMOS");

        jLabel2.setText("INSUMO");

        txt_insumo_buscarInsumos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_insumo_buscarInsumosKeyReleased(evt);
            }
        });

        tbl_insumos_selInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "UnidadMedida", "Descripcion", "PrecioUnit"
            }
        ));
        tbl_insumos_selInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_insumos_selInsumosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_insumos_selInsumos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_insumo_buscarInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_insumo_buscarInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_insumo_buscarInsumosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_insumo_buscarInsumosKeyReleased
        if(this.txt_insumo_buscarInsumos.getText().isEmpty()){
            this.llenaTblInsumo(false, "");
        }else{
            this.llenaTblInsumo(true, this.txt_insumo_buscarInsumos.getText());
        }
    }//GEN-LAST:event_txt_insumo_buscarInsumosKeyReleased

    private void tbl_insumos_selInsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_insumos_selInsumosMouseClicked
        int i;
        i = this.tbl_insumos_selInsumos.getSelectedRow();
        insumo.setInsumoID(Integer.parseInt(dtm.getValueAt(i,0).toString()));
        insumo.setUnidadMedida(dtm.getValueAt(i,1).toString());
        insumo.setDescripInsumo(dtm.getValueAt(i,2).toString());
        insumo.setPrecioUnit(Double.parseDouble(dtm.getValueAt(i,3).toString()));
        this.dispose();
    }//GEN-LAST:event_tbl_insumos_selInsumosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_insumos_selInsumos;
    private javax.swing.JTextField txt_insumo_buscarInsumos;
    // End of variables declaration//GEN-END:variables
}
