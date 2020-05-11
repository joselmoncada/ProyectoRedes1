package com.matcher;

import com.tile.ConstantTile;
import com.token.Cardinal;

public class BingoMatcher implements Matcher<Cardinal> {
    protected Match<Cardinal> matchers;

    public BingoMatcher(Match<Cardinal> matchers) {
        this.matchers = matchers;
    }

    public void setMatchers(Match<Cardinal> matchers) {
        this.matchers = matchers;
    }

    public boolean checkMatch(ConstantTile<Cardinal> initTile) {
        if(matchers != null && initTile != null)
            return matchers.checkMatch(initTile);
        return true;
    }
}
