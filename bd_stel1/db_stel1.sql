-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-06-2024 a las 07:55:02
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
-- Base de datos: `db_stel1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `new_has_role`
--

CREATE TABLE `new_has_role` (
  `fkid_novedades` int(11) NOT NULL,
  `fkid_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `property_correspondence`
--

CREATE TABLE `property_correspondence` (
  `fkid_inmueble` int(11) NOT NULL,
  `fkid_correspondencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_correspondencia`
--

CREATE TABLE `tbl_correspondencia` (
  `id` int(11) NOT NULL,
  `tipo_correspondencia` varchar(30) DEFAULT NULL,
  `est_correspondencia` varchar(20) DEFAULT NULL,
  `fentr_correspondencia` datetime(6) DEFAULT NULL,
  `frec_correspodencia` datetime(6) DEFAULT NULL,
  `fkid_trabajador` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_estcartera`
--

CREATE TABLE `tbl_estcartera` (
  `id` int(11) NOT NULL,
  `est_cartera` varchar(30) DEFAULT NULL,
  `noti_estcartera` varchar(35) DEFAULT NULL,
  `tacc_estcartera` varchar(20) DEFAULT NULL,
  `fkid_inmueble` int(11) DEFAULT NULL,
  `fkid_trabajador` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_multa`
--

CREATE TABLE `tbl_multa` (
  `id` int(11) NOT NULL,
  `tipo_multa` varchar(30) DEFAULT NULL,
  `fec_multa` datetime(6) DEFAULT NULL,
  `val_multa` int(11) NOT NULL,
  `fpag_multa` datetime(6) DEFAULT NULL,
  `fkid_inmueble` int(11) DEFAULT NULL,
  `fkid_trabajador` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_novedades`
--

CREATE TABLE `tbl_novedades` (
  `id` int(11) NOT NULL,
  `asunto_novedades` varchar(65) DEFAULT NULL,
  `desc_novedades` varchar(65) DEFAULT NULL,
  `est_novedades` varchar(25) DEFAULT NULL,
  `fec_novedades` datetime(6) DEFAULT NULL,
  `rem_novedades` varchar(30) DEFAULT NULL,
  `res_novedades` varchar(30) DEFAULT NULL,
  `tipo_novedad` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_parqueadero`
--

CREATE TABLE `tbl_parqueadero` (
  `id` int(11) NOT NULL,
  `tipo_parqueadero` varchar(30) DEFAULT NULL,
  `estado_parqueadero` varchar(30) DEFAULT NULL,
  `fec_parqueadero` datetime(6) DEFAULT NULL,
  `dvte_parqueadero` varchar(45) DEFAULT NULL,
  `cup_parqueadero` int(11) DEFAULT NULL,
  `hora_salida` datetime(6) DEFAULT NULL,
  `tar_parqueadero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_residente`
--

CREATE TABLE `tbl_residente` (
  `id` int(11) NOT NULL,
  `num_integrantes` int(11) DEFAULT NULL,
  `fkid_parqueadero` int(11) DEFAULT NULL,
  `fkid_rol` int(11) DEFAULT NULL,
  `fkid_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_residente`
--

INSERT INTO `tbl_residente` (`id`, `num_integrantes`, `fkid_parqueadero`, `fkid_rol`, `fkid_user`) VALUES
(2, 3, NULL, 2, 3);

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
(1, 'Administrador'),
(2, 'Residente'),
(3, 'Vigilante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_trabajador`
--

CREATE TABLE `tbl_trabajador` (
  `id` int(11) NOT NULL,
  `tpco_trabajador` varchar(40) DEFAULT NULL,
  `carg_trabajador` varchar(30) DEFAULT NULL,
  `emp_trabajador` varchar(30) DEFAULT NULL,
  `fkid_rol` int(11) DEFAULT NULL,
  `fkid_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_trabajador`
--

INSERT INTO `tbl_trabajador` (`id`, `tpco_trabajador`, `carg_trabajador`, `emp_trabajador`, `fkid_rol`, `fkid_user`) VALUES
(1, 'Prestación de servicios', 'Administrador', 'admins', 1, 1),
(2, 'Fijo', 'Vigilante', 'vigias Colombia', 3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuarios`
--

CREATE TABLE `tbl_usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `contrasena` varchar(15) DEFAULT NULL,
  `nombre` varchar(35) DEFAULT NULL,
  `cedula` int(11) DEFAULT NULL,
  `celular` bigint(20) DEFAULT NULL,
  `fkid_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_usuarios`
--

INSERT INTO `tbl_usuarios` (`id`, `usuario`, `contrasena`, `nombre`, `cedula`, `celular`, `fkid_rol`) VALUES
(1, 'albaamaya@gmail.com', '@lb4m!3af', 'Alba Amaya', 11345687, 3104521302, 1),
(2, 'bentedder@gmail.com', 't3de4a!f', 'Benjamin Tedder', 1012354687, 3111036584, 3),
(3, 'samuelliza@gmail.com', '5am6e!*l', 'Samuel Lizarralde', 1015411032, 3123504550, 2),
(4, 'pablodelgado@gmail.com', 'P@bl0d3e', 'Pablo Delgado', 1013451320, 3103126548, 2),
(5, 'laural@gmail.com', 'l4ural@L', 'Laura Alvarez', 1012465879, 3111254680, 2),
(6, 'rafablas@gmail.com', 'R4f@blas', 'Rafael Blas', 1014548987, 3133256874, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_visitantes`
--

CREATE TABLE `tbl_visitantes` (
  `id` int(11) NOT NULL,
  `nom_residente` varchar(35) DEFAULT NULL,
  `car_visitante` varchar(2) DEFAULT NULL,
  `ingr_visitante` varchar(2) DEFAULT NULL,
  `fec_visitante` datetime(6) DEFAULT NULL,
  `fkid_parqueadero` int(11) DEFAULT NULL,
  `fkid_inmueble` int(11) DEFAULT NULL,
  `fkid_user` int(11) DEFAULT NULL,
  `fkid_trabajador` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  ADD KEY `FK4tcet6lof1y7vu5qismynlmws` (`fkid_rol`),
  ADD KEY `FKm4k2fg1yo8aju23aplwbteoit` (`fkid_user`);

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
  ADD KEY `FKt1lrnp3fumykv007ohxu3hrql` (`fkid_rol`),
  ADD KEY `FKdvwdpxyj8xkor1jucj9fab65n` (`fkid_user`);

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
  ADD KEY `FKpqdtnjppvfi32ggmdhh3bb9kd` (`fkid_user`),
  ADD KEY `FK84s7bxw8llyx2if0jj8kddxp5` (`fkid_trabajador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_correspondencia`
--
ALTER TABLE `tbl_correspondencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_estcartera`
--
ALTER TABLE `tbl_estcartera`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_inmueble`
--
ALTER TABLE `tbl_inmueble`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_multa`
--
ALTER TABLE `tbl_multa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_novedades`
--
ALTER TABLE `tbl_novedades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_parqueadero`
--
ALTER TABLE `tbl_parqueadero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_residente`
--
ALTER TABLE `tbl_residente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbl_rol`
--
ALTER TABLE `tbl_rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tbl_trabajador`
--
ALTER TABLE `tbl_trabajador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tbl_visitantes`
--
ALTER TABLE `tbl_visitantes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `FK8w3gesmftw8g8cug3qn74jxqk` FOREIGN KEY (`fkid_parqueadero`) REFERENCES `tbl_parqueadero` (`id`),
  ADD CONSTRAINT `FKm4k2fg1yo8aju23aplwbteoit` FOREIGN KEY (`fkid_user`) REFERENCES `tbl_usuarios` (`id`);

--
-- Filtros para la tabla `tbl_trabajador`
--
ALTER TABLE `tbl_trabajador`
  ADD CONSTRAINT `FKdvwdpxyj8xkor1jucj9fab65n` FOREIGN KEY (`fkid_user`) REFERENCES `tbl_usuarios` (`id`),
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
  ADD CONSTRAINT `FKpqdtnjppvfi32ggmdhh3bb9kd` FOREIGN KEY (`fkid_user`) REFERENCES `tbl_usuarios` (`id`),
  ADD CONSTRAINT `FKsim7hyw3kbcv4y92jfq73g5r3` FOREIGN KEY (`fkid_parqueadero`) REFERENCES `tbl_parqueadero` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
