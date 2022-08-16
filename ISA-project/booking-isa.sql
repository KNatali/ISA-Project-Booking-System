-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: booking-isa
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `additional_item`
--

use heroku_5efb7e358f1f4f3;

DROP TABLE IF EXISTS `additional_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `additional_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additional_item`
--

LOCK TABLES `additional_item` WRITE;
/*!40000 ALTER TABLE `additional_item` DISABLE KEYS */;
INSERT INTO `additional_item` VALUES (1,'Fishing License',20),(2,'Live Bait',5),(3,'Fridge',5),(4,'Kitchen',10),(5,'fishfinder',15),(6,'Rend a car',15),(7,'Spa',5),(8,'Wi-fi',5);
/*!40000 ALTER TABLE `additional_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Panama City',30.16753,-85.70388,'United States','3151 West 10th Street'),(2,'Key West',24.56155,-81.80015,'United States',' 201 Margaret Street'),(3,'Key West',24.56392,-81.72815,'United States',' 5950 Peninsular Avenue'),(4,'Key West',24.56567,-81.77288,'United States','  North Roosevelt Boulevard'),(5,'Destin',30.3934711,-86.5068368,'United States',' 210 Harbor Boulevard'),(6,'Destin',30.392942,-86.5063408,'United States',' 214 Harbor Boulevard'),(7,'St. Petersburg',27.805171,-82.6278321,'United States',' 3600 Poplar Street Northeast'),(8,'St. Petersburg',27.8141447,-82.7718856,'United States',' 9600 Bay Pines Boulevard'),(9,'Miami',25.7269537,-80.2354768,'United States',' 3400 Pan American Dr,'),(10,'Miami',25.7269537,-80.2354768,'United States','Northwest 7th Street Road 945'),(11,'San Diego',32.7251557,-117.1917584,'United States',' 955 Harbor Island Drive'),(12,'San Diego',32.7234718,-117.227589,'United States','Emerson Street 2803');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `first_login` bit(1) DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK1ja8rua032fgnk9jmq7du3b3a` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (_binary '\0',10);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure`
--

DROP TABLE IF EXISTS `adventure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `average_grade` double DEFAULT NULL,
  `cancellation_percentage` int DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` longtext,
  `main_picture` varchar(255) DEFAULT NULL,
  `max_persons` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `instructor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkw7qhm14pdauo5ee7w96a2e0y` (`address_id`),
  KEY `FK97ewe4levuvnmwbe4uslrabpq` (`instructor_id`),
  CONSTRAINT `FK97ewe4levuvnmwbe4uslrabpq` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`),
  CONSTRAINT `FKkw7qhm14pdauo5ee7w96a2e0y` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure`
--

