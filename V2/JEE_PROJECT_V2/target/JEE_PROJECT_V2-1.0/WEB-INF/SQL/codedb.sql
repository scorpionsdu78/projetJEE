CREATE TABLE  EMPLOYEE 
(
  id INT NOT NULL AUTO_INCREMENT,
  first_name  varchar(45) NOT NULL ,
  last_name   varchar(45) NOT NULL ,
  home_phone  varchar(45) NOT NULL ,
  cell_phone  varchar(45),
  work_phone  varchar(45),
  e_mail      varchar(45),

PRIMARY KEY ( id )
);






-- **************************************  adress 

CREATE TABLE  ADRESS 
(
  id INT NOT NULL AUTO_INCREMENT,
  rue          varchar(45) NOT NULL ,
  code_postal  varchar(45) NOT NULL ,
  ville        varchar(45) NOT NULL ,
  complement   varchar(45)  ,
  batiment     varchar(45) ,
  id_employee  int NOT NULL,

PRIMARY KEY ( id ),
FOREIGN KEY ( id_employee ) REFERENCES  EMPLOYEE  ( id )
);


-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;


-- **************************************  adress_employee 

