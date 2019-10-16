CREATE DATABASE  IF NOT EXISTS `boxer_directory`;
USE `boxer_directory`;

--
-- Table structure for table `boxer`
--

DROP TABLE IF EXISTS `boxer`;

CREATE TABLE `boxer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `nationality` varchar(45) DEFAULT NULL,
  `total_fights` int(11) NOT NULL,
  `wins` int(11) NOT NULL,
  `twitter` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `boxer`
--

INSERT INTO `boxer` VALUES 
	(1,'Manny','Pacquiao','Philippines', 71, 62, 'https://twitter.com/MannyPacquiao'),
	(2,'Floyd','Mayweather','USA', 50, 50, 'https://twitter.com/FloydMayweather'),
	(3,'Deontay','Wilder','USA', 42, 41, 'https://twitter.com/bronzebomber'),
	(4,'Oleksandr','Usyk','Ukraine', 16, 16, 'https://twitter.com/usykaa'),
	(5,'Anthony','Joshua','United Kingdom', 22, 21, 'https://twitter.com/anthonyfjoshua'),
    (6,'Canelo','Alvarez','Mexico', 55, 52, 'https://twitter.com/canelo'),
    (7,'Roy','Jones','USA', 75, 66, 'https://twitter.com/realroyjonesjr'),
    (8,'Andy','Ruiz','USA', 34, 33, 'https://twitter.com/Andy_destroyer1');