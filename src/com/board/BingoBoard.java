package com.board;

import com.tile.BingoTile;
import com.tile.ConstantTile;
import com.token.Cardinal;

import java.util.TreeMap;

public class BingoBoard extends Board {
    protected TreeMap<String, BingoTile> indexByValue;
    protected TreeMap<String, BingoTile> indexByReference;

    public BingoBoard(TreeMap<String, BingoTile> indexByValue,TreeMap<String, BingoTile> indexByReference) {
        this.indexByValue = indexByValue;
        this.indexByReference = indexByReference;
    }

    protected ConstantTile<Cardinal> getTileByValue(String key) {
        if(indexByValue != null)
            return indexByValue.get(key);
        return null;
    }

    protected ConstantTile<Cardinal> getTileByReference(String key) {
        if(indexByReference != null)
            return indexByReference.get(key);
        return null;
    }

    @Override
    public ConstantTile<Cardinal> getTile(String key, String typeOfKey) {
        switch (typeOfKey.toLowerCase()) {
            case "value":
                return getTileByValue(key);
            case "reference":
                return getTileByReference(key);
        }
        return  null;
    }

    @Override
    public void updateTileProperty(String key, String typeOfKey, String property, String value) {
       if(key != null){
           BingoTile tile = null;
           switch (typeOfKey.toLowerCase()) {
               case "value":
                   tile = indexByValue.get(key);
                   break;
               case "reference":
                   tile = indexByReference.get(key);
                   break;
           }
           if(tile != null)
               tile.setValueOfProperty(property, value);
       }
    }

}
