create table if not exists files (
    id bigserial primary key,
    filename varchar(255),
    size bigserial,
    file bytea
);

create table if not exists t_users (
    id bigserial primary key,
    username varchar(255),
    password varchar(255),
    authToken varchar(255)
)