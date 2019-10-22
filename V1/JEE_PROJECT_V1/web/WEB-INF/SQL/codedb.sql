CREATE TABLE "EMPLOYEE"
(
 "id" int NOT NULL GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1) ,
 "fisrt_name" varchar(45) NOT NULL ,
 "last_name"  varchar(45) NOT NULL ,
 "home_phone" varchar(45) NOT NULL ,
 "cell_phone" varchar(45),
 "work_phone" varchar(45),
 "e_mail"     varchar(45),

PRIMARY KEY ("id")
);






-- ************************************** "adress"

CREATE TABLE "ADRESS"
(
 "id"          int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
 "rue"         varchar(45) NOT NULL ,
 "code_postal" varchar(45) NOT NULL ,
 "ville"       varchar(45) NOT NULL ,
 "complement"  varchar(45)  ,
 "batiment"    varchar(45) ,
 "id_employee" int NOT NULL,

PRIMARY KEY ("id"),
FOREIGN KEY ("id_employee") REFERENCES "EMPLOYEE" ("id")
);


-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;


-- ************************************** "adress_employee"

