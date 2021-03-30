import { User } from './models/user.model';

export const USERS: User[] = [
    { id: 1, username: 'Ron', userRole: 'Student', portfolio: { portfolio_id: 1, cash_value: 30, stock_value: 10, total_value: 300, 
        positions: [{position_id: 1, quantity: 12, stock_symbol: "AARP", portfolio_portfolio_id: 1, portfolio_id_fk: 1}]}, 
        game: {game_game_id:2, phase: 0, start_date: "04/30/2010"}},
    { id: 2, username: 'Ricardo', userRole: 'Student', portfolio: { portfolio_id: 1, cash_value: 30, stock_value: 10, total_value: 300, 
        positions: [{position_id: 1, quantity: 12, stock_symbol: "AARP", portfolio_portfolio_id: 1, portfolio_id_fk: 1}]}, 
        game: {game_game_id:2, phase: 0, start_date: "04/30/2010"}},
    { id: 3, username: 'Ramon', userRole: 'Student', portfolio: { portfolio_id: 1, cash_value: 30, stock_value: 10, total_value: 300, 
        positions: [{position_id: 1, quantity: 12, stock_symbol: "AARP", portfolio_portfolio_id: 1, portfolio_id_fk: 1}]}, 
        game: {game_game_id:2, phase: 0, start_date: "04/30/2010"}},
    { id: 4, username: 'Barry', userRole: 'Teacher', portfolio: { portfolio_id: 1, cash_value: 30, stock_value: 10, total_value: 300, 
        positions: [{position_id: 1, quantity: 12, stock_symbol: "AARP", portfolio_portfolio_id: 1, portfolio_id_fk: 1}]}, 
        game: {game_game_id:2, phase: 0, start_date: "04/30/2010"}},
    
 


]
