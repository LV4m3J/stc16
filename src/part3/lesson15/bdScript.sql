create tablespace stc16space location 'J:\dbs\stc16';
create database stc16 tablespace stc16space;
alter database stc16 owner to postgres;
CREATE SCHEMA stc16schema;

create table stc16.stc16schema.users (
                id serial primary key,
                name varchar(255),
                birthday date,
                login_id int,
                city varchar(255),
                email varchar(255),
                description varchar(255)
);
create table stc16.stc16schema.role (
                id serial primary key,
                name varchar(255) check (name in ('Administration', 'Clients', 'Billing')),
                description varchar(255)
);
create table stc16.stc16schema.users_role (
                id serial primary key,
                user_id INTEGER references stc16.stc16schema.users(id),
                role_id INTEGER references stc16.stc16schema.role(id)
);
