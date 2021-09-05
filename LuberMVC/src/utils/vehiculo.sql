create table vehiculo(
veh_placa char(7) not null primary key,
veh_marca char(15),
veh_modelo char(15),
veh_anio smallint(6),
veh_capacidad tinyint(4), 
veh_color char(15),
veh_kilometros int(11) 
);
insert into vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros) values ("KLM 565", "Chevrolet", "spark", 2015, 5, "amarillo", 120.000);
insert into vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros) values ("LCS 364", "Chevrolet", "spark", 2016, 5, "blanco", 125.000);
insert into vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros) values ("KGH 211", "Kia", "picanto", 2015, 5, "amarillo", 80.000);
insert into vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros) values ("PET 363", "Kia", "rio", 2019, 5, "blanco", 150.000);
insert into vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros) values ("CUL 073", "Renault", "duster", 2015, 5, "blanco", 220.000);
insert into vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros) values ("PEL 456", "Renault", "duster", 2015, 5, "blanco", 130.000);