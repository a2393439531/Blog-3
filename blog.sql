CREATE TABLE user
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(32) NOT NULL COMMENT '用户名称',
    birthday DATE COMMENT '生日',
    sex CHAR(15) COMMENT '性别',
    address VARCHAR(256) COMMENT '地址',
    password VARCHAR(50) NOT NULL
);
CREATE TABLE article
(
    art_id INT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT(20) NOT NULL,
    title VARCHAR(255),
    summary TEXT,
    publish_date DATE,
    cat_id INT(20),
    CONSTRAINT art_user FOREIGN KEY (user_id) REFERENCES user (id)
);
CREATE INDEX art_cat ON article (cat_id);
CREATE INDEX art_user ON article (user_id);
CREATE TABLE article_detail
(
    art_de_id INT(20) PRIMARY KEY NOT NULL,
    content LONGTEXT,
    article_click INT(20),
    CONSTRAINT artde_art FOREIGN KEY (art_de_id) REFERENCES article (art_id)
);
CREATE TABLE cateory
(
    cat_id INT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cat_name VARCHAR(255)
);
CREATE UNIQUE INDEX cateory_cat_id_uindex ON cateory (cat_id);
CREATE TABLE photo
(
    pho_id INT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    art_id INT(20) NOT NULL,
    img_url VARCHAR(255),
    img_des TEXT,
    CONSTRAINT pho_art FOREIGN KEY (art_id) REFERENCES article (art_id)
);
CREATE INDEX pho_art ON photo (art_id);
CREATE TABLE tag
(
    tag_id INT(20) NOT NULL AUTO_INCREMENT,
    art_id INT(20) NOT NULL,
    tag_name VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (tag_id, art_id),
    CONSTRAINT tag_art FOREIGN KEY (art_id) REFERENCES article (art_id)
);
CREATE INDEX tag_art ON tag (art_id);