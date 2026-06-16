
package UI;

import BEAN.Insumo;
import BEAN.Producto;
import DAO.CabOrdenDeProduccionSemanalDAO;
import DAO.DetOrdenDeProduccionSemanalDAO;
import DAO.EmpleadoDao;
import DAO.InsumoDao;
import DAO.PlatoDao;
import DAO.ProductoDao;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class OrdenCompra extends javax.swing.JInternalFrame {
    DefaultTableModel dtm1;
    DefaultTableModel dtm2;
    DefaultTableModel dtm3;
    DefaultTableModel dtm4;
    ProductoDao productoDao = new ProductoDao();
    InsumoDao insumoDao= new InsumoDao();
    PlatoDao platoDao= new PlatoDao();
    EmpleadoDao empleadoDao= new EmpleadoDao();
    CabOrdenDeProduccionSemanalDAO cabOrdenDeProduccionSemanalDao= new CabOrdenDeProduccionSemanalDAO();
    DetOrdenDeProduccionSemanalDAO detOrdenDeProduccionSemanalDao= new DetOrdenDeProduccionSemanalDAO();
    public OrdenCompra() {
        initComponents();
        dtm1 = (DefaultTableModel)this.tbl_insumos_orden_compra.getModel();
        dtm2 = (DefaultTableModel)this.tbl_productos_orden_compra.getModel();

        llenaTblInsumo(false, "");
        llenaTblProducto(false, "");
    }
    private void llenaTblInsumo(boolean sw, String str){
        Vector<Insumo> listaInsu;
        listaInsu = insumoDao.ListaItem(sw, str);
        
        dtm1.setRowCount(0);
        
        for(int i = 0;i<listaInsu.size();i++){
            Vector vec = new Vector();
            vec.addElement(listaInsu.get(i).getInsumoID());
            vec.addElement(listaInsu.get(i).getIdTipInsumo());
            vec.addElement(listaInsu.get(i).getUnidadMedida());
            vec.addElement(listaInsu.get(i).getDescripInsumo());
            vec.addElement(listaInsu.get(i).getPrecioUnit());
            vec.addElement(listaInsu.get(i).getCantidad());
            dtm1.addRow(vec);
        }
        
    }
    private void llenaTblProducto(boolean sw, String str){
        Vector<Producto> listaProd;
        listaProd = productoDao.ListaProducto(sw, str);
        
        dtm2.setRowCount(0);
        
        for(int i = 0;i<listaProd.size();i++){
            Vector vec = new Vector();
            vec.addElement(listaProd.get(i).getProductoID());
            vec.addElement(listaProd.get(i).getIdtipo());
            vec.addElement(listaProd.get(i).getDescripProducto());
            vec.addElement(listaProd.get(i).getPrecioUnit());
            vec.addElement(listaProd.get(i).getCantidad());
            dtm2.addRow(vec);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_buscar_insumos_ordenCompra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_insumos_orden_compra = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_buscar_producto_ordenCompra = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_productos_orden_compra = new javax.swing.JTable();
        btn_cerrar_control_inventarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("CONTROL DE INVENTARIOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("INSUMOS"));

        jLabel2.setText("BUSCAR");

        txt_buscar_insumos_ordenCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar_insumos_ordenCompraKeyReleased(evt);
            }
        });

        tbl_insumos_orden_compra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "TipoInsumo", "UniMedida", "Descripcion", "PrecioUnit", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tbl_insumos_orden_compra);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_buscar_insumos_ordenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_buscar_insumos_ordenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("PRODUCTOS"));

        jLabel3.setText("BUSCAR");

        txt_buscar_producto_ordenCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar_producto_ordenCompraKeyReleased(evt);
            }
        });

        tbl_productos_orden_compra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "TipoProducto", "Descripcion", "PrecioUnit", "Cantidad"
            }
        ));
        jScrollPane2.setViewportView(tbl_productos_orden_compra);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(22, 22, 22)
                        .addComponent(txt_buscar_producto_ordenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_buscar_producto_ordenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_cerrar_control_inventarios.setText("CERRAR");
        btn_cerrar_control_inventarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrar_control_inventariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_cerrar_control_inventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(360, 360, 360)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btn_cerrar_control_inventarios)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerrar_control_inventariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrar_control_inventariosActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerrar_control_inventariosActionPerformed

    private void txt_buscar_producto_ordenCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_producto_ordenCompraKeyReleased
        if(this.txt_buscar_producto_ordenCompra.getText().isEmpty()){
            llenaTblProducto(false, "");
        }else{
            llenaTblProducto(true, this.txt_buscar_producto_ordenCompra.getText());
        }
    }//GEN-LAST:event_txt_buscar_producto_ordenCompraKeyReleased

    private void txt_buscar_insumos_ordenCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_insumos_ordenCompraKeyReleased
        if(this.txt_buscar_insumos_ordenCompra.getText().isEmpty()){
            llenaTblInsumo(false, "");
        }else{
            llenaTblInsumo(true, this.txt_buscar_insumos_ordenCompra.getText());
        }
    }//GEN-LAST:event_txt_buscar_insumos_ordenCompraKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrar_control_inventarios;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_insumos_orden_compra;
    private javax.swing.JTable tbl_productos_orden_compra;
    private javax.swing.JTextField txt_buscar_insumos_ordenCompra;
    private javax.swing.JTextField txt_buscar_producto_ordenCompra;
    // End of variables declaration//GEN-END:variables
}
