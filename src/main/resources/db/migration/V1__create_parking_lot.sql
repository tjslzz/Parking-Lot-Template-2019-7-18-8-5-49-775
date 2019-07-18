CREATE TABLE parking_lot  (
  name varchar(255) NOT NULL,
  capacity int(255) UNSIGNED NOT NULL,
  position varchar(255) NOT NULL,
  PRIMARY KEY (name),
  UNIQUE INDEX name(name)
) 