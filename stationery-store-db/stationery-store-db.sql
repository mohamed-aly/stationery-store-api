CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON *.* TO 'admin'@'localhost';

DROP database IF EXISTS `stationery-store-db`;
CREATE database `stationery-store-db`;
use `stationery-store-db`;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `user`
(
    `id`            int(11) NOT NULL AUTO_INCREMENT,
    `user_type_id`  int(11) NOT NULL,
    `cart_id`       int(11)  Not NULL,
    `first_name`    varchar(128) DEFAULT NULL,
    `last_name`     varchar(45)  DEFAULT NULL,
    `email`         varchar(45)  DEFAULT NULL,
    `phone_number1` varchar(45)  DEFAULT NULL,
    `phone_number2` varchar(45)  DEFAULT NULL,
    `password`      varchar(45)  DEFAULT NULL,
    `token`         varchar(45)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `USER_EMAIL_UNIQUE` (`email`),
    CONSTRAINT `FK_USER_USER_TYPE` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_USER_CART` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE `address`
(
    `id`             int(11)     NOT NULL AUTO_INCREMENT,
    `user_id`        int(11)     NOT NULL,
    `building`       int(11)     NOT NULL,
    `apartment`      int(11)     NOT NULL,
    `street_details` varchar(45) NOT NULL,
    `city`           varchar(45) NOT NULL,
    `state`          varchar(45) NOT NULL,
    `special_marque` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_USER_ADDRESS` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE `user_type`
(
    `id`        int(11)     NOT NULL AUTO_INCREMENT,
    `user_type` varchar(45) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE `product`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT,
    `category_id` int(11)      NOT NULL,
    `name`        varchar(45)  NOT NULL,
    `description` varchar(250) NOT NULL,
    `min_stock`   int(11)      NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_CATEGORY_PRODUCT` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE `category`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT,
    `name`        varchar(128) NOT NULL,
    `image_url`   varchar(250) NOT NULL default 'https://blueskystores.com/wp-content/uploads/artist-group.jpg',
    `description` varchar(128) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE `product_images`
(
    `id`         int(11)      NOT NULL AUTO_INCREMENT,
    `product_id` int(11)      NOT NULL,
    `image_url`  varchar(250) NOT NULL default 'https://cdn.shopify.com/s/files/1/0046/3421/4518/products/Sailor-1911S-Fountain-pen---Transparent-Demo---Gold-Trim---14k-Nib.jpg?v=1562348464',
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_PRODUCT_PRODUCT_IMAGES` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE `offers`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `product_id` int(11) NOT NULL,
    `discount`   int(11) NOT NULL,
    `start_date` date    NOT NULL,
    `end_date`   date    NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_PRODUCT_OFFERS` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE `product_patch`
(
    `id`               int(11) NOT NULL AUTO_INCREMENT,
    `user_id`         int(11) NOT NULL,
    `product_id`       int(11) NOT NULL,
    `quantity`         int(11) NOT NULL,
    `purchasing_price` int(11) NOT NULL,
    `selling_price`    int(11) NOT NULL,
    `date_in`          date    NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_ADMIN_PRODUCT_PATCHES` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_PRODUCT_PRODUCT_PATCHES` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE `grade_level`
(
    `id`    int(11)     NOT NULL AUTO_INCREMENT,
    `level` varchar(45) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

CREATE TABLE `grade`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `grade_level`  int(11) NOT NULL,
    `grade_number` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_GRADE_LEVEL_GRADE` FOREIGN KEY (`grade_level`) REFERENCES `grade_level` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE `classified_product`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `grade_id`   int(11) NOT NULL,
    `product_id` int(11) NOT NULL,
    `quantity`   int(11) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_GRADE_CLASSIFIED_PRODUCT` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_PRODUCT_CLASSIFIED_PRODUCT` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE `order_status`
(
    `id`     int(11)     NOT NULL AUTO_INCREMENT,
    `status` varchar(45) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

CREATE TABLE `shipper`
(
    `id`            int(11)     NOT NULL AUTO_INCREMENT,
    `name`          varchar(45) NOT NULL,
    `phone_number`  varchar(45) NOT NULL,
    `shipping_fees` int(11)     NOT NULL,
    `status`        boolean     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

CREATE TABLE `orders`
(
    `id`                      int(11) NOT NULL AUTO_INCREMENT,
    `order_status_id`         int(11) NOT NULL,
    `shipper_id`              int(11) NOT NULL,
    `submit_date`             date    NOT NULL,
    `estimated_days`          int(11) NOT NULL,
    `delivery_date`           date    NOT NULL,
    `last_status_update_date` date    NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_ORDER_STATUS_ORDER` FOREIGN KEY (`order_status_id`) REFERENCES `order_status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_SHIPPER_ORDER` FOREIGN KEY (`shipper_id`) REFERENCES `shipper` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

CREATE TABLE `order_item`
(
    `id`                    int(11) NOT NULL AUTO_INCREMENT,
    `product_id`            int(11) NOT NULL,
    `classified_product_id` int(11) DEFAULT NULL,
    `order_id`              int(11) NOT NULL,
    `quantity`              int(11) NOT NULL,
    `price_per_unit`        int(11) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_PRODUCT_ORDER_ITEM` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_CLASSIFIED_PRODUCT_ORDER_ITEM` FOREIGN KEY (`classified_product_id`) REFERENCES `classified_product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_ORDER_ORDER_ITEM` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

CREATE TABLE `order_details`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `user_id`    int(11) NOT NULL,
    `order_id`   int(11) NOT NULL,
    `address_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_USER_ORDER_DETAILS` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_ORDER_ORDER_DETAILS` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_ ADDRESS_ORDER_DETAILS` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

CREATE TABLE `cart`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `last_update` date NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

CREATE TABLE `cart_item`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `product_id` int(11) NOT NULL,
    `cart_id`    int(11) NOT NULL,
    `quantity`   int(11) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_PRODUCT_CART_ITEM` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_CART_CART_ITEM` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;
