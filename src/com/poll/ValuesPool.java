package com.poll;

import java.util.ArrayList;
import java.util.Random;

public abstract class ValuesPool<E> {
    protected ArrayList<E> values;
    protected ArrayList<E> pulledValues;
    protected Random randomGenerator;

    public E getNewValue() {
        E value = null;
        if(!values.isEmpty()) {
            int index = randomGenerator.nextInt(values.size());
            value = values.get(index);
            pulledValues.add(value);
            values.remove(index);
            System.out.println("The value is: " + value);
        }
        return value;
    }

    public boolean verifyPulledValues(ArrayList<E> values) {
        for(E val: values)
            if(!pulledValues.contains(val))
                return false;
        return true;
    }

    public ArrayList<E> getUnpulledValues() {
        return (ArrayList<E>) values.clone();
    }

    public ArrayList<E> getPulledValues () {
        return (ArrayList<E>) pulledValues.clone();
    }
}
