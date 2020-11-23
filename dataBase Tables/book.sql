-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 23 nov. 2020 à 19:42
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bookstore`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `title` varchar(20) NOT NULL,
  `price` double NOT NULL,
  `author` varchar(20) NOT NULL,
  `releaseDate` date DEFAULT NULL,
  `path` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`id`, `title`, `price`, `author`, `releaseDate`, `path`) VALUES
(1, 'Le Petit Prince', 50, 'Antoine de Saint-Exu', '2020-11-17', NULL),
(3, '	Les Rougon-Macquart', 50, 'Émile Zola', '2020-11-17', NULL),
(4, 'Le Rouge et le Noir', 50, 'Stendhal', '2020-11-17', NULL),
(5, 'Le Grand Meaulnes', 50, 'Alain-Fournier', '2020-11-17', NULL),
(6, 'Les Trois Mousquetai', 50, 'Alexandre Dumas', '2020-11-17', NULL),
(7, 'Journal d\'Anne Frank', 50, 'Anne Frank', '2020-11-17', NULL),
(8, 'La nuit des temps', 50, 'René Barjavel', '2020-11-17', NULL),
(9, 'Ils étaient dix', 50, 'Agatha Christie', '2020-11-17', NULL),
(10, 'Sans famille', 50, 'Hector Malot', NULL, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
