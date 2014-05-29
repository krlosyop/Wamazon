CREATE TABLE tbl02_atributo (id_categoria int(10) NOT NULL, id_atributo int(10) NOT NULL, nb_atributo varchar(256) NOT NULL, tx_descripcion varchar(256) NOT NULL, PRIMARY KEY (id_categoria, id_atributo));
CREATE TABLE tbl01_categoria (id_categoria int(10) NOT NULL AUTO_INCREMENT, id_padre int(10) NOT NULL, nb_categoria varchar(50) NOT NULL, tx_descripcion varchar(256) NOT NULL, PRIMARY KEY (id_categoria));
CREATE TABLE tbl03_producto (id_producto int(10) NOT NULL, id_categoria int(10) NOT NULL, nb_producto varchar(80) NOT NULL, nu_precio float NOT NULL, nu_existencia int(10) NOT NULL, dx_descripcion varchar(255) NOT NULL, bl_fotografia blob, PRIMARY KEY (id_producto, id_categoria));
CREATE TABLE tbl04_producto_atributo (id_producto int(10) NOT NULL, id_atributo int(10) NOT NULL, id_categoria int(10) NOT NULL, tx_valor varchar(100) NOT NULL, PRIMARY KEY (id_producto, id_atributo, id_categoria));
CREATE TABLE tbl05_compra (id_compra int(10) NOT NULL AUTO_INCREMENT, id_usuario int(10) NOT NULL, fh_compra timestamp NOT NULL, PRIMARY KEY (id_compra));
CREATE TABLE tbl06_producto_compra (id_producto int(10) NOT NULL, id_compra int(10) NOT NULL, cantidad int(10) NOT NULL, PRIMARY KEY (id_producto, id_compra));
CREATE TABLE tbl07_usuario (id_usuario int(10) NOT NULL AUTO_INCREMENT, tx_login varchar(15) NOT NULL, tx_password varchar(15) NOT NULL, nb_usuario varchar(20) NOT NULL, tx_apa varchar(20) NOT NULL, tx_apb varchar(20) NOT NULL, PRIMARY KEY (id_usuario));
CREATE TABLE tbl08_direccion (id_direccion int(10) NOT NULL AUTO_INCREMENT, id_usuario int(10) NOT NULL, nb_calle varchar(50) NOT NULL, nb_colonia varchar(100) NOT NULL, tx_cp varchar(6) NOT NULL, nb_ciudad varchar(50) NOT NULL, nb_estado varchar(50) NOT NULL, PRIMARY KEY (id_direccion));
ALTER TABLE tbl01_categoria ADD INDEX FKtbl01_cate758351 (), ADD CONSTRAINT FKtbl01_cate758351 FOREIGN KEY () REFERENCES tbl01_categoria ();
ALTER TABLE tbl02_atributo ADD INDEX FKtbl02_atri921981 (id_categoria), ADD CONSTRAINT FKtbl02_atri921981 FOREIGN KEY (id_categoria) REFERENCES tbl01_categoria (id_categoria);
ALTER TABLE tbl03_producto ADD INDEX FKtbl03_prod205652 (id_categoria), ADD CONSTRAINT FKtbl03_prod205652 FOREIGN KEY (id_categoria) REFERENCES tbl01_categoria (id_categoria);
ALTER TABLE tbl04_producto_atributo ADD INDEX FKtbl04_prod923596 (id_producto, id_categoria), ADD CONSTRAINT FKtbl04_prod923596 FOREIGN KEY (id_producto, id_categoria) REFERENCES tbl03_producto (id_producto, id_categoria);
ALTER TABLE tbl04_producto_atributo ADD INDEX FKtbl04_prod539688 (id_categoria, id_atributo), ADD CONSTRAINT FKtbl04_prod539688 FOREIGN KEY (id_categoria, id_atributo) REFERENCES tbl02_atributo (id_categoria, id_atributo);
ALTER TABLE tbl06_producto_compra ADD INDEX FKtbl06_prod758312 (id_producto), ADD CONSTRAINT FKtbl06_prod758312 FOREIGN KEY (id_producto) REFERENCES tbl03_producto (id_producto);
ALTER TABLE tbl06_producto_compra ADD INDEX FKtbl06_prod179180 (id_compra), ADD CONSTRAINT FKtbl06_prod179180 FOREIGN KEY (id_compra) REFERENCES tbl05_compra (id_compra);
ALTER TABLE tbl05_compra ADD INDEX FKtbl05_comp240987 (id_usuario), ADD CONSTRAINT FKtbl05_comp240987 FOREIGN KEY (id_usuario) REFERENCES tbl07_usuario (id_usuario);
ALTER TABLE tbl08_direccion ADD INDEX FKtbl08_dire695188 (id_usuario), ADD CONSTRAINT FKtbl08_dire695188 FOREIGN KEY (id_usuario) REFERENCES tbl07_usuario (id_usuario);

