-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 22, 2012 at 10:54 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `testhib`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `CUST_ID` int(10) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `AGE` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CUST_ID`, `NAME`, `AGE`) VALUES
(1, 'testing', 28),
(2, 'test', 28);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `PRODUCT_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `PRODUCT_CODE` varchar(20) NOT NULL,
  `PRODUCT_DESC` varchar(255) NOT NULL,
  PRIMARY KEY (`PRODUCT_ID`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`PRODUCT_ID`, `PRODUCT_CODE`, `PRODUCT_DESC`) VALUES
(2, 'ABC', 'This is product ABC'),
(3, 'ABC', 'This is product ABC'),
(4, 'Test', 'This is product of Test');

-- --------------------------------------------------------

--
-- Table structure for table `product_qoh`
--

CREATE TABLE IF NOT EXISTS `product_qoh` (
  `QOH_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `PRODUCT_ID` bigint(20) unsigned NOT NULL,
  `QTY` int(10) unsigned NOT NULL,
  PRIMARY KEY (`QOH_ID`),
  KEY `FK_product_qoh_product_id` (`PRODUCT_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `product_qoh`
--

INSERT INTO `product_qoh` (`QOH_ID`, `PRODUCT_ID`, `QTY`) VALUES
(1, 2, 100),
(2, 3, 100),
(3, 4, 100);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE IF NOT EXISTS `stock` (
  `STOCK_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `STOCK_CODE` varchar(10) NOT NULL,
  `STOCK_NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`STOCK_ID`) USING BTREE,
  UNIQUE KEY `UNI_STOCK_NAME` (`STOCK_NAME`),
  UNIQUE KEY `UNI_STOCK_ID` (`STOCK_CODE`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`STOCK_ID`, `STOCK_CODE`, `STOCK_NAME`) VALUES
(15, '7669', 'Hamam');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product_qoh`
--
ALTER TABLE `product_qoh`
  ADD CONSTRAINT `FK_product_qoh_product_id` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
