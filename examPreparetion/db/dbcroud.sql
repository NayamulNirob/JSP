-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Aug 13, 2024 at 01:48 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbcroud`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `empid` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `cell` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`empid`, `name`, `email`, `address`, `cell`) VALUES
(1, 'Nirjash', 'nirjash@gamil.com', 'framget', '5865254546'),
(3, 'name', 'email', 'address', 'cell'),
(4, 'name', 'email', 'address', 'cell'),
(5, 'Nirob', 'nirobkgm2gmail.com', 'Mohammodpur', '5654564'),
(6, 'Nirob', 'nirobkgm2gmail.com', 'Mohammodpur', '5654564'),
(7, 'Nirob', 'nirobkgm2gmail.com', 'Mohammodpur', '5654564'),
(8, 'Nirob', 'nirobkgm2gmail.com', 'Mohammodpur', '5654564'),
(9, 'Nirob', 'nirobkgm2gmail.com', 'Mohammodpur', '5654564'),
(10, 'Nirob', 'nirobkgm2gmail.com', 'Mohammodpur', '5654564');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`id`, `name`, `department`, `gender`) VALUES
(3, 'Towhid', 'Java', 'Male'),
(5, 'Nirjash', 'C#', 'Female');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`empid`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `empid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
