-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 30, 2020 at 10:58 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bpjs`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_diri`
--

CREATE TABLE `data_diri` (
  `nik` varchar(20) NOT NULL,
  `nomor_kk` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` text NOT NULL,
  `ttl` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_diri`
--

INSERT INTO `data_diri` (`nik`, `nomor_kk`, `nama`, `alamat`, `ttl`) VALUES
('17238239475839402', '32859384728392814', 'Agus Winarto', 'Jl. Rawarontek RT. 03/01, Kel. Sukamakmur, Kec. Sukamandi, Kab. Jonggol, Jawa Barat', 'Jonggol, 07-08-1999'),
('180301519000000001', '18800022222211', 'Fadwah Rara', 'Jl. Saibun RT.004/001 No.10 Cijantung Pasar Rebo Jakarta Timur', 'Jakarta, 14-04-2000'),
('180301519000000221', '18800022222211', 'Dafi Mu\'ammar Zulfikar', 'Jl. Saibun RT.004/001 No.10 Cijantung Pasar Rebo Jakarta Timur', 'Jakarta, 02-12-2000'),
('3201011403000019', '1803015053', 'Riky Ardiansyah', 'Jl. Amanah RT. 03/08 No.106 Kel. Cibinong, Kec. Cibinong, Kab. Bogor, Jawa Barat ', 'Bogor, 14-03-2000'),
('54738473827364183', '46274836193847162', 'Ade Wahyudi', 'Jl. Halimun Ketir RT.03/01 No. 66 Kab. Bogor, Jawa Barat', 'Bogor, 31-04-2000'),
('57381928847382948', '1803015053', 'Riski Pratama Putra', 'Jl. Amanah RT. 03/08 No.106 Kel. Cibinong, Kec. Cibinong, Kab. Bogor, Jawa Barat ', 'Bogor, 24-03-1990'),
('73856391224835712', '1803015053', 'Sarmili', 'Jl. Vasopati RT. 06/01 Kec. Jayakarta, Kab. Bandungan, Jawa Barat', 'Bogor, 12-12-1912');

-- --------------------------------------------------------

--
-- Table structure for table `kartu`
--

CREATE TABLE `kartu` (
  `nomor_kartu` varchar(20) NOT NULL,
  `nik` varchar(20) NOT NULL,
  `faskes` varchar(50) NOT NULL,
  `status` enum('PPU','PBI','Mandiri') NOT NULL,
  `kelas` varchar(1) NOT NULL,
  `terakhir_bayar` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kartu`
--

INSERT INTO `kartu` (`nomor_kartu`, `nik`, `faskes`, `status`, `kelas`, `terakhir_bayar`) VALUES
('0002743817274', '57381928847382948', 'Klinik Noordin Wahid', 'Mandiri', '3', '2020-06-20'),
('0002747141662', '3201011403000019', 'Klinik Noordin Wahid', 'Mandiri', '3', '2020-06-20'),
('083819035315', '180301519000000001', 'Klinik Medical Lillah', 'PBI', '0', ''),
('1245323554323', '17238239475839402', 'Klinik Sukamaju', 'Mandiri', '1', '2020-06-29'),
('1803151900111', '180301519000000221', 'Klinik Medical Lillah', 'PBI', '0', ''),
('6473817236473', '54738473827364183', 'Klinik Mahasta', 'PBI', '0', ''),
('839378563883468', '73856391224835712', 'Klinik Noordin Wahid', 'Mandiri', '3', '2020-06-20');

-- --------------------------------------------------------

--
-- Table structure for table `kelas_mandiri`
--

CREATE TABLE `kelas_mandiri` (
  `kelas` varchar(1) NOT NULL,
  `iuran_perbulan` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kelas_mandiri`
--

INSERT INTO `kelas_mandiri` (`kelas`, `iuran_perbulan`) VALUES
('1', 160000),
('2', 110000),
('3', 42000);

-- --------------------------------------------------------

--
-- Table structure for table `peserta`
--

CREATE TABLE `peserta` (
  `nomor_kartu` varchar(15) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `ttl` varchar(50) NOT NULL,
  `nomor_kk` varchar(20) NOT NULL,
  `nik` varchar(20) NOT NULL,
  `faskes` varchar(50) NOT NULL,
  `status` enum('PPU','PBI','Mandiri') NOT NULL,
  `kelas` enum('Kelas 1','Kelas 2','Kelas 3','-') NOT NULL,
  `pembayaran` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peserta`
--

INSERT INTO `peserta` (`nomor_kartu`, `nama`, `alamat`, `ttl`, `nomor_kk`, `nik`, `faskes`, `status`, `kelas`, `pembayaran`) VALUES
('0002743817274', 'Riski Pratama Putra', 'Jl. Amanah RT. 03/08 No.106 Kel. Cibinong, Kec. Cibinong, Kab. Bogor, Jawa Barat ', 'Bogor, 24-03-1990', '1803015053', '57381928847382948', 'Klinik Noordin Wahid', 'Mandiri', 'Kelas 3', '2020-04-30'),
('0002747141662', 'Riky Ardiansyah', 'Jl. Amanah RT. 03/08 No.106 Kel. Cibinong, Kec. Cibinong, Kab. Bogor, Jawa Barat ', 'Bogor, 14-03-2000', '1803015053', '3201011403000019', 'Klinik Noordin Wahid', 'Mandiri', 'Kelas 3', '2020-04-30'),
('1245323554323', 'Agus Winarto', 'Jl. Rawarontek RT. 03/01, Kel. Sukamakmur, Kec. Sukamandi, Kab. Jonggol, Jawa Barat', 'Jonggol, 07-08-1999', '32859384728392814', '17238239475839402', 'Klinik Sukamaju', 'Mandiri', 'Kelas 1', '2019-03-21');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_diri`
--
ALTER TABLE `data_diri`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `kartu`
--
ALTER TABLE `kartu`
  ADD PRIMARY KEY (`nomor_kartu`);

--
-- Indexes for table `kelas_mandiri`
--
ALTER TABLE `kelas_mandiri`
  ADD PRIMARY KEY (`kelas`);

--
-- Indexes for table `peserta`
--
ALTER TABLE `peserta`
  ADD PRIMARY KEY (`nomor_kartu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
