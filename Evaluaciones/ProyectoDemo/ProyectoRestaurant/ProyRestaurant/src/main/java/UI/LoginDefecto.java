
package UI;

import BEAN.Empleado;
import BEAN.LocalR;
import BEAN.Usuario;
import DAO.inciaBdDao;
import UTIL.DbBean;
import UTIL.Util;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDefecto extends javax.swing.JFrame {
    
    Empleado empleado = new Empleado();
    Usuario usuario = new Usuario();
    LocalR local = new LocalR();
    Util util = new Util();
    Login login = new Login();
    public int idLocal;
    
    inciaBdDao inicia = new inciaBdDao();
    public LoginDefecto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.llenaCmbEstadoCivil();
        this.llenaCmbGenero();
    }
    public void llenaCmbGenero(){
    
        this.cmb_genero_logDefecto.addItem("");
        this.cmb_genero_logDefecto.addItem("MASCULINO");
        this.cmb_genero_logDefecto.addItem("FEMENINO");
    
    }
    
    public void llenaCmbEstadoCivil(){
    
        this.cmb_estadoCivil_logDefecto.addItem("");
        this.cmb_estadoCivil_logDefecto.addItem("SOLTERO");
        this.cmb_estadoCivil_logDefecto.addItem("CASADO");
        this.cmb_estadoCivil_logDefecto.addItem("DIVORCIADO");
    
    }
    
    public boolean valida(){
        
        if(this.txt_id_local_logDefecto.getText().isEmpty() || this.txt_nomUsuario_logDefecto.getText().isEmpty() ||
            this.txt_contra_logDefecto.getText().isEmpty() || this.txt_apellidos_logDefecto.getText().isEmpty() ||
            this.txt_fechaNac_logDefecto.getText().isEmpty() || this.cmb_genero_logDefecto.getSelectedItem().toString().isEmpty() ||
            this.txt_dni_logDefecto.getText().isEmpty() || this.cmb_estadoCivil_logDefecto.getSelectedItem().toString().isEmpty() ||
            this.txt_ubicacion_logDefecto.getText().isEmpty() || this.txt_capacidad_logDefecto.getText().isEmpty() ||
            this.txt_pisos_logDefecto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Faltan Completar Campos");
            return false;
        }
        JOptionPane.showMessageDialog(null,"Campos Completados");
        return true;
    }
    
    public void creaPDF() throws FileNotFoundException{
        
        com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
        DbBean con = new DbBean();
        String sql;
        String ruta = System.getProperty("user.home");
        String nombreArchivo = "BD_Restaurant.pdf";
        String rutaCompleta = ruta + "/downloads/" + nombreArchivo;

        try{

            File archivo = new File(rutaCompleta);
            int contador = 1;

            while (archivo.exists()) {
                nombreArchivo = "BD_Restaurant(" + contador + ").pdf";
                rutaCompleta = ruta + "/downloads/" + nombreArchivo;
                archivo = new File(rutaCompleta);
                contador++;
        }

        PdfWriter.getInstance(documento, new FileOutputStream(rutaCompleta));
        documento.open();
        
        Paragraph titulo = new Paragraph("'BD_RESTAURANT'", new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD));
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        documento.add(titulo);    
        
        Paragraph subtitulo = new Paragraph("\nALGUNOS INSERTS IMPORTANTES: ", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD));
        subtitulo.setAlignment(Element.ALIGN_CENTER);
        subtitulo.setSpacingAfter(20);
        documento.add(subtitulo); 
        
        String inserts = "insert into empleado values (empleadoID,usuarioModifID,usuarioCreaID,'nombres','apellidos','fechaNacimiento','fechaCrea',genero,\n'fechaModif','dni','estadoCivil')" + 
                          "\ninsert into localR values(idLocalR,'Ubicacion',capacidadMax,pisos,'horaApertura','horaCerrado')"+
                          "\ninsert into usuario values(usuarioID,idLocalR,'usuario','contraseña',tipoUsuario,empleadoID)\n"+
                          "\ninsert into servidor values(servidorID,nomServidor)\n";
        
        Paragraph primero = new Paragraph(inserts, new Font(Font.FontFamily.TIMES_ROMAN, 12));
        documento.add(primero);
       
        Paragraph subtitulo2 = new Paragraph("\nCUERPO DE LA BD: \n", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD));
        subtitulo2.setAlignment(Element.ALIGN_CENTER);
        subtitulo2.setSpacingAfter(20);
        documento.add(subtitulo2);
        
        String texto = "\nuse master\n" +
                        "go\n" +
                        "create database restaurante\n" +
                        "go\n" +
                        "use restaurante\n" +
                        "go\n"+
                    "create table Area(\n" +
                    "areaID int constraint pkareaID primary key,\n" +
                    "descripArea varchar(40)\n" +
                    ")\n" +
                    "go\n" +
                    "create table CabOrdenDeProduccionSemanal(\n" +
                    "ordenProduccionID int constraint pkOrdenProduccionID primary key,\n" +
                    "empleadoID int,\n" +
                    "descripArea varchar(40),\n" +
                    "fechaxSem date\n" +
                    ")\n" +
                    "go\n"+
                "create table CabOrdenDeVenta(\n" +
                    "ordenDeVentaID int constraint pkOrdenDeVentaID primary key,\n" +
                    "empleadoID int,\n" +
                    "clienteID int,\n" +
                    "mesaID int,\n" +
                    "fechaVenta datetime,\n" +
                    "metodoPago int,\n" +
                    "tipEntrega varchar(15)\n" +
                    ")\n" +
                    "go\n" +
                    "create table CabReceta(\n" +
                    "recetaID int constraint pkRecetaID primary key,\n" +
                    "empleadoID int,\n" +
                    "productoID int,\n" +
                    "fechaElab date,\n" +
                    "preparacion varchar(300)\n" +
                    ")\n" +
                    "go\n"+
                "create table Cliente(\n" +
                    "clienteID int constraint pkClienteID primary key,\n" +
                    "nombres varchar(40),\n" +
                    "apellidos varchar(40),\n" +
                    "dni varchar(8),\n" +
                    "genero int,\n" +
                    "estadoCivil varchar(10),\n" +
                    "telefono int,\n" +
                    "correo varchar(20),\n" +
                    "fechNaci date,\n" +
                    "estado int,\n" +
                    "direccion varchar(30)\n" +
                    ")\n" +
                    "go\n" +
                    "create table Contrato(\n" +
                    "contratoID int constraint pkContratoID primary key,\n" +
                    "empleadoID int,\n" +
                    "rolID int,\n" +
                    "areaID int,\n" +
                    "fechaIni date,\n" +
                    "fechaFin date,\n" +
                    "estado int,\n" +
                    "sueldo float\n" +
                    ")\n" +
                    "go\n"+
                "create table DetOrdenDeProduccionSemanal(\n" +
                    "ordenProduccionID int,\n" +
                    "productoID int,\n" +
                    "cantidad int,\n" +
                    "estado int\n" +
                    ")\n" +
                    "go\n" +
                    "create table DetOrdenDeVenta(\n" +
                    "ordenDeVentaID int,\n" +
                    "productoID int,\n" +
                    "idPedidos int,\n" +
                    "cantidad int\n" +
                    ")\n" +
                    "go\n" +
                    "create table DetReceta(\n" +
                    "recetaID int,\n" +
                    "insumoID int,\n" +
                    "cantidad int\n" +
                    ")\n" +
                    "go\n" +
                    "create table Empleado(\n" +
                    "empleadoID int constraint pkEmpleadoID primary key,\n" +
                    "usuarioModifiID int,\n" +
                    "usuarioCreaID int,\n" +
                    "nombres varchar(40),\n" +
                    "apellidos varchar(40),\n" +
                    "fechaNacimiento date,\n" +
                    "fechCrea date,\n" +
                    "genero int,\n" +
                    "fechModif date,\n" +
                    "dni varchar(8),\n" +
                    "estadoCivil varchar(10)\n" +
                    ")\n" +
                    "go\n"+
                "create table Insumo(\n" +
                    "insumoID int constraint pkInsumoID primary key,\n" +
                    "idTipInsumo int,\n" +
                    "unidadMedida varchar(10),\n" +
                    "descripInsumo varchar(20),\n" +
                    "precioUnit float,\n" +
                    "cantidad int\n" +
                    ")\n" +
                    "go\n" +
                    "create table LocalR(\n" +
                    "idLocalR int constraint pkIdLocalR primary key,\n" +
                    "Ubicacion varchar(30),\n" +
                    "capcidadMax int,\n" +
                    "pisos int,\n" +
                    "horaApertura time,\n" +
                    "horaCerrado time\n" +
                    ")\n" +
                    "go\n" +
                    "create table Mesa(\n" +
                    "mesaID int constraint pkMesaID primary key,\n" +
                    "ubic varchar(30),\n" +
                    "numSillas int,\n" +
                    "estado int\n" +
                    ")\n" +
                    "go\n" +
                    "create table Pedidos(\n" +
                    "idPedidos int constraint pkIdPedidos primary key,\n" +
                    "empleadoID int,\n" +
                    "ubic varchar(30),\n" +
                    "estado int\n" +
                    ")\n" +
                    "go\n" +
                    "create table Plato(\n" +
                    "idPlato int constraint pkIdPlato primary key,\n" +
                    "descPlato varchar(30)\n" +
                    ")\n" +
                    "go\n"+
                "create table Producto(\n" +
                    "productoID int constraint pkProductoID primary key,\n" +
                    "idPlato int,\n" +
                    "idTipProducto int,\n" +
                    "descripProducto varchar(40),\n" +
                    "cantidad int,\n" +
                    "precioUnit float\n" +
                    ")\n" +
                    "go\n" +
                    "create table Reserva(\n" +
                    "reservaID int constraint pkReservaID primary key,\n" +
                    "empleadoID int,\n" +
                    "clienteID int,\n" +
                    "fecha date,\n" +
                    "estado int\n" +
                    ")\n" +
                    "go\n" +
                    "create table Rol(\n" +
                    "rolID int constraint pkRolID primary key,\n" +
                    "descripRol varchar(25)\n" +
                    ")\n" +
                    "go\n" +
                    "create table TipInsumo(\n" +
                    "idTipInsumo int constraint pkIdTipInsumo primary key,\n" +
                    "descripcion varchar(25)\n" +
                    ")\n" +
                    "go\n" +
                    "create table TipProducto(\n" +
                    "idTipProducto int constraint pkIdTipProducto primary key,\n" +
                    "descripcion varchar(15)\n" +
                    ")\n" +
                    "go\n" +
                    "create table Usuario(\n" +
                    "usuarioID int constraint pkUsuarioID primary key,\n" +
                    "idLocalR int,\n" +
                    "usuario varchar(25),\n" +
                    "contraseña varchar(20),\n" +
                    "tipoUsuario int\n" +
                    ")"+ "\ngo"+
                       
                    "alter table CabOrdenDeProduccionSemanal\n" +
                    "add constraint fkEmpleadoID foreign key (empleadoID) references Empleado(empleadoID)\n" +
                    "go\n" +
                    "alter table CabOrdenDeVenta\n" +
                    "add constraint fk1EmpleadoID foreign key (empleadoID) references Empleado(empleadoID),\n" +
                    "constraint fkClienteID foreign key (clienteID) references Cliente(clienteID),\n" +
                    "constraint fkMesaID foreign key (mesaID) references Mesa(mesaID)\n" +
                    "go\n" +
                    "alter table CabReceta\n" +
                    "add constraint fk2EmpleadoID foreign key (empleadoID) references Empleado(empleadoID),\n" +
                    "constraint fkProductoID foreign key (productoID) references Producto(productoID)\n" +
                    "go\n" +
                    "alter table Contrato\n" +
                    "add constraint fk3EmpleadoID foreign key (empleadoID) references Empleado(empleadoID),\n" +
                    "constraint fkRolID foreign key (rolID) references Rol(rolID),\n" +
                    "constraint fkAreaID foreign key (areaID) references Area(areaID)\n" +
                    "go\n" +
                    "alter table DetOrdenDeProduccionSemanal\n" +
                    "add constraint fk1ProductoID foreign key (productoID) references Producto(productoID),\n" +
                    "constraint fkOrdenProduccionID foreign key (ordenProduccionID) references CabOrdenDeProduccionSemanal(ordenProduccionID)\n" +
                    "go\n" +
                    "alter table DetOrdenDeVenta\n" +
                    "add constraint fk2ProductoID foreign key (productoID) references Producto(productoID),\n" +
                    "constraint fkIdPedidos foreign key (idPedidos) references Pedidos(idPedidos),\n" +
                    "constraint fkOrdenDeVentaID foreign key (ordenDeVentaID) references CabOrdenDeVenta(ordenDeVentaID)\n" +
                    "go\n" +
                    "alter table DetReceta\n" +
                    "add constraint fkInsumoID foreign key (insumoID) references Insumo(insumoID),\n" +
                    "constraint fkRecetaID foreign key (recetaID) references CabReceta(recetaID)\n" +
                    "go\n" +
                    "alter table Insumo\n" +
                    "add constraint fkIdTipInsumo foreign key (idTipInsumo) references TipInsumo(idTipInsumo)\n" +
                    "go\n" +
                    "alter table Usuario\n" +
                    "add constraint fkIdLocalR foreign key (idLocalR) references LocalR(idLocalR),\n" +
                    "empleadoID int FOREIGN KEY REFERENCES Empleado(empleadoID),\n" +
                    "CONSTRAINT FK_Usuario_Empleado UNIQUE(empleadoID)\n" +
                    "go\n" +
                    "alter table Pedidos\n" +
                    "add constraint fk4EmpleadoID foreign key (empleadoID) references Empleado(empleadoID)\n" +
                    "go\n" +
                    "alter table Producto\n" +
                    "add constraint fkIdPlato foreign key (idPlato) references Plato(idPlato),\n" +
                    "constraint fkIdTipProducto foreign key (idTipProducto) references TipProducto(idTipProducto)\n" +
                    "go\n" +
                    "alter table Reserva\n" +
                    "add constraint fk5EmpleadoID foreign key (empleadoID) references Empleado(empleadoID),\n" +
                    "constraint fk1ClienteID foreign key (clienteID) references Cliente(clienteID)\n";

        Paragraph parrafo = new Paragraph(texto, new Font(Font.FontFamily.TIMES_ROMAN, 12));
        documento.add(parrafo);        
        
    
        documento.close();
    
        }catch(DocumentException | HeadlessException | FileNotFoundException e){
        
            e.printStackTrace();  
        }
    }
    
    public void crearBD(){
    
        if (this.valida()==true){
        
            empleado.setEmpleadoID(1001);
            empleado.setUsuarioModifID(1001);
            empleado.setUsuarioCreaID(1001);
            empleado.setNombres(this.txt_nomUsuario_logDefecto.getText());
            empleado.setApellidos(this.txt_apellidos_logDefecto.getText());
            empleado.setFechaNacimiento(this.txt_fechaNac_logDefecto.getText());
            empleado.setFechCrea("2025-02-10");
            if(this.cmb_genero_logDefecto.getSelectedItem().equals("MASCULINO")){
                empleado.setGenero(1);
            }else if(this.cmb_genero_logDefecto.getSelectedItem().equals("FEMENINO")){
                empleado.setGenero(0);
            }
            empleado.setFechModif("2025-02-10");
            empleado.setDni(this.txt_dni_logDefecto.getText());
            empleado.setEstadoCivil(this.cmb_estadoCivil_logDefecto.getSelectedItem().toString());
        
            idLocal = Integer.parseInt(this.txt_id_local_logDefecto.getText());
            local.setIdLocalR(Integer.parseInt(this.txt_id_local_logDefecto.getText()));
            local.setUbicacion(this.txt_ubicacion_logDefecto.getText());
            local.setCapcidadMax(Integer.parseInt(this.txt_capacidad_logDefecto.getText()));
            local.setPisos(Integer.parseInt(this.txt_pisos_logDefecto.getText()));
            local.setHoraApertura("23:59:59.9999999");
            local.setHoraCerrado("23:59:59.9999999");
            
            usuario.setUsuarioID(101);
            usuario.setIdLocalR(Integer.parseInt(this.txt_id_local_logDefecto.getText()));
            usuario.setUsuario(this.txt_nomUsuario_logDefecto.getText());
            usuario.setContrasena(this.txt_contra_logDefecto.getText());
            usuario.setTipoUsuario(1);
            usuario.setIdEmpleado(1001);
            
            this.inicia.creacionBD(empleado, usuario, local);
            
            try {
                this.creaPDF();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LoginDefecto.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "PDF DE REFERENCIA DE LA BD CREADA en DESCARGAS...");
            login.setVisible(true);
            this.dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_id_local_logDefecto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_nomUsuario_logDefecto = new javax.swing.JTextField();
        txt_contra_logDefecto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_apellidos_logDefecto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_fechaNac_logDefecto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_dni_logDefecto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmb_genero_logDefecto = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmb_estadoCivil_logDefecto = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_ubicacion_logDefecto = new javax.swing.JTextField();
        txt_capacidad_logDefecto = new javax.swing.JTextField();
        txt_pisos_logDefecto = new javax.swing.JTextField();
        btn_grabar_logDefecto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("REGISTRO ADMINISTRADOR");

        jLabel2.setText("ID LOCAL");

        jLabel3.setText("NOMBRE USUARIO");

        jLabel4.setText("CONTRASEÑA");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("EMPLEADO"));

        jLabel5.setText("APELLIDOS");

        jLabel6.setText("FECHA NAC.");

        jLabel7.setText("GENERO");

        jLabel8.setText("DNI");

        jLabel9.setText("ESTADO CIVIL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_apellidos_logDefecto)
                    .addComponent(txt_fechaNac_logDefecto)
                    .addComponent(txt_dni_logDefecto)
                    .addComponent(cmb_genero_logDefecto, 0, 120, Short.MAX_VALUE)
                    .addComponent(cmb_estadoCivil_logDefecto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_apellidos_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_fechaNac_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmb_genero_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_dni_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmb_estadoCivil_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("LOCAL"));

        jLabel10.setText("UBICACION");

        jLabel11.setText("CAPACIDAD MAX");

        jLabel12.setText("PISOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_ubicacion_logDefecto, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(txt_capacidad_logDefecto)
                    .addComponent(txt_pisos_logDefecto))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_ubicacion_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txt_capacidad_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txt_pisos_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btn_grabar_logDefecto.setText("GRABAR");
        btn_grabar_logDefecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabar_logDefectoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_id_local_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nomUsuario_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_contra_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(btn_grabar_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_id_local_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nomUsuario_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_contra_logDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_grabar_logDefecto, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_grabar_logDefectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabar_logDefectoActionPerformed
        this.crearBD();
    }//GEN-LAST:event_btn_grabar_logDefectoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_grabar_logDefecto;
    private javax.swing.JComboBox<String> cmb_estadoCivil_logDefecto;
    private javax.swing.JComboBox<String> cmb_genero_logDefecto;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_apellidos_logDefecto;
    private javax.swing.JTextField txt_capacidad_logDefecto;
    private javax.swing.JTextField txt_contra_logDefecto;
    private javax.swing.JTextField txt_dni_logDefecto;
    private javax.swing.JTextField txt_fechaNac_logDefecto;
    private javax.swing.JTextField txt_id_local_logDefecto;
    private javax.swing.JTextField txt_nomUsuario_logDefecto;
    private javax.swing.JTextField txt_pisos_logDefecto;
    private javax.swing.JTextField txt_ubicacion_logDefecto;
    // End of variables declaration//GEN-END:variables
}
