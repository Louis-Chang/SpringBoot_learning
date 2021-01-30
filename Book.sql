-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: book
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'杨绛','这是一本小说，不错。推荐你阅读 good','我们仨','2'),(2,'刘慈欣','一本科幻小说~','时间移民','1'),(4,'简·麦戈尼格尔 ','游戏是我们集中精力的大好机会，我们乐观向上地做着一件自己擅长并享受的事情','游戏改变世界','0'),(5,'彼得·蒂尔 / 布莱克·马斯特斯 ','帮助你思考从0到1的秘密，在意想不到之处发现价值与机会','从0到1','2'),(6,'[美] 德内拉·梅多斯 ','是一本简明扼要的系统思考入门指南，也是认识复杂动态系统的有力工具','系统之美','1'),(7,'彼得•迈尔斯 (Peter Meyers) / 尚恩•尼克','通过演讲一举赢得支持实现梦想','高效演讲','0'),(8,'凯文·凯利','经济和社会发展的趋势有着深刻的见解','必然','2'),(9,'凯文·凯利','这可能是90年代最重要的一本书','失控','1'),(10,'李笑来','时间管理不了，只能管理自己','把时间当作朋友','2'),(11,'李笑来','七年就是一辈子','七年就是一辈子','1'),(12,'王东岳','一本哲理随笔，汇集了作者数十年的思想精髓。哲学','知鱼之乐','0'),(13,'王东岳','一本哲学书','物演通论','0'),(14,'查理·芒格','收录了查理•芒格的个人传记与投资哲学','穷查理宝典','1'),(15,'Andy Hunt ','思考如何解决问题','程序员思维修炼','2'),(16,'Andy Hunt ','学有所思，思有所悟，悟有所行','高效程序员的45个习惯','1'),(17,'格雷厄姆','主要介绍黑客即优秀程序员的爱好和动机','黑客与画家','0'),(18,'安德斯•艾利克森','如何学习一项技能的方法','刻意练习','2'),(23,'John','nice book','Teach you how to OKR','0'),(24,'Louis','好書j','教你怎麼投資','0'),(25,'Fish','good book too.','OSMR','0');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (26);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-30 15:51:30
