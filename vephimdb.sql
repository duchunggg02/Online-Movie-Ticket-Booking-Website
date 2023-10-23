-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: vephimdb
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `chongoi`
--

DROP TABLE IF EXISTS `chongoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chongoi` (
  `ChoNgoiID` int NOT NULL AUTO_INCREMENT,
  `PhongChieuID` int NOT NULL,
  `SoGhe` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`ChoNgoiID`),
  KEY `PhongChieuID_idx` (`PhongChieuID`),
  CONSTRAINT `ChoNgoi-PhongChieu` FOREIGN KEY (`PhongChieuID`) REFERENCES `phongchieu` (`PhongChieuID`)
) ENGINE=InnoDB AUTO_INCREMENT=210 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chongoi`
--

LOCK TABLES `chongoi` WRITE;
/*!40000 ALTER TABLE `chongoi` DISABLE KEYS */;
INSERT INTO `chongoi` VALUES (88,11,'Ghe 1'),(89,11,'Ghe 2'),(90,11,'Ghe 3'),(91,11,'Ghe 4'),(92,11,'Ghe 5'),(93,11,'Ghe 6'),(94,11,'Ghe 7'),(95,11,'Ghe 8'),(96,11,'Ghe 9'),(97,11,'Ghe 10'),(98,11,'Ghe 11'),(99,11,'Ghe 12'),(100,11,'Ghe 13'),(101,11,'Ghe 14'),(102,11,'Ghe 15'),(103,11,'Ghe 16'),(104,11,'Ghe 17'),(105,11,'Ghe 18'),(106,11,'Ghe 19'),(107,11,'Ghe 20'),(108,11,'Ghe 21'),(109,11,'Ghe 22'),(110,11,'Ghe 23'),(111,11,'Ghe 24'),(112,11,'Ghe 25'),(113,11,'Ghe 26'),(114,11,'Ghe 27'),(115,11,'Ghe 28'),(116,11,'Ghe 29'),(117,11,'Ghe 30'),(118,11,'Ghe 31'),(119,11,'Ghe 32'),(120,11,'Ghe 33'),(121,11,'Ghe 34'),(122,11,'Ghe 35'),(123,11,'Ghe 36'),(124,11,'Ghe 37'),(125,11,'Ghe 38'),(126,11,'Ghe 39'),(127,11,'Ghe 40'),(128,11,'Ghe 41'),(129,11,'Ghe 42'),(130,11,'Ghe 43'),(131,11,'Ghe 44'),(132,11,'Ghe 45'),(133,11,'Ghe 46'),(134,11,'Ghe 47'),(135,11,'Ghe 48'),(136,11,'Ghe 49'),(137,11,'Ghe 50'),(138,12,'Ghe 1'),(139,12,'Ghe 2'),(140,13,'Ghe 1'),(141,13,'Ghe 2'),(142,13,'Ghe 3'),(143,13,'Ghe 4'),(144,13,'Ghe 5'),(145,13,'Ghe 6'),(146,13,'Ghe 7'),(147,13,'Ghe 8'),(148,13,'Ghe 9'),(149,13,'Ghe 10'),(150,13,'Ghe 11'),(151,13,'Ghe 12'),(152,13,'Ghe 13'),(153,13,'Ghe 14'),(154,13,'Ghe 15'),(155,13,'Ghe 16'),(156,13,'Ghe 17'),(157,13,'Ghe 18'),(158,13,'Ghe 19'),(159,13,'Ghe 20'),(160,14,'1'),(161,14,'2'),(162,14,'3'),(163,14,'4'),(164,14,'5'),(165,14,'6'),(166,14,'7'),(167,14,'8'),(168,14,'9'),(169,14,'10'),(170,14,'11'),(171,14,'12'),(172,14,'13'),(173,14,'14'),(174,14,'15'),(175,14,'16'),(176,14,'17'),(177,14,'18'),(178,14,'19'),(179,14,'20'),(180,14,'21'),(181,14,'22'),(182,14,'23'),(183,14,'24'),(184,14,'25'),(185,14,'26'),(186,14,'27'),(187,14,'28'),(188,14,'29'),(189,14,'30'),(190,14,'31'),(191,14,'32'),(192,14,'33'),(193,14,'34'),(194,14,'35'),(195,14,'36'),(196,14,'37'),(197,14,'38'),(198,14,'39'),(199,14,'40'),(200,14,'41'),(201,14,'42'),(202,14,'43'),(203,14,'44'),(204,14,'45'),(205,14,'46'),(206,14,'47'),(207,14,'48'),(208,14,'49'),(209,14,'50');
/*!40000 ALTER TABLE `chongoi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chongoi_suatchieu`
--

DROP TABLE IF EXISTS `chongoi_suatchieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chongoi_suatchieu` (
  `ChoNgoiSuatChieuID` int NOT NULL AUTO_INCREMENT,
  `ChoNgoiID` int NOT NULL,
  `SuatChieuID` int NOT NULL,
  `TrangThai` bit(1) NOT NULL,
  PRIMARY KEY (`ChoNgoiSuatChieuID`),
  KEY `ChoNgoi_idx` (`ChoNgoiID`),
  KEY `SuatChieu_idx` (`SuatChieuID`),
  CONSTRAINT `ChoNgoi` FOREIGN KEY (`ChoNgoiID`) REFERENCES `chongoi` (`ChoNgoiID`),
  CONSTRAINT `SuatChieu` FOREIGN KEY (`SuatChieuID`) REFERENCES `suatchieu` (`SuatChieuID`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chongoi_suatchieu`
