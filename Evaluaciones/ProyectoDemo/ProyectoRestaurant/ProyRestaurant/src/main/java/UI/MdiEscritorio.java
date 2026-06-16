
package UI;

import BEAN.LocalR;
import DAO.LocalDao;
import DAO.UsuarioDao;
import DAO.inciaBdDao;
import UTIL.DbBean;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class MdiEscritorio extends javax.swing.JFrame {
    
    UsuarioDao us = new UsuarioDao();
    FrmContrato fContrato;
    FrmContratoPorFechas frmContratoFechas;
    FrmContratoPorArea frmPorArea;
    FrmArea frmArea;
    FrmRol frmRol;
    FrmProducto frmProdu;
    FrmContratoPorRol frmPorRol;
    FrmRepProdRango frmProdRango;
    FrmInsumo frmInsumo;
    FrmInsumoPorPrecioUnitario frmInsuPrecio;
    Compartir compartir;
    FrmVenta frmVenta;
    OrdenCompra frmOrdenCompra;
    FrmUsuario frmUser;
    
    LocalDao lDao = new LocalDao();
    
    public MdiEscritorio(int n) {
        
        initComponents();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        
        
        if (n == 1){
            
            JOptionPane.showMessageDialog(null, "MODO ADMINISTRAR " );
        
        }else if(n == 2){
        
            JOptionPane.showMessageDialog(null, "MODO MANTENIMIENTO " );
            this.mnu_admin.setVisible(false);
            this.mnu_reportes.setVisible(false);
            this.mnu_reportes_parametro.setVisible(false);
            this.mnu_transaccion_control.setVisible(false);
            this.mnu_tablas_cruzada.setVisible(false);
        
        }else if (n ==3){
            JOptionPane.showMessageDialog(null, "MODO REPORTES " );
            this.mnu_admin.setVisible(false);
            this.mnu_transaccion_control.setVisible(false);
            this.mnu_mantenimiento.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "MODO TRANSACCION " );
            this.mnu_admin.setVisible(false);
            this.mnu_mantenimiento.setVisible(false);
            this.mnu_reportes.setVisible(false);
            this.mnu_reportes_parametro.setVisible(false);
            this.mnu_tablas_cruzada.setVisible(false);
        }
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        mnu_admin = new javax.swing.JMenu();
        mnuItem_agrega_usuario = new javax.swing.JMenuItem();
        mnuItem_completa_bd = new javax.swing.JMenuItem();
        mnu_mantenimiento = new javax.swing.JMenu();
        mnuItem_mante_contrato = new javax.swing.JMenuItem();
        mnuItem_mante_rol = new javax.swing.JMenuItem();
        mnuItem_mante_area = new javax.swing.JMenuItem();
        mnuItem_mante_producto = new javax.swing.JMenuItem();
        mnuItem_mante_insumo = new javax.swing.JMenuItem();
        mnu_reportes = new javax.swing.JMenu();
        mnuItem_reporte_contrato = new javax.swing.JMenuItem();
        mnuItem_reporte_area = new javax.swing.JMenuItem();
        mnuItem_reporte_rol = new javax.swing.JMenuItem();
        mnuItem_reporte_producto = new javax.swing.JMenuItem();
        mnuItem_reporte_insumo = new javax.swing.JMenuItem();
        mnu_reportes_parametro = new javax.swing.JMenu();
        mnuItem_repPara_contrato_fecha = new javax.swing.JMenuItem();
        mnuItem_repPara_contrato_area = new javax.swing.JMenuItem();
        mnuItem_repPara_contrato_rol = new javax.swing.JMenuItem();
        mnu_repPara_producto_precio = new javax.swing.JMenuItem();
        mnu_repPara_insumo_precio = new javax.swing.JMenuItem();
        mnu_tablas_cruzada = new javax.swing.JMenu();
        mnu_tablas_producto_tipoPlato = new javax.swing.JMenuItem();
        mnuItem_tablas_contrato_area = new javax.swing.JMenuItem();
        mnuItem_tablas_usuario_ubicacion = new javax.swing.JMenuItem();
        mnu_correo_general = new javax.swing.JMenu();
        mnuItem_correo_gmail = new javax.swing.JMenuItem();
        mnu_redes = new javax.swing.JMenu();
        mnuItem_redes_facebook = new javax.swing.JMenuItem();
        mnuItem_redes_instagram = new javax.swing.JMenuItem();
        mnuItem_redes_x = new javax.swing.JMenuItem();
        mnu_transaccion_control = new javax.swing.JMenu();
        mnuItem_tranControl_venta = new javax.swing.JMenuItem();
        mnuItem_tranControl_controlInventario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnu_admin.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\admin.jpg")); // NOI18N
        mnu_admin.setMnemonic('f');
        mnu_admin.setText("Administrador");

        mnuItem_agrega_usuario.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\añadirUsuario.jpg")); // NOI18N
        mnuItem_agrega_usuario.setMnemonic('o');
        mnuItem_agrega_usuario.setText("Agregar Usuarios");
        mnuItem_agrega_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_agrega_usuarioActionPerformed(evt);
            }
        });
        mnu_admin.add(mnuItem_agrega_usuario);

        mnuItem_completa_bd.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\bd.jpg")); // NOI18N
        mnuItem_completa_bd.setMnemonic('s');
        mnuItem_completa_bd.setText("Completar BD por Defecto");
        mnuItem_completa_bd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_completa_bdActionPerformed(evt);
            }
        });
        mnu_admin.add(mnuItem_completa_bd);

        menuBar.add(mnu_admin);

        mnu_mantenimiento.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\mantenimiento.jpg")); // NOI18N
        mnu_mantenimiento.setMnemonic('e');
        mnu_mantenimiento.setText("Mantenimiento");

        mnuItem_mante_contrato.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\contrato.jpg")); // NOI18N
        mnuItem_mante_contrato.setMnemonic('t');
        mnuItem_mante_contrato.setText("Contrato");
        mnuItem_mante_contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_mante_contratoActionPerformed(evt);
            }
        });
        mnu_mantenimiento.add(mnuItem_mante_contrato);

        mnuItem_mante_rol.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\rol.jpg")); // NOI18N
        mnuItem_mante_rol.setMnemonic('y');
        mnuItem_mante_rol.setText("Rol");
        mnuItem_mante_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_mante_rolActionPerformed(evt);
            }
        });
        mnu_mantenimiento.add(mnuItem_mante_rol);

        mnuItem_mante_area.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\area.jpg")); // NOI18N
        mnuItem_mante_area.setMnemonic('p');
        mnuItem_mante_area.setText("Area");
        mnuItem_mante_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_mante_areaActionPerformed(evt);
            }
        });
        mnu_mantenimiento.add(mnuItem_mante_area);

        mnuItem_mante_producto.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\producto.jpg")); // NOI18N
        mnuItem_mante_producto.setMnemonic('d');
        mnuItem_mante_producto.setText("Producto");
        mnuItem_mante_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_mante_productoActionPerformed(evt);
            }
        });
        mnu_mantenimiento.add(mnuItem_mante_producto);

        mnuItem_mante_insumo.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\insumo.jpg")); // NOI18N
        mnuItem_mante_insumo.setText("Insumo");
        mnuItem_mante_insumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_mante_insumoActionPerformed(evt);
            }
        });
        mnu_mantenimiento.add(mnuItem_mante_insumo);

        menuBar.add(mnu_mantenimiento);

        mnu_reportes.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\reportes.jpg")); // NOI18N
        mnu_reportes.setMnemonic('h');
        mnu_reportes.setText("Reportes");

        mnuItem_reporte_contrato.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\contrato.jpg")); // NOI18N
        mnuItem_reporte_contrato.setMnemonic('c');
        mnuItem_reporte_contrato.setText("Reporte Contrato");
        mnuItem_reporte_contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_reporte_contratoActionPerformed(evt);
            }
        });
        mnu_reportes.add(mnuItem_reporte_contrato);

        mnuItem_reporte_area.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\area.jpg")); // NOI18N
        mnuItem_reporte_area.setMnemonic('a');
        mnuItem_reporte_area.setText("Reporte Area");
        mnuItem_reporte_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_reporte_areaActionPerformed(evt);
            }
        });
        mnu_reportes.add(mnuItem_reporte_area);

        mnuItem_reporte_rol.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\rol.jpg")); // NOI18N
        mnuItem_reporte_rol.setText("Reporte Rol");
        mnuItem_reporte_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_reporte_rolActionPerformed(evt);
            }
        });
        mnu_reportes.add(mnuItem_reporte_rol);

        mnuItem_reporte_producto.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\producto.jpg")); // NOI18N
        mnuItem_reporte_producto.setText("Reporte Producto");
        mnuItem_reporte_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_reporte_productoActionPerformed(evt);
            }
        });
        mnu_reportes.add(mnuItem_reporte_producto);

        mnuItem_reporte_insumo.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\insumo.jpg")); // NOI18N
        mnuItem_reporte_insumo.setText("Reporte Insumo");
        mnuItem_reporte_insumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_reporte_insumoActionPerformed(evt);
            }
        });
        mnu_reportes.add(mnuItem_reporte_insumo);

        menuBar.add(mnu_reportes);

        mnu_reportes_parametro.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\repParametros.jpg")); // NOI18N
        mnu_reportes_parametro.setText("Reporte Con Parametros");

        mnuItem_repPara_contrato_fecha.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\tiempo.jpg")); // NOI18N
        mnuItem_repPara_contrato_fecha.setText("Contrato por Fecha");
        mnuItem_repPara_contrato_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_repPara_contrato_fechaActionPerformed(evt);
            }
        });
        mnu_reportes_parametro.add(mnuItem_repPara_contrato_fecha);

        mnuItem_repPara_contrato_area.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\area.jpg")); // NOI18N
        mnuItem_repPara_contrato_area.setText("Contrato por Area");
        mnuItem_repPara_contrato_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_repPara_contrato_areaActionPerformed(evt);
            }
        });
        mnu_reportes_parametro.add(mnuItem_repPara_contrato_area);

        mnuItem_repPara_contrato_rol.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\rol.jpg")); // NOI18N
        mnuItem_repPara_contrato_rol.setText("Contrato por Rol");
        mnuItem_repPara_contrato_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_repPara_contrato_rolActionPerformed(evt);
            }
        });
        mnu_reportes_parametro.add(mnuItem_repPara_contrato_rol);

        mnu_repPara_producto_precio.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\producto.jpg")); // NOI18N
        mnu_repPara_producto_precio.setText("Producto por  Precio");
        mnu_repPara_producto_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_repPara_producto_precioActionPerformed(evt);
            }
        });
        mnu_reportes_parametro.add(mnu_repPara_producto_precio);

        mnu_repPara_insumo_precio.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\insumo.jpg")); // NOI18N
        mnu_repPara_insumo_precio.setText("Insumo por Precio");
        mnu_repPara_insumo_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_repPara_insumo_precioActionPerformed(evt);
            }
        });
        mnu_reportes_parametro.add(mnu_repPara_insumo_precio);

        menuBar.add(mnu_reportes_parametro);

        mnu_tablas_cruzada.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\tablacruzada.jpg")); // NOI18N
        mnu_tablas_cruzada.setText("Tablas Cruzadas");

        mnu_tablas_producto_tipoPlato.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\producto.jpg")); // NOI18N
        mnu_tablas_producto_tipoPlato.setText("Producto - Tipo Plato");
        mnu_tablas_producto_tipoPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_tablas_producto_tipoPlatoActionPerformed(evt);
            }
        });
        mnu_tablas_cruzada.add(mnu_tablas_producto_tipoPlato);

        mnuItem_tablas_contrato_area.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\contrato.jpg")); // NOI18N
        mnuItem_tablas_contrato_area.setText("Contrato - Area");
        mnuItem_tablas_contrato_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_tablas_contrato_areaActionPerformed(evt);
            }
        });
        mnu_tablas_cruzada.add(mnuItem_tablas_contrato_area);

        mnuItem_tablas_usuario_ubicacion.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\Ubicacion.jpg")); // NOI18N
        mnuItem_tablas_usuario_ubicacion.setText("Tipo Usuario - Ubicacion");
        mnuItem_tablas_usuario_ubicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_tablas_usuario_ubicacionActionPerformed(evt);
            }
        });
        mnu_tablas_cruzada.add(mnuItem_tablas_usuario_ubicacion);

        menuBar.add(mnu_tablas_cruzada);

        mnu_correo_general.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\correo.jpg")); // NOI18N
        mnu_correo_general.setText("Correo General");

        mnuItem_correo_gmail.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\Gmail.jpg")); // NOI18N
        mnuItem_correo_gmail.setText("GMAIL");
        mnuItem_correo_gmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_correo_gmailActionPerformed(evt);
            }
        });
        mnu_correo_general.add(mnuItem_correo_gmail);

        menuBar.add(mnu_correo_general);

        mnu_redes.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\redes.jpg")); // NOI18N
        mnu_redes.setText("Redes");

        mnuItem_redes_facebook.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\Facebook.jpg")); // NOI18N
        mnuItem_redes_facebook.setText("Facebook");
        mnuItem_redes_facebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_redes_facebookActionPerformed(evt);
            }
        });
        mnu_redes.add(mnuItem_redes_facebook);

        mnuItem_redes_instagram.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\Instagram.jpg")); // NOI18N
        mnuItem_redes_instagram.setText("Instagram");
        mnuItem_redes_instagram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_redes_instagramActionPerformed(evt);
            }
        });
        mnu_redes.add(mnuItem_redes_instagram);

        mnuItem_redes_x.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\x.png")); // NOI18N
        mnuItem_redes_x.setText("X");
        mnuItem_redes_x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_redes_xActionPerformed(evt);
            }
        });
        mnu_redes.add(mnuItem_redes_x);

        menuBar.add(mnu_redes);

        mnu_transaccion_control.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\transaccion.jpg")); // NOI18N
        mnu_transaccion_control.setText("Transacciones y Control");

        mnuItem_tranControl_venta.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\venta.jpg")); // NOI18N
        mnuItem_tranControl_venta.setText("Venta");
        mnuItem_tranControl_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_tranControl_ventaActionPerformed(evt);
            }
        });
        mnu_transaccion_control.add(mnuItem_tranControl_venta);

        mnuItem_tranControl_controlInventario.setIcon(new javax.swing.ImageIcon("C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\IMAGENES\\inventario.jpg")); // NOI18N
        mnuItem_tranControl_controlInventario.setText("Control de Inventario");
        mnuItem_tranControl_controlInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItem_tranControl_controlInventarioActionPerformed(evt);
            }
        });
        mnu_transaccion_control.add(mnuItem_tranControl_controlInventario);

        menuBar.add(mnu_transaccion_control);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuItem_mante_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_mante_productoActionPerformed
        frmProdu = new FrmProducto();
        this.desktopPane.add(frmProdu);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = frmProdu.getSize();
        frmProdu.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        frmProdu.setVisible(true); 
    }//GEN-LAST:event_mnuItem_mante_productoActionPerformed

    private void mnuItem_reporte_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_reporte_rolActionPerformed
        try{
            String r = "C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\REPORTES\\repRolSimple.jasper";
            DbBean db = new DbBean();
            db.connectRep(r, null, false);
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(JRException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_mnuItem_reporte_rolActionPerformed

    private void mnuItem_agrega_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_agrega_usuarioActionPerformed
        frmUser = new FrmUsuario();
        this.desktopPane.add(frmUser);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = frmUser.getSize();
        frmUser.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        frmUser.setVisible(true);
    }//GEN-LAST:event_mnuItem_agrega_usuarioActionPerformed

    private void mnuItem_completa_bdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_completa_bdActionPerformed
        inciaBdDao ini = new inciaBdDao();
        Vector<LocalR> listaLocal = new Vector<LocalR>();
        listaLocal = lDao.listaLocal();
        int id=0;
        for (int i =0; i<listaLocal.size();i++){
            id = listaLocal.get(i).getIdLocalR();
        }
        
        ini.completaBD(id);
        
        JOptionPane.showMessageDialog(null, "BD CORRECTAMENTE COMPLETADA...");
    }//GEN-LAST:event_mnuItem_completa_bdActionPerformed

    private void mnuItem_mante_contratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_mante_contratoActionPerformed
        fContrato = new FrmContrato();
        this.desktopPane.add(fContrato);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = fContrato.getSize();
        fContrato.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        fContrato.setVisible(true);
    }//GEN-LAST:event_mnuItem_mante_contratoActionPerformed

    private void mnuItem_mante_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_mante_rolActionPerformed
        frmRol = new FrmRol();
        this.desktopPane.add(frmRol);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = frmRol.getSize();
        frmRol.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        frmRol.setVisible(true);  
    }//GEN-LAST:event_mnuItem_mante_rolActionPerformed

    private void mnuItem_mante_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_mante_areaActionPerformed
        frmArea = new FrmArea();
        this.desktopPane.add(frmArea);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = frmArea.getSize();
        frmArea.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        frmArea.setVisible(true); 
    }//GEN-LAST:event_mnuItem_mante_areaActionPerformed

    private void mnuItem_mante_insumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_mante_insumoActionPerformed
        frmInsumo = new FrmInsumo();
        this.desktopPane.add(frmInsumo);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = frmInsumo.getSize();
        frmInsumo.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        frmInsumo.setVisible(true); 
    }//GEN-LAST:event_mnuItem_mante_insumoActionPerformed

    private void mnuItem_reporte_contratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_reporte_contratoActionPerformed
        String r = "C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\REPORTES\\repContratoSimple.jasper";
        DbBean db = new DbBean();
        try {
            db.connectRep(r, null, false);
        } catch (SQLException ex) {
            Logger.getLogger(MdiEscritorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(MdiEscritorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuItem_reporte_contratoActionPerformed

    private void mnuItem_reporte_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_reporte_areaActionPerformed
        try{
            String r = "C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\REPORTES\\repAreaSimple.jasper";
            DbBean db = new DbBean();
            db.connectRep(r, null, false);
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(JRException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_mnuItem_reporte_areaActionPerformed

    private void mnuItem_reporte_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_reporte_productoActionPerformed
        try{
            String r = "C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\REPORTES\\reportProdSimp.jasper";
            DbBean db = new DbBean();
            db.connectRep(r, null, false);
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(JRException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_mnuItem_reporte_productoActionPerformed

    private void mnuItem_reporte_insumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_reporte_insumoActionPerformed
        try{
            String r = "C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\REPORTES\\repInsSimp.jasper";
            DbBean db = new DbBean();
            db.connectRep(r, null, false);
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(JRException ex){
            ex.printStackTrace();
        } 
    }//GEN-LAST:event_mnuItem_reporte_insumoActionPerformed

    private void mnuItem_repPara_contrato_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_repPara_contrato_fechaActionPerformed
        frmContratoFechas = new FrmContratoPorFechas();
        this.desktopPane.add(frmContratoFechas);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = frmContratoFechas.getSize();
        frmContratoFechas.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        frmContratoFechas.setVisible(true);
    }//GEN-LAST:event_mnuItem_repPara_contrato_fechaActionPerformed

    private void mnuItem_repPara_contrato_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_repPara_contrato_areaActionPerformed
        frmPorArea = new FrmContratoPorArea();
        this.desktopPane.add(frmPorArea);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = frmPorArea.getSize();
        frmPorArea.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        frmPorArea.setVisible(true);
    }//GEN-LAST:event_mnuItem_repPara_contrato_areaActionPerformed

    private void mnuItem_repPara_contrato_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_repPara_contrato_rolActionPerformed
        frmPorRol = new FrmContratoPorRol();
        this.desktopPane.add(frmPorRol);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = frmPorRol.getSize();
        frmPorRol.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        frmPorRol.setVisible(true);
    }//GEN-LAST:event_mnuItem_repPara_contrato_rolActionPerformed

    private void mnu_repPara_producto_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_repPara_producto_precioActionPerformed
        frmProdRango = new FrmRepProdRango();
        this.desktopPane.add(frmProdRango);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = frmProdRango.getSize();
        frmProdRango.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        frmProdRango.setVisible(true);
    }//GEN-LAST:event_mnu_repPara_producto_precioActionPerformed

    private void mnu_repPara_insumo_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_repPara_insumo_precioActionPerformed
        frmInsuPrecio = new FrmInsumoPorPrecioUnitario();
        this.desktopPane.add(frmInsuPrecio);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = frmInsuPrecio.getSize();
        frmInsuPrecio.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        frmInsuPrecio.setVisible(true);
    }//GEN-LAST:event_mnu_repPara_insumo_precioActionPerformed

    private void mnu_tablas_producto_tipoPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_tablas_producto_tipoPlatoActionPerformed
        try{
            String r = "C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\REPORTES\\reporTblCruzProd.jasper";
            DbBean db = new DbBean();
            db.connectRep(r, null, false);
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(JRException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_mnu_tablas_producto_tipoPlatoActionPerformed

    private void mnuItem_tablas_contrato_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_tablas_contrato_areaActionPerformed
        try{
            String r = "C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\REPORTES\\reportContratoTblCruz.jasper";
            DbBean db = new DbBean();
            db.connectRep(r, null, false);
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(JRException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_mnuItem_tablas_contrato_areaActionPerformed

    private void mnuItem_tablas_usuario_ubicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_tablas_usuario_ubicacionActionPerformed
        try{
            String r = "C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\REPORTES\\reportTblCruzUsuarios.jasper";
            DbBean db = new DbBean();
            db.connectRep(r, null, false);
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(JRException ex){
            ex.printStackTrace();
        }  
    }//GEN-LAST:event_mnuItem_tablas_usuario_ubicacionActionPerformed

    private void mnuItem_correo_gmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_correo_gmailActionPerformed
        compartir = new Compartir();
        this.desktopPane.add(compartir);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = compartir.getSize();
        compartir.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        compartir.setVisible(true);
    }//GEN-LAST:event_mnuItem_correo_gmailActionPerformed

    private void mnuItem_redes_facebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_redes_facebookActionPerformed
        if(Desktop.isDesktopSupported()){
            Desktop desk = Desktop.getDesktop();
            if(desk.isSupported(Desktop.Action.BROWSE)){
                try {
                    desk.browse(new URI("https://www.facebook.com/groups/1237922966896488"));
                } catch (URISyntaxException ex) {
                    Logger.getLogger(MdiEscritorio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MdiEscritorio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }//GEN-LAST:event_mnuItem_redes_facebookActionPerformed

    private void mnuItem_redes_instagramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_redes_instagramActionPerformed
        if(Desktop.isDesktopSupported()){
            Desktop desk = Desktop.getDesktop();
            if(desk.isSupported(Desktop.Action.BROWSE)){
                try{
                    desk.browse(new URI("https://www.instagram.com/restaurantepoo/"));
                }catch(IOException e){
                    e.printStackTrace();
                }catch(URISyntaxException e){

                }
            }

        }
    }//GEN-LAST:event_mnuItem_redes_instagramActionPerformed

    private void mnuItem_redes_xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_redes_xActionPerformed
        if(Desktop.isDesktopSupported()){
            Desktop desk = Desktop.getDesktop();
            if(desk.isSupported(Desktop.Action.BROWSE)){
                try{
                    desk.browse(new URI("https://twitter.com/POORestaurante_"));
                }catch(IOException e){
                    e.printStackTrace();
                }catch(URISyntaxException e){

                }
            }

        }
    }//GEN-LAST:event_mnuItem_redes_xActionPerformed

    private void mnuItem_tranControl_controlInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_tranControl_controlInventarioActionPerformed
        frmOrdenCompra = new OrdenCompra();
        this.desktopPane.add(frmOrdenCompra);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = frmOrdenCompra.getSize();
        frmOrdenCompra.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        frmOrdenCompra.setVisible(true);
    }//GEN-LAST:event_mnuItem_tranControl_controlInventarioActionPerformed

    private void mnuItem_tranControl_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_tranControl_ventaActionPerformed
        frmVenta = new FrmVenta();
        this.desktopPane.add(frmVenta);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = frmVenta.getSize();
        frmVenta.setLocation((pantalla.width-ventana.width)/2, (pantalla.height-ventana.height)/2);
        frmVenta.setVisible(true);
    }//GEN-LAST:event_mnuItem_tranControl_ventaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnuItem_agrega_usuario;
    private javax.swing.JMenuItem mnuItem_completa_bd;
    private javax.swing.JMenuItem mnuItem_correo_gmail;
    private javax.swing.JMenuItem mnuItem_mante_area;
    private javax.swing.JMenuItem mnuItem_mante_contrato;
    private javax.swing.JMenuItem mnuItem_mante_insumo;
    private javax.swing.JMenuItem mnuItem_mante_producto;
    private javax.swing.JMenuItem mnuItem_mante_rol;
    private javax.swing.JMenuItem mnuItem_redes_facebook;
    private javax.swing.JMenuItem mnuItem_redes_instagram;
    private javax.swing.JMenuItem mnuItem_redes_x;
    private javax.swing.JMenuItem mnuItem_repPara_contrato_area;
    private javax.swing.JMenuItem mnuItem_repPara_contrato_fecha;
    private javax.swing.JMenuItem mnuItem_repPara_contrato_rol;
    private javax.swing.JMenuItem mnuItem_reporte_area;
    private javax.swing.JMenuItem mnuItem_reporte_contrato;
    private javax.swing.JMenuItem mnuItem_reporte_insumo;
    private javax.swing.JMenuItem mnuItem_reporte_producto;
    private javax.swing.JMenuItem mnuItem_reporte_rol;
    private javax.swing.JMenuItem mnuItem_tablas_contrato_area;
    private javax.swing.JMenuItem mnuItem_tablas_usuario_ubicacion;
    private javax.swing.JMenuItem mnuItem_tranControl_controlInventario;
    private javax.swing.JMenuItem mnuItem_tranControl_venta;
    private javax.swing.JMenu mnu_admin;
    private javax.swing.JMenu mnu_correo_general;
    private javax.swing.JMenu mnu_mantenimiento;
    private javax.swing.JMenu mnu_redes;
    private javax.swing.JMenuItem mnu_repPara_insumo_precio;
    private javax.swing.JMenuItem mnu_repPara_producto_precio;
    private javax.swing.JMenu mnu_reportes;
    private javax.swing.JMenu mnu_reportes_parametro;
    private javax.swing.JMenu mnu_tablas_cruzada;
    private javax.swing.JMenuItem mnu_tablas_producto_tipoPlato;
    private javax.swing.JMenu mnu_transaccion_control;
    // End of variables declaration//GEN-END:variables

}
