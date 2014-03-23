CREATE TABLE tm_user(
   user_id 		   NUMBER NOT NULL,
   user_email      VARCHAR(255) NOT NULL,
   user_full_name  VARCHAR(255),
   user_password   VARCHAR(255),
   user_group_id   NUMBER NOT NULL,
   user_enabled    NUMBER,
   user_account_non_expired     NUMBER,
   user_credentials_non_expired NUMBER,
   user_not_pending_activation  NUMBER,
   user_account_non_locked      NUMBER,
   PRIMARY KEY (user_id)
);

CREATE TABLE user_groups
(
  user_group_id   NUMBER NOT NULL,
  user_group_name VARCHAR(255) NOT NULL,
  version NUMBER NOT NULL,
  PRIMARY KEY (user_group_id)
);


CREATE TABLE user_ticket(
	user_id NUMBER,
	ticket_id NUMBER,
	PRIMARY KEY (user_id,ticket_id)
);

CREATE TABLE ticket(
	id NUMBER NOT NULL,
	summary VARCHAR2(2000),
	description VARCHAR2(4000),
	priority VARCHAR2(20),
	status VARCHAR2(40),
	assigned CHAR,
	PRIMARY KEY (ticket_id)
);


--UserGroups
INSERT INTO user_groups(user_group_id,user_group_name) VALUES(1,'USER_GROUP');
INSERT INTO user_groups(user_group_id,user_group_name) VALUES(2,'ADMIN_USER_GROUP');

--Users only for testing
INSERT INTO tm_user(user_id,user_email,user_password,user_group_id) VALUES(1,'user@tm.com','1234ABCD',(SELECT USER_GROUP_ID FROM USER_GROUPS WHERE USER_GROUP_NAME='USER_GROUP'));
INSERT INTO tm_user(user_id,user_email,user_password,user_group_id) VALUES(2,'admin@tm.com','1234ABCD',(SELECT USER_GROUP_ID FROM USER_GROUPS WHERE USER_GROUP_NAME='ADMIN_USER_GROUP'));

