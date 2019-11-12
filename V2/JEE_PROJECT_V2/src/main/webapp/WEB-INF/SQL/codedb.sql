CREATE TABLE  EMPLOYEE 
(
  id INT NOT NULL AUTO_INCREMENT,
  first_name  varchar(45) NOT NULL ,
  last_name   varchar(45) NOT NULL ,
  home_phone  varchar(45) NOT NULL ,
  cell_phone  varchar(45),
  work_phone  varchar(45),
  e_mail      varchar(45),
  rue          varchar(45) NOT NULL ,
  code_postal  varchar(45) NOT NULL ,
  ville        varchar(45) NOT NULL 

PRIMARY KEY ( id )
);
