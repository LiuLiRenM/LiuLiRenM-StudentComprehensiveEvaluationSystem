mysqldump: [Warning] Using a password on the command line interface can be insecure.
-- MySQL dump 10.13  Distrib 8.0.19, for Linux (x86_64)
--
-- Host: localhost    Database: ses
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `professionId` int DEFAULT NULL,
  `collegeId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `professionId` (`professionId`),
  KEY `collegeId` (`collegeId`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`professionId`) REFERENCES `profession` (`id`),
  CONSTRAINT `class_ibfk_2` FOREIGN KEY (`collegeId`) REFERENCES `college` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,'16计算机科学与技术卓越01班',3,1),(2,'16计算机科学与技术1班',3,1),(3,'16计算机科学与技术2班',3,1),(4,'16软件工程1班',4,1),(5,'16软件工程2班',4,1),(6,'17计算机科学与技术1班',3,1),(7,'16电子信息工程01班',2,1),(8,'16通信工程03班',1,1);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_item`
--

DROP TABLE IF EXISTS `class_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_item` (
  `classId` int NOT NULL,
  `evaluationitemId` int NOT NULL,
  `beginYear` int NOT NULL,
  `endYear` int DEFAULT NULL,
  `evaluationtypeId` int DEFAULT NULL,
  PRIMARY KEY (`classId`,`evaluationitemId`,`beginYear`),
  KEY `evaluationitemId` (`evaluationitemId`),
  CONSTRAINT `class_item_ibfk_1` FOREIGN KEY (`classId`) REFERENCES `class` (`id`),
  CONSTRAINT `class_item_ibfk_2` FOREIGN KEY (`evaluationitemId`) REFERENCES `evaluationitem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_item`
--

LOCK TABLES `class_item` WRITE;
/*!40000 ALTER TABLE `class_item` DISABLE KEYS */;
INSERT INTO `class_item` VALUES (1,1,2016,2017,1),(1,2,2016,2017,1),(1,3,2016,2017,1),(1,6,2016,2017,1),(1,7,2016,2017,1),(1,8,2016,2017,1),(1,17,2016,2017,1),(1,18,2016,2017,1),(1,19,2016,2017,1),(1,20,2016,2017,1),(1,24,2016,2017,1),(1,26,2016,2017,1),(1,27,2016,2017,2),(1,28,2016,2017,2),(1,29,2016,2017,2),(1,30,2016,2017,2),(1,31,2016,2017,2),(1,32,2016,2017,3),(1,35,2016,2017,3),(1,38,2016,2017,3),(1,39,2016,2017,3),(1,40,2016,2017,3),(1,41,2016,2017,3),(1,42,2016,2017,3),(1,43,2016,2017,3),(1,44,2016,2017,3),(1,45,2016,2017,3),(1,46,2016,2017,3),(1,47,2016,2017,3),(1,48,2016,2017,3),(1,49,2016,2017,3),(1,50,2016,2017,3),(1,51,2016,2017,3),(1,52,2016,2017,3),(1,53,2016,2017,3),(1,54,2016,2017,3),(1,55,2016,2017,3),(1,56,2016,2017,3),(1,57,2016,2017,3),(1,58,2016,2017,3),(1,59,2016,2017,4),(1,60,2016,2017,4),(1,61,2016,2017,4),(1,62,2016,2017,4),(1,63,2016,2017,4),(1,64,2016,2017,4),(1,65,2016,2017,4);
/*!40000 ALTER TABLE `class_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `college` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `college_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college`
--

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;
INSERT INTO `college` VALUES (12,'人文与艺术学院'),(27,'传媒学院'),(28,'体育学院'),(1,'信息工程学院'),(8,'国际教育学院'),(2,'土木与建筑工程学院'),(10,'士官学院'),(7,'外国语学院'),(4,'工商管理学院'),(9,'应用技术型本科'),(3,'机械与电气工程学院'),(11,'水利与生态工程学院'),(6,'理学院'),(5,'经济贸易学院'),(13,'美术与设计学院'),(29,'航天航空学院');
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluationitem`
--

DROP TABLE IF EXISTS `evaluationitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluationitem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `typeId` int DEFAULT NULL,
  `max` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `evaluationitem_name_uindex` (`name`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `evaluationitem_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `evaluationtype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluationitem`
--

LOCK TABLES `evaluationitem` WRITE;
/*!40000 ALTER TABLE `evaluationitem` DISABLE KEYS */;
INSERT INTO `evaluationitem` VALUES (1,'基本要求分',1,40),(2,'操行分',1,40),(3,'国家级先进个人',1,20),(6,'省级先进个人',1,10),(7,'校级先进个人',1,5),(8,'院级先进个人',1,1),(9,'国家级先进集体负责人',1,10),(10,'省级先进集体负责人',1,5),(11,'校级先进个人负责人',1,2),(12,'院级先进集体负责人',1,2),(13,'国家级先进集体成员',1,5),(14,'省级先进集体成员',1,2),(15,'校级先进集体成员',1,1),(16,'院级先进集体成员成员',1,1),(17,'优秀学生干部',1,8),(18,'良好学生干部',1,5),(19,'合格学生干部',1,2),(20,'不合格学生干部',1,0),(21,'国家级见义勇为',1,20),(22,'省级见义勇为',1,10),(23,'校级见义勇为',1,5),(24,'学校通报表扬',1,5),(26,'学院通报表扬',1,3),(27,'学业成绩-优',2,100),(28,'学业成绩-良',2,80),(29,'学业成绩-中',2,70),(30,'学业成绩-及格',2,50),(31,'学业成绩-不及格',2,40),(32,'创新与实践素质基本要求分',3,60),(35,'国际级一等奖',3,40),(38,'国家级一等奖',3,40),(39,'省级一等奖',3,25),(40,'校级一等奖',3,15),(41,'院级一等奖',3,6),(42,'国际级二等奖',3,40),(43,'国家级二等奖',3,30),(44,'省级二等奖',3,20),(45,'校级二等奖',3,10),(46,'院级二等奖',3,4),(47,'国际级三等奖',3,40),(48,'国家级三等奖',3,25),(49,'省级三等奖',3,15),(50,'校级三等奖',3,6),(51,'院级三等奖',3,3),(52,'国际级优秀奖',3,30),(53,'国家级优秀奖',3,20),(54,'省级优秀奖',3,10),(55,'校级优秀奖',3,4),(56,'院级优秀奖',3,2),(57,'英语四级',3,10),(58,'英语六级',3,15),(59,'文体与身心素质基本要求分',4,60),(60,'校级文体队员',4,10),(61,'学院文体队员',4,5),(62,'校铜管乐队',4,10),(63,'校礼仪队员',4,10),(64,'校军训教官',4,8),(65,'国家级文体竞赛第一名',4,40);
/*!40000 ALTER TABLE `evaluationitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluationtype`
--

DROP TABLE IF EXISTS `evaluationtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluationtype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluationtype`
--

LOCK TABLES `evaluationtype` WRITE;
/*!40000 ALTER TABLE `evaluationtype` DISABLE KEYS */;
INSERT INTO `evaluationtype` VALUES (1,'思想与道德素质'),(2,'专业与文化素质'),(3,'创新与实践素质'),(4,'文体与身心素质');
/*!40000 ALTER TABLE `evaluationtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` varchar(50) NOT NULL,
  `menuName` varchar(30) DEFAULT NULL,
  `parMenu` varchar(50) DEFAULT NULL,
  `url` varchar(30) DEFAULT NULL,
  `logo` varchar(20) DEFAULT NULL,
  `menu_id` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parMenu` (`parMenu`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`parMenu`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES ('8a7d74a4-65c0-11ea-b102-0242ac110002','专业信息管理','be4cba34-651f-11ea-b102-0242ac110002','/menus/professionManage.do','fa-gear','professionInfoManage'),('8ad25ba6-65c0-11ea-b102-0242ac110002','综合测评项目管理','be4cba34-651f-11ea-b102-0242ac110002','/menus/evaluationManage.do','fa-gear','evaluationManage'),('a9c0987a-6b75-11ea-a9ca-0242ac110002','设置测评项','bc1f3dca-651f-11ea-b102-0242ac110002',NULL,'fa-cogs','setEvaluationItem'),('be4cba34-651f-11ea-b102-0242ac110002','系别信息管理','be4cba34-651f-11ea-b102-0242ac110002','/menus/collegeManage.do','fa-gear','collegeInfoManage'),('c11b77e9-6525-11ea-b102-0242ac110002','查看个人信息','ba8cf238-651f-11ea-b102-0242ac110002',NULL,'fa-copy','checkPersonalInfo1'),('c1364705-6525-11ea-b102-0242ac110002','修改个人信息','ba8cf238-651f-11ea-b102-0242ac110002',NULL,'fa-copy','updatePersonalInfo1'),('c14fc3a9-6525-11ea-b102-0242ac110002','查询综测成绩','bad0d8aa-651f-11ea-b102-0242ac110002',NULL,'fa-align-left','checkEvaluationScore'),('c191442f-6525-11ea-b102-0242ac110002','查询操行成绩','bad0d8aa-651f-11ea-b102-0242ac110002',NULL,'fa-align-left',NULL),('c1c13755-6525-11ea-b102-0242ac110002','查询学业成绩','bad0d8aa-651f-11ea-b102-0242ac110002',NULL,'fa-align-left',NULL),('c1dd2d13-6525-11ea-b102-0242ac110002','查看工作信息','bb6d42e9-651f-11ea-b102-0242ac110002',NULL,'fa-suitcase',NULL),('c1ffcf36-6525-11ea-b102-0242ac110002','修改工作信息','bb6d42e9-651f-11ea-b102-0242ac110002',NULL,'fa-suitcase',NULL),('c22b0501-6525-11ea-b102-0242ac110002','查看个人信息','bb2014be-651f-11ea-b102-0242ac110002',NULL,'fa-copy',NULL),('c2543302-6525-11ea-b102-0242ac110002','修改个人信息','bb2014be-651f-11ea-b102-0242ac110002',NULL,'fa-copy',NULL),('c3092504-6525-11ea-b102-0242ac110002','管理测评成绩','bc1f3dca-651f-11ea-b102-0242ac110002',NULL,'fa-cogs','manageEvaluationResult'),('c33b3d5f-6525-11ea-b102-0242ac110002','管理学业成绩','bc1f3dca-651f-11ea-b102-0242ac110002',NULL,'fa-cogs',NULL),('c36bf891-6525-11ea-b102-0242ac110002','管理操行成绩','bc1f3dca-651f-11ea-b102-0242ac110002',NULL,'fa-cogs',NULL),('c3977af9-6525-11ea-b102-0242ac110002','查看工作信息','bc7661a7-651f-11ea-b102-0242ac110002',NULL,'fa-suitcase',NULL),('c3beee59-6525-11ea-b102-0242ac110002','修改工作信息','bc7661a7-651f-11ea-b102-0242ac110002',NULL,'fa-suitcase',NULL),('c3f03837-6525-11ea-b102-0242ac110002','添加工作信息','bc7661a7-651f-11ea-b102-0242ac110002',NULL,'fa-suitcase',NULL),('c418aa39-6525-11ea-b102-0242ac110002','查看个人信息','bcd61bde-651f-11ea-b102-0242ac110002',NULL,'fa-copy',NULL),('c4410ef4-6525-11ea-b102-0242ac110002','修改个人信息','bcd61bde-651f-11ea-b102-0242ac110002',NULL,'fa-copy',NULL),('c469c70c-6525-11ea-b102-0242ac110002','查看班主任信息','bd359f88-651f-11ea-b102-0242ac110002',NULL,'fa-file-text','checkTeacherInfo1'),('c48d9689-6525-11ea-b102-0242ac110002','修改班主任信息','bd359f88-651f-11ea-b102-0242ac110002',NULL,'fa-file-text','updateTeacherInfo1'),('c4b939d1-6525-11ea-b102-0242ac110002','添加班主任信息','bd359f88-651f-11ea-b102-0242ac110002',NULL,'fa-file-text','addTeacherInfo'),('c4de6917-6525-11ea-b102-0242ac110002','查看学生信息','bbd163bc-651f-11ea-b102-0242ac110002',NULL,'fa-th-list','checkStudentInfo'),('c5022f0c-6525-11ea-b102-0242ac110002','修改学生信息','bbd163bc-651f-11ea-b102-0242ac110002',NULL,'fa-th-list','updateStudentInfo'),('c5272edb-6525-11ea-b102-0242ac110002','添加学生信息','bbd163bc-651f-11ea-b102-0242ac110002','','fa-th-list','addStudentInfo'),('c54a6d82-6525-11ea-b102-0242ac110002','设置测评项','bda81b55-651f-11ea-b102-0242ac110002',NULL,'fa-cogs','setEvaluationItem'),('c57230cc-6525-11ea-b102-0242ac110002','管理测评成绩','bda81b55-651f-11ea-b102-0242ac110002',NULL,'fa-cogs','manageEvaluationResult'),('c5a53443-6525-11ea-b102-0242ac110002','编辑操行成绩','bda81b55-651f-11ea-b102-0242ac110002',NULL,'fa-cogs',NULL),('c5d6faa8-6525-11ea-b102-0242ac110002','管理学业成绩','bda81b55-651f-11ea-b102-0242ac110002',NULL,'fa-cogs',NULL),('c5fb3777-6525-11ea-b102-0242ac110002','修改用户权限','bdfaf2f4-651f-11ea-b102-0242ac110002',NULL,'fa-tag',NULL),('c640117a-6525-11ea-b102-0242ac110002','添加用户权限','bdfaf2f4-651f-11ea-b102-0242ac110002',NULL,'fa-tag',NULL);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `id` varchar(50) NOT NULL,
  `permissionName` varchar(30) DEFAULT NULL,
  `permissionId` varchar(4) DEFAULT NULL,
  `parPermissionId` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES ('','','',NULL),('ba8cf238-651f-11ea-b102-0242ac110002','个人信息','0001',2),('bad0d8aa-651f-11ea-b102-0242ac110002','成绩查询','0002',2),('bb2014be-651f-11ea-b102-0242ac110002','个人信息','0003',1),('bb6d42e9-651f-11ea-b102-0242ac110002','班主任工作','0004',1),('bbd163bc-651f-11ea-b102-0242ac110002','学生信息','0005',NULL),('bc1f3dca-651f-11ea-b102-0242ac110002','综合测评管理','0006',1),('bc7661a7-651f-11ea-b102-0242ac110002','班主任工作','0007',1),('bcd61bde-651f-11ea-b102-0242ac110002','个人信息','0008',0),('bd359f88-651f-11ea-b102-0242ac110002','班主任信息','0009',0),('bda81b55-651f-11ea-b102-0242ac110002','综合测评管理','0010',0),('bdfaf2f4-651f-11ea-b102-0242ac110002','用户权限','0011',0),('be4cba34-651f-11ea-b102-0242ac110002','系统设置','0012',0);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profession`
--

DROP TABLE IF EXISTS `profession`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profession` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `collegeId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `profession_name_uindex` (`name`),
  KEY `collegeId` (`collegeId`),
  CONSTRAINT `profession_ibfk_1` FOREIGN KEY (`collegeId`) REFERENCES `college` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profession`
--

LOCK TABLES `profession` WRITE;
/*!40000 ALTER TABLE `profession` DISABLE KEYS */;
INSERT INTO `profession` VALUES (1,'通信工程',1),(2,'电子信息工程',1),(3,'计算机科学与技术',1),(4,'软件工程',1),(5,'数据科学与大数据技术',1),(6,'土木工程',2),(7,'城乡规划',2),(8,'给排水科学与工程',2),(9,'道路桥梁与渡河工程',2),(10,'建筑学',2),(11,'工程造价',2),(12,'电气工程及其自动化',3),(13,'能源与动力工程',3),(14,'机械设计制造及其自动化',3),(15,'材料成型及控制工程',3),(16,'车辆工程',3),(17,'机械电子工程',3),(18,'自动化',3),(19,'市场营销',4),(20,'物流管理',4),(21,'电子商务',4),(22,'人力资源管理',4),(23,'财务管理',5),(24,'国际经济与贸易',5),(25,'审计学',5),(26,'投资学',5),(27,'应用统计学',6),(28,'英语',7),(29,'法语',7),(30,'翻译',7),(31,'土木工程（中荷合作）',8),(32,'电气工程及其自动化（中韩合作）',8),(33,'水土保持与荒漠化防治（职教本科）',9),(34,'园林（职教本科）',9),(35,'应用电子技术',10),(36,'通信技术',10),(37,'电气自动化技术',10),(39,'工程机械运用技术',10),(40,'汽车检测与维修技术',10),(41,'水利水电工程',11),(42,'水文与水资源工程',11),(43,'港口航道与海岸工程',11),(44,'农业水利工程',11),(45,'测绘工程',11),(46,'水土保持与荒漠化防治',11),(47,'园林',11),(48,'地质工程',11),(49,'风景园林',11),(50,'网络与新媒体',12),(51,'编辑出版学',12),(52,'环境设计',12),(53,'视觉传达设计',12),(54,'产品设计',12),(55,'数字媒体艺术',12),(56,'音乐学',12),(57,'服装与服饰设计',13),(58,'服装设计与工程',13),(59,'飞行器制造工程',29);
/*!40000 ALTER TABLE `profession` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` varchar(50) NOT NULL,
  `roleName` varchar(32) DEFAULT NULL,
  `roleDesc` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('022a39cc-62aa-11ea-8bc3-0242ac110002','ADMIN','管理员'),('02391c16-62aa-11ea-8bc3-0242ac110002','STUDENT','学生'),('024da70d-62aa-11ea-8bc3-0242ac110002','TEACHER','班主任');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permission` (
  `roleId` varchar(50) NOT NULL,
  `permissionId` varchar(50) NOT NULL,
  PRIMARY KEY (`roleId`,`permissionId`),
  KEY `permissionId` (`permissionId`),
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`),
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` VALUES ('02391c16-62aa-11ea-8bc3-0242ac110002','ba8cf238-651f-11ea-b102-0242ac110002'),('02391c16-62aa-11ea-8bc3-0242ac110002','bad0d8aa-651f-11ea-b102-0242ac110002'),('024da70d-62aa-11ea-8bc3-0242ac110002','bb2014be-651f-11ea-b102-0242ac110002'),('024da70d-62aa-11ea-8bc3-0242ac110002','bb6d42e9-651f-11ea-b102-0242ac110002'),('022a39cc-62aa-11ea-8bc3-0242ac110002','bbd163bc-651f-11ea-b102-0242ac110002'),('024da70d-62aa-11ea-8bc3-0242ac110002','bbd163bc-651f-11ea-b102-0242ac110002'),('024da70d-62aa-11ea-8bc3-0242ac110002','bc1f3dca-651f-11ea-b102-0242ac110002'),('022a39cc-62aa-11ea-8bc3-0242ac110002','bc7661a7-651f-11ea-b102-0242ac110002'),('022a39cc-62aa-11ea-8bc3-0242ac110002','bcd61bde-651f-11ea-b102-0242ac110002'),('022a39cc-62aa-11ea-8bc3-0242ac110002','bd359f88-651f-11ea-b102-0242ac110002'),('022a39cc-62aa-11ea-8bc3-0242ac110002','bda81b55-651f-11ea-b102-0242ac110002'),('022a39cc-62aa-11ea-8bc3-0242ac110002','bdfaf2f4-651f-11ea-b102-0242ac110002'),('022a39cc-62aa-11ea-8bc3-0242ac110002','be4cba34-651f-11ea-b102-0242ac110002');
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `score` (
  `studentId` varchar(32) NOT NULL,
  `itemId` int NOT NULL,
  `score` int DEFAULT NULL,
  `begin` int NOT NULL,
  PRIMARY KEY (`studentId`,`itemId`,`begin`),
  KEY `itemId` (`itemId`),
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`studentId`) REFERENCES `student` (`userId`),
  CONSTRAINT `score_ibfk_2` FOREIGN KEY (`itemId`) REFERENCES `evaluationitem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` VALUES ('2016101100',1,40,2016),('2016101100',2,40,2016),('2016101100',3,0,2016),('2016101100',6,0,2016),('2016101100',7,0,2016),('2016101100',8,0,2016),('2016101100',17,0,2016),('2016101100',18,0,2016),('2016101100',19,0,2016),('2016101100',20,0,2016),('2016101100',24,0,2016),('2016101100',26,0,2016),('2016101100',27,90,2016),('2016101100',28,0,2016),('2016101100',29,0,2016),('2016101100',30,0,2016),('2016101100',31,0,2016),('2016101100',32,60,2016),('2016101100',35,0,2016),('2016101100',38,0,2016),('2016101100',39,0,2016),('2016101100',40,0,2016),('2016101100',41,0,2016),('2016101100',42,0,2016),('2016101100',43,0,2016),('2016101100',44,0,2016),('2016101100',45,0,2016),('2016101100',46,0,2016),('2016101100',47,0,2016),('2016101100',48,0,2016),('2016101100',49,0,2016),('2016101100',50,0,2016),('2016101100',51,0,2016),('2016101100',52,0,2016),('2016101100',53,0,2016),('2016101100',54,0,2016),('2016101100',55,0,2016),('2016101100',56,0,2016),('2016101100',57,0,2016),('2016101100',58,0,2016),('2016101100',59,60,2016),('2016101100',60,0,2016),('2016101100',61,0,2016),('2016101100',62,0,2016),('2016101100',63,0,2016),('2016101100',64,0,2016),('2016101100',65,0,2016),('2016101824',1,40,2016),('2016101824',2,40,2016),('2016101824',3,0,2016),('2016101824',6,10,2016),('2016101824',7,0,2016),('2016101824',8,0,2016),('2016101824',17,8,2016),('2016101824',18,0,2016),('2016101824',19,0,2016),('2016101824',20,0,2016),('2016101824',24,5,2016),('2016101824',26,0,2016),('2016101824',27,90,2016),('2016101824',28,0,2016),('2016101824',29,0,2016),('2016101824',30,0,2016),('2016101824',31,0,2016),('2016101824',32,60,2016),('2016101824',35,40,2016),('2016101824',38,0,2016),('2016101824',39,0,2016),('2016101824',40,0,2016),('2016101824',41,0,2016),('2016101824',42,0,2016),('2016101824',43,0,2016),('2016101824',44,20,2016),('2016101824',45,0,2016),('2016101824',46,0,2016),('2016101824',47,0,2016),('2016101824',48,0,2016),('2016101824',49,0,2016),('2016101824',50,0,2016),('2016101824',51,0,2016),('2016101824',52,0,2016),('2016101824',53,0,2016),('2016101824',54,0,2016),('2016101824',55,0,2016),('2016101824',56,0,2016),('2016101824',57,0,2016),('2016101824',58,15,2016),('2016101824',59,60,2016),('2016101824',60,10,2016),('2016101824',61,0,2016),('2016101824',62,0,2016),('2016101824',63,0,2016),('2016101824',64,0,2016),('2016101824',65,40,2016),('2016101826',1,40,2016),('2016101826',2,40,2016),('2016101826',3,0,2016),('2016101826',6,0,2016),('2016101826',7,0,2016),('2016101826',8,0,2016),('2016101826',17,0,2016),('2016101826',18,0,2016),('2016101826',19,0,2016),('2016101826',20,0,2016),('2016101826',24,0,2016),('2016101826',26,0,2016),('2016101826',27,90,2016),('2016101826',28,0,2016),('2016101826',29,0,2016),('2016101826',30,0,2016),('2016101826',31,0,2016),('2016101826',32,40,2016),('2016101826',35,0,2016),('2016101826',38,0,2016),('2016101826',39,0,2016),('2016101826',40,0,2016),('2016101826',41,0,2016),('2016101826',42,0,2016),('2016101826',43,0,2016),('2016101826',44,0,2016),('2016101826',45,10,2016),('2016101826',46,4,2016),('2016101826',47,0,2016),('2016101826',48,0,2016),('2016101826',49,0,2016),('2016101826',50,0,2016),('2016101826',51,0,2016),('2016101826',52,0,2016),('2016101826',53,0,2016),('2016101826',54,0,2016),('2016101826',55,0,2016),('2016101826',56,0,2016),('2016101826',57,0,2016),('2016101826',58,0,2016),('2016101826',59,60,2016),('2016101826',60,0,2016),('2016101826',61,0,2016),('2016101826',62,0,2016),('2016101826',63,0,2016),('2016101826',64,0,2016),('2016101826',65,0,2016);
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` varchar(32) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `classId` int DEFAULT NULL,
  `professionId` int DEFAULT NULL,
  `collegeId` int DEFAULT NULL,
  `beginYear` int DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userId` (`userId`,`name`),
  KEY `professionId` (`professionId`),
  KEY `collegeId` (`collegeId`),
  KEY `classId` (`classId`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`professionId`) REFERENCES `profession` (`id`),
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`collegeId`) REFERENCES `college` (`id`),
  CONSTRAINT `student_ibfk_3` FOREIGN KEY (`classId`) REFERENCES `class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'2016101826','刘文','男',1,NULL,NULL,2016,NULL),(2,'2016101827','刘小文','男',1,NULL,NULL,2016,'liuxiaowen@nit.edu.cn'),(4,'2016101828','刘小文','男',1,NULL,NULL,2016,NULL),(5,'2016101829','刘小文','男',1,NULL,NULL,2016,NULL),(6,'2017101823','张三','女',3,NULL,NULL,2017,NULL),(7,'2016101825','李四四','男',2,NULL,NULL,2016,'lisi@nit.edu.cn'),(8,'2016101100','张慈龙','男',1,NULL,NULL,2016,'2016101100@nit.edu.cn'),(9,'2016101101','张国广','男',1,NULL,NULL,2016,NULL),(10,'2016101102','张淑娟','女',1,NULL,NULL,2016,NULL),(11,'2016101103','张凌雪','女',1,NULL,NULL,2016,NULL),(12,'2016101104','张一锦','男',1,NULL,NULL,2016,NULL),(13,'2016101105','北原秀次','男',1,NULL,NULL,2016,NULL),(14,'2016101106','内田雄马','男',1,NULL,NULL,2016,NULL),(15,'2016101107','铃木乃希','女',1,NULL,NULL,2016,NULL),(16,'2016101108','福田冬美','女',1,NULL,NULL,2016,NULL),(17,'2016101824','巫山','男',1,NULL,NULL,2016,'2016101824@nit.edu.cn');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `collegeId` int DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userId` (`userId`),
  KEY `collegeId` (`collegeId`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`username`),
  CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`collegeId`) REFERENCES `college` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (3,'1997010080','张三疯','男',40,1,'zhangsanfeng@nit.edu.cn'),(4,'1997010825','张三疯','男',40,1,NULL),(5,'admin','李四四','男',42,1,'lisisi@nit.edu.cn'),(6,'1984992122','司离人','女',25,1,'siliren@nit.edu.cn'),(7,'2016admin','小离人','男',30,1,NULL),(8,'1995010825','黄宸瑞','男',45,1,NULL),(9,'1995992122','黄国涛','男',35,1,NULL);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_class`
--

DROP TABLE IF EXISTS `teacher_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_class` (
  `teacherId` int NOT NULL,
  `classId` int NOT NULL,
  PRIMARY KEY (`teacherId`,`classId`),
  KEY `classId` (`classId`),
  CONSTRAINT `teacher_class_ibfk_1` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`),
  CONSTRAINT `teacher_class_ibfk_2` FOREIGN KEY (`classId`) REFERENCES `class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_class`
--

LOCK TABLES `teacher_class` WRITE;
/*!40000 ALTER TABLE `teacher_class` DISABLE KEYS */;
INSERT INTO `teacher_class` VALUES (4,1),(5,1),(8,1),(4,2),(8,2),(4,3),(8,3),(3,4),(7,4),(8,4),(9,4),(3,5),(7,5),(8,5),(9,5),(5,6),(6,6),(7,6),(8,6),(9,6),(5,7),(6,7),(7,7),(5,8),(6,8),(7,8);
/*!40000 ALTER TABLE `teacher_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1396df29-6a97-11ea-a9ca-0242ac110002','2016101826','101826',1),('1637bca5-6c35-11ea-acd2-0242ac110002','1997010080','010080',1),('25b13bc6-6dd0-11ea-acd2-0242ac110002','2016101100','$2a$10$LPRv3/sV355iPMxrHz9FF.gahsBFSsUXSAty8Od7wCWEzMHChoM2C',1),('2716cace-61f8-11ea-8bc3-0242ac110002','2016101825','101825',1),('2723a6d9-61f8-11ea-8bc3-0242ac110002','1984992122','$2a$10$NE3xa1Bd6Z2Mhu009WeuS.zjxpvGlORbCB4swG65Gnrz4szZZVx3q',1),('2e9eed1c-6dd0-11ea-acd2-0242ac110002','2016101101','$2a$10$lywn/tdWXvFexytAYyJ5f.MFEngJCTZ4yY0W.NbYlJWBogDAorBl2',1),('35d3ab44-6dd0-11ea-acd2-0242ac110002','2016101102','$2a$10$hJFA60emNiR7nb4ro/zZ0uUHskV0tprqzV6Ib9.hXLiqtDDYxg7Au',1),('3d20384e-6a96-11ea-a9ca-0242ac110002','2016101829','101829',1),('3f08dcc8-6dd0-11ea-acd2-0242ac110002','2016101103','$2a$10$zhXYk.l.rA0BrpZUzVqaBeVaX9V2RBLrXp3nQMspc8TUwEyT9Z7tu',1),('5376d2ac-6dd0-11ea-acd2-0242ac110002','2016101104','$2a$10$AN7w6h3d4coC/brE0LGrPuuPCqSGnqVoTDUvCOFeC0JIda48ZbNiW',1),('588b3e57-6dd1-11ea-acd2-0242ac110002','1995010825','$2a$10$mNdC0Q0C7XKQ8S/mB5L1Ke/PbTwvL0L7L30.yTsh6tD/S3..iq9wy',1),('5c5237a0-6a97-11ea-a9ca-0242ac110002','2016101827','101827',1),('6b6218bf-6dd0-11ea-acd2-0242ac110002','2016101105','$2a$10$4Vy.qi5C/9L5qNpUa2vRl.SQFAcK1RulTM/9YcFZhFL5A9TpNON.O',1),('7de6669e-6dd0-11ea-acd2-0242ac110002','2016101106','$2a$10$O3XDdIemi9D1TV62/yNIIOAw97cW8lyAarH7yvwnIU2eOwvy5OvGC',1),('82fc7f0f-6aa2-11ea-a9ca-0242ac110002','2017101823','101823',1),('860cee79-91f0-11ea-b127-0242ac110002','2016101824','$2a$10$1bTh1rhueLwizsO1Z/pxzOFNh53cAd3GfusW7tgglQlOyrUPLbHS2',1),('8e92fbe4-6dd0-11ea-acd2-0242ac110002','2016101107','$2a$10$mFFJL8S49r.VrnPfeSf98eMvIYagvWMFWlvPG2UknV1t4ZHiJly5a',1),('a50ca477-6dd0-11ea-acd2-0242ac110002','2016101108','$2a$10$g4dygb39oyZCqragkXPQX.jntH65hkupu/SnVjU60UVo.B5Vw7Eza',1),('b335ed9e-6dd1-11ea-acd2-0242ac110002','1995992122','$2a$10$NE3xa1Bd6Z2Mhu009WeuS.zjxpvGlORbCB4swG65Gnrz4szZZVx3q',1),('c4e1cf0b-61f6-11ea-8bc3-0242ac110002','admin','$2a$10$yHqqdtyTdYW4mAU0gRYSO.YTS0XnXTyRIRRfMGjHJJZF.CdR80uf2',1),('de18dfe8-6c36-11ea-acd2-0242ac110002','1997010825','$2a$10$mNdC0Q0C7XKQ8S/mB5L1Ke/PbTwvL0L7L30.yTsh6tD/S3..iq9wy',1),('dfd93d0b-6a95-11ea-a9ca-0242ac110002','2016101828','101828',1),('fc149d66-6dcb-11ea-acd2-0242ac110002','2016admin','$2a$10$yHqqdtyTdYW4mAU0gRYSO.YTS0XnXTyRIRRfMGjHJJZF.CdR80uf2',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `userId` varchar(50) NOT NULL,
  `roleId` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('c4e1cf0b-61f6-11ea-8bc3-0242ac110002','022a39cc-62aa-11ea-8bc3-0242ac110002'),('1396df29-6a97-11ea-a9ca-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('25b13bc6-6dd0-11ea-acd2-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('2716cace-61f8-11ea-8bc3-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('2e9eed1c-6dd0-11ea-acd2-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('35d3ab44-6dd0-11ea-acd2-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('3d20384e-6a96-11ea-a9ca-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('3f08dcc8-6dd0-11ea-acd2-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('5376d2ac-6dd0-11ea-acd2-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('5c5237a0-6a97-11ea-a9ca-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('6b6218bf-6dd0-11ea-acd2-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('7de6669e-6dd0-11ea-acd2-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('82fc7f0f-6aa2-11ea-a9ca-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('860cee79-91f0-11ea-b127-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('8e92fbe4-6dd0-11ea-acd2-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('a50ca477-6dd0-11ea-acd2-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('dfd93d0b-6a95-11ea-a9ca-0242ac110002','02391c16-62aa-11ea-8bc3-0242ac110002'),('1637bca5-6c35-11ea-acd2-0242ac110002','024da70d-62aa-11ea-8bc3-0242ac110002'),('2723a6d9-61f8-11ea-8bc3-0242ac110002','024da70d-62aa-11ea-8bc3-0242ac110002'),('588b3e57-6dd1-11ea-acd2-0242ac110002','024da70d-62aa-11ea-8bc3-0242ac110002'),('b335ed9e-6dd1-11ea-acd2-0242ac110002','024da70d-62aa-11ea-8bc3-0242ac110002'),('c4e1cf0b-61f6-11ea-8bc3-0242ac110002','024da70d-62aa-11ea-8bc3-0242ac110002'),('de18dfe8-6c36-11ea-acd2-0242ac110002','024da70d-62aa-11ea-8bc3-0242ac110002'),('fc149d66-6dcb-11ea-acd2-0242ac110002','024da70d-62aa-11ea-8bc3-0242ac110002');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-12  7:30:13
