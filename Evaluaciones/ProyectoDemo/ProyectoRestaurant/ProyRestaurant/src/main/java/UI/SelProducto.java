
package UI;

import BEAN.Producto;
import DAO.ProductoDao;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

public class SelProducto extends javax.swing.JDialog {
    ProductoDao productoDao;
    DefaultTableModel dtm;
    Producto prod;
    public SelProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        productoDao = new ProductoDao();
        prod = new Producto();
        dtm = new DefaultTableModel(new Object[]{"ID", "Descripcion", "Tipo", "Precio", "Estado"},0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tbl_producto_buscarProducto.setModel(dtm);
        this.llenaTblProducto(false, "");
    }
    public void llenaTblProducto(boolean sw, String cad){
        Vector<Producto> listProducto = productoDao.ListaProducto(sw, cad);
        dtm.setRowCount(0);
        for(int i = 0; i<listProducto.size();i++){
            Vector vec = new Vector();
            vec.addElement(listProducto.get(i).getProductoID());
            vec.addElement(listProducto.get(i).getDescripProducto());
            vec.addElement(listProducto.get(i).getIdtipo());
            vec.addElement(listProducto.get(i).getPrecioUnit());
            dtm.addRow(vec);
        }  
    }
    public Producto devProd(){
        return prod;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_producto_buscarProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_producto_buscarProducto = new javax.swing.JTable();
        btn_salir_buscar_producto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("BUSCAR PRODUCTOS");

        jLabel2.setText("PRODUCTO");

        txt_producto_buscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_producto_buscarProductoKeyReleased(evt);
            }
        });

        tbl_producto_buscarProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Descripcion", "Tipo", "Precio", "Estado"
            }
        ));
        tbl_producto_buscarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_producto_buscarProductoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_producto_buscarProductoMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_producto_buscarProducto);

        btn_salir_buscar_producto.setText("SALIR");
        btn_salir_buscar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_buscar_productoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_salir_buscar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(115, 115, 115)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txt_producto_buscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_producto_buscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_salir_buscar_producto)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_producto_buscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_producto_buscarProductoKeyReleased
        if(this.txt_producto_buscarProducto.getText().isEmpty()){
            this.llenaTblProducto(false, "");
        }else{
            this.llenaTblProducto(true, this.txt_producto_buscarProducto.getText());
        }
    }//GEN-LAST:event_txt_producto_buscarProductoKeyReleased

    private void tbl_producto_buscarProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_producto_buscarProductoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_producto_buscarProductoMouseEntered

    private void tbl_producto_buscarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_producto_buscarProductoMouseClicked
        int i;
        i = this.tbl_producto_buscarProducto.getSelectedRow();
        prod.setProductoID(Integer.parseInt(dtm.getValueAt(i,0).toString()));
        prod.setDescripProducto(dtm.getValueAt(i,1).toString());
        prod.setIdtipo(Integer.parseInt(dtm.getValueAt(i,2).toString()));
        prod.setPrecioUnit(Double.parseDouble(dtm.getValueAt(i,3).toString()));
        this.dispose();
    }//GEN-LAST:event_tbl_producto_buscarProductoMouseClicked

    private void btn_salir_buscar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_buscar_productoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_buscar_productoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_salir_buscar_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_producto_buscarProducto;
    private javax.swing.JTextField txt_producto_buscarProducto;
    // End of variables declaration//GEN-END:variables
}
