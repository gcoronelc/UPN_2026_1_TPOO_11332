
package UI;

import BEAN.Plato;
import BEAN.Producto;
import BEAN.TipProducto;
import DAO.PlatoDao;
import DAO.ProductoDao;
import DAO.TipProductoDao;
import UTIL.Util;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmProducto extends javax.swing.JInternalFrame {
    PlatoDao platDao;
    ProductoDao prodDao;
    TipProductoDao tipProbDao;
    DefaultTableModel dtm;
    Util u;
    private int idProducto;
    
    public FrmProducto() {
        platDao = new PlatoDao();
        prodDao = new ProductoDao();
        tipProbDao = new TipProductoDao();
        u = new Util();
        initComponents();
        dtm = new DefaultTableModel(new Object[]{"ID", "Descripcion", "Cantidad", "Precio Unitario", "Plato", "Tipo Producto"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tbl_producto.setModel(dtm);
        llenaTblProducto(false,"");
        llenaCmbPlato();
        llenaCmbTipo(); 
    }
    private void llenaCmbTipo(){
        Vector<TipProducto>listaTip;
        listaTip = tipProbDao.listaTip();
        this.cmb_tipoProducto_producto.addItem("");
        for(int i=0;i<listaTip.size();i++){
            this.cmb_tipoProducto_producto.addItem(listaTip.get(i).getDescripcion());
        }
    }
    private void llenaCmbPlato(){
        Vector <Plato> listaPlato;
        listaPlato = platDao.listaPlato();
        this.cmb_plato_producto.addItem("");
        for(int i=0;i<listaPlato.size();i++){
            this.cmb_plato_producto.addItem(listaPlato.get(i).getDescPlat());
        }
    }
    private void llenaTblProducto(boolean valida, String Cadena){
        
        Vector<Producto> listProduct;
        
        listProduct = prodDao.ListaProducto(valida, Cadena);
        dtm.setRowCount(0);
        
        for(int i=0; i<listProduct.size();i++){
            Vector v = new Vector();
            v.addElement(listProduct.get(i).getProductoID());
            v.addElement(listProduct.get(i).getDescripProducto());
            v.addElement(listProduct.get(i).getCantidad());
            v.addElement(listProduct.get(i).getPrecioUnit());
            v.addElement(listProduct.get(i).getIdplato());
            v.addElement(listProduct.get(i).getIdtipo());
            dtm.addRow(v);
        }
    }
    private boolean verificaCamposLlenos(){
        boolean valida = false;
        if(this.txt_descripcion_producto.getText().isEmpty() && this.txt_cantidad_producto.getText().isEmpty()
           && this.txt_precioUnitario_producto.getText().isEmpty() && this.cmb_plato_producto.getSelectedItem().toString().isEmpty()
           && this.cmb_tipoProducto_producto.getSelectedItem().toString().isEmpty()){
            JOptionPane.showMessageDialog(this, "FALTA LLENAR TODOS LOS CAMPOS...");
        }else{
            if(this.txt_descripcion_producto.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "FALTA LLENAR LA DESCRIPCION DEL PRODUCTO...");
            }else if(this.txt_cantidad_producto.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "FALTA LLENAR LA CANTIDAD...");
            }else if(this.txt_precioUnitario_producto.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "FALTA LLENAR EL PRECIO UNITARIO...");
            }
            else if(this.cmb_plato_producto.getSelectedItem().toString().isEmpty()){
            JOptionPane.showMessageDialog(this, "FALTA LLENAR EL TIPO DE PLATO...");
            }
            else if(this.cmb_tipoProducto_producto.getSelectedItem().toString().isEmpty()){
            JOptionPane.showMessageDialog(this, "FALTA LLENAR EL TIPO DE PRODUCTO...");
            }else{
                valida = true;
            }
        }
        return valida;
    } 
    
    private void limpiar(){
        this.txt_id_producto.setText("");
        this.txt_descripcion_producto.setText("");
        this.txt_cantidad_producto.setText("");
        this.txt_precioUnitario_producto.setText("");
        this.cmb_plato_producto.setSelectedItem("");
        this.cmb_tipoProducto_producto.setSelectedItem("");
        this.txt_id_producto.setText(Integer.toString(u.idNext("Producto", "productoID")));
        this.btn_grabar_producto.setText("Grabar");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_id_producto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_descripcion_producto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cantidad_producto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_precioUnitario_producto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmb_plato_producto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmb_tipoProducto_producto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_buscar_producto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_producto = new javax.swing.JTable();
        btn_grabar_producto = new javax.swing.JButton();
        btn_eliminar_producto = new javax.swing.JButton();
        btn_limpiar_producto = new javax.swing.JButton();
        btn_salir_producto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID");

        txt_id_producto.setEditable(false);

        jLabel2.setText("Descripcion");

        jLabel3.setText("Cantidad");

        jLabel4.setText("Precio Unitario");

        jLabel5.setText("Plato");

        jLabel6.setText("Tipo Producto");

        jLabel7.setText("Buscar");

        txt_buscar_producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar_productoKeyReleased(evt);
            }
        });

        tbl_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Descripcion", "Cantidad", "Precio unitario", "Plato", "Tipo Producto"
            }
        ));
        tbl_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_productoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_producto);

        btn_grabar_producto.setText("Grabar");
        btn_grabar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabar_productoActionPerformed(evt);
            }
        });

        btn_eliminar_producto.setText("Eliminar");
        btn_eliminar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_productoActionPerformed(evt);
            }
        });

        btn_limpiar_producto.setText("Limpiar");
        btn_limpiar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_productoActionPerformed(evt);
            }
        });

        btn_salir_producto.setText("Salir");
        btn_salir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_productoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("FORMULARIO PRODUCTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_grabar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_eliminar_producto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_limpiar_producto))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_descripcion_producto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_cantidad_producto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_precioUnitario_producto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmb_plato_producto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cmb_tipoProducto_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(30, 30, 30)
                                .addComponent(txt_buscar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                                .addGap(32, 32, 32))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_salir_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(326, 326, 326))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_buscar_producto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_descripcion_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_cantidad_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_precioUnitario_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmb_plato_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmb_tipoProducto_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_grabar_producto)
                    .addComponent(btn_eliminar_producto)
                    .addComponent(btn_limpiar_producto))
                .addGap(10, 10, 10)
                .addComponent(btn_salir_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_productoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_productoActionPerformed

    private void btn_limpiar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_productoActionPerformed
        limpiar();
    }//GEN-LAST:event_btn_limpiar_productoActionPerformed

    private void txt_buscar_productoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_productoKeyReleased
        if(this.txt_buscar_producto.getText().isEmpty()){
            llenaTblProducto(false,"");
        }else{
            llenaTblProducto(true,this.txt_buscar_producto.getText());
        } 
    }//GEN-LAST:event_txt_buscar_productoKeyReleased

    private void tbl_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_productoMouseClicked
        int idx;
        idx = this.tbl_producto.getSelectedRow();
        this.idProducto = Integer.parseInt(dtm.getValueAt(idx, 0).toString());
        this.txt_id_producto.setText(dtm.getValueAt(idx, 0).toString());
        this.txt_descripcion_producto.setText(dtm.getValueAt(idx, 1).toString());
        this.txt_cantidad_producto.setText(dtm.getValueAt(idx, 2).toString());
        this.txt_precioUnitario_producto.setText(dtm.getValueAt(idx, 3).toString());
        this.cmb_plato_producto.setSelectedItem(u.cadExpNum("Plato", "idPlato", "descPlato", Integer.parseInt(dtm.getValueAt(idx, 4).toString())));
        this.cmb_tipoProducto_producto.setSelectedItem(u.cadExpNum("TipProducto", "idTipProducto", "descripcion", Integer.parseInt(dtm.getValueAt(idx, 5).toString())));
        this.btn_grabar_producto.setText("Actualizar");
    }//GEN-LAST:event_tbl_productoMouseClicked

    private void btn_eliminar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_productoActionPerformed
        if (this.verificaCamposLlenos() == true){
            Producto prod = new Producto();
        
            prod.setProductoID(this.idProducto);
            this.prodDao.eliminarProducto(prod);
        }
        this.llenaTblProducto(false, "");
        this.limpiar();
        this.btn_grabar_producto.setText("Grabar"); 
    }//GEN-LAST:event_btn_eliminar_productoActionPerformed

    private void btn_grabar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabar_productoActionPerformed
        if(this.verificaCamposLlenos()== true){
            Producto prod = new Producto();
            Util util = new Util();

            if(this.btn_grabar_producto.getText().equals("Grabar")){
                idProducto = util.idNext("producto","productoID");

                prod.setProductoID(idProducto);
                prod.setIdplato(u.idExp("Plato", "idPlato", "descPlato", this.cmb_plato_producto.getSelectedItem().toString()));
                prod.setIdtipo(u.idExp("TipProducto", "idTipProducto", "descripcion", this.cmb_tipoProducto_producto.getSelectedItem().toString()));
                prod.setDescripProducto(this.txt_descripcion_producto.getText());
                prod.setCantidad(Integer.parseInt(this.txt_cantidad_producto.getText()));
                prod.setPrecioUnit(Double.parseDouble(this.txt_precioUnitario_producto.getText()));

                this.prodDao.insertaProducto(prod);
            }else{
                prod.setProductoID(Integer.parseInt(this.txt_id_producto.getText()));
                prod.setIdplato(u.idExp("Plato", "idPlato", "descPlato", this.cmb_plato_producto.getSelectedItem().toString()));
                prod.setIdtipo(u.idExp("TipProducto", "idTipProducto", "descripcion", this.cmb_tipoProducto_producto.getSelectedItem().toString()));
                prod.setDescripProducto(this.txt_descripcion_producto.getText());
                prod.setCantidad(Integer.parseInt(this.txt_cantidad_producto.getText()));
                prod.setPrecioUnit(Double.parseDouble(this.txt_precioUnitario_producto.getText()));

                this.prodDao.actualizarProducto(prod);
                this.btn_grabar_producto.setText("Grabar");
            }
            this.llenaTblProducto(false,"");
            this.limpiar();
        }
    }//GEN-LAST:event_btn_grabar_productoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar_producto;
    private javax.swing.JButton btn_grabar_producto;
    private javax.swing.JButton btn_limpiar_producto;
    private javax.swing.JButton btn_salir_producto;
    private javax.swing.JComboBox<String> cmb_plato_producto;
    private javax.swing.JComboBox<String> cmb_tipoProducto_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_producto;
    private javax.swing.JTextField txt_buscar_producto;
    private javax.swing.JTextField txt_cantidad_producto;
    private javax.swing.JTextField txt_descripcion_producto;
    private javax.swing.JTextField txt_id_producto;
    private javax.swing.JTextField txt_precioUnitario_producto;
    // End of variables declaration//GEN-END:variables
}
