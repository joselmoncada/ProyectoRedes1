package com.tile;

import com.tile.mapper.TileMapper;
import com.tile.property.Property;

public abstract class Tile<D> implements ConstantTile<D> {
    TileMapper adjacencyMapper;
    Property propertys;

    @Override
    public ConstantTile<D> getAdjacent(D direction) {
       return adjacencyMapper.getAdjacent(direction);
    }

    public void setAdjacent(D direction, Tile<D> tile) {
        adjacencyMapper.setAdjacent(direction, tile);
    }

    @Override
    public String getValueOfProperty(String propertyName) {
        if(propertys != null)
            return propertys.getPropertyValue(propertyName);
        return null;
    }

    public void setValueOfProperty(String propertyName, String newValue) {
        if(propertys != null)
            propertys.setPropertyValue(propertyName, newValue);

    }
}
