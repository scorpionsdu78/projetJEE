 -- "Adding EMPLOYEE rows"
INSERT INTO EMPLOYEE("id", "first_name", "last_name", "home_phone", "cell_phone", "work_phone", "e_mail")
VALUES(1, "John", "DOE", "01 46 77 46 77", "01 88 28 91 04", "01 88 28 91 33", "johnDoe@gmail.com");



 
-- "Adding ADRESS rows"
INSERT INTO ADRESS("id", "rue", "code_postal", "ville", "complement", "batiment", "id_employee")
VALUES("1", "30-32 avenue de la Republique", "94 800", "Villejuif", "Efrei Paris", "Batiment C", "1");