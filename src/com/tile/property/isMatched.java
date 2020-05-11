package com.tile.property;

public class isMatched extends Property {
    boolean isMatched;

    public isMatched(boolean isMatched, Property nextProperty) {
        name = "ismatched";
        this.isMatched = isMatched;
        this.nextProperty = nextProperty;
    }

    @Override
    public void setPropertyValue(String propertyName, String newValue) {
        if(propertyName.toLowerCase().equals(name))
            if(newValue.toLowerCase().equals("true") || newValue.toLowerCase().equals("false"))
                isMatched = Boolean.valueOf(newValue);
        else if(nextProperty != null)
            nextProperty.setPropertyValue(propertyName, newValue);
    }

    @Override
    public String getPropertyValue(String propertyName) {
        if(propertyName.toLowerCase().equals(name))
            return String.valueOf(isMatched);
        else if(nextProperty != null)
            return nextProperty.getPropertyValue(propertyName);
        return null;
    }
}
