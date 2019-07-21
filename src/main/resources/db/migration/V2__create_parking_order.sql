CREATE TABLE parking_order  (
  id int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
  name varchar(255),
  number varchar(255) NOT NULL,
  create_time varchar(255) NOT NULL,
  end_time varchar(255) NOT NULL,
  state int(1) UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (`name`) REFERENCES `parking_lot` (`name`)
)