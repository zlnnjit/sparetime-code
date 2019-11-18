USE test;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_role;
CREATE TABLE `user`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `name`     varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `sex`      int(11)      DEFAULT NULL,
    `des`      varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `user_role`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) DEFAULT NULL,
    `role_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;