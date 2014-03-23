CREATE TABLE tm_user(
   user_id 		   INT NOT NULL AUTO_INCREMENT,
   user_email      VARCHAR(255) NOT NULL,
   user_fullName  VARCHAR(255),
   user_password   VARCHAR(255),
   user_group_id   INT NOT NULL,
   created_by INT,
   updated_by INT,
   created_on TIMESTAMP,
   updated_on TIMESTAMP,
   version INT NOT NULL DEFAULT 0,
   PRIMARY KEY (user_id)
);

CREATE TABLE user_groups
(
  user_group_id   INT NOT NULL,
  user_group_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_group_id)
);


CREATE TABLE ticket(
	ticket_id INT NOT NULL AUTO_INCREMENT,
	user_id INT,
	summary VARCHAR(2000),
	description VARCHAR(4000),
	comments TEXT,
	priority VARCHAR(20),
	status VARCHAR(20),
	assigned VARCHAR(20),
	created_by INT,
    updated_by INT,
    created_on TIMESTAMP,
    updated_on TIMESTAMP,
    version INT NOT NULL DEFAULT 0,
	PRIMARY KEY (ticket_id)
);


--UserGroups
INSERT INTO user_groups(user_group_id,user_group_name) VALUES(1,'USER');
INSERT INTO user_groups(user_group_id,user_group_name) VALUES(2,'ADMIN');
INSERT INTO user_groups(user_group_id,user_group_name) VALUES(3,'ASSIGNEE');

--Users only for testing
INSERT INTO tm_user(user_email,user_password,user_group_id) VALUES('user@tm.com','1234',(SELECT USER_GROUP_ID FROM USER_GROUPS WHERE USER_GROUP_NAME='USER'));
INSERT INTO tm_user(user_email,user_password,user_group_id) VALUES('admin@tm.com','1234',(SELECT USER_GROUP_ID FROM USER_GROUPS WHERE USER_GROUP_NAME='ADMIN'));
INSERT INTO tm_user(user_email,user_password,user_group_id) VALUES('assignee@tm.com','1234',(SELECT USER_GROUP_ID FROM USER_GROUPS WHERE USER_GROUP_NAME='ASSIGNEE'));

