
package UI;

import BEAN.CabOrdenDeVenta;
import BEAN.Cliente;
import BEAN.DetOrdenDeVenta;
import BEAN.Empleado;
import BEAN.Mesa;
import BEAN.Pedidos;
import BEAN.Producto;
import DAO.CabOrdenDeVentaDao;
import DAO.ClienteDao;
import DAO.DetOrdVentaDao;
import DAO.EmpleadoDao;
import DAO.MesaDao;
import DAO.PedidosDao;
import DAO.ProductoDao;
import DAO.VentaDao;
import UTIL.Util;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmVenta extends javax.swing.JInternalFrame {
    CabOrdenDeVentaDao CabOrdenDeVentaDao= new CabOrdenDeVentaDao();
    DetOrdVentaDao DetOrdenDeVentaDao= new DetOrdVentaDao();
    DefaultTableModel dtm1;
    DefaultTableModel dtm2;
    DefaultTableModel dtm3;
    DefaultTableModel dtm4;
    ClienteDao clieDao= new ClienteDao();
    MesaDao mesaDao= new MesaDao();
    EmpleadoDao empleadoDao= new EmpleadoDao();
    PedidosDao pedidosDao= new PedidosDao();
    ProductoDao productoDao= new ProductoDao();
    Util u = new Util();
    public FrmVenta() {
        initComponents();
        dtm1 = new DefaultTableModel(new Object[]{"ID", "NOMBRE", "APELLIDO", "ESTADO"}, 0){
          @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tbl_cliente_venta.setModel(dtm1);
        dtm2 =  new DefaultTableModel(new Object[]{"VENTA", "CLIENTE", "MESA", "FECHA", "METODO PAGO", "TIPO ENTREGA"}, 0){
          @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tbl_compras_venta.setModel(dtm2);
        dtm3 = new DefaultTableModel(new Object[]{"ID PRODUCTO", "DESCRIPCION", "TIPO", "PRECIO"}, 0){
          @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tbl_detalle_compras_ventas.setModel(dtm3);
        dtm4 = new DefaultTableModel(new Object[]{"ID", "DESCRIPCION", "TIPO", "PRECIO", "CANTIDAD"}, 0){
          @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tbl_producto_venta.setModel(dtm4);
        this.jTabbedPane1.setSelectedIndex(1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        llenaCmbMesa();
        llenaCmbEmpleado();
        llenaCmbMetodoPago();
        llenaTblCliente(false, "");
        this.habilitaCliente(false);
        this.habilitaProducto(false);
    }
    
    private void habilitaCliente(boolean sw){
        if(sw){
            this.txt_nombre_venta.setEditable(true);
            this.txt_apellido_venta.setEditable(true);
            this.txt_direccion_venta.setEditable(true);
            this.txt_telefono_venta.setEditable(true);
            this.cmb_empleado_venta.setEditable(true);
            this.cmb_mesa_venta.setEditable(true);
            this.cmb_metodo_pago_venta.setEditable(true);
        }else{
            this.txt_nombre_venta.setEditable(false);
            this.txt_apellido_venta.setEditable(false);
            this.txt_direccion_venta.setEditable(false);
            this.txt_telefono_venta.setEditable(false);
            this.cmb_empleado_venta.setEditable(false);
            this.cmb_mesa_venta.setEditable(false);
            this.cmb_metodo_pago_venta.setEditable(false);
        }
    }
    
    private void habilitaProducto(boolean sw){
        if(sw){
            this.txt_descripcion_venta.setEditable(true);
            this.txt_cantidad_producto_venta.setEditable(true);
            this.txt_precio_producto_venta.setEditable(true);
            this.txt_tipo_producto_venta.setEditable(true);   
        }else{
            this.txt_descripcion_venta.setEditable(false);
            this.txt_cantidad_producto_venta.setEditable(false);
            this.txt_precio_producto_venta.setEditable(false);
            this.txt_tipo_producto_venta.setEditable(false);
        }
    }
    
    private void llenaCompraCliente(boolean sw, String str){
        Vector<CabOrdenDeVenta> listCabVenta;
        listCabVenta = CabOrdenDeVentaDao.ListaCodv(sw, str);
        
        dtm2.setRowCount(0);
        
        for(int i = 0;i<listCabVenta.size();i++){
            Vector vec = new Vector();
            vec.addElement(listCabVenta.get(i).getOrdenDeVentaID());
            vec.addElement(listCabVenta.get(i).getClienteID());
            vec.addElement(listCabVenta.get(i).getMesaID());
            vec.addElement(listCabVenta.get(i).getFechaVenta());
            vec.addElement(listCabVenta.get(i).getMetodoPago());
            vec.addElement(listCabVenta.get(i).getTipEntrega());
            dtm2.addRow(vec);
        }
    }
    private void llenaDetCompraCliente(boolean sw, String str){
        Vector<Producto>listDetVenta;
        listDetVenta = productoDao.ListaProducto2(sw, str);
        
        dtm3.setRowCount(0);
        for(int i = 0;i<listDetVenta.size();i++){
            Vector vec = new Vector();
            vec.addElement(listDetVenta.get(i).getProductoID());
            vec.addElement(listDetVenta.get(i).getDescripProducto());
            vec.addElement(listDetVenta.get(i).getIdtipo());
            vec.addElement(listDetVenta.get(i).getPrecioUnit());
            dtm3.addRow(vec);
        }
    }
    private void limpiaDet(){
        this.txt_id_producto_venta.setText("");
        this.txt_descripcion_venta.setText("");
        this.txt_tipo_producto_venta.setText("");
        this.txt_precio_producto_venta.setText("");
        this.txt_cantidad_producto_venta.setText("");
    }
    private void limpiaCab(){
        this.txt_nombre_venta.setText("");
        this.txt_apellido_venta.setText("");
        this.txt_direccion_venta.setText("");
        this.txt_telefono_venta.setText("");
        this.txt_idCliente_venta.setText("");
        this.cmb_empleado_venta.setSelectedItem("");
        this.cmb_mesa_venta.setSelectedItem("");
        this.cmb_metodo_pago_venta.setSelectedItem("");
        this.grupo_opciones_venta.clearSelection();
    }
    private void llenaTblCliente(boolean sw, String str){
        Vector<Cliente> listaClie;
        listaClie = clieDao.ListaCliente2(sw, str);
        
        dtm1.setRowCount(0);
        
        for(int i = 0;i<listaClie.size();i++){
            Vector vec = new Vector();
            vec.addElement(listaClie.get(i).getClienteID());
            vec.addElement(listaClie.get(i).getApellidos());
            vec.addElement(listaClie.get(i).getNombres());
            vec.addElement(listaClie.get(i).getEstado());
            dtm1.addRow(vec);
        }
        
    }
    private void llenaCmbMesa(){
        Vector<Mesa> listMesa;
        listMesa = mesaDao.ListaMesa();
        this.cmb_mesa_venta.addItem("");
        for(int i = 0;i<listMesa.size();i++){
            this.cmb_mesa_venta.addItem(listMesa.get(i).getUbic());
        }
    }
    private void llenaCmbEmpleado(){
        Vector<Empleado> listEmp;
        listEmp = empleadoDao.listaEmpleado(false, "");
        this.cmb_empleado_venta.addItem("");
        for(int i = 0;i<listEmp.size();i++){
            this.cmb_empleado_venta.addItem(listEmp.get(i).getApellidos());
        }
    }
    private void llenaCmbMetodoPago(){
        this.cmb_metodo_pago_venta.addItem("");
        this.cmb_metodo_pago_venta.addItem("Efectivo");
        this.cmb_metodo_pago_venta.addItem("Credito");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_opciones_venta = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_buscar_cliente_venta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cliente_venta = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_compras_venta = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_detalle_compras_ventas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rbtn_delivery_venta = new javax.swing.JRadioButton();
        rbtn_llevar_venta = new javax.swing.JRadioButton();
        rbtn_local_venta = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_idCliente_venta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_nombre_venta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_apellido_venta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_direccion_venta = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_telefono_venta = new javax.swing.JTextField();
        btn_crear_nuevo_cliente_venta = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmb_mesa_venta = new javax.swing.JComboBox<>();
        cmb_empleado_venta = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cmb_metodo_pago_venta = new javax.swing.JComboBox<>();
        btn_buscar_cliente_venta = new javax.swing.JButton();
        btn_limpiar_cliente_venta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_id_producto_venta = new javax.swing.JTextField();
        txt_descripcion_venta = new javax.swing.JTextField();
        txt_tipo_producto_venta = new javax.swing.JTextField();
        txt_precio_producto_venta = new javax.swing.JTextField();
        txt_cantidad_producto_venta = new javax.swing.JTextField();
        btn_buscar_producto_venta = new javax.swing.JButton();
        btn_agregar_producto_venta = new javax.swing.JButton();
        btn_registrar_producto_venta = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_producto_venta = new javax.swing.JTable();
        btn_limpiar_producto_venta = new javax.swing.JButton();
        btn_elimina_producto_venta = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FORMULARIO DE VENTAS");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Cliente");

        jLabel3.setText("Buscar");

        txt_buscar_cliente_venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar_cliente_ventaKeyReleased(evt);
            }
        });

        tbl_cliente_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO", "ESTADO"
            }
        ));
        tbl_cliente_venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cliente_ventaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cliente_venta);

        jLabel4.setText("Compras Cliente");

        tbl_compras_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "VENTA", "CLIENTE", "MESA", "FECHA", "METODO PAGO", "TIPO ENTREGA"
            }
        ));
        tbl_compras_venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_compras_ventaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_compras_venta);

        jLabel5.setText("Detalle de Compras");

        tbl_detalle_compras_ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PRODUCTO", "DESCRIPCION", "TIPO", "PRECIO"
            }
        ));
        jScrollPane3.setViewportView(tbl_detalle_compras_ventas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_buscar_cliente_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_buscar_cliente_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buscar Ventas", jPanel2);

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("TIPO ENTREGA");

        grupo_opciones_venta.add(rbtn_delivery_venta);
        rbtn_delivery_venta.setText("Delivery");

        grupo_opciones_venta.add(rbtn_llevar_venta);
        rbtn_llevar_venta.setText("Para llevar");

        grupo_opciones_venta.add(rbtn_local_venta);
        rbtn_local_venta.setText("Comer en el local");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));

        jLabel7.setText("ID CLIENTE");

        txt_idCliente_venta.setEditable(false);

        jLabel8.setText("NOMBRE");

        jLabel9.setText("APELLIDO");

        jLabel10.setText("DIRECCION");

        jLabel11.setText("TELEFONO");

        btn_crear_nuevo_cliente_venta.setText("Crear Nuevo Cliente");
        btn_crear_nuevo_cliente_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crear_nuevo_cliente_ventaActionPerformed(evt);
            }
        });

        jLabel12.setText("MESA");

        jLabel13.setText("EMPLEADO");

        jLabel14.setText("METODO PAGO");

        btn_buscar_cliente_venta.setText("Buscar Cliente");
        btn_buscar_cliente_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_cliente_ventaActionPerformed(evt);
            }
        });

        btn_limpiar_cliente_venta.setText("Limpiar");
        btn_limpiar_cliente_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_cliente_ventaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_crear_nuevo_cliente_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(18, 18, 18)
                            .addComponent(txt_telefono_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(txt_direccion_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_apellido_venta, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txt_nombre_venta)
                            .addComponent(txt_idCliente_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_limpiar_cliente_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmb_metodo_pago_venta, 0, 120, Short.MAX_VALUE))
                                .addComponent(btn_buscar_cliente_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13))
                                    .addGap(41, 41, 41)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmb_mesa_venta, 0, 120, Short.MAX_VALUE)
                                        .addComponent(cmb_empleado_venta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_idCliente_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cmb_mesa_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txt_nombre_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb_empleado_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txt_apellido_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb_metodo_pago_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_direccion_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_telefono_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btn_buscar_cliente_venta)))
                .addGap(18, 18, 18)
                .addComponent(btn_limpiar_cliente_venta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_crear_nuevo_cliente_venta)
                .addGap(38, 38, 38))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Producto"));

        jLabel15.setText("ID PRODUCTO");

        jLabel16.setText("DESCRIPCION");

        jLabel17.setText("TIPO");

        jLabel18.setText("PRECIO");

        jLabel19.setText("CANTIDAD");

        txt_id_producto_venta.setEditable(false);

        btn_buscar_producto_venta.setText("BUSCAR PRODUCTO");
        btn_buscar_producto_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_producto_ventaActionPerformed(evt);
            }
        });

        btn_agregar_producto_venta.setText("AGREGAR PRODUCTO");
        btn_agregar_producto_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_producto_ventaActionPerformed(evt);
            }
        });

        btn_registrar_producto_venta.setText("REGISTRAR ");
        btn_registrar_producto_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrar_producto_ventaActionPerformed(evt);
            }
        });

        tbl_producto_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCION", "TIPO", "PRECIO", "CANTIDAD"
            }
        ));
        tbl_producto_venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_producto_ventaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_producto_venta);

        btn_limpiar_producto_venta.setText("LIMPIAR");
        btn_limpiar_producto_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_producto_ventaActionPerformed(evt);
            }
        });

        btn_elimina_producto_venta.setText("ELIMINAR");
        btn_elimina_producto_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elimina_producto_ventaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_descripcion_venta, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(txt_tipo_producto_venta)
                                .addComponent(txt_id_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_precio_producto_venta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txt_cantidad_producto_venta, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(btn_limpiar_producto_venta))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_elimina_producto_venta)
                                .addGap(35, 35, 35))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_agregar_producto_venta)
                                    .addComponent(btn_buscar_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_registrar_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_id_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar_producto_venta))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_descripcion_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar_producto_venta))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_tipo_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_precio_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_agregar_producto_venta))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_cantidad_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_elimina_producto_venta))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_registrar_producto_venta, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(43, 43, 43)
                        .addComponent(rbtn_delivery_venta)
                        .addGap(29, 29, 29)
                        .addComponent(rbtn_llevar_venta)
                        .addGap(30, 30, 30)
                        .addComponent(rbtn_local_venta)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rbtn_delivery_venta)
                            .addComponent(rbtn_llevar_venta)
                            .addComponent(rbtn_local_venta))
                        .addGap(29, 29, 29)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ventas", jPanel3);

        jButton7.setText("SALIR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(420, 420, 420)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1085, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_limpiar_producto_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_producto_ventaActionPerformed
        this.limpiaDet();
        this.habilitaProducto(false);
    }//GEN-LAST:event_btn_limpiar_producto_ventaActionPerformed

    private void btn_crear_nuevo_cliente_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crear_nuevo_cliente_ventaActionPerformed

        CrearCliente abrir = new CrearCliente(new javax.swing.JFrame(), true);
        abrir.setVisible(true);
    }//GEN-LAST:event_btn_crear_nuevo_cliente_ventaActionPerformed

    private void btn_buscar_cliente_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_cliente_ventaActionPerformed
        Cliente clie;
       
        SelCliente dialog = new SelCliente(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        clie = dialog.devuelveCliente();
        if(clie.getClienteID()!=0){
            this.habilitaCliente(true);
            this.limpiaCab();
            this.limpiaDet();
            dtm4.setRowCount(0);
            this.txt_idCliente_venta.setText(String.valueOf(clie.getClienteID()));
            this.txt_apellido_venta.setText(clie.getApellidos());
            this.txt_nombre_venta.setText(clie.getNombres());
            this.txt_direccion_venta.setText(clie.getDireccion().toString());
            this.txt_telefono_venta.setText(String.valueOf(clie.getTelefono()));  
        }else{
            this.habilitaCliente(false);
        }
    }//GEN-LAST:event_btn_buscar_cliente_ventaActionPerformed

    private void btn_buscar_producto_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_producto_ventaActionPerformed
        Producto p;
        
        SelProducto dialog = new SelProducto(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        p = dialog.devProd();
        if(p.getProductoID()!=0){
            this.habilitaProducto(true);
            this.txt_id_producto_venta.setText(String.valueOf(p.getProductoID()));
            this.txt_descripcion_venta.setText(p.getDescripProducto());
            this.txt_tipo_producto_venta.setText(String.valueOf(p.getIdtipo()));
            this.txt_precio_producto_venta.setText(String.valueOf(p.getPrecioUnit()));  
        }else{
            this.habilitaProducto(false);
        }
    }//GEN-LAST:event_btn_buscar_producto_ventaActionPerformed

    private void btn_agregar_producto_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_producto_ventaActionPerformed
        if(this.txt_id_producto_venta.getText().isEmpty() || this.txt_cantidad_producto_venta.getText().isEmpty() || this.cmb_empleado_venta.getSelectedItem().toString().isEmpty() || this.cmb_metodo_pago_venta.getSelectedItem().toString().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe selecionara el producto, registrar la cantidad, seleccionar el empleado y el metodo de pago");
        }else{    
            Vector vec = new Vector();
            
            vec.addElement(this.txt_id_producto_venta.getText());
            vec.addElement(this.txt_descripcion_venta.getText());
            vec.addElement(this.txt_tipo_producto_venta.getText());
            vec.addElement(this.txt_precio_producto_venta.getText());
            vec.addElement(this.txt_cantidad_producto_venta.getText());
            
            dtm4.addRow(vec);
            limpiaDet();
        }
    }//GEN-LAST:event_btn_agregar_producto_ventaActionPerformed

    private void btn_registrar_producto_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrar_producto_ventaActionPerformed
        if(this.txt_idCliente_venta.getText().isEmpty() || dtm4.getRowCount() == 0 || this.rbtn_local_venta.isSelected() == false && this.rbtn_delivery_venta.isSelected() == false && this.rbtn_llevar_venta.isSelected() == false){
            JOptionPane.showMessageDialog(this, "Debe selecionarar el tipo de entrega, un cliente y por lo menos un producto");
        }else{
            VentaDao v = new VentaDao();
            CabOrdenDeVenta cv = new CabOrdenDeVenta();
            int idGenera = u.idNext("CabOrdenDeVenta", "OrdenDeVentaID");
            cv.setOrdenDeVentaID(idGenera);
            cv.setEmpleadoID(Integer.parseInt(u.cadExp("Empleado", "apellidos", "empleadoID",this.cmb_empleado_venta.getSelectedItem().toString())));
            cv.setClienteID(Integer.parseInt(this.txt_idCliente_venta.getText()));
            cv.setMesaID(Integer.parseInt(u.cadExp("Mesa", "ubic", "mesaID",this.cmb_mesa_venta.getSelectedItem().toString())));
            cv.setFechaVenta(u.obtenerFecha());
            if(this.cmb_metodo_pago_venta.getSelectedItem().equals("Efectivo")){
                cv.setMetodoPago(1);
            }else{
                cv.setMetodoPago(0);
            }
            if(this.rbtn_delivery_venta.isSelected()){
                cv.setTipEntrega("Delivery");
            }else if(this.rbtn_llevar_venta.isSelected()){
                cv.setTipEntrega("Para Llevar");
            }else{
                cv.setTipEntrega("Para Local");
            }
            v.insertaCabVenta(cv);
            
            for (int i = 0; i < dtm4.getRowCount(); i++) {
                DetOrdenDeVenta dv = new DetOrdenDeVenta(); // Crear un nuevo objeto en cada iteración

                dv.setOrdenDeVentaID(idGenera);

                // Obtener y validar el ProductoID
                Object prodObj = dtm4.getValueAt(i, 0);
                int productoID = (prodObj != null) ? Integer.parseInt(prodObj.toString()) : 0;
                dv.setProductoID(productoID);

                dv.setIdPedidos(900);

                // Obtener y validar la cantidad
                Object cantObj = dtm4.getValueAt(i, 4);
                int cantidad = (cantObj != null) ? Integer.parseInt(cantObj.toString()) : 0;
                dv.setCantidad(cantidad);

                // Insertar el detalle de venta en la base de datos
                v.insertaDetVenta(dv);
            }

            this.limpiaCab();
            this.limpiaDet();
            this.habilitaCliente(false);
            this.habilitaProducto(false);
            dtm4.setRowCount(0);
        }
    }//GEN-LAST:event_btn_registrar_producto_ventaActionPerformed

    private void txt_buscar_cliente_ventaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_cliente_ventaKeyReleased
        if(this.txt_buscar_cliente_venta.getText().isEmpty()){
            llenaTblCliente(false, "");
        }else{
            llenaTblCliente(true, this.txt_buscar_cliente_venta.getText());
        }
    }//GEN-LAST:event_txt_buscar_cliente_ventaKeyReleased

    private void tbl_cliente_ventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cliente_ventaMouseClicked
        int idx;
        String cad;
        
        idx = this.tbl_cliente_venta.getSelectedRow();
        cad = dtm1.getValueAt(idx, 0).toString();
        
        llenaCompraCliente(true,cad);
    }//GEN-LAST:event_tbl_cliente_ventaMouseClicked

    private void tbl_compras_ventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_compras_ventaMouseClicked
        if(this.dtm2.getRowCount()!=0){
            int idx;
            String cad;
            idx = this.tbl_compras_venta.getSelectedRow();
            cad = dtm2.getValueAt(idx, 0).toString();
            llenaDetCompraCliente(true,cad);   
        }
    }//GEN-LAST:event_tbl_compras_ventaMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btn_limpiar_cliente_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_cliente_ventaActionPerformed
        this.habilitaCliente(false);
        this.limpiaCab();
    }//GEN-LAST:event_btn_limpiar_cliente_ventaActionPerformed

    private void btn_elimina_producto_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elimina_producto_ventaActionPerformed
        int idx;
        idx = this.tbl_producto_venta.getSelectedRow();
        if(idx!=1){
            dtm4.removeRow(idx);
        }else{
            JOptionPane.showMessageDialog(null, "Falta seleccionar fila.");
        }
    }//GEN-LAST:event_btn_elimina_producto_ventaActionPerformed

    private void tbl_producto_ventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_producto_ventaMouseClicked

    }//GEN-LAST:event_tbl_producto_ventaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar_producto_venta;
    private javax.swing.JButton btn_buscar_cliente_venta;
    private javax.swing.JButton btn_buscar_producto_venta;
    private javax.swing.JButton btn_crear_nuevo_cliente_venta;
    private javax.swing.JButton btn_elimina_producto_venta;
    private javax.swing.JButton btn_limpiar_cliente_venta;
    private javax.swing.JButton btn_limpiar_producto_venta;
    private javax.swing.JButton btn_registrar_producto_venta;
    private javax.swing.JComboBox<String> cmb_empleado_venta;
    private javax.swing.JComboBox<String> cmb_mesa_venta;
    private javax.swing.JComboBox<String> cmb_metodo_pago_venta;
    private javax.swing.ButtonGroup grupo_opciones_venta;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbtn_delivery_venta;
    private javax.swing.JRadioButton rbtn_llevar_venta;
    private javax.swing.JRadioButton rbtn_local_venta;
    private javax.swing.JTable tbl_cliente_venta;
    private javax.swing.JTable tbl_compras_venta;
    private javax.swing.JTable tbl_detalle_compras_ventas;
    private javax.swing.JTable tbl_producto_venta;
    private javax.swing.JTextField txt_apellido_venta;
    private javax.swing.JTextField txt_buscar_cliente_venta;
    private javax.swing.JTextField txt_cantidad_producto_venta;
    private javax.swing.JTextField txt_descripcion_venta;
    private javax.swing.JTextField txt_direccion_venta;
    private javax.swing.JTextField txt_idCliente_venta;
    private javax.swing.JTextField txt_id_producto_venta;
    private javax.swing.JTextField txt_nombre_venta;
    private javax.swing.JTextField txt_precio_producto_venta;
    private javax.swing.JTextField txt_telefono_venta;
    private javax.swing.JTextField txt_tipo_producto_venta;
    // End of variables declaration//GEN-END:variables
}
