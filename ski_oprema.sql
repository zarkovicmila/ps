/*
SQLyog Community v13.1.1 (32 bit)
MySQL - 10.1.38-MariaDB : Database - ski_oprema
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ski_oprema` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ski_oprema`;

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `klijentID` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `jmbg` varchar(255) DEFAULT NULL,
  `telefon` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`klijentID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `klijent` */

insert  into `klijent`(`klijentID`,`ime`,`prezime`,`jmbg`,`telefon`,`email`) values 
(3,'Marko','Markovic','1206995958651','0653698589','marko@gmail.com'),
(4,'Pera','Peric','0602998365289','06478952','pera@hotmail.com'),
(5,'Ivana','Ilic','23306989463274','065968463','ivana@gmail.com'),
(6,'Ilija','Petrovic','3216548978975','065889566','ilija@google.com'),
(7,'Nikola','Nikolic','6549873212583','066898763','nikola@yahoo.com'),
(8,'Mila','Zarkovic','2704996715137','0643634865','milazarkovic@hotmail.com'),
(9,'Ana','Nikolic','3214789657856','0668952473','ana@gmail.com');

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `korisnikid` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezime` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `korisnickoime` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lozinka` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefon` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`korisnikid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `korisnik` */

insert  into `korisnik`(`korisnikid`,`ime`,`prezime`,`korisnickoime`,`lozinka`,`telefon`) values 
(1,'Mila','Zarkovic','admin','admin',NULL),
(2,'fon','fon','fon','fon','fon');

/*Table structure for table `proizvodjac` */

DROP TABLE IF EXISTS `proizvodjac`;

