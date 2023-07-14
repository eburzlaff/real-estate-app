CREATE TABLE `property` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `address` varchar(200) DEFAULT NULL,
  `price` varchar(200) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `property_type` varchar(100) DEFAULT NULL,
  `availability_type` varchar(30) DEFAULT NULL,
  `bedroom_number` varchar(200) DEFAULT NULL,
  `bathroom_number` varchar(200) DEFAULT NULL,
  `image` longblob,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `saved_property` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(200) DEFAULT NULL,
  `price` varchar(200) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `property_type` varchar(100) DEFAULT NULL,
  `availability_type` varchar(30) DEFAULT NULL,
  `bedroom_number` varchar(200) DEFAULT NULL,
  `bathroom_number` varchar(200) DEFAULT NULL,
  `image` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `user_name` varchar(15) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_savedProperty` (
  `property_id` int NOT NULL,
  `user_saved_id` int NOT NULL,
  PRIMARY KEY (`property_id`,`user_saved_id`),
  KEY `user_saved_id_idx` (`user_saved_id`),
  CONSTRAINT `property_id` FOREIGN KEY (`property_id`) REFERENCES `saved_property` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_saved_id` FOREIGN KEY (`user_saved_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
