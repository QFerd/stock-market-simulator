import { Position } from './position.model'

export interface Portfolio{
    portfolioId:number;
    cashValue:number;
    stockValue:number;
    totalValue:number;

    positionList: Position[];

    
}