LOCK TABLES `adventure` WRITE;
/*!40000 ALTER TABLE `adventure` DISABLE KEYS */;
INSERT INTO `adventure` VALUES (1,5,0,_binary '\0','Lucky B Sportfishing welcomes you to one of the most beautiful fisheries in the world. This charter service is operated by a professional crew that always strives to exceed their guests’ expectations. No matter what time of year you join, you can always count on a great water experience.The adventure starts on a 36’ Yellowfin boat . The boat features all necessary safety gear, modern navigational electronics, a live bait tank, and a cooler.You can fish the inshore waters of Coronado Islands or visit offshore spots for big game fish. Some of the species you’ll target on your trip are Calico Bass, Halibut, Lingcod, Tuna, Swordfish, Mahi Mahi, and many more. With such a variety of fish species and fishing techniques, it never gets boring or repetitive on board.The only thing you need to prepare in advance is your fishing license. The crew takes care of everything else - your fishing equipment, catch cleaning, snacks, and drinks.The main goal for the Lucky B Sportfishing’s crew is for you to have a memorable and enjoyable experience. They look forward to seeing you on their boat!','/assets/adventure/Adventure1.jpg',10,'Lucky B Sportfishing',100,1,1),(2,9,10,_binary '\0','No matter what kind of fishing trip you’re looking for, The Long Run is at your disposal. She’s a 40’ Hershine boat that’s got plenty of room for up to 6 anglers to be fishing in comfort. This is a spacious vessel with a pair of private heads, an outfitted kitchen, an air-conditioned cabin, and more.On shorter trips, you can expect to target Barracuda, Dorado, Yellowtail or bottom fish such as Lingcod, Sand Bass, Rockfish, and Halibut. Overnight trips will take you out for Yellowfin, Bluefin and Albacore Tuna, Dorado, Yellowtail, Marlin, and more. During shorter trips, you can also leave some lobster hoops in pristine locations when the season is open.All the fishing equipment, including bait, is provided for your convenience – all you need to do is get that daily license and some food and beverages and start bagging fish! For maximum comfort, bring a pair of polarized sunglasses and get ready to have some fun.','/assets/adventure/Adventure2.jpg',7,'The Long Run Sportfishing',80,2,1),(3,7,15,_binary '\0','Head out to some of the richest waters of the mighty Atlantic as you search for some trophy specimens. There’s a whole host of fish species inhabiting these waters, and some of them that you can expect to target are Snapper, Scup, Grouper, King Mackerel, Cobia, Sailfish, and Mahi Mahi.You’ll be fishing using Shimano rods, reels, and tackle, and Capt. Tyler will be happy to clean and fillet your catch for you to take home for a nice dinner. Feel free to bring your kids along, but note that you should bring life jackets for them. From viewing various marine life like turtles and dolphins to catching the fish of a lifetime, this is an adventure you won’t forget!Make sure to bring some food and drinks, especially on longer trips to stay refreshed throughout the day,Join Reel Floridian Fishing and let Capt. Tyler show you a great time, fishing under the Floridian sun!','/assets/adventure/Adventure3.jpg',5,'Reel Floridian Fishing',250,10,1),(4,0,15,_binary '\0','Head out to some of the richest waters of the mighty Atlantic as you search for some trophy specimens. There’s a whole host of fish species inhabiting these waters, and some of them that you can expect to target are Snapper, Scup, Grouper, King Mackerel, Cobia, Sailfish, and Mahi Mahi.You’ll be fishing using Shimano rods, reels, and tackle, and Capt. Tyler will be happy to clean and fillet your catch for you to take home for a nice dinner. Feel free to bring your kids along, but note that you should bring life jackets for them. From viewing various marine life like turtles and dolphins to catching the fish of a lifetime, this is an adventure you won’t forget!Make sure to bring some food and drinks, especially on longer trips to stay refreshed throughout the day,Join Reel Floridian Fishing and let Capt. Tyler show you a great time, fishing under the Floridian sun!','/assets/adventure/Adventure5.jpg',5,'Fishing river',250,1,2),(5,0,20,_binary '\0','Head out to some of the richest waters of the mighty Atlantic as you search for some trophy specimens. There’s a whole host of fish species inhabiting these waters, and some of them that you can expect to target are Snapper, Scup, Grouper, King Mackerel, Cobia, Sailfish, and Mahi Mahi.You’ll be fishing using Shimano rods, reels, and tackle, and Capt. Tyler will be happy to clean and fillet your catch for you to take home for a nice dinner. Feel free to bring your kids along, but note that you should bring life jackets for them. From viewing various marine life like turtles and dolphins to catching the fish of a lifetime, this is an adventure you won’t forget!Make sure to bring some food and drinks, especially on longer trips to stay refreshed throughout the day,Join Reel Floridian Fishing and let Capt. Tyler show you a great time, fishing under the Floridian sun!','/assets/adventure/Adventure4.jpg',8,'Super star fishing',415,5,1);
/*!40000 ALTER TABLE `adventure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_additional_items`
--

DROP TABLE IF EXISTS `adventure_additional_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_additional_items` (
  `adventure_id` bigint NOT NULL,
  `additional_item_id` bigint NOT NULL,
  PRIMARY KEY (`adventure_id`,`additional_item_id`),
  KEY `FK9up15n9n1ikrwd8ahjgnvldvm` (`additional_item_id`),
  CONSTRAINT `FK23x38jv3ck67ik48q9au2bdyi` FOREIGN KEY (`adventure_id`) REFERENCES `adventure` (`id`),
  CONSTRAINT `FK9up15n9n1ikrwd8ahjgnvldvm` FOREIGN KEY (`additional_item_id`) REFERENCES `additional_item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_additional_items`
--

LOCK TABLES `adventure_additional_items` WRITE;
/*!40000 ALTER TABLE `adventure_additional_items` DISABLE KEYS */;
INSERT INTO `adventure_additional_items` VALUES (1,1),(3,1),(1,2),(2,2),(1,3),(2,4);
/*!40000 ALTER TABLE `adventure_additional_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_behavioral_rule`
--

DROP TABLE IF EXISTS `adventure_behavioral_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_behavioral_rule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_behavioral_rule`
--

LOCK TABLES `adventure_behavioral_rule` WRITE;
/*!40000 ALTER TABLE `adventure_behavioral_rule` DISABLE KEYS */;
INSERT INTO `adventure_behavioral_rule` VALUES (1,'Child Friendly'),(2,'Forbidden for childer under 5 yo'),(3,'Just bring good energy'),(4,'You Keep Catch'),(5,'Catch and Release Allowed');
/*!40000 ALTER TABLE `adventure_behavioral_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_complaint`
--

DROP TABLE IF EXISTS `adventure_complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_complaint` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `adventure_id` bigint DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK48md7wafjxwu64ns2pkjhii39` (`adventure_id`),
  KEY `FK46wuecejg7xtccs8kcm2ythcc` (`client_id`),
  CONSTRAINT `FK46wuecejg7xtccs8kcm2ythcc` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FK48md7wafjxwu64ns2pkjhii39` FOREIGN KEY (`adventure_id`) REFERENCES `adventure` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_complaint`
--

LOCK TABLES `adventure_complaint` WRITE;
/*!40000 ALTER TABLE `adventure_complaint` DISABLE KEYS */;
INSERT INTO `adventure_complaint` VALUES (1,'Instructor was very unpolite and rude!','Default',1,5),(2,'Service is too expensive. Nothing is like on pictures','Default',1,8);
/*!40000 ALTER TABLE `adventure_complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_completed_reservation_report`
--

DROP TABLE IF EXISTS `adventure_completed_reservation_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_completed_reservation_report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `admin_check` bit(1) DEFAULT NULL,
  `get_penal` bit(1) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `adventure_id` bigint DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlt0lkiv3okvng9lp3xldt0uw5` (`adventure_id`),
  KEY `FKjr5ctye61codygfdm1mt3v4hn` (`client_id`),
  CONSTRAINT `FKjr5ctye61codygfdm1mt3v4hn` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKlt0lkiv3okvng9lp3xldt0uw5` FOREIGN KEY (`adventure_id`) REFERENCES `adventure` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_completed_reservation_report`
--

LOCK TABLES `adventure_completed_reservation_report` WRITE;
/*!40000 ALTER TABLE `adventure_completed_reservation_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `adventure_completed_reservation_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_equipment`
--

DROP TABLE IF EXISTS `adventure_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_equipment` (
  `adventure_id` bigint NOT NULL,
  `equipment_id` bigint NOT NULL,
  PRIMARY KEY (`adventure_id`,`equipment_id`),
  KEY `FK3xdo53cfsvh0ltwqwglb2hrxn` (`equipment_id`),
  CONSTRAINT `FK3xdo53cfsvh0ltwqwglb2hrxn` FOREIGN KEY (`equipment_id`) REFERENCES `adventure_fishing_equipment` (`id`),
  CONSTRAINT `FKdx9qdrdti6guxhpp1jjl332hk` FOREIGN KEY (`adventure_id`) REFERENCES `adventure` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_equipment`
--

LOCK TABLES `adventure_equipment` WRITE;
/*!40000 ALTER TABLE `adventure_equipment` DISABLE KEYS */;
INSERT INTO `adventure_equipment` VALUES (1,1),(2,1),(1,2),(1,4);
/*!40000 ALTER TABLE `adventure_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_fast_reservation`
--

DROP TABLE IF EXISTS `adventure_fast_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_fast_reservation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `max_persons` int NOT NULL,
  `price` double NOT NULL,
  `reservation_end` datetime(6) NOT NULL,
  `reservation_start` datetime(6) NOT NULL,
  `validity_end` date DEFAULT NULL,
  `validity_start` date DEFAULT NULL,
  `adventure_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm5djdb0rrirpr6jhywf0dpe8g` (`adventure_id`),
  CONSTRAINT `FKm5djdb0rrirpr6jhywf0dpe8g` FOREIGN KEY (`adventure_id`) REFERENCES `adventure` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_fast_reservation`
--

LOCK TABLES `adventure_fast_reservation` WRITE;
/*!40000 ALTER TABLE `adventure_fast_reservation` DISABLE KEYS */;
INSERT INTO `adventure_fast_reservation` VALUES (1,4,460,'2022-10-15 16:00:00.000000','2022-07-20 13:00:00.000000','2022-08-10','2022-05-15',1),(2,2,100,'2022-09-25 15:00:00.000000','2022-08-01 07:00:00.000000','2022-08-15','2022-05-10',1),(3,2,200,'2022-09-10 00:42:00.000000','2022-08-31 00:42:00.000000','2022-08-24','2022-08-19',1);
/*!40000 ALTER TABLE `adventure_fast_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_fast_reservation_additional_items`
--

DROP TABLE IF EXISTS `adventure_fast_reservation_additional_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_fast_reservation_additional_items` (
  `adventure_fast_reservation_id` bigint NOT NULL,
  `additional_item_id` bigint NOT NULL,
  PRIMARY KEY (`adventure_fast_reservation_id`,`additional_item_id`),
  KEY `FK1xoyel4pd4w3ghgafouf3vrx7` (`additional_item_id`),
  CONSTRAINT `FK1xoyel4pd4w3ghgafouf3vrx7` FOREIGN KEY (`additional_item_id`) REFERENCES `additional_item` (`id`),
  CONSTRAINT `FKdqa4fcjm493r6d8o0ioxd49kp` FOREIGN KEY (`adventure_fast_reservation_id`) REFERENCES `adventure_fast_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_fast_reservation_additional_items`
--

LOCK TABLES `adventure_fast_reservation_additional_items` WRITE;
/*!40000 ALTER TABLE `adventure_fast_reservation_additional_items` DISABLE KEYS */;
INSERT INTO `adventure_fast_reservation_additional_items` VALUES (3,1),(3,2),(3,3);
/*!40000 ALTER TABLE `adventure_fast_reservation_additional_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_fishing_equipment`
--

DROP TABLE IF EXISTS `adventure_fishing_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_fishing_equipment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_fishing_equipment`
--

LOCK TABLES `adventure_fishing_equipment` WRITE;
/*!40000 ALTER TABLE `adventure_fishing_equipment` DISABLE KEYS */;
INSERT INTO `adventure_fishing_equipment` VALUES (1,'cumberland'),(2,'soft baits'),(3,'frogs'),(4,'fishing rods');
/*!40000 ALTER TABLE `adventure_fishing_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_pictures`
--

DROP TABLE IF EXISTS `adventure_pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_pictures` (
  `adventure_id` bigint NOT NULL,
  `picture_id` bigint NOT NULL,
  PRIMARY KEY (`adventure_id`,`picture_id`),
  KEY `FKhr4ie4tjf67loctealnkig2s9` (`picture_id`),
  CONSTRAINT `FKhr4ie4tjf67loctealnkig2s9` FOREIGN KEY (`picture_id`) REFERENCES `picture` (`id`),
  CONSTRAINT `FKkpc5o4ypn7gy64fp72dkjsdgi` FOREIGN KEY (`adventure_id`) REFERENCES `adventure` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_pictures`
--

LOCK TABLES `adventure_pictures` WRITE;
/*!40000 ALTER TABLE `adventure_pictures` DISABLE KEYS */;
/*!40000 ALTER TABLE `adventure_pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_price_list`
--

DROP TABLE IF EXISTS `adventure_price_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_price_list` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_price_list`
--

LOCK TABLES `adventure_price_list` WRITE;
/*!40000 ALTER TABLE `adventure_price_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `adventure_price_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_price_list_additional_items`
--

DROP TABLE IF EXISTS `adventure_price_list_additional_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_price_list_additional_items` (
  `adventure_price_list_id` bigint NOT NULL,
  `additional_items_id` bigint NOT NULL,
  PRIMARY KEY (`adventure_price_list_id`,`additional_items_id`),
  UNIQUE KEY `UK_l82krw9xvccrl05cphuxy3ayf` (`additional_items_id`),
  CONSTRAINT `FK7ave9qdvgp51u6k3v3jj847ld` FOREIGN KEY (`additional_items_id`) REFERENCES `additional_item` (`id`),
  CONSTRAINT `FKnv6t0yt4un4j1d9kkwcy6r49n` FOREIGN KEY (`adventure_price_list_id`) REFERENCES `adventure_price_list` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_price_list_additional_items`
--

LOCK TABLES `adventure_price_list_additional_items` WRITE;
/*!40000 ALTER TABLE `adventure_price_list_additional_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `adventure_price_list_additional_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_report`
--

DROP TABLE IF EXISTS `adventure_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `average_grade` double DEFAULT NULL,
  `revenue` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_report`
--

LOCK TABLES `adventure_report` WRITE;
/*!40000 ALTER TABLE `adventure_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `adventure_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_reservation`
--

DROP TABLE IF EXISTS `adventure_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_reservation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) DEFAULT NULL,
  `number_of_persons` int NOT NULL,
  `price` double NOT NULL,
  `reservation_end` datetime(6) NOT NULL,
  `reservation_start` datetime(6) NOT NULL,
  `system_earning` double DEFAULT NULL,
  `adventure_id` bigint DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  `report_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgk2k6c05fo3ebvxom0isnuu6r` (`adventure_id`),
  KEY `FKlqisltebfkqdg7hw10320i9fd` (`client_id`),
  KEY `FKfbqrxbw4dukpvn9s4vgfhuduo` (`report_id`),
  CONSTRAINT `FKfbqrxbw4dukpvn9s4vgfhuduo` FOREIGN KEY (`report_id`) REFERENCES `instructor_report` (`id`),
  CONSTRAINT `FKgk2k6c05fo3ebvxom0isnuu6r` FOREIGN KEY (`adventure_id`) REFERENCES `adventure` (`id`),
  CONSTRAINT `FKlqisltebfkqdg7hw10320i9fd` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_reservation`
--

LOCK TABLES `adventure_reservation` WRITE;
/*!40000 ALTER TABLE `adventure_reservation` DISABLE KEYS */;
INSERT INTO `adventure_reservation` VALUES (1,_binary '\0',3,2000,'2022-11-12 13:00:00.000000','2022-07-10 07:00:00.000000',200,1,5,NULL),(2,_binary '\0',3,3000,'2022-02-10 13:00:00.000000','2022-09-10 07:00:00.000000',300,2,8,NULL),(3,_binary '\0',3,2500,'2022-08-30 13:00:00.000000','2022-08-10 07:00:00.000000',250,3,8,NULL),(4,_binary '\0',3,6000,'2021-09-12 13:00:00.000000','2021-09-10 07:00:00.000000',600,4,8,NULL),(5,_binary '\0',3,5400,'2023-07-12 13:00:00.000000','2023-07-10 07:00:00.000000',540,1,8,NULL),(6,_binary '\0',3,3000,'2021-08-12 13:00:00.000000','2021-08-10 07:00:00.000000',300,1,5,NULL);
/*!40000 ALTER TABLE `adventure_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_reservation_additional_items`
--

DROP TABLE IF EXISTS `adventure_reservation_additional_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_reservation_additional_items` (
  `adventure_reservation_id` bigint NOT NULL,
  `additional_item_id` bigint NOT NULL,
  PRIMARY KEY (`adventure_reservation_id`,`additional_item_id`),
  KEY `FKbx6mli38vefcjflle2xi8rv3` (`additional_item_id`),
  CONSTRAINT `FKbx6mli38vefcjflle2xi8rv3` FOREIGN KEY (`additional_item_id`) REFERENCES `additional_item` (`id`),
  CONSTRAINT `FKrpmtdstgx7dhbgw0oaqb5o304` FOREIGN KEY (`adventure_reservation_id`) REFERENCES `adventure_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_reservation_additional_items`
--

LOCK TABLES `adventure_reservation_additional_items` WRITE;
/*!40000 ALTER TABLE `adventure_reservation_additional_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `adventure_reservation_additional_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_reservation_adventure_complaints`
--

DROP TABLE IF EXISTS `adventure_reservation_adventure_complaints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_reservation_adventure_complaints` (
  `adventure_reservation_id` bigint NOT NULL,
  `adventure_complaints_id` bigint NOT NULL,
  UNIQUE KEY `UK_6tdyvic1gi7sxnl8viuhrx2jt` (`adventure_complaints_id`),
  KEY `FKkr30giocgccltbeow7pakpw6k` (`adventure_reservation_id`),
  CONSTRAINT `FKe9s5okrd0aukbm2eeto7r6x6i` FOREIGN KEY (`adventure_complaints_id`) REFERENCES `adventure_complaint` (`id`),
  CONSTRAINT `FKkr30giocgccltbeow7pakpw6k` FOREIGN KEY (`adventure_reservation_id`) REFERENCES `adventure_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_reservation_adventure_complaints`
--

LOCK TABLES `adventure_reservation_adventure_complaints` WRITE;
/*!40000 ALTER TABLE `adventure_reservation_adventure_complaints` DISABLE KEYS */;
/*!40000 ALTER TABLE `adventure_reservation_adventure_complaints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_reservation_adventure_revisions`
--

DROP TABLE IF EXISTS `adventure_reservation_adventure_revisions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_reservation_adventure_revisions` (
  `adventure_reservation_id` bigint NOT NULL,
  `adventure_revisions_id` bigint NOT NULL,
  UNIQUE KEY `UK_fgkci29t1cjbbli2wb6lq4g2v` (`adventure_revisions_id`),
  KEY `FKuww21p4xl5n55x60ob3gel0y` (`adventure_reservation_id`),
  CONSTRAINT `FKd487h0d49pr8aib7no71kv58w` FOREIGN KEY (`adventure_revisions_id`) REFERENCES `adventure_revision` (`id`),
  CONSTRAINT `FKuww21p4xl5n55x60ob3gel0y` FOREIGN KEY (`adventure_reservation_id`) REFERENCES `adventure_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_reservation_adventure_revisions`
--

LOCK TABLES `adventure_reservation_adventure_revisions` WRITE;
/*!40000 ALTER TABLE `adventure_reservation_adventure_revisions` DISABLE KEYS */;
/*!40000 ALTER TABLE `adventure_reservation_adventure_revisions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_revision`
--

DROP TABLE IF EXISTS `adventure_revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_revision` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `adventure_reservation_id` bigint DEFAULT NULL,
  `revision_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKltncpkr5s5joleol68h2787m7` (`adventure_reservation_id`),
  KEY `FK55kbb730pijfcqch9iivdcql7` (`revision_id`),
  CONSTRAINT `FK55kbb730pijfcqch9iivdcql7` FOREIGN KEY (`revision_id`) REFERENCES `revision` (`id`),
  CONSTRAINT `FKltncpkr5s5joleol68h2787m7` FOREIGN KEY (`adventure_reservation_id`) REFERENCES `adventure_reservation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_revision`
--

LOCK TABLES `adventure_revision` WRITE;
/*!40000 ALTER TABLE `adventure_revision` DISABLE KEYS */;
INSERT INTO `adventure_revision` VALUES (1,1,1);
/*!40000 ALTER TABLE `adventure_revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_rules`
--

DROP TABLE IF EXISTS `adventure_rules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_rules` (
  `adventure_id` bigint NOT NULL,
  `rule_id` bigint NOT NULL,
  PRIMARY KEY (`adventure_id`,`rule_id`),
  KEY `FKpbkn5f6fdt0whwykrk9qfof7b` (`rule_id`),
  CONSTRAINT `FKpbkn5f6fdt0whwykrk9qfof7b` FOREIGN KEY (`rule_id`) REFERENCES `adventure_behavioral_rule` (`id`),
  CONSTRAINT `FKpmdcdtmcn2b0xtui11osxwyj7` FOREIGN KEY (`adventure_id`) REFERENCES `adventure` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_rules`
--

LOCK TABLES `adventure_rules` WRITE;
/*!40000 ALTER TABLE `adventure_rules` DISABLE KEYS */;
INSERT INTO `adventure_rules` VALUES (1,1),(2,1),(1,2),(3,2),(2,3),(1,4),(3,4),(3,5);
/*!40000 ALTER TABLE `adventure_rules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_subscribers`
--

DROP TABLE IF EXISTS `adventure_subscribers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_subscribers` (
  `adventure_id` bigint NOT NULL,
  `client_id` bigint NOT NULL,
  PRIMARY KEY (`adventure_id`,`client_id`),
  KEY `FKagjw8f7enl793th250xyidbdb` (`client_id`),
  CONSTRAINT `FKagjw8f7enl793th250xyidbdb` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKlv8fmwt5yr766ey4mykp2nw4c` FOREIGN KEY (`adventure_id`) REFERENCES `adventure` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_subscribers`
--

LOCK TABLES `adventure_subscribers` WRITE;
/*!40000 ALTER TABLE `adventure_subscribers` DISABLE KEYS */;
INSERT INTO `adventure_subscribers` VALUES (1,5),(1,8),(3,8);
/*!40000 ALTER TABLE `adventure_subscribers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventure_unavailability`
--

DROP TABLE IF EXISTS `adventure_unavailability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adventure_unavailability` (
  `adventure_id` bigint NOT NULL,
  `period_id` bigint NOT NULL,
  PRIMARY KEY (`adventure_id`,`period_id`),
  KEY `FKb9vg6we6oavy7bnh0516cq1sy` (`period_id`),
  CONSTRAINT `FK6cpp507npxs4ofgqj8ab8qnq2` FOREIGN KEY (`adventure_id`) REFERENCES `adventure` (`id`),
  CONSTRAINT `FKb9vg6we6oavy7bnh0516cq1sy` FOREIGN KEY (`period_id`) REFERENCES `time_period` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_unavailability`
--

LOCK TABLES `adventure_unavailability` WRITE;
/*!40000 ALTER TABLE `adventure_unavailability` DISABLE KEYS */;
/*!40000 ALTER TABLE `adventure_unavailability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authority` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'ROLE_SYSADMIN'),(2,'ROLE_ADMIN'),(3,'ROLE_INSTRUCTOR'),(4,'ROLE_CLIENT'),(5,'ROLE_COTTAGE_OWNER'),(6,'ROLE_BOAT_OWNER');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat`
--

DROP TABLE IF EXISTS `boat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cancellation_percentage` int DEFAULT NULL,
  `capacity` int DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `grade` double DEFAULT NULL,
  `length` double DEFAULT NULL,
  `main_picture` varchar(255) DEFAULT NULL,
  `max_persons` int DEFAULT NULL,
  `max_speed` int DEFAULT NULL,
  `motor_number` int DEFAULT NULL,
  `motor_power` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `type` int DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `owner_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrha46a4xuastt0veangg0ikui` (`address_id`),
  KEY `FKqp3aeqp0i0q898gi7f3xlpxkt` (`owner_id`),
  CONSTRAINT `FKqp3aeqp0i0q898gi7f3xlpxkt` FOREIGN KEY (`owner_id`) REFERENCES `boat_owner` (`id`),
  CONSTRAINT `FKrha46a4xuastt0veangg0ikui` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat`
--

LOCK TABLES `boat` WRITE;
/*!40000 ALTER TABLE `boat` DISABLE KEYS */;
INSERT INTO `boat` VALUES (1,15,50,_binary '\0','ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki, Cyclades ',10,40,'/assets/boats/slika1.jpeg',10,3,3,100,'Marina',150,NULL,1,15),(2,20,40,_binary '\0','ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki, Cyclades and Dodecanese',9,23,'/assets/boats/slika2.jpeg',15,33,3,10,'Golden',250,NULL,2,15),(3,10,30,_binary '\0','ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki,',7,9,'/assets/boats/slika3.jpeg',20,333,1,1000,'Blue sky',300,NULL,3,15),(4,50,20,_binary '\0','ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki, Cyclades ',9,10,'/assets/boats/slika4.jpeg',30,33,1,100,'Blue star',180,NULL,4,15),(5,30,10,_binary '\0','ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki, Cyclades and Dodecanese ',6,15,'/assets/boats/slika1.jpeg',20,333,1,10,'Sky',120,NULL,5,15);
/*!40000 ALTER TABLE `boat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_additional_items`
--

DROP TABLE IF EXISTS `boat_additional_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_additional_items` (
  `boat_id` bigint NOT NULL,
  `additional_item_id` bigint NOT NULL,
  PRIMARY KEY (`boat_id`,`additional_item_id`),
  KEY `FKf7mep68tarj4p3t5ad78xl5x9` (`additional_item_id`),
  CONSTRAINT `FK7bcgdciphss32mosh6yht3c6y` FOREIGN KEY (`boat_id`) REFERENCES `boat` (`id`),
  CONSTRAINT `FKf7mep68tarj4p3t5ad78xl5x9` FOREIGN KEY (`additional_item_id`) REFERENCES `additional_item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_additional_items`
--

LOCK TABLES `boat_additional_items` WRITE;
/*!40000 ALTER TABLE `boat_additional_items` DISABLE KEYS */;
INSERT INTO `boat_additional_items` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(1,8);
/*!40000 ALTER TABLE `boat_additional_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_behavioral_rule`
--

DROP TABLE IF EXISTS `boat_behavioral_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_behavioral_rule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_behavioral_rule`
--

LOCK TABLES `boat_behavioral_rule` WRITE;
/*!40000 ALTER TABLE `boat_behavioral_rule` DISABLE KEYS */;
INSERT INTO `boat_behavioral_rule` VALUES (1,'Pet friendly');
/*!40000 ALTER TABLE `boat_behavioral_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_behavioral_rule_boats`
--

DROP TABLE IF EXISTS `boat_behavioral_rule_boats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_behavioral_rule_boats` (
  `boat_behavioral_rule_id` bigint NOT NULL,
  `boats_id` bigint NOT NULL,
  PRIMARY KEY (`boat_behavioral_rule_id`,`boats_id`),
  KEY `FKm4rw1ojfpa5kcdpr6bvbcdtai` (`boats_id`),
  CONSTRAINT `FKm4rw1ojfpa5kcdpr6bvbcdtai` FOREIGN KEY (`boats_id`) REFERENCES `boat` (`id`),
  CONSTRAINT `FKrd4k84jreecrxxj1scbnym4kr` FOREIGN KEY (`boat_behavioral_rule_id`) REFERENCES `boat_behavioral_rule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_behavioral_rule_boats`
--

LOCK TABLES `boat_behavioral_rule_boats` WRITE;
/*!40000 ALTER TABLE `boat_behavioral_rule_boats` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_behavioral_rule_boats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_behavioral_rules`
--

DROP TABLE IF EXISTS `boat_behavioral_rules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_behavioral_rules` (
  `boat_id` bigint NOT NULL,
  `rule_id` bigint NOT NULL,
  PRIMARY KEY (`boat_id`,`rule_id`),
  KEY `FKnw1o4k2en2r2vfi73q4c517kf` (`rule_id`),
  CONSTRAINT `FKnw1o4k2en2r2vfi73q4c517kf` FOREIGN KEY (`rule_id`) REFERENCES `boat_behavioral_rule` (`id`),
  CONSTRAINT `FKscnawjf2ku37jt3kgpyt3kyyq` FOREIGN KEY (`boat_id`) REFERENCES `boat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_behavioral_rules`
--

LOCK TABLES `boat_behavioral_rules` WRITE;
/*!40000 ALTER TABLE `boat_behavioral_rules` DISABLE KEYS */;
INSERT INTO `boat_behavioral_rules` VALUES (1,1),(2,1),(3,1),(4,1),(5,1);
/*!40000 ALTER TABLE `boat_behavioral_rules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_boat_reservations`
--

DROP TABLE IF EXISTS `boat_boat_reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_boat_reservations` (
  `boat_id` bigint NOT NULL,
  `boat_reservations_id` bigint NOT NULL,
  PRIMARY KEY (`boat_id`,`boat_reservations_id`),
  UNIQUE KEY `UK_4pokr49uicswlq7nf13b2cu0n` (`boat_reservations_id`),
  CONSTRAINT `FK7kik7wls6vcebhsgx5frnkn33` FOREIGN KEY (`boat_reservations_id`) REFERENCES `boat_reservation` (`id`),
  CONSTRAINT `FK85mka5p9ec4qemn825og8jgrx` FOREIGN KEY (`boat_id`) REFERENCES `boat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_boat_reservations`
--

LOCK TABLES `boat_boat_reservations` WRITE;
/*!40000 ALTER TABLE `boat_boat_reservations` DISABLE KEYS */;
INSERT INTO `boat_boat_reservations` VALUES (1,1),(2,2),(3,3),(1,4),(4,5),(2,6);
/*!40000 ALTER TABLE `boat_boat_reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_complaint`
--

DROP TABLE IF EXISTS `boat_complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_complaint` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `boat_reservation_id` bigint DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaemfg3hvdhvlorc8bmno9e3is` (`boat_reservation_id`),
  KEY `FKqx9mamrd5n1v5atd12xq50ucu` (`client_id`),
  CONSTRAINT `FKaemfg3hvdhvlorc8bmno9e3is` FOREIGN KEY (`boat_reservation_id`) REFERENCES `boat_reservation` (`id`),
  CONSTRAINT `FKqx9mamrd5n1v5atd12xq50ucu` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_complaint`
--

LOCK TABLES `boat_complaint` WRITE;
/*!40000 ALTER TABLE `boat_complaint` DISABLE KEYS */;
INSERT INTO `boat_complaint` VALUES (1,'Boat owner was very unpolite!','Default',1,5),(2,'Boat is small','Default',1,8);
/*!40000 ALTER TABLE `boat_complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_fast_reservation`
--

DROP TABLE IF EXISTS `boat_fast_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_fast_reservation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `duration` int NOT NULL,
  `max_persons` int NOT NULL,
  `price` double NOT NULL,
  `reservation_end` datetime(6) NOT NULL,
  `reservation_start` datetime(6) NOT NULL,
  `time` time DEFAULT NULL,
  `validity_end` date DEFAULT NULL,
  `validity_start` date DEFAULT NULL,
  `boat_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlb1vgv0o22lc0spyplwhky7au` (`boat_id`),
  CONSTRAINT `FKlb1vgv0o22lc0spyplwhky7au` FOREIGN KEY (`boat_id`) REFERENCES `boat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_fast_reservation`
--

LOCK TABLES `boat_fast_reservation` WRITE;
/*!40000 ALTER TABLE `boat_fast_reservation` DISABLE KEYS */;
INSERT INTO `boat_fast_reservation` VALUES (1,'2021-12-10',3,4,460,'2022-09-27 16:00:00.000000','2022-09-20 10:00:00.000000','06:30:00','2022-12-14','2022-12-10',1),(2,'2021-12-20',2,2,100,'2021-12-24 06:30:00.000000','2021-12-20 06:30:00.000000','06:30:00','2022-12-24','2022-12-12',1);
/*!40000 ALTER TABLE `boat_fast_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_fast_reservation_additional_items`
--

DROP TABLE IF EXISTS `boat_fast_reservation_additional_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_fast_reservation_additional_items` (
  `boat_fast_reservation_id` bigint NOT NULL,
  `additional_items_id` bigint NOT NULL,
  PRIMARY KEY (`boat_fast_reservation_id`,`additional_items_id`),
  UNIQUE KEY `UK_rvgepr4iuraaqbr2iva4kg7jh` (`additional_items_id`),
  CONSTRAINT `FK7seguav58l7p53x9xsqnlgaxu` FOREIGN KEY (`additional_items_id`) REFERENCES `additional_item` (`id`),
  CONSTRAINT `FKqhmcoihwr7gn5d9j6lo8axod7` FOREIGN KEY (`boat_fast_reservation_id`) REFERENCES `boat_fast_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_fast_reservation_additional_items`
--

LOCK TABLES `boat_fast_reservation_additional_items` WRITE;
/*!40000 ALTER TABLE `boat_fast_reservation_additional_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_fast_reservation_additional_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_navigation_equipment`
--

DROP TABLE IF EXISTS `boat_navigation_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_navigation_equipment` (
  `boat_id` bigint NOT NULL,
  `equipment_id` bigint NOT NULL,
  PRIMARY KEY (`boat_id`,`equipment_id`),
  KEY `FK94kiic91s0ov1jnvby6u5wiys` (`equipment_id`),
  CONSTRAINT `FK94kiic91s0ov1jnvby6u5wiys` FOREIGN KEY (`equipment_id`) REFERENCES `navigation_equipment` (`id`),
  CONSTRAINT `FKlokfqpiqfrsehg4lytaerqog3` FOREIGN KEY (`boat_id`) REFERENCES `boat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_navigation_equipment`
--

LOCK TABLES `boat_navigation_equipment` WRITE;
/*!40000 ALTER TABLE `boat_navigation_equipment` DISABLE KEYS */;
INSERT INTO `boat_navigation_equipment` VALUES (1,1),(2,1),(1,2),(5,2),(1,3),(4,3),(2,4),(3,4),(3,5);
/*!40000 ALTER TABLE `boat_navigation_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_owner`
--

DROP TABLE IF EXISTS `boat_owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_owner` (
  `grade` double DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK1590hrh1bg6ejt7ioob2nyrso` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_owner`
--

LOCK TABLES `boat_owner` WRITE;
/*!40000 ALTER TABLE `boat_owner` DISABLE KEYS */;
INSERT INTO `boat_owner` VALUES (4,15);
/*!40000 ALTER TABLE `boat_owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_owner_complaint`
--

DROP TABLE IF EXISTS `boat_owner_complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_owner_complaint` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `boat_reservation_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKonw64w1v6exf0tqeydc2kho5v` (`boat_reservation_id`),
  CONSTRAINT `FKonw64w1v6exf0tqeydc2kho5v` FOREIGN KEY (`boat_reservation_id`) REFERENCES `boat_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_owner_complaint`
--

LOCK TABLES `boat_owner_complaint` WRITE;
/*!40000 ALTER TABLE `boat_owner_complaint` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_owner_complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_owner_complaints`
--

DROP TABLE IF EXISTS `boat_owner_complaints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_owner_complaints` (
  `boat_owner_id` bigint NOT NULL,
  `complaints_id` bigint NOT NULL,
  PRIMARY KEY (`boat_owner_id`,`complaints_id`),
  UNIQUE KEY `UK_lv4e2i2ewmq3ccig5jsvrjrkj` (`complaints_id`),
  CONSTRAINT `FK6x5foxugw5qt6hvjjlun47rll` FOREIGN KEY (`boat_owner_id`) REFERENCES `boat_owner` (`id`),
  CONSTRAINT `FKim7ge9r8ysl4up33ae6haw41m` FOREIGN KEY (`complaints_id`) REFERENCES `boat_owner_complaint` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_owner_complaints`
--

LOCK TABLES `boat_owner_complaints` WRITE;
/*!40000 ALTER TABLE `boat_owner_complaints` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_owner_complaints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_owner_report`
--

DROP TABLE IF EXISTS `boat_owner_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_owner_report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `check_admin` bit(1) DEFAULT NULL,
  `checked` bit(1) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `penal` bit(1) DEFAULT NULL,
  `boat_reservation_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1h8oj1y96lhlc2egi54lj0p8u` (`boat_reservation_id`),
  CONSTRAINT `FK1h8oj1y96lhlc2egi54lj0p8u` FOREIGN KEY (`boat_reservation_id`) REFERENCES `boat_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_owner_report`
--

LOCK TABLES `boat_owner_report` WRITE;
/*!40000 ALTER TABLE `boat_owner_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_owner_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_owner_revision`
--

DROP TABLE IF EXISTS `boat_owner_revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_owner_revision` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `boat_reservation_id` bigint DEFAULT NULL,
  `revision_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2k6us3qlsvvrc19dcjxxqrw1v` (`boat_reservation_id`),
  KEY `FK5lpegj07qkau1q4baarc3lqt5` (`revision_id`),
  CONSTRAINT `FK2k6us3qlsvvrc19dcjxxqrw1v` FOREIGN KEY (`boat_reservation_id`) REFERENCES `boat_reservation` (`id`),
  CONSTRAINT `FK5lpegj07qkau1q4baarc3lqt5` FOREIGN KEY (`revision_id`) REFERENCES `revision` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_owner_revision`
--

LOCK TABLES `boat_owner_revision` WRITE;
/*!40000 ALTER TABLE `boat_owner_revision` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_owner_revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_owner_unavailability`
--

DROP TABLE IF EXISTS `boat_owner_unavailability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_owner_unavailability` (
  `boat_owner_id` bigint NOT NULL,
  `period_id` bigint NOT NULL,
  PRIMARY KEY (`boat_owner_id`,`period_id`),
  KEY `FKanpargq9nkkq2jsv2rlbk0ql7` (`period_id`),
  CONSTRAINT `FK9b9951822egi9jc2w6alefpq8` FOREIGN KEY (`boat_owner_id`) REFERENCES `boat_owner` (`id`),
  CONSTRAINT `FKanpargq9nkkq2jsv2rlbk0ql7` FOREIGN KEY (`period_id`) REFERENCES `time_period` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_owner_unavailability`
--

LOCK TABLES `boat_owner_unavailability` WRITE;
/*!40000 ALTER TABLE `boat_owner_unavailability` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_owner_unavailability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_pictures`
--

DROP TABLE IF EXISTS `boat_pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_pictures` (
  `boat_id` bigint NOT NULL,
  `picture_id` bigint NOT NULL,
  PRIMARY KEY (`boat_id`,`picture_id`),
  KEY `FK83tthjg7hv5s1v0xya44lwx8j` (`picture_id`),
  CONSTRAINT `FK83tthjg7hv5s1v0xya44lwx8j` FOREIGN KEY (`picture_id`) REFERENCES `picture` (`id`),
  CONSTRAINT `FKtjpde0sacn1rlam2ncrex1hoa` FOREIGN KEY (`boat_id`) REFERENCES `boat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_pictures`
--

LOCK TABLES `boat_pictures` WRITE;
/*!40000 ALTER TABLE `boat_pictures` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_price_list`
--

DROP TABLE IF EXISTS `boat_price_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_price_list` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_price_list`
--

LOCK TABLES `boat_price_list` WRITE;
/*!40000 ALTER TABLE `boat_price_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_price_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_price_list_additional_items`
--

DROP TABLE IF EXISTS `boat_price_list_additional_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_price_list_additional_items` (
  `boat_price_list_id` bigint NOT NULL,
  `additional_items_id` bigint NOT NULL,
  PRIMARY KEY (`boat_price_list_id`,`additional_items_id`),
  UNIQUE KEY `UK_p36ordg39j3atglr3m1fcapu9` (`additional_items_id`),
  CONSTRAINT `FKahhutq893nw1l4vl2tfotv4rp` FOREIGN KEY (`boat_price_list_id`) REFERENCES `boat_price_list` (`id`),
  CONSTRAINT `FKe40111to82v7dcbnuox0b8alb` FOREIGN KEY (`additional_items_id`) REFERENCES `additional_item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_price_list_additional_items`
--

LOCK TABLES `boat_price_list_additional_items` WRITE;
/*!40000 ALTER TABLE `boat_price_list_additional_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_price_list_additional_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_report`
--

DROP TABLE IF EXISTS `boat_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `average_grade` double DEFAULT NULL,
  `revenue` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_report`
--

LOCK TABLES `boat_report` WRITE;
/*!40000 ALTER TABLE `boat_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_reservation`
--

DROP TABLE IF EXISTS `boat_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_reservation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `number_of_persons` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `reservation_end` datetime(6) NOT NULL,
  `reservation_start` datetime(6) NOT NULL,
  `system_earning` double DEFAULT NULL,
  `boat_id` bigint DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  `owner_report_id` bigint DEFAULT NULL,
  `report_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn8x5qc8faxa12q527i69ulirt` (`boat_id`),
  KEY `FKj4rctqilfeyeox7516shnhk6i` (`client_id`),
  KEY `FKqehhic61xf28c2ypdbh4p1vw6` (`owner_report_id`),
  KEY `FKlavvh56auft6ntle8hdd59fiq` (`report_id`),
  CONSTRAINT `FKj4rctqilfeyeox7516shnhk6i` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKlavvh56auft6ntle8hdd59fiq` FOREIGN KEY (`report_id`) REFERENCES `boat_report` (`id`),
  CONSTRAINT `FKn8x5qc8faxa12q527i69ulirt` FOREIGN KEY (`boat_id`) REFERENCES `boat` (`id`),
  CONSTRAINT `FKqehhic61xf28c2ypdbh4p1vw6` FOREIGN KEY (`owner_report_id`) REFERENCES `boat_owner_report` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_reservation`
--

LOCK TABLES `boat_reservation` WRITE;
/*!40000 ALTER TABLE `boat_reservation` DISABLE KEYS */;
INSERT INTO `boat_reservation` VALUES (1,'2016-02-20 06:30:00.000000',_binary '\0',10,10,15000,'2022-08-15 16:00:00.000000','2022-08-10 10:00:00.000000',120,1,5,NULL,NULL),(2,'2014-02-20 06:30:00.000000',_binary '\0',3,2,7000,'2021-12-20 14:00:00.000000','2021-12-04 07:00:00.000000',150,2,8,NULL,NULL),(3,'2021-02-20 06:30:00.000000',_binary '\0',1,3,3000,'2021-11-12 13:00:00.000000','2021-11-10 07:00:00.000000',200,3,8,NULL,NULL),(4,'2017-02-20 06:30:00.000000',_binary '\0',3,1,6000,'2022-01-30 14:00:00.000000','2022-01-04 07:00:00.000000',250,1,8,NULL,NULL),(5,'2025-02-20 06:30:00.000000',_binary '\0',4,5,9000,'2022-11-12 13:00:00.000000','2022-11-10 07:00:00.000000',300,4,8,NULL,NULL),(6,'2021-02-20 06:30:00.000000',_binary '\0',2,5,3400,'2022-12-20 14:00:00.000000','2022-12-04 07:00:00.000000',100,2,9,NULL,NULL);
/*!40000 ALTER TABLE `boat_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_reservation_additional_items`
--

DROP TABLE IF EXISTS `boat_reservation_additional_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_reservation_additional_items` (
  `boat_reservation_id` bigint NOT NULL,
  `additional_items_id` bigint NOT NULL,
  PRIMARY KEY (`boat_reservation_id`,`additional_items_id`),
  UNIQUE KEY `UK_ptxkmoo3idoahs5dy57ucp093` (`additional_items_id`),
  CONSTRAINT `FK3tsblpru1wq8t8ep09ih7wl8n` FOREIGN KEY (`boat_reservation_id`) REFERENCES `boat_reservation` (`id`),
  CONSTRAINT `FKsb6g34uwotx14mmp9pwom1dw4` FOREIGN KEY (`additional_items_id`) REFERENCES `additional_item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_reservation_additional_items`
--

LOCK TABLES `boat_reservation_additional_items` WRITE;
/*!40000 ALTER TABLE `boat_reservation_additional_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_reservation_additional_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_reservation_boat_complaints`
--

DROP TABLE IF EXISTS `boat_reservation_boat_complaints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_reservation_boat_complaints` (
  `boat_reservation_id` bigint NOT NULL,
  `boat_complaints_id` bigint NOT NULL,
  UNIQUE KEY `UK_cx4q1c18knk52gw5u0a9n4oee` (`boat_complaints_id`),
  KEY `FKeixhh28nh1ao0j9g9wdaneo1c` (`boat_reservation_id`),
  CONSTRAINT `FK11bnqfcka7wyc8m1cgnmpyebn` FOREIGN KEY (`boat_complaints_id`) REFERENCES `boat_complaint` (`id`),
  CONSTRAINT `FKeixhh28nh1ao0j9g9wdaneo1c` FOREIGN KEY (`boat_reservation_id`) REFERENCES `boat_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_reservation_boat_complaints`
--

LOCK TABLES `boat_reservation_boat_complaints` WRITE;
/*!40000 ALTER TABLE `boat_reservation_boat_complaints` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_reservation_boat_complaints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_reservation_boat_owner_complaints`
--

DROP TABLE IF EXISTS `boat_reservation_boat_owner_complaints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_reservation_boat_owner_complaints` (
  `boat_reservation_id` bigint NOT NULL,
  `boat_owner_complaints_id` bigint NOT NULL,
  UNIQUE KEY `UK_pe406lu4jo47trgetlmqpp39c` (`boat_owner_complaints_id`),
  KEY `FKch6eedry86efag7q9c92l4uk2` (`boat_reservation_id`),
  CONSTRAINT `FK5ccdoofqhieduqwpuuu7fiuye` FOREIGN KEY (`boat_owner_complaints_id`) REFERENCES `boat_owner_complaint` (`id`),
  CONSTRAINT `FKch6eedry86efag7q9c92l4uk2` FOREIGN KEY (`boat_reservation_id`) REFERENCES `boat_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_reservation_boat_owner_complaints`
--

LOCK TABLES `boat_reservation_boat_owner_complaints` WRITE;
/*!40000 ALTER TABLE `boat_reservation_boat_owner_complaints` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_reservation_boat_owner_complaints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_reservation_boat_revisions`
--

DROP TABLE IF EXISTS `boat_reservation_boat_revisions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_reservation_boat_revisions` (
  `boat_reservation_id` bigint NOT NULL,
  `boat_revisions_id` bigint NOT NULL,
  UNIQUE KEY `UK_ow0mx8dlbs1nxna03m03qhlbb` (`boat_revisions_id`),
  KEY `FKq9qd4dp91uawrvl4d2uat7oc9` (`boat_reservation_id`),
  CONSTRAINT `FKoxmksjl7k8fe5lcfarxdt5c81` FOREIGN KEY (`boat_revisions_id`) REFERENCES `boat_revision` (`id`),
  CONSTRAINT `FKq9qd4dp91uawrvl4d2uat7oc9` FOREIGN KEY (`boat_reservation_id`) REFERENCES `boat_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_reservation_boat_revisions`
--

LOCK TABLES `boat_reservation_boat_revisions` WRITE;
/*!40000 ALTER TABLE `boat_reservation_boat_revisions` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat_reservation_boat_revisions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_revision`
--

DROP TABLE IF EXISTS `boat_revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_revision` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `boat_reservation_id` bigint DEFAULT NULL,
  `revision_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKorv6c4na4nuaehvwwjeynbbsk` (`boat_reservation_id`),
  KEY `FKk51w46uxqr0j7hwfbquwhdfmg` (`revision_id`),
  CONSTRAINT `FKk51w46uxqr0j7hwfbquwhdfmg` FOREIGN KEY (`revision_id`) REFERENCES `revision` (`id`),
  CONSTRAINT `FKorv6c4na4nuaehvwwjeynbbsk` FOREIGN KEY (`boat_reservation_id`) REFERENCES `boat_reservation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_revision`
--

LOCK TABLES `boat_revision` WRITE;
/*!40000 ALTER TABLE `boat_revision` DISABLE KEYS */;
INSERT INTO `boat_revision` VALUES (1,1,7),(2,2,8);
/*!40000 ALTER TABLE `boat_revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_subscribers`
--

DROP TABLE IF EXISTS `boat_subscribers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_subscribers` (
  `boat_id` bigint NOT NULL,
  `client_id` bigint NOT NULL,
  PRIMARY KEY (`boat_id`,`client_id`),
  KEY `FKj65fb44hdv8j4fp8jd0ql914n` (`client_id`),
  CONSTRAINT `FK70p178wjnylevsqwllyur4n7k` FOREIGN KEY (`boat_id`) REFERENCES `boat` (`id`),
  CONSTRAINT `FKj65fb44hdv8j4fp8jd0ql914n` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_subscribers`
--

LOCK TABLES `boat_subscribers` WRITE;
/*!40000 ALTER TABLE `boat_subscribers` DISABLE KEYS */;
INSERT INTO `boat_subscribers` VALUES (1,5),(1,8),(4,8);
/*!40000 ALTER TABLE `boat_subscribers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boat_unavailability`
--

DROP TABLE IF EXISTS `boat_unavailability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boat_unavailability` (
  `boat_id` bigint NOT NULL,
  `period_id` bigint NOT NULL,
  PRIMARY KEY (`boat_id`,`period_id`),
  KEY `FKrwdn12p8nbpv6wjwslkog173f` (`period_id`),
  CONSTRAINT `FKn6ai4fg0f8soo6rkm0j1pwg47` FOREIGN KEY (`boat_id`) REFERENCES `boat` (`id`),
  CONSTRAINT `FKrwdn12p8nbpv6wjwslkog173f` FOREIGN KEY (`period_id`) REFERENCES `time_period` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat_unavailability`
--

LOCK TABLES `boat_unavailability` WRITE;
/*!40000 ALTER TABLE `boat_unavailability` DISABLE KEYS */;
INSERT INTO `boat_unavailability` VALUES (1,1),(1,2),(1,3);
/*!40000 ALTER TABLE `boat_unavailability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `number_of_penals` int DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK4ai00u1wkkeysdaq92yicsf6e` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (0,5),(0,7),(0,8),(0,9);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_adventure_reservations`
--

DROP TABLE IF EXISTS `client_adventure_reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_adventure_reservations` (
  `client_id` bigint NOT NULL,
  `adventure_reservations_id` bigint NOT NULL,
  UNIQUE KEY `UK_7wsj8kei8wbn1ubvha99x4o59` (`adventure_reservations_id`),
  KEY `FKsh3rvg2b0sfhqcw7wg5gl4oeg` (`client_id`),
  CONSTRAINT `FKg2mbae0sk9wq4dgoi039f9ig8` FOREIGN KEY (`adventure_reservations_id`) REFERENCES `adventure_reservation` (`id`),
  CONSTRAINT `FKsh3rvg2b0sfhqcw7wg5gl4oeg` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_adventure_reservations`
--

LOCK TABLES `client_adventure_reservations` WRITE;
/*!40000 ALTER TABLE `client_adventure_reservations` DISABLE KEYS */;
INSERT INTO `client_adventure_reservations` VALUES (5,1),(5,6),(8,2),(8,3),(8,4),(8,5);
/*!40000 ALTER TABLE `client_adventure_reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_boat_reservations`
--

DROP TABLE IF EXISTS `client_boat_reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_boat_reservations` (
  `client_id` bigint NOT NULL,
  `boat_reservations_id` bigint NOT NULL,
  UNIQUE KEY `UK_r857i6wl0nr97pco0ak2bsx88` (`boat_reservations_id`),
  KEY `FKaqp35b5sfy1cebe6vry4xb2hb` (`client_id`),
  CONSTRAINT `FKaqp35b5sfy1cebe6vry4xb2hb` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKg7jjqul1uj0usw4koq1qn8oin` FOREIGN KEY (`boat_reservations_id`) REFERENCES `boat_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_boat_reservations`
--

LOCK TABLES `client_boat_reservations` WRITE;
/*!40000 ALTER TABLE `client_boat_reservations` DISABLE KEYS */;
INSERT INTO `client_boat_reservations` VALUES (5,1),(8,2),(8,3),(8,4),(8,5),(9,6);
/*!40000 ALTER TABLE `client_boat_reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_cottage_reservations`
--

DROP TABLE IF EXISTS `client_cottage_reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_cottage_reservations` (
  `client_id` bigint NOT NULL,
  `cottage_reservations_id` bigint NOT NULL,
  UNIQUE KEY `UK_hvhnparbff4qppfosy4bekb9w` (`cottage_reservations_id`),
  KEY `FK4c4aua0vfdwqeai1vv917d1av` (`client_id`),
  CONSTRAINT `FK4c4aua0vfdwqeai1vv917d1av` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKej7a9gnqfbh87ktaalt5lsfky` FOREIGN KEY (`cottage_reservations_id`) REFERENCES `cottage_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_cottage_reservations`
--

LOCK TABLES `client_cottage_reservations` WRITE;
/*!40000 ALTER TABLE `client_cottage_reservations` DISABLE KEYS */;
INSERT INTO `client_cottage_reservations` VALUES (5,1),(8,2),(8,3),(8,4),(8,5),(9,6);
/*!40000 ALTER TABLE `client_cottage_reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage`
--

DROP TABLE IF EXISTS `cottage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cancellation_percentage` int DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `grade` double NOT NULL,
  `main_picture` varchar(255) DEFAULT NULL,
  `max_persons` int DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` double DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `cottage_owner_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt3gm2win8jld5k4l3hcgnbe8` (`address_id`),
  KEY `FK7hwm0i79jm6o0i29traicobl8` (`cottage_owner_id`),
  CONSTRAINT `FK7hwm0i79jm6o0i29traicobl8` FOREIGN KEY (`cottage_owner_id`) REFERENCES `cottage_owner` (`id`),
  CONSTRAINT `FKt3gm2win8jld5k4l3hcgnbe8` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage`
--

LOCK TABLES `cottage` WRITE;
/*!40000 ALTER TABLE `cottage` DISABLE KEYS */;
INSERT INTO `cottage` VALUES (1,20,_binary '\0','small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.',10,'assets/cottages/vikendica1.jpg',5,'Sun cottage',120,1,11),(2,30,_binary '\0','small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.',8,'assets/cottages/vikendica5.jpg',10,'Star cottage',100,5,11),(3,15,_binary '\0','small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.',8,'assets/cottages/vikendica3.jpg',4,'Moon cottage',50,4,11),(4,10,_binary '\0','small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.',9,'assets/cottages/vikendica4.jpg',2,'shooting star cottage',150,3,11),(5,40,_binary '\0','small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.',7,'assets/cottages/vikendica5.jpg',3,'Sky cottage',100,6,11);
/*!40000 ALTER TABLE `cottage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_behavioral_rule`
--

DROP TABLE IF EXISTS `cottage_behavioral_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_behavioral_rule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_behavioral_rule`
--

LOCK TABLES `cottage_behavioral_rule` WRITE;
/*!40000 ALTER TABLE `cottage_behavioral_rule` DISABLE KEYS */;
INSERT INTO `cottage_behavioral_rule` VALUES (1,'Pet friendly');
/*!40000 ALTER TABLE `cottage_behavioral_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_behavioral_rule_cottages`
--

DROP TABLE IF EXISTS `cottage_behavioral_rule_cottages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_behavioral_rule_cottages` (
  `cottage_behavioral_rule_id` bigint NOT NULL,
  `cottages_id` bigint NOT NULL,
  PRIMARY KEY (`cottage_behavioral_rule_id`,`cottages_id`),
  KEY `FK4t1ave1jkoisc0n93yd6j3m30` (`cottages_id`),
  CONSTRAINT `FK4t1ave1jkoisc0n93yd6j3m30` FOREIGN KEY (`cottages_id`) REFERENCES `cottage` (`id`),
  CONSTRAINT `FKf2gi5gfwsylnopu1qk82n4uxf` FOREIGN KEY (`cottage_behavioral_rule_id`) REFERENCES `cottage_behavioral_rule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_behavioral_rule_cottages`
--

LOCK TABLES `cottage_behavioral_rule_cottages` WRITE;
/*!40000 ALTER TABLE `cottage_behavioral_rule_cottages` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_behavioral_rule_cottages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_behavioral_rules`
--

DROP TABLE IF EXISTS `cottage_behavioral_rules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_behavioral_rules` (
  `cottage_id` bigint NOT NULL,
  `rule_id` bigint NOT NULL,
  PRIMARY KEY (`cottage_id`,`rule_id`),
  KEY `FKt4nrby24urxlhqeumyy8jlxc8` (`rule_id`),
  CONSTRAINT `FKc5uqjo6v07olmlplox7ur2reu` FOREIGN KEY (`cottage_id`) REFERENCES `cottage` (`id`),
  CONSTRAINT `FKt4nrby24urxlhqeumyy8jlxc8` FOREIGN KEY (`rule_id`) REFERENCES `cottage_behavioral_rule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_behavioral_rules`
--

LOCK TABLES `cottage_behavioral_rules` WRITE;
/*!40000 ALTER TABLE `cottage_behavioral_rules` DISABLE KEYS */;
INSERT INTO `cottage_behavioral_rules` VALUES (1,1),(2,1),(3,1),(4,1),(5,1);
/*!40000 ALTER TABLE `cottage_behavioral_rules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_complaint`
--

DROP TABLE IF EXISTS `cottage_complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_complaint` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  `cottage_reservation_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa2lhgsqbrkm69mpib65wusgk0` (`client_id`),
  KEY `FK8orpp51s8w2714a8yokepnvhn` (`cottage_reservation_id`),
  CONSTRAINT `FK8orpp51s8w2714a8yokepnvhn` FOREIGN KEY (`cottage_reservation_id`) REFERENCES `cottage_reservation` (`id`),
  CONSTRAINT `FKa2lhgsqbrkm69mpib65wusgk0` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_complaint`
--

LOCK TABLES `cottage_complaint` WRITE;
/*!40000 ALTER TABLE `cottage_complaint` DISABLE KEYS */;
INSERT INTO `cottage_complaint` VALUES (1,'Rooms are dirty!','Default',5,1),(2,'There are no enough beds.','Default',8,1);
/*!40000 ALTER TABLE `cottage_complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_cottage_reservations`
--

DROP TABLE IF EXISTS `cottage_cottage_reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_cottage_reservations` (
  `cottage_id` bigint NOT NULL,
  `cottage_reservations_id` bigint NOT NULL,
  PRIMARY KEY (`cottage_id`,`cottage_reservations_id`),
  UNIQUE KEY `UK_ewkteeriejtulrixibsegr2ru` (`cottage_reservations_id`),
  CONSTRAINT `FK8j3s693i6bwqahaxv59p8y0pa` FOREIGN KEY (`cottage_reservations_id`) REFERENCES `cottage_reservation` (`id`),
  CONSTRAINT `FKc7uta9vgpj4wquoodm1g4et3f` FOREIGN KEY (`cottage_id`) REFERENCES `cottage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_cottage_reservations`
--

LOCK TABLES `cottage_cottage_reservations` WRITE;
/*!40000 ALTER TABLE `cottage_cottage_reservations` DISABLE KEYS */;
INSERT INTO `cottage_cottage_reservations` VALUES (1,1),(2,2),(3,3),(1,4),(4,5),(2,6);
/*!40000 ALTER TABLE `cottage_cottage_reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_fast_reservation`
--

DROP TABLE IF EXISTS `cottage_fast_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_fast_reservation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `duration` int NOT NULL,
  `max_persons` int NOT NULL,
  `price` double NOT NULL,
  `reservation_end` datetime(6) NOT NULL,
  `reservation_start` datetime(6) NOT NULL,
  `time` time DEFAULT NULL,
  `validity_end` date DEFAULT NULL,
  `validity_start` date DEFAULT NULL,
  `cottage_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr2plspt0xmwl084qfb56o04iq` (`cottage_id`),
  CONSTRAINT `FKr2plspt0xmwl084qfb56o04iq` FOREIGN KEY (`cottage_id`) REFERENCES `cottage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_fast_reservation`
--

LOCK TABLES `cottage_fast_reservation` WRITE;
/*!40000 ALTER TABLE `cottage_fast_reservation` DISABLE KEYS */;
INSERT INTO `cottage_fast_reservation` VALUES (1,'2021-12-10',3,4,460,'2022-09-27 16:00:00.000000','2022-09-20 10:00:00.000000','06:30:00','2022-12-14','2022-12-10',2),(2,'2021-12-20',2,2,100,'2021-12-24 06:30:00.000000','2021-12-20 06:30:00.000000','06:30:00','2022-12-24','2022-12-12',1);
/*!40000 ALTER TABLE `cottage_fast_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_fast_reservation_additional_items`
--

DROP TABLE IF EXISTS `cottage_fast_reservation_additional_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_fast_reservation_additional_items` (
  `cottage_fast_reservation_id` bigint NOT NULL,
  `additional_items_id` bigint NOT NULL,
  PRIMARY KEY (`cottage_fast_reservation_id`,`additional_items_id`),
  UNIQUE KEY `UK_iqy1wg70xm69qg3wgvf1s7dc3` (`additional_items_id`),
  CONSTRAINT `FKmpyn82fi7t64inr14pww1rg53` FOREIGN KEY (`additional_items_id`) REFERENCES `additional_item` (`id`),
  CONSTRAINT `FKpjaqw9cbe2j7bk3rgy5gdjur4` FOREIGN KEY (`cottage_fast_reservation_id`) REFERENCES `cottage_fast_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_fast_reservation_additional_items`
--

LOCK TABLES `cottage_fast_reservation_additional_items` WRITE;
/*!40000 ALTER TABLE `cottage_fast_reservation_additional_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_fast_reservation_additional_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_items`
--

DROP TABLE IF EXISTS `cottage_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_items` (
  `cottage_id` bigint NOT NULL,
  `additional_item_id` bigint NOT NULL,
  PRIMARY KEY (`cottage_id`,`additional_item_id`),
  KEY `FK790mms76wathp9i7fwp4hjeyt` (`additional_item_id`),
  CONSTRAINT `FK790mms76wathp9i7fwp4hjeyt` FOREIGN KEY (`additional_item_id`) REFERENCES `additional_item` (`id`),
  CONSTRAINT `FKm92d7x90k9tvhxkeq1w0irx70` FOREIGN KEY (`cottage_id`) REFERENCES `cottage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_items`
--

LOCK TABLES `cottage_items` WRITE;
/*!40000 ALTER TABLE `cottage_items` DISABLE KEYS */;
INSERT INTO `cottage_items` VALUES (1,3),(2,4),(2,6),(5,6),(1,7),(3,7),(3,8),(4,8);
/*!40000 ALTER TABLE `cottage_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_owner`
--

DROP TABLE IF EXISTS `cottage_owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_owner` (
  `grade` double DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKfevgk5xe2acgfrxmf6fhavk7d` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_owner`
--

LOCK TABLES `cottage_owner` WRITE;
/*!40000 ALTER TABLE `cottage_owner` DISABLE KEYS */;
INSERT INTO `cottage_owner` VALUES (3,11);
/*!40000 ALTER TABLE `cottage_owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_owner_complaint`
--

DROP TABLE IF EXISTS `cottage_owner_complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_owner_complaint` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `cottage_reservation_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4mfixsb3rai5d9mgfjm2hi5qr` (`cottage_reservation_id`),
  CONSTRAINT `FK4mfixsb3rai5d9mgfjm2hi5qr` FOREIGN KEY (`cottage_reservation_id`) REFERENCES `cottage_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_owner_complaint`
--

LOCK TABLES `cottage_owner_complaint` WRITE;
/*!40000 ALTER TABLE `cottage_owner_complaint` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_owner_complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_owner_report`
--

DROP TABLE IF EXISTS `cottage_owner_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_owner_report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `check_admin` bit(1) DEFAULT NULL,
  `checked` bit(1) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `penal` bit(1) DEFAULT NULL,
  `cottage_reservation_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd66bj85b637t1e6fqan7tiu8r` (`cottage_reservation_id`),
  CONSTRAINT `FKd66bj85b637t1e6fqan7tiu8r` FOREIGN KEY (`cottage_reservation_id`) REFERENCES `cottage_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_owner_report`
--

LOCK TABLES `cottage_owner_report` WRITE;
/*!40000 ALTER TABLE `cottage_owner_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_owner_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_owner_revision`
--

DROP TABLE IF EXISTS `cottage_owner_revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_owner_revision` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cottage_reservation_id` bigint DEFAULT NULL,
  `revision_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKftumleqc4ymumjf68txk09mh4` (`cottage_reservation_id`),
  KEY `FKt4vugpnq94o1i32vu8am9yais` (`revision_id`),
  CONSTRAINT `FKftumleqc4ymumjf68txk09mh4` FOREIGN KEY (`cottage_reservation_id`) REFERENCES `cottage_reservation` (`id`),
  CONSTRAINT `FKt4vugpnq94o1i32vu8am9yais` FOREIGN KEY (`revision_id`) REFERENCES `revision` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_owner_revision`
--

LOCK TABLES `cottage_owner_revision` WRITE;
/*!40000 ALTER TABLE `cottage_owner_revision` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_owner_revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_owner_unavailability`
--

DROP TABLE IF EXISTS `cottage_owner_unavailability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_owner_unavailability` (
  `cottage_owner_id` bigint NOT NULL,
  `period_id` bigint NOT NULL,
  PRIMARY KEY (`cottage_owner_id`,`period_id`),
  KEY `FKobbxj1mwpsh0e0jtg3uv8x7x4` (`period_id`),
  CONSTRAINT `FKcdgikih79ocph7hxp4cbe30ll` FOREIGN KEY (`cottage_owner_id`) REFERENCES `cottage_owner` (`id`),
  CONSTRAINT `FKobbxj1mwpsh0e0jtg3uv8x7x4` FOREIGN KEY (`period_id`) REFERENCES `time_period` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_owner_unavailability`
--

LOCK TABLES `cottage_owner_unavailability` WRITE;
/*!40000 ALTER TABLE `cottage_owner_unavailability` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_owner_unavailability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_pictures`
--

DROP TABLE IF EXISTS `cottage_pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_pictures` (
  `cottage_id` bigint NOT NULL,
  `picture_id` bigint NOT NULL,
  PRIMARY KEY (`cottage_id`,`picture_id`),
  KEY `FK7aw1d0fskgc65q85ks78i6pq5` (`picture_id`),
  CONSTRAINT `FK7aw1d0fskgc65q85ks78i6pq5` FOREIGN KEY (`picture_id`) REFERENCES `picture` (`id`),
  CONSTRAINT `FKlw616fldcqlb3bnplmxj8eona` FOREIGN KEY (`cottage_id`) REFERENCES `cottage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_pictures`
--

LOCK TABLES `cottage_pictures` WRITE;
/*!40000 ALTER TABLE `cottage_pictures` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_price_list`
--

DROP TABLE IF EXISTS `cottage_price_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_price_list` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_price_list`
--

LOCK TABLES `cottage_price_list` WRITE;
/*!40000 ALTER TABLE `cottage_price_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_price_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_price_list_additional_items`
--

DROP TABLE IF EXISTS `cottage_price_list_additional_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_price_list_additional_items` (
  `cottage_price_list_id` bigint NOT NULL,
  `additional_items_id` bigint NOT NULL,
  PRIMARY KEY (`cottage_price_list_id`,`additional_items_id`),
  UNIQUE KEY `UK_n9ggabccamsbh5bi4qqy1eh1h` (`additional_items_id`),
  CONSTRAINT `FK9sbdy9ycticjc3epvc4c53054` FOREIGN KEY (`additional_items_id`) REFERENCES `additional_item` (`id`),
  CONSTRAINT `FKmt16opo9f7o0mv315791stph2` FOREIGN KEY (`cottage_price_list_id`) REFERENCES `cottage_price_list` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_price_list_additional_items`
--

LOCK TABLES `cottage_price_list_additional_items` WRITE;
/*!40000 ALTER TABLE `cottage_price_list_additional_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_price_list_additional_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_report`
--

DROP TABLE IF EXISTS `cottage_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `average_grade` double DEFAULT NULL,
  `revenue` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_report`
--

LOCK TABLES `cottage_report` WRITE;
/*!40000 ALTER TABLE `cottage_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_reservation`
--

DROP TABLE IF EXISTS `cottage_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_reservation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `max_persons` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `reservation_end` datetime(6) NOT NULL,
  `reservation_start` datetime(6) NOT NULL,
  `system_earning` double DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  `cottage_id` bigint DEFAULT NULL,
  `owner_report_id` bigint DEFAULT NULL,
  `report_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqrdmsc1bbd8kkmmv1hmvfki05` (`client_id`),
  KEY `FKhmfrwuci5kp1nntm37edeqlho` (`cottage_id`),
  KEY `FKe1fbiyi69h0d11ai67wltl3yn` (`owner_report_id`),
  KEY `FK9uvccuwn9aamlqx4f0k17iun` (`report_id`),
  CONSTRAINT `FK9uvccuwn9aamlqx4f0k17iun` FOREIGN KEY (`report_id`) REFERENCES `cottage_report` (`id`),
  CONSTRAINT `FKe1fbiyi69h0d11ai67wltl3yn` FOREIGN KEY (`owner_report_id`) REFERENCES `cottage_owner_report` (`id`),
  CONSTRAINT `FKhmfrwuci5kp1nntm37edeqlho` FOREIGN KEY (`cottage_id`) REFERENCES `cottage` (`id`),
  CONSTRAINT `FKqrdmsc1bbd8kkmmv1hmvfki05` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_reservation`
--

LOCK TABLES `cottage_reservation` WRITE;
/*!40000 ALTER TABLE `cottage_reservation` DISABLE KEYS */;
INSERT INTO `cottage_reservation` VALUES (1,'2016-02-20 06:30:00.000000',_binary '\0',10,10,15000,'2022-08-15 16:00:00.000000','2022-08-10 10:00:00.000000',20,5,1,NULL,NULL),(2,'2014-02-20 06:30:00.000000',_binary '\0',3,2,7000,'2022-08-09 16:00:00.000000','2022-08-02 10:00:00.000000',30,8,2,NULL,NULL),(3,'2023-02-20 06:30:00.000000',_binary '\0',1,3,3000,'2021-11-12 13:00:00.000000','2021-11-10 07:00:00.000000',40,8,3,NULL,NULL),(4,'2017-02-20 06:30:00.000000',_binary '\0',3,1,6000,'2022-01-30 14:00:00.000000','2022-01-04 07:00:00.000000',50,8,1,NULL,NULL),(5,'2022-02-20 06:30:00.000000',_binary '\0',4,5,9000,'2022-11-12 13:00:00.000000','2022-11-10 07:00:00.000000',60,8,4,NULL,NULL),(6,'2021-02-20 06:30:00.000000',_binary '\0',2,5,3400,'2022-12-20 14:00:00.000000','2022-12-04 07:00:00.000000',10,9,2,NULL,NULL);
/*!40000 ALTER TABLE `cottage_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_reservation_additional_items`
--

DROP TABLE IF EXISTS `cottage_reservation_additional_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_reservation_additional_items` (
  `cottage_reservation_id` bigint NOT NULL,
  `additional_items_id` bigint NOT NULL,
  PRIMARY KEY (`cottage_reservation_id`,`additional_items_id`),
  UNIQUE KEY `UK_ifxx0w3twne16ex5xrbteukuy` (`additional_items_id`),
  CONSTRAINT `FKnp48udbhmm7f43ywg1bs5kryj` FOREIGN KEY (`additional_items_id`) REFERENCES `additional_item` (`id`),
  CONSTRAINT `FKqbd40robw1955u2fkyao032p5` FOREIGN KEY (`cottage_reservation_id`) REFERENCES `cottage_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_reservation_additional_items`
--

LOCK TABLES `cottage_reservation_additional_items` WRITE;
/*!40000 ALTER TABLE `cottage_reservation_additional_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_reservation_additional_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_reservation_cottage_complaints`
--

DROP TABLE IF EXISTS `cottage_reservation_cottage_complaints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_reservation_cottage_complaints` (
  `cottage_reservation_id` bigint NOT NULL,
  `cottage_complaints_id` bigint NOT NULL,
  UNIQUE KEY `UK_gmo8tq06y6m2o047mbqyrq9ci` (`cottage_complaints_id`),
  KEY `FKlyx9xtwhc00oq4a4ngqfwapjw` (`cottage_reservation_id`),
  CONSTRAINT `FKehfitnobq4gf6ug9annlhj6f0` FOREIGN KEY (`cottage_complaints_id`) REFERENCES `cottage_complaint` (`id`),
  CONSTRAINT `FKlyx9xtwhc00oq4a4ngqfwapjw` FOREIGN KEY (`cottage_reservation_id`) REFERENCES `cottage_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_reservation_cottage_complaints`
--

LOCK TABLES `cottage_reservation_cottage_complaints` WRITE;
/*!40000 ALTER TABLE `cottage_reservation_cottage_complaints` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_reservation_cottage_complaints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_reservation_cottage_owner_complaints`
--

DROP TABLE IF EXISTS `cottage_reservation_cottage_owner_complaints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_reservation_cottage_owner_complaints` (
  `cottage_reservation_id` bigint NOT NULL,
  `cottage_owner_complaints_id` bigint NOT NULL,
  UNIQUE KEY `UK_gncihs3cyb5ba3k976mykqb3v` (`cottage_owner_complaints_id`),
  KEY `FKnp9t4y01t4012oki6l1005tsw` (`cottage_reservation_id`),
  CONSTRAINT `FK8p736g375whx7ut52jp39mgur` FOREIGN KEY (`cottage_owner_complaints_id`) REFERENCES `cottage_owner_complaint` (`id`),
  CONSTRAINT `FKnp9t4y01t4012oki6l1005tsw` FOREIGN KEY (`cottage_reservation_id`) REFERENCES `cottage_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_reservation_cottage_owner_complaints`
--

LOCK TABLES `cottage_reservation_cottage_owner_complaints` WRITE;
/*!40000 ALTER TABLE `cottage_reservation_cottage_owner_complaints` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_reservation_cottage_owner_complaints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_reservation_cottage_owner_revisions`
--

DROP TABLE IF EXISTS `cottage_reservation_cottage_owner_revisions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_reservation_cottage_owner_revisions` (
  `cottage_reservation_id` bigint NOT NULL,
  `cottage_owner_revisions_id` bigint NOT NULL,
  UNIQUE KEY `UK_6cogee960ed5by6m3jcqbrjov` (`cottage_owner_revisions_id`),
  KEY `FKsqoa5kreu3qulh3o24bk18psk` (`cottage_reservation_id`),
  CONSTRAINT `FKd4wck2b334rt3ow7jxao8c9wx` FOREIGN KEY (`cottage_owner_revisions_id`) REFERENCES `cottage_owner_revision` (`id`),
  CONSTRAINT `FKsqoa5kreu3qulh3o24bk18psk` FOREIGN KEY (`cottage_reservation_id`) REFERENCES `cottage_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_reservation_cottage_owner_revisions`
--

LOCK TABLES `cottage_reservation_cottage_owner_revisions` WRITE;
/*!40000 ALTER TABLE `cottage_reservation_cottage_owner_revisions` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_reservation_cottage_owner_revisions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_reservation_cottage_revisions`
--

DROP TABLE IF EXISTS `cottage_reservation_cottage_revisions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_reservation_cottage_revisions` (
  `cottage_reservation_id` bigint NOT NULL,
  `cottage_revisions_id` bigint NOT NULL,
  UNIQUE KEY `UK_p38vyfkqsg8ywgmjropfet38w` (`cottage_revisions_id`),
  KEY `FK4t06m2hcgq7xjeltw5r0y7r8i` (`cottage_reservation_id`),
  CONSTRAINT `FK4t06m2hcgq7xjeltw5r0y7r8i` FOREIGN KEY (`cottage_reservation_id`) REFERENCES `cottage_reservation` (`id`),
  CONSTRAINT `FKnuavnmddyncfi3ilpev4dnwgi` FOREIGN KEY (`cottage_revisions_id`) REFERENCES `cottage_revision` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_reservation_cottage_revisions`
--

LOCK TABLES `cottage_reservation_cottage_revisions` WRITE;
/*!40000 ALTER TABLE `cottage_reservation_cottage_revisions` DISABLE KEYS */;
/*!40000 ALTER TABLE `cottage_reservation_cottage_revisions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_revision`
--

DROP TABLE IF EXISTS `cottage_revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_revision` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cottage_reservation_id` bigint DEFAULT NULL,
  `revision_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKojwy92of8vb69wb19soh6kbmj` (`cottage_reservation_id`),
  KEY `FKjh9chxebgklfg4ke97kb6l5pl` (`revision_id`),
  CONSTRAINT `FKjh9chxebgklfg4ke97kb6l5pl` FOREIGN KEY (`revision_id`) REFERENCES `revision` (`id`),
  CONSTRAINT `FKojwy92of8vb69wb19soh6kbmj` FOREIGN KEY (`cottage_reservation_id`) REFERENCES `cottage_reservation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_revision`
--

LOCK TABLES `cottage_revision` WRITE;
/*!40000 ALTER TABLE `cottage_revision` DISABLE KEYS */;
INSERT INTO `cottage_revision` VALUES (1,1,2),(2,2,3),(3,4,4),(4,5,5),(5,6,6);
/*!40000 ALTER TABLE `cottage_revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_subscribers`
--

DROP TABLE IF EXISTS `cottage_subscribers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_subscribers` (
  `cottage_id` bigint NOT NULL,
  `client_id` bigint NOT NULL,
  PRIMARY KEY (`cottage_id`,`client_id`),
  KEY `FKsb5wudds1ksrphoftphgvn9at` (`client_id`),
  CONSTRAINT `FKpdaq83kf126vrvcho4glq9uc0` FOREIGN KEY (`cottage_id`) REFERENCES `cottage` (`id`),
  CONSTRAINT `FKsb5wudds1ksrphoftphgvn9at` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_subscribers`
--

LOCK TABLES `cottage_subscribers` WRITE;
/*!40000 ALTER TABLE `cottage_subscribers` DISABLE KEYS */;
INSERT INTO `cottage_subscribers` VALUES (1,5),(1,8),(5,8);
/*!40000 ALTER TABLE `cottage_subscribers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_unavailability`
--

DROP TABLE IF EXISTS `cottage_unavailability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cottage_unavailability` (
  `cottage_id` bigint NOT NULL,
  `period_id` bigint NOT NULL,
  PRIMARY KEY (`cottage_id`,`period_id`),
  KEY `FKr1s8o7rcg2sgpayd2c9upd62e` (`period_id`),
  CONSTRAINT `FKj1eqkma1m58gw57w6gkyxh8f0` FOREIGN KEY (`cottage_id`) REFERENCES `cottage` (`id`),
  CONSTRAINT `FKr1s8o7rcg2sgpayd2c9upd62e` FOREIGN KEY (`period_id`) REFERENCES `time_period` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_unavailability`
--

LOCK TABLES `cottage_unavailability` WRITE;
/*!40000 ALTER TABLE `cottage_unavailability` DISABLE KEYS */;
INSERT INTO `cottage_unavailability` VALUES (1,1),(1,2),(2,3),(2,4);
/*!40000 ALTER TABLE `cottage_unavailability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `files`
--

DROP TABLE IF EXISTS `files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `files` (
  `id` varchar(255) NOT NULL,
  `data` longblob,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `files`
--

LOCK TABLES `files` WRITE;
/*!40000 ALTER TABLE `files` DISABLE KEYS */;
/*!40000 ALTER TABLE `files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image_model`
--

DROP TABLE IF EXISTS `image_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_model` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pic_byte` mediumblob,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_model`
--

LOCK TABLES `image_model` WRITE;
/*!40000 ALTER TABLE `image_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `image_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor` (
  `biography` longtext,
  `grade` double DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK7g3x2jl829f2l4end0uk08es8` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES ('I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',3,1),('I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',4,2),('I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',3,3),('I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',5,4),('I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',2,6);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor_report`
--

DROP TABLE IF EXISTS `instructor_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor_report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `check_admin` bit(1) DEFAULT NULL,
  `checked` bit(1) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `penal` bit(1) DEFAULT NULL,
  `adventure_reservation_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmc4lsw32dyw1du34f7ln0fruw` (`adventure_reservation_id`),
  CONSTRAINT `FKmc4lsw32dyw1du34f7ln0fruw` FOREIGN KEY (`adventure_reservation_id`) REFERENCES `adventure_reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor_report`
--

LOCK TABLES `instructor_report` WRITE;
/*!40000 ALTER TABLE `instructor_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructor_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor_unavailability`
--

DROP TABLE IF EXISTS `instructor_unavailability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor_unavailability` (
  `instructor_id` bigint NOT NULL,
  `period_id` bigint NOT NULL,
  PRIMARY KEY (`instructor_id`,`period_id`),
  KEY `FKgquyp3vv00ar6txxygt2ts5l4` (`period_id`),
  CONSTRAINT `FKdtmqb9td0keaud5v5aeumakxd` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`),
  CONSTRAINT `FKgquyp3vv00ar6txxygt2ts5l4` FOREIGN KEY (`period_id`) REFERENCES `time_period` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor_unavailability`
--

LOCK TABLES `instructor_unavailability` WRITE;
/*!40000 ALTER TABLE `instructor_unavailability` DISABLE KEYS */;
INSERT INTO `instructor_unavailability` VALUES (1,5);
/*!40000 ALTER TABLE `instructor_unavailability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `navigation_equipment`
--

DROP TABLE IF EXISTS `navigation_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `navigation_equipment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `navigation_equipment`
--

LOCK TABLES `navigation_equipment` WRITE;
/*!40000 ALTER TABLE `navigation_equipment` DISABLE KEYS */;
INSERT INTO `navigation_equipment` VALUES (1,'Gyro Compass',10),(2,'Radar',12),(3,'Magnetic Compass',15),(4,'Autopilot',45),(5,'Speed & Distance Log Device',78);
/*!40000 ALTER TABLE `navigation_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `picture` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile_delete_request`
--

DROP TABLE IF EXISTS `profile_delete_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile_delete_request` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `reason` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjxp4cbbvjr24hcn5y01jstly9` (`user_id`),
  CONSTRAINT `FKjxp4cbbvjr24hcn5y01jstly9` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile_delete_request`
--

LOCK TABLES `profile_delete_request` WRITE;
/*!40000 ALTER TABLE `profile_delete_request` DISABLE KEYS */;
INSERT INTO `profile_delete_request` VALUES (1,'My services are no longer available','Unverified',3),(2,'I am getting to old for this :( ','Unverified',4);
/*!40000 ALTER TABLE `profile_delete_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration_request`
--

DROP TABLE IF EXISTS `registration_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registration_request` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `reason` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK48hqrla6xn33637yefvrq61g0` (`user_id`),
  CONSTRAINT `FK48hqrla6xn33637yefvrq61g0` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration_request`
--

LOCK TABLES `registration_request` WRITE;
/*!40000 ALTER TABLE `registration_request` DISABLE KEYS */;
INSERT INTO `registration_request` VALUES (1,'Have many adventures to offer',13),(2,'This site looks pretty amazing and I want to be part of this community',14);
/*!40000 ALTER TABLE `registration_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revision`
--

DROP TABLE IF EXISTS `revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `revision` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `grade` double DEFAULT NULL,
  `revision` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revision`
--

LOCK TABLES `revision` WRITE;
/*!40000 ALTER TABLE `revision` DISABLE KEYS */;
INSERT INTO `revision` VALUES (1,7,'Boat was very dirty','Unchecked'),(2,4,'Beds are very uncomfotable','Unchecked'),(3,3,'Beds are very uncomfotable','Unchecked'),(4,1,'Beds are very uncomfotable','Unchecked'),(5,5,'Beds are very uncomfotable','Unchecked'),(6,2,'Beds are very uncomfotable','Unchecked'),(7,4,'Boat was very dirty','Unchecked'),(8,3,'Boat was very dirty','Unchecked');
/*!40000 ALTER TABLE `revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `beds_number` int DEFAULT NULL,
  `cottage_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk6c04f8s0bdbpm8s1qcasawgl` (`cottage_id`),
  CONSTRAINT `FKk6c04f8s0bdbpm8s1qcasawgl` FOREIGN KEY (`cottage_id`) REFERENCES `cottage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_earnings`
--

DROP TABLE IF EXISTS `system_earnings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_earnings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_earnings`
--

LOCK TABLES `system_earnings` WRITE;
/*!40000 ALTER TABLE `system_earnings` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_earnings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_period`
--

DROP TABLE IF EXISTS `time_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_period` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `end` datetime(6) DEFAULT NULL,
  `start` datetime(6) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_period`
--

LOCK TABLES `time_period` WRITE;
/*!40000 ALTER TABLE `time_period` DISABLE KEYS */;
INSERT INTO `time_period` VALUES (1,'2022-08-15 16:00:00.000000','2022-08-10 10:00:00.000000','Reservation'),(2,'2022-09-18 16:00:00.000000','2022-09-15 10:00:00.000000','Default'),(3,'2022-09-27 16:00:00.000000','2022-09-20 10:00:00.000000','Action'),(4,'2022-08-09 16:00:00.000000','2022-08-02 10:00:00.000000','Reservation'),(5,'2022-09-10 00:42:00.000000','2022-08-31 00:42:00.000000','Action');
/*!40000 ALTER TABLE `time_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `last_password_reset_date` datetime(6) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKddefmvbrws3hvl5t0hnnsv8ox` (`address_id`),
  CONSTRAINT `FKddefmvbrws3hvl5t0hnnsv8ox` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,_binary '\0','isa.booking22@gmail.com',_binary '','Truman','Willis','1983-07-12 21:30:55.888000','305-555-0163','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','Instructor','truman',1),(2,_binary '\0','isa.booking22@gmail.com',_binary '','Raymond','Weaving','1983-07-12 21:30:55.888000','305-555-0720','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','Instructor','raymond',2),(3,_binary '\0','isa.booking22@gmail.com',_binary '','Stewart','Lindsey','1983-07-12 21:30:55.888000','305-555-0000','222','Instructor','stewart',3),(4,_binary '\0','isa.booking22@gmail.com',_binary '','Bruno','Nicholson','1983-07-12 21:30:55.888000','305-555-0419','333','Instructor','bruno',4),(5,_binary '\0','isa.booking22@gmail.com',_binary '','Ana','Anic','1983-07-12 21:30:55.888000','305-555-0419','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','Client','ana',4),(6,_binary '\0','isa.booking22@gmail.com',_binary '','Lana','Laic','1983-07-12 21:30:55.888000','305-555-0419','$2a$10$PTOW/.r9dgjokBc60GGnIO6csC4ReF7ql/F21IE/spO4fhCQLP9XK','Instructor','lana',4),(7,_binary '\0','isa.booking22@gmail.com',_binary '','Laza','Anic','1983-07-12 21:30:55.888000','305-555-0419','$2a$10$sfvnEaK0mFaQB1VH3b.5k.ZloVuTXQ4DmM/uJazZNWh8.gcMa/2Bi','Client','laza',4),(8,_binary '\0','isa.booking22@gmail.com',_binary '','Dusko','Dusic','1983-07-12 21:30:55.888000','305-555-0419','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','Client','dusko',4),(9,_binary '\0','isa.booking22@gmail.com',_binary '','Danica','Danicic','1983-07-12 21:30:55.888000','305-555-0419','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','Client','daca',4),(10,_binary '\0','isa.booking22@gmail.com',_binary '','Taylor','Smith','1983-07-12 21:30:55.888000','305-666-0163','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','SysAdmin','taylor',3),(11,_binary '\0','isa.booking22@gmail.com',_binary '','Ana','Popovic','1983-07-12 21:30:55.888000','305-555-0163','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','CottageOwner','anna',1),(12,_binary '\0','isa.booking22@gmail.com',_binary '','Maya','Smith','1983-07-12 21:30:55.888000','305-555-0163','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','Client','Maya',5),(13,_binary '\0','isa.booking22@gmail.com',_binary '\0','Tanya','Smith','1983-07-12 21:30:55.888000','305-555-0163','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','Instructor','tanya',5),(14,_binary '\0','isa.booking22@gmail.com',_binary '\0','Sam','Smith','1983-07-12 21:30:55.888000','305-555-0163','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','Cottage Owner','sam',5),(15,_binary '\0','isa.booking22@gmail.com',_binary '','Naomi','Willis','1983-07-12 21:30:55.888000','305-555-0163','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','BoatOwner','naomi',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_authority`
--

DROP TABLE IF EXISTS `user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_authority` (
  `user_id` bigint NOT NULL,
  `authority_id` bigint NOT NULL,
  KEY `FKgvxjs381k6f48d5d2yi11uh89` (`authority_id`),
  KEY `FKpqlsjpkybgos9w2svcri7j8xy` (`user_id`),
  CONSTRAINT `FKgvxjs381k6f48d5d2yi11uh89` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  CONSTRAINT `FKpqlsjpkybgos9w2svcri7j8xy` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_authority`
--

LOCK TABLES `user_authority` WRITE;
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
INSERT INTO `user_authority` VALUES (1,3),(2,3),(3,3),(4,3),(5,4),(6,3),(7,4),(8,4),(9,4),(11,5),(15,6),(10,1);
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-15 12:50:35
