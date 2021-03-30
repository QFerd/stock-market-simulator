import { Portfolio } from './portfolio.model';
import { Game } from './game.model';

export interface User {

    id: number;
    username: string;
    userRole: string;
    portfolio: Portfolio;
    game: Game;
    //comment
    
    
}