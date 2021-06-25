-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 25, 2021 at 03:32 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laundrykris`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_pegawai`
--

CREATE TABLE `data_pegawai` (
  `Id_user` char(10) NOT NULL,
  `Id_bantu` int(11) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_pegawai`
--

INSERT INTO `data_pegawai` (`Id_user`, `Id_bantu`, `Username`, `Password`) VALUES
('USR1', 1, 'krisno', 'iloveu'),
('USR2', 2, 'a', 'a');

-- --------------------------------------------------------

--
-- Table structure for table `laundry`
--

CREATE TABLE `laundry` (
  `Tanggal` date NOT NULL,
  `Kode_pelanggan` varchar(10) NOT NULL,
  `Nama_pelanggan` varchar(20) NOT NULL,
  `No_telp` varchar(15) NOT NULL,
  `Alamat` text NOT NULL,
  `Berat_Pakaian` float NOT NULL,
  `Harga` int(11) NOT NULL,
  `Total_bayar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `laundry`
--

INSERT INTO `laundry` (`Tanggal`, `Kode_pelanggan`, `Nama_pelanggan`, `No_telp`, `Alamat`, `Berat_Pakaian`, `Harga`, `Total_bayar`) VALUES
('2021-05-26', '01', 'Krisno', '082112519474', 'Los Angeles', 1.5, 15000, 22500),
('2021-05-26', '02', 'Aimi Hakai', '4544', 'Tokyo', 1, 5000, 5000),
('2021-05-29', '03', 'Ribet', '12', 'Jauh', 1.5, 5000, 7500),
('2021-05-26', '04', 'Wahyd', '145', 'Gak Tau', 4.2, 15000, 63000),
('2021-05-26', '05', 'Ricardo', '2233111', 'Tanggerang', 2, 5000, 10000),
('2021-05-26', '06', 'Alex', '55544455', 'Bandung', 7, 5000, 35000),
('2021-05-26', '07', 'Seyae', '111', 'Cianjur', 51.5, 15000, 772500),
('2021-06-17', '08', 'Budi', '4587', 'Gatau', 45, 15000, 675000),
('2021-05-26', '09', 'aaa', 'aa', 'aaa', 1, 5000, 5000),
('2021-05-26', '10', 'AAAAAAA', '555555', 'ALALALAA', 6, 15000, 90000),
('2021-06-17', '11', 'Robet', '111', '111', 23, 15000, 345000),
('2021-06-17', '12', 'Rijak', '111', '111', 23, 5000, 115000),
('2021-06-17', '13', 'Robby', '654', 'SSSS', 3, 9000, 27000),
('2021-05-26', '14', 'Wahit', '764577', 'ASDX', 5, 9000, 45000),
('2021-05-29', '15', 'zzzzzzzz', 'zzzzzzzzzzz', 'zzzzzzzzz', 2, 5000, 10000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_pegawai`
--
ALTER TABLE `data_pegawai`
  ADD PRIMARY KEY (`Id_user`);

--
-- Indexes for table `laundry`
--
ALTER TABLE `laundry`
  ADD PRIMARY KEY (`Kode_pelanggan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
