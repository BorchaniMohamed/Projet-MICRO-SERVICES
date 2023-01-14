-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 13 jan. 2023 à 21:56
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
-- Base de données : `service_produit`
--

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `id` bigint(20) NOT NULL,
  `dateopen` date DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`id`, `dateopen`, `mail`, `name`, `phone`) VALUES
(1, '2019-01-13', 'wiki@yahoo.fr', 'Wiki', 22999111),
(2, '2023-01-13', 'maytech@yahoo.fr', 'Myteck', 33666777),
(3, '2023-01-13', 'bestbuy@gmail.com', 'BestBuy', 55667788),
(4, '2023-01-13', 'media@yahoo.com', 'MediaTech', 44001122);

-- --------------------------------------------------------

--
-- Structure de la table `stockitemcategorie`
--

CREATE TABLE `stockitemcategorie` (
  `id` bigint(20) NOT NULL,
  `nomcategorie` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `stockitemcategorie`
--

INSERT INTO `stockitemcategorie` (`id`, `nomcategorie`) VALUES
(1, 'Desktop'),
(2, 'Laptop'),
(3, 'Smartphone'),
(4, 'Cartouche imprimante'),
(5, 'Souris'),
(6, 'Clavier'),
(7, 'Imprimante');

-- --------------------------------------------------------

--
-- Structure de la table `stock_item`
--

CREATE TABLE `stock_item` (
  `id` bigint(20) NOT NULL,
  `valid_form` date DEFAULT NULL,
  `dateopen` date DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `carateristique` varchar(255) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `qte` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `valid_to` date DEFAULT NULL,
  `categorie_id` bigint(20) DEFAULT NULL,
  `fournisseur_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `stock_item`
--

INSERT INTO `stock_item` (`id`, `valid_form`, `dateopen`, `brand`, `carateristique`, `prix`, `qte`, `name`, `valid_to`, `categorie_id`, `fournisseur_id`) VALUES
(1, '2021-12-26', '2020-01-13', 'Lenovo', 'i7 14pouces 1TO SSD 12 RAM', 3500, 70, 'T450s', NULL, 2, 1),
(4, '2020-12-26', '2023-01-13', 'OPPO', '128G0 6pouces', 780, 78, 'A70', NULL, 3, 2),
(5, '2021-12-26', '2023-01-13', 'LPM', 'Brother J172W  Noir', 10, 68, 'LC123 noir', '2023-02-05', 4, 1),
(6, '2021-12-26', '2023-01-13', 'LPM', 'HP', 50, 81, 'HP 50 cartouche noir', '2023-01-13', 4, 3),
(7, '2021-12-26', '2023-01-13', 'ACER', '1TO 4GO Duel Core', 2000, 88, 'ACER 5600', NULL, 1, 4),
(8, '2022-01-13', '2023-01-13', 'LPM', 'Brother J172W', 10, 88, 'LC123 rouge', '2023-01-13', 4, 1),
(9, '2022-01-06', '2023-01-13', 'LPM', 'Brother J172W', 10, 84, 'LC 123 bleu', '2024-01-06', 4, 1),
(10, '2022-12-26', '2023-01-13', 'LG', 'optique', 15, 100, 'Souris ABC', NULL, 5, 3),
(11, '2022-12-26', '2023-01-13', 'BIgData', 'étanche', 25, 100, 'Clavier rock', NULL, 6, 3),
(12, '2023-01-03', '2023-01-13', 'IPHONE', '128GO', 5000, 84, 'IPHONE 13', NULL, 3, 4),
(13, '2021-12-26', '2023-01-13', 'Brother', 'Jet d\'encre', 600, 134, 'BROTHER J172W', NULL, 7, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `stockitemcategorie`
--
ALTER TABLE `stockitemcategorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `stock_item`
--
ALTER TABLE `stock_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKc573n7ydds079dlmb81krr8r1` (`categorie_id`),
  ADD KEY `FKnpgpxbggn9xg0bsqsq3vt9259` (`fournisseur_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `stockitemcategorie`
--
ALTER TABLE `stockitemcategorie`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `stock_item`
--
ALTER TABLE `stock_item`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `stock_item`
--
ALTER TABLE `stock_item`
  ADD CONSTRAINT `FKc573n7ydds079dlmb81krr8r1` FOREIGN KEY (`categorie_id`) REFERENCES `stockitemcategorie` (`id`),
  ADD CONSTRAINT `FKnpgpxbggn9xg0bsqsq3vt9259` FOREIGN KEY (`fournisseur_id`) REFERENCES `fournisseur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
