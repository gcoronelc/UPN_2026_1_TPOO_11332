
package DAO;

import BEAN.Empleado;
import BEAN.LocalR;
import BEAN.Usuario;
import UTIL.creaBD;

public class inciaBdDao {
    public inciaBdDao() {
    }
    
    public void creacionBD(Empleado emp, Usuario user, LocalR local){
    
        String sql;
        creaBD crea = new creaBD(); 
        

        try{

                sql = " use master\n " +
                        " " +
                        " CREATE DATABASE restaurante\n"+
                        "  " ;
                crea.accesoBDCrea(sql); 
                System.out.println("exito");
                
                String cuerpo =   " use restaurante\n" +
                        " " +
                        " "+
                        " create table Area(" +
                        " areaID int constraint pkareaID primary key," +
                        " descripArea varchar(40) " +
                        ")\n"+
                        " "+
                        " create table CabOrdenDeProduccionSemanal(" +
                        " ordenProduccionID int constraint pkOrdenProduccionID primary key, " +
                        " empleadoID int, " +
                        " descripArea varchar(40), " +
                        " fechaxSem date " +
                        " ) " +
                        " " +
                        " create table CabOrdenDeVenta( " +
                        " ordenDeVentaID int constraint pkOrdenDeVentaID primary key, " +
                        " empleadoID int, " +
                        " clienteID int, " +
                        " mesaID int, " +
                        " fechaVenta datetime, " +
                        " metodoPago int, " +
                        " tipEntrega varchar(15) " +
                        " ) " +
                        " " +
                        " create table CabReceta( " +
                        " recetaID int constraint pkRecetaID primary key, " +
                        " empleadoID int, " +
                        " productoID int, " +
                        " fechaElab date, " +
                        " preparacion varchar(300) " +
                        " )\n " +
                        " " +
                        " create table Cliente( " +
                        " clienteID int constraint pkClienteID primary key, " +
                        " nombres varchar(40), " +
                        " apellidos varchar(40), " +
                        " dni varchar(8), " +
                        " genero int, " +
                        " estadoCivil varchar(10), " +
                        " telefono int, " +
                        " correo varchar(20), " +
                        " fechNaci date, " +
                        " estado int, " +
                        " direccion varchar(30) " +
                        " )\n " +
                        " " +
                        " create table Contrato( " +
                        " contratoID int constraint pkContratoID primary key, " +
                        " empleadoID int, " +
                        " rolID int, " +
                        " areaID int, " +
                        " fechaIni date, " +
                        " fechaFin date, " +
                        " estado int, " +
                        " sueldo float " +
                        " ) \n" +
                        " " +
                        " create table DetOrdenDeProduccionSemanal( " +
                        " ordenProduccionID int, " +
                        " productoID int, " +
                        " cantidad int, " +
                        " estado int " +
                        " )\n" +
                        " " +
                        " create table DetOrdenDeVenta( " +
                        " ordenDeVentaID int, " +
                        " productoID int, " +
                        " idPedidos int, " +
                        " cantidad int " +
                        " )\n" +
                        " " +
                        " create table DetReceta( " +
                        " recetaID int, " +
                        " insumoID int, " +
                        " cantidad int " +
                        " )\n" +
                        " " +
                        " create table Empleado( " +
                        " empleadoID int constraint pkEmpleadoID primary key, " +
                        " usuarioModifiID int, "+
                        " usuarioCreaID int, " +
                        " nombres varchar(40), " +
                        " apellidos varchar(40), " +
                        " fechaNacimiento date, " +
                        " fechCrea date, " +
                        " genero int, " +
                        " fechModif date, " +
                        " dni varchar(8), " +
                        " estadoCivil varchar(10) " +
                        " )\n" +
                        " " +
                        "create table Insumo( " +
                        "insumoID int constraint pkInsumoID primary key, " +
                        "idTipInsumo int, " +
                        "unidadMedida varchar(10), " +
                        "descripInsumo varchar(20), " +
                        "precioUnit float, " +
                        "cantidad int " +
                        " )\n" +
                        " " +
                        "create table LocalR( " +
                        " idLocalR int constraint pkIdLocalR primary key, " +
                        " Ubicacion varchar(30), " +
                        " capcidadMax int, " +
                        " pisos int, " +
                        " horaApertura time, " +
                        " horaCerrado time " +
                        " )\n" +
                        " " +
                        " create table Mesa( " +
                        " mesaID int constraint pkMesaID primary key, " +
                        " ubic varchar(30), " +
                        " numSillas int, " +
                        " estado int " +
                        " )\n" +
                        " " +
                        " create table Pedidos( " +
                        " idPedidos int constraint pkIdPedidos primary key, " +
                        " empleadoID int, " +
                        " ubic varchar(30), " +
                        " estado int " +
                        ")\n" +
                        " " +
                        " create table Plato(" +
                        " idPlato int constraint pkIdPlato primary key, " +
                        " descPlato varchar(30) " +
                        " )\n" +
                        " " +
                        " create table Producto( " +
                        " productoID int constraint pkProductoID primary key, " +
                        " idPlato int, " +
                        " idTipProducto int, " +
                        " descripProducto varchar(40), " +
                        " cantidad int, " +
                        " precioUnit float " +
                        " )\n" +
                        " " +
                        " create table Reserva( " +
                        " reservaID int constraint pkReservaID primary key, " +
                        " empleadoID int, " +
                        " clienteID int, " +
                        " fecha date, " +
                        " estado int " +
                        " )\n" +
                        " " +
                        " create table Rol( " +
                        " rolID int constraint pkRolID primary key, " +
                        " descripRol varchar(25) " +
                        " )\n" +
                        " " +
                        " create table TipInsumo( " +
                        " idTipInsumo int constraint pkIdTipInsumo primary key, " +
                        " descripcion varchar(25) " +
                        ")\n" +
                        " " +
                        " create table TipProducto( " +
                        " idTipProducto int constraint pkIdTipProducto primary key, " +
                        " descripcion varchar(15) " +
                        " )\n" +
                        " " +
                        " create table Usuario( " +
                        " usuarioID int constraint pkUsuarioID primary key, " +
                        " idLocalR int, " +
                        " usuario varchar(25), " +
                        " contraseña varchar(20), " +
                        " tipoUsuario int " +
                        " )\n" +
                        " ";
                
                crea.accesoBDCrea(cuerpo);
                
                System.out.println("exito2");
                     String alters =  " use restaurante\n" +
                        " " +
                        " "+ " alter table CabOrdenDeProduccionSemanal\n " +
                        " add constraint fkEmpleadoID foreign key (empleadoID) references Empleado(empleadoID) " +
                        " " +
                        " alter table CabOrdenDeVenta\n" +
                        " add constraint fk1EmpleadoID foreign key (empleadoID) references Empleado(empleadoID)," +
                        " constraint fkClienteID foreign key (clienteID) references Cliente(clienteID), " +
                        " constraint fkMesaID foreign key (mesaID) references Mesa(mesaID) " +
                        " " +
                        " alter table CabReceta " +
                        " add constraint fk2EmpleadoID foreign key (empleadoID) references Empleado(empleadoID), " +
                        " constraint fkProductoID foreign key (productoID) references Producto(productoID) " +
                        " " +
                        " alter table Contrato " +
                        " add constraint fk3EmpleadoID foreign key (empleadoID) references Empleado(empleadoID), " +
                        " constraint fkRolID foreign key (rolID) references Rol(rolID), " +
                        " constraint fkAreaID foreign key (areaID) references Area(areaID) " +
                        " " +
                        " alter table DetOrdenDeProduccionSemanal " +
                        " add constraint fk1ProductoID foreign key (productoID) references Producto(productoID), " +
                        " constraint fkOrdenProduccionID foreign key (ordenProduccionID) references CabOrdenDeProduccionSemanal(ordenProduccionID) " +
                        " " +
                        " alter table DetOrdenDeVenta " +
                        " add constraint fk2ProductoID foreign key (productoID) references Producto(productoID), " +
                        " constraint fkIdPedidos foreign key (idPedidos) references Pedidos(idPedidos), " +
                        " constraint fkOrdenDeVentaID foreign key (ordenDeVentaID) references CabOrdenDeVenta(ordenDeVentaID) " +
                        " " +
                        " alter table DetReceta\n" +
                        " add constraint fkInsumoID foreign key (insumoID) references Insumo(insumoID), " +
                        " constraint fkRecetaID foreign key (recetaID) references CabReceta(recetaID) " +
                        " " +
                        " alter table Insumo\n" +
                        " add constraint fkIdTipInsumo foreign key (idTipInsumo) references TipInsumo(idTipInsumo) " +
                        " " +
                        " alter table Usuario\n" +
                        " add constraint fkIdLocalR foreign key (idLocalR) references LocalR(idLocalR), " +
                        " empleadoID int FOREIGN KEY REFERENCES Empleado(empleadoID), " +
                        " CONSTRAINT FK_Usuario_Empleado UNIQUE(empleadoID) " +
                        " " +
                        " alter table Pedidos " +
                        " add constraint fk4EmpleadoID foreign key (empleadoID) references Empleado(empleadoID) " +
                        " " +
                        " alter table Producto\n" +
                        " add constraint fkIdPlato foreign key (idPlato) references Plato(idPlato), " +
                        " constraint fkIdTipProducto foreign key (idTipProducto) references TipProducto(idTipProducto) " +
                        " " +
                        " alter table Reserva\n" +
                        " add constraint fk5EmpleadoID foreign key (empleadoID) references Empleado(empleadoID), " +
                        " constraint fk1ClienteID foreign key (clienteID) references Cliente(clienteID) "+
                        " " ;
                     crea.accesoBDCrea(alters);
                     System.out.println("exito 3");
                     
                     String insert1 =" use restaurante\n" +
                        " " +
                        " "+ 
                        " "+"\ninsert into empleado values ("+emp.getEmpleadoID()+","+emp.getUsuarioModifID()+","+emp.getUsuarioCreaID()+",'"+emp.getNombres()+"','"+emp.getApellidos()+"','"+emp.getFechaNacimiento()+"','"+emp.getFechCrea()+"',"+emp.getGenero()+",'"+emp.getFechModif()+"','"+emp.getDni()+"','"+emp.getEstadoCivil()+"')";
                     crea.accesoBDCrea(insert1);
                     System.out.println("exito4");
                     
                     String insert2 =
                     
                            " use restaurante\n" +
                        " " +
                        " "+"\ninsert into localR values("+local.getIdLocalR()+",'"+local.getUbicacion()+"',"+local.getCapcidadMax()+","+local.getPisos()+",'"+local.getHoraApertura()+"','"+local.getHoraCerrado()+"')";
                     crea.accesoBDCrea(insert2);
                     System.out.println("exito5");
                     
                     String insert3 =" use restaurante\n" +
                        " " +
                        " "+
                            "\ninsert into usuario values("+user.getUsuarioID()+","+user.getIdLocalR()+",'"+user.getUsuario()+"','"+user.getContrasena()+"',"+user.getTipoUsuario()+","+user.getIdEmpleado()+")";
                     crea.accesoBDCrea(insert3);
                     System.out.println("exito6");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    
    }
    
    public void completaBD(int id){

        
        creaBD crea = new creaBD(); 
        try{
        String sql1 =  " use restaurante "+
                        " " +
                        " "+ 
                    " insert into Plato values (30, 'entrada');  " +
                    " insert into Plato values (31, 'menú');  " +
                    " insert into Plato values (32, 'sopa');  " +
                    " " ;
                    crea.accesoBDCrea(sql1);
                    System.out.println("se inserto plato");
                  
        String sql2 = " use restaurante "+" "+" " 
                   +" insert into TipProducto values (40, 'envasado'); " +
                    " insert into TipProducto values (41, 'preparado'); ";
                    crea.accesoBDCrea(sql2);
                    System.out.println("se inserto tipProducto");
       
       String sql3 = " use restaurante "+" "+" "  
                   +" insert into Producto values(50, 30, 41, 'tequeños',10,10); " +
                    " insert into Producto values(51, 31, 41, 'lomosaltado', 15, 10); ";
                    crea.accesoBDCrea(sql3);
                    System.out.println("se inserto producto");
       
      String sql4 = " use restaurante " +" "+" " 
                   + " insert into TipInsumo values(10,'perecible'); " +
                     " insert into TipInsumo values(11,'No perecible'); ";
                     crea.accesoBDCrea(sql4);
                     System.out.println("se inserto insumo");
                  
      String sql5 =  " use restaurante " +" "+" " 
                   +  " insert into Insumo values(20, 10, 'gramos', 'pollo', 10,15); " +
                     " insert into Insumo values(21, 10, 'gramos', 'pescado', 10,15); " +
                     " insert into Insumo values(22, 10, 'gramos', 'embutidos', 10,15); "+
                     " insert into Insumo values(23, 11, 'gramos', 'atún enlatado', 10,15); " +
                     " insert into Insumo values(24, 11, 'gramos', 'arroz', 10,15); " +
                     " insert into Insumo values(25, 11, 'gramos', 'frijol', 10,15); ";
                     crea.accesoBDCrea(sql5);
                     System.out.println("se inserto tipinsumo");
      
      String sql6 = " use restaurante " +" "+" " +
                    " insert into rol values (400, 'Recepcionista'); " +
                    " insert into rol values (401, 'Mesero'); " +
                    " insert into rol values (402, 'Cocinero'); " +
                    " insert into rol values (403, 'Personal de Limpieza'); ";
                    crea.accesoBDCrea(sql6);
                    System.out.println("se inserto rol");
      
     String sql7 = " use restaurante " +" "+" " +
                   " insert into area values (500, 'Recepción'); " +
                   " insert into area values (501, 'Atención al Cliente'); " +
                   " insert into area values (502, 'Preparación'); " +
                   " insert into area values (503, 'Limpieza'); ";
                   crea.accesoBDCrea(sql7);
                   System.out.println("se inserto area");
     
     String sql8 = " use restaurante " +" "+" " +
                   " insert into empleado values (1002, 1001, 1001, 'Daniel', 'Dramos', '2004-01-15', '2023-07-04', 1,'2023-07-04', '33333333', 'SOLTERO'); " +
                    " insert into empleado values (1003, 1001, 1001, 'Glem', 'Cramos', '2004-01-16', '2023-07-04', 1,'2023-07-04', '44444444', 'SOLTERO'); " +
                    " insert into empleado values (1004, 1001, 1001, 'Alonzo', 'Piton', '2004-01-17', '2023-07-04', 1,'2023-07-04', '55555555', 'SOLTERO'); " +
                    " insert into empleado values (1005, 1001, 1001, 'Manuel', 'Secni', '2004-01-18', '2023-07-04', 1,'2023-07-04', '66666666', 'SOLTERO'); " +
                    " " +
                    " insert into empleado values (1006, 1001, 1001, 'laDaniel', 'Dramos', '2004-01-15', '2023-07-04', 1,'2023-07-04', '33333333', 'SOLTERO'); " +
                    " insert into empleado values (1007, 1001, 1001, 'laGlem', 'Cramos', '2004-01-16', '2023-07-04', 1,'2023-07-04', '44444444', 'SOLTERO'); " +
                    " insert into empleado values (1008, 1001, 1001, 'laAlonzo', 'Piton', '2004-01-17', '2023-07-04', 1,'2023-07-04', '55555555', 'SOLTERO'); " +
                    " insert into empleado values (1009, 1001, 1001, 'laManuel', 'Secni', '2004-01-18', '2023-07-04', 1,'2023-07-04', '66666666', 'SOLTERO'); " +
                    " " +
                    " insert into empleado values (1010, 1001, 1001, 'zzlaDaniel', 'Dramos', '2004-01-15', '2023-07-04', 1,'2023-07-04', '33333333', 'SOLTERO'); " +
                    " insert into empleado values (1011, 1001, 1001, 'zzlaGlem', 'Cramos', '2004-01-16', '2023-07-04', 1,'2023-07-04', '44444444', 'SOLTERO'); " +
                    " insert into empleado values (1012, 1001, 1001, 'zzlaAlonzo', 'Piton', '2004-01-17', '2023-07-04', 1,'2023-07-04', '55555555', 'SOLTERO'); " +
                    " insert into empleado values (1013, 1001, 1001, 'zzlaManuel', 'Secni', '2004-01-18', '2023-07-04', 1,'2023-07-04', '66666666', 'SOLTERO'); ";
                    crea.accesoBDCrea(sql8);
                    System.out.println("se inserto empleados");
                    
     String sql9 = " use restaurante " +" "+" " +
                   " insert into Usuario values (102,"+id+", 'Daniel', '123456789', 1, 1002); " +
                    " insert into Usuario values (103,"+id+", 'Glem', '123456789', 1, 1003); " +
                    " insert into Usuario values (104, "+id+", 'Alonzo', '123456789', 1, 1004); " +
                    " insert into Usuario values (105, "+id+", 'Manuel', '123456789', 1, 1005); " +
                    " " +
                    " insert into Usuario values (106, "+id+", 'laDaniel', '123456789', 2, 1006); " +
                    " insert into Usuario values (107,"+id+", 'laGlem', '123456789', 2, 1007); " +
                    " insert into Usuario values (108, "+id+", 'laAlonzo', '123456789', 2, 1008); " +
                    " insert into Usuario values (109, "+id+", 'laManuel', '123456789', 2, 1009); " +
                    " " +
                    " " +
                    " insert into Usuario values (110, "+id+", 'zzDaniel', '123456789', 3, 1010); " +
                    " insert into Usuario values (111, "+id+", 'zzGlem', '123456789', 3, 1011); " +
                    " insert into Usuario values (112, "+id+", 'zzAlonzo', '123456789', 4, 1012); " +
                    " insert into Usuario values (113, "+id+", 'zzManuel', '123456789', 4, 1013); ";
                    crea.accesoBDCrea(sql9);
                    System.out.println("se inserto usuarios");
                    
    String sql10 = " use restaurante " +" "+" " +
                 " insert into Contrato values (001, 1001, 400, 500, '2023-07-04', '2110-07-04', 1, 50000); " +
                " insert into Contrato values (002, 1002, 400, 500, '2023-07-04', '2110-07-04', 1, 30000); " +
                " insert into Contrato values (003, 1003, 400, 500, '2023-07-04', '2110-07-04', 1, 50000); " +
                " insert into Contrato values (004, 1004, 400, 500, '2023-07-04', '2110-07-04', 1, 30000); " +
                " insert into Contrato values (005, 1005, 400, 500, '2023-07-04', '2110-07-04', 1, 30000); " +
                " " +
                " insert into Contrato values (006, 1006, 400, 500, '2023-07-04', '2110-07-04', 0, 30000); " +
                " insert into Contrato values (007, 1007, 400, 500, '2023-07-04', '2110-07-04', 0, 30000); ";

                crea.accesoBDCrea(sql10);
                System.out.println("se inserto contratos");
                
    String sql11 = " use restaurante " +" "+" " +
                    " insert into cliente values(90, 'tanos', 'cronos', '63636363', 1, 'SOLTERO', '99999999','miin@gmail.com','2003-01-01',1,'surco'); " +
                    " " +
                    " insert into cliente values(91, 'homero','simpsonp', '63636363', 1, 'SOLTERO', '99999999','miin@gmail.com','2003-01-01',1,'surco'); ";
                 crea.accesoBDCrea(sql11);
                 System.out.println("se inserto clientes");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
