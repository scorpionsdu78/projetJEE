-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;


-- ************************************** `employee`

CREATE TABLE `employee`
(
 `id`         int NOT NULL AUTO_INCREMENT ,
 `fisrt_name` varchar(45) NOT NULL ,
 `last_name`  varchar(45) NOT NULL ,
 `home_phone` varchar(45) NOT NULL ,
 `cell_phone` varchar(45) NULL ,
 `work_phone` varchar(45) NULL ,
 `e_mail`     varchar(45) NULL ,

PRIMARY KEY (`id`)
);






-- ************************************** `adress`

CREATE TABLE `adress`
(
 `id`          int NOT NULL AUTO_INCREMENT ,
 `rue`         varchar(45) NOT NULL ,
 `code_postal` varchar(45) NOT NULL ,
 `ville`       varchar(45) NOT NULL ,
 `complement`  varchar(45) NULL ,
 `batiment`    varchar(45) NULL ,

PRIMARY KEY (`id`)
);


-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;


-- ************************************** `adress_employee`

CREATE TABLE `adress_employee`
(
 `id`          int NOT NULL AUTO_INCREMENT ,
 `id_adress`   int NOT NULL ,
 `id_employee` int NOT NULL ,

PRIMARY KEY (`id`),
KEY `fkIdx_22` (`id_adress`),
CONSTRAINT `FK_22` FOREIGN KEY `fkIdx_22` (`id_adress`) REFERENCES `adress` (`id`),
KEY `fkIdx_25` (`id_employee`),
CONSTRAINT `FK_25` FOREIGN KEY `fkIdx_25` (`id_employee`) REFERENCES `employee` (`id`)
);





