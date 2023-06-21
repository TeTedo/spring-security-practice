DROP TABLE IF EXISTS `member_roles`;
DROP TABLE IF EXISTS `member`;

CREATE TABLE `member`
(
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL
);

CREATE TABLE member_roles (
    member_id BIGINT,
    roles VARCHAR(255),
    FOREIGN KEY (member_id) REFERENCES member(id)
);
