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
-- Base de données : `service_client`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `id` bigint(20) NOT NULL,
  `codepostale` bigint(20) DEFAULT NULL,
  `delegation` varchar(255) DEFAULT NULL,
  `gouvernorat` varchar(255) DEFAULT NULL,
  `localite` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `adresse`
--

INSERT INTO `adresse` (`id`, `codepostale`, `delegation`, `gouvernorat`, `localite`) VALUES
(1, 3000, 'Sfax', 'Tunisie', 'Centre ville'),
(2, 3042, 'Sfax', 'Tunisie', 'Route ain km 7.5'),
(3, 4000, 'Tunis', 'Tunisie', 'Marsa'),
(4, 75000, 'Paris', 'France', 'Arrondissement 1'),
(5, 5001, 'Monsatir', 'Tunise', 'Immeuble 13'),
(6, 3000, 'Sfax', 'Tunisie', 'Centre ville'),
(7, 3001, 'Sfax', 'Tunisie', 'Route Afrane'),
(8, 2001, 'Mahdia', 'Tunisie', 'immeuble 1'),
(9, NULL, NULL, 'Tunsie', NULL),
(10, NULL, 'Sfax', 'Tunise', NULL),
(11, NULL, 'Sfax', '', 'Route Ain'),
(12, 0, '', '', ''),
(13, 0, '', '', ''),
(14, NULL, NULL, 'France', NULL),
(15, NULL, 'Bizerte', 'Tunisie', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `dateopen` date DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `datebirth` date DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `adresse_id` bigint(20) DEFAULT NULL,
  `customer_category_id` bigint(20) DEFAULT NULL,
  `todocustomer_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `customer`
--

INSERT INTO `customer` (`id`, `dateopen`, `mail`, `name`, `datebirth`, `phone`, `adresse_id`, `customer_category_id`, `todocustomer_id`) VALUES
(1, '2019-01-13', 'amin@yahoo.fr', 'Amine Abid', '1994-01-01', '22000111', 1, 1, 1),
(2, '2020-01-13', 'med@yahoo.fr', 'Mohamed Borchani', '1985-01-22', '22661936', 2, 1, 2),
(3, '2021-01-13', 'afef@yahoo.fr', 'Afef feki', '1987-11-10', '44009900', 3, 1, 3),
(4, '2022-01-13', 'malek@gmail.com', 'Malek Chakroun', '2000-11-09', '71000999', 4, 1, 4),
(5, '2019-01-13', 'islem@yahoo.fr', 'Islem Mestiri', '1999-01-02', '31000999', 5, 1, 5),
(6, '2021-01-13', '3Sbureuatique@gmail.com', '3S Bureautique', NULL, '71000222', 6, 2, 6),
(7, '2020-01-13', 'sfaxpc@gmail.com', 'Sfax PC', NULL, '74000222', 7, 2, 7),
(8, '2023-01-13', 'imed@yahoo.fr', 'Imed Baklouti', '2001-01-01', '21999000', 8, 1, 8),
(9, '2023-01-13', 'ilhem@yahoo.fr', 'Ilhem Omri', '2001-12-26', '23556677', 9, 1, 9),
(10, '2023-01-13', 'yousri@yahoo.fr', 'Yousri Aroussi', '1980-09-22', '41444666', 10, 1, 10),
(11, '2023-01-13', 'fahmi@yahoo.fr', 'Fahmi gargouri', '1970-02-01', '44111000', 11, 1, 11),
(15, '2023-01-13', 'ana@yahoo.fr', 'Anas Kadri', '1990-01-22', '20071889', 14, 1, 14),
(16, '2023-01-13', 'ahmed@yahoo.fr', 'Ahmed Chakroun', '1966-01-09', '99008800', 15, 1, 15);

-- --------------------------------------------------------

--
-- Structure de la table `customercategory`
--

CREATE TABLE `customercategory` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `customercategory`
--

INSERT INTO `customercategory` (`id`, `name`) VALUES
(1, 'Particulier'),
(2, 'Entreprise');

-- --------------------------------------------------------

--
-- Structure de la table `todocustomer`
--

CREATE TABLE `todocustomer` (
  `id` bigint(20) NOT NULL,
  `actiontodo` varchar(255) DEFAULT NULL,
  `dateofaction` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `todocustomer`
--

INSERT INTO `todocustomer` (`id`, `actiontodo`, `dateofaction`) VALUES
(1, '', '2023-01-13'),
(2, 'Envoyer Liste des prix', '2023-01-13'),
(3, '', '2023-01-13'),
(4, 'Envoyer catalogue promotion', '2023-01-13'),
(5, 'Envoyer facture par mail', '2023-01-13'),
(6, NULL, '2023-01-13'),
(7, 'Envoyer 10 catalogues ', '2023-01-13'),
(8, 'Envoyer catalogue promotion', '2023-01-13'),
(9, NULL, '2023-01-13'),
(10, NULL, '2023-01-13'),
(11, NULL, '2023-01-13'),
(12, NULL, NULL),
(13, NULL, NULL),
(14, NULL, '2023-01-13'),
(15, NULL, '2023-01-13');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4og38o9ldycluf0cx6gis8rke` (`adresse_id`),
  ADD KEY `FKkshqjy7ypf6e3guy9ifanxwyg` (`customer_category_id`),
  ADD KEY `FKl1pouavvepqy44qyogqpwx3k2` (`todocustomer_id`);

--
-- Index pour la table `customercategory`
--
ALTER TABLE `customercategory`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `todocustomer`
--
ALTER TABLE `todocustomer`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `customercategory`
--
ALTER TABLE `customercategory`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `todocustomer`
--
ALTER TABLE `todocustomer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FK4og38o9ldycluf0cx6gis8rke` FOREIGN KEY (`adresse_id`) REFERENCES `adresse` (`id`),
  ADD CONSTRAINT `FKkshqjy7ypf6e3guy9ifanxwyg` FOREIGN KEY (`customer_category_id`) REFERENCES `customercategory` (`id`),
  ADD CONSTRAINT `FKl1pouavvepqy44qyogqpwx3k2` FOREIGN KEY (`todocustomer_id`) REFERENCES `todocustomer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
