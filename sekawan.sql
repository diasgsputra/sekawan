-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               PostgreSQL 15.6, compiled by Visual C++ build 1937, 64-bit
-- Server OS:                    
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES  */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table public.sekawan
CREATE TABLE IF NOT EXISTS "sekawan" (
	"id" INTEGER NOT NULL,
	"username" TEXT NULL DEFAULT NULL,
	"email" TEXT NULL DEFAULT NULL,
	"name" TEXT NULL DEFAULT NULL,
	"phone" TEXT NULL DEFAULT NULL,
	"address" TEXT NULL DEFAULT NULL,
	"gender" TEXT NULL DEFAULT NULL,
	"occupation" TEXT NULL DEFAULT NULL,
	"status" TEXT NULL DEFAULT NULL,
	"citizen" TEXT NULL DEFAULT NULL,
	"document" TEXT NULL DEFAULT NULL,
	"video" TEXT NULL DEFAULT NULL,
	"image" TEXT NULL DEFAULT NULL,
	PRIMARY KEY ("id")
);

-- Dumping data for table public.sekawan: 2 rows
/*!40000 ALTER TABLE "sekawan" DISABLE KEYS */;
INSERT INTO "sekawan" ("id", "username", "email", "name", "phone", "address", "gender", "occupation", "status", "citizen", "document", "video", "image") VALUES
	(5, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, NULL, NULL),
	(6, 'bambang', 'bambang@bam.com', 'Bambang', '081808080', 'jalan mawar 15', 'male', 'developer', 'single', 'new zealand', 'D:\sekawan\file\DOCUMENT.docx', 'D:\sekawan\file\5 Second Video_ Watch the Milky Way Rise.mp4', 'D:\sekawan\file\tree-736885_640.jpg');
/*!40000 ALTER TABLE "sekawan" ENABLE KEYS */;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
