-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-07-2021 a las 00:23:35
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `redbayesiana`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_data`
--

CREATE TABLE `tbl_data` (
  `idData` int(11) NOT NULL,
  `isCovid` int(11) NOT NULL,
  `dolencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_data`
--

INSERT INTO `tbl_data` (`idData`, `isCovid`, `dolencia`) VALUES
(1, 1, 2),
(2, 1, 1),
(3, 0, 3),
(4, 1, 2),
(5, 1, 2),
(6, 1, 3),
(7, 0, 1),
(8, 1, 2),
(9, 0, 3),
(10, 1, 2),
(11, 0, 3),
(12, 1, 1),
(13, 0, 2),
(14, 1, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_data`
--
ALTER TABLE `tbl_data`
  ADD PRIMARY KEY (`idData`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_data`
--
ALTER TABLE `tbl_data`
  MODIFY `idData` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
