-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2021 at 09:31 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pbo_proyek`
--

-- --------------------------------------------------------

--
-- Table structure for table `dtrans`
--

CREATE TABLE `dtrans` (
  `nomorNota` varchar(16) NOT NULL,
  `id_menu` int(10) NOT NULL,
  `qty` int(10) NOT NULL,
  `harga` int(10) NOT NULL,
  `subtotal` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dtrans`
--

INSERT INTO `dtrans` (`nomorNota`, `id_menu`, `qty`, `harga`, `subtotal`) VALUES
('NOTA211120210001', 5, 2, 5000, 10000),
('NOTA211120210001', 4, 2, 20000, 40000),
('NOTA211120210002', 6, 2, 18000, 36000),
('NOTA211120210002', 2, 2, 12000, 24000),
('NOTA211120210003', 1, 1, 10000, 10000),
('NOTA211120210003', 5, 2, 5000, 10000),
('NOTA211120210003', 9, 1, 5000, 5000),
('NOTA211120210003', 8, 1, 5000, 5000),
('NOTA261120210001', 2, 2, 12000, 24000),
('NOTA261120210002', 1, 1, 10000, 10000),
('NOTA261120210002', 5, 1, 5000, 5000),
('NOTA271120210001', 1, 1, 10000, 10000),
('NOTA271120210001', 4, 2, 20000, 40000),
('NOTA271120210001', 8, 2, 5000, 10000),
('NOTA061220210001', 1, 1, 10000, 10000),
('NOTA061220210001', 4, 1, 20000, 20000),
('NOTA061220210001', 8, 1, 5000, 5000),
('NOTA061220210002', 1, 1, 10000, 10000),
('NOTA061220210003', 4, 1, 20000, 20000),
('NOTA061220210003', 5, 1, 5000, 5000),
('NOTA061220210003', 1, 2, 10000, 20000),
('NOTA061220210003', 2, 1, 12000, 12000),
('NOTA071220210001', 1, 5, 10000, 50000),
('NOTA071220210001', 2, 1, 12000, 12000);

-- --------------------------------------------------------

--
-- Table structure for table `htrans`
--

