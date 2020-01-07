--Used Postgresql Database for this Application--

CREATE DATABASE contact;
\c contact;
CREATE SCHEMA contact;
set search_path to contact;

create table user_main(
  user_id serial, 
  name character varying(50), 
  phone character varying(50), 
  email character varying(50), 
  address character varying(150), 
  login_name character varying(45) not null, 
  password character varying(50), 
  role integer default 2,//normal user 
  login_status integer default 1 //active
);
