SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS dingdan;
DROP TABLE IF EXISTS shopcar;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS wine;




/* Create Tables */

CREATE TABLE comments
(
	-- 评论id
	com_id int NOT NULL AUTO_INCREMENT COMMENT '评论id',
	user_id int NOT NULL,
	wine_id int NOT NULL,
	-- 0 好评
	-- 1 中评
	-- 2 差评
	state int DEFAULT 0,
	content text,
	PRIMARY KEY (com_id)
);


CREATE TABLE dingdan
(
	dd_id int NOT NULL AUTO_INCREMENT,
	user_id int NOT NULL,
	-- 把所有商品id都添加用";"分割.例：002;092
	wines_ids varchar(99) NOT NULL COMMENT '把所有商品id都添加用";"分割.例：002;092',
	-- 0 待发货
	-- 1 快递中
	-- 2 已送达
	state int DEFAULT 0 NOT NULL ,
	-- 购买数量
	number int DEFAULT 1 NOT NULL COMMENT '购买数量',
	-- 总价格
	prices float NOT NULL COMMENT '总价格',
	PRIMARY KEY (dd_id)
);


CREATE TABLE shopcar
(
	car_id int NOT NULL AUTO_INCREMENT,
	user_id int NOT NULL,
	wine_id int NOT NULL,
	-- 购物车商品数量
	number int DEFAULT 1 NOT NULL COMMENT '购物车商品数量',
	PRIMARY KEY (car_id)
);


CREATE TABLE users
(
	user_id int NOT NULL AUTO_INCREMENT,
	user_name varchar(20) NOT NULL,
	password varchar(99) NOT NULL,
	-- 省
	province varchar(20) COMMENT '省',
	-- 市
	city varchar(20) COMMENT '市',
	phone int(11),
	picture varchar(99),
	PRIMARY KEY (user_id),
	UNIQUE (user_name)
);


CREATE TABLE wine
(
	wine_id int NOT NULL AUTO_INCREMENT,
	wine_name varchar(20) NOT NULL,
	kind varchar(20) NOT NULL,
	price float NOT NULL,
	detail text,
	-- 封面大图
	picture varchar(99) NOT NULL COMMENT '封面大图',
	-- 剩下四张图
	picture4 varchar(99) COMMENT '剩下四张图',
	PRIMARY KEY (wine_id)
);



/* Create Foreign Keys */

ALTER TABLE comments
	ADD FOREIGN KEY (user_id)
	REFERENCES users (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE dingdan
	ADD FOREIGN KEY (user_id)
	REFERENCES users (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE shopcar
	ADD FOREIGN KEY (user_id)
	REFERENCES users (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE comments
	ADD FOREIGN KEY (wine_id)
	REFERENCES wine (wine_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE shopcar
	ADD FOREIGN KEY (wine_id)
	REFERENCES wine (wine_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



