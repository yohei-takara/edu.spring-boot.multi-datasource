DROP TABLE IF EXISTS `human`;

CREATE TABLE `human` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT '',
  `age` int(3) DEFAULT 0,
  `sex` tinyint(1) DEFAULT TRUE,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;