
use restaurante;
--
INSERT INTO Area (areaID, descripArea) VALUES 
(1, 'Cocina'),
(2, 'Atención al Cliente'),
(3, 'Administración');
--
INSERT INTO Rol (rolID, descripRol) VALUES 
(1, 'Chef'),
(2, 'Mesero'),
(3, 'Administrador');
--
INSERT INTO TipInsumo (idTipInsumo, descripcion) VALUES 
(1, 'Verduras'),
(2, 'Carnes'),
(3, 'Lácteos');
--
INSERT INTO TipProducto (idTipProducto, descripcion) VALUES 
(1, 'Entrada'),
(2, 'Plato fuerte'),
(3, 'Postre');
INSERT INTO LocalR (idLocalR, Ubicacion, capcidadMax, pisos, horaApertura, horaCerrado) VALUES 
(1, 'Centro de la ciudad', 100, 2, '08:00', '23:00'),
(2, 'Mall Plaza', 50, 1, '10:00', '22:00');
INSERT INTO Empleado (empleadoID, usuarioModifiID, usuarioCreaID, nombres, apellidos, fechaNacimiento, fechCrea, genero, fechModif, dni, estadoCivil) VALUES 
(1, 1, 1, 'Luis', 'Acuña', '1990-05-12', '2024-02-10', 1, '2024-02-10', '12345678', 'Soltero'),
(2, 1, 1, 'Ana', 'Pérez', '1995-08-20', '2024-02-10', 2, '2024-02-10', '87654321', 'Casado');
INSERT INTO Cliente (clienteID, nombres, apellidos, dni, genero, estadoCivil, telefono, correo, fechNaci, estado, direccion) VALUES 
(1, 'Luis', 'Martínez', '56789123', 1, 'Soltero', 987654321, 'luis@gmail.com', '1992-03-15', 1, 'Av. Siempre Viva'),
(2, 'Marta', 'Rodríguez', '67891234', 2, 'Casado', 999888777, 'marta@gmail.com', '1987-06-30', 1, 'Calle Lima 123');
INSERT INTO Mesa (mesaID, ubic, numSillas, estado) VALUES 
(1, 'Terraza', 4, 1),
(2, 'Interior', 6, 1);
INSERT INTO Usuario (usuarioID, idLocalR, usuario, contraseña, tipoUsuario, empleadoID) VALUES 
(1, 1, 'luis', '123', 1, 1),
(2, 2, 'aperez', 'pass456', 2, 2);
INSERT INTO Producto (productoID, idPlato, idTipProducto, descripProducto, cantidad, precioUnit) VALUES 
(1, 1, 1, 'Ensalada César', 50, 15.00),
(2, 2, 2, 'Lomo Saltado', 30, 25.00),
(3, 3, 3, 'Tiramisú', 20, 12.00);
INSERT INTO Plato (idPlato, descPlato) VALUES 
(1, 'Ensalada'),
(2, 'Plato Principal'),
(3, 'Postre');
INSERT INTO Contrato (contratoID, empleadoID, rolID, areaID, fechaIni, fechaFin, estado, sueldo) VALUES 
(1, 1, 1, 1, '2023-01-01', '2024-12-31', 1, 3500.00),
(2, 2, 2, 2, '2023-06-01', '2024-12-31', 1, 2500.00);
INSERT INTO CabOrdenDeVenta (ordenDeVentaID, empleadoID, clienteID, mesaID, fechaVenta, metodoPago, tipEntrega) VALUES 
(1, 1, 1, 1, '2024-02-10 13:30:00', 1, 'Presencial'),
(2, 2, 2, 2, '2024-02-10 14:00:00', 2, 'Delivery');
INSERT INTO DetOrdenDeVenta (ordenDeVentaID, productoID, idPedidos, cantidad) VALUES 
(1, 1, 1, 2),
(1, 2, 1, 1),
(2, 3, 2, 3);
INSERT INTO CabReceta (recetaID, empleadoID, productoID, fechaElab, preparacion) VALUES 
(1, 1, 1, '2024-02-10', 'Preparar la ensalada con lechuga, queso y pollo'),
(2, 2, 2, '2024-02-10', 'Cocinar el lomo saltado con arroz y papas fritas');
INSERT INTO DetReceta (recetaID, insumoID, cantidad) VALUES 
(1, 1, 5),
(1, 2, 2),
(2, 3, 3);
INSERT INTO DetOrdenDeProduccionSemanal (ordenProduccionID, productoID, cantidad, estado) VALUES 
(1, 1, 20, 1),
(1, 2, 15, 1);
INSERT INTO Pedidos (idPedidos, empleadoID, ubic, estado) VALUES 
(1, 1, 'Mesa 1', 1),
(2, 2, 'Mesa 2', 1);
INSERT INTO Reserva (reservaID, empleadoID, clienteID, fecha, estado) VALUES 
(1, 1, 1, '2024-02-11', 1),
(2, 2, 2, '2024-02-12', 1);
                  
insert into Insumo values(1, 2, 'gramos', 'pescado', 10,15);
insert into Insumo values(2, 1, 'gramos', 'papa', 10,15);
insert into Insumo values(3, 3, 'gramos', 'leche', 10,15);
INSERT INTO CabOrdenDeProduccionSemanal (ordenProduccionID, empleadoID, descripArea, fechaxSem)
VALUES 
(1, 1, 'Cocina', '2025-02-11'),
(2, 2, 'Barra', '2025-02-18');

     
