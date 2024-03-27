-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-03-2024 a las 03:15:52
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `stel1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `new_has_role`
--

CREATE TABLE `new_has_role` (
  `fkid_novedades` int(11) NOT NULL,
  `fkid_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `new_has_role`
--

INSERT INTO `new_has_role` (`fkid_novedades`, `fkid_rol`) VALUES
(2, 2),
(3, 1),
(2, 2),
(3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `property_correspondence`
--

CREATE TABLE `property_correspondence` (
  `fkid_inmueble` int(11) NOT NULL,
  `fkid_correspondencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `property_correspondence`
--

INSERT INTO `property_correspondence` (`fkid_inmueble`, `fkid_correspondencia`) VALUES
(1, 1),
(2, 2),
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_correspondencia`
--

CREATE TABLE `tbl_correspondencia` (
  `id` int(11) NOT NULL,
  `tipo_correspondencia` varchar(30) DEFAULT NULL,
  `frec_correspodencia` datetime DEFAULT NULL,
  `est_correspondencia` varchar(20) DEFAULT NULL,
  `fentr_correspondencia` datetime DEFAULT NULL,
  `fkid_trabajador` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_correspondencia`
--

INSERT INTO `tbl_correspondencia` (`id`, `tipo_correspondencia`, `frec_correspodencia`, `est_correspondencia`, `fentr_correspondencia`, `fkid_trabajador`) VALUES
(1, 'Convocatoria reunion', '2023-09-07 13:11:00', 'Entregado', '2023-09-07 15:30:00', 3),
(2, 'Paquete', '2023-12-12 13:30:00', 'Entregado', '2023-12-13 08:20:00', 3),
(3, 'Recibo', '2024-01-12 13:30:00', 'Entregado', '2024-01-03 08:20:00', 3),
(4, 'Recibo Luz', '2024-03-15 09:30:00', 'Entregado', '2024-03-15 13:20:00', 3),
(5, 'Recibo Gas', '2024-03-15 09:30:00', 'Entregado', '2024-03-15 13:20:00', 3),
(6, 'Recibo Gas', '2024-03-15 09:30:00', 'Entregado', '2024-03-15 13:20:00', 3),
(7, 'Paquete', '2024-03-15 09:30:00', 'Entregado', '2024-03-15 13:20:00', 3),
(8, 'Cartilla Asamblea', '2024-03-15 09:30:00', 'Entregado', '2024-03-15 13:20:00', 3),
(9, 'Paquete chileno', '2024-02-18 09:30:00', 'Entregado', '2024-03-15 13:20:00', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_docsadmin`
--

CREATE TABLE `tbl_docsadmin` (
  `id` int(11) NOT NULL,
  `class_docsadmin` varchar(30) DEFAULT NULL,
  `peti_docsadmin` varchar(30) DEFAULT NULL,
  `fkid_trabajador` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_docsadmin`
--

INSERT INTO `tbl_docsadmin` (`id`, `class_docsadmin`, `peti_docsadmin`, `fkid_trabajador`) VALUES
(1, 'Presupuesto', '2023 Diciembre', 1),
(2, 'Balance', 'diciembre 2024', 1),
(3, 'Presupuesto', '2023 Agosto', 1),
(4, 'Poliza', '2024 DIciembre', 1),
(5, 'Demanda', '2025 Agosto', 1),
(6, 'Acta', '2022 Agosto', 1),
(7, 'Presupuesto', '2029 Agosto', 1),
(8, 'Acta', '2030 Agosto', 1),
(9, 'Rendición de cuentas', '2023 Diciembre', 1),
(10, 'acta', 'diciembre 2022', 1),
(11, 'Estados Financieros', '2024 Diciembre', 1),
(12, 'Presupuesto', '2024 Enero', 1),
(13, 'Presupuesto', '2024 Marzo', 1),
(14, 'Rendicion de cuentas', '2024 Diciembre', 1),
(15, 'Estado financiero', '2023 Junio', 1),
(16, 'Estado financiero', '2023 Junio', 1),
(17, 'Estado financiero', '2023 Junio', 1),
(18, 'Estado financiero', '2023 Junio', 1),
(19, 'Convocatoria', '2023 Junio', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_estcartera`
--

CREATE TABLE `tbl_estcartera` (
  `id` int(11) NOT NULL,
  `docest_cartera` varchar(50) DEFAULT NULL,
  `est_cartera` varchar(30) DEFAULT NULL,
  `tacc_estcartera` varchar(20) DEFAULT NULL,
  `noti_estcartera` varchar(35) DEFAULT NULL,
  `fkid_inmueble` int(11) DEFAULT NULL,
  `fkid_trabajador` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_estcartera`
--

INSERT INTO `tbl_estcartera` (`id`, `docest_cartera`, `est_cartera`, `tacc_estcartera`, `noti_estcartera`, `fkid_inmueble`, `fkid_trabajador`) VALUES
(1, 'paz y salvo.pdf', 'Paz y salvo', 'Permitido', 'Enviar certificado', 1, 1),
(2, 'pazysalvo.pdf', 'Paz y Salvo', 'Permitido', 'enviar certificado', 2, 1),
(4, 'paz y salvo.pdf', 'Mora', 'Bloqueado', 'Notificar Residente', NULL, 1),
(5, 'paz y salvo.pdf', 'Mora', 'Bloqueado', 'Notificar Residente', NULL, 1),
(6, 'paz y salvo.pdf', 'Mora', 'Bloqueado', 'Notificar Residente', NULL, 1),
(7, 'mora.pdf', 'Mora', 'Bloqueado', 'Notificar Residente', NULL, 1),
(8, 'mora.pdf', 'Mora', 'Bloqueado', 'Notificar', NULL, 1),
(9, 'mora.pdf', 'Mora', 'Bloqueado', 'Notificar', NULL, 1),
(10, 'mora.pdf', 'Mora', 'Bloqueado', 'Notificar', NULL, 1),
(11, 'mora.pdf', 'Acuerdo de pago', 'Bloqueado', 'Notificar residente', NULL, 1),
(12, 'mora.pdf', 'Acuerdo de pago', 'Bloqueado', 'Notificar residente', NULL, 1),
(13, 'acuerdopago.pdf', 'Acuerdo de pago', 'Bloqueado', 'Notificar residente', NULL, 1),
(14, 'acuerdopago.pdf', 'Acuerdo de pago', 'Bloqueado', 'Notificar residente', 1, 1),
(15, 'pazysalvo.pdf', 'pazysalvo', 'Permitido', 'Notificar residente', 1, 1),
(16, 'pazysalvo.pdf', 'pazysalvo', 'Permitido', 'Notificar residente', 1, 1),
(17, 'pazysalvo.pdf', 'pazysalvo', 'Permitido', 'Notificar residente', 5, 1),
(18, 'paz y salvo.pdf', 'Paz y salvo', 'Permitido', 'Enviar certificado', NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_inmueble`
--

CREATE TABLE `tbl_inmueble` (
  `id` int(11) NOT NULL,
  `and_inmueble` int(11) DEFAULT NULL,
  `num_inmueble` int(11) DEFAULT NULL,
  `fkid_residente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_inmueble`
--

INSERT INTO `tbl_inmueble` (`id`, `and_inmueble`, `num_inmueble`, `fkid_residente`) VALUES
(1, 1, 1, 1),
(2, 1, 2, NULL),
(3, 1, 3, NULL),
(4, 1, 4, NULL),
(5, 1, 5, NULL),
(6, 1, 6, NULL),
(7, 1, 7, NULL),
(8, 1, 8, NULL),
(9, 1, 9, NULL),
(10, 1, 10, NULL),
(11, 1, 11, NULL),
(12, 1, 12, NULL),
(13, 1, 13, NULL),
(14, 1, 14, NULL),
(15, 1, 15, NULL),
(16, 1, 16, NULL),
(17, 1, 17, NULL),
(18, 1, 18, NULL),
(19, 1, 19, NULL),
(20, 1, 20, NULL),
(21, 1, 21, NULL),
(22, 1, 22, NULL),
(23, 1, 23, NULL),
(24, 1, 24, NULL),
(25, 1, 25, NULL),
(26, 1, 26, NULL),
(27, 1, 27, NULL),
(28, 1, 28, NULL),
(29, 1, 29, NULL),
(30, 1, 30, NULL),
(31, 2, 31, NULL),
(32, 2, 32, NULL),
(33, 2, 33, NULL),
(34, 2, 34, NULL),
(35, 2, 35, NULL),
(36, 2, 36, NULL),
(37, 2, 37, NULL),
(38, 2, 38, NULL),
(39, 2, 39, NULL),
(40, 2, 40, NULL),
(41, 2, 41, NULL),
(42, 2, 42, NULL),
(43, 2, 43, NULL),
(44, 2, 44, NULL),
(45, 2, 45, NULL),
(46, 2, 46, NULL),
(47, 2, 47, NULL),
(48, 2, 48, NULL),
(49, 2, 49, NULL),
(50, 2, 50, NULL),
(51, 2, 51, NULL),
(52, 2, 52, NULL),
(53, 2, 53, NULL),
(54, 2, 54, NULL),
(55, 2, 55, NULL),
(56, 2, 56, NULL),
(57, 2, 57, NULL),
(58, 2, 58, NULL),
(59, 2, 59, NULL),
(60, 2, 60, NULL),
(61, 2, 61, NULL),
(62, 2, 62, NULL),
(63, 3, 63, NULL),
(64, 3, 64, NULL),
(65, 3, 65, NULL),
(66, 3, 66, NULL),
(67, 3, 67, NULL),
(68, 3, 68, NULL),
(69, 3, 69, NULL),
(70, 3, 70, NULL),
(71, 3, 71, NULL),
(72, 3, 72, NULL),
(73, 3, 73, NULL),
(74, 3, 74, NULL),
(75, 3, 75, NULL),
(76, 3, 76, NULL),
(77, 3, 77, NULL),
(78, 3, 78, NULL),
(79, 3, 79, NULL),
(80, 3, 80, NULL),
(81, 3, 81, NULL),
(82, 3, 82, NULL),
(83, 3, 83, NULL),
(84, 3, 84, NULL),
(85, 3, 85, NULL),
(86, 3, 86, NULL),
(87, 4, 87, NULL),
(88, 4, 88, NULL),
(89, 4, 89, NULL),
(90, 4, 90, NULL),
(91, 4, 91, NULL),
(92, 4, 92, NULL),
(93, 4, 93, NULL),
(94, 4, 94, NULL),
(95, 4, 95, NULL),
(96, 4, 96, NULL),
(97, 4, 97, NULL),
(98, 4, 98, NULL),
(99, 4, 99, NULL),
(100, 4, 100, NULL),
(101, 4, 101, NULL),
(102, 5, 102, NULL),
(103, 5, 103, NULL),
(104, 5, 104, NULL),
(105, 5, 105, NULL),
(106, 5, 106, NULL),
(107, 5, 107, NULL),
(108, 5, 108, NULL),
(109, 5, 109, NULL),
(110, 5, 110, NULL),
(111, 5, 111, NULL),
(112, 5, 112, NULL),
(113, 5, 113, NULL),
(114, 5, 114, NULL),
(115, 5, 115, NULL),
(116, 6, 116, NULL),
(117, 6, 117, NULL),
(118, 6, 118, NULL),
(119, 6, 119, NULL),
(120, 6, 120, NULL),
(121, 6, 121, NULL),
(122, 6, 122, NULL),
(123, 6, 123, NULL),
(124, 6, 124, NULL),
(125, 6, 125, NULL),
(126, 6, 126, NULL),
(127, 6, 127, NULL),
(128, 6, 128, NULL),
(129, 6, 129, NULL),
(130, 6, 130, NULL),
(131, 6, 131, NULL),
(132, 6, 132, NULL),
(133, 6, 133, NULL),
(134, 6, 134, NULL),
(135, 6, 135, NULL),
(136, 6, 136, NULL),
(137, 6, 137, NULL),
(138, 6, 138, NULL),
(139, 6, 139, NULL),
(140, 7, 140, NULL),
(141, 7, 141, NULL),
(142, 7, 142, NULL),
(143, 7, 143, NULL),
(144, 7, 144, NULL),
(145, 7, 145, NULL),
(146, 7, 146, NULL),
(147, 7, 147, NULL),
(148, 7, 148, NULL),
(149, 7, 149, NULL),
(150, 7, 150, NULL),
(151, 7, 151, NULL),
(152, 7, 152, NULL),
(153, 7, 153, NULL),
(154, 7, 154, NULL),
(155, 7, 155, NULL),
(156, 7, 156, NULL),
(157, 7, 157, NULL),
(158, 7, 158, NULL),
(159, 7, 159, NULL),
(160, 7, 160, NULL),
(161, 7, 161, NULL),
(162, 7, 162, NULL),
(163, 7, 163, NULL),
(164, 8, 164, NULL),
(165, 8, 165, NULL),
(166, 8, 166, NULL),
(167, 8, 167, NULL),
(168, 8, 168, NULL),
(169, 8, 169, NULL),
(170, 8, 170, NULL),
(171, 8, 171, NULL),
(172, 8, 172, NULL),
(173, 8, 173, NULL),
(174, 8, 174, NULL),
(175, 8, 175, NULL),
(176, 8, 176, NULL),
(177, 8, 177, NULL),
(178, 8, 178, NULL),
(179, 8, 179, NULL),
(180, 8, 180, NULL),
(181, 8, 181, NULL),
(182, 8, 182, NULL),
(183, 8, 183, NULL),
(184, 8, 184, NULL),
(185, 8, 185, NULL),
(186, 8, 186, NULL),
(187, 8, 187, NULL),
(188, 9, 188, NULL),
(189, 9, 189, NULL),
(190, 9, 190, NULL),
(191, 9, 191, NULL),
(192, 9, 192, NULL),
(193, 9, 193, NULL),
(194, 9, 194, NULL),
(195, 9, 195, NULL),
(196, 9, 196, NULL),
(197, 9, 197, NULL),
(198, 9, 198, NULL),
(199, 9, 199, NULL),
(200, 9, 200, NULL),
(201, 9, 201, NULL),
(202, 9, 202, NULL),
(203, 9, 203, NULL),
(204, 9, 204, NULL),
(205, 9, 205, NULL),
(206, 9, 206, NULL),
(207, 9, 207, NULL),
(208, 9, 208, NULL),
(209, 9, 209, NULL),
(210, 9, 210, NULL),
(211, 9, 211, NULL),
(212, 9, 212, NULL),
(213, 9, 213, NULL),
(214, 10, 214, NULL),
(215, 10, 215, NULL),
(216, 10, 216, NULL),
(217, 10, 217, NULL),
(218, 10, 218, NULL),
(219, 10, 219, NULL),
(220, 10, 220, NULL),
(221, 10, 221, NULL),
(222, 10, 222, NULL),
(223, 10, 223, NULL),
(224, 10, 224, NULL),
(225, 10, 225, NULL),
(226, 10, 226, NULL),
(227, 10, 227, NULL),
(228, 10, 228, NULL),
(229, 10, 229, NULL),
(230, 10, 230, NULL),
(231, 10, 231, NULL),
(232, 10, 232, NULL),
(233, 10, 233, NULL),
(234, 10, 234, NULL),
(235, 10, 235, NULL),
(236, 10, 236, NULL),
(237, 10, 237, NULL),
(238, 10, 238, NULL),
(239, 10, 239, NULL),
(240, 10, 240, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_multa`
--

CREATE TABLE `tbl_multa` (
  `id` int(11) NOT NULL,
  `tipo_multa` varchar(30) DEFAULT NULL,
  `fec_multa` datetime DEFAULT NULL,
  `evid_multa` varchar(35) DEFAULT NULL,
  `val_multa` int(11) NOT NULL,
  `fpag_multa` datetime DEFAULT NULL,
  `fkid_inmueble` int(11) DEFAULT NULL,
  `fkid_trabajador` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_multa`
--

INSERT INTO `tbl_multa` (`id`, `tipo_multa`, `fec_multa`, `evid_multa`, `val_multa`, `fpag_multa`, `fkid_inmueble`, `fkid_trabajador`) VALUES
(1, 'Estacionamiento indebido', '2023-01-10 22:00:00', 'Multa.pdf', 250000, '2023-02-10 10:15:00', 3, 3),
(2, 'Ruido excesivo', '2023-11-11 00:15:00', 'Multa.pdf', 100000, '2024-02-10 13:18:00', 4, 3),
(3, 'Mascota sin correa', '2023-12-11 00:15:00', 'Multa.pdf', 100000, '2024-02-10 13:18:00', 1, 3),
(4, 'Ruido excesivo', '2023-12-11 00:15:00', 'Multa.pdf', 100000, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_novedades`
--

CREATE TABLE `tbl_novedades` (
  `id` int(11) NOT NULL,
  `asunto_novedades` varchar(65) DEFAULT NULL,
  `desc_novedades` varchar(65) DEFAULT NULL,
  `doc_novedades` varchar(35) DEFAULT NULL,
  `est_novedades` varchar(25) DEFAULT NULL,
  `fec_novedades` datetime DEFAULT NULL,
  `rem_novedades` varchar(30) DEFAULT NULL,
  `res_novedades` varchar(30) DEFAULT NULL,
  `tipo_novedad` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_novedades`
--

INSERT INTO `tbl_novedades` (`id`, `asunto_novedades`, `desc_novedades`, `doc_novedades`, `est_novedades`, `fec_novedades`, `rem_novedades`, `res_novedades`, `tipo_novedad`) VALUES
(2, 'Solicitud Camara Seguridad', 'Revisión cámaras de seguridad', 'documentonovedad.pdf', 'Solicitud Atendida', '2023-06-12 14:45:00', 'Jose Perez', 'verificar danos', 'Residente'),
(3, 'Solicitud Zonas Comunes', 'Reporte de danos en las areas comunes', 'documentonovedad.pdf', 'Solicitud Atendida', '2023-06-12 14:45:00', 'Dan Casas', 'verificar danos', 'Residente'),
(4, 'Solicitud Camara Seguridad', 'danos', 'documentonovedad.pdf', 'Solicitud Atendida', '2023-06-12 14:45:00', 'Jose Perez', 'verificar danos', 'Residente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_parqueadero`
--

CREATE TABLE `tbl_parqueadero` (
  `id` int(11) NOT NULL,
  `tipo_parqueadero` varchar(30) DEFAULT NULL,
  `estado_parqueadero` varchar(30) DEFAULT NULL,
  `fec_parqueadero` datetime DEFAULT NULL,
  `dvte_parqueadero` varchar(45) DEFAULT NULL,
  `cup_parqueadero` int(11) DEFAULT NULL,
  `hora_salida` datetime DEFAULT NULL,
  `tar_parqueadero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_parqueadero`
--

INSERT INTO `tbl_parqueadero` (`id`, `tipo_parqueadero`, `estado_parqueadero`, `fec_parqueadero`, `dvte_parqueadero`, `cup_parqueadero`, `hora_salida`, `tar_parqueadero`) VALUES
(1, 'Carro-propietario', 'inhabilitado', '2023-06-15 11:00:00', 'bmw-662 bmw negro', 1, NULL, 45000),
(2, 'Carro-propietario', 'inhabilitado', '2023-09-20 05:38:00', 'ABC123 kwai rojo', 18, NULL, 40000),
(3, 'Carro-Visitante', 'Habilitado', '2023-12-11 15:30:05', 'XSW-487 Sail blanco', 30, '2023-12-11 16:21:57', 5000),
(4, 'Carro-Visitante', 'Habilitado', '2023-12-13 10:50:09', 'HFR-631 Logan negro', 55, '2023-12-13 12:31:57', 5000),
(5, 'Carro-propietario', 'inhabilitado', '2023-09-20 05:38:00', 'XSG456 Sail rojo', 22, NULL, 40000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_residente`
--

CREATE TABLE `tbl_residente` (
  `id` int(11) NOT NULL,
  `nom_residente` varchar(35) DEFAULT NULL,
  `ced_residente` int(11) DEFAULT NULL,
  `ema_residente` varchar(40) DEFAULT NULL,
  `cel_residente` bigint(11) DEFAULT NULL,
  `num_integrantes` int(11) DEFAULT NULL,
  `fkid_parqueadero` int(11) DEFAULT NULL,
  `fkid_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_residente`
--

INSERT INTO `tbl_residente` (`id`, `nom_residente`, `ced_residente`, `ema_residente`, `cel_residente`, `num_integrantes`, `fkid_parqueadero`, `fkid_rol`) VALUES
(1, 'Orlando Diaz', 110143564, 'orlandodiazdelgado@hotmail.com', 3102458753, 4, 1, 1),
(2, 'Ben Rodriguez', 1114228584, 'benrodriguez@gmail.com', 3134521687, 3, 2, 1),
(3, 'Carlos Olivares', 1034587951, 'carlosol@gmail.com', 3107543210, 2, 2, 1),
(4, 'Lorenzo Lozano', 1048216548, 'londilo@gmail.com', 3138754221, 3, 2, 1),
(5, 'Pablo Diaz', 1114210354, 'padi@gmail.com', 3107543210, 2, NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_rol`
--

CREATE TABLE `tbl_rol` (
  `id` int(11) NOT NULL,
  `nombre_rol` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_rol`
--

INSERT INTO `tbl_rol` (`id`, `nombre_rol`) VALUES
(1, 'Residente'),
(2, 'Administrador'),
(3, 'Vigilante'),
(4, 'Todero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_trabajador`
--

CREATE TABLE `tbl_trabajador` (
  `id` int(11) NOT NULL,
  `nom_trabajador` varchar(35) DEFAULT NULL,
  `cc_trabajador` int(11) NOT NULL,
  `cel_trabajador` bigint(11) NOT NULL,
  `ema_trabajador` varchar(40) DEFAULT NULL,
  `tpco_trabajador` varchar(40) DEFAULT NULL,
  `cont_trabajador` varchar(50) DEFAULT NULL,
  `carg_trabajador` varchar(30) DEFAULT NULL,
  `emp_trabajador` varchar(30) DEFAULT NULL,
  `fkid_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_trabajador`
--

INSERT INTO `tbl_trabajador` (`id`, `nom_trabajador`, `cc_trabajador`, `cel_trabajador`, `ema_trabajador`, `tpco_trabajador`, `cont_trabajador`, `carg_trabajador`, `emp_trabajador`, `fkid_rol`) VALUES
(1, 'Alba Amaya', 1015487412, 3118754210, 'albaamaya@gmail.com', 'Indefinido', 'Contrato.pdf', 'Administrador', 'administradores', 2),
(2, 'Juan Gonzales', 1032798025, 3114521358, 'Juan1971@gmail.com', 'Fijo', 'contrato.pdf', 'Todero', 'ToderoColombia', 4),
(3, 'Celso Olaya', 1032798026, 3102123548, 'Celso1971@gmail.com', 'Prestacion de servicios', 'contrato.pdf', 'Vigilante', 'Seguridad 365', 3),
(4, 'Ruben Noel', 1045785421, 3114587998, 'rubenno@gmail.com', 'Indefinido', 'contrato.pdf', 'Vigilante', 'Vigias Colombia', 3),
(5, 'Jorge Torres', 1011874213, 3102245876, 'jorgetorres@gmail.com', 'Indefinido', 'Contrato.pdf', 'Vigilante', 'Prevenir', 3),
(6, 'Bruce Torres', 1010154875, 3114521879, 'brucetor@gmail.com', 'Indefinido', 'contrato.pdf', 'Vigilante', 'Vigilancia Colombia', 3),
(7, 'Bruce Torres', 1010154875, 3114521879, 'brucetor@gmail.com', 'Indefinido', 'contrato.pdf', 'Vigilante', 'Vigilancia Colombia', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuarios`
--

CREATE TABLE `tbl_usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `contrasena` varchar(15) DEFAULT NULL,
  `fkid_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_usuarios`
--

INSERT INTO `tbl_usuarios` (`id`, `usuario`, `contrasena`, `fkid_rol`) VALUES
(1, 'pabloguzman@gmail.com', 'P@-Gu7m4n.3!', 1),
(2, 'danmartinez@gmail.com', 'D4n.!123', 2),
(3, 'bentedder27@gmail.com', 'T3d-de!37*8/', 3),
(4, 'borjavilaseca@gmail.com', 'B0!r2!/1$-3a', 4),
(5, 'jaimero@gmail.com', 'J4im3ro', 1),
(6, 'bencasas@gmail.com', 'b3nc4s!', 1),
(7, 'laural@gmail.com', 'l4ural@', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_visitantes`
--

CREATE TABLE `tbl_visitantes` (
  `id` int(11) NOT NULL,
  `nom_visitante` varchar(35) DEFAULT NULL,
  `ced_visitante` int(11) DEFAULT NULL,
  `nom_residente` varchar(35) DEFAULT NULL,
  `car_visitante` bit(1) DEFAULT NULL,
  `ingr_visitante` bit(1) DEFAULT NULL,
  `fec_visitante` datetime DEFAULT NULL,
  `fkid_trabajador` int(11) DEFAULT NULL,
  `fkid_parqueadero` int(11) DEFAULT NULL,
  `fkid_inmueble` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_visitantes`
--

INSERT INTO `tbl_visitantes` (`id`, `nom_visitante`, `ced_visitante`, `nom_residente`, `car_visitante`, `ingr_visitante`, `fec_visitante`, `fkid_trabajador`, `fkid_parqueadero`, `fkid_inmueble`) VALUES
(1, 'Guido Alvarez', 14245168, 'Alvaro Alvarez', b'1', b'1', '2024-01-17 06:40:08', 3, 4, 4),
(2, 'Clare Lopez', 1154632485, 'Damian Alvarez', b'1', b'1', '2023-11-17 08:35:08', 3, 3, 3),
(3, 'Juan Carlos Arauzo', 1015487950, 'Orlando Diaz', b'1', b'1', '2023-11-17 08:35:08', 3, 1, 1),
(4, 'Carlos Guarnizo', 1018745120, 'Carlos Olivares', b'0', b'1', '2024-01-17 06:40:08', 3, NULL, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `new_has_role`
--
ALTER TABLE `new_has_role`
  ADD KEY `FKcj516a2s7ee9rxm34il4js20` (`fkid_rol`),
  ADD KEY `FKavrel0867e1bcp1924adfmquw` (`fkid_novedades`);

--
-- Indices de la tabla `property_correspondence`
--
ALTER TABLE `property_correspondence`
  ADD KEY `FKasrj8e1cihlowrcsiu6hw5tmi` (`fkid_correspondencia`),
  ADD KEY `FK2wa7hha45yviy2rpto6y4c0ba` (`fkid_inmueble`);

--
-- Indices de la tabla `tbl_correspondencia`
--
ALTER TABLE `tbl_correspondencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKd08be0l3jmxjjbr9rnlj8sjmp` (`fkid_trabajador`);

--
-- Indices de la tabla `tbl_docsadmin`
--
ALTER TABLE `tbl_docsadmin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdxli6u04j6u52q0twobiyslt` (`fkid_trabajador`);

--
-- Indices de la tabla `tbl_estcartera`
--
ALTER TABLE `tbl_estcartera`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkpdnn5uwpax8x487ub81heg5b` (`fkid_inmueble`),
  ADD KEY `FKmojd19qbf7p50pypiasun622v` (`fkid_trabajador`);

--
-- Indices de la tabla `tbl_inmueble`
--
ALTER TABLE `tbl_inmueble`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjn4gusrj56crrnxcnpdlpgquq` (`fkid_residente`);

--
-- Indices de la tabla `tbl_multa`
--
ALTER TABLE `tbl_multa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh6e6h051h51r229y3ku265515` (`fkid_inmueble`),
  ADD KEY `FKkji958iwl6u52ftmyhu5jlyht` (`fkid_trabajador`);

--
-- Indices de la tabla `tbl_novedades`
--
ALTER TABLE `tbl_novedades`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tbl_parqueadero`
--
ALTER TABLE `tbl_parqueadero`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tbl_residente`
--
ALTER TABLE `tbl_residente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8w3gesmftw8g8cug3qn74jxqk` (`fkid_parqueadero`),
  ADD KEY `FK4tcet6lof1y7vu5qismynlmws` (`fkid_rol`);

--
-- Indices de la tabla `tbl_rol`
--
ALTER TABLE `tbl_rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tbl_trabajador`
--
ALTER TABLE `tbl_trabajador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt1lrnp3fumykv007ohxu3hrql` (`fkid_rol`);

--
-- Indices de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8kmbvss9j8iiea0v84tt41wpx` (`fkid_rol`);

--
-- Indices de la tabla `tbl_visitantes`
--
ALTER TABLE `tbl_visitantes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsim7hyw3kbcv4y92jfq73g5r3` (`fkid_parqueadero`),
  ADD KEY `FKlfa3n6kyqjlb7su6hpblg65rk` (`fkid_inmueble`),
  ADD KEY `FK84s7bxw8llyx2if0jj8kddxp5` (`fkid_trabajador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_correspondencia`
--
ALTER TABLE `tbl_correspondencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `tbl_docsadmin`
--
ALTER TABLE `tbl_docsadmin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `tbl_estcartera`
--
ALTER TABLE `tbl_estcartera`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `tbl_inmueble`
--
ALTER TABLE `tbl_inmueble`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=243;

--
-- AUTO_INCREMENT de la tabla `tbl_multa`
--
ALTER TABLE `tbl_multa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tbl_novedades`
--
ALTER TABLE `tbl_novedades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tbl_parqueadero`
--
ALTER TABLE `tbl_parqueadero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tbl_residente`
--
ALTER TABLE `tbl_residente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tbl_rol`
--
ALTER TABLE `tbl_rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tbl_trabajador`
--
ALTER TABLE `tbl_trabajador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tbl_visitantes`
--
ALTER TABLE `tbl_visitantes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `new_has_role`
--
ALTER TABLE `new_has_role`
  ADD CONSTRAINT `FKavrel0867e1bcp1924adfmquw` FOREIGN KEY (`fkid_novedades`) REFERENCES `tbl_novedades` (`id`),
  ADD CONSTRAINT `FKcj516a2s7ee9rxm34il4js20` FOREIGN KEY (`fkid_rol`) REFERENCES `tbl_rol` (`id`);

--
-- Filtros para la tabla `property_correspondence`
--
ALTER TABLE `property_correspondence`
  ADD CONSTRAINT `FK2wa7hha45yviy2rpto6y4c0ba` FOREIGN KEY (`fkid_inmueble`) REFERENCES `tbl_inmueble` (`id`),
  ADD CONSTRAINT `FKasrj8e1cihlowrcsiu6hw5tmi` FOREIGN KEY (`fkid_correspondencia`) REFERENCES `tbl_correspondencia` (`id`);

--
-- Filtros para la tabla `tbl_correspondencia`
--
ALTER TABLE `tbl_correspondencia`
  ADD CONSTRAINT `FKd08be0l3jmxjjbr9rnlj8sjmp` FOREIGN KEY (`fkid_trabajador`) REFERENCES `tbl_trabajador` (`id`);

--
-- Filtros para la tabla `tbl_docsadmin`
--
ALTER TABLE `tbl_docsadmin`
  ADD CONSTRAINT `FKdxli6u04j6u52q0twobiyslt` FOREIGN KEY (`fkid_trabajador`) REFERENCES `tbl_trabajador` (`id`);

--
-- Filtros para la tabla `tbl_estcartera`
--
ALTER TABLE `tbl_estcartera`
  ADD CONSTRAINT `FKkpdnn5uwpax8x487ub81heg5b` FOREIGN KEY (`fkid_inmueble`) REFERENCES `tbl_inmueble` (`id`),
  ADD CONSTRAINT `FKmojd19qbf7p50pypiasun622v` FOREIGN KEY (`fkid_trabajador`) REFERENCES `tbl_trabajador` (`id`);

--
-- Filtros para la tabla `tbl_inmueble`
--
ALTER TABLE `tbl_inmueble`
  ADD CONSTRAINT `FKjn4gusrj56crrnxcnpdlpgquq` FOREIGN KEY (`fkid_residente`) REFERENCES `tbl_residente` (`id`);

--
-- Filtros para la tabla `tbl_multa`
--
ALTER TABLE `tbl_multa`
  ADD CONSTRAINT `FKh6e6h051h51r229y3ku265515` FOREIGN KEY (`fkid_inmueble`) REFERENCES `tbl_inmueble` (`id`),
  ADD CONSTRAINT `FKkji958iwl6u52ftmyhu5jlyht` FOREIGN KEY (`fkid_trabajador`) REFERENCES `tbl_trabajador` (`id`);

--
-- Filtros para la tabla `tbl_residente`
--
ALTER TABLE `tbl_residente`
  ADD CONSTRAINT `FK4tcet6lof1y7vu5qismynlmws` FOREIGN KEY (`fkid_rol`) REFERENCES `tbl_rol` (`id`),
  ADD CONSTRAINT `FK8w3gesmftw8g8cug3qn74jxqk` FOREIGN KEY (`fkid_parqueadero`) REFERENCES `tbl_parqueadero` (`id`);

--
-- Filtros para la tabla `tbl_trabajador`
--
ALTER TABLE `tbl_trabajador`
  ADD CONSTRAINT `FKt1lrnp3fumykv007ohxu3hrql` FOREIGN KEY (`fkid_rol`) REFERENCES `tbl_rol` (`id`);

--
-- Filtros para la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD CONSTRAINT `FK8kmbvss9j8iiea0v84tt41wpx` FOREIGN KEY (`fkid_rol`) REFERENCES `tbl_rol` (`id`);

--
-- Filtros para la tabla `tbl_visitantes`
--
ALTER TABLE `tbl_visitantes`
  ADD CONSTRAINT `FK84s7bxw8llyx2if0jj8kddxp5` FOREIGN KEY (`fkid_trabajador`) REFERENCES `tbl_trabajador` (`id`),
  ADD CONSTRAINT `FKlfa3n6kyqjlb7su6hpblg65rk` FOREIGN KEY (`fkid_inmueble`) REFERENCES `tbl_inmueble` (`id`),
  ADD CONSTRAINT `FKsim7hyw3kbcv4y92jfq73g5r3` FOREIGN KEY (`fkid_parqueadero`) REFERENCES `tbl_parqueadero` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
