DROP DATABASE np1;
CREATE DATABASE np1;

use np1;

CREATE TABLE IF NOT EXISTS posts (
	post_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS comments (
	comment_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    comment VARCHAR(255) NOT NULL,
    post_id BIGINT NOT NULL,
    FOREIGN KEY (post_id) REFERENCES posts(post_id)
);


DELIMITER $$

CREATE PROCEDURE InsertDummyData()
BEGIN
    DECLARE maxPost INT DEFAULT 11;
    DECLARE maxComment INT DEFAULT 11;
    
	DECLARE i INT DEFAULT 1;
    DECLARE j INT;

    -- 게시글 더미 데이터 삽입
    WHILE i <= maxPost DO
        INSERT INTO posts (title, content) VALUES (CONCAT('title', i), 'content for title');
        SET i = i + 1;
    END WHILE;
    
    SET i = 1;
    -- 댓글 더미 데이터 삽입
    WHILE i <= maxPost DO
        SET j = 1;
        WHILE j <= maxComment DO
            INSERT INTO comments (comment, post_id) VALUES (CONCAT('comment', j), i);
            SET j = j + 1;
        END WHILE;
        SET i = i + 1;
    END WHILE;
END$$

DELIMITER ;

CALL InsertDummyData();