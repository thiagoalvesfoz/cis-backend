create table profissional(
	id_user bigint not null, 
	crm bigint, 
	primary key (id_user)
);

alter table profissional add constraint fk_profissional_usuario
foreign key (id_user) references usuario (id_user);