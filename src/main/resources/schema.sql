create table if not exists files (
    id bigserial primary key,
    filename varchar(255),
    size bigserial,
    file bytea
);

