package com.poll;

import java.util.ArrayList;
import java.util.Random;

public class BingoPool extends ValuesPool<String> {

    public BingoPool(int maxNumber) {
        values = new ArrayList<>();
        pulledValues = new ArrayList<>();
        randomGenerator = new Random();

        values.ensureCapacity(maxNumber);
        pulledValues.ensureCapacity(maxNumber);

        for(int i = 0; i < maxNumber; i++)
            values.add(Integer.toString(i + 1));
    }
}
