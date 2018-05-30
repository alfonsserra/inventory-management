INSERT INTO app_role (id, role_name, description) VALUES (1, 'USER_ROLE', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_ROLE', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'Sharat', 'Chandler', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'user');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Mark', 'Reinhold', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'admin');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);