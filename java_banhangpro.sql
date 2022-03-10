-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 10, 2022 lúc 04:19 PM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `java.banhangpro`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categori`
--

CREATE TABLE `categori` (
  `id_categori` int(11) NOT NULL,
  `name_categori` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `categori`
--

INSERT INTO `categori` (`id_categori`, `name_categori`) VALUES
(1, 'iPhone'),
(2, 'Samsung'),
(3, 'OPPO');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id_product` int(11) NOT NULL,
  `name_product` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `amount` int(11) NOT NULL DEFAULT 0,
  `id_categori` int(11) NOT NULL,
  `about` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id_product`, `name_product`, `price`, `amount`, `id_categori`, `about`, `status`) VALUES
(1, 'iPhone 13 Pro Max 128GB', 32390000, 10, 1, NULL, 1),
(2, 'Samsung Galaxy A52s 5G 128GB', 10990000, 10, 2, NULL, 1),
(3, 'OPPO Reno6 Z 5G', 8990000, 10, 3, NULL, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `name_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id_user`, `name_user`, `user_name`, `password`) VALUES
(1, 'Đặng (Tus) Văn Hoài Tú', 'tus', 'admin');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categori`
--
ALTER TABLE `categori`
  ADD PRIMARY KEY (`id_categori`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id_product`),
  ADD KEY `id_categori` (`id_categori`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categori`
--
ALTER TABLE `categori`
  MODIFY `id_categori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id_product` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`id_categori`) REFERENCES `categori` (`id_categori`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
