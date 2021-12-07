-- POPULANDO chm.role
INSERT INTO chm.role(id, name) VALUES('7c12004d-e843-4e00-be40-01845ad75834', 'ROLE_USER');
INSERT INTO chm.role(id, name) VALUES('52c57a80-4e3b-4a41-a864-58d0cea25b14', 'ROLE_MODERATOR');
INSERT INTO chm.role(id, name) VALUES('8652ec73-0a53-433c-93be-420f1d90c681', 'ROLE_ADMIN');
INSERT INTO chm.role(id, name) VALUES('f63b534f-154b-498f-b424-8469948d2f78', 'ROLE_RECTIFIER');
INSERT INTO chm.role(id, name) VALUES('8cbfd8a2-db75-4bca-850b-d638a33701aa', 'ROLE_OPERATOR');

-- POPULANDO chm.user
INSERT INTO chm.user(id, created_at, updated_at, email, password, username) VALUES ('b4c48fe3-4cf2-411d-9d4b-82f7c63eff9c', NOW(), NOW(), 'marcelo.gadelha@marinha.mil.br', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', '00038059');
INSERT INTO chm.user(id, created_at, updated_at, email, password, username) VALUES ('f2199ebe-0306-4ade-943c-db708c418fae', NOW(), NOW(), 'thiago.gomes@marinha.mil.br', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', '14088185');
INSERT INTO chm.user(id, created_at, updated_at, email, password, username) VALUES ('e8b255ae-90cd-4d55-9561-9f85e7932c3d', NOW(), NOW(), 'jeferson.lessa@marinha.mil.br', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', '86768646');
INSERT INTO chm.user(id, created_at, updated_at, email, password, username) VALUES ('38108890-55b7-4b8c-80c0-f363b003083b', NOW(), NOW(), 'barreto.lopes@marinha.mil.br', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', '18090311');

-- POPULANDO chm.user_role
INSERT INTO chm.user_role(user_id, role_id) VALUES ('f2199ebe-0306-4ade-943c-db708c418fae', '8652ec73-0a53-433c-93be-420f1d90c681');
INSERT INTO chm.user_role(user_id, role_id) VALUES ('e8b255ae-90cd-4d55-9561-9f85e7932c3d', '8652ec73-0a53-433c-93be-420f1d90c681');
INSERT INTO chm.user_role(user_id, role_id) VALUES ('38108890-55b7-4b8c-80c0-f363b003083b', '8652ec73-0a53-433c-93be-420f1d90c681');
INSERT INTO chm.user_role(user_id, role_id) VALUES ('b4c48fe3-4cf2-411d-9d4b-82f7c63eff9c', '7c12004d-e843-4e00-be40-01845ad75834');