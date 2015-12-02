-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: moviesoffline
-- ------------------------------------------------------
-- Server version	5.6.25-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `movie_id` varchar(10) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `age_rating` int(11) DEFAULT NULL,
  `releaseDate` date DEFAULT NULL,
  `storyline` longtext,
  PRIMARY KEY (`movie_id`),
  KEY `genre_id_idx` (`genre_id`),
  KEY `age_rating_idx` (`age_rating`),
  CONSTRAINT `age_rating` FOREIGN KEY (`age_rating`) REFERENCES `movie_rating` (`mv_rating_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `genre_id` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`genre_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES ('tt1001','King Kong',2,2,'2015-11-06','During the Great Depression in New York city Vaudeville actress Ann Darrow has lost her job but is hired by filmmaker Carl Denham to be in his new movie.'),('tt1002','Olympus Has Fallen',2,2,'2015-11-01','A high stakes action thriller that plays out on the political stage, Olympus Has Fallen is a film about the President of the United States being taken hostage, and only one man being able to step up and save him as well as the country from being completely doomed. '),('tt1003','Resident Evil',3,2,'2015-11-03','This film is one example of the successful adaptation of a video game series into a movie. The zombie and undead genre seems to have become ever more popular as time goes on, lending itself to video games, movies and even television.'),('tt1004','Warrior',3,2,'2011-11-11','Warrior is a movie that revolves around two estranged brothers, Tommy and Brendon, whom are on a collision course in a winner takes all mixed-martial arts tournament called Sparta.'),('tt1005','Hunt to Kill',13,5,'2015-12-01','13 Assassins is a movie that takes place during the eighteen-forties. Japan was going through a time of peace. This was during the final years of the samurai. Lord Matsudaira Naritsugu is the younger brother of the current Shogun.'),('tt1006','Axe Giant: The Wrath Of Paul Bunyan',13,5,'2015-12-01','Axe Giant is a teens-meet-monster, slasher-type horror film, centered around a murderous local legend. The cast is introduced as a group of at-risk teens, an overbearing drill sergeant, and a counter-balancing, caring social worker out on an excursion into the woods.'),('tt1007','Crouching Tiger, Hidden Dragon',17,1,'2015-12-01','Long ago in the beginning of the 19th Century, Li Mu Bai is about to retire. Even though he is ready to live the rest of his life in meditation, he can\'t help but think of Jade Fox, the warrior that killed his master. '),('tt1008',' Fifty Shades of Grey',1,5,'2015-12-01','Ends 12/20/15. The sizzling bestseller from E.L. James is brought to exhilarating life! Dakota Johnson stars as timid college girl Anastasia Steele whose interview of wealthy Seattle businessman Christian Grey (Jamie Dornan) soon turns into a powerful and very kinky physical conn...'),('tt1009','Dr. Seuss\' How the Grinch Stole',5,1,'2015-12-01','Lavish live-action version of the classic tale, starring Jim Carrey---in Oscar-winning makeup---as the coldhearted creature trying to thwart Whoville\'s Yuletide celebration.');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-01 16:56:03