CREATE TABLE `proizvodjac` (
  `proizvodjacID` int(11) NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `adresa` varchar(255) DEFAULT NULL,
  `telefon` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`proizvodjacID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `proizvodjac` */

insert  into `proizvodjac`(`proizvodjacID`,`naziv`,`adresa`,`telefon`,`email`) values 
(1,'Nordica','KARA?OR?EV TRG 3-5 BEOGRAD (ZEMUN)','011/2618577','nordica@gmail.com'),
(2,'Fischer','Bulevar Mihajla Pupina 10/Z, 11070 Beograd','064/1324568','fischer@hotmail.com'),
(3,'Alpina','Bulevar Oslobodjenja 18 Beograd','0693625698','alpina@gmail.com'),
(4,'Dalbello','Viale Italia, 110, 31015 Conegliano TV','+390 423 55641','dallbelo@gmail.com');

/*Table structure for table `rentiranje` */

DROP TABLE IF EXISTS `rentiranje`;

CREATE TABLE `rentiranje` (
  `rentaID` int(11) NOT NULL AUTO_INCREMENT,
  `brojDana` int(11) DEFAULT NULL,
  `datumRentiranja` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ukupnaCena` decimal(10,0) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `klijentID` int(11) DEFAULT NULL,
  PRIMARY KEY (`rentaID`),
  KEY `klijentID` (`klijentID`),
  CONSTRAINT `rentiranje_ibfk_1` FOREIGN KEY (`klijentID`) REFERENCES `klijent` (`klijentID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `rentiranje` */

insert  into `rentiranje`(`rentaID`,`brojDana`,`datumRentiranja`,`ukupnaCena`,`status`,`klijentID`) values 
(1,2,'2019-06-28 17:00:00',1300,0,3),
(2,2,'2019-06-29 17:05:38',1400,1,4),
(3,2,'2019-07-07 00:00:00',1800,1,3),
(4,7,'2019-06-29 13:31:00',8050,1,6),
(5,4,'2019-06-29 00:00:00',6200,1,7),
(6,5,'2019-07-08 13:23:09',9000,0,4),
(7,3,'2019-06-25 00:00:00',2700,1,9);

/*Table structure for table `stavkarentiranja` */

DROP TABLE IF EXISTS `stavkarentiranja`;

CREATE TABLE `stavkarentiranja` (
  `rentaID` int(11) NOT NULL,
  `rb` int(11) NOT NULL,
  `cena` decimal(10,0) DEFAULT NULL,
  `kolicina` int(11) DEFAULT NULL,
  `opremaID` int(11) DEFAULT NULL,
  PRIMARY KEY (`rentaID`,`rb`),
  KEY `rentaID` (`rb`),
  KEY `opremaID` (`opremaID`),
  CONSTRAINT `stavkarentiranja_ibfk_1` FOREIGN KEY (`rentaID`) REFERENCES `rentiranje` (`rentaID`),
  CONSTRAINT `stavkarentiranja_ibfk_2` FOREIGN KEY (`opremaID`) REFERENCES `zimskaoprema` (`opremaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stavkarentiranja` */

insert  into `stavkarentiranja`(`rentaID`,`rb`,`cena`,`kolicina`,`opremaID`) values 
(1,1,500,1,2),
(1,2,800,1,4),
(2,1,500,1,2),
(2,2,900,1,3),
(3,1,900,1,3),
(4,1,500,1,2),
(4,2,650,1,5),
(5,1,350,1,22),
(5,2,900,1,3),
(5,3,300,1,20),
(6,1,1000,1,1),
(6,2,300,1,20),
(6,3,500,1,2),
(7,1,400,1,23),
(7,2,200,1,25),
(7,3,300,1,24);

/*Table structure for table `tipopreme` */

DROP TABLE IF EXISTS `tipopreme`;

CREATE TABLE `tipopreme` (
  `tipID` int(11) NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tipID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipopreme` */

insert  into `tipopreme`(`tipID`,`naziv`) values 
(1,'Skije'),
(2,'Snowboard'),
(3,'Pancerice'),
(4,'Cizme za snowboard'),
(5,'Stapovi'),
(6,'Kaciga'),
(7,'Naocare');

/*Table structure for table `zimskaoprema` */

DROP TABLE IF EXISTS `zimskaoprema`;

CREATE TABLE `zimskaoprema` (
  `opremaID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  `cena` decimal(10,0) DEFAULT NULL,
  `kapacitet` int(11) DEFAULT NULL,
  `uzrast` enum('odrasli','deca') DEFAULT NULL,
  `tipOpremeID` int(11) DEFAULT NULL,
  `proizvodjacID` int(11) DEFAULT NULL,
  PRIMARY KEY (`opremaID`),
  KEY `proizvodjacID` (`proizvodjacID`),
  KEY `tipOpremeID` (`tipOpremeID`),
  CONSTRAINT `zimskaoprema_ibfk_2` FOREIGN KEY (`proizvodjacID`) REFERENCES `proizvodjac` (`proizvodjacID`),
  CONSTRAINT `zimskaoprema_ibfk_3` FOREIGN KEY (`tipOpremeID`) REFERENCES `tipopreme` (`tipID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Data for the table `zimskaoprema` */

insert  into `zimskaoprema`(`opremaID`,`naziv`,`cena`,`kapacitet`,`uzrast`,`tipOpremeID`,`proizvodjacID`) values 
(1,'Ski Pro Lx15',1000,15,'odrasli',1,1),
(2,'Dalbello Boss',500,10,'deca',3,4),
(3,'Snow Racer',900,25,'odrasli',2,1),
(4,'Ski Professional 6',800,20,'odrasli',1,1),
(5,'Ski Professional Kids',650,20,'deca',1,1),
(16,'Ski Stap Pro12x',25,20,'odrasli',1,1),
(17,'Ski Stap Pro12x',250,20,'deca',1,1),
(18,'Ski Helmet Nordica',150,20,'deca',6,1),
(19,'Ski Helmet Nordica',200,30,'odrasli',6,1),
(20,'Ski Glasses',300,50,'odrasli',7,1),
(21,'Snowboard Boots Alpina',400,50,'odrasli',4,3),
(22,'Snowboard Boots Alpina Kids',350,50,'deca',4,3),
(23,'Board Fisher',400,25,'odrasli',2,2),
(24,'Fisher Glasses',300,25,'odrasli',7,2),
(25,'Snow Helmet P10',200,50,'odrasli',6,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
