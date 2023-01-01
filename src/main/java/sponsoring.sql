-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2022 at 09:54 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sponsoring`
--

-- --------------------------------------------------------

--
-- Table structure for table `approuver`
--

CREATE TABLE `approuver` (
  `ID_ENTREPRISE` int(11) NOT NULL,
  `ID_POSTE` int(11) NOT NULL,
  `DATE_APRV` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `club`
--

CREATE TABLE `club` (
  `ID_CLUB` int(11) NOT NULL,
  `DESCRIPTION` text DEFAULT NULL,
  `DATE_ORG` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `coordonnee`
--

CREATE TABLE `coordonnee` (
  `ID_COORD` int(11) NOT NULL,
  `ID_ORG` int(11) NOT NULL,
  `EMAIL` longtext DEFAULT NULL,
  `TEL` longtext DEFAULT NULL,
  `ADRESSE` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `entreprise`
--

CREATE TABLE `entreprise` (
  `ID_ENTREPRISE` int(11) NOT NULL,
  `TYPE` longtext DEFAULT NULL,
  `CHIFFRE_D_AFFAIRE` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `evenement`
--

CREATE TABLE `evenement` (
  `ID_evn` int(11) NOT NULL,
  `INTITULE` varchar(70) NOT NULL,
  `Edition` int(11) DEFAULT NULL,
  `ID_CLUB` int(11) NOT NULL,
  `BUDGET` double DEFAULT NULL,
  `LOCAL` longtext DEFAULT NULL,
  `DESCRIPTION` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `ID_LOG` int(11) NOT NULL,
  `USERNAME` varchar(100) DEFAULT NULL,
  `PASSWD` varchar(75) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `organisme`
--

CREATE TABLE `organisme` (
  `ID_ORG` int(11) NOT NULL,
  `NOM` longtext DEFAULT NULL,
  `ACTIVITE` longtext DEFAULT NULL,
  `DOMAINE` longtext DEFAULT NULL,
  `DATE_CONSTRUCTION` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `poste`
--

CREATE TABLE `poste` (
  `ID_POSTE` int(11) NOT NULL,
  `ID_CLUB` int(11) NOT NULL,
  `DATE_ORG` date DEFAULT NULL,
  `CONTENU` longtext DEFAULT NULL,
  `PRIORITE` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sponsoriser`
--

CREATE TABLE `sponsoriser` (
  `ID_ENTREPRISE` int(11) NOT NULL,
  `ID_evn` int(11) NOT NULL,
  `DATE_SPN` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `approuver`
--
ALTER TABLE `approuver`
  ADD PRIMARY KEY (`ID_ENTREPRISE`,`ID_POSTE`),
  ADD KEY `ID_POSTE` (`ID_POSTE`);

--
-- Indexes for table `club`
--
ALTER TABLE `club`
  ADD PRIMARY KEY (`ID_CLUB`);

--
-- Indexes for table `coordonnee`
--
ALTER TABLE `coordonnee`
  ADD PRIMARY KEY (`ID_COORD`,`ID_ORG`),
  ADD KEY `ID_ORG` (`ID_ORG`);

--
-- Indexes for table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`ID_ENTREPRISE`);

--
-- Indexes for table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`ID_evn`),
  ADD UNIQUE KEY `Edition` (`Edition`),
  ADD KEY `ID_CLUB` (`ID_CLUB`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`ID_LOG`);

--
-- Indexes for table `organisme`
--
ALTER TABLE `organisme`
  ADD PRIMARY KEY (`ID_ORG`);

--
-- Indexes for table `poste`
--
ALTER TABLE `poste`
  ADD PRIMARY KEY (`ID_POSTE`,`ID_CLUB`),
  ADD KEY `ID_CLUB` (`ID_CLUB`);

--
-- Indexes for table `sponsoriser`
--
ALTER TABLE `sponsoriser`
  ADD PRIMARY KEY (`ID_ENTREPRISE`,`ID_evn`),
  ADD KEY `ID_evn` (`ID_evn`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `approuver`
--
ALTER TABLE `approuver`
  ADD CONSTRAINT `approuver_ibfk_1` FOREIGN KEY (`ID_ENTREPRISE`) REFERENCES `entreprise` (`ID_ENTREPRISE`),
  ADD CONSTRAINT `approuver_ibfk_2` FOREIGN KEY (`ID_POSTE`) REFERENCES `poste` (`ID_POSTE`);

--
-- Constraints for table `club`
--
ALTER TABLE `club`
  ADD CONSTRAINT `club_ibfk_1` FOREIGN KEY (`ID_CLUB`) REFERENCES `organisme` (`ID_ORG`);

--
-- Constraints for table `coordonnee`
--
ALTER TABLE `coordonnee`
  ADD CONSTRAINT `coordonnee_ibfk_1` FOREIGN KEY (`ID_ORG`) REFERENCES `organisme` (`ID_ORG`);

--
-- Constraints for table `entreprise`
--
ALTER TABLE `entreprise`
  ADD CONSTRAINT `entreprise_ibfk_1` FOREIGN KEY (`ID_ENTREPRISE`) REFERENCES `organisme` (`ID_ORG`);

--
-- Constraints for table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `evenement_ibfk_1` FOREIGN KEY (`ID_CLUB`) REFERENCES `club` (`ID_CLUB`);

--
-- Constraints for table `poste`
--
ALTER TABLE `poste`
  ADD CONSTRAINT `poste_ibfk_1` FOREIGN KEY (`ID_CLUB`) REFERENCES `club` (`ID_CLUB`);

--
-- Constraints for table `sponsoriser`
--
ALTER TABLE `sponsoriser`
  ADD CONSTRAINT `sponsoriser_ibfk_1` FOREIGN KEY (`ID_ENTREPRISE`) REFERENCES `entreprise` (`ID_ENTREPRISE`),
  ADD CONSTRAINT `sponsoriser_ibfk_2` FOREIGN KEY (`ID_evn`) REFERENCES `evenement` (`ID_evn`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
