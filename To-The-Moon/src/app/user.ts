import { Portfolio } from './models/portfolio.model';
import { Game } from './models/game.model';

export interface User {
    user_id: number; 
    password: string; 
    user_role: string;
    username: string;
    game: Game; 
    portfolio: Portfolio;
    game_id_fk: number
}