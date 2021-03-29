import { Position } from './position.model'

export interface Portfolio{
    portfolio_id:number;
    cash_value:number;
    stock_value:number;
    total_value:number;
    positions: Position[];
    
}