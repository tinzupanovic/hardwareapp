create table if not exists hardware
(
    id int GENERATED ALWAYS AS IDENTITY,
    name varchar(255) not null,
    code varchar(255) not null,
    price decimal(7,2) not null,
    type varchar(255) not null,
    units integer not null,
    primary key (id)
);

create table if not exists review
(
    id int GENERATED ALWAYS AS IDENTITY,
    headline varchar(255) not null,
    text varchar(255) not null,
    mark int not null,
    hardware_id int not null,
    primary key (id),
    foreign key (hardware_id) references hardware(id)
);

create table if not exists user
(
    id identity,
    username varchar(100) not null unique,
    password varchar(1000) not null
);

create table if not exists authority
(
    id identity,
    authority_name varchar(100) not null unique
);

create table if not exists user_authority
(
    user_id bigint not null,
    authority_id bigint not null,
    constraint fk_user foreign key (user_id) references user(id),
    constraint fk_authority foreign key (authority_id) references authority(id)
);