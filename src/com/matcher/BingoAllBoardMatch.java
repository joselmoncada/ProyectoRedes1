package com.matcher;

import com.tile.ConstantTile;
import com.token.Cardinal;

public class BingoAllBoardMatch extends Match<Cardinal> {

    public BingoAllBoardMatch(Match<Cardinal> nextMatch) {
        this.nextMatch = nextMatch;
    }

    public boolean checkMatch(ConstantTile<Cardinal> initTile) {
        if (initTile != null) {
            ConstantTile<Cardinal> startTile;
            ConstantTile<Cardinal> currentTile;
            int cont = 0;
            for(startTile = initTile, cont = 0; startTile != null; startTile = startTile.getAdjacent(Cardinal.DOWN)) {
                for(currentTile = startTile; currentTile != null; currentTile = currentTile.getAdjacent(Cardinal.RIGHT))
                    if(currentTile.getValueOfProperty("isMatched") == "true")
                        cont += 1;
            }
            // Debug
            System.out.println("Match count:" +  cont);
            if(cont == 25)
                return true;
            else if(nextMatch != null)
                return nextMatch.checkMatch(initTile);
        }
        return false;
    }
}
