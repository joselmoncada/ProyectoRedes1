package com.matcher;

import com.tile.ConstantTile;
import com.token.Cardinal;

public class BingoLinearMatch extends Match<Cardinal> {

    public BingoLinearMatch(Match<Cardinal> nextMatch) {
        this.nextMatch = nextMatch;
    }

    private boolean linearCheck(ConstantTile<Cardinal> initTile, Cardinal first, Cardinal second) {
        ConstantTile<Cardinal> startTile;
        ConstantTile<Cardinal> currentTile;
        int cont = 0;

        for(startTile = initTile, cont = 0; startTile != null; cont = 0, startTile = startTile.getAdjacent(first)) {
            for(currentTile = startTile; currentTile != null; currentTile = currentTile.getAdjacent(second))
                if(currentTile.getValueOfProperty("isMatched") == "true")
                    cont++;
            if(cont == 5)
                return true;
        }
        return false;
    }

    @Override
    public boolean checkMatch(ConstantTile<Cardinal> initTile) {
        boolean result = false;
        if(initTile != null) {

            result = linearCheck(initTile, Cardinal.DOWN, Cardinal.RIGHT) || linearCheck(initTile, Cardinal.RIGHT, Cardinal.DOWN);

            if(nextMatch != null)
                return nextMatch.checkMatch(initTile);

        }
        return result;
    }
}
