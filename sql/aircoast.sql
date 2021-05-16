drop database if exists aircoast;

create database aircoast;
use aircoast;
CREATE TABLE `usersaircoast` (
  `idUsersAirCoast` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `loginName` varchar(45) NOT NULL,
  `passwordUser` varchar(45) NOT NULL,
  `emailUser` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsersAirCoast`),
  UNIQUE KEY `loginName_UNIQUE` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO  usersaircoast (firstName, lastName, loginName, passwordUser, emailUser) VALUES ('Ivan', 'Ivanov', 'Login', 'Password', 'mail');
INSERT INTO  usersaircoast (firstName, lastName, loginName, passwordUser, emailUser) VALUES ('Ivan1', 'Ivanov1', 'Login1', 'Password1', 'mail1');
INSERT INTO  usersaircoast (firstName, lastName, loginName, passwordUser, emailUser) VALUES ('Ivan2', 'Ivanov2', 'Login2', 'Password2', 'mail2');
