CREATE TABLE Item (
  id int NOT NULL AUTO_INCREMENT,
  itemName varchar(20) NOT NULL,
  itemDescription varchar(50) NOT NULL,
  itemType varchar(20) NOT NULL,
  itemPrice float NOT NULL,
  PRIMARY KEY (id)
);