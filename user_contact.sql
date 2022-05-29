DROP DATABASE User_contact;
CREATE SCHEMA IF NOT EXISTS User_contact DEFAULT CHARACTER SET utf8 ;
USE User_contact ;

-- -----------------------------------------------------
-- Crear  tabla
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS contact (
   Phone_Contact  INT  NOT NULL  AUTO_INCREMENT,
   full_name  VARCHAR(45)  NULL,
   phone_number  VARCHAR(45)  NULL,
   email  VARCHAR(45) NULL,
   date_of_birth  VARCHAR(45) NULL,
   stateLogic  VARCHAR(1) NUll,
  PRIMARY KEY ( Phone_Contact ),
  UNIQUE INDEX  Phone_Contact_UNIQUE  ( Phone_Contact  ASC) VISIBLE)
ENGINE = InnoDB;

-- Insertar Datos
INSERT INTO contact (full_name, phone_number, email, date_of_birth,stateLogic)
VALUES
  ( 'Phoebe Guerrero ', '1-787-962-3774 ', 'urna.convallis@icloud.couk ','1984-02-10','1'),
  ( 'Byron Guthrie ', '(613) 777-1517 ', 'dolor@protonmail.com ','1963-11-05','1'),
  ( 'Palmer May ', '1-186-269-0758 ', 'magna@aol.com ','1945-08-12','1'),
  ( 'Alexis Mullins ', '(120) 798-5335 ', 'vitae.sodales.at@yahoo.com ','1991-11-06','1'),
  ( 'Nasim Sears ', '(437) 624-5765 ', 'mauris.blandit@google.com ','1988-07-08','1'),
  ( 'Lareina Nunez ', '(851) 895-2656 ', 'nulla.facilisi@google.net ','1988-02-04','1'),
  ( 'MacKenzie David ', '1-467-218-5534 ', 'risus.donec@aol.couk ','1990-01-01','1'),
  ( 'Roth Browning ', '(820) 406-2791 ', 'vulputate.ullamcorper@icloud.ca ','1998-06-11','1'),
  ( 'Jhon Bruce ', '1-174-216-7420 ', 'in.faucibus.orci@google.com ','1998-06-06','1'),
  ( 'Fritz Dorsey ', '(534) 418-7076 ', 'non@google.ca ','1992-06-06','1');