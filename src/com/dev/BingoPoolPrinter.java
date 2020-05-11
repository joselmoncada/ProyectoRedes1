package com.dev;

import com.poll.ValuesPool;

import java.util.ArrayList;

public class BingoPoolPrinter {
    public static void print(ValuesPool<String> valuesPool) {
        ArrayList<String> unPulledValues = valuesPool.getUnpulledValues();
        ArrayList<String> pulledValues = valuesPool.getPulledValues();

        System.out.print("\nUnPulled Values: [");
        for(String val: unPulledValues)
            System.out.print(val + " ");
        System.out.println("]");

        System.out.print("Pulled Values: [");
        for(String val: pulledValues)
            System.out.print(val + " ");
        System.out.println("]");
    }
}
