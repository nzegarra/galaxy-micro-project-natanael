INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('natanael', '$2a$10$wFMAW.CTAT527T1rGDBkOO669WVsHHaluB0NIYg1ZpjG4zQmrH.xS', 1, 'Natanael', 'Zegarra', 'nzegarra@gmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('carlos', '$2a$10$bpAKEo5jiws4uITorRKOSOMEB1qyQhGu6VNnSPCIgm.JlmDsyfmJK', 1, 'carlos', 'Carlos', 'carlos@gmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin', '$2a$10$NdgLstHPv8srqEv/oVnyhOMdwdDmnUM1Jzyi69IzyrIaN1Pvz3dO6', 1, 'Admin', 'Admin', 'admin@gmail.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1,1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1,2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2,1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (3,1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (3,2);