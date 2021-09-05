create table viaje(
via_id int(11) primary key,
usu_cc_via int(11) not null,
con_cc_via int(11) not null,
fecha DATETIME not null,
foreign key (usu_cc_via) references usuario(usu_cc),
foreign key (con_cc_via) references conductor(usu_cc_fk)
);
insert into viaje(usu_cc_via, con_cc_via, fecha) values (65448733, 45488844, '2017-10-25 20:00:00');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (65448733, 325555451, '2019-03-15 18:30:00');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (65448733, 55844775, '2019-05-20 20:30:00');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (35448452, 45488844, '2018-05-20 20:30:00');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (35448452, 55844775, '2020-01-20 20:30:00');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (325555451, 64588522, '2019-05-20 20:30:00');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (325555451, 65544788, '2018-06-22 21:30:00');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (325555451, 55488445, '2020-03-17 15:30:20');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (64588522, 55488445, '2020-03-17 15:30:20');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (64588522, 76636633, '2020-04-10 18:30:20');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (55488445, 987367363, '2020-02-17 20:30:20');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (55488445, 55844775, '2020-02-20 16:30:20');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (55488445, 64588522, '2020-03-27 18:30:20');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (55844775, 64588522, '2020-03-20 21:30:20');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (76636633, 64588522, '2020-01-10 17:30:20');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (76636633, 325555451, '2020-02-15 20:30:20');
insert into viaje(usu_cc_via, con_cc_via, fecha) values (76636633, 987367363, '2020-03-17 18:30:20');