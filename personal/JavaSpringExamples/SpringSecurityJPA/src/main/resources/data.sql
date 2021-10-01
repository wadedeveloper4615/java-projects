SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `roles`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE IF NOT EXISTS  `roles` (
  `role_id` int NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
);

insert INTO `roles` VALUES (1,'ADMIN');