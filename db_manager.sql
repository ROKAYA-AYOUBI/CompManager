-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 17 mars 2020 à 14:36
-- Version du serveur :  10.3.16-MariaDB
-- Version de PHP :  7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `db_manager`
--

-- --------------------------------------------------------

--
-- Structure de la table `activite`
--

CREATE TABLE `activite` (
  `id` int(11) NOT NULL,
  `Type_Activite` varchar(30) NOT NULL,
  `Nom_Activite` varchar(30) NOT NULL,
  `Outils` varchar(50) NOT NULL,
  `Nombre_Participants` int(30) NOT NULL,
  `Objectif` varchar(30) NOT NULL,
  `Description` varchar(90) NOT NULL,
  `Categorie_Cible` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `activite`
--

INSERT INTO `activite` (`id`, `Type_Activite`, `Nom_Activite`, `Outils`, `Nombre_Participants`, `Objectif`, `Description`, `Categorie_Cible`) VALUES
(1, 'test', 'test', 'test', 8, 'test', 'tes', 'test');

-- --------------------------------------------------------

--
-- Structure de la table `benificier`
--

CREATE TABLE `benificier` (
  `id` int(11) NOT NULL,
  `Nom` varchar(90) NOT NULL,
  `Prenom` varchar(90) NOT NULL,
  `Date_Naissance` date NOT NULL,
  `Email` varchar(90) NOT NULL,
  `Tuteur_Nom_Complet` varchar(90) NOT NULL,
  `CIN` varchar(90) NOT NULL,
  `Addresse` varchar(90) NOT NULL,
  `Moniteur` varchar(90) NOT NULL,
  `Numero_Tel` int(90) NOT NULL,
  `Profession` varchar(90) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `benificier`
--

INSERT INTO `benificier` (`id`, `Nom`, `Prenom`, `Date_Naissance`, `Email`, `Tuteur_Nom_Complet`, `CIN`, `Addresse`, `Moniteur`, `Numero_Tel`, `Profession`) VALUES
(1, 'amorani', 'laila', '1990-02-22', 'amina@outlokk.fr', 'rokia ayoubi', 'AC1548,AC1548', 'test 022aeiuhudezaih iuzad', 'testdirecteur', 2554885, 'test');

-- --------------------------------------------------------

--
-- Structure de la table `fiche_medicale`
--

CREATE TABLE `fiche_medicale` (
  `id` int(11) NOT NULL,
  `cas` varchar(30) NOT NULL,
  `Nom_Respensable_Medicale` varchar(50) NOT NULL,
  `Nom_benificier` varchar(50) NOT NULL,
  `Prenom_benificier` varchar(50) NOT NULL,
  `Moniteur` varchar(50) NOT NULL,
  `Equipe` varchar(50) NOT NULL,
  `Decription` varchar(50) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `fiche_medicale`
--

INSERT INTO `fiche_medicale` (`id`, `cas`, `Nom_Respensable_Medicale`, `Nom_benificier`, `Prenom_benificier`, `Moniteur`, `Equipe`, `Decription`, `date`) VALUES
(1, 'n', 'test', 'test', 'test', 'testdirecteur', 'test@uh.fr', 'tes', '2020-03-16 10:48:21'),
(2, 'n', 'test222', 'test222', 'feztzehui', 'uhihi', 'hihu', 'gig', '2020-03-16 10:55:09'),
(3, 'n', 'hefiug', 'uuyfy', 'ytftyfty', 'guygyyu', 'guygyu', 'ygytgf', '2020-03-16 11:02:34');

-- --------------------------------------------------------

--
-- Structure de la table `group`
--

CREATE TABLE `group` (
  `id` int(11) NOT NULL,
  `benifier_id` int(11) NOT NULL,
  `moniteur_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `moniteur`
--

CREATE TABLE `moniteur` (
  `id` int(11) NOT NULL,
  `CIN` varchar(50) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Diplome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `Numero_Tel` int(50) NOT NULL,
  `tache` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `moniteur`
--

INSERT INTO `moniteur` (`id`, `CIN`, `Nom`, `Prenom`, `Diplome`, `email`, `Numero_Tel`, `tache`) VALUES
(2, 'AC1548', 'amina', 'cherka', 'monitrice', 'amina@outlokk.fr', 2554885, 'TEST');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id` int(11) NOT NULL,
  `Nom` varchar(90) NOT NULL,
  `Prenom` varchar(90) NOT NULL,
  `Diplome` varchar(90) NOT NULL,
  `email` varchar(90) NOT NULL,
  `Numero_Tel` int(90) NOT NULL,
  `tache` varchar(90) NOT NULL,
  `CIN` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `Nom`, `Prenom`, `Diplome`, `email`, `Numero_Tel`, `tache`, `CIN`) VALUES
(4, 'Baminauhiu', 'DJEI', 'monitrice', 'emailtest@uyu.cf', 2554885, 'FUOSHQU', 'AC15'),
(5, 'test1', 'test', 'test', 'uhiu@uyu.cf', 2554885, 'jkkq', 'vb512'),
(6, 'JAKLINE', 'iuezyh', 'uihyiu', 'iuhi@zjef.frh', 555855855, 'fjzeiuh', 'FD875'),
(7, 'amina', 'cherka', 'monitrice', 'amina@outlokk.fr', 2554885, 'moniteur', 'OKI8855'),
(8, 'lmnsori', 'IUHIU', 'MASTER', 'laila@outlokk.fr', 2554885, 'FUOSHQU', 'DR875');

-- --------------------------------------------------------

--
-- Structure de la table `programme_alimentaire`
--

CREATE TABLE `programme_alimentaire` (
  `id` int(11) NOT NULL,
  `Nom_Respensable` varchar(90) NOT NULL,
  `date` timestamp(5) NOT NULL DEFAULT current_timestamp(5),
  `Jour` int(50) NOT NULL,
  `Petit_Dejeuner` varchar(90) NOT NULL,
  `Dejeuner` varchar(90) NOT NULL,
  `Collation` varchar(90) NOT NULL,
  `Diner` varchar(90) NOT NULL,
  `Facture` varchar(90) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `programme_alimentaire`
--

INSERT INTO `programme_alimentaire` (`id`, `Nom_Respensable`, `date`, `Jour`, `Petit_Dejeuner`, `Dejeuner`, `Collation`, `Diner`, `Facture`) VALUES
(1, 'test', '2020-03-16 15:58:13.28364', 1, 'test', 'test', 'test', 'test', 'corr  lm.docx'),
(2, 'EZUIHYFIUZ', '2020-03-16 15:10:38.47573', 5, 'JUHIEZ', 'IUHUYG', 'GUYG', 'UGUYGU', 'Screenshot_2020-02-15-11-12-11.png');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `activite`
--
ALTER TABLE `activite`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `benificier`
--
ALTER TABLE `benificier`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `fiche_medicale`
--
ALTER TABLE `fiche_medicale`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `group`
--
ALTER TABLE `group`
  ADD PRIMARY KEY (`id`),
  ADD KEY `benifier_id` (`benifier_id`),
  ADD KEY `moniteur_id` (`moniteur_id`),
  ADD KEY `benifier_id_2` (`benifier_id`);

--
-- Index pour la table `moniteur`
--
ALTER TABLE `moniteur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `programme_alimentaire`
--
ALTER TABLE `programme_alimentaire`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `activite`
--
ALTER TABLE `activite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `benificier`
--
ALTER TABLE `benificier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `fiche_medicale`
--
ALTER TABLE `fiche_medicale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `group`
--
ALTER TABLE `group`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `moniteur`
--
ALTER TABLE `moniteur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `programme_alimentaire`
--
ALTER TABLE `programme_alimentaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
