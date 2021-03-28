
update portfolios
	set stock_value = 0 where portfolio_id = 1;


insert into game (game_id, start_date, phase)
	values (1, '2000-01', 1);

insert into portfolios (portfolio_id, cash_value, stock_value, total_value)
	values (1, 5, 0, 5);

insert into users (user_id, password, username, user_role, game_id_fk, game_game_id, portfolio_id)
	values (1, 'kpw', 'Kyle', 'Student', 1, 1, 1 );




insert into positions (position_id , quantity , stock_symbol , portfolio_portfolio_id, portfolio_id_fk)
	values (1, 5, 'appl', 1, 1);

update portfolios
	set stock_value = 0 where portfolio_id = 1;



drop table game;
			