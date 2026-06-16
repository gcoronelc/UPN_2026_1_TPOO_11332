
package UI;

import BEAN.Area;
import BEAN.Contrato;
import BEAN.Empleado;
import BEAN.Rol;
import DAO.AreaDao;
import DAO.ContratoDao;
import DAO.EmpleadoDao;
import DAO.RolDao;
import UTIL.Util;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmContrato extends javax.swing.JInternalFrame {
    DefaultTableModel dtmEmpleado;
    DefaultTableModel dtmEmpleadoSinContrato;
    DefaultTableModel dtmContratos;
    
    EmpleadoDao empDao = new EmpleadoDao();
    RolDao rolDao = new RolDao();
    AreaDao areaDao = new AreaDao();
    ContratoDao contratoDao = new ContratoDao();
    JDateChooser dateChooser = new JDateChooser();
    Util u = new Util();
    
    int idEmpleado = 0;
    public FrmContrato() {
        initComponents();
        dtmEmpleado = new DefaultTableModel(new Object []{"ID", "NOMBRE", "APELLIDOS", "FECHA NAC.", "GENERO", "DNI", "ESTADO CIVIL"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtmEmpleadoSinContrato = new DefaultTableModel(new Object []{"ID", "NOMBRE", "APELLIDOS", "FECHA NAC.", "GENERO", "DNI", "ESTADO CIVIL"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtmContratos = new DefaultTableModel(new Object []{"ID", "EMPLEADO", "ROL", "AREA", "FECHA INI.", "FECHA FIN", "ESTADO", "SUELDO"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tbl_empgeneral_contrato.setModel(dtmEmpleado);
        this.tbl_emp_sin_contrato.setModel(dtmEmpleadoSinContrato);
        this.tbl_contrato.setModel(dtmContratos);
        this.llenaTblEmpleado(false, "");
        this.llenaTblEmpleadoSinContrato(false, "");
        this.llenaTblContratos(false, "");
        this.llenaCmbEstado();
        
        
        if(this.idEmpleado == 0){
        
            this.TabPanel_Contrato.setEnabledAt(2, false);
        }else if(this.idEmpleado != 0){
            this.TabPanel_Contrato.setEnabledAt(2, true);
        }
        
        this.llenaCmbRol();
        this.llenaCmbArea();
    }
    public void llenaCmbEstado(){
    
        this.cmb_estado_contrato.addItem("");
        this.cmb_estado_contrato.addItem("Activo");
        this.cmb_estado_contrato.addItem("No Activo");
    
    }
    private void llenaCmbRol(){
        
        Vector<Rol> listaRol = new Vector<Rol>();
        
        this.cmb_rol_contrato.addItem("");
        
        listaRol = this.rolDao.llenaRol();
        
        for(int i=0; i<listaRol.size();i++){
        
            this.cmb_rol_contrato.addItem(listaRol.get(i).getDescripRol());
        }
    }

    private void llenaCmbArea(){
        
        Vector<Area> listaArea = new Vector<Area>();
        
        this.cmb_area_contrato.addItem("");
        
        listaArea = this.areaDao.llenaArea();
        
        for(int i=0; i<listaArea.size();i++){
        
            this.cmb_area_contrato.addItem(listaArea.get(i).getDescripArea());
        }
    }
    public void llenaTblEmpleado(boolean valida, String cadena){
    
        Vector<Empleado> listaEmp;
        
        listaEmp = empDao.listaEmpleado(valida, cadena);     
        dtmEmpleado.setRowCount(0);
        
        for(int i=0;i<listaEmp.size();i++){
            
            Vector vector = new Vector();
            vector.addElement(listaEmp.get(i).getEmpleadoID());
            vector.addElement(listaEmp.get(i).getNombres());
            vector.addElement(listaEmp.get(i).getApellidos());
            vector.addElement(listaEmp.get(i).getFechaNacimiento());
            if(listaEmp.get(i).getGenero() == 1){
                vector.addElement("masculino");
            }else if (listaEmp.get(i).getGenero() == 0){
                vector.addElement("femenino");
            }
            vector.addElement(listaEmp.get(i).getDni());
            vector.addElement(listaEmp.get(i).getEstadoCivil());
            
            dtmEmpleado.addRow(vector);
        }
    }
    
    
    public void llenaTblEmpleadoSinContrato(boolean valida, String cadena){
    
        Vector<Empleado> listaEmp;
        
        listaEmp = empDao.sinContrato(valida, cadena);     
        this.dtmEmpleadoSinContrato.setRowCount(0);
        
        for(int i=0;i<listaEmp.size();i++){
            
            Vector vector = new Vector();
            vector.addElement(listaEmp.get(i).getEmpleadoID());
            vector.addElement(listaEmp.get(i).getNombres());
            vector.addElement(listaEmp.get(i).getApellidos());
            vector.addElement(listaEmp.get(i).getFechaNacimiento());
            if(listaEmp.get(i).getGenero() == 1){
                vector.addElement("masculino");
            }else if (listaEmp.get(i).getGenero() == 0){
                vector.addElement("femenino");
            }
            vector.addElement(listaEmp.get(i).getDni());
            vector.addElement(listaEmp.get(i).getEstadoCivil());
            
            this.dtmEmpleadoSinContrato.addRow(vector);
        }
       
        
    }
    
    public void llenaTblContratos(boolean valida, String cadena){
    
        Vector<Contrato> listaContrato;
        Util u = new Util();
        
        listaContrato = contratoDao.ListaItem(valida, cadena);
        this.dtmContratos.setRowCount(0);
        
        for(int i=0; i<listaContrato.size(); i++){
        
            Vector vector = new Vector();
            
            vector.addElement(listaContrato.get(i).getContratoID());
            vector.addElement(listaContrato.get(i).getEmpleadoID());
            vector.addElement(this.rolDao.devRol(listaContrato.get(i).getRolID()));
            vector.addElement(this.areaDao.devArea(listaContrato.get(i).getAreaID()));
            vector.addElement(listaContrato.get(i).getFechaIni());
            vector.addElement(listaContrato.get(i).getFechaFin());
            if(listaContrato.get(i).getEstado() == 1){
                vector.addElement("Activo");
            }else{
                vector.addElement("No Activo");
            }
            vector.addElement(listaContrato.get(i).getSueldo());
            
            this.dtmContratos.addRow(vector);
        
        }
    }
    private void limpia(){
        this.txt_empleado_id_contrato.setText("");
        this.cmb_rol_contrato.setSelectedItem("");
        this.cmb_area_contrato.setSelectedItem("");
        this.txt_fecha_inicio_contrato.setText("");
        this.txt_fecha_fin_contrato.setText("");
        this.txt_sueldo_contrato.setText("");
        this.cmb_estado_contrato.setSelectedItem("");
        this.btn_grabar_contrato.setText("Grabar");
        this.TabPanel_Contrato.setEnabledAt(2, false);
        this.TabPanel_Contrato.setEnabledAt(1, true);
        
        this.TabPanel_Contrato.setSelectedIndex(1);
    }
    private boolean valida(){
    
        if (this.txt_fecha_inicio_contrato.getText().isEmpty() && this.cmb_estado_contrato.getSelectedItem().equals("") && this.txt_fecha_fin_contrato.getText().isEmpty()  && this.txt_sueldo_contrato.getText().isEmpty()
                && this.cmb_rol_contrato.getSelectedItem().equals("") && this.cmb_area_contrato.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "FALTA LLENAR LOS CAMPOS...");
        }else if (this.txt_fecha_inicio_contrato.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "FALTA LLENAR LA FECHA DE INICIO...");
        }else if(this.txt_fecha_fin_contrato.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "FALTA LLENAR LA FECHA DE FIN...");
        }else if(this.cmb_estado_contrato.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "FALTA SELECCIONAR EL ESTADO...");
        }else if(this.txt_sueldo_contrato.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "FALTA LLENAR EL SUELDO...");
        }else if(this.cmb_rol_contrato.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "FALTA LLENAR EL ROL...");
        }else if(this.cmb_area_contrato.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "FALTA LLENAR EL AREA...");
        }else{
            return true;
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TabPanel_Contrato = new javax.swing.JTabbedPane();
        panel_emp_general = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_busca_empgeneral_contrato = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_empgeneral_contrato = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        panel_emp_sin_contrato = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();
        txt_buscar_emp_sin_contrato = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_emp_sin_contrato = new javax.swing.JTable();
        panel_contrato = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_fecha_inicio_contrato = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_fecha_fin_contrato = new javax.swing.JTextField();
        cmb_estado_contrato = new javax.swing.JComboBox<>();
        txt_sueldo_contrato = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_id_contrato = new javax.swing.JTextField();
        txt_empleado_id_contrato = new javax.swing.JTextField();
        cmb_rol_contrato = new javax.swing.JComboBox<>();
        cmb_area_contrato = new javax.swing.JComboBox<>();
        btn_grabar_contrato = new javax.swing.JButton();
        btn_volver_contrato = new javax.swing.JButton();
        btn_eliminar_contrato = new javax.swing.JButton();
        btn_selecFecha_contrato = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_buscar_contrato = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_contrato = new javax.swing.JTable();
        btn_salir_contrato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FORMULARIO CONTRATO");

        jLabel3.setText("Buscar");

        txt_busca_empgeneral_contrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busca_empgeneral_contratoKeyReleased(evt);
            }
        });

        tbl_empgeneral_contrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "APELLIDOS", "FECHA NAC.", "GENERO", "DNI", "ESTADO CIVIL"
            }
        ));
        tbl_empgeneral_contrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_empgeneral_contratoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_empgeneral_contrato);

        javax.swing.GroupLayout panel_emp_generalLayout = new javax.swing.GroupLayout(panel_emp_general);
        panel_emp_general.setLayout(panel_emp_generalLayout);
        panel_emp_generalLayout.setHorizontalGroup(
            panel_emp_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_emp_generalLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_emp_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_emp_generalLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_busca_empgeneral_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panel_emp_generalLayout.setVerticalGroup(
            panel_emp_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_emp_generalLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panel_emp_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_busca_empgeneral_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        TabPanel_Contrato.addTab("Empleados General", panel_emp_general);

        lbl.setText("Buscar");

        txt_buscar_emp_sin_contrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar_emp_sin_contratoKeyReleased(evt);
            }
        });

        tbl_emp_sin_contrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "APELLIDOS", "FECHA NAC.", "GENERO", "DNI", "ESTADO CIVIL"
            }
        ));
        tbl_emp_sin_contrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_emp_sin_contratoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_emp_sin_contrato);

        javax.swing.GroupLayout panel_emp_sin_contratoLayout = new javax.swing.GroupLayout(panel_emp_sin_contrato);
        panel_emp_sin_contrato.setLayout(panel_emp_sin_contratoLayout);
        panel_emp_sin_contratoLayout.setHorizontalGroup(
            panel_emp_sin_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_emp_sin_contratoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_emp_sin_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_emp_sin_contratoLayout.createSequentialGroup()
                        .addComponent(lbl)
                        .addGap(18, 18, 18)
                        .addComponent(txt_buscar_emp_sin_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panel_emp_sin_contratoLayout.setVerticalGroup(
            panel_emp_sin_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_emp_sin_contratoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panel_emp_sin_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl)
                    .addComponent(txt_buscar_emp_sin_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_emp_sin_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_emp_sin_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        TabPanel_Contrato.addTab("Empleados sin Contrato", jPanel2);

        panel_contrato.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("FECHA INICIO");

        txt_fecha_inicio_contrato.setEditable(false);

        jLabel6.setText("FECHA FIN");

        jLabel7.setText("ESTADO");

        jLabel8.setText("SUELDO");

        txt_fecha_fin_contrato.setEditable(false);

        jLabel9.setText("DATOS GENERALES");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("EmpleadoID");

        jLabel11.setText("ContratoID");

        jLabel12.setText("Rol");

        jLabel13.setText("Area");

        txt_id_contrato.setEditable(false);

        txt_empleado_id_contrato.setEditable(false);

        cmb_rol_contrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmb_rol_contrato.setSelectedIndex(-1);

        btn_grabar_contrato.setText("GRABAR");
        btn_grabar_contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabar_contratoActionPerformed(evt);
            }
        });

        btn_volver_contrato.setText("VOLVER");
        btn_volver_contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volver_contratoActionPerformed(evt);
            }
        });

        btn_eliminar_contrato.setText("ELIMINAR");
        btn_eliminar_contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_contratoActionPerformed(evt);
            }
        });

        btn_selecFecha_contrato.setText("SELECCIONAR FECHA");
        btn_selecFecha_contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selecFecha_contratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_contratoLayout = new javax.swing.GroupLayout(panel_contrato);
        panel_contrato.setLayout(panel_contratoLayout);
        panel_contratoLayout.setHorizontalGroup(
            panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contratoLayout.createSequentialGroup()
                .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_contratoLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_contratoLayout.createSequentialGroup()
                                .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_fecha_inicio_contrato)
                                    .addComponent(txt_fecha_fin_contrato)
                                    .addComponent(cmb_estado_contrato, 0, 100, Short.MAX_VALUE)
                                    .addComponent(txt_sueldo_contrato)))
                            .addComponent(btn_selecFecha_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(panel_contratoLayout.createSequentialGroup()
                                .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_eliminar_contrato)
                                    .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmb_rol_contrato, 0, 150, Short.MAX_VALUE)
                                        .addComponent(cmb_area_contrato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_empleado_id_contrato, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                        .addComponent(txt_id_contrato))))))
                    .addGroup(panel_contratoLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btn_grabar_contrato)
                        .addGap(72, 72, 72)
                        .addComponent(btn_volver_contrato)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        panel_contratoLayout.setVerticalGroup(
            panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contratoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_contratoLayout.createSequentialGroup()
                        .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_fecha_inicio_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(24, 24, 24)
                        .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_fecha_fin_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txt_id_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_contratoLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txt_empleado_id_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_contratoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_selecFecha_contrato)))
                        .addGap(22, 22, 22)
                        .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cmb_estado_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(cmb_rol_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmb_area_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sueldo_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(panel_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_grabar_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_volver_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        TabPanel_Contrato.addTab("Contrato", panel_contrato);

        jLabel2.setText("CONTRATOS");

        txt_buscar_contrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar_contratoKeyReleased(evt);
            }
        });

        tbl_contrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "EMPLEADO", "ROL", "AREA", "FECHA INI.", "FECHA FIN", "ESTADO", "SUELDO"
            }
        ));
        tbl_contrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_contratoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_contrato);

        btn_salir_contrato.setText("SALIR");
        btn_salir_contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_contratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(524, 524, 524))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_salir_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TabPanel_Contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addComponent(txt_buscar_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabPanel_Contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_buscar_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_salir_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_grabar_contratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabar_contratoActionPerformed
        if(this.valida() == true){
        
            if(this.btn_grabar_contrato.getText().equals("Grabar")){
                Contrato contrato = new Contrato();

                contrato.setContratoID(Integer.parseInt(this.txt_id_contrato.getText()));
                contrato.setEmpleadoID(Integer.parseInt(this.txt_empleado_id_contrato.getText()));

                contrato.setRolID(this.rolDao.devIDRol(this.cmb_rol_contrato.getSelectedItem().toString()));
                contrato.setAreaID(this.areaDao.devIDArea(this.cmb_area_contrato.getSelectedItem().toString()));
                
                contrato.setFechaIni(this.txt_fecha_inicio_contrato.getText());
                contrato.setFechaFin(this.txt_fecha_fin_contrato.getText());

                if(this.cmb_estado_contrato.getSelectedItem().equals("Activo")){
                    contrato.setEstado(1);
                }else{
                    contrato.setEstado(0);
                }

                contrato.setSueldo(Double.parseDouble(this.txt_sueldo_contrato.getText()));

                this.contratoDao.insertaContrato(contrato);
                this.limpia();
                this.llenaTblContratos(false, "");
            }else{
                
                Contrato contrato = new Contrato();
                contrato.setContratoID(Integer.parseInt(this.txt_id_contrato.getText()));
                contrato.setEmpleadoID(Integer.parseInt(this.txt_empleado_id_contrato.getText()));

                contrato.setRolID(this.rolDao.devIDRol(this.cmb_rol_contrato.getSelectedItem().toString()));
                contrato.setAreaID(this.areaDao.devIDArea(this.cmb_area_contrato.getSelectedItem().toString()));
                
                contrato.setFechaIni(this.txt_fecha_inicio_contrato.getText());
                contrato.setFechaFin(this.txt_fecha_fin_contrato.getText());

                if(this.cmb_estado_contrato.getSelectedItem().equals("Activo")){
                    contrato.setEstado(1);
                }else{
                    contrato.setEstado(0);
                }
                contrato.setSueldo(Double.parseDouble(this.txt_sueldo_contrato.getText()));
                
                this.contratoDao.actualizarContrato(contrato);
                this.llenaTblContratos(false, "");
                this.limpia();
            
            }
            this.btn_grabar_contrato.setText("Grabar");
            this.TabPanel_Contrato.setEnabledAt(1, true);
            this.llenaTblEmpleado(false, "");
            this.llenaTblEmpleadoSinContrato(false, "");
        }
    }//GEN-LAST:event_btn_grabar_contratoActionPerformed

    private void btn_salir_contratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_contratoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_contratoActionPerformed

    private void txt_busca_empgeneral_contratoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busca_empgeneral_contratoKeyReleased
        if(this.txt_busca_empgeneral_contrato.getText().isEmpty()){
            this.llenaTblEmpleado(false,"");
        }else{
            this.llenaTblEmpleado(true,this.txt_busca_empgeneral_contrato.getText());
        }
    }//GEN-LAST:event_txt_busca_empgeneral_contratoKeyReleased

    private void txt_buscar_emp_sin_contratoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_emp_sin_contratoKeyReleased
        if(this.txt_buscar_emp_sin_contrato.getText().isEmpty()){
            this.llenaTblEmpleadoSinContrato(false,"");
        }else{
            this.llenaTblEmpleadoSinContrato(true,this.txt_buscar_emp_sin_contrato.getText());
        }
    }//GEN-LAST:event_txt_buscar_emp_sin_contratoKeyReleased

    private void txt_buscar_contratoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_contratoKeyReleased
        if(this.txt_buscar_contrato.getText().isEmpty()){
            this.llenaTblContratos(false,"");
        }else{
            this.llenaTblContratos(true,this.txt_buscar_contrato.getText());
        }
    }//GEN-LAST:event_txt_buscar_contratoKeyReleased

    private void tbl_emp_sin_contratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_emp_sin_contratoMouseClicked
        int posiFilEmpSinCon = this.tbl_emp_sin_contrato.getSelectedRow();
        
        idEmpleado = (int) this.tbl_emp_sin_contrato.getValueAt(posiFilEmpSinCon, 0);
        this.TabPanel_Contrato.setEnabledAt(2, true);
        
        this.TabPanel_Contrato.setSelectedIndex(2);
        this.txt_fecha_inicio_contrato.setText(u.obtenerFecha());
        this.txt_fecha_fin_contrato.setText(u.obtenerFecha());
        this.txt_id_contrato.setText(Integer.toString(u.idNext("Contrato", "contratoID")));
        this.txt_empleado_id_contrato.setText(Integer.toString(idEmpleado));
        this.TabPanel_Contrato.setEnabledAt(1, false);
    }//GEN-LAST:event_tbl_emp_sin_contratoMouseClicked

    private void tbl_contratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_contratoMouseClicked
        this.TabPanel_Contrato.setEnabledAt(2, true);
        this.TabPanel_Contrato.setSelectedIndex(2);
        int idx = this.tbl_contrato.getSelectedRow();
        
        this.txt_id_contrato.setText(this.dtmContratos.getValueAt(idx, 0).toString());
        this.txt_empleado_id_contrato.setText(this.dtmContratos.getValueAt(idx, 1).toString());
        this.cmb_rol_contrato.setSelectedItem(this.dtmContratos.getValueAt(idx, 2).toString());
        this.cmb_area_contrato.setSelectedItem(this.dtmContratos.getValueAt(idx, 3).toString());
        this.txt_fecha_inicio_contrato.setText(this.dtmContratos.getValueAt(idx, 4).toString());
        this.txt_fecha_fin_contrato.setText(this.dtmContratos.getValueAt(idx, 5).toString());
        this.cmb_estado_contrato.setSelectedItem(this.dtmContratos.getValueAt(idx, 6).toString());
        this.txt_sueldo_contrato.setText(this.dtmContratos.getValueAt(idx, 7).toString());
        
        this.TabPanel_Contrato.setEnabledAt(1, false);
        this.btn_grabar_contrato.setText("Actualizar");
    }//GEN-LAST:event_tbl_contratoMouseClicked

    private void btn_eliminar_contratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_contratoActionPerformed
        if(this.valida()== true){
        
            Contrato contrato = new Contrato();
            
            contrato.setContratoID(Integer.parseInt(this.txt_id_contrato.getText()));
        
            this.contratoDao.eliminarContrato(contrato);
            
            this.llenaTblContratos(false, "");
            this.llenaTblEmpleado(false, "");
            this.llenaTblEmpleadoSinContrato(false, "");
            this.limpia();
        
        }
    }//GEN-LAST:event_btn_eliminar_contratoActionPerformed

    private void btn_volver_contratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volver_contratoActionPerformed
        this.limpia();
    }//GEN-LAST:event_btn_volver_contratoActionPerformed

    private void tbl_empgeneral_contratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_empgeneral_contratoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_empgeneral_contratoMouseClicked

    private void btn_selecFecha_contratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selecFecha_contratoActionPerformed
        // Crear el selector de fecha
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
                String fechaInicioTexto = this.txt_fecha_inicio_contrato.getText();
                 try {
                    Date fechaInicio = sdf.parse(fechaInicioTexto);

                    if (fechaSeleccionada.compareTo(fechaInicio) >= 0) {
                        JOptionPane.showMessageDialog(null, "Fecha Seleccionada: "+fechaFormateadaFin);
                        this.txt_fecha_fin_contrato.setText(fechaFormateadaFin);
                    } else {
                        JOptionPane.showMessageDialog(null, "La fecha de fin debe ser igual o posterior a la fecha de inicio.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al convertir la fecha de inicio.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se seleccionó ninguna fecha.");
            }
        }
    }//GEN-LAST:event_btn_selecFecha_contratoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabPanel_Contrato;
    private javax.swing.JButton btn_eliminar_contrato;
    private javax.swing.JButton btn_grabar_contrato;
    private javax.swing.JButton btn_salir_contrato;
    private javax.swing.JButton btn_selecFecha_contrato;
    private javax.swing.JButton btn_volver_contrato;
    private javax.swing.JComboBox<String> cmb_area_contrato;
    private javax.swing.JComboBox<String> cmb_estado_contrato;
    private javax.swing.JComboBox<String> cmb_rol_contrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl;
    private javax.swing.JPanel panel_contrato;
    private javax.swing.JPanel panel_emp_general;
    private javax.swing.JPanel panel_emp_sin_contrato;
    private javax.swing.JTable tbl_contrato;
    private javax.swing.JTable tbl_emp_sin_contrato;
    private javax.swing.JTable tbl_empgeneral_contrato;
    private javax.swing.JTextField txt_busca_empgeneral_contrato;
    private javax.swing.JTextField txt_buscar_contrato;
    private javax.swing.JTextField txt_buscar_emp_sin_contrato;
    private javax.swing.JTextField txt_empleado_id_contrato;
    private javax.swing.JTextField txt_fecha_fin_contrato;
    private javax.swing.JTextField txt_fecha_inicio_contrato;
    private javax.swing.JTextField txt_id_contrato;
    private javax.swing.JTextField txt_sueldo_contrato;
    // End of variables declaration//GEN-END:variables
}
