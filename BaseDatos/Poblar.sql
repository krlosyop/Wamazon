
delimiter :) 
CREATE PROCEDURE agregaUsuario(in u varchar(15),in p varchar(15), in n varchar(20), in ap varchar(20), in am varchar(20))
BEGIN 
	INSERT INTO tbl07_usuario VALUES(null,u,p,n,ap,am,1);
END :)
delimiter ;
call agregaUsuario("lari","123456","Larissa","Arcos","Reyes");
call agregaUsuario("karen","123456","Karen","Romero","Reyes");
call agregaUsuario("Carlos","123456","Carlos","Jimenez","Lopez");

delimiter :) 
CREATE PROCEDURE agregaCategoria(in padre int, in nombre varchar(50))
BEGIN 
	INSERT INTO tbl01_categoria VALUES(null,padre,nombre,"");
END :)
delimiter ;
call agregaCategoria(0,"Ropa");
call agregaCategoria(0,"Electrónica");
call agregaCategoria(0,"Hogar");
call agregaCategoria(0,"Automoviles");
call agregaCategoria(0,"Mascotas");
call agregaCategoria(0,"Tecnología");
call agregaCategoria(0,"Libros");
call agregaCategoria(1,"Zapatos");
call agregaCategoria(1,"Accesorios");
call agregaCategoria(9,"Bolsas");
call agregaCategoria(2,"Electrodomesticos");
call agregaCategoria(2,"Televisores");
call agregaCategoria(6,"Laptop");
call agregaCategoria(6,"Accesorios");
call agregaCategoria(5,"Alimento");
call agregaCategoria(9,"Juguetes");
call agregaCategoria(7,"Fantasia");
call agregaCategoria(7,"Comedia");
call agregaCategoria(7,"Novelas");

delimiter :) 
CREATE PROCEDURE agregaProducto(in cat int, in nombre varchar(80),in float precio,in ex int, in desc varchar(255")
BEGIN 
	INSERT INTO tbl03_producto VALUES(null,cat,nombre,precio,ex,desc);
END :)
delimiter ;





