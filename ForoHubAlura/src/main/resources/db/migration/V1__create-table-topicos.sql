create table topicos(
    id bigint not null auto_increment,
    titulo varchar(250) not null unique,
    mensaje varchar(255) not null unique,
    fecha_Creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `status` TINYINT,
    autor varchar(255) not null,
    curso varchar(255) not null,
    respuestas INT UNSIGNED not null,
    primary key(id)
);
