
package UI;

import BEAN.Cliente;
import DAO.ClienteDao;
import UTIL.Util;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class CrearCliente extends javax.swing.JDialog {
    ClienteDao clieDao;
    int idCliente;
    Util u = new Util();
    public CrearCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clieDao = new ClienteDao();
        this.txt_id_cliente_registra.setText(Integer.toString(u.idNext("Cliente", "clienteID")));
         this.txt_direccion_regcliente.setText("NULL");
         this.txt_telefono_regcliente.setText("000000000");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.llenaCmbEstado();
        this.llenaCmbEstadoCivil();
        this.llenaCmbGenero();
    }

    private void llenaCmbGenero(){
        this.cmb_genero_regCliente.addItem("");
        this.cmb_genero_regCliente.addItem("Masculino");
        this.cmb_genero_regCliente.addItem("Femenino");
    }
    private void llenaCmbEstado(){
        this.cmb_estado_regCliente.addItem("");
        this.cmb_estado_regCliente.addItem("Activo");
        this.cmb_estado_regCliente.addItem("No Activo");
    }
    private void llenaCmbEstadoCivil(){
        this.cmb_estadoCivil_regCliente.addItem("");
        this.cmb_estadoCivil_regCliente.addItem("Soltero");
        this.cmb_estadoCivil_regCliente.addItem("Casado");
        this.cmb_estadoCivil_regCliente.addItem("Divorciado");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_limpiar_regcliente = new javax.swing.JButton();
        btn_registrar_regcliente = new javax.swing.JButton();
        btn_salir_regcliente = new javax.swing.JButton();
        txt_nombre_regcliente = new javax.swing.JTextField();
        txt_apellidos_regcliente = new javax.swing.JTextField();
        txt_telefono_regcliente = new javax.swing.JTextField();
        txt_direccion_regcliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_id_cliente_registra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_dni_regCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmb_genero_regCliente = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmb_estadoCivil_regCliente = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_correo_regCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_fecha_Nac_regCliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmb_estado_regCliente = new javax.swing.JComboBox<>();
        btn_fecha_seleccion_regCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("REGISTRAR CLIENTE");

        jLabel2.setText("NOMBRE");

        jLabel3.setText("APELLIDOS");

        jLabel4.setText("DIRECCION");

        jLabel5.setText("TELEFONO");

        btn_limpiar_regcliente.setText("LIMPIAR");
        btn_limpiar_regcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_regclienteActionPerformed(evt);
            }
        });

        btn_registrar_regcliente.setText("REGISTRAR");
        btn_registrar_regcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrar_regclienteActionPerformed(evt);
            }
        });

        btn_salir_regcliente.setText("SALIR");
        btn_salir_regcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_regclienteActionPerformed(evt);
            }
        });

        txt_telefono_regcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefono_regclienteActionPerformed(evt);
            }
        });

        txt_direccion_regcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccion_regclienteActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        txt_id_cliente_registra.setEditable(false);

        jLabel7.setText("DNI");

        jLabel8.setText("GENERO");

        jLabel9.setText("ESTADO CIVIL");

        jLabel10.setText("CORREO");

        jLabel11.setText("FECHA NAC.");

        txt_fecha_Nac_regCliente.setEditable(false);

        jLabel12.setText("ESTADO");

        btn_fecha_seleccion_regCliente.setText("FECHA");
        btn_fecha_seleccion_regCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fecha_seleccion_regClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(btn_limpiar_regcliente)))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_registrar_regcliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_salir_regcliente))
                            .addComponent(txt_direccion_regcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txt_nombre_regcliente)
                            .addComponent(txt_apellidos_regcliente)
                            .addComponent(txt_telefono_regcliente)
                            .addComponent(txt_id_cliente_registra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dni_regCliente)
                            .addComponent(cmb_genero_regCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb_estadoCivil_regCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_correo_regCliente)
                            .addComponent(cmb_estado_regCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_fecha_Nac_regCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_fecha_seleccion_regCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))))
                .addGap(92, 92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_id_cliente_registra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nombre_regcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_apellidos_regcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_dni_regCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cmb_genero_regCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_estadoCivil_regCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_telefono_regcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_correo_regCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_fecha_Nac_regCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_fecha_seleccion_regCliente))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cmb_estado_regCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_direccion_regcliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_limpiar_regcliente)
                    .addComponent(btn_registrar_regcliente)
                    .addComponent(btn_salir_regcliente))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private boolean valida() {
        if (txt_nombre_regcliente.getText().trim().isEmpty() ||
            txt_apellidos_regcliente.getText().trim().isEmpty() ||
            txt_dni_regCliente.getText().trim().isEmpty() ||
            cmb_genero_regCliente.getSelectedIndex() == -1 ||
            cmb_estadoCivil_regCliente.getSelectedIndex() == -1 ||
            txt_direccion_regcliente.getText().trim().isEmpty() ||
            txt_correo_regCliente.getText().trim().isEmpty() ||
            txt_fecha_Nac_regCliente.getText().trim().isEmpty() ||
            cmb_estado_regCliente.getSelectedIndex() == -1 ||
            txt_telefono_regcliente.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }
    private void limpia(){
        
        this.txt_nombre_regcliente.setText("");
        this.txt_apellidos_regcliente.setText("");
        this.txt_dni_regCliente.setText("");
        this.cmb_genero_regCliente.setSelectedItem("");
        this.cmb_estado_regCliente.setSelectedItem("");
        this.cmb_estadoCivil_regCliente.setSelectedItem("");
        this.txt_telefono_regcliente.setText("000000000");
        this.txt_direccion_regcliente.setText("NULL");
        this.txt_correo_regCliente.setText("");
        this.txt_fecha_Nac_regCliente.setText("");
        this.txt_id_cliente_registra.setText(Integer.toString(u.idNext("Cliente", "clienteID")));
    }
    private void btn_registrar_regclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrar_regclienteActionPerformed
        if(valida()){
            Util u = new Util();
            Cliente clie = new Cliente();
            idCliente = u.idNext("Cliente", "clienteID");
            clie.setClienteID(idCliente);
            clie.setNombres(this.txt_nombre_regcliente.getText());
            clie.setApellidos(this.txt_apellidos_regcliente.getText());
            clie.setDni(this.txt_dni_regCliente.getText());
            if(this.cmb_genero_regCliente.getSelectedItem().toString().equals("Masculino")){
                clie.setGenero(1);
            }else{
                clie.setGenero(0);
            }
            if(this.cmb_estadoCivil_regCliente.getSelectedItem().equals("Soltero")){
                clie.setEstadoCivil("SOLTERO");
            }else if(this.cmb_estadoCivil_regCliente.getSelectedItem().equals("Casado")){
                clie.setEstadoCivil("CASADO");
            }else{
                clie.setEstadoCivil("DIVORCIADO");
            }
            clie.setTelefono(Integer.parseInt(this.txt_telefono_regcliente.getText()));
            clie.setCorreo(this.txt_correo_regCliente.getText());
            clie.setFechNaci(this.txt_fecha_Nac_regCliente.getText());
            if(this.cmb_estado_regCliente.getSelectedItem().equals("Activo")){
                clie.setEstado(1);
            }else{
                clie.setEstado(0);
            }
            clie.setDireccion(this.txt_direccion_regcliente.getText());
            this.clieDao.procesaItem(clie, "insert");
            this.limpia();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Faltan datos");
        }
    }//GEN-LAST:event_btn_registrar_regclienteActionPerformed

    private void btn_salir_regclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_regclienteActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_regclienteActionPerformed

    private void txt_direccion_regclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccion_regclienteActionPerformed
       
    }//GEN-LAST:event_txt_direccion_regclienteActionPerformed

    private void txt_telefono_regclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefono_regclienteActionPerformed
        
    }//GEN-LAST:event_txt_telefono_regclienteActionPerformed

    private void btn_limpiar_regclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_regclienteActionPerformed
        this.limpia();
    }//GEN-LAST:event_btn_limpiar_regclienteActionPerformed

    private void btn_fecha_seleccion_regClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fecha_seleccion_regClienteActionPerformed
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd"); // Formato de visualización en JDateChooser

        // Mostrarlo dentro de un JOptionPane
        int opcion = JOptionPane.showConfirmDialog(null, dateChooser, "Seleccione una Fecha", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.OK_OPTION) {
            Date fechaSeleccionada = dateChooser.getDate();
            if (fechaSeleccionada != null) {
                // Formatear la fecha antes de mostrarla en el JTextField
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fechaFormateadaFin = sdf.format(fechaSeleccionada);
                this.txt_fecha_Nac_regCliente.setText(fechaFormateadaFin);
            } else {
                JOptionPane.showMessageDialog(null, "No se seleccionó ninguna fecha.");
            }
        }
    }//GEN-LAST:event_btn_fecha_seleccion_regClienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_fecha_seleccion_regCliente;
    private javax.swing.JButton btn_limpiar_regcliente;
    private javax.swing.JButton btn_registrar_regcliente;
    private javax.swing.JButton btn_salir_regcliente;
    private javax.swing.JComboBox<String> cmb_estadoCivil_regCliente;
    private javax.swing.JComboBox<String> cmb_estado_regCliente;
    private javax.swing.JComboBox<String> cmb_genero_regCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txt_apellidos_regcliente;
    private javax.swing.JTextField txt_correo_regCliente;
    private javax.swing.JTextField txt_direccion_regcliente;
    private javax.swing.JTextField txt_dni_regCliente;
    private javax.swing.JTextField txt_fecha_Nac_regCliente;
    private javax.swing.JTextField txt_id_cliente_registra;
    private javax.swing.JTextField txt_nombre_regcliente;
    private javax.swing.JTextField txt_telefono_regcliente;
    // End of variables declaration//GEN-END:variables
}
