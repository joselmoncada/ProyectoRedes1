package com.matcher;

import com.tile.ConstantTile;

public abstract class Match<D> {
    protected Match<D> nextMatch;

    public abstract boolean checkMatch(ConstantTile<D> initTile);
}
