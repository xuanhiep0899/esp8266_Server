create extension if not exists "uuid-ossp";

create table account (
	id uuid not null default uuid_generate_v4() primary key,
	account_name varchar (255) not null,
	created_date timestamp not null default now(),
    last_updated timestamp not null default now()
);

create table employee (
	id uuid not null default uuid_generate_v4() primary key,
	first_name varchar (255) not null,
	last_name varchar (255) not null,
	created_date timestamp not null default now(),
    last_updated timestamp not null default now()
);

create table account_employee (
	id uuid not null default uuid_generate_v4() primary key,
    account_id uuid not null,
    employee_id uuid not null,
    created_date timestamp not null default now(),
    last_updated timestamp not null default now(),
    foreign key (account_id) references account (id) on delete cascade,
    foreign key (employee_id) references employee (id) on delete cascade
);

create table application_user (
	id uuid not null default uuid_generate_v4() primary key,
    employee_id uuid unique not null,
    username varchar (255) unique not null,
    password varchar(128) not null,
    verified boolean not null,
    created_date timestamp not null default now(),
    last_updated timestamp not null default now(),
    foreign key (employee_id) references employee (id) on delete cascade
);

create table temperature (
	id uuid not null default uuid_generate_v4() primary key,
    employee_id uuid unique not null,
    temperature_value decimal(15,2) not null default 0.00,
    created_date timestamp not null default now(),
    last_updated timestamp not null default now(),
    foreign key (employee_id) references employee (id) on delete cascade
);