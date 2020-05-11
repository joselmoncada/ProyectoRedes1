package com.tile.property;

public abstract class Property {
    String name;
    Property nextProperty;

    public abstract void setPropertyValue(String propertyName, String newValue);
    public abstract String getPropertyValue(String propertyName);
    public void setNextProperty(Property nextProperty) {
        this.nextProperty = nextProperty;
    }

}
