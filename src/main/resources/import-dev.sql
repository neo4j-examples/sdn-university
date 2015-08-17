#t_camera_info
insert into t_camera_info ( addr, capability, city, county, name, password, port, status, uri, username) values ( 'kxg701', 1, 'shenzhen', 'luohu', 'kxg701#001', 'introcks1234', 8000, 1, '192.168.2.64', 'admin');
#insert into t_camera_info ( addr, capability, city, county, name, password, port, status, uri, username) values ( 'gmds01', 2, 'shenzhe ', 'luohu', 'gmds1#001', 'introcks1234', 8000, 1, '192.168.2.64', 'admin');
 #t_video_info
 #t_picture_info

 #t_rule_info
 INSERT INTO t_rule_info(thresholds, rule_description, rule_name,types) VALUES('-200,20,50','testRuleDesc', 'testRule','0,1,2');
 # t_black_bank
 INSERT INTO t_black_bank ( bank_description, bank_name, bank_no)  VALUES ( 'testDesc', 'b_name_00','test_b_01');
 #t_black_detail
 #INSERT INTO t_black_detail ( bankId, black_description, face_feature, from_image_id, from_person_id, image_data) VALUES ( '1', 'desc', '89504E470','1','1','00001111');
 #t_face_info

 #t_alarm_info
INSERT INTO t_alarm_info ( black_id, confidence, face_id, id, level, status, task_id, time) VALUES ( '1', '-99', '1', '1', '0', '0','1' , '2015-08-12 10:15:11' );
 #t_server_info
INSERT INTO t_server_info ( server_addr, server_ip, server_name, server_peak, server_port, server_status) VALUES ( 'addr#1', '192.168.2.7', 'name#1', '1000' ,'80' ,'1'  );

#t_person_info
#INSERT INTO t_person_info_c ( create_face_id, gender, last_face_id, last_time, nick_name,created,updated) VALUES ( '1', '0', '1', '2015-07-24 15:09:16', 'nick_name#1','2000-01-01 00:00:00','2000-01-01 00:00:01' );

#t_task_info
#INSERT INTO t_task_info ( bank_id, created, rule_id, server_id, source_id, source_type, status, task_name, updated) VALUES ( '1', '2015-07-24 15:09:16', '1','0', '1','0' , '-1', 'task_name#1', '2015-07-24 15:09:17' );

#t_person_detail
INSERT INTO t_person_detail ( address, birthday, cid, created, nation, photo_id, real_gender, real_name, terminal_no, updated) VALUES ( 'address_0', '1999-07-24', '1', '2015-07-24 15:09:16', 'hanzu', '1', '0', 'real_name_0', '1', '2015-07-24 15:09:16' );
#t_image_info
INSERT INTO t_image_info ( face_uri, time, uri) VALUES ( 'http://192.168.2.28:8082/api/uploads/default_output_image.jpg', '2015-08-11 17:57:05', 'http://192.168.2.28:8082/api/uploads/default_output_image.jpg' );
