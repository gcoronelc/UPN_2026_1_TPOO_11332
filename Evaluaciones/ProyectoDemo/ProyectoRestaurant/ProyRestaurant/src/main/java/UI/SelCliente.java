
package UI;

import BEAN.Cliente;
import DAO.ClienteDao;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

public class SelCliente extends javax.swing.JDialog {
    ClienteDao clieDao;
    DefaultTableModel dtm;
    Cliente clie;
    FrmVenta fv = new FrmVenta();
    public SelCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clieDao = new ClienteDao();
        clie = new Cliente();
        this.setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dtm = new DefaultTableModel(new Object[] {"ID", "Nombres", "Apellidos", "Direccion", "Telefono", "Estado"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tbl_cliente_selCliente.setModel(dtm);
        llenaTblClientes(false, "");
    }
    public Cliente devuelveCliente(){
        return clie;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_buscar_cliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cliente_selCliente = new javax.swing.JTable();
        btn_selCliente_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("BUSCAR CLIENTE");

        jLabel2.setText("CLIENTE");

        txt_buscar_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar_clienteKeyReleased(evt);
            }
        });

        tbl_cliente_selCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombres", "Apellidos", "Direccion", "Telefono", "Estado"
            }
        ));
        tbl_cliente_selCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cliente_selClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cliente_selCliente);

        btn_selCliente_salir.setText("SALIR");
        btn_selCliente_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selCliente_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_selCliente_salir)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_selCliente_salir)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscar_clienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_clienteKeyReleased
        if(this.txt_buscar_cliente.getText().isEmpty()){
            this.llenaTblClientes(false, "");
        }else{
            this.llenaTblClientes(true, this.txt_buscar_cliente.getText());
        }
    }//GEN-LAST:event_txt_buscar_clienteKeyReleased

    private void tbl_cliente_selClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cliente_selClienteMouseClicked
        int idx;
        idx = this.tbl_cliente_selCliente.getSelectedRow();
        
        clie.setClienteID(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        clie.setApellidos(dtm.getValueAt(idx, 1).toString());
        clie.setNombres(dtm.getValueAt(idx, 2).toString());
        clie.setDireccion(dtm.getValueAt(idx, 3).toString());
        clie.setTelefono(Integer.parseInt(dtm.getValueAt(idx, 4).toString()));
        clie.setEstado(Integer.parseInt(dtm.getValueAt(idx, 5).toString()));
        
        this.dispose();
    }//GEN-LAST:event_tbl_cliente_selClienteMouseClicked

    private void btn_selCliente_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selCliente_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_selCliente_salirActionPerformed
    private void llenaTblClientes(boolean sw, String cad){
        Vector<Cliente> listaClie;
        listaClie = this.clieDao.ListaCliente(sw, cad);
        dtm.setRowCount(0);
        for(int i=0;i<listaClie.size();i++){
            Vector vec = new Vector();
            vec.addElement(listaClie.get(i).getClienteID());
            vec.addElement(listaClie.get(i).getApellidos());
            vec.addElement(listaClie.get(i).getNombres());
            vec.addElement(listaClie.get(i).getDireccion());
            vec.addElement(listaClie.get(i).getTelefono());
            vec.addElement(listaClie.get(i).getEstado());
            
            dtm.addRow(vec);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_selCliente_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_cliente_selCliente;
    private javax.swing.JTextField txt_buscar_cliente;
    // End of variables declaration//GEN-END:variables
}
