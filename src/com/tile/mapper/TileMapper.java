package com.tile.mapper;

import com.tile.Tile;

import java.util.TreeMap;

public class TileMapper<D ,T extends Tile<D>> {
    protected TreeMap<D, T> adjacencyMapper;

    public TileMapper(TreeMap<D, T> adjacentsMap) {
        this.adjacencyMapper = adjacentsMap;
    }

    public void setAdjacent(D direction, T tile) {
        if(tile == null)
            adjacencyMapper.remove(direction);
        else
            adjacencyMapper.put(direction, tile);
    }

    public  T getAdjacent(D direction) {
        return adjacencyMapper.get(direction);
    }

}
