package com.tile;

import com.tile.mapper.TileMapper;
import com.tile.property.Property;
import com.token.Cardinal;

public class BingoTile extends Tile<Cardinal> {
    public BingoTile(TileMapper<Cardinal, BingoTile> adjacencyMapper, Property propertys) {
        this.adjacencyMapper = adjacencyMapper;
        this.propertys = propertys;
    }
}
