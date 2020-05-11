package com.tile.property;

public class Value extends Property {
    Integer value;

    public Value(Integer value, Property nextProperty) {
        name = "value";
        this.value = value;
        setNextProperty(nextProperty);
    }

    @Override
    public void setPropertyValue(String propertyName, String newValue) {
        if(!propertyName.toLowerCase().equals(name))
            nextProperty.setPropertyValue(propertyName, newValue);
    }

    @Override
    public String getPropertyValue(String propertyName) {
         if(propertyName.toLowerCase().equals(name))
             return value.toString();
         else if (nextProperty != null)
             return nextProperty.getPropertyValue(propertyName);
         return null;
    }
}
