/*CREATE  TABLE cinema.users (
  username VARCHAR(20) NOT NULL ,
  password VARCHAR(20) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
  
CREATE TABLE cinema.user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  role varchar(20) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES cinema.users (username));*/

INSERT INTO cinema.users(username,password,enabled) VALUES ('mantas@stud.kea.dk','mantas', true);
INSERT INTO cinema.users(username,password,enabled) VALUES ('thomas','thomas', true);

INSERT INTO cinema.user_roles (username, role) VALUES ('mantas@stud.kea.dk', 'ROLE_USER');
INSERT INTO cinema.user_roles (username, role) VALUES ('mantas@stud.kea.dk', 'ROLE_ADMIN');
INSERT INTO cinema.user_roles (username, role) VALUES ('thomas', 'ROLE_USER');