CREATE TABLE `htrans` (
  `nomorNota` varchar(16) NOT NULL,
  `tanggalTrans` date NOT NULL,
  `jamTrans` time(6) NOT NULL,
  `metodePembayaran` varchar(50) NOT NULL,
  `total` int(10) NOT NULL,
  `id_karyawan` int(10) NOT NULL,
  `status` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `htrans`
--

INSERT INTO `htrans` (`nomorNota`, `tanggalTrans`, `jamTrans`, `metodePembayaran`, `total`, `id_karyawan`, `status`) VALUES
('NOTA061220210001', '2021-12-06', '00:28:37.321000', 'Go-Pay', 35000, 1, 99),
('NOTA061220210002', '2021-12-06', '00:29:57.740000', 'Go-Pay', 10000, 1, 99),
('NOTA061220210003', '2021-12-06', '00:31:16.586000', 'Go-Pay', 57000, 1, 12),
('NOTA071220210001', '2021-12-07', '23:57:56.764000', 'Go-Pay', 62000, 1, 3),
('NOTA211120210001', '2021-11-21', '16:36:27.000000', 'Tunai', 50000, 1, 5),
('NOTA211120210002', '2021-11-21', '17:43:51.348000', 'Go-Pay', 60000, 2, 99),
('NOTA211120210003', '2021-11-21', '17:45:51.348000', 'Ovo', 30000, 3, 4),
('NOTA261120210001', '2021-11-26', '20:58:07.755000', 'Tunai', 24000, 1, 1),
('NOTA261120210002', '2021-11-26', '21:22:25.430000', 'Go-Pay', 15000, 1, 1),
('NOTA271120210001', '2021-11-27', '21:57:14.157000', 'Go-Pay', 60000, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `status` int(10) NOT NULL,
  `jabatan` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `username`, `password`, `nama`, `status`, `jabatan`) VALUES
(1, 'karyawan1', 'karyawan1', 'Michael', 1, 1),
(2, 'karyawan2', 'karyawan2', 'Rico', 1, 1),
(3, 'karyawan3', 'karyawan3', 'Jonathan', 0, 1),
(4, 'manager1', 'manager1', 'Novan', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id_menu` int(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` int(10) NOT NULL,
  `kategori` varchar(50) NOT NULL,
  `status` int(10) NOT NULL,
  `imageURL` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id_menu`, `nama`, `harga`, `kategori`, `status`, `imageURL`) VALUES
(1, 'Nasi Goreng', 10000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Nasi Goreng.jpg'),
(2, 'Mie Goreng', 12000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Mie Goreng.jpg'),
(4, 'Udang Goreng Tepung', 20000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Udang Goreng Tepung.jpg'),
(5, 'Es Teh Manis', 5000, 'Minuman', 1, 'src\\testproject\\images\\Makanan\\Es Teh Manis.jpg'),
(6, 'Ayam Goreng', 18000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Ayam Goreng.jpg'),
(7, 'Teh Tawar', 4000, 'Minuman', 1, 'src\\testproject\\images\\Makanan\\Teh Tawar.jpg'),
(8, 'Lumpia', 5000, 'Snack', 1, 'src\\testproject\\images\\Makanan\\Lumpia.jpg'),
(9, 'Pastel', 5000, 'Snack', 1, 'src\\testproject\\images\\Makanan\\Pastel.jpg'),
(10, 'Pangsit', 6000, 'Snack', 1, 'src\\testproject\\images\\Makanan\\Pangsit.jpg'),
(11, 'Es Jeruk', 4000, 'Minuman', 1, 'src\\testproject\\images\\Makanan\\Es Jeruk.jpg'),
(12, 'Milkshake Strawberry', 9000, 'Minuman', 1, 'src\\testproject\\images\\Makanan\\Milkshake Strawberry.jpg'),
(13, 'Nasi Goreng Cabai Hijau', 10000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Nasi Goreng Cabai Hijau.jpg'),
(14, 'Bebek Goreng', 13000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Bebek Goreng.jpg'),
(15, 'Tempe Goreng', 7000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Tempe Goreng.jpg'),
(16, 'Tempe Bacem', 9000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Tempe Bacem.jpg'),
(17, 'Nasi Putih', 5000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Nasi Putih.jpg'),
(18, 'Rendang', 23000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Rendang.jpg'),
(19, 'Koloke', 21000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Koloke.jpg'),
(20, 'Capcai', 17000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Capcai.jpg'),
(21, 'Mie Goreng jumbo', 19000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Mie Goreng jumbo.jpg'),
(22, 'Rawon', 18000, 'Makanan', 1, 'src\\testproject\\images\\Makanan\\Rawon.jpg'),
(23, 'Milkshake Cokelat', 9000, 'Minuman', 1, 'src\\testproject\\images\\Makanan\\Milkshake Cokelat.jpg'),
(28, 'Mie Goreng Cabai Hijau', 9000, 'Makanan', 0, 'src\\testproject\\images\\Makanan\\Mie Goreng Cabai Hijau.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dtrans`
--
ALTER TABLE `dtrans`
  ADD KEY `FK_MENU` (`id_menu`),
  ADD KEY `FK_HTRANS` (`nomorNota`);

--
-- Indexes for table `htrans`
--
ALTER TABLE `htrans`
  ADD PRIMARY KEY (`nomorNota`),
  ADD KEY `FK_KARYAWAN` (`id_karyawan`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id_menu`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_karyawan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id_menu` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dtrans`
--
ALTER TABLE `dtrans`
  ADD CONSTRAINT `FK_HTRANS` FOREIGN KEY (`nomorNota`) REFERENCES `htrans` (`nomorNota`),
  ADD CONSTRAINT `FK_MENU` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`);

--
-- Constraints for table `htrans`
--
ALTER TABLE `htrans`
  ADD CONSTRAINT `FK_KARYAWAN` FOREIGN KEY (`id_karyawan`) REFERENCES `karyawan` (`id_karyawan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
