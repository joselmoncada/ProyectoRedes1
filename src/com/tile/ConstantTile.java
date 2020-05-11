package com.tile;

public interface ConstantTile<D> {
    public ConstantTile<D> getAdjacent(D direction);

    public String getValueOfProperty(String propertyName);
}
