-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 13 jan. 2023 à 21:55
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `service_facture`
--

-- --------------------------------------------------------

--
-- Structure de la table `invoice`
--

CREATE TABLE `invoice` (
  `id` bigint(20) NOT NULL,
  `amount` double DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `invoice_date` datetime DEFAULT NULL,
  `states` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `invoice`
--

INSERT INTO `invoice` (`id`, `amount`, `customer_id`, `invoice_date`, `states`) VALUES
(1, 4280, 1, '2023-01-13 14:09:55', 'non payée'),
(2, 3510, 1, '2022-01-13 14:10:23', 'non payée'),
(3, 2060, 2, '2020-01-13 14:10:53', 'non payée'),
(4, 9100, 3, '2021-01-13 14:11:16', 'non payée'),
(5, 5510, 3, '2023-01-13 14:11:45', 'non payée'),
(6, 600, 4, '2022-01-13 14:11:58', 'non payée'),
(7, 4100, 4, '2023-01-13 14:12:19', 'non payée'),
(8, 6290, 5, '2021-01-13 14:13:15', 'non payée'),
(9, 3500, 5, '2022-01-13 14:13:30', 'non payée'),
(10, 3500, 5, '2023-01-13 14:13:42', 'non payée'),
(11, 47000, 6, '2020-01-13 14:14:10', 'non payée'),
(12, 7930, 6, '2021-01-13 14:14:27', 'non payée'),
(13, 15950, 6, '2023-01-13 14:15:17', 'non payée'),
(14, 21650, 7, '2020-01-13 14:15:39', 'non payée'),
(15, 25480, 7, '2021-01-13 14:16:24', 'non payée'),
(16, 3500, 7, '2022-01-13 14:20:47', 'non payée'),
(17, 780, 8, '2021-01-13 14:21:08', 'non payée'),
(18, 600, 8, '2023-01-13 14:21:20', 'non payée'),
(19, 5000, 8, '2023-01-13 14:21:34', 'non payée'),
(20, 4280, 9, '2022-01-13 14:21:52', 'non payée'),
(21, 1200, 9, '2023-01-13 14:22:17', 'non payée'),
(22, 3220, 10, '2020-01-13 14:22:40', 'non payée'),
(23, 2010, 10, '2022-01-13 14:23:10', 'non payée'),
(24, 4020, 10, '2023-01-13 14:23:25', 'non payée'),
(25, 28000, 11, '2023-01-13 14:23:47', 'non payée'),
(26, 10620, 11, '2023-01-13 14:24:11', 'non payée'),
(27, 10, 11, '2023-01-13 14:24:22', 'non payée'),
(28, 4290, 15, '2023-01-13 14:27:01', 'non payée'),
(29, 8500, 15, '2023-01-13 14:27:14', 'non payée'),
(30, 4150, 15, '2023-01-13 14:27:34', 'non payée'),
(31, 11940, 16, '2023-01-13 14:28:08', 'non payée'),
(32, 5610, 16, '2023-01-13 14:28:28', 'non payée'),
(33, 5610, 16, '2023-01-13 14:28:47', 'non payée'),
(34, 10, 1, '2023-01-13 15:07:38', 'non payée'),
(35, 3500, 1, '2023-01-13 15:10:42', 'non payée');

-- --------------------------------------------------------

--
-- Structure de la table `invoice_line`
--

CREATE TABLE `invoice_line` (
  `id` bigint(20) NOT NULL,
  `amountinvoiceline` double DEFAULT NULL,
  `qte` int(11) DEFAULT NULL,
  `stock_item_id` bigint(20) DEFAULT NULL,
  `invoice_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `invoice_line`
--

INSERT INTO `invoice_line` (`id`, `amountinvoiceline`, `qte`, `stock_item_id`, `invoice_id`) VALUES
(1, 3500, 1, 1, 1),
(2, 780, 1, 4, 1),
(3, 10, 1, 5, 2),
(4, 3500, 1, 1, 2),
(5, 50, 1, 6, 3),
(6, 2000, 1, 7, 3),
(7, 10, 1, 8, 3),
(8, 3500, 1, 1, 4),
(9, 600, 1, 13, 4),
(10, 5000, 1, 12, 4),
(11, 10, 1, 9, 5),
(12, 3500, 1, 1, 5),
(13, 2000, 1, 7, 5),
(14, 600, 1, 13, 6),
(15, 3500, 1, 1, 7),
(16, 600, 1, 13, 7),
(17, 3500, 1, 1, 8),
(18, 780, 1, 4, 8),
(19, 10, 1, 5, 8),
(20, 2000, 1, 7, 8),
(21, 3500, 1, 1, 9),
(22, 3500, 1, 1, 10),
(23, 35000, 10, 1, 11),
(24, 12000, 20, 13, 11),
(25, 130, 13, 5, 12),
(26, 7800, 13, 13, 12),
(27, 8580, 11, 4, 13),
(28, 110, 11, 5, 13),
(29, 550, 11, 6, 13),
(30, 110, 11, 9, 13),
(31, 6600, 11, 13, 13),
(32, 17500, 5, 1, 14),
(33, 3900, 5, 4, 14),
(34, 250, 5, 6, 14),
(35, 2400, 4, 13, 15),
(36, 15000, 3, 12, 15),
(37, 40, 4, 9, 15),
(38, 8000, 4, 7, 15),
(39, 40, 4, 5, 15),
(40, 3500, 1, 1, 16),
(41, 780, 1, 4, 17),
(42, 600, 1, 13, 18),
(43, 5000, 1, 12, 19),
(44, 780, 1, 4, 20),
(45, 3500, 1, 1, 20),
(46, 1200, 2, 13, 21),
(47, 2000, 1, 7, 22),
(48, 20, 2, 8, 22),
(49, 1200, 2, 13, 22),
(50, 10, 1, 8, 23),
(51, 2000, 1, 7, 23),
(52, 20, 2, 8, 24),
(53, 4000, 2, 7, 24),
(54, 3000, 5, 13, 25),
(55, 25000, 5, 12, 25),
(56, 600, 1, 13, 26),
(57, 10000, 2, 12, 26),
(58, 20, 2, 8, 26),
(59, 10, 1, 8, 27),
(60, 3500, 1, 1, 28),
(61, 780, 1, 4, 28),
(62, 10, 1, 5, 28),
(63, 3500, 1, 1, 29),
(64, 5000, 1, 12, 29),
(65, 600, 1, 13, 30),
(66, 50, 1, 6, 30),
(67, 3500, 1, 1, 30),
(68, 3500, 1, 1, 31),
(69, 780, 1, 4, 31),
(70, 600, 1, 13, 31),
(71, 5000, 1, 12, 31),
(72, 10, 1, 5, 31),
(73, 50, 1, 6, 31),
(74, 2000, 1, 7, 31),
(75, 10, 1, 8, 32),
(76, 600, 1, 13, 32),
(77, 5000, 1, 12, 32),
(78, 10, 1, 8, 33),
(79, 600, 1, 13, 33),
(80, 5000, 1, 12, 33),
(81, 10, 1, 8, 34),
(82, 3500, 1, 1, 35);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `invoice_line`
--
ALTER TABLE `invoice_line`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfnwks1ouvwbttl0fklxsem7ik` (`invoice_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT pour la table `invoice_line`
--
ALTER TABLE `invoice_line`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `invoice_line`
--
ALTER TABLE `invoice_line`
  ADD CONSTRAINT `FKfnwks1ouvwbttl0fklxsem7ik` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
