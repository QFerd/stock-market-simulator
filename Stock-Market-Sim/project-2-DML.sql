insert into game_phases (phase_id, phase_name)
	values (0, 'No current game'),
			(1, 'Phase 1'),
			(2, 'Phase 2'),
			(3, 'Phase 3'),
			(4, 'Phase 4'),
			(5, 'Phase 5');
		
update game_phases 	
	set phase_name = 'Third Month' where phase_id = 3;

insert into user_roles (role_id, role_name)
	values (1, 'Teacher'),
			(2, 'Student');
		
insert into users (username, password, userrole_fk)
	values ('Teacher', 'tpw', 1),
			('Kyle', 'kpw', 2);

delete from users where user_id = 4;
			