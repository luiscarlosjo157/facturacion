INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('luis carlos', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('luis carlos', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('ayde', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('carlos', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('luis', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('andres', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('julio', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('pepito', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('juanito', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('maria', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('ana', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('angel', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('roberto', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('juan', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('jose', 'jurado ortega', 'luiscarjo157@gmai.com', '2017-08-21', '');

INSERT INTO productos (nombre, precio, create_at) VALUES('Televisor LG', 1800000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Camara LG', 18000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Celular APPLE', 1000000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Equipo de Sonido SONY', 800000,NOW());

INSERT INTO `users` (username, password, enabled) VALUES ('carlos','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');





