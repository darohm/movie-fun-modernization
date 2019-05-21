CREATE TABLE albums
(
  id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  year INT(11)              NOT NULL,
  rating INT(11)            NOT NULL,
  artist VARCHAR(255),
  title VARCHAR(255)
);