--

LOCK TABLES `chongoi_suatchieu` WRITE;
/*!40000 ALTER TABLE `chongoi_suatchieu` DISABLE KEYS */;
INSERT INTO `chongoi_suatchieu` VALUES (77,88,11,_binary ''),(78,89,11,_binary ''),(79,90,11,_binary ''),(80,91,11,_binary ''),(81,92,11,_binary ''),(82,93,11,_binary ''),(83,94,11,_binary ''),(84,95,11,_binary ''),(85,96,11,_binary ''),(86,97,11,_binary ''),(87,98,11,_binary ''),(88,99,11,_binary ''),(89,100,11,_binary ''),(90,101,11,_binary ''),(91,102,11,_binary ''),(92,103,11,_binary ''),(93,104,11,_binary ''),(94,105,11,_binary ''),(95,106,11,_binary ''),(96,107,11,_binary ''),(97,108,11,_binary ''),(98,109,11,_binary ''),(99,110,11,_binary ''),(100,111,11,_binary ''),(101,112,11,_binary ''),(102,113,11,_binary ''),(103,114,11,_binary ''),(104,115,11,_binary ''),(105,116,11,_binary ''),(106,117,11,_binary ''),(107,118,11,_binary ''),(108,119,11,_binary ''),(109,120,11,_binary ''),(110,121,11,_binary ''),(111,122,11,_binary ''),(112,123,11,_binary ''),(113,124,11,_binary ''),(114,125,11,_binary ''),(115,126,11,_binary ''),(116,127,11,_binary ''),(117,128,11,_binary ''),(118,129,11,_binary ''),(119,130,11,_binary ''),(120,131,11,_binary ''),(121,132,11,_binary ''),(122,133,11,_binary ''),(123,134,11,_binary ''),(124,135,11,_binary ''),(125,136,11,_binary ''),(126,137,11,_binary ''),(129,140,13,_binary ''),(130,141,13,_binary ''),(131,142,13,_binary ''),(132,143,13,_binary '\0'),(133,144,13,_binary ''),(134,145,13,_binary ''),(135,146,13,_binary ''),(136,147,13,_binary ''),(137,148,13,_binary '\0'),(138,149,13,_binary ''),(139,150,13,_binary ''),(140,151,13,_binary ''),(141,152,13,_binary ''),(142,153,13,_binary ''),(143,154,13,_binary ''),(144,155,13,_binary ''),(145,156,13,_binary ''),(146,157,13,_binary ''),(147,158,13,_binary ''),(148,159,13,_binary ''),(149,140,14,_binary '\0'),(150,141,14,_binary '\0'),(151,142,14,_binary '\0'),(152,143,14,_binary '\0'),(153,144,14,_binary '\0'),(154,145,14,_binary '\0'),(155,146,14,_binary '\0'),(156,147,14,_binary '\0'),(157,148,14,_binary '\0'),(158,149,14,_binary '\0'),(159,150,14,_binary '\0'),(160,151,14,_binary '\0'),(161,152,14,_binary '\0'),(162,153,14,_binary '\0'),(163,154,14,_binary '\0'),(164,155,14,_binary '\0'),(165,156,14,_binary '\0'),(166,157,14,_binary '\0'),(167,158,14,_binary '\0'),(168,159,14,_binary '\0'),(169,138,15,_binary '\0'),(170,139,15,_binary ''),(171,88,16,_binary ''),(172,89,16,_binary '\0'),(173,90,16,_binary ''),(174,91,16,_binary ''),(175,92,16,_binary ''),(176,93,16,_binary ''),(177,94,16,_binary ''),(178,95,16,_binary ''),(179,96,16,_binary ''),(180,97,16,_binary ''),(181,98,16,_binary ''),(182,99,16,_binary '\0'),(183,100,16,_binary '\0'),(184,101,16,_binary '\0'),(185,102,16,_binary '\0'),(186,103,16,_binary '\0'),(187,104,16,_binary '\0'),(188,105,16,_binary '\0'),(189,106,16,_binary '\0'),(190,107,16,_binary '\0'),(191,108,16,_binary '\0'),(192,109,16,_binary '\0'),(193,110,16,_binary '\0'),(194,111,16,_binary '\0'),(195,112,16,_binary '\0'),(196,113,16,_binary '\0'),(197,114,16,_binary '\0'),(198,115,16,_binary '\0'),(199,116,16,_binary '\0'),(200,117,16,_binary ''),(201,118,16,_binary ''),(202,119,16,_binary ''),(203,120,16,_binary ''),(204,121,16,_binary ''),(205,122,16,_binary '\0'),(206,123,16,_binary '\0'),(207,124,16,_binary '\0'),(208,125,16,_binary ''),(209,126,16,_binary ''),(210,127,16,_binary '\0'),(211,128,16,_binary '\0'),(212,129,16,_binary '\0'),(213,130,16,_binary ''),(214,131,16,_binary ''),(215,132,16,_binary '\0'),(216,133,16,_binary '\0'),(217,134,16,_binary '\0'),(218,135,16,_binary '\0'),(219,136,16,_binary '\0'),(220,137,16,_binary '\0'),(221,140,17,_binary ''),(222,141,17,_binary ''),(223,142,17,_binary ''),(224,143,17,_binary '\0'),(225,144,17,_binary '\0'),(226,145,17,_binary '\0'),(227,146,17,_binary '\0'),(228,147,17,_binary '\0'),(229,148,17,_binary '\0'),(230,149,17,_binary '\0'),(231,150,17,_binary '\0'),(232,151,17,_binary ''),(233,152,17,_binary '\0'),(234,153,17,_binary '\0'),(235,154,17,_binary '\0'),(236,155,17,_binary '\0'),(237,156,17,_binary '\0'),(238,157,17,_binary '\0'),(239,158,17,_binary '\0'),(240,159,17,_binary '');
/*!40000 ALTER TABLE `chongoi_suatchieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chongoi_ve`
--

DROP TABLE IF EXISTS `chongoi_ve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chongoi_ve` (
  `ChoNgoiVeID` int NOT NULL AUTO_INCREMENT,
  `VeID` int NOT NULL,
  `ChoNgoiSuatChieuID` int NOT NULL,
  PRIMARY KEY (`ChoNgoiVeID`),
  KEY `Ve-Ve_idx` (`VeID`),
  KEY `ChoNgoi_idx` (`ChoNgoiSuatChieuID`),
  CONSTRAINT `seat-seat` FOREIGN KEY (`ChoNgoiSuatChieuID`) REFERENCES `chongoi_suatchieu` (`ChoNgoiSuatChieuID`),
  CONSTRAINT `ve-ve` FOREIGN KEY (`VeID`) REFERENCES `ve` (`VeID`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chongoi_ve`
--

LOCK TABLES `chongoi_ve` WRITE;
/*!40000 ALTER TABLE `chongoi_ve` DISABLE KEYS */;
INSERT INTO `chongoi_ve` VALUES (11,17,130),(14,20,149),(15,20,168),(86,60,171),(88,62,173),(89,62,174),(92,78,221),(93,78,222),(94,79,223),(95,81,232),(96,82,240),(97,83,170),(100,85,109),(101,86,110),(102,89,99),(103,90,108),(104,92,100),(105,93,100),(106,94,140),(107,94,141),(108,95,142),(109,96,143),(110,97,144),(111,98,145),(112,99,146),(113,99,147),(114,99,148),(115,100,129),(116,101,130),(117,103,175),(118,103,176),(119,104,200),(120,105,201),(121,106,202),(122,107,203),(123,108,204),(130,113,213),(131,113,214),(132,114,177),(133,114,178),(134,114,179),(135,114,180),(136,114,181),(137,115,133),(138,115,135),(139,115,134),(140,115,136),(141,116,131);
/*!40000 ALTER TABLE `chongoi_ve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoidung`
--

DROP TABLE IF EXISTS `nguoidung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoidung` (
  `NguoiDungID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `Ho` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `Ten` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `HinhDaiDien` varchar(200) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `VaiTroID` int NOT NULL,
  PRIMARY KEY (`NguoiDungID`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `VaiTroID_idx` (`VaiTroID`),
  CONSTRAINT `NguoiDung-VaiTro` FOREIGN KEY (`VaiTroID`) REFERENCES `vaitro` (`VaiTroID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoidung`
--

LOCK TABLES `nguoidung` WRITE;
/*!40000 ALTER TABLE `nguoidung` DISABLE KEYS */;
INSERT INTO `nguoidung` VALUES (1,'admin','$2a$10$9YACvGo72kGHaOZ4Ob8Mn.FCfJQD1idqXFDtypNmWhC9K96kMp.eC','Nguyễn Đức','Hưng','https://res.cloudinary.com/dluqeqfiv/image/upload/v1693920714/jpl0n1scwwcoxmuog4hx.png',1),(2,'user01','$2a$10$9YACvGo72kGHaOZ4Ob8Mn.FCfJQD1idqXFDtypNmWhC9K96kMp.eC','Nguyễn Đức','Hưng','https://res.cloudinary.com/dluqeqfiv/image/upload/v1695976791/tox29stcun5oidiizabs.png',2),(3,'user02','$2a$10$F.xSpCwX2lOM7V5By9Iu6OISkXnI/ZIMcfAHsqcIqjrNSCzax7ACW','Nguyễn Đức','Hưng','https://res.cloudinary.com/dluqeqfiv/image/upload/v1694863616/bwl37ylhcq8myhihsj5t.png',2),(4,'user03','$2a$10$Fb.KicJcPft3QgUJONphHevW2QZvMbV31IcOU/MCiQRzhjfkPkuOu','Nguyễn Đức','Hưng','https://res.cloudinary.com/dluqeqfiv/image/upload/v1695124762/quvbe66cxxautq9jvrr6.png',2),(5,'user04','$2a$10$B0m7IehgK9BPFN2xQThI/OsfMkdDtfMq16ot1.TPZtMfyzXcK2Vgq','Nguyễn Đức','Hưng','https://res.cloudinary.com/dluqeqfiv/image/upload/v1695127550/xscfud5xuqadkynyw0eq.png',2);
/*!40000 ALTER TABLE `nguoidung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phanhoi`
--

DROP TABLE IF EXISTS `phanhoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phanhoi` (
  `PhanHoiID` int NOT NULL AUTO_INCREMENT,
  `NoiDung` varchar(200) COLLATE utf8mb3_unicode_ci NOT NULL,
  `NgayTao` datetime NOT NULL,
  `VeID` int NOT NULL,
  PRIMARY KEY (`PhanHoiID`),
  KEY `VeID_idx` (`VeID`),
  CONSTRAINT `PhanHoi-Ve` FOREIGN KEY (`VeID`) REFERENCES `ve` (`VeID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phanhoi`
--

LOCK TABLES `phanhoi` WRITE;
/*!40000 ALTER TABLE `phanhoi` DISABLE KEYS */;
INSERT INTO `phanhoi` VALUES (5,'hay quá','2023-10-23 00:00:00',17),(6,'hay','2023-09-27 17:00:00',17),(7,'rất hay','2023-10-23 00:00:00',17),(8,'tuyệt vời','2023-10-23 00:00:00',64),(9,'very good','2023-10-23 00:00:00',64),(10,'hay lắm','2023-10-23 00:00:00',64);
/*!40000 ALTER TABLE `phanhoi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phim`
--

DROP TABLE IF EXISTS `phim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phim` (
  `PhimID` int NOT NULL AUTO_INCREMENT,
  `TenPhim` varchar(200) COLLATE utf8mb3_unicode_ci NOT NULL,
  `MoTa` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `NgayPhatHanh` date NOT NULL,
  `ThoiLuong` varchar(200) COLLATE utf8mb3_unicode_ci NOT NULL,
  `AnhPhim` varchar(200) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`PhimID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phim`
--

LOCK TABLES `phim` WRITE;
/*!40000 ALTER TABLE `phim` DISABLE KEYS */;
INSERT INTO `phim` VALUES (4,'Quỷ Ám: Tín Đồ','Kể từ cái chết của người vợ đang mang thai trong trận động đất ở Haiti 12 năm trước.','2023-10-06','111 phút','https://res.cloudinary.com/dluqeqfiv/image/upload/v1697990240/tusx9kh4yrbuv41xh4eh.webp'),(6,'Kumanthong: Quỷ Linh Nhi','Ging đưa con trai đi nghỉ mát ở căn nhà gỗ nằm giữa rừng cây. Tuy nhiên, cậu bé đã bị bắt cóc vào lúc nửa đêm.','2023-10-05','88 phút','https://res.cloudinary.com/dluqeqfiv/image/upload/v1697990522/xgblugar79mpwlze9col.webp'),(7,'Con Nhót Mót Chồng','Lấy cảm hứng từ web drama Chuyện Xóm Tui, phiên bản điện ảnh sẽ mang một màu sắc hoàn toàn khác: hài hước hơn, gần gũi và nhiều cảm xúc hơn.','2023-04-21','112 phút','https://res.cloudinary.com/dluqeqfiv/image/upload/v1697990658/nz7yqmhhfawkde4vzsix.webp'),(8,'Wolfoo Và Hòn Đảo Kỳ Bí','Câu chuyện xoanh quanh nhân vật chính là chú sói nhỏ Wolfoo 8 tuổi - một chú bé vui vẻ, tốt bụng và yêu thích sự khám phá.','2023-10-13','100 phút','https://res.cloudinary.com/dluqeqfiv/image/upload/v1697990764/qbamtauqd750aikfqpw9.webp'),(9,'Bến Phà Xác Sống','Là phần tiếp theo Cù Lao Xác Sống, Bến Phà Xác Sống tiết lộ hành trình mới về cuộc tháo chạy của Công và những người bạn khỏi sự tấn công của đại dịch Zombie.','2023-09-01','83 phút','https://res.cloudinary.com/dluqeqfiv/image/upload/v1697990850/rdjb5duetm3reqo5cfxm.webp'),(12,'Vầng Trăng Máu','Nội Dung Phim Bộ phim dựa trên cuốn sách bán chạy và được ca ngợi rộng rãi Killers of the Flower Moon: The Osage Murders and the Birth of the FBI.','2023-10-20','206 phút','https://res.cloudinary.com/dluqeqfiv/image/upload/v1697990955/jna6axka9indbythu9ny.webp'),(13,'Năm Đêm Kinh Hoàng','Bộ phim kể về một nhân viên bảo vệ gặp rắc rối khi anh bắt đầu làm việc tại Freddy Fazbear\'s Pizza.','2023-10-27','110 phút','https://res.cloudinary.com/dluqeqfiv/image/upload/v1697991018/cbdmsdkmjvw9fpbshep6.webp'),(15,'Những Nàng Tôm Lấp Lánh','The Shiny Shrimps kể về Matthias Le Goff - một nhà vô địch bơi lội thế giới.','2023-10-28','100 phút','https://res.cloudinary.com/dluqeqfiv/image/upload/v1697991101/onm1t6ivomvo3gbebh9u.webp');
/*!40000 ALTER TABLE `phim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phongchieu`
--

DROP TABLE IF EXISTS `phongchieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phongchieu` (
  `PhongChieuID` int NOT NULL AUTO_INCREMENT,
  `TenPhongChieu` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `SoLuongGhe` int NOT NULL,
  `RapPhimID` int NOT NULL,
  PRIMARY KEY (`PhongChieuID`),
  KEY `RapPhimID_idx` (`RapPhimID`),
  CONSTRAINT `PhongChieu-RapPhim` FOREIGN KEY (`RapPhimID`) REFERENCES `rapphim` (`RapPhimID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phongchieu`
--

LOCK TABLES `phongchieu` WRITE;
/*!40000 ALTER TABLE `phongchieu` DISABLE KEYS */;
INSERT INTO `phongchieu` VALUES (11,'Phòng chiếu A',50,1),(12,'Phòng chiếu A',2,3),(13,'Phòng chiếu B',20,1),(14,'Phòng chiếu B',50,3);
/*!40000 ALTER TABLE `phongchieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rapphim`
--

DROP TABLE IF EXISTS `rapphim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rapphim` (
  `RapPhimID` int NOT NULL AUTO_INCREMENT,
  `TenRapPhim` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `DiaChi` varchar(200) COLLATE utf8mb3_unicode_ci NOT NULL,
  `AnhRap` varchar(200) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`RapPhimID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rapphim`
--

LOCK TABLES `rapphim` WRITE;
/*!40000 ALTER TABLE `rapphim` DISABLE KEYS */;
INSERT INTO `rapphim` VALUES (1,'CGV Cinemas','123','https://res.cloudinary.com/dluqeqfiv/image/upload/v1693560838/xziiqdj2c7efhtj6lsnd.jpg'),(2,'Galaxy Cinema','cute1','https://res.cloudinary.com/dluqeqfiv/image/upload/v1693572810/zwoujfnvc8oeovhw9nt8.jpg'),(3,'Lotte Cinema','d','https://res.cloudinary.com/dluqeqfiv/image/upload/v1694087445/puxyvqe8c5cnazjztyku.png');
/*!40000 ALTER TABLE `rapphim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suatchieu`
--

DROP TABLE IF EXISTS `suatchieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suatchieu` (
  `SuatChieuID` int NOT NULL AUTO_INCREMENT,
  `PhimID` int NOT NULL,
  `PhongChieuID` int NOT NULL,
  `NgayChieu` date NOT NULL,
  `GioChieu` time NOT NULL,
  `GiaTien` int NOT NULL,
  PRIMARY KEY (`SuatChieuID`),
  KEY `PhongChieuID_idx` (`PhongChieuID`),
  KEY `PhimID_idx` (`PhimID`),
  CONSTRAINT `SuatChieu-Phim` FOREIGN KEY (`PhimID`) REFERENCES `phim` (`PhimID`),
  CONSTRAINT `SuatChieu-PhongChieu` FOREIGN KEY (`PhongChieuID`) REFERENCES `phongchieu` (`PhongChieuID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suatchieu`
--

LOCK TABLES `suatchieu` WRITE;
/*!40000 ALTER TABLE `suatchieu` DISABLE KEYS */;
INSERT INTO `suatchieu` VALUES (11,4,11,'2023-09-09','18:00:00',55),(13,4,13,'2023-09-25','18:00:00',9),(14,4,13,'2023-09-04','20:20:00',0),(15,9,12,'2023-09-30','20:20:00',9),(16,9,11,'2023-10-12','21:00:00',500000),(17,13,13,'2023-09-30','20:20:00',9);
/*!40000 ALTER TABLE `suatchieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaitro`
--

DROP TABLE IF EXISTS `vaitro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaitro` (
  `VaiTroID` int NOT NULL AUTO_INCREMENT,
  `TenVaiTro` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`VaiTroID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaitro`
--

LOCK TABLES `vaitro` WRITE;
/*!40000 ALTER TABLE `vaitro` DISABLE KEYS */;
INSERT INTO `vaitro` VALUES (1,'Admin'),(2,'User');
/*!40000 ALTER TABLE `vaitro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ve`
--

DROP TABLE IF EXISTS `ve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ve` (
  `VeID` int NOT NULL AUTO_INCREMENT,
  `NguoiDungID` int NOT NULL,
  `SuatChieuID` int NOT NULL,
  `NgayDat` date NOT NULL,
  `PhuongThucThanhToan` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TinhTrang` bit(1) NOT NULL,
  `Gia` int NOT NULL,
  PRIMARY KEY (`VeID`),
  KEY `Ve-NguoiDung_idx` (`NguoiDungID`),
  KEY `Ve-SuatChieu_idx` (`SuatChieuID`),
  CONSTRAINT `Ve-NguoiDung` FOREIGN KEY (`NguoiDungID`) REFERENCES `nguoidung` (`NguoiDungID`),
  CONSTRAINT `Ve-SuatChieu` FOREIGN KEY (`SuatChieuID`) REFERENCES `suatchieu` (`SuatChieuID`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ve`
--

LOCK TABLES `ve` WRITE;
/*!40000 ALTER TABLE `ve` DISABLE KEYS */;
INSERT INTO `ve` VALUES (17,1,13,'2020-02-02','tiền',_binary '\0',0),(20,1,14,'2023-09-09','momo',_binary '\0',0),(60,1,16,'2020-02-02','tiền',_binary '\0',0),(62,1,16,'2023-09-09','tiền',_binary '\0',0),(64,2,11,'2023-09-20','Tiền',_binary '',0),(65,2,11,'2023-09-20','Tiền',_binary '',0),(66,2,11,'2023-09-20','Tiền',_binary '',0),(67,2,11,'2023-09-20','Tiền',_binary '',0),(68,2,11,'2023-09-20','Tiền',_binary '',0),(69,2,11,'2023-09-20','Tiền',_binary '',0),(70,2,11,'2023-09-20','Tiền',_binary '',0),(71,2,11,'2023-09-20','Tiền',_binary '',0),(72,2,13,'2023-09-20','Tiền',_binary '',0),(73,2,15,'2023-09-20','Tiền',_binary '',0),(75,2,16,'2023-09-22','Tiền',_binary '',0),(76,2,16,'2023-09-22','Tiền',_binary '',0),(77,1,11,'2023-09-22','Tiền',_binary '',0),(78,1,17,'2023-09-23','Tiền',_binary '',0),(79,1,17,'2023-09-23','Tiền',_binary '',0),(81,1,17,'2023-09-23','Tiền',_binary '',0),(82,1,17,'2023-09-23','Tiền',_binary '',0),(83,1,15,'2023-09-23','Tiền',_binary '',0),(85,2,11,'2023-09-29','Tiền',_binary '',0),(86,1,11,'2023-10-05','Tiền',_binary '',0),(87,1,11,'2023-10-05','Tiền',_binary '',0),(88,1,11,'2023-10-05','Tiền',_binary '',0),(89,1,11,'2023-10-05','Tiền',_binary '',0),(90,1,11,'2023-10-05','Tiền',_binary '',0),(91,1,13,'2023-10-05','Tiền',_binary '',0),(92,1,11,'2023-10-06','Tiền',_binary '',0),(93,1,11,'2023-10-06','Tiền',_binary '',0),(94,1,13,'2023-10-06','Tiền',_binary '',0),(95,1,13,'2023-10-06','Tiền',_binary '',0),(96,1,13,'2023-10-06','Tiền',_binary '',0),(97,1,13,'2023-10-06','Tiền',_binary '',0),(98,1,13,'2023-10-06','Tiền',_binary '',0),(99,1,13,'2023-10-06','Tiền',_binary '',0),(100,1,13,'2023-10-06','Tiền',_binary '',0),(101,1,13,'2023-10-06','Tiền',_binary '',0),(102,1,13,'2023-10-06','Tiền',_binary '',0),(103,1,16,'2023-10-07','momo',_binary '\0',0),(104,1,16,'2023-10-07','momo',_binary '\0',0),(105,1,16,'2023-10-07','momo',_binary '\0',0),(106,1,16,'2023-10-07','momo',_binary '\0',0),(107,1,16,'2023-10-07','momo',_binary '\0',0),(108,1,16,'2023-10-07','momo',_binary '\0',0),(113,1,16,'2023-10-07','Tiền',_binary '',1000000),(114,1,16,'2023-10-07','Tiền',_binary '',2500000),(115,1,13,'2023-10-22','Tiền',_binary '',36),(116,2,13,'2023-10-23','Tiền',_binary '',9);
/*!40000 ALTER TABLE `ve` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-23 21:44:11
