-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2016 at 10:06 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `staffsalary`
--

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE IF NOT EXISTS `salary` (
  `PersonalID` int(20) NOT NULL AUTO_INCREMENT,
  `Month` smallint(2) unsigned NOT NULL,
  `Year` year(4) NOT NULL,
  `SalarySum` decimal(10,2) unsigned NOT NULL,
  `ExtraSalary` decimal(10,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`PersonalID`,`Month`,`Year`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

-- --------------------------------------------------------

--
-- Table structure for table `staffperson`
--

CREATE TABLE IF NOT EXISTS `staffperson` (
  `PersonalID` int(20) NOT NULL AUTO_INCREMENT,
  `FisrtName` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `PostalCode` varchar(10) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `HouseNumber` int(10) NOT NULL,
  `Phone` varchar(15) DEFAULT NULL,
  `EMail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PersonalID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `staffperson`
--

--
-- Constraints for dumped tables
--

--
-- Constraints for table `salary`
--
ALTER TABLE `salary`
  ADD CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`PersonalID`) REFERENCES `staffperson` (`PersonalID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
