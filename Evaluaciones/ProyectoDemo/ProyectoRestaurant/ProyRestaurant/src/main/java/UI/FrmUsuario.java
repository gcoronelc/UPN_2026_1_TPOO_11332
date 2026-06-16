
package UI;

import BEAN.Empleado;
import BEAN.LocalR;
import BEAN.Usuario;
import DAO.EmpleadoDao;
import DAO.LocalDao;
import DAO.UsuarioDao;
import UTIL.Util;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmUsuario extends javax.swing.JInternalFrame {
   
    DefaultTableModel dtmUsuario;
    DefaultTableModel dtmEmpleado;
    UsuarioDao uDao = new UsuarioDao();
    LocalDao lDao = new LocalDao();
    EmpleadoDao empDao = new EmpleadoDao();
    int idEmpleado = 0;
    
    public FrmUsuario() {
        initComponents();

        dtmUsuario = new DefaultTableModel(new Object[]{"ID USUARIO", "LOCAL", "USUARIO", "TIPO USUARIO", "EMPLEADO"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dtmEmpleado = new DefaultTableModel(new Object[]{"EMPLEADO ID", "NOMBRE", "APELLIDO", "DNI"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tbl_usuario.setModel(dtmUsuario);
        tbl_empleado_usuario.setModel(dtmEmpleado);
        
        this.llenaCmbTipoUsuario();
        this.llenaTblUsuario(false, "");
        this.llenaTblEmpleado(false, "");

        if (this.idEmpleado == 0) {
            this.panel_usuario.setEnabledAt(1, false);
        } else {
            this.panel_usuario.setEnabledAt(1, true);
        }
    }

    private void llenaTblUsuario(boolean valida, String cadena){
    
        Vector<Usuario> listaUsuario;
        
        listaUsuario = uDao.listaUsuario(valida, cadena);
        dtmUsuario.setRowCount(0);
        
        for(int i=0;i<listaUsuario.size();i++){
            
            Vector vector = new Vector();
            vector.addElement(listaUsuario.get(i).getUsuarioID());
            vector.addElement(listaUsuario.get(i).getIdLocalR());
            vector.addElement(listaUsuario.get(i).getUsuario());
            
            if(listaUsuario.get(i).getTipoUsuario()==1){
                vector.addElement("Administrador");
            }else if(listaUsuario.get(i).getTipoUsuario()==2){
                vector.addElement("Mantenimiento");
            }else if(listaUsuario.get(i).getTipoUsuario()==3){
                vector.addElement("Reportes");
            }else{
                vector.addElement("Transacciones");
            }
            vector.addElement(listaUsuario.get(i).getIdEmpleado());
            
            dtmUsuario.addRow(vector);
        }
    }
   private void llenaTblEmpleado(boolean valida, String cadena){
    
        Vector<Empleado> listaEmp;
        
        
        listaEmp = empDao.listaEmpleadoNoUsers(valida, cadena);
        dtmEmpleado.setRowCount(0);
        
        for(int i=0;i<listaEmp.size();i++){
            
            Vector vector = new Vector();
            vector.addElement(listaEmp.get(i).getEmpleadoID());
            vector.addElement(listaEmp.get(i).getNombres());
            vector.addElement(listaEmp.get(i).getApellidos());
            vector.addElement(listaEmp.get(i).getDni());
            
            dtmEmpleado.addRow(vector);
        }
    
    }
    private void llenaCmbTipoUsuario(){
    
        this.cmb_tipoUsuario_usuario.addItem("");
        this.cmb_tipoUsuario_usuario.addItem("Administrador");
        this.cmb_tipoUsuario_usuario.addItem("Mantenimiento");
        this.cmb_tipoUsuario_usuario.addItem("Reportes");
        this.cmb_tipoUsuario_usuario.addItem("Transacciones");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panel_usuario = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_buscar_emp_usuario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_empleado_usuario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_idUsuario_usuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_idLocal_usuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmb_tipoUsuario_usuario = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txt_idEmp_usuario = new javax.swing.JTextField();
        btn_grabar_usuario = new javax.swing.JButton();
        btn_eliminar_usuario = new javax.swing.JButton();
        btn_volver_usuario = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_contra_usuario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_usuario = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_buscar_usuario = new javax.swing.JTextField();
        btn_salir_usuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FORMULARIO USUARIO");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Buscar");

        txt_buscar_emp_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscar_emp_usuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar_emp_usuarioKeyReleased(evt);
            }
        });

        tbl_empleado_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMPLEADO ID", "NOMBRE", "APELLIDO", "DNI"
            }
        ));
        tbl_empleado_usuario.setRowSelectionAllowed(true);
        tbl_empleado_usuario.setShowGrid(true);
        tbl_empleado_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_empleado_usuarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_empleado_usuario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_buscar_emp_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_buscar_emp_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panel_usuario.addTab("Busca Empleado", jPanel1);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("ID USUARIO");

        txt_idUsuario_usuario.setEditable(false);

        jLabel5.setText("ID LOCAL");

        txt_idLocal_usuario.setEditable(false);

        jLabel6.setText("USUARIO");

        jLabel7.setText("TIPO USUARIO");

        jLabel8.setText("ID EMPLEADO");

        txt_idEmp_usuario.setEditable(false);

        btn_grabar_usuario.setText("Grabar");
        btn_grabar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabar_usuarioActionPerformed(evt);
            }
        });

        btn_eliminar_usuario.setText("Eliminar");
        btn_eliminar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_usuarioActionPerformed(evt);
            }
        });

        btn_volver_usuario.setText("Volver");
        btn_volver_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volver_usuarioActionPerformed(evt);
            }
        });

        jLabel9.setText("CONTRASEÑA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(btn_grabar_usuario)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btn_eliminar_usuario)
                        .addGap(58, 58, 58)
                        .addComponent(btn_volver_usuario))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_tipoUsuario_usuario, 0, 150, Short.MAX_VALUE)
                            .addComponent(txt_usuario)
                            .addComponent(txt_contra_usuario)
                            .addComponent(txt_idLocal_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(txt_idUsuario_usuario)
                            .addComponent(txt_idEmp_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_idUsuario_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_idLocal_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_contra_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmb_tipoUsuario_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_idEmp_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_grabar_usuario)
                    .addComponent(btn_eliminar_usuario)
                    .addComponent(btn_volver_usuario))
                .addGap(53, 53, 53))
        );

        panel_usuario.addTab("Usuario", jPanel2);

        tbl_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID USUARIO", "LOCAL", "USUARIO", "TIPO USUARIO", "EMPLEADO"
            }
        ));
        tbl_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_usuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_usuario);

        jLabel2.setText("Buscar");

        txt_buscar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscar_usuarioActionPerformed(evt);
            }
        });
        txt_buscar_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar_usuarioKeyReleased(evt);
            }
        });

        btn_salir_usuario.setText("SALIR");
        btn_salir_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_usuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_salir_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panel_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_buscar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_buscar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_salir_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panel_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salir_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_usuarioActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_usuarioActionPerformed

    private void txt_buscar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscar_usuarioActionPerformed

    }//GEN-LAST:event_txt_buscar_usuarioActionPerformed

    private void txt_buscar_emp_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_emp_usuarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscar_emp_usuarioKeyPressed

    private void txt_buscar_usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_usuarioKeyReleased
        if(this.txt_buscar_usuario.getText().isEmpty()){
            this.llenaTblUsuario(false, "");
        }else{
            this.llenaTblUsuario(true, this.txt_buscar_usuario.getText());
        }
    }//GEN-LAST:event_txt_buscar_usuarioKeyReleased

    private void txt_buscar_emp_usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_emp_usuarioKeyReleased
        if(this.txt_buscar_emp_usuario.getText().isEmpty()){
            this.llenaTblEmpleado(false, "");
        }else{
            this.llenaTblEmpleado(true, this.txt_buscar_emp_usuario.getText());
        }
    }//GEN-LAST:event_txt_buscar_emp_usuarioKeyReleased

    private void tbl_empleado_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_empleado_usuarioMouseClicked
        // PANEL USUARIO
        this.panel_usuario.setEnabledAt(0, false);
        this.panel_usuario.setEnabledAt(1, true);
        this.panel_usuario.setSelectedIndex(1);
        // SELECCION DE FILA
        int idx = this.tbl_empleado_usuario.getSelectedRow();
        idEmpleado  = (int) this.dtmEmpleado.getValueAt(idx, 0);
        // Locales
        int id=0;
        Vector<LocalR> listaLocal = new Vector<LocalR>();
        listaLocal = lDao.listaLocal();
        id = listaLocal.get(0).getIdLocalR();
        // Completa campos
        Util u = new Util();
        this.txt_idUsuario_usuario.setText(Integer.toString(u.idNext("Usuario", "usuarioID")));
        this.txt_idLocal_usuario.setText(Integer.toString(id));
        this.txt_idEmp_usuario.setText(Integer.toString(idEmpleado));
    }//GEN-LAST:event_tbl_empleado_usuarioMouseClicked

    private void btn_grabar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabar_usuarioActionPerformed
        if(this.valida()==true){
        
            if(this.btn_eliminar_usuario.getText().equals("Grabar")){
            
                Usuario user = new Usuario();
                
                user.setUsuarioID(Integer.parseInt(this.txt_idUsuario_usuario.getText()));
                user.setIdLocalR(Integer.parseInt(this.txt_idLocal_usuario.getText()));
                user.setUsuario(this.txt_usuario.getText());
                user.setContrasena(this.txt_contra_usuario.getText());
                if(this.cmb_tipoUsuario_usuario.getSelectedItem().equals("Administrador")){
                    user.setTipoUsuario(1);
                }else if(this.cmb_tipoUsuario_usuario.getSelectedItem().equals("Mantenimiento")){
                    user.setTipoUsuario(2);
                }else if(this.cmb_tipoUsuario_usuario.getSelectedItem().equals("Reportes")){
                    user.setTipoUsuario(3);
                }else{
                    user.setTipoUsuario(4);
                }
                user.setIdEmpleado(Integer.parseInt(this.txt_idEmp_usuario.getText()));
                
                this.uDao.insertaUsuario(user);
                this.limpiar();
                this.llenaTblUsuario(false, "");
                this.llenaTblEmpleado(false, "");
                
            }else{
                Usuario user = new Usuario();
                
                user.setUsuarioID(Integer.parseInt(this.txt_idUsuario_usuario.getText()));
                user.setIdLocalR(Integer.parseInt(this.txt_idLocal_usuario.getText()));
                user.setUsuario(this.txt_usuario.getText());
                if(this.cmb_tipoUsuario_usuario.getSelectedItem().equals("Administrador")){
                    user.setTipoUsuario(1);
                }else if(this.cmb_tipoUsuario_usuario.getSelectedItem().equals("Mantenimiento")){
                    user.setTipoUsuario(2);
                }else if(this.cmb_tipoUsuario_usuario.getSelectedItem().equals("Reportes")){
                    user.setTipoUsuario(3);
                }else{
                    user.setTipoUsuario(4);
                }
                user.setContrasena(this.txt_contra_usuario.getText());
                user.setIdEmpleado(Integer.parseInt(this.txt_idEmp_usuario.getText()));
                
                this.uDao.actualizarUsuario(user);
                this.llenaTblUsuario(false, "");
                this.limpiar();
                
            }
        
        }
    }//GEN-LAST:event_btn_grabar_usuarioActionPerformed

    private void tbl_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usuarioMouseClicked
        this.btn_grabar_usuario.setText("Actualizar");
        // Cambi Panel
        this.panel_usuario.setSelectedIndex(1);
        this.panel_usuario.setEnabledAt(1, true);
        // Tabla Seleccion
        int idx = this.tbl_usuario.getSelectedRow();
        this.txt_idUsuario_usuario.setText(this.dtmUsuario.getValueAt(idx,0).toString());
        this.txt_idLocal_usuario.setText(this.dtmUsuario.getValueAt(idx, 1).toString());
        this.txt_usuario.setText(this.dtmUsuario.getValueAt(idx, 2).toString());
        this.cmb_tipoUsuario_usuario.setSelectedItem(this.dtmUsuario.getValueAt(idx, 3).toString());
        this.txt_idEmp_usuario.setText(this.dtmUsuario.getValueAt(idx, 4).toString());
        // variables seleccion
        int idUsuario = Integer.parseInt(this.dtmUsuario.getValueAt(idx,0).toString());
        int idLocal = Integer.parseInt(this.dtmUsuario.getValueAt(idx, 1).toString());
        String usuario = this.dtmUsuario.getValueAt(idx, 2).toString();
        int tipUsuario;
        if(this.dtmUsuario.getValueAt(idx, 3).toString().equals("Administrador")){
            tipUsuario=1;
        }else if(this.dtmUsuario.getValueAt(idx, 3).toString().equals("Mantenimiento")){
            tipUsuario=2;
        }else if(this.dtmUsuario.getValueAt(idx, 3).toString().equals("Reportes")){
            tipUsuario=3;
        }else{
            tipUsuario=4;
        }
        int idEmpleado = Integer.parseInt(this.dtmUsuario.getValueAt(idx, 4).toString());
        //contraseña
        this.txt_contra_usuario.setText(this.uDao.consultaContra(idUsuario, idLocal, usuario, tipUsuario, idEmpleado));
        // Bloquea pestaña Empleado
        this.panel_usuario.setEnabledAt(0, false);
    }//GEN-LAST:event_tbl_usuarioMouseClicked

    private void btn_volver_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volver_usuarioActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btn_volver_usuarioActionPerformed

    private void btn_eliminar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_usuarioActionPerformed
        int idx = this.tbl_usuario.getSelectedRow();
        Usuario user = new Usuario();
        
        user.setUsuarioID(Integer.parseInt(this.dtmUsuario.getValueAt(idx, 0).toString()));
        
        this.uDao.eliminarUsuario(user);
        this.llenaTblUsuario(false, "");
        this.llenaTblEmpleado(false, "");
        this.limpiar();
    }//GEN-LAST:event_btn_eliminar_usuarioActionPerformed

    private boolean valida(){
    
        if (this.txt_usuario.getText().isEmpty() && this.cmb_tipoUsuario_usuario.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "FALTA LLENAR LOS CAMPOS");
            
        }else if(this.txt_usuario.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "FALTA LLENAR USUARIO");
        }else if(this.cmb_tipoUsuario_usuario.getSelectedItem().equals("")){
        
            JOptionPane.showMessageDialog(null, "FALTA SELECCIONAR TIPO USUARIO");
        }else {
            return true;
        }
        return false;
    }
    
    
    private void limpiar(){
    
        this.txt_usuario.setText("");
        this.cmb_tipoUsuario_usuario.setSelectedItem("");
        this.panel_usuario.setSelectedIndex(0);
        idEmpleado =0;
        this.panel_usuario.setEnabledAt(1, false);
        this.panel_usuario.setEnabledAt(0, true);
        this.btn_grabar_usuario.setText("Grabar");
        this.txt_contra_usuario.setText("");
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar_usuario;
    private javax.swing.JButton btn_grabar_usuario;
    private javax.swing.JButton btn_salir_usuario;
    private javax.swing.JButton btn_volver_usuario;
    private javax.swing.JComboBox<String> cmb_tipoUsuario_usuario;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane panel_usuario;
    private javax.swing.JTable tbl_empleado_usuario;
    private javax.swing.JTable tbl_usuario;
    private javax.swing.JTextField txt_buscar_emp_usuario;
    private javax.swing.JTextField txt_buscar_usuario;
    private javax.swing.JTextField txt_contra_usuario;
    private javax.swing.JTextField txt_idEmp_usuario;
    private javax.swing.JTextField txt_idLocal_usuario;
    private javax.swing.JTextField txt_idUsuario_usuario;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
