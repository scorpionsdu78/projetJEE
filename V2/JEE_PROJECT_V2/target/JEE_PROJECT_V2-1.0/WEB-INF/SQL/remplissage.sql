 -- "Adding EMPLOYEE rows"
INSERT INTO `employee` (`id`, `first_name`, `last_name`, `home_phone`, `cell_phone`, `work_phone`, `e_mail`) VALUES
(NULL, 'John', 'DOE', '0102030405', '0102030405', '0102030405', 'johnDoe@gmail.com'),
(NULL, 'Jane', 'DOE', '0102030405', '0102030405', '0102030405', 'JaneDOE@gmail.com'),
(NULL, 'Hugues', 'BEGEOT', '0102030405', '0102030405', '0102030405', 'hugues.begeot@efrei.net'),
(NULL, 'François', 'BONI', '0102030405', '0102030405', '0102030405', 'françois.boni@efrei.net'),
(NULL, 'Eddy', 'DULCHE', '0102030405', '0102030405', '0102030405', 'eddy.dulche@efrei.net'),
(NULL, 'Obi-Wan', 'Kenobi', '0102030405', '0102030405', '0102030405', '404notFound@coruscant.web'),
(NULL, 'General', 'Grievous', '0102030405', '0102030405', '0102030405', 'default@mail.com'),
(NULL, 'Sheev', 'Palpatine', '0102030405', '0102030405', '0102030405', 'default@mail.com'),
(NULL, 'Mace', 'Windu', '0102030405', '0102030405', '0102030405', 'default@mail.com')




 
-- "Adding ADRESS rows"
INSERT INTO `adress` (`id`, `rue`, `code_postal`, `ville`, `complement`, `batiment`, `id_employee`) VALUES
(NULL, '46, Avenue Mozart', '75016', 'Paris', 'Centre commercial', 'bâtiment A', '1'),
(NULL, '46, Avenue Mozart', '75016', 'Paris', 'Centre Commercial', 'bâtiment B', '2')