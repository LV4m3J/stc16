create table stc16.stc16schema.logs (
    id serial primary key,
    date date not null,
    log_level varchar(5),
    message varchar(255),
    exception varchar(255)
);

REVOKE ALL PRIVILEGES ON SCHEMA stc16.stc16schema FROM log4j;

GRANT ALL PRIVILEGES ON stc16.stc16schema.logs TO log4j;
