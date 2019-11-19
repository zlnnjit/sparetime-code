USE test;

DROP TABLE IF EXISTS orders;
CREATE TABLE orders
(
    id    BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name  VARCHAR(50)                                NOT NULL,
    piece double                                     NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4
  COLLATE utf8mb4_bin COMMENT ='端口表';