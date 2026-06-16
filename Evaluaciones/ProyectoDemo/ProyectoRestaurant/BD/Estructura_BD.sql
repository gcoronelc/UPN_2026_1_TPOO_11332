use master
go
create database restaurante
go
use restaurante
go
create table Area(
areaID int constraint pkareaID primary key,
descripArea varchar(40)
)
go
create table CabOrdenDeProduccionSemanal(
ordenProduccionID int constraint pkOrdenProduccionID primary key,
empleadoID int,
descripArea varchar(40),
fechaxSem date
)
go
create table CabOrdenDeVenta(
ordenDeVentaID int constraint pkOrdenDeVentaID primary key,
empleadoID int,
clienteID int,
mesaID int,
fechaVenta datetime,
metodoPago int,
tipEntrega varchar(15)
)
go
create table CabReceta(
recetaID int constraint pkRecetaID primary key,
empleadoID int,
productoID int,
fechaElab date,
preparacion varchar(300)
)
go
create table Cliente(
clienteID int constraint pkClienteID primary key,
nombres varchar(40),
apellidos varchar(40),
dni varchar(8),
genero int,
estadoCivil varchar(10),
telefono int,
correo varchar(20),
fechNaci date,
estado int,
direccion varchar(30)
)
go
create table Contrato(
contratoID int constraint pkContratoID primary key,
empleadoID int,
rolID int,
areaID int,
fechaIni date,
fechaFin date,
estado int,
sueldo float
)
go
create table DetOrdenDeProduccionSemanal(
ordenProduccionID int,
productoID int,
cantidad int,
estado int
)
go
create table DetOrdenDeVenta(
ordenDeVentaID int,
productoID int,
idPedidos int,
cantidad int
)
go
create table DetReceta(
recetaID int,
insumoID int,
cantidad int
)
go
create table Empleado(
empleadoID int constraint pkEmpleadoID primary key,
usuarioModifiID int,
usuarioCreaID int,
nombres varchar(40),
apellidos varchar(40),
fechaNacimiento date,
fechCrea date,
genero int,
fechModif date,
dni varchar(8),
estadoCivil varchar(10)
)
go
create table Insumo(
insumoID int constraint pkInsumoID primary key,
idTipInsumo int,
unidadMedida varchar(10),
descripInsumo varchar(20),
precioUnit float,
cantidad int
)
go
create table LocalR(
idLocalR int constraint pkIdLocalR primary key,
Ubicacion varchar(30),
capcidadMax int,
pisos int,
horaApertura time,
horaCerrado time
)
go
create table Mesa(
mesaID int constraint pkMesaID primary key,
ubic varchar(30),
numSillas int,
estado int
)
go
create table Pedidos(
idPedidos int constraint pkIdPedidos primary key,
empleadoID int,
ubic varchar(30),
estado int
)
go
create table Plato(
idPlato int constraint pkIdPlato primary key,
descPlato varchar(30)
)
go
create table Producto(
productoID int constraint pkProductoID primary key,
idPlato int,
idTipProducto int,
descripProducto varchar(40),
cantidad int,
precioUnit float
)
go
create table Reserva(
reservaID int constraint pkReservaID primary key,
empleadoID int,
clienteID int,
fecha date,
estado int
)
go
create table Rol(
rolID int constraint pkRolID primary key,
descripRol varchar(25)
)
go
create table TipInsumo(
idTipInsumo int constraint pkIdTipInsumo primary key,
descripcion varchar(25)
)
go
create table TipProducto(
idTipProducto int constraint pkIdTipProducto primary key,
descripcion varchar(15)
)
go
create table Usuario(
usuarioID int constraint pkUsuarioID primary key,
idLocalR int,
usuario varchar(25),
contraseña varchar(20),
tipoUsuario int
)
-- Correciones
alter table CabOrdenDeProduccionSemanal
add constraint fkEmpleadoID foreign key (empleadoID) references Empleado(empleadoID)
go
alter table CabOrdenDeVenta
add constraint fk1EmpleadoID foreign key (empleadoID) references Empleado(empleadoID),
constraint fkClienteID foreign key (clienteID) references Cliente(clienteID),
constraint fkMesaID foreign key (mesaID) references Mesa(mesaID)
go
alter table CabReceta
add constraint fk2EmpleadoID foreign key (empleadoID) references Empleado(empleadoID),
constraint fkProductoID foreign key (productoID) references Producto(productoID)
go
alter table Contrato
add constraint fk3EmpleadoID foreign key (empleadoID) references Empleado(empleadoID),
constraint fkRolID foreign key (rolID) references Rol(rolID),
constraint fkAreaID foreign key (areaID) references Area(areaID)
go
alter table DetOrdenDeProduccionSemanal
add constraint fk1ProductoID foreign key (productoID) references Producto(productoID),
constraint fkOrdenProduccionID foreign key (ordenProduccionID) references CabOrdenDeProduccionSemanal(ordenProduccionID)
go
alter table DetOrdenDeVenta
add constraint fk2ProductoID foreign key (productoID) references Producto(productoID),
constraint fkIdPedidos foreign key (idPedidos) references Pedidos(idPedidos),
constraint fkOrdenDeVentaID foreign key (ordenDeVentaID) references CabOrdenDeVenta(ordenDeVentaID)
go
alter table DetReceta
add constraint fkInsumoID foreign key (insumoID) references Insumo(insumoID),
constraint fkRecetaID foreign key (recetaID) references CabReceta(recetaID)
go
alter table Insumo
add constraint fkIdTipInsumo foreign key (idTipInsumo) references TipInsumo(idTipInsumo)
go
alter table Usuario
add constraint fkIdLocalR foreign key (idLocalR) references LocalR(idLocalR),
empleadoID int FOREIGN KEY REFERENCES Empleado(empleadoID),
CONSTRAINT FK_Usuario_Empleado UNIQUE(empleadoID)
go
alter table Pedidos
add constraint fk4EmpleadoID foreign key (empleadoID) references Empleado(empleadoID)
go
alter table Producto
add constraint fkIdPlato foreign key (idPlato) references Plato(idPlato),
constraint fkIdTipProducto foreign key (idTipProducto) references TipProducto(idTipProducto)
go
alter table Reserva
add constraint fk5EmpleadoID foreign key (empleadoID) references Empleado(empleadoID),
constraint fk1ClienteID foreign key (clienteID) references Cliente(clienteID)