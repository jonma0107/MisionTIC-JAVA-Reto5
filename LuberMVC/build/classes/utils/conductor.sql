create table conductor(
usu_cc_fk int(11) not null,
veh_placa_fk char(7) not null,
primary key (usu_cc_fk),
foreign key (usu_cc_fk) references usuario(usu_cc), 
foreign key (veh_placa_fk) references vehiculo(veh_placa) 
);
insert into conductor(usu_cc_fk, veh_placa_fk) values (45488844, "KLM 565");
insert into conductor(usu_cc_fk, veh_placa_fk) values (325555451, "KLM 565");
insert into conductor(usu_cc_fk, veh_placa_fk) values (76636633, "LCS 364");
insert into conductor(usu_cc_fk, veh_placa_fk) values (64588522, "PET 363");
insert into conductor(usu_cc_fk, veh_placa_fk) values (65544788, "PET 363");
insert into conductor(usu_cc_fk, veh_placa_fk) values (55844775, "LCS 364");
insert into conductor(usu_cc_fk, veh_placa_fk) values (55488445, "KGH 211");
insert into conductor(usu_cc_fk, veh_placa_fk) values (987367363, "KGH 211");