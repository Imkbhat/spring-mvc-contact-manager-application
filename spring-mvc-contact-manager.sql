--Used Postgresql Database for this Application--

CREATE DATABASE contact;
\c contact;
CREATE SCHEMA contact;
set search_path to contact;

CREATE TABLE user_main(
  user_id serial, 
  name character varying(50), 
  phone character varying(50), 
  email character varying(50), 
  address character varying(150), 
  login_name character varying(45) UNIQUE not null, 
  password character varying(50), 
  role integer default 2, 
  login_status integer default 1,
CONSTRAINT user_main_pkey PRIMARY KEY (user_id)
);

--login name should be unique and not null
--role default 2(normal user)
--login_status default 1, means active user

CREATE TABLE user_contact(
  user_contact_id serial,
  user_id integer, 
  name character varying(50), 
  phone character varying(50), 
  email character varying(50), 
  address character varying(150),
  remark character varying(150),
CONSTRAINT user_contact_pkey PRIMARY KEY (user_contact_id),
CONSTRAINT fk_user_id FOREIGN KEY (user_id)
            REFERENCES user_main (user_id)
);
