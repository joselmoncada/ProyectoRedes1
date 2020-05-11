package com.board;

import com.tile.ConstantTile;

import java.util.TreeMap;

public abstract class Board {
    protected TreeMap<String, ConstantTile> indexByKey;

    public abstract ConstantTile getTile(String key, String typeOfKey);

    public abstract void updateTileProperty(String key, String typeOfKey, String property, String value);
}
