select 'Consulta 1';
select * from usuario order by usu_cc asc;
select 'Consulta 2';
select veh_placa, veh_marca, veh_modelo  from vehiculo  where veh_anio > 2015 order by veh_marca asc;
select 'Consulta 3';
select usu_cc_fk, usu_nombre, usu_apellido, usu_email from conductor join usuario on usu_cc_fk=usu_cc where veh_placa_fk='PET 363';
select 'Consulta 4';
select veh_placa_fk from viaje join conductor on con_cc_via=usu_cc_fk where usu_cc_via = 64588522;
select 'Consulta 6';
select count(veh_placa) from vehiculo where veh_kilometros > 120;