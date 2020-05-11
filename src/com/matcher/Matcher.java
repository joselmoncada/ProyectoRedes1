package com.matcher;

import com.tile.ConstantTile;

public interface Matcher<D> {
    public boolean checkMatch(ConstantTile<D> initTile);
}
